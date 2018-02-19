package nl.designlama.mennosoundboard.utils;

import android.app.AlertDialog;
import android.content.Context;

import nl.designlama.mennosoundboard.R;

/**
 * Created by Maarten on 19-2-2018.
 */

public class AlertDialogUtil {

    private AlertDialogUtil(){

    }

    public static AlertDialog.Builder createAlertDialog(Context context, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_info_outline);
        return builder;
    }

    public static void createAndShowAlertDialog(Context context, String title, String message){
        createAlertDialog(context,title,message).show();
    }
}
