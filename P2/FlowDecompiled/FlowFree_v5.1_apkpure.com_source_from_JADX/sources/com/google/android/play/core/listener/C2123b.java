package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.splitcompat.C2150p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.play.core.listener.b */
public abstract class C2123b<StateT> {

    /* renamed from: a */
    protected final C2058ag f5217a;

    /* renamed from: b */
    protected final Set<StateUpdatedListener<StateT>> f5218b = new HashSet();

    /* renamed from: c */
    private final IntentFilter f5219c;

    /* renamed from: d */
    private final Context f5220d;

    /* renamed from: e */
    private C2122a f5221e = null;

    /* renamed from: f */
    private volatile boolean f5222f = false;

    protected C2123b(C2058ag agVar, IntentFilter intentFilter, Context context) {
        this.f5217a = agVar;
        this.f5219c = intentFilter;
        this.f5220d = C2150p.m5402c(context);
    }

    /* renamed from: b */
    private final void m5334b() {
        C2122a aVar;
        if ((this.f5222f || !this.f5218b.isEmpty()) && this.f5221e == null) {
            C2122a aVar2 = new C2122a(this);
            this.f5221e = aVar2;
            this.f5220d.registerReceiver(aVar2, this.f5219c);
        }
        if (!this.f5222f && this.f5218b.isEmpty() && (aVar = this.f5221e) != null) {
            this.f5220d.unregisterReceiver(aVar);
            this.f5221e = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo21868a(Context context, Intent intent);

    /* renamed from: e */
    public final synchronized void mo22109e(boolean z) {
        this.f5222f = z;
        m5334b();
    }

    /* renamed from: i */
    public final synchronized void mo22110i(StateT statet) {
        Iterator it = new HashSet(this.f5218b).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    /* renamed from: j */
    public final synchronized boolean mo22111j() {
        return this.f5221e != null;
    }
}
