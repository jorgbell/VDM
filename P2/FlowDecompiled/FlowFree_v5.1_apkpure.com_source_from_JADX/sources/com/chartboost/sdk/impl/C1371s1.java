package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C1279f;
import com.chartboost.sdk.Model.C1230c;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.s1 */
public class C1371s1 extends RelativeLayout {

    /* renamed from: a */
    private C1279f.C1281b f3371a;

    /* renamed from: b */
    private C1347n1 f3372b;

    /* renamed from: c */
    private C1347n1 f3373c;

    /* renamed from: d */
    private final C1230c f3374d;

    public C1371s1(Context context, C1230c cVar) {
        super(context);
        this.f3374d = cVar;
        if (cVar.f2751q.f2709b == 0) {
            C1347n1 n1Var = new C1347n1(context);
            this.f3372b = n1Var;
            addView(n1Var, new RelativeLayout.LayoutParams(-1, -1));
            C1347n1 n1Var2 = new C1347n1(context);
            this.f3373c = n1Var2;
            addView(n1Var2, new RelativeLayout.LayoutParams(-1, -1));
            this.f3373c.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo10601a() {
    }

    /* renamed from: b */
    public C1347n1 mo10602b() {
        return this.f3372b;
    }

    /* renamed from: c */
    public View mo10603c() {
        return this.f3371a;
    }

    /* renamed from: d */
    public C1230c mo10604d() {
        return this.f3374d;
    }

    /* renamed from: e */
    public boolean mo10605e() {
        C1279f.C1281b bVar = this.f3371a;
        return bVar != null && bVar.getVisibility() == 0;
    }

    /* renamed from: f */
    public void mo10606f() {
        if (this.f3371a == null) {
            C1279f.C1281b j = this.f3374d.mo10096j();
            this.f3371a = j;
            if (j != null) {
                addView(j, new RelativeLayout.LayoutParams(-1, -1));
                this.f3371a.mo10356b();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        performClick();
        return true;
    }

    public boolean performClick() {
        super.performClick();
        return true;
    }
}
