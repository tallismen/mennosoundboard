package nl.designlama.mennosoundboard;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Pressed(View v) {
        playSound(R.raw.test);
    }

    public void onButton2Pressed(View v) {
        playSound(R.raw.hallo);
    }

    public void onButton3Pressed(View v) {
        playSound(R.raw.hallo);
    }

    public void onButton4Pressed(View v) {
        playSound(R.raw.jaleuk);
    }

    public void onButton5Pressed(View v) {
        playSound(R.raw.ondersteboven);
    }

    public void onButton6Pressed(View v) {
        playSound(R.raw.racketlanceren);
    }

    private void stopSound() {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }

    private void playSound(int wav) {
        stopSound();
        try {
            mp = MediaPlayer.create(this, wav);
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
