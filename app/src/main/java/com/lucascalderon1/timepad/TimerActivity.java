package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class TimerActivity extends AppCompatActivity {

    private CircularSeekBar progress_circular;
    private ImageView img_play, img_stop, img_pause, img_reset;
    private ImageButton ib_voltarTarefa;
    private EditText editText;
    private int max = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        ib_voltarTarefa = findViewById(R.id.ib_voltarTarefa);
        img_play = findViewById(R.id.img_play);
        img_stop = findViewById(R.id.img_stop);
        img_pause = findViewById(R.id.img_pause);
        img_reset = findViewById(R.id.img_reset);
        progress_circular = findViewById(R.id.progress_circular);
        editText = findViewById(R.id.editText);

        progress_circular.setMax(max);
        progress_circular.setProgress(0);

        startInfiniteCounterLoop();


        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


        private void startInfiniteCounterLoop () {
            new CountDownTimer(max, 2) {


                @Override
                public void onTick(long l) {
                    progress_circular.setProgress(max - l);


                }

                @Override
                public void onFinish() {
                    startInfiniteCounterLoop();

                }
            }.start();
        }


    }
