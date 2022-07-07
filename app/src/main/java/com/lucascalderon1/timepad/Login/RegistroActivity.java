package com.lucascalderon1.timepad.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lucascalderon1.timepad.R;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        findViewById(R.id.ib_voltar).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}