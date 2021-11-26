package com.applovin.impl.adview;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.adview.C0653j;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.p018a.C0543d;
import com.applovin.impl.p018a.C0547g;
import com.applovin.impl.p018a.C0548h;
import com.applovin.impl.p018a.C0549i;
import com.applovin.impl.p018a.C0553k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.s */
public class C0713s extends C0668o {

    /* renamed from: a */
    private final Set<C0547g> f693a = new HashSet();

    /* renamed from: a */
    private void m793a() {
        if (isFullyWatched() && !this.f693a.isEmpty()) {
            C1107r rVar = this.logger;
            rVar.mo9587d("InterstitialActivity", "Firing " + this.f693a.size() + " un-fired video progress trackers when video was completed.");
            m798a(this.f693a);
        }
    }

    /* renamed from: a */
    private void m794a(C0536a.C0540c cVar) {
        m795a(cVar, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m795a(C0536a.C0540c cVar, C0543d dVar) {
        m797a(cVar, "", dVar);
    }

    /* renamed from: a */
    private void m796a(C0536a.C0540c cVar, String str) {
        m797a(cVar, str, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m797a(C0536a.C0540c cVar, String str, C0543d dVar) {
        if (isVastAd()) {
            m799a(((C0536a) this.currentAd).mo7813a(cVar, str), dVar);
        }
    }

    /* renamed from: a */
    private void m798a(Set<C0547g> set) {
        m799a(set, C0543d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m799a(Set<C0547g> set, C0543d dVar) {
        if (isVastAd() && set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.videoView.getCurrentPosition());
            C0553k m = m800b().mo7838m();
            Uri a = m != null ? m.mo7899a() : null;
            C1107r rVar = this.logger;
            rVar.mo9584b("InterstitialActivity", "Firing " + set.size() + " tracker(s): " + set);
            C0549i.m291a(set, seconds, a, dVar, this.sdk);
        }
    }

    /* renamed from: b */
    private C0536a m800b() {
        if (this.currentAd instanceof C0536a) {
            return (C0536a) this.currentAd;
        }
        return null;
    }

    public void clickThroughFromVideo(PointF pointF) {
        super.clickThroughFromVideo(pointF);
        m794a(C0536a.C0540c.VIDEO_CLICK);
    }

    public void dismiss() {
        if (isVastAd()) {
            m796a(C0536a.C0540c.VIDEO, "close");
            m796a(C0536a.C0540c.COMPANION, "close");
        }
        super.dismiss();
    }

    public void handleCountdownStep() {
        if (isVastAd()) {
            long seconds = ((long) this.computedLengthSeconds) - TimeUnit.MILLISECONDS.toSeconds((long) (this.videoView.getDuration() - this.videoView.getCurrentPosition()));
            HashSet hashSet = new HashSet();
            for (C0547g gVar : new HashSet(this.f693a)) {
                if (gVar.mo7883a(seconds, getVideoPercentViewed())) {
                    hashSet.add(gVar);
                    this.f693a.remove(gVar);
                }
            }
            m798a((Set<C0547g>) hashSet);
        }
    }

    public void handleMediaError(String str) {
        m795a(C0536a.C0540c.ERROR, C0543d.MEDIA_FILE_ERROR);
        super.handleMediaError(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isVastAd()) {
            C0536a b = m800b();
            C0536a.C0540c cVar = C0536a.C0540c.VIDEO;
            this.f693a.addAll(b.mo7814a(cVar, C0548h.f212a));
            m794a(C0536a.C0540c.IMPRESSION);
            m796a(cVar, "creativeView");
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        m796a(this.postitialWasDisplayed ? C0536a.C0540c.COMPANION : C0536a.C0540c.VIDEO, "pause");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m796a(this.postitialWasDisplayed ? C0536a.C0540c.COMPANION : C0536a.C0540c.VIDEO, "resume");
    }

    public void playVideo() {
        this.countdownManager.mo8195a("PROGRESS_TRACKING", ((Long) this.sdk.mo9350a(C0965b.f1811ed)).longValue(), (C0653j.C0655a) new C0653j.C0655a() {
            /* renamed from: a */
            public void mo8020a() {
                C0713s.this.handleCountdownStep();
            }

            /* renamed from: b */
            public boolean mo8021b() {
                return C0713s.this.shouldContinueFullLengthVideoCountdown();
            }
        });
        super.playVideo();
    }

    public void showPostitial() {
        if (isVastAd()) {
            m793a();
            if (!C0549i.m298c(m800b())) {
                dismiss();
                return;
            } else if (!this.postitialWasDisplayed) {
                m796a(C0536a.C0540c.COMPANION, "creativeView");
            } else {
                return;
            }
        }
        super.showPostitial();
    }

    public void skipVideo() {
        m796a(C0536a.C0540c.VIDEO, "skip");
        super.skipVideo();
    }

    public void toggleMute() {
        super.toggleMute();
        m796a(C0536a.C0540c.VIDEO, this.videoMuted ? "mute" : "unmute");
    }
}
