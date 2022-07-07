package com.lucascalderon1.timepad.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lucascalderon1.timepad.MainActivity;
import com.lucascalderon1.timepad.R;




public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.txt_criar).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, RegistroActivity.class));
        });


        findViewById(R.id.btn_avancar).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });

        findViewById(R.id.txt_recuperar).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, RecuperaActivity.class));
        });


    }
}