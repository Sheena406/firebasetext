package com.example.wennlab.database;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://fir-ac110.firebaseio.com/");
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());

            }

            @Override
            public void onCancelled(FirebaseError error) {

            }
        });
    }
}
