package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.C0653j;
import com.applovin.impl.adview.C0717v;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1044f;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p035a.C0940h;
import com.applovin.impl.sdk.p035a.C0941i;
import com.applovin.impl.sdk.p036b.C0951b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1112a;
import com.applovin.impl.sdk.utils.C1113b;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1157p;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1199R;
import com.mopub.common.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.o */
public abstract class C0668o extends Activity implements C0657k, C1044f.C1046a {
    public static volatile C0703p lastKnownWrapper;

    /* renamed from: A */
    private final Handler f574A = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final Handler f575B = new Handler(Looper.getMainLooper());

    /* renamed from: C */
    private FrameLayout f576C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public C0651i f577D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public View f578E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C0651i f579F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public View f580G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public C0648g f581H;

    /* renamed from: I */
    private ImageView f582I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public WeakReference<MediaPlayer> f583J = new WeakReference<>((Object) null);

    /* renamed from: K */
    private C0951b f584K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public C0716u f585L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public ProgressBar f586M;

    /* renamed from: N */
    private C0717v.C0718a f587N;

    /* renamed from: O */
    private C0564a f588O;

    /* renamed from: P */
    private C1157p f589P;

    /* renamed from: Q */
    private C1112a f590Q;

    /* renamed from: R */
    private AppLovinBroadcastManager.Receiver f591R;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0667n f592a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0703p f593b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0981d f594c;
    protected int computedLengthSeconds = 0;
    protected C0653j countdownManager;
    public volatile C0934g currentAd;

    /* renamed from: d */
    private volatile boolean f595d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f596e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f597f = false;

    /* renamed from: g */
    private volatile boolean f598g = false;

    /* renamed from: h */
    private volatile boolean f599h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f600i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile boolean f601j = false;

    /* renamed from: k */
    private boolean f602k = false;

    /* renamed from: l */
    private volatile boolean f603l = false;
    public C1107r logger;

    /* renamed from: m */
    private boolean f604m = true;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f605n = false;

    /* renamed from: o */
    private long f606o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f607p = 0;
    protected volatile boolean postitialWasDisplayed = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f608q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f609r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f610s = -2;
    public C1062k sdk;

    /* renamed from: t */
    private int f611t = 0;

    /* renamed from: u */
    private int f612u = Integer.MIN_VALUE;

    /* renamed from: v */
    private AtomicBoolean f613v = new AtomicBoolean(false);
    protected volatile boolean videoMuted = false;
    public AppLovinVideoView videoView;

    /* renamed from: w */
    private AtomicBoolean f614w = new AtomicBoolean(false);

    /* renamed from: x */
    private AtomicBoolean f615x = new AtomicBoolean(false);

    /* renamed from: y */
    private int f616y = C1044f.f2116a;

