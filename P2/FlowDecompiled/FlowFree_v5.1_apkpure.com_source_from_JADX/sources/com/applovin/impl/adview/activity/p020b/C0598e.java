package com.applovin.impl.adview.activity.p020b;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
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
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.e */
public class C0598e extends C0578a {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final C0564a f378A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final C0666m f379B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final ImageView f380C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public final C0716u f381D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public final ProgressBar f382E;

    /* renamed from: F */
    private final C0607a f383F;

    /* renamed from: G */
    private final Handler f384G;

    /* renamed from: H */
    private final boolean f385H;

    /* renamed from: I */
    private long f386I;

    /* renamed from: J */
    private AtomicBoolean f387J;

    /* renamed from: K */
    private AtomicBoolean f388K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public long f389L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public long f390M;

    /* renamed from: r */
    protected final PlayerView f391r;

    /* renamed from: s */
    protected final SimpleExoPlayer f392s;

    /* renamed from: t */
    protected final C0653j f393t;

    /* renamed from: u */
    protected boolean f394u;

    /* renamed from: v */
    protected long f395v;

    /* renamed from: w */
    protected int f396w;

    /* renamed from: x */
    protected boolean f397x;

    /* renamed from: y */
    protected boolean f398y;

    /* renamed from: z */
    private final C0574c f399z = new C0574c(this.f324a, this.f327d, this.f325b);

    /* renamed from: com.applovin.impl.adview.activity.b.e$a */
    private class C0607a implements C0717v.C0718a {
        private C0607a() {
        }

        /* renamed from: a */
        public void mo8042a(C0716u uVar) {
            C0598e.this.f326c.mo9584b("InterActivityV2", "Clicking through from video button...");
            C0598e.this.mo8014a(uVar.getAndClearLastClickLocation());
        }

        /* renamed from: b */
        public void mo8043b(C0716u uVar) {
            C0598e.this.f326c.mo9584b("InterActivityV2", "Closing ad from video button...");
            C0598e.this.mo7985f();
        }

        /* renamed from: c */
        public void mo8044c(C0716u uVar) {
            C0598e.this.f326c.mo9584b("InterActivityV2", "Skipping video from video button...");
            C0598e.this.mo8017u();
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.e$b */
    private class C0608b implements AppLovinTouchToClickListener.OnClickListener, Player.EventListener, PlayerControlView.VisibilityListener {
        private C0608b() {
        }

        public void onClick(View view, PointF pointF) {
            C0598e.this.mo8014a(pointF);
        }

        public void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        }

        public void onIsLoadingChanged(boolean z) {
        }

        public void onIsPlayingChanged(boolean z) {
        }

        public void onLoadingChanged(boolean z) {
        }

        public void onMediaItemTransition(MediaItem mediaItem, int i) {
        }

        public void onPlayWhenReadyChanged(boolean z, int i) {
        }

        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        public void onPlaybackStateChanged(int i) {
            C1107r rVar = C0598e.this.f326c;
            rVar.mo9584b("InterActivityV2", "Player state changed to state " + i + " and will play when ready: " + C0598e.this.f392s.getPlayWhenReady());
            if (i == 2) {
                if (C0598e.this.f378A != null) {
                    C0598e.this.f378A.mo7946a();
                }
                C0598e.this.f328e.mo9181g();
            } else if (i == 3) {
                C0598e eVar = C0598e.this;
                eVar.f392s.setVolume(eVar.f394u ^ true ? 1.0f : 0.0f);
                C0598e eVar2 = C0598e.this;
                eVar2.f395v = eVar2.f392s.getDuration();
                C0598e.this.mo7997r();
                C1107r rVar2 = C0598e.this.f326c;
                rVar2.mo9584b("InterActivityV2", "MediaPlayer prepared: " + C0598e.this.f392s);
                C0598e.this.f393t.mo8194a();
                if (C0598e.this.f379B != null) {
                    C0598e.this.mo8033y();
                }
                if (C0598e.this.f378A != null) {
                    C0598e.this.f378A.mo7947b();
                }
                if (C0598e.this.f338o.mo9099d()) {
                    C0598e.this.mo8016t();
                }
            } else if (i == 4) {
                C0598e.this.f326c.mo9584b("InterActivityV2", "Video completed");
                C0598e eVar3 = C0598e.this;
                eVar3.f398y = true;
                eVar3.mo8019w();
            }
        }

        public void onPlaybackSuppressionReasonChanged(int i) {
        }

        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            C0598e eVar = C0598e.this;
            eVar.mo8015c("Video view error (" + exoPlaybackException + ")");
            C0598e.this.mo7985f();
        }

