package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lucascalderon1.timepad.Login.LoginActivity;
import com.lucascalderon1.timepad.configuracao.ConfiguracaoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.config).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, ConfiguracaoActivity.class));
        });
    }
}