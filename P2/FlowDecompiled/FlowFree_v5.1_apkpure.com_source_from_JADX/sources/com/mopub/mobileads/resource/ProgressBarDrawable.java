package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;

public class ProgressBarDrawable extends BaseWidgetDrawable {
    private final Paint mBackgroundPaint;
    private int mCurrentProgress;
    private int mDuration;
    private int mLastProgress;
    private final int mNuggetWidth;
    private final Paint mProgressPaint;
    private int mSkipOffset;
    private float mSkipRatio;

    public ProgressBarDrawable(Context context) {
        Paint paint = new Paint();
        this.mBackgroundPaint = paint;
        paint.setColor(-1);
        paint.setAlpha(128);
        paint.setStyle(DrawableConstants.ProgressBar.BACKGROUND_STYLE);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mProgressPaint = paint2;
        paint2.setColor(DrawableConstants.ProgressBar.PROGRESS_COLOR);
        paint2.setAlpha(255);
        paint2.setStyle(DrawableConstants.ProgressBar.PROGRESS_STYLE);
        paint2.setAntiAlias(true);
        this.mNuggetWidth = Dips.dipsToIntPixels(4.0f, context);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.mBackgroundPaint);
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) getBounds().left, (float) getBounds().top, ((float) getBounds().right) * (((float) this.mCurrentProgress) / ((float) this.mDuration)), (float) getBounds().bottom, this.mProgressPaint);
        int i = this.mSkipOffset;
        if (i > 0 && i < this.mDuration) {
            float f = ((float) getBounds().right) * this.mSkipRatio;
            canvas.drawRect(f, (float) getBounds().top, f + ((float) this.mNuggetWidth), (float) getBounds().bottom, this.mProgressPaint);
        }
    }

    public void reset() {
        this.mLastProgress = 0;
    }

    public void setDurationAndSkipOffset(int i, int i2) {
        this.mDuration = i;
        this.mSkipOffset = i2;
        this.mSkipRatio = ((float) i2) / ((float) i);
    }

    public void setProgress(int i) {
        int i2 = this.mLastProgress;
        if (i >= i2) {
            this.mCurrentProgress = i;
            this.mLastProgress = i;
        } else if (i != 0) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("Progress not monotonically increasing: last = %d, current = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)}));
            forceCompletion();
        }
        invalidateSelf();
    }

    @VisibleForTesting
    public void forceCompletion() {
        this.mCurrentProgress = this.mDuration;
    }

    @Deprecated
    @VisibleForTesting
    public float getSkipRatio() {
        return this.mSkipRatio;
    }

    @Deprecated
    @VisibleForTesting
    public int getCurrentProgress() {
        return this.mCurrentProgress;
    }
}
