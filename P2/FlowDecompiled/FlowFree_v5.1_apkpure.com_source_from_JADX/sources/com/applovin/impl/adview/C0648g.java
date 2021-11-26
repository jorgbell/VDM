package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.sdk.AppLovinMediationProvider;

/* renamed from: com.applovin.impl.adview.g */
public class C0648g extends View {

    /* renamed from: s */
    private static final int f516s = Color.rgb(66, 145, 241);

    /* renamed from: t */
    private static final int f517t = Color.rgb(66, 145, 241);

    /* renamed from: u */
    private static final int f518u = Color.rgb(66, 145, 241);

    /* renamed from: a */
    protected Paint f519a;

    /* renamed from: b */
    protected Paint f520b;

    /* renamed from: c */
    private Paint f521c;

    /* renamed from: d */
    private Paint f522d;

    /* renamed from: e */
    private RectF f523e;

    /* renamed from: f */
    private float f524f;

    /* renamed from: g */
    private int f525g;

    /* renamed from: h */
    private int f526h;

    /* renamed from: i */
    private int f527i;

    /* renamed from: j */
    private int f528j;

    /* renamed from: k */
    private int f529k;

    /* renamed from: l */
    private float f530l;

    /* renamed from: m */
    private int f531m;

    /* renamed from: n */
    private String f532n;

    /* renamed from: o */
    private String f533o;

    /* renamed from: p */
    private float f534p;

    /* renamed from: q */
    private String f535q;

    /* renamed from: r */
    private float f536r;

    /* renamed from: v */
    private final float f537v;

    /* renamed from: w */
    private final float f538w;

    /* renamed from: x */
    private final float f539x;

    /* renamed from: y */
    private final int f540y;

    /* renamed from: com.applovin.impl.adview.g$a */
    private static class C0649a {
        /* access modifiers changed from: private */
        /* renamed from: c */
        public static float m621c(Resources resources, float f) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public static float m622d(Resources resources, float f) {
            return f * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public C0648g(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0648g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0648g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f523e = new RectF();
        this.f527i = 0;
        this.f532n = "";
        this.f533o = "";
        this.f535q = "";
        this.f538w = C0649a.m622d(getResources(), 14.0f);
        this.f540y = (int) C0649a.m621c(getResources(), 100.0f);
        this.f537v = C0649a.m621c(getResources(), 4.0f);
        this.f539x = C0649a.m622d(getResources(), 18.0f);
        mo8157b();
        mo8156a();
    }

    /* renamed from: a */
    private int m616a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f540y;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private float getProgressAngle() {
        return (((float) getProgress()) / ((float) this.f528j)) * 360.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8156a() {
        TextPaint textPaint = new TextPaint();
        this.f519a = textPaint;
        textPaint.setColor(this.f525g);
        this.f519a.setTextSize(this.f524f);
        this.f519a.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.f520b = textPaint2;
        textPaint2.setColor(this.f526h);
        this.f520b.setTextSize(this.f534p);
        this.f520b.setAntiAlias(true);
        Paint paint = new Paint();
        this.f521c = paint;
        paint.setColor(this.f529k);
        this.f521c.setStyle(Paint.Style.STROKE);
        this.f521c.setAntiAlias(true);
        this.f521c.setStrokeWidth(this.f530l);
        Paint paint2 = new Paint();
        this.f522d = paint2;
        paint2.setColor(this.f531m);
        this.f522d.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8157b() {
        this.f529k = f516s;
        this.f525g = f517t;
        this.f524f = this.f538w;
        setMax(100);
        setProgress(0);
        this.f530l = this.f537v;
        this.f531m = 0;
        this.f534p = this.f539x;
        this.f526h = f518u;
    }

    public int getFinishedStrokeColor() {
        return this.f529k;
    }

    public float getFinishedStrokeWidth() {
        return this.f530l;
    }

    public int getInnerBackgroundColor() {
        return this.f531m;
    }

    public String getInnerBottomText() {
        return this.f535q;
    }

    public int getInnerBottomTextColor() {
        return this.f526h;
    }

    public float getInnerBottomTextSize() {
        return this.f534p;
    }

    public int getMax() {
        return this.f528j;
    }

    public String getPrefixText() {
        return this.f532n;
    }

    public int getProgress() {
        return this.f527i;
    }

    public String getSuffixText() {
        return this.f533o;
    }

    public int getTextColor() {
        return this.f525g;
    }

    public float getTextSize() {
        return this.f524f;
    }

    public void invalidate() {
        mo8156a();
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f530l;
        this.f523e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        float f2 = this.f530l;
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - f2) + f2) / 2.0f, this.f522d);
        canvas.drawArc(this.f523e, 270.0f, -getProgressAngle(), false, this.f521c);
        String str = this.f532n + this.f527i + this.f533o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (((float) getWidth()) - this.f519a.measureText(str)) / 2.0f, (((float) getWidth()) - (this.f519a.descent() + this.f519a.ascent())) / 2.0f, this.f519a);
        }
        if (!TextUtils.isEmpty(getInnerBottomText())) {
            this.f520b.setTextSize(this.f534p);
            canvas.drawText(getInnerBottomText(), (((float) getWidth()) - this.f520b.measureText(getInnerBottomText())) / 2.0f, (((float) getHeight()) - this.f536r) - ((this.f519a.descent() + this.f519a.ascent()) / 2.0f), this.f520b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m616a(i), m616a(i2));
        this.f536r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f525g = bundle.getInt("text_color");
            this.f524f = bundle.getFloat("text_size");
            this.f534p = bundle.getFloat("inner_bottom_text_size");
            this.f535q = bundle.getString("inner_bottom_text");
            this.f526h = bundle.getInt("inner_bottom_text_color");
            this.f529k = bundle.getInt("finished_stroke_color");
            this.f530l = bundle.getFloat("finished_stroke_width");
            this.f531m = bundle.getInt("inner_background_color");
            mo8156a();
            setMax(bundle.getInt(AppLovinMediationProvider.MAX));
            setProgress(bundle.getInt("progress"));
            this.f532n = bundle.getString("prefix");
            this.f533o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", (float) getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt(AppLovinMediationProvider.MAX, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i) {
        this.f529k = i;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.f530l = f;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.f531m = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f535q = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.f526h = i;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.f534p = f;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f528j = i;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f532n = str;
        invalidate();
    }

    public void setProgress(int i) {
        this.f527i = i;
        if (i > getMax()) {
            this.f527i %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f533o = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f525g = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f524f = f;
        invalidate();
    }
}
