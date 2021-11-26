package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.VastWebView;
import com.mopub.network.TrackingRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastVideoViewController.kt */
final class VastVideoViewController$handleIconDisplay$$inlined$let$lambda$1 implements VastWebView.VastWebViewClickListener {
    final /* synthetic */ VastIconConfig $iconConfig$inlined;
    final /* synthetic */ VastVideoViewController this$0;

    VastVideoViewController$handleIconDisplay$$inlined$let$lambda$1(VastIconConfig vastIconConfig, VastVideoViewController vastVideoViewController) {
        this.$iconConfig$inlined = vastIconConfig;
        this.this$0 = vastVideoViewController;
    }

    public final void onVastWebViewClick() {
        TrackingRequest.makeVastTrackingHttpRequest(this.$iconConfig$inlined.getClickTrackingUris(), (VastErrorCode) null, Integer.valueOf(this.this$0.getCurrentPosition()), this.this$0.getNetworkMediaFileUrl(), this.this$0.getContext());
        VastIconConfig vastIconConfig = this.this$0.getVastIconConfig();
        if (vastIconConfig != null) {
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            vastIconConfig.handleClick(context, (String) null, this.this$0.getVastVideoConfig().getDspCreativeId());
        }
    }
}
