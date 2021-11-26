package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.C1279f;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.l0 */
public class C1335l0 extends LinearLayout {

    /* renamed from: a */
    final C1319i0 f3270a;

    /* renamed from: b */
    private LinearLayout f3271b;

    /* renamed from: c */
    private C1355o1 f3272c;

    /* renamed from: d */
    private TextView f3273d;

    /* renamed from: e */
    final C1359p1 f3274e;

    /* renamed from: f */
    private int f3275f = Integer.MIN_VALUE;

    /* renamed from: com.chartboost.sdk.impl.l0$a */
    class C1336a extends C1359p1 {
        C1336a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10432a(MotionEvent motionEvent) {
            C1335l0.this.f3274e.setEnabled(false);
            C1335l0.this.f3270a.mo10344i().mo10456g();
        }
    }

    public C1335l0(Context context, C1319i0 i0Var) {
        super(context);
        this.f3270a = i0Var;
        int round = Math.round(context.getResources().getDisplayMetrics().density * 8.0f);
        setOrientation(1);
        setGravity(17);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f3271b = linearLayout;
        linearLayout.setGravity(17);
        this.f3271b.setOrientation(0);
        this.f3271b.setPadding(round, round, round, round);
        C1355o1 o1Var = new C1355o1(context);
        this.f3272c = o1Var;
        o1Var.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f3272c.setPadding(0, 0, round, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        i0Var.mo10436a(layoutParams, i0Var.f3188N, 1.0f);
        TextView textView = new TextView(getContext());
        this.f3273d = textView;
        textView.setTextColor(-1);
        this.f3273d.setTypeface((Typeface) null, 1);
        this.f3273d.setGravity(17);
        this.f3273d.setTextSize(2, C1279f.m3312b(context) ? 26.0f : 16.0f);
        this.f3271b.addView(this.f3272c, layoutParams);
        this.f3271b.addView(this.f3273d, new LinearLayout.LayoutParams(-2, -2));
        C1336a aVar = new C1336a(getContext());
        this.f3274e = aVar;
        aVar.setContentDescription("CBWatch");
        aVar.setPadding(0, 0, 0, round);
        aVar.mo10568a(ImageView.ScaleType.FIT_CENTER);
        aVar.setPadding(round, round, round, round);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        i0Var.mo10436a(layoutParams2, i0Var.f3187M, 1.0f);
        this.f3272c.mo10558a(i0Var.f3188N);
        aVar.mo10569a(i0Var.f3187M);
        addView(this.f3271b, new LinearLayout.LayoutParams(-2, -2));
        addView(aVar, layoutParams2);
        mo10503a();
    }

    /* renamed from: a */
    public void mo10505a(boolean z) {
        setBackgroundColor(z ? -16777216 : this.f3275f);
    }

    /* renamed from: a */
    public void mo10504a(String str, int i) {
        this.f3273d.setText(str);
        this.f3275f = i;
        mo10505a(this.f3270a.mo10447t());
    }

    /* renamed from: a */
    public void mo10503a() {
        mo10505a(this.f3270a.mo10447t());
    }
}
