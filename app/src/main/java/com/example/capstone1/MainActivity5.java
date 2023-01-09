package com.example.capstone1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listView = findViewById(R.id.lv_LogList);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_main5, arrayList);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("QR_lock").child("date");
        getValue();
    }

    private void getValue() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String sValue = dataSnapshot.child(Integer.toString(1)).getValue(String.class);
                    arrayList.add(sValue);
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity5.this, "error : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}