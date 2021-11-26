package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.internal.aq */
public final class C2068aq<T extends IInterface> {

    /* renamed from: a */
    private static final Map<String, Handler> f5159a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f5160b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C2058ag f5161c;

    /* renamed from: d */
    private final String f5162d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<C2059ah> f5163e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f5164f;

    /* renamed from: g */
    private final Intent f5165g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C2064am<T> f5166h;

    /* renamed from: i */
    private final WeakReference<C2063al> f5167i;

    /* renamed from: j */
    private final IBinder.DeathRecipient f5168j = new C2060ai(this);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ServiceConnection f5169k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public T f5170l;

    public C2068aq(Context context, C2058ag agVar, String str, Intent intent, C2064am<T> amVar) {
        this.f5160b = context;
        this.f5161c = agVar;
        this.f5162d = str;
        this.f5165g = intent;
        this.f5166h = amVar;
        this.f5167i = new WeakReference<>((Object) null);
    }

    /* renamed from: d */
    static /* synthetic */ void m5159d(C2068aq aqVar, C2059ah ahVar) {
        if (aqVar.f5170l == null && !aqVar.f5164f) {
            aqVar.f5161c.mo22027d("Initiate binding to the service.", new Object[0]);
            aqVar.f5163e.add(ahVar);
            C2067ap apVar = new C2067ap(aqVar);
            aqVar.f5169k = apVar;
            aqVar.f5164f = true;
            if (!aqVar.f5160b.bindService(aqVar.f5165g, apVar, 1)) {
                aqVar.f5161c.mo22027d("Failed to bind to the service.", new Object[0]);
                aqVar.f5164f = false;
                for (C2059ah b : aqVar.f5163e) {
                    b.mo22029b(new C2069ar());
                }
                aqVar.f5163e.clear();
            }
        } else if (aqVar.f5164f) {
            aqVar.f5161c.mo22027d("Waiting to bind to the service.", new Object[0]);
            aqVar.f5163e.add(ahVar);
        } else {
            ahVar.run();
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m5165j(C2068aq aqVar) {
        aqVar.f5161c.mo22027d("linkToDeath", new Object[0]);
        try {
            aqVar.f5170l.asBinder().linkToDeath(aqVar.f5168j, 0);
        } catch (RemoteException e) {
            aqVar.f5161c.mo22026c(e, "linkToDeath failed", new Object[0]);
        }
    }

    /* renamed from: m */
    static /* synthetic */ void m5168m(C2068aq aqVar) {
        aqVar.f5161c.mo22027d("unlinkToDeath", new Object[0]);
        aqVar.f5170l.asBinder().unlinkToDeath(aqVar.f5168j, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public final void m5172r(C2059ah ahVar) {
        Handler handler;
        Map<String, Handler> map = f5159a;
        synchronized (map) {
            if (!map.containsKey(this.f5162d)) {
                HandlerThread handlerThread = new HandlerThread(this.f5162d, 10);
                handlerThread.start();
                map.put(this.f5162d, new Handler(handlerThread.getLooper()));
            }
            handler = map.get(this.f5162d);
        }
        handler.post(ahVar);
    }

    /* renamed from: a */
    public final void mo22036a(C2059ah ahVar) {
        m5172r(new C2061aj(this, ahVar.mo22030c(), ahVar));
    }

    /* renamed from: b */
    public final void mo22037b() {
        m5172r(new C2062ak(this));
    }

    /* renamed from: c */
    public final T mo22038c() {
        return this.f5170l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* bridge */ /* synthetic */ void mo22039n() {
        this.f5161c.mo22027d("reportBinderDeath", new Object[0]);
        C2063al alVar = (C2063al) this.f5167i.get();
        if (alVar == null) {
            this.f5161c.mo22027d("%s : Binder has died.", this.f5162d);
            for (C2059ah b : this.f5163e) {
                b.mo22029b(Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.f5162d).concat(" : Binder has died.")));
            }
            this.f5163e.clear();
            return;
        }
        this.f5161c.mo22027d("calling onBinderDied", new Object[0]);
        alVar.mo22033a();
    }
}
