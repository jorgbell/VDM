package com.noodlecake.noodlenews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.ImageView;

public class ImagePopup {
    public static void popUpImage(final PopupTransaction popupTransaction) {
        Handler handler = Popup.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    Context context = Popup.getContext();
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (context == null) {
                        return;
                    }
                    if (activity == null || !activity.isFinishing()) {
                        ImageView imageView = new ImageView(context);
                        imageView.setImageBitmap(new WebImage("http://static.noodlecake.net/LRad-hd.jpg").getBitmap(context));
                        imageView.setMinimumHeight(400);
                        new AlertDialog.Builder(context).setView(imageView).setPositiveButton(popupTransaction.getPositiveButtonText(), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Popup.addCurrency(popupTransaction.getId());
                            }
                        }).setNegativeButton(popupTransaction.getNegativeButtonText(), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).create().show();
                    }
                }
            });
        }
    }
}
