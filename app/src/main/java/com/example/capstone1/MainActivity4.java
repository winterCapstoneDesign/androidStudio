package com.example.capstone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
    private Button createBtn;
    private EditText input_QR_user;
    private Button qr_go_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        input_QR_user = findViewById(R.id.input_QR_user);
        qr_go_main = findViewById(R.id.qr_go_main);
        qr_go_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                startActivity(intent); //실제 화면 이동
            }
        });

        createBtn = findViewById(R.id.create_QR);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity4.this, CreateQR.class);
                intent.putExtra("input_QR_user",input_QR_user.getText().toString());
                startActivity(intent); //실제 화면 이동
            }
        });
    }
}