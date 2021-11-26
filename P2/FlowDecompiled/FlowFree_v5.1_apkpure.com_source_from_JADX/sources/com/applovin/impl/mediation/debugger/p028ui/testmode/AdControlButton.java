package com.applovin.impl.mediation.debugger.p028ui.testmode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.C0564a;
import com.applovin.impl.sdk.utils.C1118f;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private final Button f1165a;

    /* renamed from: b */
    private final C0564a f1166b;

    /* renamed from: c */
    private C0858b f1167c;

    /* renamed from: d */
    private MaxAdFormat f1168d;

    /* renamed from: e */
    private C0857a f1169e;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton$a */
    public interface C0857a {
        void onClick(AdControlButton adControlButton);
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton$b */
    public enum C0858b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Button button = new Button(getContext());
        this.f1165a = button;
        C0564a aVar = new C0564a(getContext(), 20, 16842873);
        this.f1166b = aVar;
        C0858b bVar = C0858b.LOAD;
        this.f1167c = bVar;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setTextColor(-1);
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        aVar.setColor(-1);
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
        m1369a(bVar);
    }

    /* renamed from: a */
    private void m1369a(C0858b bVar) {
        if (C0858b.LOADING == bVar) {
            setEnabled(false);
            this.f1166b.mo7946a();
        } else {
            setEnabled(true);
            this.f1166b.mo7947b();
        }
        this.f1165a.setText(m1370b(bVar));
        this.f1165a.setBackgroundColor(m1371c(bVar));
    }

    /* renamed from: b */
    private String m1370b(C0858b bVar) {
        return C0858b.LOAD == bVar ? "Load" : C0858b.LOADING == bVar ? "" : "Show";
    }

    /* renamed from: c */
    private int m1371c(C0858b bVar) {
        return C1118f.m2525a((C0858b.LOAD == bVar || C0858b.LOADING == bVar) ? C1199R.color.applovin_sdk_brand_color : C1199R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    public C0858b getControlState() {
        return this.f1167c;
    }

    public MaxAdFormat getFormat() {
        return this.f1168d;
    }

    public void onClick(View view) {
        C0857a aVar = this.f1169e;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(C0858b bVar) {
        if (this.f1167c != bVar) {
            m1369a(bVar);
        }
        this.f1167c = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.f1168d = maxAdFormat;
    }

    public void setOnClickListener(C0857a aVar) {
        this.f1169e = aVar;
    }
}
