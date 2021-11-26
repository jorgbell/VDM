package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.C1284h;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.C1222i;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.impl.C1319i0;
import com.chartboost.sdk.impl.C1337l1;
import java.util.Locale;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.o0 */
public class C1349o0 extends RelativeLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: o */
    private static final CharSequence f3316o = "00:00";

    /* renamed from: a */
    final RelativeLayout f3317a;

    /* renamed from: b */
    final C1346n0 f3318b;

    /* renamed from: c */
    final C1346n0 f3319c;

    /* renamed from: d */
    final C1359p1 f3320d;

    /* renamed from: e */
    final TextView f3321e;

    /* renamed from: f */
    final C1332k0 f3322f;

    /* renamed from: g */
    final C1337l1 f3323g;

    /* renamed from: h */
    final C1319i0 f3324h;

    /* renamed from: i */
    private boolean f3325i = false;

    /* renamed from: j */
    private boolean f3326j = false;

    /* renamed from: k */
    final Handler f3327k;

    /* renamed from: l */
    private final Runnable f3328l = new C1351b();

    /* renamed from: m */
    private final Runnable f3329m = new C1352c();

    /* renamed from: n */
    final Runnable f3330n = new C1353d();

    /* renamed from: com.chartboost.sdk.impl.o0$a */
    class C1350a extends C1359p1 {
        C1350a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10432a(MotionEvent motionEvent) {
            C1349o0.this.f3324h.mo10335a(C1217e.m2937a(C1217e.m2935a("x", (Object) Float.valueOf(motionEvent.getX())), C1217e.m2935a("y", (Object) Float.valueOf(motionEvent.getY())), C1217e.m2935a("w", (Object) Integer.valueOf(C1349o0.this.f3320d.getWidth())), C1217e.m2935a("h", (Object) Integer.valueOf(C1349o0.this.f3320d.getHeight()))));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$b */
    class C1351b implements Runnable {
        C1351b() {
        }

        public void run() {
            C1349o0.this.mo10542d(false);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$c */
    class C1352c implements Runnable {
        C1352c() {
        }

        public void run() {
            C1346n0 n0Var = C1349o0.this.f3318b;
            if (n0Var != null) {
                n0Var.setVisibility(8);
            }
            C1349o0 o0Var = C1349o0.this;
            if (o0Var.f3324h.f3193S) {
                o0Var.f3322f.setVisibility(8);
            }
            C1349o0.this.f3319c.setVisibility(8);
            C1359p1 p1Var = C1349o0.this.f3320d;
            if (p1Var != null) {
                p1Var.setEnabled(false);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$d */
    class C1353d implements Runnable {

        /* renamed from: a */
        private int f3334a = 0;

        C1353d() {
        }

        public void run() {
            C1319i0.C1321b o = C1349o0.this.f3324h.mo10344i();
            if (o != null) {
                if (C1349o0.this.f3323g.mo10506a().mo10471c()) {
                    int d = C1349o0.this.f3323g.mo10506a().mo10472d();
                    if (d > 0) {
                        C1319i0 i0Var = C1349o0.this.f3324h;
                        i0Var.f3203z = d;
                        if (((float) d) / 1000.0f > 0.0f && !i0Var.mo10446s()) {
                            C1349o0.this.f3324h.mo10449v();
                            C1349o0.this.f3324h.mo10441a(true);
                        }
                    }
                    float b = ((float) d) / ((float) C1349o0.this.f3323g.mo10506a().mo10470b());
                    C1349o0 o0Var = C1349o0.this;
                    if (o0Var.f3324h.f3193S) {
                        o0Var.f3322f.mo10484a(b);
                    }
                    int i = d / 1000;
                    if (this.f3334a != i) {
                        this.f3334a = i;
                        C1349o0.this.f3321e.setText(String.format(Locale.US, "%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
                    }
                }
                if (o.mo10455f()) {
                    C1359p1 c = o.mo10451c(true);
                    if (c.getVisibility() == 8) {
                        C1349o0.this.f3324h.mo10333a(true, (View) c);
                        c.setEnabled(true);
                    }
                }
                C1349o0 o0Var2 = C1349o0.this;
                o0Var2.f3327k.removeCallbacks(o0Var2.f3330n);
                C1349o0 o0Var3 = C1349o0.this;
                o0Var3.f3327k.postDelayed(o0Var3.f3330n, 16);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$e */
    class C1354e implements Runnable {
        C1354e() {
        }

        public void run() {
            C1349o0.this.f3323g.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1349o0(Context context, C1319i0 i0Var) {
        super(context);
        Context context2 = context;
        C1319i0 i0Var2 = i0Var;
        this.f3324h = i0Var2;
        this.f3327k = i0Var2.f2998a;
        JSONObject e = i0Var.mo10340e();
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = 10.0f * f;
        int round = Math.round(f2);
        C1284h a = C1284h.m3343a();
        C1337l1 l1Var = (C1337l1) a.mo10361a(new C1337l1(context2));
        this.f3323g = l1Var;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView(l1Var, layoutParams);
        RelativeLayout relativeLayout = (RelativeLayout) a.mo10361a(new RelativeLayout(context2));
        this.f3317a = relativeLayout;
        if (e == null || e.isNull("video-click-button")) {
            this.f3318b = null;
            this.f3320d = null;
        } else {
            C1346n0 n0Var = (C1346n0) a.mo10361a(new C1346n0(context2));
            this.f3318b = n0Var;
            n0Var.setVisibility(8);
            C1350a aVar = new C1350a(context2);
            this.f3320d = aVar;
            aVar.mo10568a(ImageView.ScaleType.FIT_CENTER);
            C1222i iVar = i0Var2.f3189O;
            Point b = i0Var2.mo10437b("video-click-button");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = Math.round(((float) b.x) / iVar.mo10054a());
            layoutParams2.topMargin = Math.round(((float) b.y) / iVar.mo10054a());
            i0Var2.mo10436a(layoutParams2, iVar, 1.0f);
            aVar.mo10569a(iVar);
            n0Var.addView(aVar, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, Math.round(((float) layoutParams2.height) + f2));
            layoutParams3.addRule(10);
            relativeLayout.addView(n0Var, layoutParams3);
        }
        C1346n0 n0Var2 = (C1346n0) a.mo10361a(new C1346n0(context2));
        this.f3319c = n0Var2;
        n0Var2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, Math.round(f * 32.5f));
        layoutParams4.addRule(12);
        relativeLayout.addView(n0Var2, layoutParams4);
        n0Var2.setGravity(16);
        n0Var2.setPadding(round, round, round, round);
        TextView textView = (TextView) a.mo10361a(new TextView(context2));
        this.f3321e = textView;
        textView.setTextColor(-1);
        textView.setTextSize(2, 11.0f);
        textView.setText(f3316o);
        textView.setPadding(0, 0, round, 0);
        textView.setSingleLine();
        textView.measure(0, 0);
        int measuredWidth = textView.getMeasuredWidth();
        textView.setGravity(17);
        n0Var2.addView(textView, new LinearLayout.LayoutParams(measuredWidth, -1));
        C1332k0 k0Var = (C1332k0) a.mo10361a(new C1332k0(context2));
        this.f3322f = k0Var;
        k0Var.setVisibility(8);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, Math.round(f2));
        layoutParams5.setMargins(0, CBUtility.m2912a(1, context2), 0, 0);
        n0Var2.addView(k0Var, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(6, l1Var.getId());
        layoutParams6.addRule(8, l1Var.getId());
        layoutParams6.addRule(5, l1Var.getId());
        layoutParams6.addRule(7, l1Var.getId());
        addView(relativeLayout, layoutParams6);
        mo10546h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10536a(boolean z, boolean z2) {
        C1346n0 n0Var;
        this.f3327k.removeCallbacks(this.f3328l);
        this.f3327k.removeCallbacks(this.f3329m);
        C1319i0 i0Var = this.f3324h;
        if (i0Var.f3179E && i0Var.mo10445r() && z != this.f3325i) {
            this.f3325i = z;
            AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(z2 ? 100 : 200);
            alphaAnimation.setFillAfter(true);
            if (!this.f3326j && (n0Var = this.f3318b) != null) {
                n0Var.setVisibility(0);
                this.f3318b.startAnimation(alphaAnimation);
                C1359p1 p1Var = this.f3320d;
                if (p1Var != null) {
                    p1Var.setEnabled(true);
                }
            }
            if (this.f3324h.f3193S) {
                this.f3322f.setVisibility(0);
            }
            this.f3319c.setVisibility(0);
            this.f3319c.startAnimation(alphaAnimation);
            if (this.f3325i) {
                this.f3327k.postDelayed(this.f3328l, 3000);
            } else {
                this.f3327k.postDelayed(this.f3329m, alphaAnimation.getDuration());
            }
        }
    }

    /* renamed from: b */
    public void mo10538b(boolean z) {
        setBackgroundColor(z ? -16777216 : 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!z) {
            layoutParams.addRule(6, this.f3323g.getId());
            layoutParams.addRule(8, this.f3323g.getId());
            layoutParams.addRule(5, this.f3323g.getId());
            layoutParams.addRule(7, this.f3323g.getId());
        }
        this.f3317a.setLayoutParams(layoutParams);
        C1346n0 n0Var = this.f3318b;
        if (n0Var != null) {
            n0Var.setGravity(8388627);
            this.f3318b.requestLayout();
        }
    }

    /* renamed from: c */
    public void mo10540c(boolean z) {
        this.f3321e.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10542d(boolean z) {
        mo10536a(!this.f3325i, z);
    }

    /* renamed from: e */
    public void mo10543e() {
        if (this.f3323g.mo10506a().mo10471c()) {
            this.f3324h.f3203z = this.f3323g.mo10506a().mo10472d();
        }
        this.f3323g.mo10506a().mo10473e();
        this.f3327k.removeCallbacks(this.f3330n);
    }

    /* renamed from: f */
    public void mo10544f() {
        this.f3327k.postDelayed(new C1354e(), 500);
        this.f3323g.mo10506a().mo10462a();
        this.f3327k.removeCallbacks(this.f3330n);
        this.f3327k.postDelayed(this.f3330n, 16);
    }

    /* renamed from: g */
    public void mo10545g() {
        if (this.f3323g.mo10506a().mo10471c()) {
            this.f3324h.f3203z = this.f3323g.mo10506a().mo10472d();
            this.f3323g.mo10506a().mo10473e();
        }
        if (this.f3324h.mo10344i().f3168l.getVisibility() == 0) {
            this.f3324h.mo10344i().f3168l.postInvalidate();
        }
        this.f3327k.removeCallbacks(this.f3330n);
    }

    /* renamed from: h */
    public void mo10546h() {
        mo10538b(CBUtility.m2921b(CBUtility.m2918b(getContext())));
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3324h.f3203z = this.f3323g.mo10506a().mo10470b();
        if (this.f3324h.mo10344i() != null) {
            this.f3324h.mo10344i().mo10453e();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3327k.removeCallbacks(this.f3330n);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f3324h.mo10448u();
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f3324h.f3175A = this.f3323g.mo10506a().mo10470b();
        this.f3324h.mo10344i().mo10354a(true);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3323g.mo10506a().mo10471c() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (this.f3324h != null) {
            mo10542d(true);
        }
        return true;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        C1359p1 p1Var = this.f3320d;
        if (p1Var != null) {
            p1Var.setEnabled(z);
        }
        if (z) {
            mo10535a(false);
        }
    }

    /* renamed from: c */
    public void mo10539c() {
        this.f3323g.setVisibility(8);
        invalidate();
    }

    /* renamed from: d */
    public void mo10541d() {
        C1346n0 n0Var = this.f3318b;
        if (n0Var != null) {
            n0Var.setVisibility(8);
        }
        this.f3326j = true;
        C1359p1 p1Var = this.f3320d;
        if (p1Var != null) {
            p1Var.setEnabled(false);
        }
    }

    /* renamed from: b */
    public C1332k0 mo10537b() {
        return this.f3322f;
    }

    /* renamed from: a */
    public void mo10535a(boolean z) {
        C1346n0 n0Var;
        this.f3327k.removeCallbacks(this.f3328l);
        this.f3327k.removeCallbacks(this.f3329m);
        if (z) {
            if (!this.f3326j && (n0Var = this.f3318b) != null) {
                n0Var.setVisibility(0);
            }
            if (this.f3324h.f3193S) {
                this.f3322f.setVisibility(0);
            }
            this.f3319c.setVisibility(0);
            C1359p1 p1Var = this.f3320d;
            if (p1Var != null) {
                p1Var.setEnabled(true);
            }
        } else {
            C1346n0 n0Var2 = this.f3318b;
            if (n0Var2 != null) {
                n0Var2.clearAnimation();
                this.f3318b.setVisibility(8);
            }
            this.f3319c.clearAnimation();
            if (this.f3324h.f3193S) {
                this.f3322f.setVisibility(8);
            }
            this.f3319c.setVisibility(8);
            C1359p1 p1Var2 = this.f3320d;
            if (p1Var2 != null) {
                p1Var2.setEnabled(false);
            }
        }
        this.f3325i = z;
    }

    /* renamed from: a */
    public C1337l1.C1338a mo10532a() {
        return this.f3323g.mo10506a();
    }

    /* renamed from: a */
    public void mo10533a(int i) {
        C1346n0 n0Var = this.f3318b;
        if (n0Var != null) {
            n0Var.setBackgroundColor(i);
        }
        this.f3319c.setBackgroundColor(i);
    }

    /* renamed from: a */
    public void mo10534a(String str) {
        this.f3323g.mo10506a().mo10465a((MediaPlayer.OnCompletionListener) this);
        this.f3323g.mo10506a().mo10466a((MediaPlayer.OnErrorListener) this);
        this.f3323g.mo10506a().mo10467a((MediaPlayer.OnPreparedListener) this);
        this.f3323g.mo10506a().mo10468a(Uri.parse(str));
    }
}
