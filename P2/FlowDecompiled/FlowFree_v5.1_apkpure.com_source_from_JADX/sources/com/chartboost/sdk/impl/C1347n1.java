package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import com.chartboost.sdk.Model.C1228a;

/* renamed from: com.chartboost.sdk.impl.n1 */
public final class C1347n1 extends View {

    /* renamed from: a */
    private boolean f3305a = false;

    public C1347n1(Context context) {
        super(context);
        setFocusable(false);
        setBackgroundColor(-1442840576);
    }

    /* renamed from: a */
    public void mo10529a(C1342m1 m1Var, C1228a aVar) {
        if (!this.f3305a) {
            m1Var.mo10516a(true, (View) this, aVar);
            this.f3305a = true;
        }
    }
}
