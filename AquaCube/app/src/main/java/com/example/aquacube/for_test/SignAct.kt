package com.example.aquacube.for_test
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.result.ActivityResultLauncher
//import androidx.activity.result.contract.ActivityResultContracts
//import com.example.aquacube.databinding.ActivitySignBinding
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.api.ApiException
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.GoogleAuthProvider
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//
//class SignAct : AppCompatActivity() {
//    lateinit var launcher: ActivityResultLauncher<Intent>
//    lateinit var auth: FirebaseAuth
//    lateinit var binding: ActivitySignBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySignBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        auth = Firebase.auth
//        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
//            try {
//                val account = task.getResult(ApiException::class.java)
//                if (account != null){
//                    firebaseAuthWithGoggle(account.idToken!!)
//                }
//            } catch (e:ApiException){
//                Log.d("My log", "Api Exception")
//            }
//        }
//        binding.buttonSign.setOnClickListener {
//            signInWithGoogle()
//        }
//        checkAuthState()
//    }
//    private fun getClient(): GoogleSignInClient {
//        val gso = GoogleSignInOptions
//            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//        return GoogleSignIn.getClient(this, gso)
//    }
//
//    private fun signInWithGoogle(){
//        val signInClient = getClient()
//        launcher.launch(signInClient.signInIntent)
//    }
//
//    private fun firebaseAuthWithGoggle(idToken: String){
//        val credential = GoogleAuthProvider.getCredential(idToken, null)
//        auth.signInWithCredential(credential).addOnCompleteListener {
//            if(it.isSuccessful){
//                Log.d("My Log","Google singIn done")
//                checkAuthState()
//            } else{
//                Log.d("My Log","Google singIn error")
//            }
//        }
//    }
//
//    private fun checkAuthState(){
//        if(auth.currentUser != null){
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//    }
//
//
//}