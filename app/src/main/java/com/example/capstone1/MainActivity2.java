package com.example.capstone1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private Button pass_btn0;
    private Button pass_btn1;
    private Button pass_btn2;
    private Button pass_btn3;
    private Button pass_btn4;
    private Button pass_btn5;
    private Button pass_btn6;
    private Button pass_btn7;
    private Button pass_btn8;
    private Button pass_btn9;
    private Button pass_clear;
    private Button pass_enter;

    private EditText etPasscode1;
    private EditText etPasscode2;
    private EditText etPasscode3;
    private EditText etPasscode4;

    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pass_btn0 = findViewById(R.id.pass_btn0);
        pass_btn1 = findViewById(R.id.pass_btn1);
        pass_btn2 = findViewById(R.id.pass_btn2);
        pass_btn3 = findViewById(R.id.pass_btn3);
        pass_btn4 = findViewById(R.id.pass_btn4);
        pass_btn5 = findViewById(R.id.pass_btn5);
        pass_btn6 = findViewById(R.id.pass_btn6);
        pass_btn7 = findViewById(R.id.pass_btn7);
        pass_btn8 = findViewById(R.id.pass_btn8);
        pass_btn9 = findViewById(R.id.pass_btn9);
        pass_clear = findViewById(R.id.pass_clear);
        pass_enter = findViewById(R.id.pass_enter);

        etPasscode1 = findViewById(R.id.etPasscode1);
        etPasscode2 = findViewById(R.id.etPasscode2);
        etPasscode3 = findViewById(R.id.etPasscode3);
        etPasscode4 = findViewById(R.id.etPasscode4);

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
            switch (view.getId()) {
                case R.id.pass_btn0:
                    currentValue = 0;
                    break;
                case R.id.pass_btn1:
                    currentValue = 1;
                    break;
                case R.id.pass_btn2:
                    currentValue = 2;
                    break;
                case R.id.pass_btn3:
                    currentValue = 3;
                    break;
                case R.id.pass_btn4:
                    currentValue = 4;
                    break;
                case R.id.pass_btn5:
                    currentValue = 5;
                    break;
                case R.id.pass_btn6:
                    currentValue = 6;
                    break;
                case R.id.pass_btn7:
                    currentValue = 7;
                    break;
                case R.id.pass_btn8:
                    currentValue = 8;
                    break;
                case R.id.pass_btn9:
                    currentValue = 9;
                    break;
                case R.id.pass_clear:
                    //onClear();
                    break;
                case R.id.pass_enter:
                    onEnter();
                    break;
            }

            String strCurrentValue = Integer.toString(currentValue);
            if(currentValue != -1) {
                if(etPasscode1.isFocusable()) {
                    etPasscode1.setText(strCurrentValue);
                    etPasscode1.setFocusable(false);
                    etPasscode2.requestFocus();
                }
                else if(etPasscode2.isFocusable()) {
                    etPasscode2.setText(strCurrentValue);
                    etPasscode2.setFocusable(false);
                    etPasscode3.requestFocus();
                }
                else if(etPasscode3.isFocusable()) {
                    etPasscode3.setText(strCurrentValue);
                    etPasscode3.setFocusable(false);
                    etPasscode4.requestFocus();
                }
                else {
                    etPasscode4.setText(strCurrentValue);
                }
            }

            if(etPasscode1.length() != 0 && etPasscode2.length() != 0 && etPasscode3.length() != 0 && etPasscode4.length() != 0) {
                Toast.makeText(getApplicationContext(), "비밀번호 입력 완료", Toast.LENGTH_SHORT).show();
                password = etPasscode1.getText().toString() + etPasscode2.getText().toString() + etPasscode3.getText().toString() + etPasscode4.getText().toString();
            }
        }

//        private void onClear() {
//            etPasscode1.setText("");
//            etPasscode2.setText("");
//            etPasscode3.setText("");
//            etPasscode4.setText("");
//
//            if(etPasscode2.isFocusable()) {
//                etPasscode2.clearFocus();
//            }
//            else if(etPasscode3.isFocusable()) {
//                etPasscode3.clearFocus();
//            }
//            else if(etPasscode4.isFocusable()) {
//                etPasscode4.clearFocus();
//            }
//            etPasscode1.requestFocus();
//        }

        private void onEnter() {
            //esp32로 비밀번호 전송
        }
    };
}