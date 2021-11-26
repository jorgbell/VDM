package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* renamed from: com.chartboost.sdk.impl.k0 */
public class C1332k0 extends C1368r1 {

    /* renamed from: c */
    private Paint f3240c;

    /* renamed from: d */
    private Paint f3241d;

    /* renamed from: e */
    private Path f3242e;

    /* renamed from: f */
    private RectF f3243f;

    /* renamed from: g */
    private RectF f3244g;

    /* renamed from: h */
    private int f3245h = 0;

    /* renamed from: i */
    private float f3246i;

    /* renamed from: j */
    private float f3247j;

    public C1332k0(Context context) {
        super(context);
        m3573a(context);
    }

    /* renamed from: a */
    private void m3573a(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.f3246i = 4.5f * f;
        Paint paint = new Paint();
        this.f3240c = paint;
        paint.setColor(-1);
        this.f3240c.setStyle(Paint.Style.STROKE);
        this.f3240c.setStrokeWidth(f * 1.0f);
        this.f3240c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f3241d = paint2;
        paint2.setColor(-855638017);
        this.f3241d.setStyle(Paint.Style.FILL);
        this.f3241d.setAntiAlias(true);
        this.f3242e = new Path();
        this.f3244g = new RectF();
        this.f3243f = new RectF();
    }

    /* renamed from: b */
    public void mo10488b(int i) {
        this.f3240c.setColor(i);
        invalidate();
    }

    /* renamed from: c */
    public void mo10489c(int i) {
        this.f3241d.setColor(i);
        invalidate();
    }

    /* renamed from: b */
    public void mo10487b(float f) {
        this.f3246i = f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10486a(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f3243f.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        float min = (float) Math.min(1, Math.round(f * 0.5f));
        this.f3243f.inset(min, min);
        this.f3242e.reset();
        Path path = this.f3242e;
        RectF rectF = this.f3243f;
        float f2 = this.f3246i;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.f3242e);
        canvas.drawColor(this.f3245h);
        this.f3244g.set(this.f3243f);
        RectF rectF2 = this.f3244g;
        float f3 = rectF2.right;
        float f4 = rectF2.left;
        rectF2.right = ((f3 - f4) * this.f3247j) + f4;
        canvas.drawRect(rectF2, this.f3241d);
        canvas.restore();
        RectF rectF3 = this.f3243f;
        float f5 = this.f3246i;
        canvas.drawRoundRect(rectF3, f5, f5, this.f3240c);
    }

    /* renamed from: a */
    public void mo10485a(int i) {
        this.f3245h = i;
        invalidate();
    }

    /* renamed from: a */
    public void mo10484a(float f) {
        this.f3247j = f;
        if (getVisibility() != 8) {
            invalidate();
        }
    }
}
