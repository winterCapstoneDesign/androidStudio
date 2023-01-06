package com.example.capstone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CreateQR extends AppCompatActivity {
    private ImageView iv;
    private String text;
    private Button main_btn;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);

        Intent intent = getIntent();

        iv = (ImageView)findViewById(R.id.qrcode);
        text = intent.getStringExtra("input_QR_user");
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            iv.setImageBitmap(bitmap);

            //파이어베이스로 QR 정보 전송
            HashMap result = new HashMap<>();
            result.put("user" + Integer.toString(count.count),text);
            count.count = count.count + 1;
            databaseReference.child("QR_code").setValue(result);
        }catch (Exception e){}

        main_btn = findViewById(R.id.main_button);
        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateQR.this, MainActivity.class);
                startActivity(intent); //실제 화면 이동
            }
        });
    }
}