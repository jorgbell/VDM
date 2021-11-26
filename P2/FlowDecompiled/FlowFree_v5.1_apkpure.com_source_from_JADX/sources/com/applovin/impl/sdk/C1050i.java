package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1157p;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.i */
class C1050i implements AppLovinBroadcastManager.Receiver {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static AlertDialog f2134b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final AtomicBoolean f2135c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1056j f2136a;

    /* renamed from: d */
    private C1157p f2137d;

    /* renamed from: com.applovin.impl.sdk.i$a */
    public interface C1055a {
        /* renamed from: a */
        void mo9316a();

        /* renamed from: b */
        void mo9317b();
    }

    C1050i(C1056j jVar, C1062k kVar) {
        this.f2136a = jVar;
        kVar.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        kVar.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void mo9311a(long j, final C1062k kVar, final C1055a aVar) {
        if (j > 0) {
            AlertDialog alertDialog = f2134b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (f2135c.getAndSet(true)) {
                    if (j < this.f2137d.mo9661a()) {
                        C1107r z = kVar.mo9411z();
                        z.mo9584b("ConsentAlertManager", "Scheduling consent alert earlier (" + j + "ms) than remaining scheduled time (" + this.f2137d.mo9661a() + "ms)");
                        this.f2137d.mo9664d();
                    } else {
                        C1107r z2 = kVar.mo9411z();
                        z2.mo9587d("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.f2137d.mo9661a() + " milliseconds");
                        return;
                    }
                }
                C1107r z3 = kVar.mo9411z();
                z3.mo9584b("ConsentAlertManager", "Scheduling consent alert for " + j + " milliseconds");
                this.f2137d = C1157p.m2682a(j, kVar, new Runnable() {
                    public void run() {
                        String str;
                        C1107r rVar;
                        if (C1050i.this.f2136a.mo9320c()) {
                            kVar.mo9411z().mo9588e("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                            return;
                        }
                        Activity a = kVar.mo9370ae().mo8944a();
                        if (a == null || !C1120h.m2544a(kVar.mo9334J())) {
                            if (a == null) {
                                rVar = kVar.mo9411z();
                                str = "No parent Activity found - rescheduling consent alert...";
                            } else {
                                rVar = kVar.mo9411z();
                                str = "No internet available - rescheduling consent alert...";
                            }
                            rVar.mo9588e("ConsentAlertManager", str);
                            C1050i.f2135c.set(false);
                            C1050i.this.mo9311a(((Long) kVar.mo9350a(C0965b.f1627az)).longValue(), kVar, aVar);
                            return;
                        }
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                AlertDialog unused = C1050i.f2134b = new AlertDialog.Builder(kVar.mo9370ae().mo8944a()).setTitle((CharSequence) kVar.mo9350a(C0965b.f1576aA)).setMessage((CharSequence) kVar.mo9350a(C0965b.f1577aB)).setCancelable(false).setPositiveButton((CharSequence) kVar.mo9350a(C0965b.f1578aC), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo9316a();
                                        dialogInterface.dismiss();
                                        C1050i.f2135c.set(false);
                                    }
                                }).setNegativeButton((CharSequence) kVar.mo9350a(C0965b.f1579aD), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo9317b();
                                        dialogInterface.dismiss();
                                        C1050i.f2135c.set(false);
                                        long longValue = ((Long) kVar.mo9350a(C0965b.f1626ay)).longValue();
                                        C10511 r0 = C10511.this;
                                        C1050i.this.mo9311a(longValue, kVar, aVar);
                                    }
                                }).create();
                                C1050i.f2134b.show();
                            }
                        });
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (this.f2137d != null) {
            String action = intent.getAction();
            if ("com.applovin.application_paused".equals(action)) {
                this.f2137d.mo9662b();
            } else if ("com.applovin.application_resumed".equals(action)) {
                this.f2137d.mo9663c();
            }
        }
    }
}
