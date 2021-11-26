package com.noodlecake.lib.uikit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.noodlecake.lib.UIKit;
import com.noodlecake.lib.process.AppProcess;

public class DialogMessage {
    public String message;
    public String title;

    public DialogMessage(String str, String str2) {
        this.message = str2;
        this.title = str;
    }

    public static void showDialog(String str, String str2) {
        Context context = UIKit.appContext;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (context == null) {
            return;
        }
        if (activity == null || !activity.isFinishing()) {
            new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create().show();
        }
    }

    public static void showExitDialog(String str, String str2) {
        Context context = UIKit.appContext;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (context == null) {
            return;
        }
        if (activity == null || !activity.isFinishing()) {
            new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setPositiveButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AppProcess.terminateProcess();
                }
            }).create().show();
        }
    }
}
