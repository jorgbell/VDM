package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastIconConfig.kt */
public final class VastIconConfig$handleClick$$inlined$let$lambda$1 implements UrlHandler.ResultActions {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ String $dspCreativeId$inlined;

    public void urlHandlingFailed(String str, UrlAction urlAction) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(urlAction, "lastFailedUrlAction");
    }

    VastIconConfig$handleClick$$inlined$let$lambda$1(String str, Context context) {
        this.$dspCreativeId$inlined = str;
        this.$context$inlined = context;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(urlAction, "urlAction");
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            String str2 = this.$dspCreativeId$inlined;
            if (!(str2 == null || str2.length() == 0)) {
                bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.$dspCreativeId$inlined);
            }
            try {
                Intents.startActivity(this.$context$inlined, Intents.getStartActivityIntent(this.$context$inlined, MoPubBrowser.class, bundle));
            } catch (IntentNotResolvableException e) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, e.getMessage());
            }
        }
    }
}
