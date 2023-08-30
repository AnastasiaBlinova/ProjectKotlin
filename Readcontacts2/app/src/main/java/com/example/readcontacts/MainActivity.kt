package com.example.readcontacts

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.readcontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val  launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if (isGranted){
            getContacts()
        } else {
            Toast.makeText(this,"Permission is not Granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkPermissions()
    }

    private fun checkPermissions() {
        return if (
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ){
            getContacts()
        } else {
            launcher.launch(android.Manifest.permission.READ_CONTACTS)
        }
    }

    private fun getContacts() {
        val contentUri = ContactsContract.Contacts.CONTENT_URI
        val contactsProjection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.HAS_PHONE_NUMBER
        )
        val phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val phoneProjection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )
        val phoneSelection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?"

        val stringBuilder = StringBuilder()
        contentResolver.query(
            contentUri,
            contactsProjection,
            null,
            null,
            null

        )?.use { cursor ->
            val idIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID)
            val nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            val hasPhoneIndex = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)

            while (cursor.moveToNext()){
                stringBuilder.append(cursor.getString(nameIndex))  //добавляем имя контакта
                    .append(": ")
                val hasPhone = cursor.getInt(hasPhoneIndex) > 0    // проверка есть ли у контакта телефон
                if (hasPhone){                                     // процесс получения конкретного
                    val contactId = cursor.getString(idIndex)
                    contentResolver.query(
                        phoneUri,
                        phoneProjection,
                        phoneSelection,
                        arrayOf(contactId),
                        null
                    )?.use { phoneCursor ->
                        val numberIndex = phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                        while (phoneCursor.moveToNext()){
                            stringBuilder.append(phoneCursor.getString(numberIndex))
                                .append(", ")
                        }
                    }
                } else {
                    stringBuilder.append("no phone")
                }
                stringBuilder.append("\n")
            }
        }
        binding.textView.text = stringBuilder.toString()
    }
}