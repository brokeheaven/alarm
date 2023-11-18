package com.example.passwordprogramm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private View root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = findViewById(R.id.root);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editTextText);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count  , int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count  , int after) {
                calculpass(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable s){

            }
        });

    }
    private void calculpass(String str){
        PasswordStrength passwordStrength = PasswordStrength.calculate(str);
        textView.setText(passwordStrength.msg);
        root.setBackgroundColor(passwordStrength.color);
    }
}