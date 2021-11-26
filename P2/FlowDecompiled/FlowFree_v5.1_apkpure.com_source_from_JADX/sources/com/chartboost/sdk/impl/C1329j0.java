package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C1222i;
import com.chartboost.sdk.Libraries.CBUtility;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.j0 */
public class C1329j0 extends C1340m0 {

    /* renamed from: d */
    private LinearLayout f3219d;

    /* renamed from: e */
    private C1355o1 f3220e;

    /* renamed from: f */
    private TextView f3221f;

    public C1329j0(Context context, C1319i0 i0Var) {
        super(context, i0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo10429a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f3219d = linearLayout;
        linearLayout.setOrientation(0);
        this.f3219d.setGravity(17);
        int a = CBUtility.m2912a(36, context);
        C1355o1 o1Var = new C1355o1(context);
        this.f3220e = o1Var;
        o1Var.setPadding(round, round, round, round);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        this.f3220e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TextView textView = new TextView(context);
        this.f3221f = textView;
        textView.setPadding(round / 2, round, round, round);
        this.f3221f.setTextColor(-15264491);
        this.f3221f.setTextSize(2, 16.0f);
        this.f3221f.setTypeface((Typeface) null, 1);
        this.f3221f.setGravity(17);
        this.f3219d.addView(this.f3220e, layoutParams);
        this.f3219d.addView(this.f3221f, new LinearLayout.LayoutParams(-2, -1));
        return this.f3219d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo10431b() {
        return 48;
    }

    /* renamed from: a */
    public void mo10460a(C1222i iVar) {
        this.f3220e.mo10558a(iVar);
        this.f3220e.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    /* renamed from: a */
    public void mo10461a(String str) {
        this.f3221f.setText(str);
    }
}
