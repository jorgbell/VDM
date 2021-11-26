package com.mopub.mobileads;

import android.content.Context;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@Mockable
/* compiled from: VastIconConfig.kt */
public class VastIconConfig implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("clickthrough_url")
    @Expose
    private final String clickThroughUri;
    @SerializedName("click_trackers")
    @Expose
    private final List<VastTracker> clickTrackingUris;
    @SerializedName("duration_ms")
    @Expose
    private final Integer durationMS;
    @SerializedName("height")
    @Expose
    private final int height;
    @SerializedName("skip_offset_ms")
    @Expose
    private final int offsetMS;
    @SerializedName("resource")
    @Expose
    private final VastResource vastResource;
    @SerializedName("video_viewability_tracker")
    @Expose
    private final List<VastTracker> viewTrackingUris;
    @SerializedName("width")
    @Expose
    private final int width;

    public VastIconConfig(int i, int i2, Integer num, Integer num2, VastResource vastResource2, List<? extends VastTracker> list, String str, List<? extends VastTracker> list2) {
        Intrinsics.checkNotNullParameter(vastResource2, "vastResource");
        Intrinsics.checkNotNullParameter(list, "clickTrackingUris");
        Intrinsics.checkNotNullParameter(list2, "viewTrackingUris");
        this.width = i;
        this.height = i2;
        this.durationMS = num2;
        this.vastResource = vastResource2;
        this.clickTrackingUris = list;
        this.clickThroughUri = str;
        this.viewTrackingUris = list2;
        this.offsetMS = num != null ? num.intValue() : 0;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Integer getDurationMS() {
        return this.durationMS;
    }

    public VastResource getVastResource() {
        return this.vastResource;
    }

    public List<VastTracker> getClickTrackingUris() {
        return this.clickTrackingUris;
    }

    public String getClickThroughUri() {
        return this.clickThroughUri;
    }

    public List<VastTracker> getViewTrackingUris() {
        return this.viewTrackingUris;
    }

    public int getOffsetMS() {
        return this.offsetMS;
    }

    public void handleImpression(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "assetUri");
        TrackingRequest.makeVastTrackingHttpRequest(getViewTrackingUris(), (VastErrorCode) null, Integer.valueOf(i), str, context);
    }

    public void handleClick(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        String correctClickThroughUrl = getVastResource().getCorrectClickThroughUrl(getClickThroughUri(), str);
        if (correctClickThroughUrl != null) {
            if (!(correctClickThroughUrl.length() > 0)) {
                correctClickThroughUrl = null;
            }
            if (correctClickThroughUrl != null) {
                new UrlHandler.Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER).withResultActions(new VastIconConfig$handleClick$$inlined$let$lambda$1(str2, context)).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
            }
        }
    }

    /* compiled from: VastIconConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
