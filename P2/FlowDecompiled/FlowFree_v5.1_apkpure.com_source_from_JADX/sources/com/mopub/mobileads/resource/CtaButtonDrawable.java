package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;

public class CtaButtonDrawable extends BaseWidgetDrawable {
    private final Paint mBackgroundPaint;
    private final int mButtonCornerRadius;
    private final RectF mButtonRect = new RectF();
    private String mCtaText = DrawableConstants.CtaButton.DEFAULT_CTA_TEXT;
    private final Paint mOutlinePaint;
    private final Paint mTextPaint;
    private final Rect mTextRect = new Rect();

    public CtaButtonDrawable(Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(2.0f, context);
        float dipsToFloatPixels = Dips.dipsToFloatPixels(15.0f, context);
        Paint paint = new Paint();
        this.mBackgroundPaint = paint;
        paint.setColor(-16777216);
        paint.setAlpha(51);
        paint.setStyle(DrawableConstants.CtaButton.BACKGROUND_STYLE);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mOutlinePaint = paint2;
        paint2.setColor(-1);
        paint2.setAlpha(51);
        paint2.setStyle(DrawableConstants.CtaButton.OUTLINE_STYLE);
        paint2.setStrokeWidth((float) dipsToIntPixels);
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mTextPaint = paint3;
        paint3.setColor(-1);
        paint3.setTextAlign(DrawableConstants.CtaButton.TEXT_ALIGN);
        paint3.setTypeface(DrawableConstants.CtaButton.TEXT_TYPEFACE);
        paint3.setTextSize(dipsToFloatPixels);
        paint3.setAntiAlias(true);
        this.mButtonCornerRadius = Dips.dipsToIntPixels(6.0f, context);
    }

    public void draw(Canvas canvas) {
        this.mButtonRect.set(getBounds());
        RectF rectF = this.mButtonRect;
        int i = this.mButtonCornerRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.mBackgroundPaint);
        RectF rectF2 = this.mButtonRect;
        int i2 = this.mButtonCornerRadius;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, this.mOutlinePaint);
        drawTextWithinBounds(canvas, this.mTextPaint, this.mTextRect, this.mCtaText);
    }

    public void setCtaText(String str) {
        this.mCtaText = str;
        invalidateSelf();
    }

    @Deprecated
    @VisibleForTesting
    public String getCtaText() {
        return this.mCtaText;
    }
}
