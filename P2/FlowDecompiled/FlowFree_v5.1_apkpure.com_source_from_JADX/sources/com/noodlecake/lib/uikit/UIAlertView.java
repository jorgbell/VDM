package com.noodlecake.lib.uikit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.noodlecake.lib.UIKit;
import java.util.HashMap;
import java.util.Map;

public class UIAlertView {
    /* access modifiers changed from: private */
    public static Map<Integer, AlertDialog> _alertDialogById = new HashMap();

    public static native void returnAlertView(int i, int i2, String str, boolean z);

    /* access modifiers changed from: private */
    public static void alertFinished(final int i, final int i2, final String str, final boolean z) {
        UIKit.appHandler.post(new Runnable() {
            public void run() {
                UIAlertView.returnAlertView(i, i2, str, z);
                UIAlertView._alertDialogById.remove(Integer.valueOf(i));
            }
        });
    }

    /* access modifiers changed from: private */
    public static void alertFinished(int i, int i2, String str) {
        alertFinished(i, i2, str, true);
    }

    public static void dismissWithClickedButtonIndex(final int i, final int i2) {
        UIKit.appHandler.post(new Runnable() {
            public void run() {
                if (UIAlertView._alertDialogById.containsKey(Integer.valueOf(i))) {
                    ((AlertDialog) UIAlertView._alertDialogById.get(Integer.valueOf(i))).dismiss();
                    UIAlertView.alertFinished(i, i2, (String) null, false);
                }
            }
        });
    }

    public static void createOkCancelDialog(String str, String str2, String str3, String str4, int i, boolean z) {
        Handler handler = UIKit.appHandler;
        if (handler != null) {
            final String str5 = str;
            final String str6 = str2;
            final boolean z2 = z;
            final String str7 = str4;
            final int i2 = i;
            final String str8 = str3;
            handler.post(new Runnable() {
                public void run() {
                    Context context = UIKit.appContext;
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (context == null) {
                        return;
                    }
                    if (activity == null || !activity.isFinishing()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle(str5);
                        builder.setMessage(str6);
                        final EditText editText = new EditText(UIKit.appContext);
                        if (z2) {
                            builder.setView(editText);
                        }
                        String str = str7;
                        builder.setPositiveButton((str == null || str.equalsIgnoreCase("")) ? "OK" : str7, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                UIAlertView.alertFinished(i2, 1, z2 ? editText.getText().toString() : null);
                            }
                        });
                        String str2 = str8;
                        if (str2 != null && !str2.equalsIgnoreCase("")) {
                            builder.setNegativeButton(str8, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    UIAlertView.alertFinished(i2, 0, z2 ? editText.getText().toString() : null);
                                }
                            });
                        }
                        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            public void onCancel(DialogInterface dialogInterface) {
                                UIAlertView.alertFinished(i2, 0, z2 ? editText.getText().toString() : null, false);
                            }
                        });
                        builder.create();
                        UIAlertView._alertDialogById.put(Integer.valueOf(i2), builder.show());
                    }
                }
            });
        }
    }

    public static void createDialog(String str, String str2, String str3, String str4, String str5, int i) {
        Handler handler = UIKit.appHandler;
        if (handler != null) {
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final String str9 = str4;
            final int i2 = i;
            final String str10 = str5;
            handler.post(new Runnable() {
                public void run() {
                    String str;
                    Context context = UIKit.appContext;
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (context == null) {
                        return;
                    }
                    if (activity == null || !activity.isFinishing()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle(str6);
                        builder.setMessage(str7);
                        String str2 = str8;
                        if (str2 == null || str2.equalsIgnoreCase("") || (str = str9) == null || str.equalsIgnoreCase("")) {
                            String str3 = str8;
                            builder.setPositiveButton((str3 == null || str3.equalsIgnoreCase("")) ? "OK" : str8, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    UIAlertView.alertFinished(i2, 0, (String) null);
                                }
                            });
                        } else {
                            builder.setNegativeButton(str8, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    UIAlertView.alertFinished(i2, 0, (String) null);
                                }
                            });
                            builder.setPositiveButton(str9, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    UIAlertView.alertFinished(i2, 1, (String) null);
                                }
                            });
                            String str4 = str10;
                            if (str4 != null && !str4.equalsIgnoreCase("")) {
                                builder.setNeutralButton(str10, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        UIAlertView.alertFinished(i2, 2, (String) null);
                                    }
                                });
                            }
                        }
                        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            public void onCancel(DialogInterface dialogInterface) {
                                UIAlertView.alertFinished(i2, 0, (String) null, false);
                            }
                        });
                        builder.create();
                        UIAlertView._alertDialogById.put(Integer.valueOf(i2), builder.show());
                    }
                }
            });
        }
    }
}
