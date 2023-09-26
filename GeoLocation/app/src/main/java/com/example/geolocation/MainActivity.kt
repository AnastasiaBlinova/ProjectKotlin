package com.example.geolocation

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.geolocation.databinding.ActivityMainBinding
import com.example.geolocation.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.LocationSource
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity() {

    private var locationListener: LocationSource.OnLocationChangedListener? = null
    private var map: GoogleMap? = null
    private lateinit var fusedClient: FusedLocationProviderClient
    private lateinit var binding: ActivityMapsBinding



    private val launcher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ){ map ->
        if (map.values.isNotEmpty() && map.values.all {it}){
            startLocation()
        }
    }

    private val locationCallback = object : LocationCallback(){
        override fun onLocationResult(result: LocationResult) {
            result.lastLocation?.let{ location ->
                locationListener?.onLocationChanged(location)
                map?.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(location.latitude, location.longitude),
                        18f
                    )
                )
            }
//            binding.message.text = result.lastLocation.toString()
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocation() {
        map?.isMyLocationEnabled = true
        val request = LocationRequest.create()
            .setInterval(1_000)
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)

        fusedClient.requestLocationUpdates(
            request,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            map = googleMap
            checkPermissions()
            with(googleMap.uiSettings){
                isZoomControlsEnabled = true
                isMyLocationButtonEnabled = true
            }
            googleMap.setLocationSource(object : LocationSource{
                override fun activate(p0: LocationSource.OnLocationChangedListener) {
                    locationListener = p0
                }
                override fun deactivate() {
                    locationListener = null
                }
            })
        }

        fusedClient = LocationServices.getFusedLocationProviderClient((this))
    }

    override fun onStart() {
        super.onStart()
        checkPermissions()
    }

    override fun onStop() {
        super.onStop()
        fusedClient.removeLocationUpdates(locationCallback)
    }

    private fun checkPermissions(){
        if (REQUIRED_PERMISSIONS.all {permission ->
                ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
            }) {
            startLocation()
        } else {
            launcher.launch(REQUIRED_PERMISSIONS)
        }
    }

    companion object {
        private val REQUIRED_PERMISSIONS: Array<String> = arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}