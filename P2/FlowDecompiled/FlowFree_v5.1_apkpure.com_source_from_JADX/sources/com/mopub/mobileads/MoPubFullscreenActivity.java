package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.mopub.common.DataKeys;
import com.mopub.common.IntentActions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Utils;
import com.mopub.exceptions.IntentNotResolvableException;

public class MoPubFullscreenActivity extends Activity {
    private FullscreenAdController mFullscreenAdController;

    public static void start(Context context, AdData adData) {
        try {
            Intents.startActivity(context, createIntent(context, adData));
        } catch (IntentNotResolvableException unused) {
            Log.d("MoPubFullscreenActivity", "MoPubFullscreenActivity.class not found. Did you declare MoPubFullscreenActivity in your manifest?");
        }
    }

    @VisibleForTesting
    protected static Intent createIntent(Context context, AdData adData) {
        Intent intent = new Intent(context, MoPubFullscreenActivity.class);
        intent.putExtra(DataKeys.AD_DATA_KEY, adData);
        intent.setFlags(268435456);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AdData adDataFromIntent = getAdDataFromIntent(getIntent());
        if (adDataFromIntent == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Ad data to show ad is null. Failed to show fullscreen ad.");
            finish();
            return;
        }
        long broadcastIdentifier = adDataFromIntent.getBroadcastIdentifier();
        try {
            this.mFullscreenAdController = new FullscreenAdController(this, bundle, getIntent(), adDataFromIntent);
            MoPubLog.log(MoPubLog.AdLogEvent.SHOW_SUCCESS, new Object[0]);
            BaseBroadcastReceiver.broadcastAction(this, adDataFromIntent.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_SHOW);
            getWindow().setFlags(16777216, 16777216);
        } catch (IllegalStateException unused) {
            MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.FULLSCREEN_SHOW_ERROR;
            MoPubLog.log(adLogEvent, moPubErrorCode, Integer.valueOf(moPubErrorCode.getIntCode()));
            BaseBroadcastReceiver.broadcastAction(this, broadcastIdentifier, IntentActions.ACTION_FULLSCREEN_FAIL);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Utils.hideNavigationBar(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        FullscreenAdController fullscreenAdController = this.mFullscreenAdController;
        if (fullscreenAdController != null) {
            fullscreenAdController.pause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FullscreenAdController fullscreenAdController = this.mFullscreenAdController;
        if (fullscreenAdController != null) {
            fullscreenAdController.resume();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        FullscreenAdController fullscreenAdController = this.mFullscreenAdController;
        if (fullscreenAdController != null) {
            fullscreenAdController.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        FullscreenAdController fullscreenAdController = this.mFullscreenAdController;
        if (fullscreenAdController != null) {
            fullscreenAdController.destroy();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        FullscreenAdController fullscreenAdController = this.mFullscreenAdController;
        if (fullscreenAdController == null || fullscreenAdController.backButtonEnabled()) {
            super.onBackPressed();
        }
    }

    protected static AdData getAdDataFromIntent(Intent intent) {
        try {
            return (AdData) intent.getParcelableExtra(DataKeys.AD_DATA_KEY);
        } catch (ClassCastException unused) {
            return null;
        }
    }
}
