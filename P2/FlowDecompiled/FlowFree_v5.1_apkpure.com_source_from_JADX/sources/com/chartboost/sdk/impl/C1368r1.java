package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* renamed from: com.chartboost.sdk.impl.r1 */
public abstract class C1368r1 extends View {

    /* renamed from: a */
    private Bitmap f3368a = null;

    /* renamed from: b */
    private Canvas f3369b = null;

    public C1368r1(Context context) {
        super(context);
        m3714a(context);
    }

    /* renamed from: a */
    private void m3714a(Context context) {
        try {
            Class<?> cls = getClass();
            cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{1, null});
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private boolean m3715b(Canvas canvas) {
        try {
            return ((Boolean) Canvas.class.getMethod("isHardwareAccelerated", new Class[0]).invoke(canvas, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo10486a(Canvas canvas);

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f3368a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f3368a.recycle();
        }
        this.f3368a = null;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        boolean b = m3715b(canvas);
        if (b) {
            Bitmap bitmap = this.f3368a;
            if (!(bitmap != null && bitmap.getWidth() == canvas.getWidth() && this.f3368a.getHeight() == canvas.getHeight())) {
                Bitmap bitmap2 = this.f3368a;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.f3368a.recycle();
                }
                try {
                    this.f3368a = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                    this.f3369b = new Canvas(this.f3368a);
                } catch (Throwable unused) {
                    return;
                }
            }
            this.f3368a.eraseColor(0);
            canvas2 = canvas;
            canvas = this.f3369b;
        } else {
            canvas2 = null;
        }
        mo10486a(canvas);
        if (b) {
            canvas2.drawBitmap(this.f3368a, 0.0f, 0.0f, (Paint) null);
        }
    }
}
