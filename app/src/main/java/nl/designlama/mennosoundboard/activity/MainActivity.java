package nl.designlama.mennosoundboard.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import nl.designlama.mennosoundboard.utils.AlertDialogUtil;
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
    protected void onPause(){
        Log.i(TAG, "onPause()");
        super.onPause();
        stopSound();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG, "onCreateOptionsMenu()");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");
        switch (item.getItemId()) {
            case R.id.preferences: {
                Log.i(TAG, "Open preferences");
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        Log.i(TAG,"onBackPressed()");
        final AlertDialog.Builder builder = AlertDialogUtil.createAlertDialog(this,"Afsluiten?","Weet je zeker dat je de app wil sluiten?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Nee", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
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

    public void onSluitenPressed(View v){
        onBackPressed();
    }

    private void stopSound() {
        Log.i(TAG, "stopSound()");
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }

    private void playSound(int wav) {
        Log.i(TAG, "playSound() Wav:"+wav);
        stopSound();
        try {
            mp = MediaPlayer.create(this, wav);
            mp.start();
        } catch (Exception e) {
            Log.e(TAG,"Fout bij afspelen! "+ e.getMessage());
        }
    }
}
