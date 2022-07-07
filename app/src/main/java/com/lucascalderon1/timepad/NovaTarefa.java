package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NovaTarefa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_tarefa);

        findViewById(R.id.ib_voltarHome).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });

    }
}