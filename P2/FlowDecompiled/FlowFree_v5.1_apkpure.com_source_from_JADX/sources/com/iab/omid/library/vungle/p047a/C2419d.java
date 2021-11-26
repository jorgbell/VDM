package com.iab.omid.library.vungle.p047a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* renamed from: com.iab.omid.library.vungle.a.d */
public final class C2419d extends ContentObserver {

    /* renamed from: a */
    private final Context f5456a;

    /* renamed from: b */
    private final AudioManager f5457b;

    /* renamed from: c */
    private final C2416a f5458c;

    /* renamed from: d */
    private final C2418c f5459d;

    /* renamed from: e */
    private float f5460e;

    public C2419d(Handler handler, Context context, C2416a aVar, C2418c cVar) {
        super(handler);
        this.f5456a = context;
        this.f5457b = (AudioManager) context.getSystemService("audio");
        this.f5458c = aVar;
        this.f5459d = cVar;
    }

    /* renamed from: a */
    private boolean m5699a(float f) {
        return f != this.f5460e;
    }

    /* renamed from: c */
    private float m5700c() {
        return this.f5458c.mo24129a(this.f5457b.getStreamVolume(3), this.f5457b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m5701d() {
        this.f5459d.mo24131a(this.f5460e);
    }

    /* renamed from: a */
    public void mo24132a() {
        this.f5460e = m5700c();
        m5701d();
        this.f5456a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public void mo24133b() {
        this.f5456a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float c = m5700c();
        if (m5699a(c)) {
            this.f5460e = c;
            m5701d();
        }
    }
}