        public void onPlayerStateChanged(boolean z, int i) {
        }

        public void onPositionDiscontinuity(int i) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSeekProcessed() {
        }

        public void onShuffleModeEnabledChanged(boolean z) {
        }

        public void onTimelineChanged(Timeline timeline, int i) {
        }

        public void onTimelineChanged(Timeline timeline, Object obj, int i) {
        }

        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        }

        public void onVisibilityChange(int i) {
            if (i == 0) {
                C0598e.this.f391r.hideController();
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.e$c */
    private class C0609c implements View.OnClickListener {
        private C0609c() {
        }

        public void onClick(View view) {
            if (view == C0598e.this.f379B) {
                if (C0598e.this.mo7995p()) {
                    C0598e.this.mo8016t();
                    C0598e.this.mo7992m();
                    C0598e.this.f338o.mo9097b();
                    return;
                }
                C0598e.this.mo8017u();
            } else if (view == C0598e.this.f380C) {
                C0598e.this.mo8018v();
            } else {
                C1107r rVar = C0598e.this.f326c;
                rVar.mo9588e("InterActivityV2", "Unhandled click on widget: " + view);
            }
        }
    }

    public C0598e(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        C0607a aVar = new C0607a();
        this.f383F = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f384G = handler;
        C0653j jVar = new C0653j(handler, this.f325b);
        this.f393t = jVar;
        boolean e = this.f324a.mo7826e();
        this.f385H = e;
        this.f394u = mo7998s();
        this.f386I = -1;
        this.f387J = new AtomicBoolean();
        this.f388K = new AtomicBoolean();
        this.f389L = -2;
        this.f390M = 0;
        if (gVar.hasVideoUrl()) {
            C0609c cVar = new C0609c();
            if (gVar.mo9066r() >= 0) {
                C0666m mVar = new C0666m(gVar.mo9070v(), appLovinFullscreenActivity);
                this.f379B = mVar;
                mVar.setVisibility(8);
                mVar.setOnClickListener(cVar);
            } else {
                this.f379B = null;
            }
            if (m457a(this.f394u, kVar)) {
                ImageView imageView = new ImageView(appLovinFullscreenActivity);
                this.f380C = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(cVar);
                mo8031d(this.f394u);
            } else {
                this.f380C = null;
            }
            String A = gVar.mo8993A();
            if (C1155o.m2673b(A)) {
                C0717v vVar = new C0717v(kVar);
                vVar.mo8300a(new WeakReference(aVar));
                C0716u uVar = new C0716u(vVar, appLovinFullscreenActivity);
                this.f381D = uVar;
                uVar.mo8299a(A);
            } else {
                this.f381D = null;
            }
            if (e) {
                C0564a aVar2 = new C0564a(appLovinFullscreenActivity, ((Integer) kVar.mo9350a(C0965b.f1684cD)).intValue(), 16842874);
                this.f378A = aVar2;
                aVar2.setColor(Color.parseColor("#75FFFFFF"));
                aVar2.setBackgroundColor(Color.parseColor("#00000000"));
                aVar2.setVisibility(8);
            } else {
                this.f378A = null;
            }
            if (gVar.mo9004M()) {
                ProgressBar progressBar = new ProgressBar(appLovinFullscreenActivity, (AttributeSet) null, 16842872);
                this.f382E = progressBar;
                progressBar.setMax(10000);
                progressBar.setPadding(0, 0, 0, 0);
                if (C1119g.m2531d()) {
                    progressBar.setProgressTintList(ColorStateList.valueOf(gVar.mo9005N()));
                }
                jVar.mo8195a("PROGRESS_BAR", ((Long) kVar.mo9350a(C0965b.f1731cy)).longValue(), (C0653j.C0655a) new C0653j.C0655a() {
                    /* renamed from: a */
                    public void mo8020a() {
                        C0598e eVar = C0598e.this;
                        if (eVar.f397x) {
                            eVar.f382E.setVisibility(8);
                            return;
                        }
                        C0598e eVar2 = C0598e.this;
                        eVar2.f382E.setProgress((int) ((((float) eVar.f392s.getCurrentPosition()) / ((float) eVar2.f395v)) * 10000.0f));
                    }

                    /* renamed from: b */
                    public boolean mo8021b() {
                        return !C0598e.this.f397x;
                    }
                });
            } else {
                this.f382E = null;
            }
            SimpleExoPlayer build = new SimpleExoPlayer.Builder(appLovinFullscreenActivity).build();
            this.f392s = build;
            C0608b bVar = new C0608b();
            build.addListener(bVar);
            build.setRepeatMode(0);
            PlayerView playerView = new PlayerView(appLovinFullscreenActivity);
            this.f391r = playerView;
            playerView.hideController();
            playerView.setControllerVisibilityListener(bVar);
            playerView.setPlayer(build);
            playerView.setOnTouchListener(new AppLovinTouchToClickListener(kVar, C0965b.f1583aH, appLovinFullscreenActivity, bVar));
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    /* renamed from: C */
    private void m454C() {
        C0716u uVar;
        C0715t B = this.f324a.mo8994B();
        if (B != null && B.mo8290e() && !this.f397x && (uVar = this.f381D) != null) {
            final boolean z = uVar.getVisibility() == 4;
            final long f = B.mo8292f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        C1163s.m2766a((View) C0598e.this.f381D, f, (Runnable) null);
                    } else {
                        C1163s.m2771b(C0598e.this.f381D, f, (Runnable) null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private static boolean m457a(boolean z, C1062k kVar) {
        if (!((Boolean) kVar.mo9350a(C0965b.f1722cp)).booleanValue()) {
            return false;
        }
        if (!((Boolean) kVar.mo9350a(C0965b.f1723cq)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) kVar.mo9350a(C0965b.f1725cs)).booleanValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void mo8028A() {
        C1107r rVar;
        String str;
        if (this.f397x) {
            rVar = this.f326c;
            str = "Skip video resume - postitial shown";
        } else if (this.f325b.mo9368ac().mo9718a()) {
            rVar = this.f326c;
            str = "Skip video resume - app paused";
        } else {
            long j = this.f386I;
            if (j >= 0) {
                long aJ = this.f324a.mo9031aJ();
                if (aJ > 0) {
                    j = Math.max(0, j - aJ);
                    this.f392s.seekTo(j);
                }
                C1107r rVar2 = this.f326c;
                rVar2.mo9584b("InterActivityV2", "Resuming video at position " + j + "ms for MediaPlayer: " + this.f392s);
                this.f392s.setPlayWhenReady(true);
                this.f393t.mo8194a();
                this.f386I = -1;
                if (!this.f392s.isPlaying()) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            if (C0598e.this.f378A != null) {
                                C0598e.this.f378A.mo7946a();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            C1107r rVar3 = this.f326c;
            rVar3.mo9584b("InterActivityV2", "Invalid last video position, isVideoPlaying=" + this.f392s.isPlaying());
            return;
        }
        rVar.mo9587d("InterActivityV2", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public int mo8029B() {
        long currentPosition = this.f392s.getCurrentPosition();
        if (this.f398y) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.f395v)) * 100.0f) : this.f396w;
    }

    /* renamed from: a */
    public void mo8010a() {
        this.f326c.mo9584b("InterActivityV2", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8014a(PointF pointF) {
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
        m454C();
    }

    /* renamed from: b */
    public void mo8011b() {
        this.f326c.mo9584b("InterActivityV2", "Skipping video from prompt");
        mo8017u();
    }

    /* renamed from: b */
    public void mo8030b(long j) {
        mo7974a((Runnable) new Runnable() {
            public void run() {
                C0598e.this.mo8028A();
            }
        }, j);
    }

    /* renamed from: c */
    public void mo7981c() {
        this.f399z.mo7964a(this.f380C, this.f379B, this.f381D, this.f378A, this.f382E, this.f391r, this.f329f);
        mo7977a(!this.f385H);
        mo8032x();
        if (this.f385H) {
            this.f378A.mo7946a();
        }
        this.f329f.renderAd(this.f324a);
        this.f328e.mo9174b(this.f385H ? 1 : 0);
        if (this.f379B != null) {
            this.f325b.mo9340Q().mo9268a((C0989a) new C1042y(this.f325b, new Runnable() {
                public void run() {
                    C0598e.this.mo8033y();
                }
            }), C1020o.C1022a.MAIN, this.f324a.mo9067s(), true);
        }
        super.mo7980b(this.f394u);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8015c(String str) {
        C1107r rVar = this.f326c;
        rVar.mo9588e("InterActivityV2", "Encountered media error: " + str + " for ad: " + this.f324a);
        if (this.f387J.compareAndSet(false, true)) {
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
            mo8030b(((Boolean) this.f325b.mo9350a(C0965b.f1795eK)).booleanValue() ? 0 : 250);
        } else if (!this.f397x) {
            mo8016t();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo8031d(boolean z) {
        if (C1119g.m2531d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f327d.getDrawable(z ? C1199R.C1200drawable.unmute_to_mute : C1199R.C1200drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f380C.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f380C.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aD = z ? this.f324a.mo9025aD() : this.f324a.mo9026aE();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f380C.setImageURI(aD);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: f */
    public void mo7985f() {
        this.f393t.mo8196b();
        this.f384G.removeCallbacksAndMessages((Object) null);
        mo7990k();
        super.mo7985f();
    }

    /* renamed from: h */
    public void mo7987h() {
        this.f392s.release();
        super.mo7987h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo7990k() {
        super.mo7970a(mo8029B(), this.f385H, mo7994o(), this.f389L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public boolean mo7994o() {
        return mo8029B() >= this.f324a.mo9006O();
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
                long j3 = this.f395v;
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
    public void mo8016t() {
        String str;
        C1107r rVar;
        this.f326c.mo9584b("InterActivityV2", "Pausing video");
        if (this.f392s.isPlaying()) {
            this.f386I = this.f392s.getCurrentPosition();
            this.f392s.setPlayWhenReady(false);
            this.f393t.mo8197c();
            rVar = this.f326c;
            str = "Paused video at position " + this.f386I + "ms";
        } else {
            rVar = this.f326c;
            str = "Nothing to pause";
        }
        rVar.mo9584b("InterActivityV2", str);
    }

    /* renamed from: u */
    public void mo8017u() {
        this.f389L = SystemClock.elapsedRealtime() - this.f390M;
        C1107r rVar = this.f326c;
        rVar.mo9584b("InterActivityV2", "Skipping video with skip time: " + this.f389L + "ms");
        this.f328e.mo9180f();
        if (this.f324a.mo9071w()) {
            mo7985f();
        } else {
            mo8019w();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public void mo8018v() {
        boolean z = !this.f394u;
        this.f394u = z;
        this.f392s.setVolume(z ^ true ? 1.0f : 0.0f);
        mo8031d(this.f394u);
        mo7978a(this.f394u, 0);
    }

    /* renamed from: w */
    public void mo8019w() {
        mo8034z();
        this.f399z.mo7965a(this.f330g, this.f329f);
        mo7976a("javascript:al_onPoststitialShow();", (long) this.f324a.mo9008Q());
        if (this.f330g != null) {
            int i = (this.f324a.mo9068t() > 0 ? 1 : (this.f324a.mo9068t() == 0 ? 0 : -1));
            C0666m mVar = this.f330g;
            if (i >= 0) {
                mo7973a(mVar, this.f324a.mo9068t(), new Runnable() {
                    public void run() {
                        C0598e.this.f332i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.f397x = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void mo8032x() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = this.f327d;
        this.f392s.setMediaSource(new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(appLovinFullscreenActivity, Util.getUserAgent(appLovinFullscreenActivity, "com.applovin.sdk"))).createMediaSource(MediaItem.fromUri(this.f324a.mo7829g())));
        this.f392s.prepare();
        this.f392s.setPlayWhenReady(true);
        if (this.f324a.mo9044al()) {
            this.f338o.mo9095a(this.f324a, (Runnable) new Runnable() {
                public void run() {
                    C0598e.this.mo8030b(250);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public void mo8033y() {
        if (this.f388K.compareAndSet(false, true)) {
            mo7973a(this.f379B, this.f324a.mo9066r(), new Runnable() {
                public void run() {
                    long unused = C0598e.this.f389L = -1;
                    long unused2 = C0598e.this.f390M = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void mo8034z() {
        this.f396w = mo8029B();
        this.f392s.setPlayWhenReady(false);
    }
}
