package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mopub.common.Constants;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.ViewabilityVendor;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastAbsoluteProgressTracker;
import com.mopub.mobileads.VastFractionalProgressTracker;
import com.mopub.mobileads.VastTracker;
import com.mopub.network.TrackingRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Mockable
/* compiled from: VastVideoConfig.kt */
public class VastVideoConfig implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("absolute_trackers")
    @Expose
    private final List<VastAbsoluteProgressTracker> _absoluteTrackers = new ArrayList();
    @SerializedName("click_trackers")
    @Expose
    private final List<VastTracker> _clickTrackers = new ArrayList();
    @SerializedName("close_trackers")
    @Expose
    private final List<VastTracker> _closeTrackers = new ArrayList();
    @SerializedName("complete_trackers")
    @Expose
    private final List<VastTracker> _completeTrackers = new ArrayList();
    @SerializedName("error_trackers")
    @Expose
    private final List<VastTracker> _errorTrackers = new ArrayList();
    @SerializedName("fractional_trackers")
    @Expose
    private final List<VastFractionalProgressTracker> _fractionalTrackers = new ArrayList();
    @SerializedName("impression_trackers")
    @Expose
    private final List<VastTracker> _impressionTrackers = new ArrayList();
    @SerializedName("pause_trackers")
    @Expose
    private final List<VastTracker> _pauseTrackers = new ArrayList();
    @SerializedName("resume_trackers")
    @Expose
    private final List<VastTracker> _resumeTrackers = new ArrayList();
    @SerializedName("skip_trackers")
    @Expose
    private final List<VastTracker> _skipTrackers = new ArrayList();
    @SerializedName("viewability-verification-resources")
    @Expose
    private final Set<ViewabilityVendor> _viewabilityVendors = new LinkedHashSet();
    @SerializedName("clickthrough_url")
    private String clickThroughUrl;
    @SerializedName("countdown_timer_duration")
    @Expose
    private int countdownTimerDuration;
    @SerializedName("custom_close_icon_url")
    @Expose
    private String customCloseIconUrl;
    @SerializedName("custom_cta_text")
    @Expose
    private String customCtaText;
    @SerializedName("custom_skip_text")
    @Expose
    private String customSkipText;
    @SerializedName("disk_media_file_url")
    @Expose
    private String diskMediaFileUrl;
    @SerializedName("dsp_creative_id")
    @Expose
    private String dspCreativeId;
    @SerializedName("enable_click_exp")
    @Expose
    private boolean enableClickExperiment;
    @SerializedName("is_rewarded")
    @Expose
    private boolean isRewarded;
    @SerializedName("network_media_file_url")
    @Expose
    private String networkMediaFileUrl;
    @SerializedName("privacy_icon_click_url")
    @Expose
    private String privacyInformationIconClickthroughUrl;
    @SerializedName("privacy_icon_image_url")
    @Expose
    private String privacyInformationIconImageUrl;
    @SerializedName("skip_offset")
    @Expose
    private String skipOffset;
    @SerializedName("companion_ads")
    @Expose
    private final Set<VastCompanionAdConfig> vastCompanionAdConfigs = new HashSet();
    @SerializedName("icon_config")
    @Expose
    private VastIconConfig vastIconConfig;
    @SerializedName("video_viewability_tracker")
    @Expose
    private VideoViewabilityTracker videoViewabilityTracker;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoTrackingEvent.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VideoTrackingEvent.START.ordinal()] = 1;
            iArr[VideoTrackingEvent.FIRST_QUARTILE.ordinal()] = 2;
            iArr[VideoTrackingEvent.MIDPOINT.ordinal()] = 3;
            iArr[VideoTrackingEvent.THIRD_QUARTILE.ordinal()] = 4;
            iArr[VideoTrackingEvent.COMPLETE.ordinal()] = 5;
            iArr[VideoTrackingEvent.COMPANION_AD_VIEW.ordinal()] = 6;
            iArr[VideoTrackingEvent.COMPANION_AD_CLICK.ordinal()] = 7;
        }
    }

    /* compiled from: VastVideoConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VastVideoConfig fromVastVideoConfigString(String str) throws IOException, ClassNotFoundException {
            Intrinsics.checkNotNullParameter(str, "input");
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapterFactory(new VastVideoConfigTypeAdapterFactory());
            Object fromJson = gsonBuilder.create().fromJson(str, VastVideoConfig.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(input, VastVideoConfig::class.java)");
            return (VastVideoConfig) fromJson;
        }
    }

    public ArrayList<VastTracker> getImpressionTrackers() {
        return new ArrayList<>(this._impressionTrackers);
    }

    public ArrayList<VastTracker> getPauseTrackers() {
        return new ArrayList<>(this._pauseTrackers);
    }

    public ArrayList<VastTracker> getResumeTrackers() {
        return new ArrayList<>(this._resumeTrackers);
    }

    public ArrayList<VastTracker> getCompleteTrackers() {
        return new ArrayList<>(this._completeTrackers);
    }

    public ArrayList<VastTracker> getCloseTrackers() {
        return new ArrayList<>(this._closeTrackers);
    }

    public ArrayList<VastTracker> getSkipTrackers() {
        return new ArrayList<>(this._skipTrackers);
    }

    public ArrayList<VastTracker> getClickTrackers() {
        return new ArrayList<>(this._clickTrackers);
    }

    public ArrayList<VastTracker> getErrorTrackers() {
        return new ArrayList<>(this._errorTrackers);
    }

    public ArrayList<VastFractionalProgressTracker> getFractionalTrackers() {
        return new ArrayList<>(this._fractionalTrackers);
    }

    public ArrayList<VastAbsoluteProgressTracker> getAbsoluteTrackers() {
        return new ArrayList<>(this._absoluteTrackers);
    }

    public Set<ViewabilityVendor> getViewabilityVendors() {
        return new HashSet(this._viewabilityVendors);
    }

    public String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public void setClickThroughUrl(String str) {
        this.clickThroughUrl = str;
    }

    public String getNetworkMediaFileUrl() {
        return this.networkMediaFileUrl;
    }

    public void setNetworkMediaFileUrl(String str) {
        this.networkMediaFileUrl = str;
    }

    public String getDiskMediaFileUrl() {
        return this.diskMediaFileUrl;
    }

    public void setDiskMediaFileUrl(String str) {
        this.diskMediaFileUrl = str;
    }

    public String getSkipOffset() {
        return this.skipOffset;
    }

    public void setSkipOffset(String str) {
        this.skipOffset = str;
    }

    public Set<VastCompanionAdConfig> getVastCompanionAdConfigs() {
        return this.vastCompanionAdConfigs;
    }

    public VastIconConfig getVastIconConfig() {
        return this.vastIconConfig;
    }

    public void setVastIconConfig(VastIconConfig vastIconConfig2) {
        this.vastIconConfig = vastIconConfig2;
    }

    public boolean isRewarded() {
        return this.isRewarded;
    }

    public void setRewarded(boolean z) {
        this.isRewarded = z;
    }

    public int getCountdownTimerDuration() {
        return this.countdownTimerDuration;
    }

    public void setCountdownTimerDuration(int i) {
        this.countdownTimerDuration = i;
    }

    public boolean getEnableClickExperiment() {
        return this.enableClickExperiment;
    }

    public void setEnableClickExperiment(boolean z) {
        this.enableClickExperiment = z;
    }

    public String getCustomCtaText() {
        return this.customCtaText;
    }

    public void setCustomCtaText(String str) {
        if (str == null) {
            str = this.customCtaText;
        }
        this.customCtaText = str;
    }

    public String getCustomSkipText() {
        return this.customSkipText;
    }

    public void setCustomSkipText(String str) {
        if (str == null) {
            str = this.customSkipText;
        }
        this.customSkipText = str;
    }

    public String getCustomCloseIconUrl() {
        return this.customCloseIconUrl;
    }

    public void setCustomCloseIconUrl(String str) {
        if (str == null) {
            str = this.customCloseIconUrl;
        }
        this.customCloseIconUrl = str;
    }

    public VideoViewabilityTracker getVideoViewabilityTracker() {
        return this.videoViewabilityTracker;
    }

    public void setVideoViewabilityTracker(VideoViewabilityTracker videoViewabilityTracker2) {
        if (videoViewabilityTracker2 == null) {
            videoViewabilityTracker2 = this.videoViewabilityTracker;
        }
        this.videoViewabilityTracker = videoViewabilityTracker2;
    }

    public String getDspCreativeId() {
        return this.dspCreativeId;
    }

    public void setDspCreativeId(String str) {
        if (str == null) {
            str = this.dspCreativeId;
        }
        this.dspCreativeId = str;
    }

    public String getPrivacyInformationIconImageUrl() {
        return this.privacyInformationIconImageUrl;
    }

    public void setPrivacyInformationIconImageUrl(String str) {
        if (str == null) {
            str = this.privacyInformationIconImageUrl;
        }
        this.privacyInformationIconImageUrl = str;
    }

    public String getPrivacyInformationIconClickthroughUrl() {
        return this.privacyInformationIconClickthroughUrl;
    }

    public void setPrivacyInformationIconClickthroughUrl(String str) {
        this.privacyInformationIconClickthroughUrl = str;
    }

    public void addImpressionTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "impressionTrackers");
        this._impressionTrackers.addAll(list);
    }

    public void addResumeTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "resumeTrackers");
        this._resumeTrackers.addAll(list);
    }

    public void addFractionalTrackers(List<VastFractionalProgressTracker> list) {
        Intrinsics.checkNotNullParameter(list, "fractionalTrackers");
        this._fractionalTrackers.addAll(list);
        CollectionsKt__MutableCollectionsJVMKt.sort(this._fractionalTrackers);
    }

    public void addAbsoluteTrackers(List<? extends VastAbsoluteProgressTracker> list) {
        Intrinsics.checkNotNullParameter(list, "absoluteTrackers");
        this._absoluteTrackers.addAll(list);
        CollectionsKt__MutableCollectionsJVMKt.sort(this._absoluteTrackers);
    }

    public void addCompleteTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "completeTrackers");
        this._completeTrackers.addAll(list);
    }

    public void addPauseTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "pauseTrackers");
        this._pauseTrackers.addAll(list);
    }

    public void addCloseTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "closeTrackers");
        this._closeTrackers.addAll(list);
    }

    public void addSkipTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "skipTrackers");
        this._skipTrackers.addAll(list);
    }

    public void addClickTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "clickTrackers");
        this._clickTrackers.addAll(list);
    }

    public void addErrorTrackers(List<? extends VastTracker> list) {
        Intrinsics.checkNotNullParameter(list, "errorTrackers");
        this._errorTrackers.addAll(list);
    }

    public void addViewabilityVendors(Set<? extends ViewabilityVendor> set) {
        if (set != null) {
            this._viewabilityVendors.addAll(set);
        }
    }

    public void addVideoTrackers(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray(Constants.VIDEO_TRACKING_URLS_KEY);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Constants.VIDEO_TRACKING_EVENTS_KEY);
            if (optJSONArray != null && optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray2.optString(i);
                    List<String> hydrateUrls = hydrateUrls(optString, optJSONArray);
                    VideoTrackingEvent fromString = VideoTrackingEvent.Companion.fromString(optString);
                    if (!(optString == null || hydrateUrls == null)) {
                        switch (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()]) {
                            case 1:
                                addStartTrackersForUrls(hydrateUrls);
                                break;
                            case 2:
                            case 3:
                            case 4:
                                addFractionalTrackersForUrls(hydrateUrls, fromString.toFloat());
                                break;
                            case 5:
                                addCompleteTrackersForUrls(hydrateUrls);
                                break;
                            case 6:
                                addCompanionAdViewTrackersForUrls(hydrateUrls);
                                break;
                            case 7:
                                addCompanionAdClickTrackersForUrls(hydrateUrls);
                                break;
                            default:
                                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                                MoPubLog.log(sdkLogEvent, "Encountered unknown video tracking event: " + optString);
                                break;
                        }
                    }
                }
            }
        }
    }

    public boolean hasCompanionAd() {
        return !getVastCompanionAdConfigs().isEmpty();
    }

    public void handleImpression(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this._impressionTrackers, (VastErrorCode) null, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
    }

    public void handleClickForResult(Activity activity, int i, int i2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        handleClick(activity, i, Integer.valueOf(i2));
    }

    public void handleClickWithoutResult(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        handleClick(applicationContext, i, (Integer) null);
    }

    private void handleClick(Context context, int i, Integer num) {
        TrackingRequest.makeVastTrackingHttpRequest(this._clickTrackers, (VastErrorCode) null, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
        String clickThroughUrl2 = getClickThroughUrl();
        if (!(clickThroughUrl2 == null || clickThroughUrl2.length() == 0)) {
            UrlHandler build = new UrlHandler.Builder().withDspCreativeId(getDspCreativeId()).withoutMoPubBrowser().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new VastVideoConfig$handleClick$urlHandler$1(this, context, num)).build();
            String clickThroughUrl3 = getClickThroughUrl();
            if (clickThroughUrl3 != null) {
                build.handleUrl(context, clickThroughUrl3);
            }
        }
    }

    public void handleResume(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this._resumeTrackers, (VastErrorCode) null, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
    }

    public void handlePause(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this._pauseTrackers, (VastErrorCode) null, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
    }

    public void handleClose(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this._closeTrackers, (VastErrorCode) null, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
    }

    public void handleSkip(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this._skipTrackers, (VastErrorCode) null, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
    }

    public void handleComplete(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this._completeTrackers, (VastErrorCode) null, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
    }

    public void handleError(Context context, VastErrorCode vastErrorCode, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TrackingRequest.makeVastTrackingHttpRequest(this._errorTrackers, vastErrorCode, Integer.valueOf(i), getNetworkMediaFileUrl(), context);
    }

    public List<VastTracker> getUntriggeredTrackersBefore(int i, int i2) {
        if (i2 <= 0 || i < 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        VastAbsoluteProgressTracker build = new VastAbsoluteProgressTracker.Builder("", i).build();
        for (VastAbsoluteProgressTracker vastAbsoluteProgressTracker : this._absoluteTrackers) {
            if (vastAbsoluteProgressTracker.compareTo(build) <= 0 && !vastAbsoluteProgressTracker.isTracked()) {
                arrayList.add(vastAbsoluteProgressTracker);
            }
        }
        VastFractionalProgressTracker build2 = new VastFractionalProgressTracker.Builder("", ((float) i) / ((float) i2)).build();
        for (VastFractionalProgressTracker vastFractionalProgressTracker : this._fractionalTrackers) {
            if (vastFractionalProgressTracker.compareTo(build2) <= 0 && !vastFractionalProgressTracker.isTracked()) {
                arrayList.add(vastFractionalProgressTracker);
            }
        }
        return arrayList;
    }

    public int getRemainingProgressTrackerCount() {
        return getUntriggeredTrackersBefore(Integer.MAX_VALUE, Integer.MAX_VALUE).size();
    }

    public Integer getSkipOffsetMillis(int i) throws NumberFormatException {
        Integer num;
        String skipOffset2 = getSkipOffset();
        if (skipOffset2 == null) {
            return null;
        }
        VastAbsoluteProgressTracker.Companion companion = VastAbsoluteProgressTracker.Companion;
        if (companion.isAbsoluteTracker(skipOffset2)) {
            num = companion.parseAbsoluteOffset(skipOffset2);
        } else {
            VastFractionalProgressTracker.Companion companion2 = VastFractionalProgressTracker.Companion;
            if (companion2.isPercentageTracker(skipOffset2)) {
                num = companion2.parsePercentageOffset(skipOffset2, i);
            } else {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Invalid VAST skipoffset format: " + skipOffset2);
                num = null;
            }
        }
        if (num != null) {
            return Integer.valueOf(Math.min(num.intValue(), i));
        }
        return null;
    }

    public String toJsonString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new VastVideoConfigTypeAdapterFactory());
        String json = gsonBuilder.create().toJson((Object) this);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this@VastVideoConfig)");
        return json;
    }

    private List<String> hydrateUrls(String str, JSONArray jSONArray) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jSONArray.optString(i);
            if (optString != null) {
                arrayList.add(StringsKt__StringsJVMKt.replace$default(optString, Constants.VIDEO_TRACKING_URL_MACRO, str, false, 4, (Object) null));
            }
        }
        return arrayList;
    }

    private void addCompleteTrackersForUrls(List<String> list) {
        addCompleteTrackers(createVastTrackersForUrls(list));
    }

    private void addCompanionAdViewTrackersForUrls(List<String> list) {
        List<VastTracker> createVastTrackersForUrls = createVastTrackersForUrls(list);
        for (VastCompanionAdConfig addCreativeViewTrackers : getVastCompanionAdConfigs()) {
            addCreativeViewTrackers.addCreativeViewTrackers(createVastTrackersForUrls);
        }
    }

    private void addCompanionAdClickTrackersForUrls(List<String> list) {
        List<VastTracker> createVastTrackersForUrls = createVastTrackersForUrls(list);
        for (VastCompanionAdConfig addClickTrackers : getVastCompanionAdConfigs()) {
            addClickTrackers.addClickTrackers(createVastTrackersForUrls);
        }
    }

    public void addVastCompanionAdConfig(VastCompanionAdConfig vastCompanionAdConfig) {
        Intrinsics.checkNotNullParameter(vastCompanionAdConfig, "vastCompanionAdConfig");
        getVastCompanionAdConfigs().add(vastCompanionAdConfig);
    }

    /* compiled from: VastVideoConfig.kt */
    private static final class VastVideoConfigTypeAdapterFactory implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken == null || !Class.class.isAssignableFrom(typeToken.getRawType())) {
                return null;
            }
            return new VastVideoConfigTypeAdapter();
        }
    }

    /* compiled from: VastVideoConfig.kt */
    public static final class VastVideoConfigTypeAdapter extends TypeAdapter<Class<?>> {
        public void write(JsonWriter jsonWriter, Class<?> cls) throws IOException {
            if (jsonWriter != null) {
                if (cls == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(cls.getName());
                }
            }
        }

        public Class<?> read(JsonReader jsonReader) throws IOException {
            if (jsonReader == null) {
                return null;
            }
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Class.forName(jsonReader.nextString());
            } catch (ClassNotFoundException e) {
                throw new IOException(e);
            }
        }
    }

    private void addFractionalTrackersForUrls(List<String> list, float f) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (String builder : list) {
            arrayList.add(new VastFractionalProgressTracker.Builder(builder, f).build());
        }
        addFractionalTrackers(arrayList);
    }

    private void addStartTrackersForUrls(List<String> list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (String builder : list) {
            arrayList.add(new VastAbsoluteProgressTracker.Builder(builder, 0).build());
        }
        addAbsoluteTrackers(arrayList);
    }

    private List<VastTracker> createVastTrackersForUrls(List<String> list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (String builder : list) {
            arrayList.add(new VastTracker.Builder(builder).build());
        }
        return arrayList;
    }

    public void addVastCompanionAdConfigs(Iterable<? extends VastCompanionAdConfig> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "vastCompanionAdConfigs");
        for (VastCompanionAdConfig addVastCompanionAdConfig : iterable) {
            addVastCompanionAdConfig(addVastCompanionAdConfig);
        }
    }
}
