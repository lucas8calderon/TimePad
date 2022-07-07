package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.lucascalderon1.timepad.Login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ActivityLogin();

            }
        }, 3000); // 3 segundos
    }

    private void ActivityLogin () {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);


    }

}