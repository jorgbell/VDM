package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;

class InlineVisibilityTracker {
    /* access modifiers changed from: private */
    public InlineVisibilityTrackerListener mInlineVisibilityTrackerListener;
    /* access modifiers changed from: private */
    public boolean mIsImpTrackerFired;
    /* access modifiers changed from: private */
    public boolean mIsVisibilityScheduled;
    @VisibleForTesting
    final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            InlineVisibilityTracker.this.scheduleVisibilityCheck();
            return true;
        }
    };
    /* access modifiers changed from: private */
    public final View mRootView;
    /* access modifiers changed from: private */
    public final View mTrackedView;
    /* access modifiers changed from: private */
    public final BannerVisibilityChecker mVisibilityChecker;
    private final Handler mVisibilityHandler = new Handler();
    private final BannerVisibilityRunnable mVisibilityRunnable = new BannerVisibilityRunnable();
    @VisibleForTesting
    WeakReference<ViewTreeObserver> mWeakViewTreeObserver = new WeakReference<>((Object) null);

    interface InlineVisibilityTrackerListener {
        void onVisibilityChanged();
    }

    @VisibleForTesting
    public InlineVisibilityTracker(Context context, View view, View view2, int i, int i2) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view2);
        this.mRootView = view;
        this.mTrackedView = view2;
        this.mVisibilityChecker = new BannerVisibilityChecker(i, i2);
        setViewTreeObserver(context, view2);
    }

    private void setViewTreeObserver(Context context, View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mWeakViewTreeObserver.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View topmostView = Views.getTopmostView(context, view);
            if (topmostView == null) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Unable to set Visibility Tracker due to no available root view.");
                return;
            }
            ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (!viewTreeObserver2.isAlive()) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Visibility Tracker was unable to track views because the root view tree observer was not alive");
                return;
            }
            this.mWeakViewTreeObserver = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void setInlineVisibilityTrackerListener(InlineVisibilityTrackerListener inlineVisibilityTrackerListener) {
        this.mInlineVisibilityTrackerListener = inlineVisibilityTrackerListener;
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        this.mVisibilityHandler.removeMessages(0);
        this.mIsVisibilityScheduled = false;
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mWeakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mWeakViewTreeObserver.clear();
        this.mInlineVisibilityTrackerListener = null;
    }

    /* access modifiers changed from: package-private */
    public void scheduleVisibilityCheck() {
        if (!this.mIsVisibilityScheduled) {
            this.mIsVisibilityScheduled = true;
            this.mVisibilityHandler.postDelayed(this.mVisibilityRunnable, 100);
        }
    }

    class BannerVisibilityRunnable implements Runnable {
        BannerVisibilityRunnable() {
        }

        public void run() {
            if (!InlineVisibilityTracker.this.mIsImpTrackerFired) {
                boolean unused = InlineVisibilityTracker.this.mIsVisibilityScheduled = false;
                if (InlineVisibilityTracker.this.mVisibilityChecker.isVisible(InlineVisibilityTracker.this.mRootView, InlineVisibilityTracker.this.mTrackedView)) {
                    if (!InlineVisibilityTracker.this.mVisibilityChecker.hasBeenVisibleYet()) {
                        InlineVisibilityTracker.this.mVisibilityChecker.setStartTimeMillis();
                    }
                    if (InlineVisibilityTracker.this.mVisibilityChecker.hasRequiredTimeElapsed() && InlineVisibilityTracker.this.mInlineVisibilityTrackerListener != null) {
                        InlineVisibilityTracker.this.mInlineVisibilityTrackerListener.onVisibilityChanged();
                        boolean unused2 = InlineVisibilityTracker.this.mIsImpTrackerFired = true;
                    }
                }
                if (!InlineVisibilityTracker.this.mIsImpTrackerFired) {
                    InlineVisibilityTracker.this.scheduleVisibilityCheck();
                }
            }
        }
    }

    static class BannerVisibilityChecker {
        private final Rect mClipRect = new Rect();
        private int mMinVisibleDips;
        private int mMinVisibleMillis;
        private long mStartTimeMillis = Long.MIN_VALUE;

        BannerVisibilityChecker(int i, int i2) {
            this.mMinVisibleDips = i;
            this.mMinVisibleMillis = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean hasBeenVisibleYet() {
            return this.mStartTimeMillis != Long.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void setStartTimeMillis() {
            this.mStartTimeMillis = SystemClock.uptimeMillis();
        }

        /* access modifiers changed from: package-private */
        public boolean hasRequiredTimeElapsed() {
            if (hasBeenVisibleYet() && SystemClock.uptimeMillis() - this.mStartTimeMillis >= ((long) this.mMinVisibleMillis)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isVisible(View view, View view2) {
            if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.mClipRect) || ((long) (Dips.pixelsToIntDips((float) this.mClipRect.width(), view2.getContext()) * Dips.pixelsToIntDips((float) this.mClipRect.height(), view2.getContext()))) < ((long) this.mMinVisibleDips)) {
                return false;
            }
            return true;
        }
    }
}
