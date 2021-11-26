package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.mobileads.VastResource;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastCompanionAdConfig.kt */
public class VastCompanionAdConfig implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("clickthrough_url")
    @Expose
    private final String clickThroughUrl;
    @SerializedName("click_trackers")
    @Expose
    private final List<VastTracker> clickTrackers;
    @SerializedName("impression_trackers")
    @Expose
    private final List<VastTracker> creativeViewTrackers;
    @SerializedName("custom_cta_text")
    @Expose
    private final String customCtaText;
    @SerializedName("height")
    @Expose
    private final int height;
    @SerializedName("resource")
    @Expose
    private final VastResource vastResource;
    @SerializedName("width")
    @Expose
    private final int width;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VastResource.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VastResource.Type.STATIC_RESOURCE.ordinal()] = 1;
            iArr[VastResource.Type.HTML_RESOURCE.ordinal()] = 2;
            iArr[VastResource.Type.IFRAME_RESOURCE.ordinal()] = 3;
            iArr[VastResource.Type.BLURRED_LAST_FRAME.ordinal()] = 4;
        }
    }

    public VastCompanionAdConfig(int i, int i2, VastResource vastResource2, String str, List<VastTracker> list, List<VastTracker> list2, String str2) {
        Intrinsics.checkNotNullParameter(vastResource2, "vastResource");
        Intrinsics.checkNotNullParameter(list, "clickTrackers");
        Intrinsics.checkNotNullParameter(list2, "creativeViewTrackers");
        this.width = i;
        this.height = i2;
        this.vastResource = vastResource2;
        this.clickThroughUrl = str;
        this.clickTrackers = list;
        this.creativeViewTrackers = list2;
        this.customCtaText = str2;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final VastResource getVastResource() {
        return this.vastResource;
    }

    public final String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public final List<VastTracker> getClickTrackers() {
        return this.clickTrackers;
    }

    public final List<VastTracker> getCreativeViewTrackers() {
        return this.creativeViewTrackers;
    }

    public final String getCustomCtaText() {
        return this.customCtaText;
    }

    /* compiled from: VastCompanionAdConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void addClickTrackers(Collection<? extends VastTracker> collection) {
        Intrinsics.checkNotNullParameter(collection, "clickTrackers");
        this.clickTrackers.addAll(collection);
    }

    public final void addCreativeViewTrackers(Collection<? extends VastTracker> collection) {
        Intrinsics.checkNotNullParameter(collection, "creativeViewTrackers");
        this.creativeViewTrackers.addAll(collection);
    }

    public final void handleImpression(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this.creativeViewTrackers, (VastErrorCode) null, Integer.valueOf(i), (String) null, context);
    }

    public final double formatScore() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.vastResource.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1.2d;
            }
            if (i != 3) {
                if (i == 4) {
                    return 0.0d;
                }
                throw new NoWhenBranchMatchedException();
            }
        } else if (!VastResource.CreativeType.JAVASCRIPT.equals(this.vastResource.getCreativeType())) {
            if (VastResource.CreativeType.IMAGE.equals(this.vastResource.getCreativeType())) {
                return 0.8d;
            }
            return 0.0d;
        }
        return 1.0d;
    }

    public double calculateScore(int i, int i2) {
        int i3;
        if (i2 == 0 || (i3 = this.height) == 0) {
            return 0.0d;
        }
        double d = (double) i;
        double d2 = (double) i2;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (double) this.width;
        double d4 = (double) i3;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double abs = Math.abs((d / d2) - (d3 / d4));
        double d5 = (double) this.width;
        Double.isNaN(d);
        Double.isNaN(d5);
        Double.isNaN(d);
        double abs2 = abs + Math.abs((d - d5) / d);
        double formatScore = formatScore();
        double d6 = (double) 1;
        Double.isNaN(d6);
        return formatScore / (d6 + abs2);
    }

    public void handleClick(Context context, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            String correctClickThroughUrl = this.vastResource.getCorrectClickThroughUrl(this.clickThroughUrl, str);
            if (correctClickThroughUrl != null) {
                if (!(correctClickThroughUrl.length() > 0)) {
                    correctClickThroughUrl = null;
                }
                if (correctClickThroughUrl != null) {
                    new UrlHandler.Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new VastCompanionAdConfig$handleClick$$inlined$let$lambda$1(str2, context, i)).withDspCreativeId(str2).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("context must be an activity".toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastCompanionAdConfig)) {
            return false;
        }
        VastCompanionAdConfig vastCompanionAdConfig = (VastCompanionAdConfig) obj;
        return this.width == vastCompanionAdConfig.width && this.height == vastCompanionAdConfig.height && !(Intrinsics.areEqual(this.vastResource, vastCompanionAdConfig.vastResource) ^ true) && !(Intrinsics.areEqual(this.clickThroughUrl, vastCompanionAdConfig.clickThroughUrl) ^ true) && !(Intrinsics.areEqual(this.clickTrackers, vastCompanionAdConfig.clickTrackers) ^ true) && !(Intrinsics.areEqual(this.creativeViewTrackers, vastCompanionAdConfig.creativeViewTrackers) ^ true) && !(Intrinsics.areEqual(this.customCtaText, vastCompanionAdConfig.customCtaText) ^ true);
    }

    public int hashCode() {
        int hashCode = ((((this.width * 31) + this.height) * 31) + this.vastResource.hashCode()) * 31;
        String str = this.clickThroughUrl;
        int i = 0;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.clickTrackers.hashCode()) * 31) + this.creativeViewTrackers.hashCode()) * 31;
        String str2 = this.customCtaText;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "VastCompanionAdConfig(width=" + this.width + ", height=" + this.height + ", vastResource=" + this.vastResource + ", " + "clickThroughUrl=" + this.clickThroughUrl + ", clickTrackers=" + this.clickTrackers + ", " + "creativeViewTrackers=" + this.creativeViewTrackers + ", customCtaText=" + this.customCtaText + ')';
    }
}
