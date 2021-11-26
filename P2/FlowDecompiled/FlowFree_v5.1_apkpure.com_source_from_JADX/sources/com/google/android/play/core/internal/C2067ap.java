package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ap */
final class C2067ap implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C2068aq f5158a;

    /* synthetic */ C2067ap(C2068aq aqVar) {
        this.f5158a = aqVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f5158a.f5161c.mo22027d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f5158a.m5172r(new C2065an(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5158a.f5161c.mo22027d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f5158a.m5172r(new C2066ao(this));
    }
}
