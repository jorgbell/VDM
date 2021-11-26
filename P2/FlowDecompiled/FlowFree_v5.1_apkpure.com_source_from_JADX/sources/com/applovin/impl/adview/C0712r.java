package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.C0651i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.r */
public final class C0712r extends C0651i {

    /* renamed from: c */
    private static final Paint f691c = new Paint(1);

    /* renamed from: d */
    private static final Paint f692d = new Paint(1);

    public C0712r(Context context) {
        super(context);
        f691c.setARGB(80, 0, 0, 0);
        Paint paint = f692d;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public void mo8189a(int i) {
        setViewScale(((float) i) / 30.0f);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.f542a * 8.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f542a * 2.0f;
    }

    public C0651i.C0652a getStyle() {
        return C0651i.C0652a.WHITE_ON_TRANSPARENT;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f691c);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f692d;
        paint.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        Paint paint2 = paint;
        canvas2.drawLine(f, crossOffset, f2, size, paint2);
        canvas2.drawLine(f, size, f2, crossOffset, paint2);
    }
}
