package com.applovin.impl.adview.activity.p020b;

import android.graphics.PointF;
import android.net.Uri;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0653j;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.p018a.C0543d;
import com.applovin.impl.p018a.C0547g;
import com.applovin.impl.p018a.C0548h;
import com.applovin.impl.p018a.C0549i;
import com.applovin.impl.p018a.C0550j;
import com.applovin.impl.p018a.C0553k;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.activity.b.c */
public class C0594c extends C0598e {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final Set<C0547g> f372A;

    /* renamed from: z */
    private final C0536a f373z;

    public C0594c(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.f372A = hashSet;
        C0536a aVar = (C0536a) gVar;
        this.f373z = aVar;
        C0536a.C0540c cVar = C0536a.C0540c.VIDEO;
        hashSet.addAll(aVar.mo7814a(cVar, C0548h.f212a));
        m412a(C0536a.C0540c.IMPRESSION);
        m414a(cVar, "creativeView");
    }

    /* renamed from: C */
    private void m410C() {
        if (mo7994o() && !this.f372A.isEmpty()) {
            C1107r rVar = this.f326c;
            rVar.mo9587d("InterActivityV2", "Firing " + this.f372A.size() + " un-fired video progress trackers when video was completed.");
            m417a(this.f372A);
        }
    }

    /* renamed from: a */
    private void m412a(C0536a.C0540c cVar) {
        m413a(cVar, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m413a(C0536a.C0540c cVar, C0543d dVar) {
        m415a(cVar, "", dVar);
    }

    /* renamed from: a */
    private void m414a(C0536a.C0540c cVar, String str) {
        m415a(cVar, str, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m415a(C0536a.C0540c cVar, String str, C0543d dVar) {
        m418a(this.f373z.mo7813a(cVar, str), dVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m417a(Set<C0547g> set) {
        m418a(set, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m418a(Set<C0547g> set, C0543d dVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f392s.getCurrentPosition());
            C0553k m = this.f373z.mo7838m();
            Uri a = m != null ? m.mo7899a() : null;
            C1107r rVar = this.f326c;
            rVar.mo9584b("InterActivityV2", "Firing " + set.size() + " tracker(s): " + set);
            C0549i.m291a(set, seconds, a, dVar, this.f325b);
        }
    }

    /* renamed from: a */
    public void mo8014a(PointF pointF) {
        m412a(C0536a.C0540c.VIDEO_CLICK);
        super.mo8014a(pointF);
    }

    /* renamed from: c */
    public void mo7981c() {
        super.mo7981c();
        this.f393t.mo8195a("PROGRESS_TRACKING", ((Long) this.f325b.mo9350a(C0965b.f1811ed)).longValue(), (C0653j.C0655a) new C0653j.C0655a() {
            /* renamed from: a */
            public void mo8020a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(C0594c.this.f395v - (C0594c.this.f392s.getDuration() - C0594c.this.f392s.getCurrentPosition()));
                HashSet hashSet = new HashSet();
                for (C0547g gVar : new HashSet(C0594c.this.f372A)) {
                    if (gVar.mo7883a(seconds, C0594c.this.mo8029B())) {
                        hashSet.add(gVar);
                        C0594c.this.f372A.remove(gVar);
                    }
                }
                C0594c.this.m417a((Set<C0547g>) hashSet);
            }

            /* renamed from: b */
            public boolean mo8021b() {
                return !C0594c.this.f397x;
            }
        });
    }

    /* renamed from: c */
    public void mo8015c(String str) {
        m413a(C0536a.C0540c.ERROR, C0543d.MEDIA_FILE_ERROR);
        super.mo8015c(str);
    }

    /* renamed from: d */
    public void mo7983d() {
        super.mo7983d();
        m414a(this.f397x ? C0536a.C0540c.COMPANION : C0536a.C0540c.VIDEO, "resume");
    }

    /* renamed from: e */
    public void mo7984e() {
        super.mo7984e();
        m414a(this.f397x ? C0536a.C0540c.COMPANION : C0536a.C0540c.VIDEO, "pause");
    }

    /* renamed from: f */
    public void mo7985f() {
        m414a(C0536a.C0540c.VIDEO, "close");
        m414a(C0536a.C0540c.COMPANION, "close");
        super.mo7985f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo7997r() {
        long j;
        int t;
        long j2 = 0;
        if (this.f373z.mo9034ab() >= 0 || this.f373z.mo9035ac() >= 0) {
            int i = (this.f373z.mo9034ab() > 0 ? 1 : (this.f373z.mo9034ab() == 0 ? 0 : -1));
            C0536a aVar = this.f373z;
            if (i >= 0) {
                j = aVar.mo9034ab();
            } else {
                C0550j l = aVar.mo7837l();
                if (l == null || l.mo7890b() <= 0) {
                    long j3 = this.f395v;
                    if (j3 > 0) {
                        j2 = 0 + j3;
                    }
                } else {
                    j2 = 0 + TimeUnit.SECONDS.toMillis((long) l.mo7890b());
                }
                if (aVar.mo9036ad() && (t = (int) aVar.mo9068t()) > 0) {
                    j2 += TimeUnit.SECONDS.toMillis((long) t);
                }
                double d = (double) j2;
                double ac = (double) this.f373z.mo9035ac();
                Double.isNaN(ac);
                Double.isNaN(d);
                j = (long) (d * (ac / 100.0d));
            }
            mo7971a(j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo8016t() {
        this.f393t.mo8197c();
        super.mo8016t();
    }

    /* renamed from: u */
    public void mo8017u() {
        m414a(C0536a.C0540c.VIDEO, "skip");
        super.mo8017u();
    }

    /* renamed from: v */
    public void mo8018v() {
        super.mo8018v();
        m414a(C0536a.C0540c.VIDEO, this.f394u ? "mute" : "unmute");
    }

    /* renamed from: w */
    public void mo8019w() {
        m410C();
        if (!C0549i.m298c(this.f373z)) {
            this.f326c.mo9584b("InterActivityV2", "VAST ad does not have valid companion ad - dismissing...");
            mo7985f();
        } else if (!this.f397x) {
            m414a(C0536a.C0540c.COMPANION, "creativeView");
            super.mo8019w();
        }
    }
}
