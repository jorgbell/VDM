package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C1337l1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.j1 */
public class C1330j1 extends SurfaceView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, C1337l1.C1338a {

    /* renamed from: a */
    private Uri f3222a;

    /* renamed from: b */
    private int f3223b;

    /* renamed from: c */
    private int f3224c = 0;

    /* renamed from: d */
    private int f3225d = 0;

    /* renamed from: e */
    private SurfaceHolder f3226e = null;

    /* renamed from: f */
    private MediaPlayer f3227f = null;

    /* renamed from: g */
    private int f3228g;

    /* renamed from: h */
    private int f3229h;

    /* renamed from: i */
    private int f3230i;

    /* renamed from: j */
    private int f3231j;

    /* renamed from: k */
    private MediaPlayer.OnCompletionListener f3232k;

    /* renamed from: l */
    private MediaPlayer.OnPreparedListener f3233l;

    /* renamed from: m */
    private MediaPlayer.OnErrorListener f3234m;

    /* renamed from: n */
    private int f3235n;

    public C1330j1(Context context) {
        super(context);
        m3558f();
    }

    /* renamed from: f */
    private void m3558f() {
        this.f3228g = 0;
        this.f3229h = 0;
        getHolder().addCallback(this);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f3224c = 0;
        this.f3225d = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.f3224c;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3559g() {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.f3227f
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.f3224c
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
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1330j1.m3559g():boolean");
    }

    /* renamed from: h */
    private void m3560h() {
        if (this.f3222a != null && this.f3226e != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m3557a(false);
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f3227f = mediaPlayer;
                mediaPlayer.setOnPreparedListener(this);
                this.f3227f.setOnVideoSizeChangedListener(this);
                this.f3223b = -1;
                this.f3227f.setOnCompletionListener(this);
                this.f3227f.setOnErrorListener(this);
                this.f3227f.setOnBufferingUpdateListener(this);
                this.f3227f.setDisplay(this.f3226e);
                this.f3227f.setAudioStreamType(3);
                this.f3227f.setScreenOnWhilePlaying(true);
                FileInputStream fileInputStream = new FileInputStream(new File(this.f3222a.toString()));
                this.f3227f.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
                this.f3227f.prepareAsync();
                this.f3224c = 1;
            } catch (IOException e) {
                CBLogging.m2906b("VideoSurfaceView", "Unable to open content: " + this.f3222a, e);
                this.f3224c = -1;
                this.f3225d = -1;
                onError(this.f3227f, 1, 0);
            } catch (IllegalArgumentException e2) {
                CBLogging.m2906b("VideoSurfaceView", "Unable to open content: " + this.f3222a, e2);
                this.f3224c = -1;
                this.f3225d = -1;
                onError(this.f3227f, 1, 0);
            }
        }
    }

    /* renamed from: a */
    public void mo10464a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo10468a(Uri uri) {
        mo10469a(uri, (Map<String, String>) null);
    }

    /* renamed from: b */
    public int mo10470b() {
        if (m3559g()) {
            int i = this.f3223b;
            if (i > 0) {
                return i;
            }
            int duration = this.f3227f.getDuration();
            this.f3223b = duration;
            return duration;
        }
        this.f3223b = -1;
        return -1;
    }

    /* renamed from: c */
    public boolean mo10471c() {
        return m3559g() && this.f3227f.isPlaying();
    }

    /* renamed from: d */
    public int mo10472d() {
        if (m3559g()) {
            return this.f3227f.getCurrentPosition();
        }
        return 0;
    }

    /* renamed from: e */
    public void mo10473e() {
        if (m3559g() && this.f3227f.isPlaying()) {
            this.f3227f.pause();
            this.f3224c = 4;
        }
        this.f3225d = 4;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3225d = 5;
        if (this.f3224c != 5) {
            this.f3224c = 5;
            MediaPlayer.OnCompletionListener onCompletionListener = this.f3232k;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this.f3227f);
            }
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        CBLogging.m2903a("VideoSurfaceView", "Error: " + i + "," + i2);
        this.f3224c = -1;
        this.f3225d = -1;
        MediaPlayer.OnErrorListener onErrorListener = this.f3234m;
        if (onErrorListener == null || onErrorListener.onError(this.f3227f, i, i2)) {
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = SurfaceView.getDefaultSize(0, i);
        int defaultSize2 = SurfaceView.getDefaultSize(0, i2);
        int i4 = this.f3228g;
        if (i4 > 0 && (i3 = this.f3229h) > 0) {
            int min = Math.min(defaultSize2, Math.round((((float) i3) / ((float) i4)) * ((float) defaultSize)));
            defaultSize = Math.min(defaultSize, Math.round((((float) this.f3228g) / ((float) this.f3229h)) * ((float) defaultSize2)));
            defaultSize2 = min;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f3224c = 2;
        this.f3228g = mediaPlayer.getVideoWidth();
        this.f3229h = mediaPlayer.getVideoHeight();
        MediaPlayer.OnPreparedListener onPreparedListener = this.f3233l;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this.f3227f);
        }
        int i = this.f3235n;
        if (i != 0) {
            mo10463a(i);
        }
        if (this.f3228g != 0 && this.f3229h != 0) {
            getHolder().setFixedSize(this.f3228g, this.f3229h);
            if (this.f3230i == this.f3228g && this.f3231j == this.f3229h && this.f3225d == 3) {
                mo10462a();
            }
        } else if (this.f3225d == 3) {
            mo10462a();
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f3228g = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f3229h = videoHeight;
        if (this.f3228g != 0 && videoHeight != 0) {
            getHolder().setFixedSize(this.f3228g, this.f3229h);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f3230i = i2;
        this.f3231j = i3;
        boolean z = true;
        boolean z2 = this.f3225d == 3;
        if (!(this.f3228g == i2 && this.f3229h == i3)) {
            z = false;
        }
        if (this.f3227f != null && z2 && z) {
            int i4 = this.f3235n;
            if (i4 != 0) {
                mo10463a(i4);
            }
            mo10462a();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f3226e = surfaceHolder;
        m3560h();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f3226e = null;
        m3557a(true);
    }

    /* renamed from: a */
    public void mo10469a(Uri uri, Map<String, String> map) {
        this.f3222a = uri;
        this.f3235n = 0;
        m3560h();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void mo10467a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f3233l = onPreparedListener;
    }

    /* renamed from: a */
    public void mo10465a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f3232k = onCompletionListener;
    }

    /* renamed from: a */
    public void mo10466a(MediaPlayer.OnErrorListener onErrorListener) {
        this.f3234m = onErrorListener;
    }

    /* renamed from: a */
    private void m3557a(boolean z) {
        MediaPlayer mediaPlayer = this.f3227f;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f3227f.release();
            this.f3227f = null;
            this.f3224c = 0;
            if (z) {
                this.f3225d = 0;
            }
        }
    }

    /* renamed from: a */
    public void mo10462a() {
        if (m3559g()) {
            this.f3227f.start();
            this.f3224c = 3;
        }
        this.f3225d = 3;
    }

    /* renamed from: a */
    public void mo10463a(int i) {
        if (m3559g()) {
            this.f3227f.seekTo(i);
            this.f3235n = 0;
            return;
        }
        this.f3235n = i;
    }
}
