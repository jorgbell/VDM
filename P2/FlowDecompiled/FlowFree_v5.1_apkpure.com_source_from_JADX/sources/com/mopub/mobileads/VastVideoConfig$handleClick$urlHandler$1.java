package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastVideoConfig.kt */
public final class VastVideoConfig$handleClick$urlHandler$1 implements UrlHandler.ResultActions {
    final /* synthetic */ Context $context;
    final /* synthetic */ Integer $requestCode;
    final /* synthetic */ VastVideoConfig this$0;

    public void urlHandlingFailed(String str, UrlAction urlAction) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(urlAction, "lastFailedUrlAction");
    }

    VastVideoConfig$handleClick$urlHandler$1(VastVideoConfig vastVideoConfig, Context context, Integer num) {
        this.this$0 = vastVideoConfig;
        this.$context = context;
        this.$requestCode = num;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(urlAction, "urlAction");
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.this$0.getDspCreativeId());
            Class<MoPubBrowser> cls = MoPubBrowser.class;
            Intent startActivityIntent = Intents.getStartActivityIntent(this.$context, cls, bundle);
            try {
                Context context = this.$context;
                if (context instanceof Activity) {
                    Integer num = this.$requestCode;
                    if (num != null) {
                        ((Activity) context).startActivityForResult(startActivityIntent, num.intValue());
                        return;
                    }
                    throw new IllegalArgumentException("Activity context requires a requestCode".toString());
                }
                Intents.startActivity(context, startActivityIntent);
            } catch (ActivityNotFoundException unused) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Activity " + cls.getName() + " not found. Did you declare " + "it in your AndroidManifest.xml?");
            } catch (IntentNotResolvableException unused2) {
                MoPubLog.SdkLogEvent sdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent2, "Activity " + cls.getName() + " not found. Did you declare " + "it in your AndroidManifest.xml?");
            }
        }
    }
}
