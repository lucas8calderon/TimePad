package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lucascalderon1.timepad.Login.LoginActivity;
import com.lucascalderon1.timepad.configuracao.ConfiguracaoActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView btnAtividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.config).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, ConfiguracaoActivity.class));
        });

        findViewById(R.id.imageView5).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, Atividades.class));
        });

        findViewById(R.id.imageView3).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, NovaTarefa.class));
        });
    }
}