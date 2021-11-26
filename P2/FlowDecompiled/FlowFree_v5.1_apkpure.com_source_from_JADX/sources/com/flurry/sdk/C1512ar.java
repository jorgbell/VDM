package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Locale;

/* renamed from: com.flurry.sdk.ar */
public final class C1512ar extends C1907m<C1511aq> {

    /* renamed from: a */
    protected BroadcastReceiver f3809a = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            C1512ar.this.notifyObservers(C1512ar.m4012b());
        }
    };

    public C1512ar() {
        super("LocaleProvider");
        Context a = C1536b.m4057a();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        if (a != null) {
            a.registerReceiver(this.f3809a, intentFilter);
        } else {
            C1648cy.m4317a(6, "LocaleProvider", "Context is null when initializing.");
        }
    }

    public final void subscribe(final C1914o<C1511aq> oVar) {
        super.subscribe(oVar);
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                oVar.mo11263a(C1512ar.m4012b());
            }
        });
    }

    public final void destroy() {
        super.destroy();
        C1536b.m4057a().unregisterReceiver(this.f3809a);
    }

    /* renamed from: a */
    public static String m4010a() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    /* renamed from: b */
    public static C1511aq m4012b() {
        return new C1511aq(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
    }
}
