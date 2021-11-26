package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.LinearLayout;

/* renamed from: com.chartboost.sdk.impl.n0 */
public class C1346n0 extends LinearLayout {

    /* renamed from: a */
    private final Paint f3303a;

    /* renamed from: b */
    private int f3304b = 0;

    public C1346n0(Context context) {
        super(context);
        int round = Math.round(context.getResources().getDisplayMetrics().density * 5.0f);
        setPadding(round, round, round, round);
        setBaselineAligned(false);
        Paint paint = new Paint();
        this.f3303a = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    /* renamed from: a */
    public void mo10526a(int i) {
        this.f3304b = i;
    }

    /* renamed from: b */
    public void mo10527b(int i) {
        this.f3303a.setColor(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = getContext().getResources().getDisplayMetrics().density;
        if ((this.f3304b & 1) > 0) {
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), f * 1.0f, this.f3303a);
        }
        if ((this.f3304b & 2) > 0) {
            canvas.drawRect(((float) canvas.getWidth()) - (f * 1.0f), 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f3303a);
        }
        if ((this.f3304b & 4) > 0) {
            canvas.drawRect(0.0f, ((float) canvas.getHeight()) - (f * 1.0f), (float) canvas.getWidth(), (float) canvas.getHeight(), this.f3303a);
        }
        if ((this.f3304b & 8) > 0) {
            canvas.drawRect(0.0f, 0.0f, f * 1.0f, (float) canvas.getHeight(), this.f3303a);
        }
    }
}
