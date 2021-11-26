package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.applovin.impl.adview.i */
public abstract class C0651i extends View {

    /* renamed from: a */
    protected float f542a = 1.0f;

    /* renamed from: b */
    protected final Context f543b;

    /* renamed from: com.applovin.impl.adview.i$a */
    public enum C0652a {
        WHITE_ON_BLACK(0),
        WHITE_ON_TRANSPARENT(1),
        INVISIBLE(2);
        

        /* renamed from: d */
        private final int f548d;

        private C0652a(int i) {
            this.f548d = i;
        }

        /* renamed from: a */
        public int mo8193a() {
            return this.f548d;
        }
    }

    protected C0651i(Context context) {
        super(context);
        this.f543b = context;
    }

    /* renamed from: a */
    public static C0651i m623a(C0652a aVar, Context context) {
        return aVar.equals(C0652a.INVISIBLE) ? new C0711q(context) : aVar.equals(C0652a.WHITE_ON_TRANSPARENT) ? new C0712r(context) : new C0720x(context);
    }

    /* renamed from: a */
    public void mo8189a(int i) {
        setViewScale(((float) i) / 30.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getSize();
            layoutParams.height = (int) getSize();
        }
    }

    public float getSize() {
        return this.f542a * 30.0f;
    }

    public abstract C0652a getStyle();

    public void setViewScale(float f) {
        this.f542a = f;
    }
}
