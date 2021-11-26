package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.f */
public class C1044f extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public static int f2116a = -1;

    /* renamed from: b */
    private final AudioManager f2117b;

    /* renamed from: c */
    private final Context f2118c;

    /* renamed from: d */
    private final C1062k f2119d;

    /* renamed from: e */
    private final Set<C1046a> f2120e = new HashSet();

    /* renamed from: f */
    private final Object f2121f = new Object();

    /* renamed from: g */
    private boolean f2122g;

    /* renamed from: h */
    private int f2123h;

    /* renamed from: com.applovin.impl.sdk.f$a */
    public interface C1046a {
        void onRingerModeChanged(int i);
    }

    C1044f(C1062k kVar) {
        this.f2119d = kVar;
        Context J = kVar.mo9334J();
        this.f2118c = J;
        this.f2117b = (AudioManager) J.getSystemService("audio");
    }

    /* renamed from: a */
    public static boolean m2057a(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: b */
    private void m2058b() {
        this.f2119d.mo9411z().mo9584b("AudioSessionManager", "Observing ringer mode...");
        this.f2123h = f2116a;
        this.f2118c.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.f2119d.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f2119d.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: b */
    private void m2059b(final int i) {
        if (!this.f2122g) {
            C1107r z = this.f2119d.mo9411z();
            z.mo9584b("AudioSessionManager", "Ringer mode is " + i);
            synchronized (this.f2121f) {
                for (final C1046a next : this.f2120e) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            next.onRingerModeChanged(i);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: c */
    private void m2060c() {
        this.f2119d.mo9411z().mo9584b("AudioSessionManager", "Stopping observation of mute switch state...");
        this.f2118c.unregisterReceiver(this);
        this.f2119d.mo9375aj().unregisterReceiver(this);
    }

    /* renamed from: a */
    public int mo9297a() {
        return this.f2117b.getRingerMode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9298a(com.applovin.impl.sdk.C1044f.C1046a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2121f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.f$a> r1 = r2.f2120e     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.f$a> r1 = r2.f2120e     // Catch:{ all -> 0x0020 }
            r1.add(r3)     // Catch:{ all -> 0x0020 }
            java.util.Set<com.applovin.impl.sdk.f$a> r3 = r2.f2120e     // Catch:{ all -> 0x0020 }
            int r3 = r3.size()     // Catch:{ all -> 0x0020 }
            r1 = 1
            if (r3 != r1) goto L_0x001e
            r2.m2058b()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1044f.mo9298a(com.applovin.impl.sdk.f$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9299b(com.applovin.impl.sdk.C1044f.C1046a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2121f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.f$a> r1 = r2.f2120e     // Catch:{ all -> 0x001f }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.f$a> r1 = r2.f2120e     // Catch:{ all -> 0x001f }
            r1.remove(r3)     // Catch:{ all -> 0x001f }
            java.util.Set<com.applovin.impl.sdk.f$a> r3 = r2.f2120e     // Catch:{ all -> 0x001f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x001d
            r2.m2060c()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1044f.mo9299b(com.applovin.impl.sdk.f$a):void");
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            m2059b(this.f2117b.getRingerMode());
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2122g = true;
            this.f2123h = this.f2117b.getRingerMode();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f2122g = false;
            if (this.f2123h != this.f2117b.getRingerMode()) {
                this.f2123h = f2116a;
                m2059b(this.f2117b.getRingerMode());
            }
        }
    }
}
