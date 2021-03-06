package nl.designlama.mennosoundboard.activity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;

import nl.designlama.mennosoundboard.ActionBarSupport;
import nl.designlama.mennosoundboard.R;
import nl.designlama.mennosoundboard.utils.ToolbarUtil;

public class SettingsActivity extends AppCompatPreferenceActivity implements ActionBarSupport {

    private String TAG = "SettingsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ToolbarUtil.setupActionBar(this, this, getString(R.string.Instellingen), true);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Log.i(TAG, "onMenuItemSelected()");
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (!super.onMenuItemSelected(featureId, item)) {
                onBackPressed();
            }
            return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "onBackPressed()");
        NavUtils.navigateUpFromSameTask(this);
    }

}