package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Numbers;
import com.mopub.mobileads.resource.DrawableConstants;

public class RadialCountdownDrawable extends BaseWidgetDrawable {
    private final Paint mArcPaint;
    private final Paint mBackgroundPaint;
    private final Paint mCirclePaint;
    private final int mCircleStrokeWidth;
    private int mInitialCountdownMilliseconds;
    private int mSecondsRemaining;
    private float mSweepAngle;
    private final Paint mTextPaint;
    private Rect mTextRect = new Rect();

    public RadialCountdownDrawable(Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, context);
        this.mCircleStrokeWidth = dipsToIntPixels;
        float dipsToFloatPixels = Dips.dipsToFloatPixels(18.0f, context);
        Paint paint = new Paint();
        this.mBackgroundPaint = paint;
        paint.setColor(-16777216);
        paint.setStyle(DrawableConstants.RadialCountdown.BACKGROUND_STYLE);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mCirclePaint = paint2;
        paint2.setColor(-1);
        paint2.setAlpha(128);
        paint2.setStyle(DrawableConstants.RadialCountdown.PROGRESS_CIRCLE_STYLE);
        paint2.setStrokeWidth((float) dipsToIntPixels);
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mArcPaint = paint3;
        paint3.setColor(-1);
        paint3.setAlpha(255);
        paint3.setStyle(DrawableConstants.RadialCountdown.PROGRESS_ARC_STYLE);
        paint3.setStrokeWidth((float) dipsToIntPixels);
        paint3.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.mTextPaint = paint4;
        paint4.setColor(-1);
        paint4.setTextAlign(DrawableConstants.RadialCountdown.TEXT_ALIGN);
        paint4.setTextSize(dipsToFloatPixels);
        paint4.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        int centerX = getBounds().centerX();
        int centerY = getBounds().centerY();
        int min = Math.min(centerX, centerY);
        float f = (float) centerX;
        float f2 = (float) centerY;
        canvas.drawCircle(f, f2, (float) ((this.mCircleStrokeWidth / 2) + min), this.mBackgroundPaint);
        canvas.drawCircle(f, f2, (float) min, this.mCirclePaint);
        drawTextWithinBounds(canvas, this.mTextPaint, this.mTextRect, String.valueOf(this.mSecondsRemaining));
        canvas.drawArc(new RectF(getBounds()), -90.0f, this.mSweepAngle, false, this.mArcPaint);
    }

    public void setInitialCountdown(int i) {
        this.mInitialCountdownMilliseconds = i;
    }

    public void updateCountdownProgress(int i) {
        this.mSecondsRemaining = (int) Numbers.convertMillisecondsToSecondsRoundedUp((long) (this.mInitialCountdownMilliseconds - i));
        this.mSweepAngle = (((float) i) * 360.0f) / ((float) this.mInitialCountdownMilliseconds);
        invalidateSelf();
    }

    @Deprecated
    @VisibleForTesting
    public int getInitialCountdownMilliseconds() {
        return this.mInitialCountdownMilliseconds;
    }
}
