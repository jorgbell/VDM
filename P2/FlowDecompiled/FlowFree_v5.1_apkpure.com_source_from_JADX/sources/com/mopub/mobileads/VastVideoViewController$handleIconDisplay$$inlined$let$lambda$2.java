package com.mopub.mobileads;

import android.content.Context;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.logging.MoPubLog;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastVideoViewController.kt */
public final class VastVideoViewController$handleIconDisplay$$inlined$let$lambda$2 extends WebViewClient {
    final /* synthetic */ VastVideoViewController this$0;

    VastVideoViewController$handleIconDisplay$$inlined$let$lambda$2(VastIconConfig vastIconConfig, VastVideoViewController vastVideoViewController) {
        this.this$0 = vastVideoViewController;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        VastIconConfig vastIconConfig = this.this$0.getVastIconConfig();
        if (vastIconConfig == null) {
            return true;
        }
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        vastIconConfig.handleClick(context, str, this.this$0.getVastVideoConfig().getDspCreativeId());
        return true;
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "onRenderProcessGone() called from the IconView. Ignoring the icon.");
        VastVideoConfig vastVideoConfig = this.this$0.getVastVideoConfig();
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        vastVideoConfig.handleError(context, VastErrorCode.UNDEFINED_ERROR, this.this$0.getCurrentPosition());
        return true;
    }
}
