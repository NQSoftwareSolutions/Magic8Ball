package com.nqsoftwaresolutions.magic8ball;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final int NU_OF_STREAMS = 5;
    private final int SOURCE_QUALITY = 1;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int PRIORITY = 1;
    private final int NO_LOOP = 0;
    private final float SOUND_BIT_RATE = 1.0f;
    private SoundPool mSoundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView eightBall = findViewById(R.id.id_img_eightBall);
        final Button askButton = findViewById(R.id.id_btn_ask);
        //Todo Play sound when clicked on button
        mSoundPool = new SoundPool(NU_OF_STREAMS, AudioManager.STREAM_MUSIC,SOURCE_QUALITY);
        // ids of sounds
        int aPlayId = mSoundPool.load(this,R.raw.note6_a, PRIORITY);
        int bPlayId = mSoundPool.load(this,R.raw.note7_b, PRIORITY);
        int cPlayId = mSoundPool.load(this,R.raw.note1_c, PRIORITY);
        int dPlayId = mSoundPool.load(this,R.raw.note3_e, PRIORITY);
        int ePlayId = mSoundPool.load(this,R.raw.note4_f, PRIORITY);

        final int[] predictionArray = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };
        askButton.setOnClickListener(V ->{
            int randomNum = new Random().nextInt(4);
            switch (randomNum){
                case 0:
                    mSoundPool.play(aPlayId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,SOUND_BIT_RATE);
                    break;
                case 1:
                    mSoundPool.play(bPlayId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,SOUND_BIT_RATE);
                    break;
                case 2:
                    mSoundPool.play(cPlayId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,SOUND_BIT_RATE);
                    break;
                case 3:
                    mSoundPool.play(dPlayId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,SOUND_BIT_RATE);
                    break;
                case 4:
                    mSoundPool.play(ePlayId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,SOUND_BIT_RATE);
                    break;
            }
            eightBall.setImageResource(predictionArray[randomNum]);

        });

    }
}