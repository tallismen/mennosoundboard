package nl.designlama.mennosoundboard.utils;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import nl.designlama.mennosoundboard.ActionBarSupport;
import nl.designlama.mennosoundboard.R;

public class ToolbarUtil {


    private ToolbarUtil() {
    }

    public static void setupActionBar(ActionBarSupport actionBarSupport, Activity activity, String title, boolean homeEnabled) {
        Log.i("ToolbarUtil","setupActionBar()");
        activity.getLayoutInflater().inflate(R.layout.toolbar, (ViewGroup) activity.findViewById(android.R.id.content));
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        actionBarSupport.setSupportActionBar(toolbar);
        ActionBar actionBar = actionBarSupport.getSupportActionBar();
        if (actionBar != null) {
            TextView textView = (TextView) activity.findViewById(R.id.toolbar_title);
            textView.setText(title);
            actionBar.setDisplayHomeAsUpEnabled(homeEnabled);
            actionBar.setHomeAsUpIndicator(ContextCompat.getDrawable(activity, R.drawable.ic_arrow_back));
        }
    }
}
