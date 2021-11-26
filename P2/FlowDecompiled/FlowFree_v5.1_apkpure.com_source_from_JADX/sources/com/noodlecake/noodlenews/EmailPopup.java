package com.noodlecake.noodlenews;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.HashMap;
import java.util.regex.Pattern;

public class EmailPopup {
    /* access modifiers changed from: private */
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");

    public static String getPrePopEmail(String str) {
        for (Account account : AccountManager.get(Popup.getContext()).getAccounts()) {
            String str2 = account.name;
            if (EMAIL_ADDRESS_PATTERN.matcher(str2).matches()) {
                boolean z = true;
                if (str != null && !str.equals("")) {
                    for (String indexOf : str.split(",")) {
                        if (str2.indexOf(indexOf) > -1) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    return str2;
                }
            }
        }
        return "";
    }

    public static void popUpEmailDialog(final PopupTransaction popupTransaction) {
        Handler handler = Popup.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    Context context = Popup.getContext();
                    final EditText editText = new EditText(context);
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (context == null) {
                        return;
                    }
                    if (activity == null || !activity.isFinishing()) {
                        final AlertDialog create = new AlertDialog.Builder(context).setTitle(popupTransaction.getTitle()).setView(editText).setMessage(popupTransaction.getDescription()).setPositiveButton(popupTransaction.getPositiveButtonText(), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C27371.this.sendEmail(editText.getText().toString());
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
                        }).create();
                        create.show();
                        create.getButton(-1).setEnabled(false);
                        editText.addTextChangedListener(new TextWatcher() {
                            public void afterTextChanged(Editable editable) {
                            }

                            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            }

                            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                if (EmailPopup.EMAIL_ADDRESS_PATTERN.matcher(editText.getText().toString()).matches()) {
                                    create.getButton(-1).setEnabled(true);
                                } else {
                                    create.getButton(-1).setEnabled(false);
                                }
                            }
                        });
                        editText.setText(EmailPopup.getPrePopEmail(popupTransaction.getParameter4()));
                    }
                }

                public void sendEmail(final String str) {
                    new Thread() {
                        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r4 = this;
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                r0.<init>()
                                java.lang.String r1 = "?bundle_id=com.noodlecake.ssg&platform=android&email="
                                r0.append(r1)
                                java.lang.String r1 = r2
                                r0.append(r1)
                                java.lang.String r1 = "&referral_id="
                                r0.append(r1)
                                com.noodlecake.noodlenews.EmailPopup$1 r1 = com.noodlecake.noodlenews.EmailPopup.C27371.this
                                com.noodlecake.noodlenews.PopupTransaction r1 = r2
                                int r1 = r1.getId()
                                r0.append(r1)
                                java.lang.String r0 = r0.toString()
                                java.net.URI r1 = new java.net.URI     // Catch:{ URISyntaxException -> 0x0054 }
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x0054 }
                                r2.<init>()     // Catch:{ URISyntaxException -> 0x0054 }
                                com.noodlecake.noodlenews.EmailPopup$1 r3 = com.noodlecake.noodlenews.EmailPopup.C27371.this     // Catch:{ URISyntaxException -> 0x0054 }
                                com.noodlecake.noodlenews.PopupTransaction r3 = r2     // Catch:{ URISyntaxException -> 0x0054 }
                                java.lang.String r3 = r3.getParameter2()     // Catch:{ URISyntaxException -> 0x0054 }
                                r2.append(r3)     // Catch:{ URISyntaxException -> 0x0054 }
                                r2.append(r0)     // Catch:{ URISyntaxException -> 0x0054 }
                                java.lang.String r0 = r2.toString()     // Catch:{ URISyntaxException -> 0x0054 }
                                r1.<init>(r0)     // Catch:{ URISyntaxException -> 0x0054 }
                                org.apache.http.client.methods.HttpGet r0 = new org.apache.http.client.methods.HttpGet
                                r0.<init>(r1)
                                org.apache.http.impl.client.DefaultHttpClient r1 = new org.apache.http.impl.client.DefaultHttpClient
                                r1.<init>()
                                org.apache.http.HttpResponse r0 = r1.execute(r0)     // Catch:{  }
                                org.apache.http.StatusLine r0 = r0.getStatusLine()     // Catch:{  }
                                r0.getStatusCode()     // Catch:{  }
                            L_0x0054:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.noodlenews.EmailPopup.C27371.C27414.run():void");
                        }
                    }.start();
                }
            });
        }
    }
}
