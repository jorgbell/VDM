package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastCompanionAdConfig.kt */
public final class VastCompanionAdConfig$handleClick$$inlined$let$lambda$1 implements UrlHandler.ResultActions {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ String $dspCreativeId$inlined;
    final /* synthetic */ int $requestCode$inlined;

    public void urlHandlingFailed(String str, UrlAction urlAction) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(urlAction, "lastFailedUrlAction");
    }

    VastCompanionAdConfig$handleClick$$inlined$let$lambda$1(String str, Context context, int i) {
        this.$dspCreativeId$inlined = str;
        this.$context$inlined = context;
        this.$requestCode$inlined = i;
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
            Class<MoPubBrowser> cls = MoPubBrowser.class;
            try {
                ((Activity) this.$context$inlined).startActivityForResult(Intents.getStartActivityIntent(this.$context$inlined, cls, bundle), this.$requestCode$inlined);
            } catch (ActivityNotFoundException unused) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Activity " + cls.getName() + " not found. Did you " + "declare it in your AndroidManifest.xml?");
            }
        }
    }
}