    /* renamed from: z */
    private boolean f617z;

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m655A() {
        if (m660C()) {
            m674M();
            pauseReportRewardTask();
            this.logger.mo9584b("InterActivity", "Prompting incentivized ad close warning");
            this.f584K.mo9097b();
            return;
        }
        skipVideo();
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m658B() {
        C0638d p;
        if (this.currentAd.mo9011T() && (p = this.f592a.getAdViewController().mo8109p()) != null) {
            p.mo8128a("javascript:al_onCloseButtonTapped();");
        }
        if (m661D()) {
            this.logger.mo9584b("InterActivity", "Prompting incentivized non-video ad close warning");
            this.f584K.mo9098c();
            return;
        }
        dismiss();
    }

    /* renamed from: C */
    private boolean m660C() {
        return m668G() && !isFullyWatched() && ((Boolean) this.sdk.mo9350a(C0965b.f1668bn)).booleanValue() && this.f584K != null;
    }

    /* renamed from: D */
    private boolean m661D() {
        return m669H() && !m666F() && ((Boolean) this.sdk.mo9350a(C0965b.f1673bs)).booleanValue() && this.f584K != null;
    }

    /* renamed from: E */
    private int m663E() {
        if (!(this.currentAd instanceof C0924a)) {
            return 0;
        }
        float k = ((C0924a) this.currentAd).mo8959k();
        if (k <= 0.0f) {
            k = (float) this.currentAd.mo9068t();
        }
        double a = C1160r.m2699a(System.currentTimeMillis() - this.f606o);
        double d = (double) k;
        Double.isNaN(d);
        return (int) Math.min((a / d) * 100.0d, 100.0d);
    }

    /* renamed from: F */
    private boolean m666F() {
        return m663E() >= this.currentAd.mo9006O();
    }

    /* renamed from: G */
    private boolean m668G() {
        return AppLovinAdType.INCENTIVIZED.equals(this.currentAd.getType());
    }

    /* renamed from: H */
    private boolean m669H() {
        return !this.currentAd.hasVideoUrl() && m668G();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r1 > 0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0098, code lost:
        if (r1 > 0) goto L_0x008a;
     */
    /* renamed from: I */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m670I() {
        /*
            r7 = this;
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            if (r0 == 0) goto L_0x00df
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            long r0 = r0.mo9034ab()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0018
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            int r0 = r0.mo9035ac()
            if (r0 < 0) goto L_0x00df
        L_0x0018:
            com.applovin.impl.sdk.utils.p r0 = r7.f589P
            if (r0 != 0) goto L_0x00df
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            long r0 = r0.mo9034ab()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x002e
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            long r0 = r0.mo9034ab()
            goto L_0x00af
        L_0x002e:
            boolean r0 = r7.isVastAd()
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            com.applovin.impl.a.a r0 = (com.applovin.impl.p018a.C0536a) r0
            com.applovin.impl.a.j r1 = r0.mo7837l()
            if (r1 == 0) goto L_0x0051
            int r4 = r1.mo7890b()
            if (r4 <= 0) goto L_0x0051
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            int r1 = r1.mo7890b()
            long r5 = (long) r1
            long r4 = r4.toMillis(r5)
            long r2 = r2 + r4
            goto L_0x005b
        L_0x0051:
            com.applovin.impl.adview.AppLovinVideoView r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x005b
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x005b:
            boolean r1 = r0.mo9036ad()
            if (r1 == 0) goto L_0x009b
            long r0 = r0.mo9068t()
            int r1 = (int) r0
            if (r1 <= 0) goto L_0x009b
            goto L_0x008a
        L_0x0069:
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            boolean r0 = r0 instanceof com.applovin.impl.sdk.p035a.C0924a
            if (r0 == 0) goto L_0x009b
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            com.applovin.impl.sdk.a.a r0 = (com.applovin.impl.sdk.p035a.C0924a) r0
            com.applovin.impl.adview.AppLovinVideoView r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x007d
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x007d:
            boolean r1 = r0.mo9036ad()
            if (r1 == 0) goto L_0x009b
            float r1 = r0.mo8959k()
            int r1 = (int) r1
            if (r1 <= 0) goto L_0x0093
        L_0x008a:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = (long) r1
            long r0 = r0.toMillis(r4)
            long r2 = r2 + r0
            goto L_0x009b
        L_0x0093:
            long r0 = r0.mo9068t()
            int r1 = (int) r0
            if (r1 <= 0) goto L_0x009b
            goto L_0x008a
        L_0x009b:
            double r0 = (double) r2
            com.applovin.impl.sdk.a.g r2 = r7.currentAd
            int r2 = r2.mo9035ac()
            double r2 = (double) r2
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            long r0 = (long) r0
        L_0x00af:
            com.applovin.impl.sdk.r r2 = r7.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Scheduling report reward in "
            r3.append(r4)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r4 = r4.toSeconds(r0)
            r3.append(r4)
            java.lang.String r4 = " seconds..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "InterActivity"
            r2.mo9584b(r4, r3)
            com.applovin.impl.sdk.k r2 = r7.sdk
            com.applovin.impl.adview.o$17 r3 = new com.applovin.impl.adview.o$17
            r3.<init>()
            com.applovin.impl.sdk.utils.p r0 = com.applovin.impl.sdk.utils.C1157p.m2682a(r0, r2, r3)
            r7.f589P = r0
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0668o.m670I():void");
    }

    /* renamed from: J */
    private void m671J() {
        View view;
        String str;
        StringBuilder sb;
        C1107r rVar;
        C0667n nVar = this.f592a;
        if (nVar != null) {
            nVar.setAdDisplayListener(new AppLovinAdDisplayListener() {
                public void adDisplayed(AppLovinAd appLovinAd) {
                    if (!C0668o.this.f596e) {
                        C0668o.this.m689a(appLovinAd);
                    }
                }

                public void adHidden(AppLovinAd appLovinAd) {
                    C0668o.this.m703b(appLovinAd);
                }
            });
            this.f592a.setAdClickListener(new AppLovinAdClickListener() {
                public void adClicked(AppLovinAd appLovinAd) {
                    C1124k.m2615a(C0668o.this.f593b.mo8271e(), appLovinAd);
                }
            });
            this.currentAd = this.f593b.mo8268b();
            if (this.f614w.compareAndSet(false, true)) {
                this.sdk.mo9404t().trackImpression(this.currentAd);
                this.currentAd.setHasShown(true);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = new FrameLayout(this);
            this.f576C = frameLayout;
            frameLayout.setLayoutParams(layoutParams);
            this.f576C.setBackgroundColor(-16777216);
            this.countdownManager = new C0653j(this.f574A, this.sdk);
            m727j();
            if (this.currentAd.isVideoAd()) {
                this.f603l = this.currentAd.mo7826e();
                if (this.f603l) {
                    rVar = this.logger;
                    sb = new StringBuilder();
                    str = "Preparing stream for ";
                } else {
                    rVar = this.logger;
                    sb = new StringBuilder();
                    str = "Preparing cached video playback for ";
                }
                sb.append(str);
                sb.append(this.currentAd.mo7829g());
                rVar.mo9584b("InterActivity", sb.toString());
                C0981d dVar = this.f594c;
                if (dVar != null) {
                    dVar.mo9174b(this.f603l ? 1 : 0);
                }
            }
            this.videoMuted = m726i();
            Uri g = this.currentAd.mo7829g();
            m684a(g);
            if (g == null) {
                m670I();
            }
            this.f577D.bringToFront();
            if (m736n() && (view = this.f578E) != null) {
                view.bringToFront();
            }
            C0651i iVar = this.f579F;
            if (iVar != null) {
                iVar.bringToFront();
            }
            if (((Boolean) this.sdk.mo9350a(C0965b.f1785eA)).booleanValue()) {
                this.f576C.addView(this.f592a);
                this.f592a.setVisibility(4);
            }
            this.f592a.renderAd(this.currentAd);
            if (!this.currentAd.hasVideoUrl()) {
                if (m669H()) {
                    m716d((AppLovinAd) this.currentAd);
                }
                showPostitial();
                return;
            }
            return;
        }
        exitWithError("AdView was null");
    }

    /* renamed from: K */
    private void m672K() {
        if (this.videoView != null) {
            boolean z = false;
            try {
                z = this.currentAd.mo9032aK();
            } catch (Throwable unused) {
            }
            this.f611t = getVideoPercentViewed();
            if (z) {
                this.videoView.pause();
            } else {
                this.videoView.stopPlayback();
            }
        }
    }

    /* renamed from: L */
    private boolean m673L() {
        return this.videoMuted;
    }

    /* renamed from: M */
    private void m674M() {
        AppLovinVideoView appLovinVideoView = this.videoView;
        this.sdk.mo9357a(C0967d.f1867v, Integer.valueOf(appLovinVideoView != null ? appLovinVideoView.getCurrentPosition() : 0));
        this.sdk.mo9357a(C0967d.f1868w, Boolean.TRUE);
        try {
            this.countdownManager.mo8197c();
        } catch (Throwable th) {
            this.logger.mo9585b("InterActivity", "Unable to pause countdown timers", th);
        }
        AppLovinVideoView appLovinVideoView2 = this.videoView;
        if (appLovinVideoView2 != null) {
            appLovinVideoView2.pause();
        }
    }

    /* renamed from: N */
    private void m675N() {
        long max = Math.max(0, ((Long) this.sdk.mo9350a(C0965b.f1682cB)).longValue());
        if (max > 0) {
            C1107r z = this.sdk.mo9411z();
            z.mo9584b("InterActivity", "Resuming video with delay of " + max);
            this.f575B.postDelayed(new Runnable() {
                public void run() {
                    C0668o.this.m676O();
                }
            }, max);
            return;
        }
        this.sdk.mo9411z().mo9584b("InterActivity", "Resuming video immediately");
        m676O();
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m676O() {
        AppLovinVideoView appLovinVideoView;
        if (!this.postitialWasDisplayed && (appLovinVideoView = this.videoView) != null && !appLovinVideoView.isPlaying()) {
            this.videoView.seekTo(((Integer) this.sdk.mo9379b(C0967d.f1867v, Integer.valueOf(this.videoView.getDuration()))).intValue());
            this.videoView.start();
            this.countdownManager.mo8194a();
        }
    }

    /* renamed from: P */
    private void m677P() {
        if (!this.f599h) {
            boolean z = true;
            this.f599h = true;
            try {
                int videoPercentViewed = getVideoPercentViewed();
                if (this.currentAd.hasVideoUrl()) {
                    m690a((AppLovinAd) this.currentAd, (double) videoPercentViewed, isFullyWatched());
                    C0981d dVar = this.f594c;
                    if (dVar != null) {
                        dVar.mo9176c((long) videoPercentViewed);
                    }
                } else if ((this.currentAd instanceof C0924a) && m669H()) {
                    int E = m663E();
                    C1107r rVar = this.logger;
                    rVar.mo9584b("InterActivity", "Rewarded playable engaged at " + E + " percent");
                    C0934g gVar = this.currentAd;
                    double d = (double) E;
                    if (E < this.currentAd.mo9006O()) {
                        z = false;
                    }
                    m690a((AppLovinAd) gVar, d, z);
                }
                long currentTimeMillis = System.currentTimeMillis() - this.f606o;
                this.sdk.mo9404t().trackVideoEnd(this.currentAd, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), videoPercentViewed, this.f603l);
                this.sdk.mo9404t().trackFullScreenAdClosed(this.currentAd, SystemClock.elapsedRealtime() - this.f608q, this.f610s, this.f617z, this.f616y);
            } catch (Throwable th) {
                C1107r rVar2 = this.logger;
                if (rVar2 != null) {
                    rVar2.mo9585b("InterActivity", "Failed to notify end listener.", th);
                }
            }
        }
    }

    /* renamed from: a */
    private int m678a(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    /* renamed from: a */
    private int m679a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        }
    }

    /* renamed from: a */
    private void m682a(long j, final C0651i iVar) {
        this.f575B.postDelayed(new Runnable() {
            public void run() {
                if (iVar.equals(C0668o.this.f577D)) {
                    C0668o.this.m733m();
                } else if (iVar.equals(C0668o.this.f579F)) {
                    C0668o.this.m737o();
                }
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m683a(PointF pointF) {
        if (!this.currentAd.mo7812C() || this.currentAd.mo7835j() == null) {
            m717e();
            m719f();
            return;
        }
        this.sdk.mo9411z().mo9584b("InterActivity", "Clicking through video...");
        clickThroughFromVideo(pointF);
    }

    /* renamed from: a */
    private void m684a(Uri uri) {
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(this, this.sdk);
        this.videoView = appLovinVideoView;
        if (uri != null) {
            appLovinVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    WeakReference unused = C0668o.this.f583J = new WeakReference(mediaPlayer);
                    float f = C0668o.this.m726i() ^ true ? 1.0f : 0.0f;
                    mediaPlayer.setVolume(f, f);
                    int videoWidth = mediaPlayer.getVideoWidth();
                    int videoHeight = mediaPlayer.getVideoHeight();
                    C0668o.this.computedLengthSeconds = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
                    C0668o.this.videoView.setVideoSize(videoWidth, videoHeight);
                    SurfaceHolder holder = C0668o.this.videoView.getHolder();
                    if (holder.getSurface() != null) {
                        mediaPlayer.setDisplay(holder);
                    }
                    mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
                            C0668o.this.f575B.post(new Runnable() {
                                public void run() {
                                    C0668o oVar = C0668o.this;
                                    oVar.handleMediaError("Media player error (" + i + "," + i2 + ")");
                                }
                            });
                            return true;
                        }
                    });
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                            if (i != 3) {
                                if (i == 701) {
                                    C0668o.this.m757y();
                                    if (C0668o.this.f594c == null) {
                                        return false;
                                    }
                                    C0668o.this.f594c.mo9181g();
                                    return false;
                                } else if (i != 702) {
                                    return false;
                                }
                            }
                            C0668o.this.m760z();
                            return false;
                        }
                    });
                    if (C0668o.this.f607p == 0) {
                        C0668o.this.m742q();
                        C0668o.this.m729k();
                        C0668o.this.m751v();
                        C0668o.this.m750u();
                        C0668o.this.playVideo();
                        C0668o.this.m670I();
                    }
                }
            });
            this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    C0668o.this.m724h();
                }
            });
            this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
                    C0668o.this.f575B.post(new Runnable() {
                        public void run() {
                            C0668o oVar = C0668o.this;
                            oVar.handleMediaError("Video view error (" + i + "," + i2 + ")");
                        }
                    });
                    return true;
                }
            });
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.videoView.setVideoURI(uri);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        this.videoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.videoView.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, this, new AppLovinTouchToClickListener.OnClickListener() {
            public void onClick(View view, PointF pointF) {
                C0668o.this.m683a(pointF);
            }
        }));
        this.f576C.addView(this.videoView);
        setContentView(this.f576C);
        m739p();
        m755x();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m685a(final View view, final boolean z, long j) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (!z) {
                    view.setVisibility(4);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(alphaAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m689a(AppLovinAd appLovinAd) {
        C1124k.m2616a(this.f593b.mo8270d(), appLovinAd);
        this.f596e = true;
        this.sdk.mo9369ad().mo9572a((Object) appLovinAd);
        this.sdk.mo9377al().mo9417a((Object) appLovinAd);
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C0668o oVar = C0668o.this;
                oVar.m705b(oVar.videoMuted);
            }
        }, ((Long) this.sdk.mo9350a(C0965b.f1686cF)).longValue());
    }

    /* renamed from: a */
    private void m690a(AppLovinAd appLovinAd, double d, boolean z) {
        C1124k.m2621a(this.f593b.mo8269c(), appLovinAd, d, z);
    }

    /* renamed from: a */
    private void m691a(final String str) {
        C0703p pVar = this.f593b;
        if (pVar != null) {
            final AppLovinAdDisplayListener d = pVar.mo8270d();
            if ((d instanceof C0941i) && this.f615x.compareAndSet(false, true)) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        ((C0941i) d).onAdDisplayFailed(str);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m692a(final String str, long j) {
        if (j >= 0) {
            this.f575B.postDelayed(new Runnable() {
                public void run() {
                    C0638d p = C0668o.this.f592a.getAdViewController().mo8109p();
                    if (p != null && C1155o.m2673b(str)) {
                        p.mo8128a(str);
                    }
                }
            }, j);
        }
    }

    /* renamed from: a */
    private void m693a(boolean z) {
        if (C1119g.m2531d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getDrawable(z ? C1199R.C1200drawable.unmute_to_mute : C1199R.C1200drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f582I.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f582I.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
            return;
        }
        Uri aD = z ? this.currentAd.mo9025aD() : this.currentAd.mo9026aE();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f582I.setImageURI(aD);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    private boolean m694a() {
        int identifier = getResources().getIdentifier((String) this.sdk.mo9350a(C0965b.f1719cm), "bool", Constants.ANDROID_PLATFORM);
        return identifier > 0 && getResources().getBoolean(identifier);
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: b */
    public void m698b() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* renamed from: b */
    private void m699b(int i) {
        try {
            setRequestedOrientation(i);
        } catch (Throwable th) {
            this.sdk.mo9411z().mo9585b("InterActivity", "Failed to set requested orientation", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r7 == 2) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        if (r7 == 1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r7 == 1) goto L_0x0028;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m700b(int r7, boolean r8) {
        /*
            r6 = this;
            com.applovin.impl.sdk.k r0 = r6.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p037c.C0965b.f1717ck
            java.lang.Object r0 = r0.mo9350a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.applovin.impl.adview.p r1 = r6.f593b
            com.applovin.impl.sdk.a.g$b r1 = r1.mo8272f()
            com.applovin.impl.sdk.a.g$b r2 = com.applovin.impl.sdk.p035a.C0934g.C0937b.ACTIVITY_PORTRAIT
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 != r2) goto L_0x003c
            r1 = 9
            if (r8 == 0) goto L_0x002c
            if (r7 == r5) goto L_0x0024
            if (r7 == r3) goto L_0x0024
            goto L_0x0030
        L_0x0024:
            if (r0 == 0) goto L_0x0064
            if (r7 != r5) goto L_0x0030
        L_0x0028:
            r6.m699b((int) r1)
            goto L_0x0064
        L_0x002c:
            if (r7 == 0) goto L_0x0034
            if (r7 == r4) goto L_0x0034
        L_0x0030:
            r6.m699b((int) r5)
            goto L_0x0064
        L_0x0034:
            if (r0 == 0) goto L_0x0064
            if (r7 != 0) goto L_0x0039
            goto L_0x0030
        L_0x0039:
            r5 = 9
            goto L_0x0030
        L_0x003c:
            com.applovin.impl.adview.p r1 = r6.f593b
            com.applovin.impl.sdk.a.g$b r1 = r1.mo8272f()
            com.applovin.impl.sdk.a.g$b r2 = com.applovin.impl.sdk.p035a.C0934g.C0937b.ACTIVITY_LANDSCAPE
            if (r1 != r2) goto L_0x0064
            r1 = 8
            r2 = 0
            if (r8 == 0) goto L_0x0057
            if (r7 == 0) goto L_0x0050
            if (r7 == r4) goto L_0x0050
            goto L_0x005b
        L_0x0050:
            if (r0 == 0) goto L_0x0064
            if (r7 != r4) goto L_0x0055
            goto L_0x0028
        L_0x0055:
            r1 = 0
            goto L_0x0028
        L_0x0057:
            if (r7 == r5) goto L_0x005f
            if (r7 == r3) goto L_0x005f
        L_0x005b:
            r6.m699b((int) r2)
            goto L_0x0064
        L_0x005f:
            if (r0 == 0) goto L_0x0064
            if (r7 != r5) goto L_0x0028
            goto L_0x0055
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0668o.m700b(int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m703b(AppLovinAd appLovinAd) {
        dismiss();
        m708c(appLovinAd);
    }

    /* renamed from: b */
    private void m704b(String str) {
        C0934g gVar = this.currentAd;
        if (gVar != null && gVar.mo9012U()) {
            m692a(str, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m705b(boolean z) {
        C0638d p;
        if (this.currentAd.mo9010S() && (p = this.f592a.getAdViewController().mo8109p()) != null) {
            try {
                p.mo8128a(z ? "javascript:al_mute();" : "javascript:al_unmute();");
            } catch (Throwable th) {
                this.logger.mo9585b("InterActivity", "Unable to forward mute setting to template.", th);
            }
        }
    }

    /* renamed from: c */
    private void m708c(AppLovinAd appLovinAd) {
        if (!this.f597f) {
            this.f597f = true;
            C0703p pVar = this.f593b;
            if (pVar != null) {
                C1124k.m2627b(pVar.mo8270d(), appLovinAd);
            }
            this.sdk.mo9369ad().mo9575b((Object) appLovinAd);
            this.sdk.mo9377al().mo9416a();
        }
    }

    /* renamed from: c */
    private void m709c(boolean z) {
        this.videoMuted = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f583J.get();
        if (mediaPlayer != null) {
            float f = (float) (z ? 0 : 1);
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException e) {
                C1107r rVar = this.logger;
                rVar.mo9585b("InterActivity", "Failed to set MediaPlayer muted: " + z, e);
            }
        }
    }

    /* renamed from: c */
    private boolean m710c() {
        C1062k kVar;
        if (this.f593b == null || (kVar = this.sdk) == null || ((Boolean) kVar.mo9350a(C0965b.f1713cg)).booleanValue()) {
            return true;
        }
        if (!((Boolean) this.sdk.mo9350a(C0965b.f1714ch)).booleanValue() || !this.f600i) {
            return ((Boolean) this.sdk.mo9350a(C0965b.f1715ci)).booleanValue() && this.postitialWasDisplayed;
        }
        return true;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: d */
    private void m714d() {
        int i;
        if (this.sdk == null || !isFinishing()) {
            if (!(this.currentAd == null || (i = this.f612u) == Integer.MIN_VALUE)) {
                m699b(i);
            }
            finish();
        }
    }

    /* renamed from: d */
    private void m716d(AppLovinAd appLovinAd) {
        if (!this.f598g) {
            this.f598g = true;
            C1124k.m2620a(this.f593b.mo8269c(), appLovinAd);
        }
    }

    /* renamed from: e */
    private void m717e() {
        C0648g gVar;
        if (((Boolean) this.sdk.mo9350a(C0965b.f1720cn)).booleanValue() && (gVar = this.f581H) != null && gVar.getVisibility() != 8) {
            m685a((View) this.f581H, this.f581H.getVisibility() == 4, 750);
        }
    }

    /* renamed from: f */
    private void m719f() {
        C0716u uVar;
        C0715t B = this.currentAd.mo8994B();
        if (B != null && B.mo8290e() && !this.postitialWasDisplayed && (uVar = this.f585L) != null) {
            m685a((View) this.f585L, uVar.getVisibility() == 4, B.mo8292f());
        }
    }

    /* renamed from: g */
    private void m722g() {
        C1062k kVar = this.sdk;
        if (kVar != null) {
            kVar.mo9357a(C0967d.f1868w, Boolean.FALSE);
            this.sdk.mo9357a(C0967d.f1867v, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m724h() {
        this.f595d = true;
        showPostitial();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m726i() {
        return ((Integer) this.sdk.mo9379b(C0967d.f1867v, 0)).intValue() > 0 ? this.videoMuted : ((Boolean) this.sdk.mo9350a(C0965b.f1726ct)).booleanValue() ? this.sdk.mo9400p().isMuted() : ((Boolean) this.sdk.mo9350a(C0965b.f1724cr)).booleanValue();
    }

    /* renamed from: j */
    private void m727j() {
        C0651i a = C0651i.m623a(this.currentAd.mo9069u(), this);
        this.f577D = a;
        a.setVisibility(8);
        this.f577D.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0668o.this.m658B();
            }
        });
        int a2 = m678a(this.currentAd.mo9014W());
        int i = 3;
        int i2 = (this.currentAd.mo9017Z() ? 3 : 5) | 48;
        if (!this.currentAd.mo9033aa()) {
            i = 5;
        }
        int i3 = i | 48;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2, i2 | 48);
        this.f577D.mo8189a(a2);
        int a3 = m678a(this.currentAd.mo9015X());
        int a4 = m678a(this.currentAd.mo9016Y());
        layoutParams.setMargins(a4, a3, a4, a3);
        this.f576C.addView(this.f577D, layoutParams);
        C0651i a5 = C0651i.m623a(this.currentAd.mo9070v(), this);
        this.f579F = a5;
        a5.setVisibility(8);
        this.f579F.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0668o.this.m655A();
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2, a2, i3);
        layoutParams2.setMargins(a4, a3, a4, a3);
        this.f579F.mo8189a(a2);
        this.f576C.addView(this.f579F, layoutParams2);
        this.f579F.bringToFront();
        if (m736n()) {
            int a6 = m678a(((Integer) this.sdk.mo9350a(C0965b.f1679by)).intValue());
            View view = new View(this);
            this.f578E = view;
            view.setBackgroundColor(0);
            this.f578E.setVisibility(8);
            View view2 = new View(this);
            this.f580G = view2;
            view2.setBackgroundColor(0);
            this.f580G.setVisibility(8);
            int i4 = a2 + a6;
            int a7 = a3 - m678a(5);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i4, i4, i2);
            layoutParams3.setMargins(a7, a7, a7, a7);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i4, i4, i3);
            layoutParams4.setMargins(a7, a7, a7, a7);
            this.f578E.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C0668o.this.f577D.performClick();
                }
            });
            this.f580G.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C0668o.this.f579F.performClick();
                }
            });
            this.f576C.addView(this.f578E, layoutParams3);
            this.f578E.bringToFront();
            this.f576C.addView(this.f580G, layoutParams4);
            this.f580G.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m729k() {
        if (this.f582I == null) {
            try {
                this.videoMuted = m726i();
                this.f582I = new ImageView(this);
                if (!m732l()) {
                    int a = m678a(((Integer) this.sdk.mo9350a(C0965b.f1727cu)).intValue());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a, ((Integer) this.sdk.mo9350a(C0965b.f1729cw)).intValue());
                    this.f582I.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    int a2 = m678a(((Integer) this.sdk.mo9350a(C0965b.f1728cv)).intValue());
                    layoutParams.setMargins(a2, a2, a2, a2);
                    if ((this.videoMuted ? this.currentAd.mo9025aD() : this.currentAd.mo9026aE()) != null) {
                        C1107r z = this.sdk.mo9411z();
                        z.mo9584b("InterActivity", "Added mute button with params: " + layoutParams);
                        m693a(this.videoMuted);
                        this.f582I.setClickable(true);
                        this.f582I.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                C0668o.this.toggleMute();
                            }
                        });
                        this.f576C.addView(this.f582I, layoutParams);
                        this.f582I.bringToFront();
                        return;
                    }
                    this.sdk.mo9411z().mo9588e("InterActivity", "Attempting to add mute button but could not find uri");
                    return;
                }
                this.sdk.mo9411z().mo9584b("InterActivity", "Mute button should be hidden");
            } catch (Exception e) {
                this.sdk.mo9411z().mo9583a("InterActivity", "Failed to attach mute button", (Throwable) e);
            }
        }
    }

    /* renamed from: l */
    private boolean m732l() {
        if (!((Boolean) this.sdk.mo9350a(C0965b.f1722cp)).booleanValue()) {
            return true;
        }
        if (!((Boolean) this.sdk.mo9350a(C0965b.f1723cq)).booleanValue() || m726i()) {
            return false;
        }
        return !((Boolean) this.sdk.mo9350a(C0965b.f1725cs)).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m733m() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C0668o.this.f600i) {
                        C0668o.this.f577D.setVisibility(0);
                        return;
                    }
                    long unused = C0668o.this.f608q = SystemClock.elapsedRealtime();
                    boolean unused2 = C0668o.this.f600i = true;
                    if (C0668o.this.m736n() && C0668o.this.f578E != null) {
                        C0668o.this.f578E.setVisibility(0);
                        C0668o.this.f578E.bringToFront();
                    }
                    C0668o.this.f577D.setVisibility(0);
                    C0668o.this.f577D.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(400);
                    alphaAnimation.setRepeatCount(0);
                    C0668o.this.f577D.startAnimation(alphaAnimation);
                } catch (Throwable unused3) {
                    C0668o.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m736n() {
        return ((Integer) this.sdk.mo9350a(C0965b.f1679by)).intValue() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m737o() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (!C0668o.this.f601j && C0668o.this.f579F != null) {
                        long unused = C0668o.this.f610s = -1;
                        long unused2 = C0668o.this.f609r = SystemClock.elapsedRealtime();
                        boolean unused3 = C0668o.this.f601j = true;
                        C0668o.this.f579F.setVisibility(0);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(400);
                        alphaAnimation.setRepeatCount(0);
                        C0668o.this.f579F.startAnimation(alphaAnimation);
                        if (C0668o.this.m736n() && C0668o.this.f580G != null) {
                            C0668o.this.f580G.setVisibility(0);
                            C0668o.this.f580G.bringToFront();
                        }
                    }
                } catch (Throwable th) {
                    C1107r rVar = C0668o.this.logger;
                    rVar.mo9587d("InterActivity", "Unable to show skip button: " + th);
                }
            }
        });
    }

    /* renamed from: p */
    private void m739p() {
        C0651i iVar;
        if (this.currentAd.mo9066r() >= 0) {
            if (!this.f602k || (iVar = this.f579F) == null) {
                iVar = this.f577D;
            }
            m682a(C1160r.m2738b((float) this.currentAd.mo9066r()), iVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m742q() {
        boolean z = ((Boolean) this.sdk.mo9350a(C0965b.f1712cf)).booleanValue() && m747t() > 0;
        if (this.f581H == null && z) {
            this.f581H = new C0648g(this);
            int F = this.currentAd.mo8997F();
            this.f581H.setTextColor(F);
            this.f581H.setTextSize((float) ((Integer) this.sdk.mo9350a(C0965b.f1711ce)).intValue());
            this.f581H.setFinishedStrokeColor(F);
            this.f581H.setFinishedStrokeWidth((float) ((Integer) this.sdk.mo9350a(C0965b.f1710cd)).intValue());
            this.f581H.setMax(m747t());
            this.f581H.setProgress(m747t());
            C1062k kVar = this.sdk;
            C0965b bVar = C0965b.f1709cc;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m678a(((Integer) kVar.mo9350a(bVar)).intValue()), m678a(((Integer) this.sdk.mo9350a(bVar)).intValue()), ((Integer) this.sdk.mo9350a(C0965b.f1708cb)).intValue());
            int a = m678a(((Integer) this.sdk.mo9350a(C0965b.f1707ca)).intValue());
            layoutParams.setMargins(a, a, a, a);
            this.f576C.addView(this.f581H, layoutParams);
            this.f581H.bringToFront();
            this.f581H.setVisibility(0);
            final long s = m745s();
            this.countdownManager.mo8195a("COUNTDOWN_CLOCK", 1000, (C0653j.C0655a) new C0653j.C0655a() {
                /* renamed from: a */
                public void mo8020a() {
                    if (C0668o.this.f581H != null) {
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(s - ((long) C0668o.this.videoView.getCurrentPosition()));
                        if (seconds <= 0) {
                            C0668o.this.f581H.setVisibility(8);
                            boolean unused = C0668o.this.f605n = true;
                        } else if (C0668o.this.m744r()) {
                            C0668o.this.f581H.setProgress((int) seconds);
                        }
                    }
                }

                /* renamed from: b */
                public boolean mo8021b() {
                    return C0668o.this.m744r();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean m744r() {
        return !this.f605n && !this.postitialWasDisplayed && this.videoView.isPlaying();
    }

    /* renamed from: s */
    private long m745s() {
        return TimeUnit.SECONDS.toMillis((long) m747t());
    }

    /* renamed from: t */
    private int m747t() {
        int E = this.currentAd.mo8996E();
        return (E <= 0 && ((Boolean) this.sdk.mo9350a(C0965b.f1685cE)).booleanValue()) ? this.computedLengthSeconds + 1 : E;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: u */
    public void m750u() {
        if (this.f586M == null && this.currentAd.mo9004M()) {
            this.logger.mo9586c("InterActivity", "Attaching video progress bar...");
            ProgressBar progressBar = new ProgressBar(this, (AttributeSet) null, 16842872);
            this.f586M = progressBar;
            progressBar.setMax(((Integer) this.sdk.mo9350a(C0965b.f1732cz)).intValue());
            this.f586M.setPadding(0, 0, 0, 0);
            if (C1119g.m2531d()) {
                try {
                    this.f586M.setProgressTintList(ColorStateList.valueOf(this.currentAd.mo9005N()));
                } catch (Throwable th) {
                    this.logger.mo9585b("InterActivity", "Unable to update progress bar color.", th);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.videoView.getWidth(), 20, 80);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.sdk.mo9350a(C0965b.f1681cA)).intValue());
            this.f576C.addView(this.f586M, layoutParams);
            this.f586M.bringToFront();
            this.countdownManager.mo8195a("PROGRESS_BAR", ((Long) this.sdk.mo9350a(C0965b.f1731cy)).longValue(), (C0653j.C0655a) new C0653j.C0655a() {
                /* renamed from: a */
                public void mo8020a() {
                    if (C0668o.this.f586M == null) {
                        return;
                    }
                    if (C0668o.this.shouldContinueFullLengthVideoCountdown()) {
                        C0668o.this.f586M.setProgress((int) ((((float) C0668o.this.videoView.getCurrentPosition()) / ((float) C0668o.this.videoView.getDuration())) * ((float) ((Integer) C0668o.this.sdk.mo9350a(C0965b.f1732cz)).intValue())));
                        return;
                    }
                    C0668o.this.f586M.setVisibility(8);
                }

                /* renamed from: b */
                public boolean mo8021b() {
                    return C0668o.this.shouldContinueFullLengthVideoCountdown();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m751v() {
        final C0715t B = this.currentAd.mo8994B();
        if (C1155o.m2673b(this.currentAd.mo8993A()) && B != null && this.f585L == null) {
            this.logger.mo9586c("InterActivity", "Attaching video button...");
            this.f585L = m754w();
            double a = (double) B.mo8286a();
            Double.isNaN(a);
            double b = (double) B.mo8287b();
            Double.isNaN(b);
            int width = this.videoView.getWidth();
            int height = this.videoView.getHeight();
            double d = (double) width;
            Double.isNaN(d);
            double d2 = (double) height;
            Double.isNaN(d2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((a / 100.0d) * d), (int) ((b / 100.0d) * d2), B.mo8289d());
            int a2 = m678a(B.mo8288c());
            layoutParams.setMargins(a2, a2, a2, a2);
            this.f576C.addView(this.f585L, layoutParams);
            this.f585L.bringToFront();
            if (B.mo8296i() > 0.0f) {
                this.f585L.setVisibility(4);
                this.f575B.postDelayed(new Runnable() {
                    public void run() {
                        long g = B.mo8293g();
                        C0668o oVar = C0668o.this;
                        oVar.m685a((View) oVar.f585L, true, g);
                        C0668o.this.f585L.bringToFront();
                    }
                }, C1160r.m2738b(B.mo8296i()));
            }
            if (B.mo8297j() > 0.0f) {
                this.f575B.postDelayed(new Runnable() {
                    public void run() {
                        long h = B.mo8294h();
                        C0668o oVar = C0668o.this;
                        oVar.m685a((View) oVar.f585L, false, h);
                    }
                }, C1160r.m2738b(B.mo8297j()));
            }
        }
    }

    /* renamed from: w */
    private C0716u m754w() {
        C1107r rVar = this.logger;
        rVar.mo9584b("InterActivity", "Create video button with HTML = " + this.currentAd.mo8993A());
        C0717v vVar = new C0717v(this.sdk);
        this.f587N = new C0717v.C0718a() {
            /* renamed from: a */
            public void mo8042a(C0716u uVar) {
                C0668o.this.logger.mo9584b("InterActivity", "Clicking through from video button...");
                C0668o.this.clickThroughFromVideo(uVar.getAndClearLastClickLocation());
            }

            /* renamed from: b */
            public void mo8043b(C0716u uVar) {
                C0668o.this.logger.mo9584b("InterActivity", "Closing ad from video button...");
                C0668o.this.dismiss();
            }

            /* renamed from: c */
            public void mo8044c(C0716u uVar) {
                C0668o.this.logger.mo9584b("InterActivity", "Skipping video from video button...");
                C0668o.this.skipVideo();
            }
        };
        vVar.mo8300a(new WeakReference(this.f587N));
        C0716u uVar = new C0716u(vVar, getApplicationContext());
        uVar.mo8299a(this.currentAd.mo8993A());
        return uVar;
    }

    /* renamed from: x */
    private void m755x() {
        if (this.f603l) {
            C0564a aVar = new C0564a(this, ((Integer) this.sdk.mo9350a(C0965b.f1684cD)).intValue(), 16842874);
            this.f588O = aVar;
            aVar.setColor(Color.parseColor("#75FFFFFF"));
            this.f588O.setBackgroundColor(Color.parseColor("#00000000"));
            this.f588O.setVisibility(8);
            this.f576C.addView(this.f588O, new FrameLayout.LayoutParams(-1, -1, 17));
            this.f576C.bringChildToFront(this.f588O);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m757y() {
        C0564a aVar = this.f588O;
        if (aVar != null) {
            aVar.mo7946a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m760z() {
        C0564a aVar = this.f588O;
        if (aVar != null) {
            aVar.mo7947b();
        }
    }

    public void clickThroughFromVideo(PointF pointF) {
        try {
            this.sdk.mo9404t().trackAndLaunchVideoClick(this.currentAd, this.f592a, this.currentAd.mo7835j(), pointF);
            C1124k.m2615a(this.f593b.mo8271e(), (AppLovinAd) this.currentAd);
            C0981d dVar = this.f594c;
            if (dVar != null) {
                dVar.mo9173b();
            }
        } catch (Throwable th) {
            this.sdk.mo9411z().mo9585b("InterActivity", "Encountered error while clicking through video.", th);
        }
    }

    public void continueVideo() {
        m676O();
    }

    public void dismiss() {
        long currentTimeMillis = System.currentTimeMillis() - this.f606o;
        C1107r.m2481f("InterActivity", "Dismissing ad after " + currentTimeMillis + " milliseconds elapsed");
        C1062k kVar = this.sdk;
        if (kVar != null) {
            if (((Boolean) kVar.mo9350a(C0965b.f1721co)).booleanValue()) {
                stopService(new Intent(getBaseContext(), AppKilledService.class));
                this.sdk.mo9375aj().unregisterReceiver(this.f591R);
            }
            this.sdk.mo9374ai().mo9299b((C1044f.C1046a) this);
        }
        m722g();
        m677P();
        if (this.f593b != null) {
            if (this.currentAd != null) {
                m708c((AppLovinAd) this.currentAd);
                C0981d dVar = this.f594c;
                if (dVar != null) {
                    dVar.mo9175c();
                    this.f594c = null;
                }
                m692a("javascript:al_onPoststitialDismiss();", (long) this.currentAd.mo9009R());
            }
            this.f593b.mo8273g();
        }
        lastKnownWrapper = null;
        m714d();
    }

    public void exitWithError(String str) {
        m691a(str);
        try {
            C1107r.m2480c("InterActivity", "Failed to properly render an Interstitial Activity, due to error: " + str, new Throwable("Initialized = " + C0703p.f666b + "; CleanedUp = " + C0703p.f667c));
            m708c((AppLovinAd) new C0940h(this.currentAd != null ? this.currentAd.getAdZone() : C0928d.m1540a(str, this.sdk), this.sdk));
        } catch (Exception e) {
            C1107r.m2480c("InterActivity", "Failed to show a video ad due to error:", e);
        }
        dismiss();
    }

    public boolean getPostitialWasDisplayed() {
        return this.postitialWasDisplayed;
    }

    public int getVideoPercentViewed() {
        if (this.f595d) {
            return 100;
        }
        AppLovinVideoView appLovinVideoView = this.videoView;
        if (appLovinVideoView != null) {
            int duration = appLovinVideoView.getDuration();
            if (duration <= 0) {
                return this.f611t;
            }
            double currentPosition = (double) this.videoView.getCurrentPosition();
            double d = (double) duration;
            Double.isNaN(currentPosition);
            Double.isNaN(d);
            return (int) ((currentPosition / d) * 100.0d);
        }
        this.logger.mo9588e("InterActivity", "No video view detected on video end");
        return 0;
    }

    public void handleMediaError(String str) {
        this.logger.mo9588e("InterActivity", str);
        if (this.f613v.compareAndSet(false, true)) {
            m691a(str);
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFullyWatched() {
        return getVideoPercentViewed() >= this.currentAd.mo9006O();
    }

    /* access modifiers changed from: protected */
    public boolean isVastAd() {
        return this.currentAd instanceof C0536a;
    }

    public void onBackPressed() {
        C0651i iVar;
        C0651i iVar2;
        if (this.currentAd != null) {
            if (this.currentAd.mo9023aB() && !this.postitialWasDisplayed) {
                return;
            }
            if (this.currentAd.mo9024aC() && this.postitialWasDisplayed) {
                return;
            }
        }
        if (m710c()) {
            this.logger.mo9584b("InterActivity", "Back button was pressed; forwarding to Android for handling...");
        } else {
            try {
                if (this.postitialWasDisplayed || !this.f602k || (iVar2 = this.f579F) == null || iVar2.getVisibility() != 0 || this.f579F.getAlpha() <= 0.0f) {
                    C0651i iVar3 = this.f577D;
                    if (iVar3 == null || iVar3.getVisibility() != 0 || this.f577D.getAlpha() <= 0.0f) {
                        this.logger.mo9584b("InterActivity", "Back button was pressed, but was not eligible for dismissal.");
                        m704b("javascript:al_onBackPressed();");
                        return;
                    }
                    this.logger.mo9584b("InterActivity", "Back button was pressed; forwarding as a click to close button.");
                    iVar = this.f577D;
                } else {
                    this.logger.mo9584b("InterActivity", "Back button was pressed; forwarding as a click to skip button.");
                    iVar = this.f579F;
                }
                iVar.performClick();
                m704b("javascript:al_onBackPressed();");
                return;
            } catch (Exception unused) {
            }
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
            r9 = this;
            java.lang.String r0 = "InterActivity"
            super.onCreate(r10)
            if (r10 == 0) goto L_0x0012
            java.lang.String r1 = "instance_impression_tracked"
            boolean r1 = r10.getBoolean(r1)
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.f614w
            r2.set(r1)
        L_0x0012:
            r1 = 1
            r9.requestWindowFeature(r1)
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
            android.content.Intent r2 = r9.getIntent()     // Catch:{ all -> 0x01b5 }
            java.lang.String r3 = "com.applovin.interstitial.wrapper_id"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x01b2
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x01b5 }
            if (r3 != 0) goto L_0x01b2
            com.applovin.impl.adview.p r2 = com.applovin.impl.adview.C0703p.m770a((java.lang.String) r2)     // Catch:{ all -> 0x01b5 }
            r9.f593b = r2     // Catch:{ all -> 0x01b5 }
            if (r2 != 0) goto L_0x003c
            com.applovin.impl.adview.p r2 = lastKnownWrapper     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x003c
            com.applovin.impl.adview.p r2 = lastKnownWrapper     // Catch:{ all -> 0x01b5 }
            r9.f593b = r2     // Catch:{ all -> 0x01b5 }
        L_0x003c:
            com.applovin.impl.adview.p r2 = r9.f593b     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x019e
            com.applovin.impl.sdk.a.g r2 = r2.mo8268b()     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.adview.p r3 = r9.f593b     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r3 = r3.mo8265a()     // Catch:{ all -> 0x01b5 }
            r9.sdk = r3     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.adview.p r3 = r9.f593b     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r3 = r3.mo8265a()     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.r r3 = r3.mo9411z()     // Catch:{ all -> 0x01b5 }
            r9.logger = r3     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r3 = r9.sdk     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.p037c.C0965b.f1721co     // Catch:{ all -> 0x01b5 }
            java.lang.Object r3 = r3.mo9350a(r4)     // Catch:{ all -> 0x01b5 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x01b5 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x01b5 }
            if (r3 == 0) goto L_0x0081
            com.applovin.impl.adview.o$1 r3 = new com.applovin.impl.adview.o$1     // Catch:{ all -> 0x01b5 }
            r3.<init>(r2)     // Catch:{ all -> 0x01b5 }
            r9.f591R = r3     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r3 = r9.sdk     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.AppLovinBroadcastManager r3 = r3.mo9375aj()     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver r4 = r9.f591R     // Catch:{ all -> 0x01b5 }
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x01b5 }
            java.lang.String r6 = "com.applovin.app_killed"
            r5.<init>(r6)     // Catch:{ all -> 0x01b5 }
            r3.registerReceiver(r4, r5)     // Catch:{ all -> 0x01b5 }
        L_0x0081:
            if (r2 == 0) goto L_0x0198
            com.applovin.impl.sdk.k r3 = r9.sdk     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r4 = com.applovin.impl.sdk.p037c.C0965b.f1794eJ     // Catch:{ all -> 0x01b5 }
            java.lang.Object r3 = r3.mo9350a(r4)     // Catch:{ all -> 0x01b5 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x01b5 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x01b5 }
            r4 = -1
            if (r3 == r4) goto L_0x00b6
            java.lang.String r5 = "activity"
            java.lang.Object r5 = r9.getSystemService(r5)     // Catch:{ all -> 0x01b5 }
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch:{ all -> 0x01b5 }
            if (r5 == 0) goto L_0x00b6
            android.app.ActivityManager$MemoryInfo r6 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x01b5 }
            r6.<init>()     // Catch:{ all -> 0x01b5 }
            r5.getMemoryInfo(r6)     // Catch:{ all -> 0x01b5 }
            long r5 = r6.availMem     // Catch:{ all -> 0x01b5 }
            long r7 = (long) r3     // Catch:{ all -> 0x01b5 }
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b6
            java.lang.String r10 = "Not enough available memory"
            r9.exitWithError(r10)     // Catch:{ all -> 0x01b5 }
            android.os.StrictMode.setThreadPolicy(r1)
            return
        L_0x00b6:
            com.applovin.impl.sdk.d.d r3 = new com.applovin.impl.sdk.d.d     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r5 = r9.sdk     // Catch:{ all -> 0x01b5 }
            r3.<init>(r2, r5)     // Catch:{ all -> 0x01b5 }
            r9.f594c = r3     // Catch:{ all -> 0x01b5 }
            boolean r3 = r2.mo9042aj()     // Catch:{ all -> 0x01b5 }
            if (r3 == 0) goto L_0x00ce
            com.applovin.impl.sdk.k r3 = r9.sdk     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.f r3 = r3.mo9374ai()     // Catch:{ all -> 0x01b5 }
            r3.mo9298a((com.applovin.impl.sdk.C1044f.C1046a) r9)     // Catch:{ all -> 0x01b5 }
        L_0x00ce:
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r9.findViewById(r3)     // Catch:{ all -> 0x01b5 }
            if (r3 == 0) goto L_0x00ea
            boolean r5 = r2.hasVideoUrl()     // Catch:{ all -> 0x01b5 }
            if (r5 == 0) goto L_0x00e3
            r5 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.setBackgroundColor(r5)     // Catch:{ all -> 0x01b5 }
            goto L_0x00ea
        L_0x00e3:
            int r5 = r2.mo8998G()     // Catch:{ all -> 0x01b5 }
            r3.setBackgroundColor(r5)     // Catch:{ all -> 0x01b5 }
        L_0x00ea:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01b5 }
            r9.f606o = r5     // Catch:{ all -> 0x01b5 }
            android.view.Window r3 = r9.getWindow()     // Catch:{ all -> 0x01b5 }
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r3.setFlags(r5, r5)     // Catch:{ all -> 0x01b5 }
            int r3 = com.applovin.impl.sdk.utils.C1160r.m2751d((android.content.Context) r9)     // Catch:{ all -> 0x01b5 }
            boolean r5 = com.applovin.sdk.AppLovinSdkUtils.isTablet(r9)     // Catch:{ all -> 0x01b5 }
            int r6 = r9.m679a((int) r3, (boolean) r5)     // Catch:{ all -> 0x01b5 }
            if (r10 != 0) goto L_0x010a
            r9.f612u = r6     // Catch:{ all -> 0x01b5 }
            goto L_0x0112
        L_0x010a:
            java.lang.String r7 = "original_orientation"
            int r10 = r10.getInt(r7, r6)     // Catch:{ all -> 0x01b5 }
            r9.f612u = r10     // Catch:{ all -> 0x01b5 }
        L_0x0112:
            boolean r10 = r2.mo8995D()     // Catch:{ all -> 0x01b5 }
            if (r10 == 0) goto L_0x013f
            if (r6 == r4) goto L_0x0134
            com.applovin.impl.sdk.r r10 = r9.logger     // Catch:{ all -> 0x01b5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r2.<init>()     // Catch:{ all -> 0x01b5 }
            java.lang.String r3 = "Locking activity orientation to current orientation: "
            r2.append(r3)     // Catch:{ all -> 0x01b5 }
            r2.append(r6)     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01b5 }
            r10.mo9584b(r0, r2)     // Catch:{ all -> 0x01b5 }
            r9.m699b((int) r6)     // Catch:{ all -> 0x01b5 }
            goto L_0x0147
        L_0x0134:
            com.applovin.impl.sdk.r r10 = r9.logger     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = "Unable to detect current orientation. Locking to targeted orientation..."
            r10.mo9588e(r0, r2)     // Catch:{ all -> 0x01b5 }
        L_0x013b:
            r9.m700b((int) r3, (boolean) r5)     // Catch:{ all -> 0x01b5 }
            goto L_0x0147
        L_0x013f:
            com.applovin.impl.sdk.r r10 = r9.logger     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = "Locking activity orientation to targeted orientation..."
            r10.mo9584b(r0, r2)     // Catch:{ all -> 0x01b5 }
            goto L_0x013b
        L_0x0147:
            com.applovin.impl.adview.n r10 = new com.applovin.impl.adview.n     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r2 = r9.sdk     // Catch:{ all -> 0x01b5 }
            com.applovin.sdk.AppLovinSdk r2 = r2.mo9347X()     // Catch:{ all -> 0x01b5 }
            com.applovin.sdk.AppLovinAdSize r3 = com.applovin.sdk.AppLovinAdSize.INTERSTITIAL     // Catch:{ all -> 0x01b5 }
            r10.<init>(r2, r3, r9)     // Catch:{ all -> 0x01b5 }
            r9.f592a = r10     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.adview.b r10 = r10.getAdViewController()     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.d.d r2 = r9.f594c     // Catch:{ all -> 0x01b5 }
            r10.mo8087a((com.applovin.impl.sdk.p038d.C0981d) r2)     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.adview.p r10 = r9.f593b     // Catch:{ all -> 0x01b5 }
            r10.mo8266a((com.applovin.impl.adview.C0657k) r9)     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r10 = r9.sdk     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.p037c.C0965b.f1683cC     // Catch:{ all -> 0x01b5 }
            java.lang.Object r10 = r10.mo9350a(r2)     // Catch:{ all -> 0x01b5 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x01b5 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x01b5 }
            r9.f602k = r10     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.b.b r10 = new com.applovin.impl.sdk.b.b     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r2 = r9.sdk     // Catch:{ all -> 0x01b5 }
            r10.<init>(r9, r2)     // Catch:{ all -> 0x01b5 }
            r9.f584K = r10     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.adview.o$12 r2 = new com.applovin.impl.adview.o$12     // Catch:{ all -> 0x01b5 }
            r2.<init>()     // Catch:{ all -> 0x01b5 }
            r10.mo9096a((com.applovin.impl.sdk.p036b.C0951b.C0961a) r2)     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.adview.o$23 r10 = new com.applovin.impl.adview.o$23     // Catch:{ all -> 0x01b5 }
            r10.<init>()     // Catch:{ all -> 0x01b5 }
            r9.f590Q = r10     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.k r10 = r9.sdk     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.a r10 = r10.mo9370ae()     // Catch:{ all -> 0x01b5 }
            com.applovin.impl.sdk.utils.a r2 = r9.f590Q     // Catch:{ all -> 0x01b5 }
            r10.mo8945a(r2)     // Catch:{ all -> 0x01b5 }
            goto L_0x01c4
        L_0x0198:
            java.lang.String r10 = "No current ad found."
        L_0x019a:
            r9.exitWithError(r10)     // Catch:{ all -> 0x01b5 }
            goto L_0x01c4
        L_0x019e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r10.<init>()     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = "Wrapper is null; initialized state: "
            r10.append(r2)     // Catch:{ all -> 0x01b5 }
            boolean r2 = com.applovin.impl.adview.C0703p.f666b     // Catch:{ all -> 0x01b5 }
            r10.append(r2)     // Catch:{ all -> 0x01b5 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01b5 }
            goto L_0x019a
        L_0x01b2:
            java.lang.String r10 = "Wrapper ID is null"
            goto L_0x019a
        L_0x01b5:
            r10 = move-exception
            com.applovin.impl.sdk.r r2 = r9.logger     // Catch:{ all -> 0x01d5 }
            if (r2 == 0) goto L_0x01bf
            java.lang.String r3 = "Encountered error during onCreate."
            r2.mo9585b(r0, r3, r10)     // Catch:{ all -> 0x01d5 }
        L_0x01bf:
            java.lang.String r10 = "An error was encountered during interstitial ad creation."
            r9.exitWithError(r10)     // Catch:{ all -> 0x01d5 }
        L_0x01c4:
            android.os.StrictMode.setThreadPolicy(r1)
            r9.m722g()
            com.applovin.impl.sdk.d.d r10 = r9.f594c
            if (r10 == 0) goto L_0x01d1
            r10.mo9171a()
        L_0x01d1:
            r9.m671J()
            return
        L_0x01d5:
            r10 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)
            goto L_0x01db
        L_0x01da:
            throw r10
        L_0x01db:
            goto L_0x01da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0668o.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r4.currentAd != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006b, code lost:
        if (r4.currentAd == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        m677P();
        m708c((com.applovin.sdk.AppLovinAd) r4.currentAd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        super.onDestroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r4 = this;
            com.applovin.impl.adview.n r0 = r4.f592a     // Catch:{ all -> 0x005d }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ all -> 0x005d }
            boolean r2 = r0 instanceof android.view.ViewGroup     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0014
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x005d }
            com.applovin.impl.adview.n r2 = r4.f592a     // Catch:{ all -> 0x005d }
            r0.removeView(r2)     // Catch:{ all -> 0x005d }
        L_0x0014:
            com.applovin.impl.adview.n r0 = r4.f592a     // Catch:{ all -> 0x005d }
            r0.destroy()     // Catch:{ all -> 0x005d }
            r4.f592a = r1     // Catch:{ all -> 0x005d }
        L_0x001b:
            com.applovin.impl.adview.AppLovinVideoView r0 = r4.videoView     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0027
            r0.pause()     // Catch:{ all -> 0x005d }
            com.applovin.impl.adview.AppLovinVideoView r0 = r4.videoView     // Catch:{ all -> 0x005d }
            r0.stopPlayback()     // Catch:{ all -> 0x005d }
        L_0x0027:
            com.applovin.impl.sdk.k r0 = r4.sdk     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0043
            java.lang.ref.WeakReference<android.media.MediaPlayer> r0 = r4.f583J     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x005d }
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0038
            r0.release()     // Catch:{ all -> 0x005d }
        L_0x0038:
            com.applovin.impl.sdk.k r0 = r4.sdk     // Catch:{ all -> 0x005d }
            com.applovin.impl.sdk.a r0 = r0.mo9370ae()     // Catch:{ all -> 0x005d }
            com.applovin.impl.sdk.utils.a r2 = r4.f590Q     // Catch:{ all -> 0x005d }
            r0.mo8947b(r2)     // Catch:{ all -> 0x005d }
        L_0x0043:
            com.applovin.impl.adview.j r0 = r4.countdownManager     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x004a
            r0.mo8196b()     // Catch:{ all -> 0x005d }
        L_0x004a:
            android.os.Handler r0 = r4.f575B     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0051
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x005d }
        L_0x0051:
            android.os.Handler r0 = r4.f574A     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0058
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x005d }
        L_0x0058:
            com.applovin.impl.sdk.a.g r0 = r4.currentAd
            if (r0 == 0) goto L_0x0075
            goto L_0x006d
        L_0x005d:
            r0 = move-exception
            com.applovin.impl.sdk.r r1 = r4.logger     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x0069
            java.lang.String r2 = "InterActivity"
            java.lang.String r3 = "Unable to destroy video view"
            r1.mo9583a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0079 }
        L_0x0069:
            com.applovin.impl.sdk.a.g r0 = r4.currentAd
            if (r0 == 0) goto L_0x0075
        L_0x006d:
            r4.m677P()
            com.applovin.impl.sdk.a.g r0 = r4.currentAd
            r4.m708c((com.applovin.sdk.AppLovinAd) r0)
        L_0x0075:
            super.onDestroy()
            return
        L_0x0079:
            r0 = move-exception
            com.applovin.impl.sdk.a.g r1 = r4.currentAd
            if (r1 == 0) goto L_0x0086
            r4.m677P()
            com.applovin.impl.sdk.a.g r1 = r4.currentAd
            r4.m708c((com.applovin.sdk.AppLovinAd) r1)
        L_0x0086:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0668o.onDestroy():void");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.logger.mo9584b("InterActivity", "App paused...");
        this.f607p = System.currentTimeMillis();
        if (this.postitialWasDisplayed) {
            m674M();
        }
        this.f584K.mo9094a();
        pauseReportRewardTask();
        m704b("javascript:al_onAppPaused();");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        C0651i iVar;
        C0651i iVar2;
        try {
            super.onResume();
            this.logger.mo9584b("InterActivity", "App resumed...");
            if (!this.f604m) {
                C0981d dVar = this.f594c;
                if (dVar != null) {
                    dVar.mo9178d(System.currentTimeMillis() - this.f607p);
                }
                if (!((Boolean) this.sdk.mo9379b(C0967d.f1868w, Boolean.FALSE)).booleanValue() || this.f584K.mo9099d() || this.postitialWasDisplayed) {
                    boolean z = (this.currentAd instanceof C0924a) && ((C0924a) this.currentAd).mo8960l();
                    if (this.currentAd != null && ((Boolean) this.sdk.mo9350a(C0965b.f1654bZ)).booleanValue() && this.postitialWasDisplayed && (iVar = this.f577D) != null && !z) {
                        m682a(0, iVar);
                    }
                } else {
                    m675N();
                    m757y();
                    if (this.currentAd != null && ((Boolean) this.sdk.mo9350a(C0965b.f1654bZ)).booleanValue() && !this.postitialWasDisplayed && this.f602k && (iVar2 = this.f579F) != null) {
                        m682a(0, iVar2);
                    }
                }
                resumeReportRewardTask();
            } else if (!this.f584K.mo9099d() && !this.postitialWasDisplayed && this.currentAd != null) {
                m757y();
            }
            m704b("javascript:al_onAppResumed();");
        } catch (IllegalArgumentException unused) {
            exitWithError("Error was encountered in onResume().");
        }
    }

    public void onRingerModeChanged(int i) {
        String str;
        if (this.f616y != C1044f.f2116a) {
            this.f617z = true;
        }
        C0638d p = this.f592a.getAdViewController().mo8109p();
        if (p != null) {
            if (C1044f.m2057a(i) && !C1044f.m2057a(this.f616y)) {
                str = "javascript:al_muteSwitchOn();";
            } else if (i == 2) {
                str = "javascript:al_muteSwitchOff();";
            }
            p.mo8128a(str);
        }
        this.f616y = i;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("instance_impression_tracked", this.f614w.get());
        bundle.putInt("original_orientation", this.f612u);
    }

    public void onWindowFocusChanged(boolean z) {
        String str;
        super.onWindowFocusChanged(z);
        C1062k kVar = this.sdk;
        if (z) {
            if (kVar != null) {
                this.logger.mo9584b("InterActivity", "Window gained focus");
                try {
                    if (!C1119g.m2530c() || !((Boolean) this.sdk.mo9350a(C0965b.f1730cx)).booleanValue() || !m694a()) {
                        getWindow().setFlags(1024, 1024);
                    } else {
                        m698b();
                        this.f575B.postDelayed(new Runnable() {
                            public void run() {
                                C0668o.this.m698b();
                            }
                        }, 2500);
                    }
                    if (!this.postitialWasDisplayed) {
                        m675N();
                        resumeReportRewardTask();
                    }
                } catch (Throwable th) {
                    this.logger.mo9585b("InterActivity", "Setting window flags failed.", th);
                }
                this.f604m = false;
                m704b("javascript:al_onWindowFocusChanged( " + z + " );");
            }
            str = "Window gained focus. SDK is null.";
        } else if (kVar != null) {
            this.logger.mo9584b("InterActivity", "Window lost focus");
            if (!this.postitialWasDisplayed) {
                m674M();
                pauseReportRewardTask();
            }
            this.f604m = false;
            m704b("javascript:al_onWindowFocusChanged( " + z + " );");
        } else {
            str = "Window lost focus. SDK is null.";
        }
        C1107r.m2481f("InterActivity", str);
        this.f604m = false;
        m704b("javascript:al_onWindowFocusChanged( " + z + " );");
    }

    public void pauseReportRewardTask() {
        C1157p pVar = this.f589P;
        if (pVar != null) {
            pVar.mo9662b();
        }
    }

    /* access modifiers changed from: protected */
    public void playVideo() {
        m716d((AppLovinAd) this.currentAd);
        this.videoView.start();
        this.countdownManager.mo8194a();
    }

    public void resumeReportRewardTask() {
        C1157p pVar = this.f589P;
        if (pVar != null) {
            pVar.mo9663c();
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldContinueFullLengthVideoCountdown() {
        return !this.f595d && !this.postitialWasDisplayed;
    }

    public void showPostitial() {
        View view;
        try {
            m672K();
            C0667n nVar = this.f592a;
            if (nVar != null) {
                ViewParent parent = nVar.getParent();
                if ((parent instanceof ViewGroup) && (!((Boolean) this.sdk.mo9350a(C0965b.f1785eA)).booleanValue() || parent != this.f576C)) {
                    ((ViewGroup) parent).removeView(this.f592a);
                }
                C1062k kVar = this.sdk;
                C0965b bVar = C0965b.f1785eA;
                FrameLayout frameLayout = ((Boolean) kVar.mo9350a(bVar)).booleanValue() ? this.f576C : new FrameLayout(this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(this.currentAd.mo8998G());
                if (((Boolean) this.sdk.mo9350a(bVar)).booleanValue()) {
                    this.f592a.setVisibility(0);
                } else {
                    frameLayout.addView(this.f592a);
                }
                if (this.f576C != null) {
                    if (((Boolean) this.sdk.mo9350a(bVar)).booleanValue()) {
                        C1113b.m2506a(this.f576C, this.f592a);
                    } else {
                        this.f576C.removeAllViewsInLayout();
                    }
                }
                if (m736n() && (view = this.f578E) != null) {
                    if (view.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f578E.getParent()).removeView(this.f578E);
                    }
                    frameLayout.addView(this.f578E);
                    this.f578E.bringToFront();
                }
                C0651i iVar = this.f577D;
                if (iVar != null) {
                    ViewParent parent2 = iVar.getParent();
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).removeView(this.f577D);
                    }
                    frameLayout.addView(this.f577D);
                    this.f577D.bringToFront();
                }
                if (!((Boolean) this.sdk.mo9350a(bVar)).booleanValue()) {
                    setContentView(frameLayout);
                }
                if (((Boolean) this.sdk.mo9350a(C0965b.f1831ex)).booleanValue()) {
                    this.f592a.setVisibility(4);
                    this.f592a.setVisibility(0);
                }
                m692a("javascript:al_onPoststitialShow();", (long) this.currentAd.mo9008Q());
            }
            if ((this.currentAd instanceof C0924a) && ((C0924a) this.currentAd).mo8960l()) {
                this.logger.mo9584b("InterActivity", "Skip showing of close button");
            } else if (this.currentAd.mo9068t() >= 0) {
                m682a(C1160r.m2738b((float) this.currentAd.mo9068t()), this.f577D);
            } else if (this.currentAd.mo9068t() == -2) {
                this.f577D.setVisibility(0);
            } else {
                m682a(0, this.f577D);
            }
            this.postitialWasDisplayed = true;
        } catch (Throwable th) {
            this.logger.mo9585b("InterActivity", "Encountered error while showing postitial. Dismissing...", th);
            dismiss();
        }
    }

    public void skipVideo() {
        this.f610s = SystemClock.elapsedRealtime() - this.f609r;
        C0981d dVar = this.f594c;
        if (dVar != null) {
            dVar.mo9180f();
        }
        if (this.currentAd.mo9071w()) {
            dismiss();
        } else {
            showPostitial();
        }
    }

    public void toggleMute() {
        boolean z = !m673L();
        try {
            m709c(z);
            m693a(z);
            m705b(z);
        } catch (Throwable th) {
            this.logger.mo9585b("InterActivity", "Unable to set volume to " + z, th);
        }
    }
}
