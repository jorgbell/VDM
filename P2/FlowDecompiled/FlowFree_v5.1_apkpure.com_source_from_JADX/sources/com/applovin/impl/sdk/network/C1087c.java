package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.network.c */
public class C1087c extends BroadcastReceiver {

    /* renamed from: a */
    private final List<C1088a> f2310a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.sdk.network.c$a */
    public interface C1088a {
        /* renamed from: a */
        void mo9414a();

        /* renamed from: b */
        void mo9415b();
    }

    public C1087c(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* renamed from: a */
    private static boolean m2335a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        Object obj = extras.get("networkInfo");
        if (obj instanceof NetworkInfo) {
            return ((NetworkInfo) obj).isConnected();
        }
        return false;
    }

    /* renamed from: a */
    public void mo9495a(C1088a aVar) {
        this.f2310a.add(aVar);
    }

    /* renamed from: b */
    public void mo9496b(C1088a aVar) {
        this.f2310a.remove(aVar);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && !isInitialStickyBroadcast()) {
            ArrayList arrayList = new ArrayList(this.f2310a);
            boolean a = m2335a(intent);
            Iterator it = arrayList.iterator();
            if (a) {
                while (it.hasNext()) {
                    ((C1088a) it.next()).mo9414a();
                }
                return;
            }
            while (it.hasNext()) {
                ((C1088a) it.next()).mo9415b();
            }
        }
    }
}
