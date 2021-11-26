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

/* renamed from: com.applovin.impl.adview.activity.b.d */
public class C0596d extends C0610f {

    /* renamed from: w */
    private final C0536a f375w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final Set<C0547g> f376x;

    public C0596d(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.f376x = hashSet;
        C0536a aVar = (C0536a) gVar;
        this.f375w = aVar;
        C0536a.C0540c cVar = C0536a.C0540c.VIDEO;
        hashSet.addAll(aVar.mo7814a(cVar, C0548h.f212a));
        m433a(C0536a.C0540c.IMPRESSION);
        m435a(cVar, "creativeView");
    }

    /* renamed from: a */
    private void m433a(C0536a.C0540c cVar) {
        m434a(cVar, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m434a(C0536a.C0540c cVar, C0543d dVar) {
        m436a(cVar, "", dVar);
    }

    /* renamed from: a */
    private void m435a(C0536a.C0540c cVar, String str) {
        m436a(cVar, str, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m436a(C0536a.C0540c cVar, String str, C0543d dVar) {
        m439a(this.f375w.mo7813a(cVar, str), dVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m438a(Set<C0547g> set) {
        m439a(set, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m439a(Set<C0547g> set, C0543d dVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.f427r.getCurrentPosition());
            C0553k m = this.f375w.mo7838m();
            Uri a = m != null ? m.mo7899a() : null;
            C1107r rVar = this.f326c;
            rVar.mo9584b("InterActivityV2", "Firing " + set.size() + " tracker(s): " + set);
            C0549i.m291a(set, seconds, a, dVar, this.f325b);
        }
    }

    /* renamed from: y */
    private void m440y() {
        if (mo7994o() && !this.f376x.isEmpty()) {
            C1107r rVar = this.f326c;
            rVar.mo9587d("InterActivityV2", "Firing " + this.f376x.size() + " un-fired video progress trackers when video was completed.");
            m438a(this.f376x);
        }
    }

    /* renamed from: a */
    public void mo8022a(PointF pointF) {
        m433a(C0536a.C0540c.VIDEO_CLICK);
        super.mo8022a(pointF);
    }

    /* renamed from: c */
    public void mo7981c() {
        super.mo7981c();
        this.f428s.mo8195a("PROGRESS_TRACKING", ((Long) this.f325b.mo9350a(C0965b.f1811ed)).longValue(), (C0653j.C0655a) new C0653j.C0655a() {
            /* renamed from: a */
            public void mo8020a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(C0596d.this.f430u - ((long) (C0596d.this.f427r.getDuration() - C0596d.this.f427r.getCurrentPosition())));
                HashSet hashSet = new HashSet();
                for (C0547g gVar : new HashSet(C0596d.this.f376x)) {
                    if (gVar.mo7883a(seconds, C0596d.this.mo8066x())) {
                        hashSet.add(gVar);
                        C0596d.this.f376x.remove(gVar);
                    }
                }
                C0596d.this.m438a((Set<C0547g>) hashSet);
            }

            /* renamed from: b */
            public boolean mo8021b() {
                return !C0596d.this.f431v;
            }
        });
    }

    /* renamed from: c */
    public void mo8023c(String str) {
        m434a(C0536a.C0540c.ERROR, C0543d.MEDIA_FILE_ERROR);
        super.mo8023c(str);
    }

    /* renamed from: d */
    public void mo7983d() {
        super.mo7983d();
        m435a(this.f431v ? C0536a.C0540c.COMPANION : C0536a.C0540c.VIDEO, "resume");
    }

    /* renamed from: e */
    public void mo7984e() {
        super.mo7984e();
        m435a(this.f431v ? C0536a.C0540c.COMPANION : C0536a.C0540c.VIDEO, "pause");
    }

    /* renamed from: f */
    public void mo7985f() {
        m435a(C0536a.C0540c.VIDEO, "close");
        m435a(C0536a.C0540c.COMPANION, "close");
        super.mo7985f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo7997r() {
        long j;
        int t;
        long j2 = 0;
        if (this.f375w.mo9034ab() >= 0 || this.f375w.mo9035ac() >= 0) {
            int i = (this.f375w.mo9034ab() > 0 ? 1 : (this.f375w.mo9034ab() == 0 ? 0 : -1));
            C0536a aVar = this.f375w;
            if (i >= 0) {
                j = aVar.mo9034ab();
            } else {
                C0550j l = aVar.mo7837l();
                if (l == null || l.mo7890b() <= 0) {
                    long j3 = this.f430u;
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
                double ac = (double) this.f375w.mo9035ac();
                Double.isNaN(ac);
                Double.isNaN(d);
                j = (long) (d * (ac / 100.0d));
            }
            mo7971a(j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo8024t() {
        this.f428s.mo8197c();
        super.mo8024t();
    }

    /* renamed from: u */
    public void mo8025u() {
        m435a(C0536a.C0540c.VIDEO, "skip");
        super.mo8025u();
    }

    /* renamed from: v */
    public void mo8026v() {
        super.mo8026v();
        m435a(C0536a.C0540c.VIDEO, this.f429t ? "mute" : "unmute");
    }

    /* renamed from: w */
    public void mo8027w() {
        m440y();
        if (!C0549i.m298c(this.f375w)) {
            this.f326c.mo9584b("InterActivityV2", "VAST ad does not have valid companion ad - dismissing...");
            mo7985f();
        } else if (!this.f431v) {
            m435a(C0536a.C0540c.COMPANION, "creativeView");
            super.mo8027w();
        }
    }
}
