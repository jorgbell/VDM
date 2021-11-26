package com.applovin.impl.adview.activity.p020b;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.C0564a;
import com.applovin.impl.adview.C0653j;
import com.applovin.impl.adview.C0666m;
import com.applovin.impl.adview.C0715t;
import com.applovin.impl.adview.C0716u;
import com.applovin.impl.adview.C0717v;
import com.applovin.impl.adview.activity.p019a.C0574c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p035a.C0941i;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1163s;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1199R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.f */
public class C0610f extends C0578a {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final ImageView f413A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final C0716u f414B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final ProgressBar f415C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public final C0621b f416D;

    /* renamed from: E */
    private final C0620a f417E;

    /* renamed from: F */
    private final Handler f418F;

    /* renamed from: G */
    private final boolean f419G;

    /* renamed from: H */
    private int f420H;

    /* renamed from: I */
    private int f421I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public boolean f422J;

    /* renamed from: K */
    private AtomicBoolean f423K;

    /* renamed from: L */
    private AtomicBoolean f424L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public long f425M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public long f426N;

    /* renamed from: r */
    protected final AppLovinVideoView f427r;

    /* renamed from: s */
    protected final C0653j f428s;

    /* renamed from: t */
    protected boolean f429t;

    /* renamed from: u */
    protected long f430u;

    /* renamed from: v */
    protected boolean f431v;

    /* renamed from: w */
    private final C0574c f432w = new C0574c(this.f324a, this.f327d, this.f325b);
    /* access modifiers changed from: private */

    /* renamed from: x */
    public MediaPlayer f433x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final C0564a f434y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final C0666m f435z;

    /* renamed from: com.applovin.impl.adview.activity.b.f$a */
    private class C0620a implements C0717v.C0718a {
        private C0620a() {
        }

        /* renamed from: a */
        public void mo8042a(C0716u uVar) {
            C0610f.this.f326c.mo9584b("InterActivityV2", "Clicking through from video button...");
            C0610f.this.mo8022a(uVar.getAndClearLastClickLocation());
        }

        /* renamed from: b */
        public void mo8043b(C0716u uVar) {
            C0610f.this.f326c.mo9584b("InterActivityV2", "Closing ad from video button...");
            C0610f.this.mo7985f();
        }

