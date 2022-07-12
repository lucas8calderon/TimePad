package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.lucascalderon1.timepad.configuracao.ConfiguracaoActivity;

public class MainActivity extends AppCompatActivity {

    int counter;

    MediaPlayer mediaPlayer;

    private ImageView btnAtividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = null;


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

        findViewById(R.id.cronometro).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, TimerActivity.class));
        });

        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }


    public void music (View view) {
        switch (view.getId()){
            case R.id.iv_play:
                if(mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.badmantingsriddim);
                    Toast.makeText(getApplicationContext(), "Musica iniciada!", Toast.LENGTH_SHORT).show();
                }

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopMusic();
                    }
                });

                mediaPlayer.start();
                break;

            case R.id.iv_pause:
                if (mediaPlayer != null)
                    Toast.makeText(getApplicationContext(), "Musica pausada!", Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                break;

            case R.id.iv_stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    Toast.makeText(getApplicationContext(), "Musica parada!", Toast.LENGTH_SHORT).show();
                    stopMusic();
                }
                break;


        }
    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer = null;
    }



}