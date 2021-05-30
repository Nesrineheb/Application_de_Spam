package com.example.spamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.telephony.SmsManager
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button= findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener{
            val contacts=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null,null)
            if (contacts != null) {
                while (contacts.moveToNext()){
                    var obj=SmsManager.getDefault()
                    obj.sendTextMessage(contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)),null,"test",null,null)
                    println("${contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))}")
                }
            }
        }

    }
}