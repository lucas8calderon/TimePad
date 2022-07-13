package com.lucascalderon1.timepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class TimerActivity extends AppCompatActivity {

    private CircularSeekBar progress_circular;
    private ImageView img_play, img_stop, img_pause, img_reset;
    private ImageButton ib_voltarTarefa;
    private EditText editText;
    private TextView textView10;


   // private int max = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        ib_voltarTarefa = findViewById(R.id.ib_voltarTarefa);
        img_stop = findViewById(R.id.img_stop);
        img_pause = findViewById(R.id.img_pause);
        img_reset = findViewById(R.id.img_reset);
        progress_circular = findViewById(R.id.progress_circular);

        img_play = findViewById(R.id.img_play);
        editText = findViewById(R.id.editText);
        textView10 = findViewById(R.id.textView10);

       // progress_circular.setMax(max);
        progress_circular.setProgress(0);

       // startInfiniteCounterLoop();


        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        ib_voltarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.equalsIgnoreCase("")) {
                int seconds = Integer.valueOf(text);
                CountDownTimer countDownTimer = new CountDownTimer(seconds  * 1000, 1000) {
                    @Override
                    public void onTick(long millis) {
                        progress_circular.setMax(seconds);
                        progress_circular.setProgress(millis / 1000);
                        editText.setText("tempo: " + (int) (millis/1000));

                    }

                    @Override
                    public void onFinish() {
                        textView10.setText("Acabou o tempo");
                        editText.setText("00:00:00");

                    }

                }.start();
                }
            }
        });

    }
}












//        private void startInfiniteCounterLoop () {
//            new CountDownTimer(max, 1) {
//
//
//                @Override
//                public void onTick(long l) {
//                    progress_circular.setProgress(max - l);
//
//
//                }
//
//                @Override
//                public void onFinish() {
//                    Toast.makeText(getApplicationContext(), "Acabou o tempo", Toast.LENGTH_SHORT).show();
//
//                }
//            }.start();
//        }
//
//
//    }
