package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.IntentActions;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.AdLifecycleListener;

public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter sIntentFilter;
    private final AdLifecycleListener.InteractionListener mInteractionListener;

    public EventForwardingBroadcastReceiver(AdLifecycleListener.InteractionListener interactionListener, long j) {
        super(j);
        this.mInteractionListener = interactionListener;
        getIntentFilter();
    }

    public IntentFilter getIntentFilter() {
        if (sIntentFilter == null) {
            IntentFilter intentFilter = new IntentFilter();
            sIntentFilter = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_FULLSCREEN_FAIL);
            sIntentFilter.addAction(IntentActions.ACTION_FULLSCREEN_SHOW);
            sIntentFilter.addAction(IntentActions.ACTION_FULLSCREEN_DISMISS);
            sIntentFilter.addAction(IntentActions.ACTION_FULLSCREEN_CLICK);
            sIntentFilter.addAction(IntentActions.ACTION_REWARDED_AD_COMPLETE);
        }
        return sIntentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.mInteractionListener != null && shouldConsumeBroadcast(intent)) {
            String action = intent.getAction();
            if (IntentActions.ACTION_FULLSCREEN_FAIL.equals(action)) {
                this.mInteractionListener.onAdFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            } else if (IntentActions.ACTION_FULLSCREEN_SHOW.equals(action)) {
                this.mInteractionListener.onAdShown();
                this.mInteractionListener.onAdImpression();
            } else if (IntentActions.ACTION_FULLSCREEN_DISMISS.equals(action)) {
                this.mInteractionListener.onAdDismissed();
                unregister(this);
            } else if (IntentActions.ACTION_FULLSCREEN_CLICK.equals(action)) {
                this.mInteractionListener.onAdClicked();
            } else if (IntentActions.ACTION_REWARDED_AD_COMPLETE.equals(action)) {
                this.mInteractionListener.onAdComplete((MoPubReward) null);
            }
        }
    }
}
