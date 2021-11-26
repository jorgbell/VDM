package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class AppLovinVideoViewV2 extends SurfaceView implements MediaController.MediaPlayerControl {

    /* renamed from: A */
    private final MediaPlayer.OnCompletionListener f251A = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            int unused = AppLovinVideoViewV2.this.f260e = 5;
            int unused2 = AppLovinVideoViewV2.this.f261f = 5;
            if (AppLovinVideoViewV2.this.f269n != null) {
                AppLovinVideoViewV2.this.f269n.onCompletion(AppLovinVideoViewV2.this.f263h);
            }
            if (AppLovinVideoViewV2.this.f279x != 0) {
                AppLovinVideoViewV2.this.f278w.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
        }
    };

    /* renamed from: B */
    private final MediaPlayer.OnInfoListener f252B = new MediaPlayer.OnInfoListener() {
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (AppLovinVideoViewV2.this.f273r == null) {
                return true;
            }
            AppLovinVideoViewV2.this.f273r.onInfo(mediaPlayer, i, i2);
            return true;
        }
    };

    /* renamed from: C */
    private final MediaPlayer.OnErrorListener f253C = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C1107r a = AppLovinVideoViewV2.this.f256a;
            a.mo9584b("AppLovinVideoView", "Media player error: " + i + ", " + i2);
            int unused = AppLovinVideoViewV2.this.f260e = -1;
            int unused2 = AppLovinVideoViewV2.this.f261f = -1;
            if (AppLovinVideoViewV2.this.f272q == null || AppLovinVideoViewV2.this.f272q.onError(AppLovinVideoViewV2.this.f263h, i, i2)) {
            }
            return true;
        }
    };

    /* renamed from: D */
    private final MediaPlayer.OnBufferingUpdateListener f254D = new MediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            C1107r a = AppLovinVideoViewV2.this.f256a;
            a.mo9584b("AppLovinVideoView", "Buffered: " + i + "%");
            int unused = AppLovinVideoViewV2.this.f271p = i;
        }
    };

    /* renamed from: E */
    private final MediaPlayer.OnSeekCompleteListener f255E = new MediaPlayer.OnSeekCompleteListener() {
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            AppLovinVideoViewV2.this.f256a.mo9584b("AppLovinVideoView", "Seek finished");
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1107r f256a;

    /* renamed from: b */
    private final C0934g.C0939d f257b;

    /* renamed from: c */
    private final C1062k f258c;

    /* renamed from: d */
    private Uri f259d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f260e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f261f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SurfaceHolder f262g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MediaPlayer f263h = null;

    /* renamed from: i */
    private int f264i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f265j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f266k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f267l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f268m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public MediaPlayer.OnCompletionListener f269n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public MediaPlayer.OnPreparedListener f270o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f271p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public MediaPlayer.OnErrorListener f272q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public MediaPlayer.OnInfoListener f273r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f274s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f275t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f276u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f277v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public AudioManager f278w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f279x = 1;

    /* renamed from: y */
    private final MediaPlayer.OnVideoSizeChangedListener f280y = new MediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            int unused = AppLovinVideoViewV2.this.f265j = mediaPlayer.getVideoWidth();
            int unused2 = AppLovinVideoViewV2.this.f266k = mediaPlayer.getVideoHeight();
            if (AppLovinVideoViewV2.this.f265j != 0 && AppLovinVideoViewV2.this.f266k != 0) {
                AppLovinVideoViewV2.this.getHolder().setFixedSize(AppLovinVideoViewV2.this.f265j, AppLovinVideoViewV2.this.f266k);
                AppLovinVideoViewV2.this.requestLayout();
            }
        }
    };

    /* renamed from: z */
    private final MediaPlayer.OnPreparedListener f281z = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            int unused = AppLovinVideoViewV2.this.f260e = 2;
            AppLovinVideoViewV2 appLovinVideoViewV2 = AppLovinVideoViewV2.this;
            boolean unused2 = appLovinVideoViewV2.f275t = appLovinVideoViewV2.f276u = appLovinVideoViewV2.f277v = true;
            if (AppLovinVideoViewV2.this.f270o != null) {
                AppLovinVideoViewV2.this.f270o.onPrepared(AppLovinVideoViewV2.this.f263h);
            }
            int unused3 = AppLovinVideoViewV2.this.f265j = mediaPlayer.getVideoWidth();
            int unused4 = AppLovinVideoViewV2.this.f266k = mediaPlayer.getVideoHeight();
            int g = AppLovinVideoViewV2.this.f274s;
            if (g != 0) {
                AppLovinVideoViewV2.this.seekTo(g);
            }
            if (AppLovinVideoViewV2.this.f265j != 0 && AppLovinVideoViewV2.this.f266k != 0) {
                AppLovinVideoViewV2.this.getHolder().setFixedSize(AppLovinVideoViewV2.this.f265j, AppLovinVideoViewV2.this.f266k);
                if (!(AppLovinVideoViewV2.this.f267l == AppLovinVideoViewV2.this.f265j && AppLovinVideoViewV2.this.f268m == AppLovinVideoViewV2.this.f266k && AppLovinVideoViewV2.this.f261f == 3)) {
                    return;
                }
            } else if (AppLovinVideoViewV2.this.f261f != 3) {
                return;
            }
            AppLovinVideoViewV2.this.start();
        }
    };

    public AppLovinVideoViewV2(C0934g.C0939d dVar, Context context, C1062k kVar) {
        super(context);
        this.f257b = dVar;
        this.f256a = kVar.mo9411z();
        this.f258c = kVar;
        this.f278w = (AudioManager) context.getSystemService("audio");
        getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                C1107r a = AppLovinVideoViewV2.this.f256a;
                a.mo9584b("AppLovinVideoView", "Surface changed with format: " + i + ", width: " + i2 + ", height: " + i3);
                int unused = AppLovinVideoViewV2.this.f267l = i2;
                int unused2 = AppLovinVideoViewV2.this.f268m = i3;
                boolean z = false;
                boolean z2 = AppLovinVideoViewV2.this.f261f == 3 || AppLovinVideoViewV2.this.f261f == 4;
                if (AppLovinVideoViewV2.this.f265j == i2 && AppLovinVideoViewV2.this.f266k == i3) {
                    z = true;
                }
                if (AppLovinVideoViewV2.this.f263h != null && z2 && z) {
                    if (AppLovinVideoViewV2.this.f274s != 0) {
                        AppLovinVideoViewV2 appLovinVideoViewV2 = AppLovinVideoViewV2.this;
                        appLovinVideoViewV2.seekTo(appLovinVideoViewV2.f274s);
                    }
                    AppLovinVideoViewV2.this.start();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppLovinVideoViewV2.this.f256a.mo9584b("AppLovinVideoView", "Surface created");
                SurfaceHolder unused = AppLovinVideoViewV2.this.f262g = surfaceHolder;
                if (AppLovinVideoViewV2.this.f263h != null) {
                    AppLovinVideoViewV2.this.f263h.setSurface(surfaceHolder.getSurface());
                } else {
                    AppLovinVideoViewV2.this.m323a();
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppLovinVideoViewV2.this.f256a.mo9584b("AppLovinVideoView", "Surface destroyed");
                SurfaceHolder unused = AppLovinVideoViewV2.this.f262g = null;
            }
        });
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f260e = 0;
        this.f261f = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m323a() {
        this.f256a.mo9584b("AppLovinVideoView", "Opening video");
        if (this.f259d != null && this.f262g != null) {
            if (this.f263h != null) {
                this.f256a.mo9584b("AppLovinVideoView", "Using existing MediaPlayer");
                this.f263h.start();
                return;
            }
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f263h = mediaPlayer;
                int i = this.f264i;
                if (i != 0) {
                    mediaPlayer.setAudioSessionId(i);
                } else {
                    this.f264i = mediaPlayer.getAudioSessionId();
                }
                this.f263h.setOnPreparedListener(this.f281z);
                this.f263h.setOnVideoSizeChangedListener(this.f280y);
                this.f263h.setOnCompletionListener(this.f251A);
                this.f263h.setOnErrorListener(this.f253C);
                this.f263h.setOnInfoListener(this.f252B);
                this.f263h.setOnBufferingUpdateListener(this.f254D);
                this.f263h.setOnSeekCompleteListener(this.f255E);
                this.f271p = 0;
                this.f263h.setDataSource(getContext(), this.f259d, (Map) null);
                this.f263h.setDisplay(this.f262g);
                this.f263h.setScreenOnWhilePlaying(true);
                this.f263h.prepareAsync();
                this.f260e = 1;
            } catch (Throwable th) {
                C1107r.m2480c("AppLovinVideoView", "Unable to open video: " + this.f259d, th);
                this.f260e = -1;
                this.f261f = -1;
                this.f253C.onError(this.f263h, 1, 0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.f260e;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m327b() {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.f263h
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.f260e
            r2 = -1
            if (r0 == r2) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            if (r0 == r1) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinVideoViewV2.m327b():boolean");
    }

    public boolean canPause() {
        return this.f275t;
    }

    public boolean canSeekBackward() {
        return this.f276u;
    }

    public boolean canSeekForward() {
        return this.f277v;
    }

    public int getAudioSessionId() {
        if (this.f264i == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f264i = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.f264i;
    }

    public int getBufferPercentage() {
        if (this.f263h != null) {
            return this.f271p;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (m327b()) {
            return this.f263h.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (m327b()) {
            return this.f263h.getDuration();
        }
        return -1;
    }

    public boolean isPlaying() {
        return m327b() && this.f263h.isPlaying();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = SurfaceView.getDefaultSize(this.f265j, i);
        int defaultSize2 = SurfaceView.getDefaultSize(this.f266k, i2);
        if (this.f265j > 0 && this.f266k > 0) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = this.f265j;
            int i4 = i3 * defaultSize2;
            int i5 = this.f266k;
            boolean z = true;
            boolean z2 = i4 < defaultSize * i5;
            if (i3 * defaultSize2 <= defaultSize * i5) {
                z = false;
            }
            C0934g.C0939d dVar = this.f257b;
            if (dVar == C0934g.C0939d.RESIZE_ASPECT) {
                if (z2) {
                    defaultSize = (i3 * size2) / i5;
                    defaultSize2 = size2;
                } else {
                    if (z) {
                        defaultSize2 = (i5 * size) / i3;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (dVar == C0934g.C0939d.RESIZE_ASPECT_FILL) {
                if (z2) {
                    defaultSize2 = (int) (((float) i5) * (((float) size) / ((float) i3)));
                } else {
                    if (z) {
                        defaultSize = (int) (((float) i3) * (((float) size2) / ((float) i5)));
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            }
            defaultSize = size;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void pause() {
        this.f256a.mo9584b("AppLovinVideoView", "Pausing video");
        if (m327b() && this.f263h.isPlaying()) {
            this.f263h.pause();
        }
        this.f261f = 4;
    }

    public void resume() {
        this.f256a.mo9584b("AppLovinVideoView", "Resuming video");
        m323a();
    }

    public void seekAndStart(long j) {
        C1107r rVar = this.f256a;
        rVar.mo9584b("AppLovinVideoView", "Seeking and starting to " + j + "ms...");
        MediaPlayer mediaPlayer = this.f263h;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo((int) j);
        } else {
            this.f256a.mo9588e("AppLovinVideoView", "Media player unavailable");
        }
    }

    public void seekTo(int i) {
        C1107r rVar = this.f256a;
        rVar.mo9584b("AppLovinVideoView", "Seeking to " + i + "ms");
        if (m327b()) {
            this.f263h.seekTo(i);
            i = 0;
        } else {
            this.f256a.mo9584b("AppLovinVideoView", "Seek delayed");
        }
        this.f274s = i;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f269n = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f272q = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f273r = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f270o = onPreparedListener;
    }

    public void setVideoURI(Uri uri) {
        C1107r rVar = this.f256a;
        rVar.mo9584b("AppLovinVideoView", "Setting video uri: " + uri);
        this.f259d = uri;
        this.f274s = 0;
        m323a();
        requestLayout();
        invalidate();
    }

    public void start() {
        this.f256a.mo9584b("AppLovinVideoView", "Starting video");
        if (m327b()) {
            this.f263h.start();
        }
        this.f261f = 3;
    }

    public void stopPlayback() {
        this.f256a.mo9584b("AppLovinVideoView", "Stopping playback");
        MediaPlayer mediaPlayer = this.f263h;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            final MediaPlayer mediaPlayer2 = this.f263h;
            this.f263h = null;
            this.f260e = 0;
            this.f261f = 0;
            this.f278w.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            if (((Boolean) this.f258c.mo9350a(C0965b.f1790eF)).booleanValue()) {
                this.f258c.mo9340Q().mo9266a((C0989a) new C1042y(this.f258c, new Runnable() {
                    public void run() {
                        mediaPlayer2.release();
                    }
                }), C1020o.C1022a.BACKGROUND);
            } else {
                mediaPlayer2.release();
            }
        }
    }
}
