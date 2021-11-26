package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.C0651i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.m */
public class C0666m extends FrameLayout {

    /* renamed from: a */
    private final C0651i f573a;

    public C0666m(C0651i.C0652a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        C0651i a = C0651i.m623a(aVar, activity);
        this.f573a = a;
        addView(a);
    }

    /* renamed from: a */
    public void mo8215a(int i, int i2, int i3, int i4) {
        int i5 = i2 + i + i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i5;
            layoutParams.width = i5;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i5, i5));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i, i4);
        layoutParams2.setMargins(i3, i3, i3, 0);
        this.f573a.setLayoutParams(layoutParams2);
        this.f573a.mo8189a(i);
    }
}
