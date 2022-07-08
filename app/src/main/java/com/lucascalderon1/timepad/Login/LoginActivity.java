package com.lucascalderon1.timepad.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.lucascalderon1.timepad.MainActivity;
import com.lucascalderon1.timepad.R;
import com.lucascalderon1.timepad.helper.FirebaseHelper;


public class LoginActivity extends AppCompatActivity {



    private TextInputEditText  etEmail, loginSenha;
    private ProgressBar progressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        etEmail = findViewById(R.id.etEmail);
        loginSenha = findViewById(R.id.loginSenha);
        progressBar = findViewById(R.id.progressBar);

        findViewById(R.id.txt_criar).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, RegistroActivity.class));
        });

        findViewById(R.id.txt_recuperar).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, RecuperaActivity.class));
        });

        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);




    }

    public void validaDados(View view) {
        String email = etEmail.getText().toString();
        String senha = loginSenha.getText().toString();

        if (!email.isEmpty()){
            if (!senha.isEmpty()){

                progressBar.setVisibility(View.VISIBLE);

                logar(email, senha);


            } else  {
                loginSenha.requestFocus();
                loginSenha.setError("Informe sua senha");
            }

        } else  {
            etEmail.requestFocus();
            etEmail.setError("Informe seu e-mail");
        }

    }

    private void logar(String email, String senha) {
        FirebaseHelper.getAuth().signInWithEmailAndPassword(
                email, senha
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                finish();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(this, "Senha ou e-mail incorretos", Toast.LENGTH_SHORT).show();
            }
        });

    }
}