package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.base.C2620R;

public class CloseableLayout extends FrameLayout {
    private final Rect mClosableLayoutRect;
    private boolean mCloseAlwaysInteractable;
    private boolean mCloseBoundChanged;
    private final Rect mCloseButtonBounds;
    private final int mCloseButtonPadding;
    private final int mCloseButtonSize;
    private final Drawable mCloseDrawable;
    private ClosePosition mClosePosition;
    private boolean mClosePressed;
    private final Rect mCloseRegionBounds;
    private final int mCloseRegionSize;
    private final Rect mInsetCloseRegionBounds;
    private OnCloseListener mOnCloseListener;
    private final int mTouchSlop;
    private UnsetPressedState mUnsetPressedState;

    public interface OnCloseListener {
        void onClose();
    }

    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        
        private final int mGravity;

        private ClosePosition(int i) {
            this.mGravity = i;
        }

        /* access modifiers changed from: package-private */
        public int getGravity() {
            return this.mGravity;
        }
    }

    public CloseableLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public CloseableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloseableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClosableLayoutRect = new Rect();
        this.mCloseRegionBounds = new Rect();
        this.mCloseButtonBounds = new Rect();
        this.mInsetCloseRegionBounds = new Rect();
        this.mCloseDrawable = ContextCompat.getDrawable(context, C2620R.C2621drawable.ic_mopub_close_button);
        this.mClosePosition = ClosePosition.TOP_RIGHT;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mCloseRegionSize = Dips.asIntPixels(50.0f, context);
        this.mCloseButtonSize = Dips.asIntPixels(34.0f, context);
        this.mCloseButtonPadding = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
        this.mCloseAlwaysInteractable = true;
        setBackgroundColor(getResources().getColor(17170444));
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void setClosePosition(ClosePosition closePosition) {
        Preconditions.checkNotNull(closePosition);
        this.mClosePosition = closePosition;
        this.mCloseBoundChanged = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        Drawable drawable = this.mCloseDrawable;
        if (drawable != null && drawable.setVisible(z, false)) {
            invalidate(this.mCloseRegionBounds);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mCloseBoundChanged = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mCloseBoundChanged) {
            this.mCloseBoundChanged = false;
            this.mClosableLayoutRect.set(0, 0, getWidth(), getHeight());
            applyCloseRegionBounds(this.mClosePosition, this.mClosableLayoutRect, this.mCloseRegionBounds);
            this.mInsetCloseRegionBounds.set(this.mCloseRegionBounds);
            Rect rect = this.mInsetCloseRegionBounds;
            int i = this.mCloseButtonPadding;
            rect.inset(i, i);
            applyCloseButtonBounds(this.mClosePosition, this.mInsetCloseRegionBounds, this.mCloseButtonBounds);
            Drawable drawable = this.mCloseDrawable;
            if (drawable != null) {
                drawable.setBounds(this.mCloseButtonBounds);
            }
        }
        Drawable drawable2 = this.mCloseDrawable;
        if (drawable2 != null && drawable2.isVisible()) {
            this.mCloseDrawable.draw(canvas);
        }
    }

    public void applyCloseRegionBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        applyCloseBoundsWithSize(closePosition, this.mCloseRegionSize, rect, rect2);
    }

    private void applyCloseButtonBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        applyCloseBoundsWithSize(closePosition, this.mCloseButtonSize, rect, rect2);
    }

    private void applyCloseBoundsWithSize(ClosePosition closePosition, int i, Rect rect, Rect rect2) {
        Gravity.apply(closePosition.getGravity(), i, i, rect, rect2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return pointInCloseBounds((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!pointInCloseBounds((int) motionEvent.getX(), (int) motionEvent.getY(), this.mTouchSlop) || !shouldAllowPress()) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (isClosePressed()) {
            if (this.mUnsetPressedState == null) {
                this.mUnsetPressedState = new UnsetPressedState();
            }
            postDelayed(this.mUnsetPressedState, (long) ViewConfiguration.getPressedStateDuration());
            performClose();
        }
        return true;
    }

    public void setCloseAlwaysInteractable(boolean z) {
        this.mCloseAlwaysInteractable = z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mCloseDrawable;
     */
    @com.mopub.common.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldAllowPress() {
        /*
            r1 = this;
            boolean r0 = r1.mCloseAlwaysInteractable
            if (r0 != 0) goto L_0x0011
            android.graphics.drawable.Drawable r0 = r1.mCloseDrawable
            if (r0 == 0) goto L_0x0011
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.CloseableLayout.shouldAllowPress():boolean");
    }

    /* access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z != isClosePressed()) {
            this.mClosePressed = z;
            invalidate(this.mCloseRegionBounds);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isClosePressed() {
        return this.mClosePressed;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean pointInCloseBounds(int i, int i2, int i3) {
        Rect rect = this.mCloseRegionBounds;
        return i >= rect.left - i3 && i2 >= rect.top - i3 && i < rect.right + i3 && i2 < rect.bottom + i3;
    }

    private void performClose() {
        playSoundEffect(0);
        OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onClose();
        }
    }

    private final class UnsetPressedState implements Runnable {
        private UnsetPressedState() {
        }

        public void run() {
            CloseableLayout.this.setClosePressed(false);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setCloseBounds(Rect rect) {
        this.mCloseRegionBounds.set(rect);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Rect getCloseBounds() {
        return this.mCloseRegionBounds;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setCloseBoundChanged(boolean z) {
        this.mCloseBoundChanged = z;
    }

    @VisibleForTesting
    public boolean isCloseVisible() {
        Drawable drawable = this.mCloseDrawable;
        return drawable != null && drawable.isVisible();
    }
}
