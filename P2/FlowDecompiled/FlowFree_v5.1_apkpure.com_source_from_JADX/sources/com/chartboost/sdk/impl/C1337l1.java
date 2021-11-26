package com.chartboost.sdk.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.chartboost.sdk.C1284h;
import com.chartboost.sdk.Libraries.CBLogging;

/* renamed from: com.chartboost.sdk.impl.l1 */
public class C1337l1 extends FrameLayout {

    /* renamed from: a */
    private View f3277a;

    /* renamed from: b */
    private boolean f3278b;

    /* renamed from: com.chartboost.sdk.impl.l1$a */
    public interface C1338a {
        /* renamed from: a */
        void mo10462a();

        /* renamed from: a */
        void mo10463a(int i);

        /* renamed from: a */
        void mo10464a(int i, int i2);

        /* renamed from: a */
        void mo10465a(MediaPlayer.OnCompletionListener onCompletionListener);

        /* renamed from: a */
        void mo10466a(MediaPlayer.OnErrorListener onErrorListener);

        /* renamed from: a */
        void mo10467a(MediaPlayer.OnPreparedListener onPreparedListener);

        /* renamed from: a */
        void mo10468a(Uri uri);

        /* renamed from: b */
        int mo10470b();

        /* renamed from: c */
        boolean mo10471c();

        /* renamed from: d */
        int mo10472d();

        /* renamed from: e */
        void mo10473e();
    }

    public C1337l1(Context context) {
        super(context);
        m3603b();
    }

    /* renamed from: b */
    private void m3603b() {
        this.f3278b = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Choosing ");
        sb.append(this.f3278b ? "texture" : "surface");
        sb.append(" solution for video playback");
        CBLogging.m2907c("VideoInit", sb.toString());
        C1284h a = C1284h.m3343a();
        if (this.f3278b) {
            this.f3277a = (View) a.mo10361a(new C1333k1(getContext()));
        } else {
            this.f3277a = (View) a.mo10361a(new C1330j1(getContext()));
        }
        this.f3277a.setContentDescription("CBVideo");
        addView(this.f3277a, new FrameLayout.LayoutParams(-1, -1));
        if (!this.f3278b) {
            ((SurfaceView) this.f3277a).setZOrderMediaOverlay(true);
        }
    }

    /* renamed from: a */
    public C1338a mo10506a() {
        return (C1338a) this.f3277a;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mo10506a().mo10464a(i, i2);
    }
}
