package com.lucascalderon1.timepad.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.lucascalderon1.timepad.MainActivity;
import com.lucascalderon1.timepad.R;
import com.lucascalderon1.timepad.helper.FirebaseHelper;
import com.lucascalderon1.timepad.model.Usuario;

public class RegistroActivity extends AppCompatActivity {


    private Button btn_avancar;
    private FirebaseAuth mAuth;
    private Usuario usuario;

    TextInputEditText etSenha1, etSenha2, etEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        etEmail = findViewById(R.id.etEmail);

        btn_avancar = findViewById(R.id.btn_avancar);
        btn_avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String senhaConfirmar1 = etSenha1.getText().toString();
                String senhaConfirmar2 = etSenha2.getText().toString();


                if (senhaConfirmar1.equals(senhaConfirmar2)) {

                    Usuario usuario = new Usuario();
                    usuario.setEmail(etEmail.getText().toString());
                    usuario.setSenha(senhaConfirmar1);

                    cadastrarUsuario(usuario);


                    Toast.makeText(getApplicationContext(), "Registro efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                    finish();
                    startActivity(intent);
                } else if (etSenha1.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Mínimo de 6 digitos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Senhas diferentes", Toast.LENGTH_SHORT).show();
                }

            }

        });



        mAuth = FirebaseAuth.getInstance();

        etSenha1 = findViewById(R.id.etSenha1);
        etSenha2 = findViewById(R.id.etSenha2);

        mAuth = FirebaseAuth.getInstance();

        etSenha1.getText().toString();
        etSenha2.getText().toString();

    }







    private void cadastrarUsuario(Usuario usuario) {
        FirebaseHelper.getAuth().createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                String id = task.getResult().getUser().getUid();
                usuario.setId(id);
                salvarDadosUsuario(usuario);



            } else {

                Toast.makeText(this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();


            }

        });
    }

    private void  salvarDadosUsuario(Usuario usuario)  {

        DatabaseReference usuarioRef = FirebaseHelper.getDatabaseReference()
                .child("usuario")
                .child(usuario.getId());
        usuarioRef.setValue(usuario).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                finish();
                startActivity(new Intent(this, MainActivity.class));
            } else {

                Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }

}