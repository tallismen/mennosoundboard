package nl.designlama.mennosoundboard.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import nl.designlama.mennosoundboard.ActionBarSupport;
import nl.designlama.mennosoundboard.R;
import nl.designlama.mennosoundboard.utils.ToolbarUtil;

public class MainActivity extends AppCompatActivity implements ActionBarSupport {

    private static String TAG = "MainActivity";
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToolbarUtil.setupActionBar(this, this, getString(R.string.app_name), false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences: {
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onButton1Pressed(View v) {
        playSound(R.raw.dikkebillen);
    }

    public void onButton2Pressed(View v) {
        playSound(R.raw.hallo);
    }

    public void onButton3Pressed(View v) {
        playSound(R.raw.gs1200r);
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

    public void onButton7Pressed(View v) {
        playSound(R.raw.oohyeah);
    }

    public void onButton8Pressed(View v) {
        playSound(R.raw.racketlanceren);
    }

    private void stopSound() {
        if (mp != null && mp.isPlaying()) {
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
