package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.TimeZone;

/* renamed from: com.flurry.sdk.bh */
public final class C1558bh extends C1907m<String> {

    /* renamed from: a */
    protected BroadcastReceiver f3948a = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            C1558bh.this.notifyObservers(TimeZone.getDefault().getID());
        }
    };

    public C1558bh() {
        super("TimeZoneProvider");
        Context a = C1536b.m4057a();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.TIMEZONE_CHANGED");
        if (a != null) {
            a.registerReceiver(this.f3948a, intentFilter);
        } else {
            C1648cy.m4317a(6, "TimeZoneProvider", "Context is null when initializing.");
        }
    }

    public final void subscribe(final C1914o<String> oVar) {
        super.subscribe(oVar);
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                oVar.mo11263a(TimeZone.getDefault().getID());
            }
        });
    }

    public final void destroy() {
        super.destroy();
        C1536b.m4057a().unregisterReceiver(this.f3948a);
    }
}
