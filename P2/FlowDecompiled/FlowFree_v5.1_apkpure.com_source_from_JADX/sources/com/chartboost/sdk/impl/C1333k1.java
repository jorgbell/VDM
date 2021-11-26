package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C1337l1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.k1 */
public class C1333k1 extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, C1337l1.C1338a {

    /* renamed from: a */
    private Uri f3248a;

    /* renamed from: b */
    private int f3249b;

    /* renamed from: c */
    private int f3250c = 0;

    /* renamed from: d */
    private int f3251d = 0;

    /* renamed from: e */
    private Surface f3252e = null;

    /* renamed from: f */
    private MediaPlayer f3253f = null;

    /* renamed from: g */
    private int f3254g;

    /* renamed from: h */
    private int f3255h;

    /* renamed from: i */
    private MediaPlayer.OnCompletionListener f3256i;

    /* renamed from: j */
    private MediaPlayer.OnPreparedListener f3257j;

    /* renamed from: k */
    private MediaPlayer.OnErrorListener f3258k;

    /* renamed from: l */
    private int f3259l;

    public C1333k1(Context context) {
        super(context);
        m3582g();
    }

    /* renamed from: f */
    private void m3581f() {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f3248a.toString());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            this.f3255h = Integer.parseInt(extractMetadata);
            this.f3254g = Integer.parseInt(extractMetadata2);
        } catch (Exception e) {
            CBLogging.m2906b("play video", "read size error", e);
        }
    }

    /* renamed from: g */
    private void m3582g() {
        this.f3254g = 0;
        this.f3255h = 0;
        setSurfaceTextureListener(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f3250c = 0;
        this.f3251d = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.f3250c;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3583h() {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.f3253f
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.f3250c
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
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1333k1.m3583h():boolean");
    }

    /* renamed from: i */
    private void m3584i() {
        if (this.f3248a != null && this.f3252e != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m3580a(false);
            m3581f();
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f3253f = mediaPlayer;
                mediaPlayer.setOnPreparedListener(this);
                this.f3253f.setOnVideoSizeChangedListener(this);
                this.f3249b = -1;
                this.f3253f.setOnCompletionListener(this);
                this.f3253f.setOnErrorListener(this);
                this.f3253f.setOnBufferingUpdateListener(this);
                FileInputStream fileInputStream = new FileInputStream(new File(this.f3248a.toString()));
                this.f3253f.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
                this.f3253f.setSurface(this.f3252e);
                this.f3253f.setAudioStreamType(3);
                this.f3253f.setScreenOnWhilePlaying(true);
                this.f3253f.prepareAsync();
                this.f3250c = 1;
            } catch (IOException e) {
                CBLogging.m2906b("VideoTextureView", "Unable to open content: " + this.f3248a, e);
                this.f3250c = -1;
                this.f3251d = -1;
                onError(this.f3253f, 1, 0);
            } catch (IllegalArgumentException e2) {
                CBLogging.m2906b("VideoTextureView", "Unable to open content: " + this.f3248a, e2);
                this.f3250c = -1;
                this.f3251d = -1;
                onError(this.f3253f, 1, 0);
            }
        }
    }

    /* renamed from: a */
    public void mo10468a(Uri uri) {
        mo10490a(uri, (Map<String, String>) null);
    }

    /* renamed from: b */
    public int mo10470b() {
        if (m3583h()) {
            int i = this.f3249b;
            if (i > 0) {
                return i;
            }
            int duration = this.f3253f.getDuration();
            this.f3249b = duration;
            return duration;
        }
        this.f3249b = -1;
        return -1;
    }

    /* renamed from: c */
    public boolean mo10471c() {
        return m3583h() && this.f3253f.isPlaying();
    }

    /* renamed from: d */
    public int mo10472d() {
        if (m3583h()) {
            return this.f3253f.getCurrentPosition();
        }
        return 0;
    }

    /* renamed from: e */
    public void mo10473e() {
        if (m3583h() && this.f3253f.isPlaying()) {
            this.f3253f.pause();
            this.f3250c = 4;
        }
        this.f3251d = 4;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3251d = 5;
        if (this.f3250c != 5) {
            this.f3250c = 5;
            MediaPlayer.OnCompletionListener onCompletionListener = this.f3256i;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this.f3253f);
            }
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        CBLogging.m2903a("VideoTextureView", "Error: " + i + "," + i2);
        if (i == 100) {
            m3584i();
            return true;
        }
        this.f3250c = -1;
        this.f3251d = -1;
        MediaPlayer.OnErrorListener onErrorListener = this.f3258k;
        if (onErrorListener == null || onErrorListener.onError(this.f3253f, i, i2)) {
        }
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f3250c = 2;
        this.f3254g = mediaPlayer.getVideoWidth();
        this.f3255h = mediaPlayer.getVideoHeight();
        MediaPlayer.OnPreparedListener onPreparedListener = this.f3257j;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this.f3253f);
        }
        int i = this.f3259l;
        if (i != 0) {
            mo10463a(i);
        }
        if (this.f3251d == 3) {
            mo10462a();
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f3252e = new Surface(surfaceTexture);
        m3584i();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f3252e = null;
        m3580a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = this.f3251d == 3;
        if (this.f3253f != null && z) {
            int i3 = this.f3259l;
            if (i3 != 0) {
                mo10463a(i3);
            }
            mo10462a();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f3254g = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f3255h = videoHeight;
        if (this.f3254g != 0 && videoHeight != 0) {
            mo10464a(getWidth(), getHeight());
        }
    }

    /* renamed from: a */
    public void mo10464a(int i, int i2) {
        int i3;
        int i4 = this.f3254g;
        if (i4 != 0 && (i3 = this.f3255h) != 0 && i != 0 && i2 != 0) {
            float f = (float) i;
            float f2 = (float) i2;
            float min = Math.min(f / ((float) i4), f2 / ((float) i3));
            float f3 = ((float) this.f3254g) * min;
            float f4 = min * ((float) this.f3255h);
            Matrix matrix = new Matrix();
            matrix.setScale(f3 / f, f4 / f2, f / 2.0f, f2 / 2.0f);
            setTransform(matrix);
        }
    }

    /* renamed from: a */
    public void mo10490a(Uri uri, Map<String, String> map) {
        this.f3248a = uri;
        this.f3259l = 0;
        m3584i();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void mo10467a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f3257j = onPreparedListener;
    }

    /* renamed from: a */
    public void mo10465a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f3256i = onCompletionListener;
    }

    /* renamed from: a */
    public void mo10466a(MediaPlayer.OnErrorListener onErrorListener) {
        this.f3258k = onErrorListener;
    }

    /* renamed from: a */
    private void m3580a(boolean z) {
        MediaPlayer mediaPlayer = this.f3253f;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f3253f.release();
            this.f3253f = null;
            this.f3250c = 0;
            if (z) {
                this.f3251d = 0;
            }
        }
    }

    /* renamed from: a */
    public void mo10462a() {
        if (m3583h()) {
            this.f3253f.start();
            this.f3250c = 3;
        }
        this.f3251d = 3;
    }

    /* renamed from: a */
    public void mo10463a(int i) {
        if (m3583h()) {
            this.f3253f.seekTo(i);
            this.f3259l = 0;
            return;
        }
        this.f3259l = i;
    }
}
