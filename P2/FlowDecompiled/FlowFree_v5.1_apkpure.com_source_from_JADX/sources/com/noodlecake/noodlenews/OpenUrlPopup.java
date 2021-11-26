package com.noodlecake.noodlenews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import java.util.HashMap;

public class OpenUrlPopup {
    public static void openUrl(final PopupTransaction popupTransaction) {
        Handler handler = Popup.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    final Context context = Popup.getContext();
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (context == null) {
                        return;
                    }
                    if (activity == null || !activity.isFinishing()) {
                        new AlertDialog.Builder(context).setTitle(popupTransaction.getTitle()).setMessage(popupTransaction.getDescription()).setPositiveButton(popupTransaction.getPositiveButtonText(), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(popupTransaction.getParameter2()));
                                context.startActivity(intent);
                                Popup.addCurrency(popupTransaction.getId());
                                HashMap hashMap = new HashMap();
                                hashMap.put("id", "" + popupTransaction.getId());
                                hashMap.put("popup_id", "" + popupTransaction.getPopupId());
                                hashMap.put("type", popupTransaction.getType());
                            }
                        }).setNegativeButton(popupTransaction.getNegativeButtonText(), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("id", "" + popupTransaction.getId());
                                hashMap.put("popup_id", "" + popupTransaction.getPopupId());
                                hashMap.put("type", popupTransaction.getType());
                            }
                        }).create().show();
                    }
                }
            });
        }
    }
}
