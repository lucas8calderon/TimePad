package com.lucascalderon1.timepad.configuracao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.lucascalderon1.timepad.Login.LoginActivity;
import com.lucascalderon1.timepad.MainActivity;
import com.lucascalderon1.timepad.R;

public class ConfiguracaoActivity extends AppCompatActivity {

    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        findViewById(R.id.ib_voltarConfig).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });

        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(), "Confifurações ativas", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Confifurações desativadas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_salvar).setOnClickListener(v -> {
            Toast.makeText(this, "Confifurações salvas com sucesso!", Toast.LENGTH_SHORT).show();
        });

        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);




    }
}