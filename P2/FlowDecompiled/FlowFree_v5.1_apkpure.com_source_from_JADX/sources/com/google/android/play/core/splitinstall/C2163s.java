package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.listener.C2123b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.s */
public final class C2163s extends C2123b<SplitInstallSessionState> {

    /* renamed from: c */
    private static C2163s f5295c;

    /* renamed from: d */
    private final Handler f5296d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final C2154e f5297e;

    /* renamed from: f */
    private final Set<SplitInstallStateUpdatedListener> f5298f = new LinkedHashSet();

    public C2163s(Context context, C2154e eVar) {
        super(new C2058ag("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f5297e = eVar;
    }

    /* renamed from: b */
    public static synchronized C2163s m5425b(Context context) {
        C2163s sVar;
        synchronized (C2163s.class) {
            if (f5295c == null) {
                f5295c = new C2163s(context, C2157l.f5284a);
            }
            sVar = f5295c;
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21868a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState d = SplitInstallSessionState.m5405d(bundleExtra);
            this.f5217a.mo22024a("ListenerRegistryBroadcastReceiver.onReceive: %s", d);
            C2155f a = this.f5297e.mo22174a();
            if (d.status() != 3 || a == null) {
                mo22177k(d);
            } else {
                a.mo22041a(d.mo22162c(), new C2161q(this, d, intent, context));
            }
        }
    }

    /* renamed from: k */
    public final synchronized void mo22177k(SplitInstallSessionState splitInstallSessionState) {
        Iterator it = new LinkedHashSet(this.f5298f).iterator();
        while (it.hasNext()) {
            ((SplitInstallStateUpdatedListener) it.next()).onStateUpdate(splitInstallSessionState);
        }
        super.mo22110i(splitInstallSessionState);
    }
}
