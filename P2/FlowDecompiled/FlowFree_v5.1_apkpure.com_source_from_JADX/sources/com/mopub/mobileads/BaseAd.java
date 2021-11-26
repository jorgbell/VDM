package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubLifecycleManager;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.AdLifecycleListener;

public abstract class BaseAd {
    private boolean mAutomaticImpressionAndClickTracking = true;
    protected AdLifecycleListener.InteractionListener mInteractionListener;
    protected AdLifecycleListener.LoadListener mLoadListener;

    /* access modifiers changed from: protected */
    public abstract boolean checkAndInitializeSdk(Activity activity, AdData adData) throws Exception;

    /* access modifiers changed from: protected */
    public abstract String getAdNetworkId();

    /* access modifiers changed from: protected */
    public View getAdView() {
        return null;
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public abstract LifecycleListener getLifecycleListener();

    /* access modifiers changed from: protected */
    public abstract void load(Context context, AdData adData) throws Exception;

    /* access modifiers changed from: protected */
    public abstract void onInvalidate();

    /* access modifiers changed from: protected */
    public void show() {
    }

    /* access modifiers changed from: protected */
    public void trackMpxAndThirdPartyImpressions() {
    }

    /* access modifiers changed from: protected */
    public void setAutomaticImpressionAndClickTracking(boolean z) {
        this.mAutomaticImpressionAndClickTracking = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isAutomaticImpressionAndClickTrackingEnabled() {
        return this.mAutomaticImpressionAndClickTracking;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void internalLoad(Context context, AdLifecycleListener.LoadListener loadListener, AdData adData) throws Exception {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(loadListener);
        Preconditions.checkNotNull(adData);
        this.mLoadListener = loadListener;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (checkAndInitializeSdk(activity, adData)) {
                MoPubLifecycleManager.getInstance(activity).addLifecycleListener(getLifecycleListener());
            }
        }
        load(context, adData);
    }

    /* access modifiers changed from: package-private */
    public final void internalShow(AdLifecycleListener.InteractionListener interactionListener) {
        Preconditions.checkNotNull(interactionListener);
        this.mInteractionListener = interactionListener;
        show();
    }
}
