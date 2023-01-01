package com.example.capstone1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button pass_btn0 = (Button) findViewById(R.id.pass_btn0);
        Button pass_btn1 = (Button) findViewById(R.id.pass_btn1);
        Button pass_btn2 = (Button) findViewById(R.id.pass_btn2);
        Button pass_btn3 = (Button) findViewById(R.id.pass_btn3);
        Button pass_btn4 = (Button) findViewById(R.id.pass_btn4);
        Button pass_btn5 = (Button) findViewById(R.id.pass_btn5);
        Button pass_btn6 = (Button) findViewById(R.id.pass_btn6);
        Button pass_btn7 = (Button) findViewById(R.id.pass_btn7);
        Button pass_btn8 = (Button) findViewById(R.id.pass_btn8);
        Button pass_btn9 = (Button) findViewById(R.id.pass_btn9);
        Button pass_clear = (Button) findViewById(R.id.pass_clear);
        Button pass_enter = (Button) findViewById(R.id.pass_enter);

        ArrayList buttonArray = new ArrayList<Button>();
        buttonArray.add(pass_btn0);
        buttonArray.add(pass_btn1);
        buttonArray.add(pass_btn2);
        buttonArray.add(pass_btn3);
        buttonArray.add(pass_btn4);
        buttonArray.add(pass_btn5);
        buttonArray.add(pass_btn6);
        buttonArray.add(pass_btn7);
        buttonArray.add(pass_btn8);
        buttonArray.add(pass_btn9);
        buttonArray.add(pass_clear);
        buttonArray.add(pass_enter);

        for(Object button : buttonArray) {
            Button btn = (Button) button;
            btn.setOnClickListener(btnListener);
        }
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int currentValue = -1;

        }
    };
}