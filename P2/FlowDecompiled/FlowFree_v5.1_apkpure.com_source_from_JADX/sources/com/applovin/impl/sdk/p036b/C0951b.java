package com.applovin.impl.sdk.p036b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.b.b */
public class C0951b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f1501a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Activity f1502b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialog f1503c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0961a f1504d;

    /* renamed from: com.applovin.impl.sdk.b.b$a */
    public interface C0961a {
        /* renamed from: a */
        void mo8010a();

        /* renamed from: b */
        void mo8011b();
    }

    public C0951b(Activity activity, C1062k kVar) {
        this.f1501a = kVar;
        this.f1502b = activity;
    }

    /* renamed from: a */
    public void mo9094a() {
        this.f1502b.runOnUiThread(new Runnable() {
            public void run() {
                if (C0951b.this.f1503c != null) {
                    C0951b.this.f1503c.dismiss();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9095a(final C0934g gVar, final Runnable runnable) {
        this.f1502b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(C0951b.this.f1502b);
                builder.setTitle(gVar.mo9045am());
                String an = gVar.mo9046an();
                if (AppLovinSdkUtils.isValidString(an)) {
                    builder.setMessage(an);
                }
                builder.setPositiveButton(gVar.mo9047ao(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        runnable.run();
                    }
                });
                builder.setCancelable(false);
                AlertDialog unused = C0951b.this.f1503c = builder.show();
            }
        });
    }

    /* renamed from: a */
    public void mo9096a(C0961a aVar) {
        this.f1504d = aVar;
    }

    /* renamed from: b */
    public void mo9097b() {
        this.f1502b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog unused = C0951b.this.f1503c = new AlertDialog.Builder(C0951b.this.f1502b).setTitle((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1669bo)).setMessage((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1670bp)).setCancelable(false).setPositiveButton((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1672br), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C0951b.this.f1504d.mo8010a();
                    }
                }).setNegativeButton((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1671bq), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C0951b.this.f1504d.mo8011b();
                    }
                }).show();
            }
        });
    }

    /* renamed from: c */
    public void mo9098c() {
        this.f1502b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(C0951b.this.f1502b);
                builder.setTitle((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1674bt));
                builder.setMessage((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1675bu));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1677bw), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C0951b.this.f1504d.mo8010a();
                    }
                });
                builder.setNegativeButton((CharSequence) C0951b.this.f1501a.mo9350a(C0965b.f1676bv), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C0951b.this.f1504d.mo8011b();
                    }
                });
                AlertDialog unused = C0951b.this.f1503c = builder.show();
            }
        });
    }

    /* renamed from: d */
    public boolean mo9099d() {
        AlertDialog alertDialog = this.f1503c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
