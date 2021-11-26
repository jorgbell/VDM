package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.g0 */
public class C1309g0 extends C1340m0 {

    /* renamed from: d */
    private LinearLayout f3131d;

    /* renamed from: e */
    private LinearLayout f3132e;

    /* renamed from: f */
    private C1355o1 f3133f;

    /* renamed from: g */
    private C1359p1 f3134g;

    /* renamed from: h */
    private TextView f3135h;

    /* renamed from: i */
    private TextView f3136i;

    /* renamed from: com.chartboost.sdk.impl.g0$a */
    class C1310a extends C1359p1 {
        C1310a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10432a(MotionEvent motionEvent) {
            C1309g0.this.f3282a.mo10344i().mo10450b(motionEvent.getX(), motionEvent.getY(), (float) super.getWidth(), (float) super.getHeight());
        }
    }

    public C1309g0(Context context, C1319i0 i0Var) {
        super(context, i0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo10429a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 6.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f3131d = linearLayout;
        linearLayout.setOrientation(0);
        this.f3131d.setGravity(17);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f3132e = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f3132e.setGravity(8388627);
        C1355o1 o1Var = new C1355o1(context);
        this.f3133f = o1Var;
        o1Var.setPadding(round, round, round, round);
        if (this.f3282a.f3190P.mo10060e()) {
            this.f3133f.mo10558a(this.f3282a.f3190P);
        }
        C1310a aVar = new C1310a(context);
        this.f3134g = aVar;
        aVar.setPadding(round, round, round, round);
        if (this.f3282a.f3191Q.mo10060e()) {
            this.f3134g.mo10569a(this.f3282a.f3191Q);
        }
        TextView textView = new TextView(getContext());
        this.f3135h = textView;
        textView.setTextColor(-15264491);
        this.f3135h.setTypeface((Typeface) null, 1);
        this.f3135h.setGravity(8388611);
        this.f3135h.setPadding(round, round, round, round / 2);
        TextView textView2 = new TextView(getContext());
        this.f3136i = textView2;
        textView2.setTextColor(-15264491);
        this.f3136i.setTypeface((Typeface) null, 1);
        this.f3136i.setGravity(8388611);
        this.f3136i.setPadding(round, 0, round, round);
        this.f3135h.setTextSize(2, 14.0f);
        this.f3136i.setTextSize(2, 11.0f);
        this.f3132e.addView(this.f3135h);
        this.f3132e.addView(this.f3136i);
        this.f3131d.addView(this.f3133f);
        this.f3131d.addView(this.f3132e, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f3131d.addView(this.f3134g);
        return this.f3131d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo10431b() {
        return 72;
    }

    /* renamed from: a */
    public void mo10430a(String str, String str2) {
        this.f3135h.setText(str);
        this.f3136i.setText(str2);
    }
}
