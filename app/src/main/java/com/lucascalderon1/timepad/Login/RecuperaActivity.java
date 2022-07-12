package com.lucascalderon1.timepad.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.lucascalderon1.timepad.R;
import com.lucascalderon1.timepad.helper.FirebaseHelper;

public class RecuperaActivity extends AppCompatActivity {


    ImageButton ib_voltarRecuperar;
    TextInputEditText edEmail;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera);

        edEmail = findViewById(R.id.edEmail);
        progressBar = findViewById(R.id.progressBar);
        ib_voltarRecuperar = findViewById(R.id.ib_voltarRecuperar);


       ib_voltarRecuperar.setOnClickListener(v -> {
           Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
           finish();
           startActivity(intent);
       });
    }

    public void validaDados(View view) {

        String email = edEmail.getText().toString();

        if (!email.isEmpty()) {

            progressBar.setVisibility(View.VISIBLE);


            recuperarConta(email);


        } else {
            edEmail.requestFocus();
            edEmail.setError("Informe seu e-mail");
        }


    }

    private void recuperarConta(String email) {



        FirebaseHelper.getAuth().sendPasswordResetEmail(
                email
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(this, "Acabamos de te enviar um link via e-mail.", Toast.LENGTH_SHORT).show();
            } else {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }

        });


    }

}

