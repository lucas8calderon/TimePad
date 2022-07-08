package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.lucascalderon1.timepad.configuracao.ConfiguracaoActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;

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

        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    public void play(View view) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.badmantingsriddim);
            Toast.makeText(this, "Som iniciado", Toast.LENGTH_SHORT).show();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {

                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View view) {
        if (player != null) {
            Toast.makeText(this, "Som pausado", Toast.LENGTH_SHORT).show();
            player.pause();
        }
    }


    public void stop(View view) {
        stopPlayer();

    }

    private void stopPlayer() {
        if (player != null) {
            player.pause();
            Toast.makeText(this, "Som parado", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        player.pause();
    }
}