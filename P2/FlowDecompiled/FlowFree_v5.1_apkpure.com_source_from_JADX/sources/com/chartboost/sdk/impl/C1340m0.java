package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBUtility;

/* renamed from: com.chartboost.sdk.impl.m0 */
public abstract class C1340m0 extends RelativeLayout {

    /* renamed from: a */
    protected C1319i0 f3282a;

    /* renamed from: b */
    private C1346n0 f3283b;

    /* renamed from: c */
    private int f3284c = 1;

    /* renamed from: com.chartboost.sdk.impl.m0$a */
    class C1341a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f3285a;

        C1341a(boolean z) {
            this.f3285a = z;
        }

        public void run() {
            if (!this.f3285a) {
                C1340m0.this.setVisibility(8);
                C1340m0.this.clearAnimation();
            }
            synchronized (C1340m0.this.f3282a.f3006i) {
                C1340m0 m0Var = C1340m0.this;
                m0Var.f3282a.f3006i.remove(m0Var);
            }
        }
    }

    public C1340m0(Context context, C1319i0 i0Var) {
        super(context);
        this.f3282a = i0Var;
        m3620a(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract View mo10429a();

    /* renamed from: a */
    public void mo10509a(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        this.f3284c = i;
        setClickable(false);
        int b = mo10431b();
        int i2 = this.f3284c;
        if (i2 == 0) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, CBUtility.m2912a(b, getContext()));
            layoutParams2.addRule(10);
            this.f3283b.mo10526a(1);
        } else if (i2 == 1) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, CBUtility.m2912a(b, getContext()));
            layoutParams2.addRule(12);
            this.f3283b.mo10526a(4);
        } else if (i2 == 2) {
            layoutParams2 = new RelativeLayout.LayoutParams(CBUtility.m2912a(b, getContext()), -1);
            layoutParams2.addRule(9);
            this.f3283b.mo10526a(8);
        } else if (i2 != 3) {
            layoutParams = null;
            setLayoutParams(layoutParams);
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(CBUtility.m2912a(b, getContext()), -1);
            layoutParams2.addRule(11);
            this.f3283b.mo10526a(2);
        }
        layoutParams = layoutParams2;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo10431b();

    /* renamed from: a */
    private void m3620a(Context context) {
        Context context2 = getContext();
        setGravity(17);
        C1346n0 n0Var = new C1346n0(context2);
        this.f3283b = n0Var;
        n0Var.mo10527b(-1);
        this.f3283b.setBackgroundColor(-855638017);
        addView(this.f3283b, new RelativeLayout.LayoutParams(-1, -1));
        addView(mo10429a(), new RelativeLayout.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void mo10510a(boolean z) {
        m3621a(z, 500);
    }

    /* renamed from: a */
    private void m3621a(boolean z, long j) {
        this.f3282a.f3183I = z;
        if (z && getVisibility() == 0) {
            return;
        }
        if (z || getVisibility() != 8) {
            C1341a aVar = new C1341a(z);
            if (z) {
                setVisibility(0);
            }
            float a = CBUtility.m2910a((float) mo10431b(), getContext());
            TranslateAnimation translateAnimation = null;
            int i = this.f3284c;
            if (i == 0) {
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, z ? -a : 0.0f, z ? 0.0f : -a);
            } else if (i == 1) {
                float f = z ? a : 0.0f;
                if (z) {
                    a = 0.0f;
                }
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, a);
            } else if (i == 2) {
                translateAnimation = new TranslateAnimation(z ? -a : 0.0f, z ? 0.0f : -a, 0.0f, 0.0f);
            } else if (i == 3) {
                float f2 = z ? a : 0.0f;
                if (z) {
                    a = 0.0f;
                }
                translateAnimation = new TranslateAnimation(f2, a, 0.0f, 0.0f);
            }
            translateAnimation.setDuration(j);
            translateAnimation.setFillAfter(!z);
            startAnimation(translateAnimation);
            synchronized (this.f3282a.f3006i) {
                this.f3282a.f3006i.put(this, aVar);
            }
            this.f3282a.f2998a.postDelayed(aVar, j);
        }
    }
}