        /* renamed from: c */
        public void mo8044c(C0716u uVar) {
            C0610f.this.f326c.mo9584b("InterActivityV2", "Skipping video from video button...");
            C0610f.this.mo8025u();
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.f$b */
    private class C0621b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        private C0621b() {
        }

        public void onClick(View view, PointF pointF) {
            C0610f.this.mo8022a(pointF);
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            C0610f.this.f326c.mo9584b("InterActivityV2", "Video completed");
            boolean unused = C0610f.this.f422J = true;
            C0610f.this.mo8027w();
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C0610f fVar = C0610f.this;
            fVar.mo8023c("Video view error (" + i + "," + i2 + ")");
            C0610f.this.f427r.start();
            return true;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            C1107r rVar = C0610f.this.f326c;
            rVar.mo9584b("InterActivityV2", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            if (i == 701) {
                if (C0610f.this.f434y != null) {
                    C0610f.this.f434y.mo7946a();
                }
                C0610f.this.f328e.mo9181g();
                return false;
            } else if (i == 3) {
                C0610f.this.f428s.mo8194a();
                if (C0610f.this.f435z != null) {
                    C0610f.this.m508y();
                }
                if (C0610f.this.f434y != null) {
                    C0610f.this.f434y.mo7947b();
                }
                if (!C0610f.this.f338o.mo9099d()) {
                    return false;
                }
                C0610f.this.mo8024t();
                return false;
            } else if (i != 702 || C0610f.this.f434y == null) {
                return false;
            } else {
                C0610f.this.f434y.mo7947b();
                return false;
            }
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer unused = C0610f.this.f433x = mediaPlayer;
            mediaPlayer.setOnInfoListener(C0610f.this.f416D);
            mediaPlayer.setOnErrorListener(C0610f.this.f416D);
            float f = C0610f.this.f429t ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            C0610f.this.f430u = (long) mediaPlayer.getDuration();
            C0610f.this.mo7997r();
            C1107r rVar = C0610f.this.f326c;
            rVar.mo9584b("InterActivityV2", "MediaPlayer prepared: " + C0610f.this.f433x);
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.f$c */
    private class C0622c implements View.OnClickListener {
        private C0622c() {
        }

        public void onClick(View view) {
            if (view == C0610f.this.f435z) {
                if (C0610f.this.mo7995p()) {
                    C0610f.this.mo8024t();
                    C0610f.this.mo7992m();
                    C0610f.this.f338o.mo9097b();
                    return;
                }
                C0610f.this.mo8025u();
            } else if (view == C0610f.this.f413A) {
                C0610f.this.mo8026v();
            } else {
                C1107r rVar = C0610f.this.f326c;
                rVar.mo9588e("InterActivityV2", "Unhandled click on widget: " + view);
            }
        }
    }

    public C0610f(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        C0621b bVar = new C0621b();
        this.f416D = bVar;
        C0620a aVar = new C0620a();
        this.f417E = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f418F = handler;
        C0653j jVar = new C0653j(handler, this.f325b);
        this.f428s = jVar;
        boolean e = this.f324a.mo7826e();
        this.f419G = e;
        this.f429t = mo7998s();
        this.f421I = -1;
        this.f423K = new AtomicBoolean();
        this.f424L = new AtomicBoolean();
        this.f425M = -2;
        this.f426N = 0;
        if (gVar.hasVideoUrl()) {
            AppLovinVideoView appLovinVideoView = new AppLovinVideoView(appLovinFullscreenActivity, kVar);
            this.f427r = appLovinVideoView;
            appLovinVideoView.setOnPreparedListener(bVar);
            appLovinVideoView.setOnCompletionListener(bVar);
            appLovinVideoView.setOnErrorListener(bVar);
            appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(kVar, C0965b.f1583aH, appLovinFullscreenActivity, bVar));
            C0622c cVar = new C0622c();
            if (gVar.mo9066r() >= 0) {
                C0666m mVar = new C0666m(gVar.mo9070v(), appLovinFullscreenActivity);
                this.f435z = mVar;
                mVar.setVisibility(8);
                mVar.setOnClickListener(cVar);
            } else {
                this.f435z = null;
            }
            if (m496a(this.f429t, kVar)) {
                ImageView imageView = new ImageView(appLovinFullscreenActivity);
                this.f413A = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(cVar);
                m503e(this.f429t);
            } else {
                this.f413A = null;
            }
            String A = gVar.mo8993A();
            if (C1155o.m2673b(A)) {
                C0717v vVar = new C0717v(kVar);
                vVar.mo8300a(new WeakReference(aVar));
                C0716u uVar = new C0716u(vVar, appLovinFullscreenActivity);
                this.f414B = uVar;
                uVar.mo8299a(A);
            } else {
                this.f414B = null;
            }
            if (e) {
                C0564a aVar2 = new C0564a(appLovinFullscreenActivity, ((Integer) kVar.mo9350a(C0965b.f1684cD)).intValue(), 16842874);
                this.f434y = aVar2;
                aVar2.setColor(Color.parseColor("#75FFFFFF"));
                aVar2.setBackgroundColor(Color.parseColor("#00000000"));
                aVar2.setVisibility(8);
            } else {
                this.f434y = null;
            }
            if (gVar.mo9004M()) {
                ProgressBar progressBar = new ProgressBar(appLovinFullscreenActivity, (AttributeSet) null, 16842872);
                this.f415C = progressBar;
                progressBar.setMax(10000);
                progressBar.setPadding(0, 0, 0, 0);
                if (C1119g.m2531d()) {
                    progressBar.setProgressTintList(ColorStateList.valueOf(gVar.mo9005N()));
                }
                jVar.mo8195a("PROGRESS_BAR", ((Long) kVar.mo9350a(C0965b.f1731cy)).longValue(), (C0653j.C0655a) new C0653j.C0655a() {
                    /* renamed from: a */
                    public void mo8020a() {
                        C0610f fVar = C0610f.this;
                        if (fVar.f431v) {
                            fVar.f415C.setVisibility(8);
                            return;
                        }
                        C0610f fVar2 = C0610f.this;
                        fVar2.f415C.setProgress((int) ((((float) fVar.f427r.getCurrentPosition()) / ((float) fVar2.f430u)) * 10000.0f));
                    }

                    /* renamed from: b */
                    public boolean mo8021b() {
                        return !C0610f.this.f431v;
                    }
                });
                return;
            }
            this.f415C = null;
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m491A() {
        C1107r rVar;
        String str;
        if (this.f431v) {
            rVar = this.f326c;
            str = "Skip video resume - postitial shown";
        } else if (this.f325b.mo9368ac().mo9718a()) {
            rVar = this.f326c;
            str = "Skip video resume - app paused";
        } else if (this.f421I >= 0) {
            C1107r rVar2 = this.f326c;
            rVar2.mo9584b("InterActivityV2", "Resuming video at position " + this.f421I + "ms for MediaPlayer: " + this.f433x);
            this.f427r.seekTo(this.f421I);
            this.f427r.start();
            this.f428s.mo8194a();
            this.f421I = -1;
            mo7974a((Runnable) new Runnable() {
                public void run() {
                    if (C0610f.this.f434y != null) {
                        C0610f.this.f434y.mo7946a();
                        C0610f.this.mo7974a((Runnable) new Runnable() {
                            public void run() {
                                C0610f.this.f434y.mo7947b();
                            }
                        }, 2000);
                    }
                }
            }, 250);
            return;
        } else {
            this.f326c.mo9584b("InterActivityV2", "Invalid last video position");
            return;
        }
        rVar.mo9587d("InterActivityV2", str);
    }

    /* renamed from: a */
    private static boolean m496a(boolean z, C1062k kVar) {
        if (!((Boolean) kVar.mo9350a(C0965b.f1722cp)).booleanValue()) {
            return false;
        }
        if (!((Boolean) kVar.mo9350a(C0965b.f1723cq)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) kVar.mo9350a(C0965b.f1725cs)).booleanValue();
    }

    /* renamed from: d */
    private void m501d(boolean z) {
        this.f420H = mo8066x();
        if (z) {
            this.f427r.pause();
        } else {
            this.f427r.stopPlayback();
        }
    }

    /* renamed from: e */
    private void m503e(boolean z) {
        if (C1119g.m2531d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f327d.getDrawable(z ? C1199R.C1200drawable.unmute_to_mute : C1199R.C1200drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f413A.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f413A.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aD = z ? this.f324a.mo9025aD() : this.f324a.mo9026aE();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f413A.setImageURI(aD);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m508y() {
        if (this.f424L.compareAndSet(false, true)) {
            mo7973a(this.f435z, this.f324a.mo9066r(), new Runnable() {
                public void run() {
                    long unused = C0610f.this.f425M = -1;
                    long unused2 = C0610f.this.f426N = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* renamed from: z */
    private void m509z() {
        C0716u uVar;
        C0715t B = this.f324a.mo8994B();
        if (B != null && B.mo8290e() && !this.f431v && (uVar = this.f414B) != null) {
            final boolean z = uVar.getVisibility() == 4;
            final long f = B.mo8292f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        C1163s.m2766a((View) C0610f.this.f414B, f, (Runnable) null);
                    } else {
                        C1163s.m2771b(C0610f.this.f414B, f, (Runnable) null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo8010a() {
        this.f326c.mo9584b("InterActivityV2", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8022a(PointF pointF) {
        if (this.f324a.mo7812C()) {
            this.f326c.mo9584b("InterActivityV2", "Clicking through video");
            Uri j = this.f324a.mo7835j();
            if (j != null) {
                C1124k.m2615a(this.f335l, (AppLovinAd) this.f324a);
                this.f325b.mo9404t().trackAndLaunchVideoClick(this.f324a, this.f329f, j, pointF);
                this.f328e.mo9173b();
                return;
            }
            return;
        }
        m509z();
    }

    /* renamed from: b */
    public void mo8011b() {
        this.f326c.mo9584b("InterActivityV2", "Skipping video from prompt");
        mo8025u();
    }

    /* renamed from: b */
    public void mo8065b(long j) {
        mo7974a((Runnable) new Runnable() {
            public void run() {
                C0610f.this.m491A();
            }
        }, j);
    }

    /* renamed from: c */
    public void mo7981c() {
        this.f432w.mo7964a(this.f413A, this.f435z, this.f414B, this.f434y, this.f415C, this.f427r, this.f329f);
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        mo7977a(!this.f419G);
        this.f427r.setVideoURI(this.f324a.mo7829g());
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (this.f324a.mo9044al()) {
            this.f338o.mo9095a(this.f324a, (Runnable) new Runnable() {
                public void run() {
                    C0610f.this.mo8065b(250);
                }
            });
        }
        this.f427r.start();
        if (this.f419G) {
            this.f434y.mo7946a();
        }
        this.f329f.renderAd(this.f324a);
        this.f328e.mo9174b(this.f419G ? 1 : 0);
        if (this.f435z != null) {
            this.f325b.mo9340Q().mo9268a((C0989a) new C1042y(this.f325b, new Runnable() {
                public void run() {
                    C0610f.this.m508y();
                }
            }), C1020o.C1022a.MAIN, this.f324a.mo9067s(), true);
        }
        super.mo7980b(this.f429t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8023c(String str) {
        C1107r rVar = this.f326c;
        rVar.mo9588e("InterActivityV2", "Encountered media error: " + str + " for ad: " + this.f324a);
        if (this.f423K.compareAndSet(false, true)) {
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.f336m;
            if (appLovinAdDisplayListener instanceof C0941i) {
                ((C0941i) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            mo7985f();
        }
    }

    /* renamed from: c */
    public void mo7982c(boolean z) {
        super.mo7982c(z);
        if (z) {
            mo8065b(((Boolean) this.f325b.mo9350a(C0965b.f1795eK)).booleanValue() ? 0 : 250);
        } else if (!this.f431v) {
            mo8024t();
        }
    }

    /* renamed from: f */
    public void mo7985f() {
        this.f428s.mo8196b();
        this.f418F.removeCallbacksAndMessages((Object) null);
        mo7990k();
        super.mo7985f();
    }

    /* renamed from: h */
    public void mo7987h() {
        this.f326c.mo9586c("InterActivityV2", "Destroying video components");
        try {
            AppLovinVideoView appLovinVideoView = this.f427r;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.f427r.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.f433x;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            Log.e("InterActivityV2", "Unable to destroy presenter", th);
        }
        super.mo7987h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo7990k() {
        super.mo7970a(mo8066x(), this.f419G, mo7994o(), this.f425M);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public boolean mo7994o() {
        return mo8066x() >= this.f324a.mo9006O();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo7995p() {
        return mo7996q() && !mo7994o();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo7997r() {
        long j;
        int k;
        long j2 = 0;
        if (this.f324a.mo9034ab() >= 0 || this.f324a.mo9035ac() >= 0) {
            int i = (this.f324a.mo9034ab() > 0 ? 1 : (this.f324a.mo9034ab() == 0 ? 0 : -1));
            C0934g gVar = this.f324a;
            if (i >= 0) {
                j = gVar.mo9034ab();
            } else {
                C0924a aVar = (C0924a) gVar;
                long j3 = this.f430u;
                if (j3 > 0) {
                    j2 = 0 + j3;
                }
                if (aVar.mo9036ad() && ((k = (int) ((C0924a) this.f324a).mo8959k()) > 0 || (k = (int) aVar.mo9068t()) > 0)) {
                    j2 += TimeUnit.SECONDS.toMillis((long) k);
                }
                double d = (double) j2;
                double ac = (double) this.f324a.mo9035ac();
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
        this.f326c.mo9584b("InterActivityV2", "Pausing video");
        this.f421I = this.f427r.getCurrentPosition();
        this.f427r.pause();
        this.f428s.mo8197c();
        C1107r rVar = this.f326c;
        rVar.mo9584b("InterActivityV2", "Paused video at position " + this.f421I + "ms");
    }

    /* renamed from: u */
    public void mo8025u() {
        this.f425M = SystemClock.elapsedRealtime() - this.f426N;
        C1107r rVar = this.f326c;
        rVar.mo9584b("InterActivityV2", "Skipping video with skip time: " + this.f425M + "ms");
        this.f328e.mo9180f();
        if (this.f324a.mo9071w()) {
            mo7985f();
        } else {
            mo8027w();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public void mo8026v() {
        MediaPlayer mediaPlayer = this.f433x;
        if (mediaPlayer != null) {
            boolean z = !this.f429t;
            this.f429t = z;
            float f = z ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            m503e(this.f429t);
            mo7978a(this.f429t, 0);
        }
    }

    /* renamed from: w */
    public void mo8027w() {
        this.f326c.mo9584b("InterActivityV2", "Showing postitial...");
        m501d(this.f324a.mo9032aK());
        this.f432w.mo7965a(this.f330g, this.f329f);
        mo7976a("javascript:al_onPoststitialShow();", (long) this.f324a.mo9008Q());
        if (this.f330g != null) {
            int i = (this.f324a.mo9068t() > 0 ? 1 : (this.f324a.mo9068t() == 0 ? 0 : -1));
            C0666m mVar = this.f330g;
            if (i >= 0) {
                mo7973a(mVar, this.f324a.mo9068t(), new Runnable() {
                    public void run() {
                        C0610f.this.f332i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.f431v = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public int mo8066x() {
        long currentPosition = (long) this.f427r.getCurrentPosition();
        if (this.f422J) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.f430u)) * 100.0f) : this.f420H;
    }
}
