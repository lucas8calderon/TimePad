package com.lucascalderon1.timepad;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.lucascalderon1.timepad.Login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initialWork();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_screen);
        img.setAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ActivityLogin();

            }
        }, 3000); // 3 segundos
    }

    private void initialWork() {
        img = findViewById(R.id.logo_img);
    }

    private void ActivityLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);


    }
}