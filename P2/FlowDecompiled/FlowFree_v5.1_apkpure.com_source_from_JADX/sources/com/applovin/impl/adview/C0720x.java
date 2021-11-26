package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.C0651i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.x */
public final class C0720x extends C0651i {

    /* renamed from: c */
    private static final Paint f709c = new Paint(1);

    /* renamed from: d */
    private static final Paint f710d = new Paint(1);

    /* renamed from: e */
    private static final Paint f711e = new Paint(1);

    public C0720x(Context context) {
        super(context);
        f709c.setColor(-1);
        f710d.setColor(-16777216);
        Paint paint = f711e;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.f542a * 10.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleOffset() {
        return this.f542a * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f542a * 3.0f;
    }

    public C0651i.C0652a getStyle() {
        return C0651i.C0652a.WHITE_ON_BLACK;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f709c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f710d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f711e;
        paint.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        Paint paint2 = paint;
        canvas2.drawLine(f, crossOffset, f2, size, paint2);
        canvas2.drawLine(f, size, f2, crossOffset, paint2);
    }
}
