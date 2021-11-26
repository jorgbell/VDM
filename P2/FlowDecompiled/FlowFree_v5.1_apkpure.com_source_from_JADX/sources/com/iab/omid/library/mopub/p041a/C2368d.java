package com.iab.omid.library.mopub.p041a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* renamed from: com.iab.omid.library.mopub.a.d */
public final class C2368d extends ContentObserver {

    /* renamed from: a */
    private final Context f5341a;

    /* renamed from: b */
    private final AudioManager f5342b;

    /* renamed from: c */
    private final C2365a f5343c;

    /* renamed from: d */
    private final C2367c f5344d;

    /* renamed from: e */
    private float f5345e;

    public C2368d(Handler handler, Context context, C2365a aVar, C2367c cVar) {
        super(handler);
        this.f5341a = context;
        this.f5342b = (AudioManager) context.getSystemService("audio");
        this.f5343c = aVar;
        this.f5344d = cVar;
    }

    /* renamed from: a */
    private boolean m5474a(float f) {
        return f != this.f5345e;
    }

    /* renamed from: c */
    private float m5475c() {
        return this.f5343c.mo23952a(this.f5342b.getStreamVolume(3), this.f5342b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m5476d() {
        this.f5344d.mo23954a(this.f5345e);
    }

    /* renamed from: a */
    public void mo23955a() {
        this.f5345e = m5475c();
        m5476d();
        this.f5341a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public void mo23956b() {
        this.f5341a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float c = m5475c();
        if (m5474a(c)) {
            this.f5345e = c;
            m5476d();
        }
    }
}
