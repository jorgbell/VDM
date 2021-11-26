package com.vungle.warren.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.mopub.common.Constants;
import com.vungle.warren.AdConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

public class Advertisement {
    AdConfig adConfig;
    String adMarketId;
    public long adRequestStartTime;
    String adToken;
    int adType;
    String appID;
    public long assetDownloadDuration;
    public long assetDownloadStartTime;
    String bidToken;
    Map<String, Pair<String, String>> cacheableAssets = new HashMap();
    String campaign;
    List<Checkpoint> checkpoints;
    String[] clickUrls;
    String[] closeUrls;
    int countdown;
    boolean ctaClickArea = true;
    String ctaDestinationUrl;
    boolean ctaOverlayEnabled;
    String ctaUrl;
    int delay;
    boolean enableOm;
    long expireTime;
    String identifier;
    String md5;
    Map<String, String> mraidFiles = new HashMap();
    String[] muteUrls;
    String omExtraVast;
    String placementId;
    String[] postRollClickUrls;
    String[] postRollViewUrls;
    String postrollBundleUrl;
    boolean requiresNonMarketInstall;
    int retryCount;
    int showCloseDelay;
    int showCloseIncentivized;
    int state = 0;
    String templateId;
    Map<String, String> templateSettings;
    String templateType;
    String templateUrl;
    long ttDownload;
    String[] unmuteUrls;
    String[] videoClickUrls;
    int videoHeight;
    String videoIdentifier;
    String videoUrl;
    int videoWidth;

    Advertisement() {
    }

    public long getTtDownload() {
        return this.ttDownload;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setAssetDownloadStartTime(long j) {
        this.assetDownloadStartTime = j;
    }

    public void setFinishedDownloadingTime(long j) {
        this.assetDownloadDuration = j - this.assetDownloadStartTime;
        this.ttDownload = j - this.adRequestStartTime;
    }

    public void setAdRequestStartTime(long j) {
        this.adRequestStartTime = j;
    }

    public long getAssetDownloadDuration() {
        return this.assetDownloadDuration;
    }

    public boolean isCtaOverlayEnabled() {
        return this.ctaOverlayEnabled;
    }

    public boolean getCtaClickArea() {
        return this.ctaClickArea;
    }

    public Advertisement(JsonObject jsonObject) throws IllegalArgumentException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (JsonUtil.hasNonNull(jsonObject, "ad_markup")) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject("ad_markup");
            if (JsonUtil.hasNonNull(asJsonObject, "adType")) {
                String asString = asJsonObject.get("adType").getAsString();
                asString.hashCode();
                if (asString.equals("vungle_local")) {
                    this.adType = 0;
                    if (JsonUtil.hasNonNull(asJsonObject, "postBundle")) {
                        str9 = asJsonObject.get("postBundle").getAsString();
                    } else {
                        str9 = "";
                    }
                    this.postrollBundleUrl = str9;
                    if (JsonUtil.hasNonNull(asJsonObject, "url")) {
                        str10 = asJsonObject.get("url").getAsString();
                    } else {
                        str10 = "";
                    }
                    this.templateSettings = new HashMap();
                    this.templateUrl = "";
                    this.templateId = "";
                    this.templateType = "";
                } else if (asString.equals("vungle_mraid")) {
                    this.adType = 1;
                    this.postrollBundleUrl = "";
                    if (JsonUtil.hasNonNull(asJsonObject, "templateSettings")) {
                        this.templateSettings = new HashMap();
                        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("templateSettings");
                        if (JsonUtil.hasNonNull(asJsonObject2, "normal_replacements")) {
                            for (Map.Entry next : asJsonObject2.getAsJsonObject("normal_replacements").entrySet()) {
                                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                                    this.templateSettings.put(next.getKey(), (next.getValue() == null || ((JsonElement) next.getValue()).isJsonNull()) ? null : ((JsonElement) next.getValue()).getAsString());
                                }
                            }
                        }
                        if (JsonUtil.hasNonNull(asJsonObject2, "cacheable_replacements")) {
                            str = "";
                            for (Map.Entry next2 : asJsonObject2.getAsJsonObject("cacheable_replacements").entrySet()) {
                                if (!TextUtils.isEmpty((CharSequence) next2.getKey()) && next2.getValue() != null && JsonUtil.hasNonNull((JsonElement) next2.getValue(), "url") && JsonUtil.hasNonNull((JsonElement) next2.getValue(), "extension")) {
                                    String asString2 = ((JsonElement) next2.getValue()).getAsJsonObject().get("url").getAsString();
                                    this.cacheableAssets.put(next2.getKey(), new Pair(asString2, ((JsonElement) next2.getValue()).getAsJsonObject().get("extension").getAsString()));
                                    if (((String) next2.getKey()).equalsIgnoreCase("MAIN_VIDEO")) {
                                        str = asString2;
                                    }
                                }
                            }
                        } else {
                            str = "";
                        }
                        if (JsonUtil.hasNonNull(asJsonObject, "templateId")) {
                            this.templateId = asJsonObject.get("templateId").getAsString();
                            if (JsonUtil.hasNonNull(asJsonObject, "template_type")) {
                                this.templateType = asJsonObject.get("template_type").getAsString();
                                if (JsonUtil.hasNonNull(asJsonObject, "templateURL")) {
                                    this.templateUrl = asJsonObject.get("templateURL").getAsString();
                                } else {
                                    throw new IllegalArgumentException("Template URL missing!");
                                }
                            } else {
                                throw new IllegalArgumentException("Template Type missing!");
                            }
                        } else {
                            throw new IllegalArgumentException("Missing templateID!");
                        }
                    } else {
                        throw new IllegalArgumentException("Missing template adConfig!");
                    }
                } else {
                    throw new IllegalArgumentException("Unknown Ad Type " + asString + "! Please add this ad type");
                }
                if (!TextUtils.isEmpty(str)) {
                    this.videoUrl = str;
                } else {
                    this.videoUrl = "";
                }
                if (JsonUtil.hasNonNull(asJsonObject, "id")) {
                    this.identifier = asJsonObject.get("id").getAsString();
                    if (JsonUtil.hasNonNull(asJsonObject, "campaign")) {
                        this.campaign = asJsonObject.get("campaign").getAsString();
                        if (JsonUtil.hasNonNull(asJsonObject, "app_id")) {
                            this.appID = asJsonObject.get("app_id").getAsString();
                            if (!JsonUtil.hasNonNull(asJsonObject, "expiry") || asJsonObject.get("expiry").isJsonNull()) {
                                this.expireTime = System.currentTimeMillis() / 1000;
                            } else {
                                long asLong = asJsonObject.get("expiry").getAsLong();
                                if (asLong > 0) {
                                    this.expireTime = asLong;
                                } else {
                                    this.expireTime = System.currentTimeMillis() / 1000;
                                }
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "tpat")) {
                                JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("tpat");
                                this.checkpoints = new ArrayList(5);
                                int i = this.adType;
                                if (i != 0) {
                                    if (i == 1) {
                                        for (int i2 = 0; i2 < 5; i2++) {
                                            int i3 = i2 * 25;
                                            String format = String.format(Locale.ENGLISH, "checkpoint.%d", new Object[]{Integer.valueOf(i3)});
                                            this.checkpoints.add(i2, JsonUtil.hasNonNull(asJsonObject3, format) ? new Checkpoint(asJsonObject3.getAsJsonArray(format), (byte) i3) : null);
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Unknown Ad Type!");
                                    }
                                } else if (JsonUtil.hasNonNull(asJsonObject3, "play_percentage")) {
                                    JsonArray asJsonArray = asJsonObject3.getAsJsonArray("play_percentage");
                                    for (int i4 = 0; i4 < asJsonArray.size(); i4++) {
                                        if (asJsonArray.get(i4) != null) {
                                            this.checkpoints.add(new Checkpoint(asJsonArray.get(i4).getAsJsonObject()));
                                        }
                                    }
                                    Collections.sort(this.checkpoints);
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, "clickUrl")) {
                                    JsonArray asJsonArray2 = asJsonObject3.getAsJsonArray("clickUrl");
                                    this.clickUrls = new String[asJsonArray2.size()];
                                    Iterator<JsonElement> it = asJsonArray2.iterator();
                                    int i5 = 0;
                                    while (it.hasNext()) {
                                        this.clickUrls[i5] = it.next().getAsString();
                                        i5++;
                                    }
                                } else {
                                    this.clickUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, "video_click")) {
                                    JsonArray asJsonArray3 = asJsonObject3.getAsJsonArray("video_click");
                                    this.videoClickUrls = new String[asJsonArray3.size()];
                                    for (int i6 = 0; i6 < asJsonArray3.size(); i6++) {
                                        if (asJsonArray3.get(i6) == null || "null".equalsIgnoreCase(asJsonArray3.get(i6).toString())) {
                                            this.videoClickUrls[i6] = "";
                                        } else {
                                            this.videoClickUrls[i6] = asJsonArray3.get(i6).getAsString();
                                        }
                                    }
                                } else {
                                    this.videoClickUrls = new String[0];
                                }
                                int i7 = this.adType;
                                if (i7 == 0) {
                                    str8 = "mute";
                                    str7 = "unmute";
                                    str6 = "video_close";
                                    str5 = "postroll_click";
                                    str4 = "postroll_view";
                                } else if (i7 == 1) {
                                    str8 = "video.mute";
                                    str7 = "video.unmute";
                                    str6 = "video.close";
                                    str5 = "postroll.click";
                                    str4 = "postroll.view";
                                } else {
                                    throw new IllegalArgumentException("Unknown AdType!");
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str8)) {
                                    JsonArray asJsonArray4 = asJsonObject3.getAsJsonArray(str8);
                                    this.muteUrls = new String[asJsonArray4.size()];
                                    for (int i8 = 0; i8 < asJsonArray4.size(); i8++) {
                                        if (asJsonArray4.get(i8) == null || "null".equalsIgnoreCase(asJsonArray4.get(i8).toString())) {
                                            this.muteUrls[i8] = "";
                                        } else {
                                            this.muteUrls[i8] = asJsonArray4.get(i8).getAsString();
                                        }
                                    }
                                } else {
                                    this.muteUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str7)) {
                                    JsonArray asJsonArray5 = asJsonObject3.getAsJsonArray(str7);
                                    this.unmuteUrls = new String[asJsonArray5.size()];
                                    for (int i9 = 0; i9 < asJsonArray5.size(); i9++) {
                                        if (asJsonArray5.get(i9) == null || "null".equalsIgnoreCase(asJsonArray5.get(i9).toString())) {
                                            this.unmuteUrls[i9] = "";
                                        } else {
                                            this.unmuteUrls[i9] = asJsonArray5.get(i9).getAsString();
                                        }
                                    }
                                } else {
                                    this.unmuteUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str6)) {
                                    JsonArray asJsonArray6 = asJsonObject3.getAsJsonArray(str6);
                                    this.closeUrls = new String[asJsonArray6.size()];
                                    for (int i10 = 0; i10 < asJsonArray6.size(); i10++) {
                                        if (asJsonArray6.get(i10) == null || "null".equalsIgnoreCase(asJsonArray6.get(i10).toString())) {
                                            this.closeUrls[i10] = "";
                                        } else {
                                            this.closeUrls[i10] = asJsonArray6.get(i10).getAsString();
                                        }
                                    }
                                } else {
                                    this.closeUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str5)) {
                                    JsonArray asJsonArray7 = asJsonObject3.getAsJsonArray(str5);
                                    this.postRollClickUrls = new String[asJsonArray7.size()];
                                    for (int i11 = 0; i11 < asJsonArray7.size(); i11++) {
                                        if (asJsonArray7.get(i11) == null || "null".equalsIgnoreCase(asJsonArray7.get(i11).toString())) {
                                            this.postRollClickUrls[i11] = "";
                                        } else {
                                            this.postRollClickUrls[i11] = asJsonArray7.get(i11).getAsString();
                                        }
                                    }
                                } else {
                                    this.postRollClickUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str4)) {
                                    JsonArray asJsonArray8 = asJsonObject3.getAsJsonArray(str4);
                                    this.postRollViewUrls = new String[asJsonArray8.size()];
                                    for (int i12 = 0; i12 < asJsonArray8.size(); i12++) {
                                        if (asJsonArray8.get(i12) == null || "null".equalsIgnoreCase(asJsonArray8.get(i12).toString())) {
                                            this.postRollViewUrls[i12] = "";
                                        } else {
                                            this.postRollViewUrls[i12] = asJsonArray8.get(i12).getAsString();
                                        }
                                    }
                                } else {
                                    this.postRollViewUrls = new String[0];
                                }
                            } else {
                                this.checkpoints = new ArrayList();
                                this.muteUrls = new String[0];
                                this.closeUrls = new String[0];
                                this.unmuteUrls = new String[0];
                                this.postRollViewUrls = new String[0];
                                this.postRollClickUrls = new String[0];
                                this.clickUrls = new String[0];
                                this.videoClickUrls = new String[0];
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "delay")) {
                                this.delay = asJsonObject.get("delay").getAsInt();
                            } else {
                                this.delay = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "showClose")) {
                                this.showCloseDelay = asJsonObject.get("showClose").getAsInt();
                            } else {
                                this.showCloseDelay = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "showCloseIncentivized")) {
                                this.showCloseIncentivized = asJsonObject.get("showCloseIncentivized").getAsInt();
                            } else {
                                this.showCloseIncentivized = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "countdown")) {
                                this.countdown = asJsonObject.get("countdown").getAsInt();
                            } else {
                                this.countdown = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "videoWidth")) {
                                this.videoWidth = asJsonObject.get("videoWidth").getAsInt();
                                if (JsonUtil.hasNonNull(asJsonObject, "videoHeight")) {
                                    this.videoHeight = asJsonObject.get("videoHeight").getAsInt();
                                    if (JsonUtil.hasNonNull(asJsonObject, "md5")) {
                                        this.md5 = asJsonObject.get("md5").getAsString();
                                    } else {
                                        this.md5 = "";
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "cta_overlay")) {
                                        JsonObject asJsonObject4 = asJsonObject.getAsJsonObject("cta_overlay");
                                        if (JsonUtil.hasNonNull(asJsonObject4, "enabled")) {
                                            this.ctaOverlayEnabled = asJsonObject4.get("enabled").getAsBoolean();
                                        } else {
                                            this.ctaOverlayEnabled = false;
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject4, "click_area") && !asJsonObject4.get("click_area").getAsString().isEmpty() && asJsonObject4.get("click_area").getAsDouble() == 0.0d) {
                                            this.ctaClickArea = false;
                                        }
                                    } else {
                                        this.ctaOverlayEnabled = false;
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "callToActionDest")) {
                                        str2 = asJsonObject.get("callToActionDest").getAsString();
                                    } else {
                                        str2 = "";
                                    }
                                    this.ctaDestinationUrl = str2;
                                    if (JsonUtil.hasNonNull(asJsonObject, "callToActionUrl")) {
                                        str3 = asJsonObject.get("callToActionUrl").getAsString();
                                    } else {
                                        str3 = "";
                                    }
                                    this.ctaUrl = str3;
                                    if (JsonUtil.hasNonNull(asJsonObject, "retryCount")) {
                                        this.retryCount = asJsonObject.get("retryCount").getAsInt();
                                    } else {
                                        this.retryCount = 1;
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "ad_token")) {
                                        this.adToken = asJsonObject.get("ad_token").getAsString();
                                        if (JsonUtil.hasNonNull(asJsonObject, "video_object_id")) {
                                            this.videoIdentifier = asJsonObject.get("video_object_id").getAsString();
                                        } else {
                                            this.videoIdentifier = "";
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, "requires_sideloading")) {
                                            this.requiresNonMarketInstall = asJsonObject.get("requires_sideloading").getAsBoolean();
                                        } else {
                                            this.requiresNonMarketInstall = false;
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, "ad_market_id")) {
                                            this.adMarketId = asJsonObject.get("ad_market_id").getAsString();
                                        } else {
                                            this.adMarketId = "";
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, "bid_token")) {
                                            this.bidToken = asJsonObject.get("bid_token").getAsString();
                                        } else {
                                            this.bidToken = "";
                                        }
                                        JsonObject asObject = JsonUtil.getAsObject(JsonUtil.getAsObject(asJsonObject, "viewability"), "om");
                                        this.enableOm = JsonUtil.getAsBoolean(asObject, "is_enabled", false);
                                        this.omExtraVast = JsonUtil.getAsString(asObject, "extra_vast", (String) null);
                                        this.adConfig = new AdConfig();
                                        return;
                                    }
                                    throw new IllegalArgumentException("AdToken missing!");
                                }
                                throw new IllegalArgumentException("Missing video height!");
                            }
                            throw new IllegalArgumentException("Missing video width!");
                        }
                        throw new IllegalArgumentException("Missing app Id, cannot process advertisement!");
                    }
                    throw new IllegalArgumentException("Missing campaign information, cannot process advertisement!");
                }
                throw new IllegalArgumentException("Missing identifier, cannot process advertisement!");
            }
            throw new IllegalArgumentException("Advertisement did not contain an adType!");
        }
        throw new IllegalArgumentException("JSON does not contain ad markup!");
    }

    public int getAdType() {
        return this.adType;
    }

    public List<Checkpoint> getCheckpoints() {
        return this.checkpoints;
    }

    public void configure(AdConfig adConfig2) {
        if (adConfig2 == null) {
            this.adConfig = new AdConfig();
        } else {
            this.adConfig = adConfig2;
        }
    }

    public AdConfig getAdConfig() {
        return this.adConfig;
    }

    public int getOrientation() {
        return this.videoWidth > this.videoHeight ? 1 : 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Advertisement)) {
            return false;
        }
        Advertisement advertisement = (Advertisement) obj;
        if (advertisement.adType != this.adType || advertisement.delay != this.delay || advertisement.showCloseDelay != this.showCloseDelay || advertisement.showCloseIncentivized != this.showCloseIncentivized || advertisement.countdown != this.countdown || advertisement.videoWidth != this.videoWidth || advertisement.videoHeight != this.videoHeight || advertisement.ctaOverlayEnabled != this.ctaOverlayEnabled || advertisement.ctaClickArea != this.ctaClickArea || advertisement.retryCount != this.retryCount || advertisement.enableOm != this.enableOm || advertisement.requiresNonMarketInstall != this.requiresNonMarketInstall || advertisement.state != this.state || (str = advertisement.identifier) == null || (str2 = this.identifier) == null || !str.equals(str2) || !advertisement.campaign.equals(this.campaign) || !advertisement.videoUrl.equals(this.videoUrl) || !advertisement.md5.equals(this.md5) || !advertisement.postrollBundleUrl.equals(this.postrollBundleUrl) || !advertisement.ctaDestinationUrl.equals(this.ctaDestinationUrl) || !advertisement.ctaUrl.equals(this.ctaUrl) || !advertisement.adToken.equals(this.adToken) || !advertisement.videoIdentifier.equals(this.videoIdentifier)) {
            return false;
        }
        String str3 = advertisement.omExtraVast;
        if (str3 == null ? this.omExtraVast != null : !str3.equals(this.omExtraVast)) {
            return false;
        }
        if (!advertisement.adMarketId.equals(this.adMarketId) || !advertisement.bidToken.equals(this.bidToken) || advertisement.checkpoints.size() != this.checkpoints.size()) {
            return false;
        }
        for (int i = 0; i < this.checkpoints.size(); i++) {
            if (!advertisement.checkpoints.get(i).equals(this.checkpoints.get(i))) {
                return false;
            }
        }
        if (advertisement.muteUrls.length != this.muteUrls.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.muteUrls;
            if (i2 < strArr.length) {
                if (!advertisement.muteUrls[i2].equals(strArr[i2])) {
                    return false;
                }
                i2++;
            } else if (advertisement.unmuteUrls.length != this.unmuteUrls.length) {
                return false;
            } else {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.unmuteUrls;
                    if (i3 < strArr2.length) {
                        if (!advertisement.unmuteUrls[i3].equals(strArr2[i3])) {
                            return false;
                        }
                        i3++;
                    } else if (advertisement.closeUrls.length != this.closeUrls.length) {
                        return false;
                    } else {
                        int i4 = 0;
                        while (true) {
                            String[] strArr3 = this.closeUrls;
                            if (i4 < strArr3.length) {
                                if (!advertisement.closeUrls[i4].equals(strArr3[i4])) {
                                    return false;
                                }
                                i4++;
                            } else if (advertisement.postRollClickUrls.length != this.postRollClickUrls.length) {
                                return false;
                            } else {
                                int i5 = 0;
                                while (true) {
                                    String[] strArr4 = this.postRollClickUrls;
                                    if (i5 < strArr4.length) {
                                        if (!advertisement.postRollClickUrls[i5].equals(strArr4[i5])) {
                                            return false;
                                        }
                                        i5++;
                                    } else if (advertisement.postRollViewUrls.length != this.postRollViewUrls.length) {
                                        return false;
                                    } else {
                                        int i6 = 0;
                                        while (true) {
                                            String[] strArr5 = this.postRollViewUrls;
                                            if (i6 < strArr5.length) {
                                                if (!advertisement.postRollViewUrls[i6].equals(strArr5[i6])) {
                                                    return false;
                                                }
                                                i6++;
                                            } else if (advertisement.videoClickUrls.length != this.videoClickUrls.length) {
                                                return false;
                                            } else {
                                                int i7 = 0;
                                                while (true) {
                                                    String[] strArr6 = this.videoClickUrls;
                                                    if (i7 >= strArr6.length) {
                                                        return true;
                                                    }
                                                    if (!advertisement.videoClickUrls[i7].equals(strArr6[i7])) {
                                                        return false;
                                                    }
                                                    i7++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((this.adType * 31) + this.identifier.hashCode()) * 31) + this.checkpoints.hashCode()) * 31) + Arrays.hashCode(this.muteUrls)) * 31) + Arrays.hashCode(this.unmuteUrls)) * 31) + Arrays.hashCode(this.closeUrls)) * 31) + Arrays.hashCode(this.postRollClickUrls)) * 31) + Arrays.hashCode(this.postRollViewUrls)) * 31) + Arrays.hashCode(this.videoClickUrls)) * 31) + this.delay) * 31) + this.campaign.hashCode()) * 31) + this.showCloseDelay) * 31) + this.showCloseIncentivized) * 31) + this.countdown) * 31) + this.videoUrl.hashCode()) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31) + this.md5.hashCode()) * 31) + this.postrollBundleUrl.hashCode()) * 31) + (this.ctaOverlayEnabled ? 1 : 0)) * 31) + (this.ctaClickArea ? 1 : 0)) * 31) + this.ctaDestinationUrl.hashCode()) * 31) + this.ctaUrl.hashCode()) * 31) + this.retryCount) * 31) + this.adToken.hashCode()) * 31) + this.videoIdentifier.hashCode()) * 31) + (this.enableOm ? 1 : 0)) * 31;
        String str = this.omExtraVast;
        return ((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + (this.requiresNonMarketInstall ? 1 : 0)) * 31) + this.adMarketId.hashCode()) * 31) + this.bidToken.hashCode()) * 31) + this.state;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        if (r12.equals("postroll.view") == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fe, code lost:
        if (r12.equals("postroll_view") == false) goto L_0x00f6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] getTpatUrls(java.lang.String r12) {
        /*
            r11 = this;
            int r0 = r11.adType
            java.lang.String r1 = "Unknown TPAT Event "
            r2 = 6
            r3 = 5
            r4 = 4
            java.lang.String r5 = "video_click"
            r6 = 3
            r7 = 2
            r8 = -1
            r9 = 0
            r10 = 1
            if (r0 == 0) goto L_0x00ec
            if (r0 != r10) goto L_0x00e4
            java.lang.String r0 = "checkpoint"
            boolean r0 = r12.startsWith(r0)
            if (r0 == 0) goto L_0x0039
            java.lang.String[] r0 = new java.lang.String[r9]
            java.lang.String r1 = "\\."
            java.lang.String[] r12 = r12.split(r1)
            r12 = r12[r10]
            int r12 = java.lang.Integer.parseInt(r12)
            java.util.List<com.vungle.warren.model.Advertisement$Checkpoint> r1 = r11.checkpoints
            int r12 = r12 / 25
            java.lang.Object r12 = r1.get(r12)
            com.vungle.warren.model.Advertisement$Checkpoint r12 = (com.vungle.warren.model.Advertisement.Checkpoint) r12
            if (r12 == 0) goto L_0x0038
            java.lang.String[] r0 = r12.getUrls()
        L_0x0038:
            return r0
        L_0x0039:
            r12.hashCode()
            int r0 = r12.hashCode()
            switch(r0) {
                case -1663300692: goto L_0x0083;
                case -1293192841: goto L_0x0078;
                case -481751803: goto L_0x006d;
                case -32221499: goto L_0x0062;
                case 906443463: goto L_0x0057;
                case 1370600644: goto L_0x004e;
                case 1621415126: goto L_0x0045;
                default: goto L_0x0043;
            }
        L_0x0043:
            r2 = -1
            goto L_0x008d
        L_0x0045:
            java.lang.String r0 = "postroll.view"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x008d
            goto L_0x0043
        L_0x004e:
            boolean r0 = r12.equals(r5)
            if (r0 != 0) goto L_0x0055
            goto L_0x0043
        L_0x0055:
            r2 = 5
            goto L_0x008d
        L_0x0057:
            java.lang.String r0 = "clickUrl"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0060
            goto L_0x0043
        L_0x0060:
            r2 = 4
            goto L_0x008d
        L_0x0062:
            java.lang.String r0 = "video.close"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x006b
            goto L_0x0043
        L_0x006b:
            r2 = 3
            goto L_0x008d
        L_0x006d:
            java.lang.String r0 = "video.unmute"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0076
            goto L_0x0043
        L_0x0076:
            r2 = 2
            goto L_0x008d
        L_0x0078:
            java.lang.String r0 = "postroll.click"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0081
            goto L_0x0043
        L_0x0081:
            r2 = 1
            goto L_0x008d
        L_0x0083:
            java.lang.String r0 = "video.mute"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x008c
            goto L_0x0043
        L_0x008c:
            r2 = 0
        L_0x008d:
            switch(r2) {
                case 0: goto L_0x00db;
                case 1: goto L_0x00d2;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00ae;
                case 6: goto L_0x00a5;
                default: goto L_0x0090;
            }
        L_0x0090:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r0.<init>(r12)
            throw r0
        L_0x00a5:
            java.lang.String[] r12 = r11.postRollViewUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00ae:
            java.lang.String[] r12 = r11.videoClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00b7:
            java.lang.String[] r12 = r11.clickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00c0:
            java.lang.String[] r12 = r11.closeUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00c9:
            java.lang.String[] r12 = r11.unmuteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00d2:
            java.lang.String[] r12 = r11.postRollClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00db:
            java.lang.String[] r12 = r11.muteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00e4:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unknown Advertisement Type!"
            r12.<init>(r0)
            throw r12
        L_0x00ec:
            r12.hashCode()
            int r0 = r12.hashCode()
            switch(r0) {
                case -1964722632: goto L_0x0136;
                case -840405966: goto L_0x012b;
                case 3363353: goto L_0x0120;
                case 109635558: goto L_0x0115;
                case 1370600644: goto L_0x010c;
                case 1370606900: goto L_0x0101;
                case 1666667655: goto L_0x00f8;
                default: goto L_0x00f6;
            }
        L_0x00f6:
            r2 = -1
            goto L_0x0140
        L_0x00f8:
            java.lang.String r0 = "postroll_view"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0140
            goto L_0x00f6
        L_0x0101:
            java.lang.String r0 = "video_close"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x010a
            goto L_0x00f6
        L_0x010a:
            r2 = 5
            goto L_0x0140
        L_0x010c:
            boolean r0 = r12.equals(r5)
            if (r0 != 0) goto L_0x0113
            goto L_0x00f6
        L_0x0113:
            r2 = 4
            goto L_0x0140
        L_0x0115:
            java.lang.String r0 = "postroll_click"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x011e
            goto L_0x00f6
        L_0x011e:
            r2 = 3
            goto L_0x0140
        L_0x0120:
            java.lang.String r0 = "mute"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0129
            goto L_0x00f6
        L_0x0129:
            r2 = 2
            goto L_0x0140
        L_0x012b:
            java.lang.String r0 = "unmute"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0134
            goto L_0x00f6
        L_0x0134:
            r2 = 1
            goto L_0x0140
        L_0x0136:
            java.lang.String r0 = "click_url"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x00f6
        L_0x013f:
            r2 = 0
        L_0x0140:
            switch(r2) {
                case 0: goto L_0x018e;
                case 1: goto L_0x0185;
                case 2: goto L_0x017c;
                case 3: goto L_0x0173;
                case 4: goto L_0x016a;
                case 5: goto L_0x0161;
                case 6: goto L_0x0158;
                default: goto L_0x0143;
            }
        L_0x0143:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r0.<init>(r12)
            throw r0
        L_0x0158:
            java.lang.String[] r12 = r11.postRollViewUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x0161:
            java.lang.String[] r12 = r11.closeUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x016a:
            java.lang.String[] r12 = r11.videoClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x0173:
            java.lang.String[] r12 = r11.postRollClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x017c:
            java.lang.String[] r12 = r11.muteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x0185:
            java.lang.String[] r12 = r11.unmuteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x018e:
            java.lang.String[] r12 = r11.clickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getTpatUrls(java.lang.String):java.lang.String[]");
    }

    public String getId() {
        String str = this.identifier;
        return str == null ? "" : str;
    }

    public String getAdToken() {
        return this.adToken;
    }

    public String getAppID() {
        return this.appID;
    }

    /* access modifiers changed from: package-private */
    public String getUrl() {
        return this.videoUrl;
    }

    public String getCampaign() {
        return this.campaign;
    }

    /* access modifiers changed from: package-private */
    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public int getShowCloseDelay(boolean z) {
        int i;
        if (z) {
            i = this.showCloseIncentivized;
        } else {
            i = this.showCloseDelay;
        }
        return i * 1000;
    }

    public boolean getOmEnabled() {
        return this.enableOm;
    }

    public long getExpireTime() {
        return this.expireTime * 1000;
    }

    public JsonObject createMRAIDArgs() {
        if (this.templateSettings != null) {
            HashMap hashMap = new HashMap(this.templateSettings);
            for (Map.Entry next : this.cacheableAssets.entrySet()) {
                hashMap.put(next.getKey(), ((Pair) next.getValue()).first);
            }
            if (!this.mraidFiles.isEmpty()) {
                hashMap.putAll(this.mraidFiles);
            }
            String str = "true";
            if (!str.equalsIgnoreCase((String) hashMap.get("START_MUTED"))) {
                if ((getAdConfig().getSettings() & 1) == 0) {
                    str = "false";
                }
                hashMap.put("START_MUTED", str);
            }
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
            }
            return jsonObject;
        }
        throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!");
    }

    public String getCTAURL(boolean z) {
        int i = this.adType;
        if (i == 0) {
            return z ? this.ctaUrl : this.ctaDestinationUrl;
        }
        if (i == 1) {
            return this.ctaUrl;
        }
        throw new IllegalArgumentException("Unknown AdType " + this.adType);
    }

    public boolean hasPostroll() {
        return !TextUtils.isEmpty(this.postrollBundleUrl);
    }

    public Map<String, String> getDownloadableUrls() {
        HashMap hashMap = new HashMap();
        int i = this.adType;
        if (i == 0) {
            hashMap.put("video", this.videoUrl);
            if (!TextUtils.isEmpty(this.postrollBundleUrl)) {
                hashMap.put("postroll", this.postrollBundleUrl);
            }
        } else if (i == 1) {
            hashMap.put("template", this.templateUrl);
            for (Map.Entry<String, Pair<String, String>> value : this.cacheableAssets.entrySet()) {
                String str = (String) ((Pair) value.getValue()).first;
                if (isValidUrl(str)) {
                    hashMap.put(URLUtil.guessFileName(str, (String) null, (String) null), str);
                }
            }
        } else {
            throw new IllegalStateException("Advertisement created without adType!");
        }
        return hashMap;
    }

    private boolean isValidUrl(String str) {
        return !TextUtils.isEmpty(str) && HttpUrl.parse(str) != null;
    }

    public void setMraidAssetDir(File file) {
        for (Map.Entry next : this.cacheableAssets.entrySet()) {
            String str = (String) ((Pair) next.getValue()).first;
            if (isValidUrl(str)) {
                File file2 = new File(file, URLUtil.guessFileName(str, (String) null, (String) null));
                if (file2.exists()) {
                    Map<String, String> map = this.mraidFiles;
                    Object key = next.getKey();
                    map.put(key, "file://" + file2.getPath());
                }
            }
        }
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public static class Checkpoint implements Comparable<Checkpoint> {
        @SerializedName("percentage")
        private byte percentage;
        @SerializedName("urls")
        private String[] urls;

        public Checkpoint(JsonObject jsonObject) throws IllegalArgumentException {
            if (JsonUtil.hasNonNull(jsonObject, "checkpoint")) {
                this.percentage = (byte) ((int) (jsonObject.get("checkpoint").getAsFloat() * 100.0f));
                if (JsonUtil.hasNonNull(jsonObject, Constants.VIDEO_TRACKING_URLS_KEY)) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray(Constants.VIDEO_TRACKING_URLS_KEY);
                    this.urls = new String[asJsonArray.size()];
                    for (int i = 0; i < asJsonArray.size(); i++) {
                        if (asJsonArray.get(i) == null || "null".equalsIgnoreCase(asJsonArray.get(i).toString())) {
                            this.urls[i] = "";
                        } else {
                            this.urls[i] = asJsonArray.get(i).getAsString();
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Checkpoint missing reporting URL!");
            }
            throw new IllegalArgumentException("Checkpoint missing percentage!");
        }

        public Checkpoint(JsonArray jsonArray, byte b) {
            if (jsonArray.size() != 0) {
                this.urls = new String[jsonArray.size()];
                for (int i = 0; i < jsonArray.size(); i++) {
                    this.urls[i] = jsonArray.get(i).getAsString();
                }
                this.percentage = b;
                return;
            }
            throw new IllegalArgumentException("Empty URLS!");
        }

        public String[] getUrls() {
            return (String[]) this.urls.clone();
        }

        public byte getPercentage() {
            return this.percentage;
        }

        public int compareTo(Checkpoint checkpoint) {
            return Float.compare((float) this.percentage, (float) checkpoint.percentage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Checkpoint)) {
                return false;
            }
            Checkpoint checkpoint = (Checkpoint) obj;
            if (checkpoint.percentage != this.percentage || checkpoint.urls.length != this.urls.length) {
                return false;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.urls;
                if (i >= strArr.length) {
                    return true;
                }
                if (!checkpoint.urls[i].equals(strArr[i])) {
                    return false;
                }
                i++;
            }
        }

        public int hashCode() {
            String[] strArr = this.urls;
            return (((this.percentage * 31) + strArr.length) * 31) + Arrays.hashCode(strArr);
        }
    }

    public String toString() {
        return "Advertisement{adType=" + this.adType + ", identifier='" + this.identifier + '\'' + ", appID='" + this.appID + '\'' + ", expireTime=" + this.expireTime + ", checkpoints=" + this.checkpoints + ", muteUrls=" + Arrays.toString(this.muteUrls) + ", unmuteUrls=" + Arrays.toString(this.unmuteUrls) + ", closeUrls=" + Arrays.toString(this.closeUrls) + ", postRollClickUrls=" + Arrays.toString(this.postRollClickUrls) + ", postRollViewUrls=" + Arrays.toString(this.postRollViewUrls) + ", videoClickUrls=" + Arrays.toString(this.videoClickUrls) + ", clickUrls=" + Arrays.toString(this.clickUrls) + ", delay=" + this.delay + ", campaign='" + this.campaign + '\'' + ", showCloseDelay=" + this.showCloseDelay + ", showCloseIncentivized=" + this.showCloseIncentivized + ", countdown=" + this.countdown + ", videoUrl='" + this.videoUrl + '\'' + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", md5='" + this.md5 + '\'' + ", postrollBundleUrl='" + this.postrollBundleUrl + '\'' + ", ctaOverlayEnabled=" + this.ctaOverlayEnabled + ", ctaClickArea=" + this.ctaClickArea + ", ctaDestinationUrl='" + this.ctaDestinationUrl + '\'' + ", ctaUrl='" + this.ctaUrl + '\'' + ", adConfig=" + this.adConfig + ", retryCount=" + this.retryCount + ", adToken='" + this.adToken + '\'' + ", videoIdentifier='" + this.videoIdentifier + '\'' + ", templateUrl='" + this.templateUrl + '\'' + ", templateSettings=" + this.templateSettings + ", mraidFiles=" + this.mraidFiles + ", cacheableAssets=" + this.cacheableAssets + ", templateId='" + this.templateId + '\'' + ", templateType='" + this.templateType + '\'' + ", enableOm=" + this.enableOm + ", oMSDKExtraVast='" + this.omExtraVast + '\'' + ", requiresNonMarketInstall=" + this.requiresNonMarketInstall + ", adMarketId='" + this.adMarketId + '\'' + ", bidToken='" + this.bidToken + '\'' + ", state=" + this.state + '\'' + ", assetDownloadStartTime='" + this.assetDownloadStartTime + '\'' + ", assetDownloadDuration='" + this.assetDownloadDuration + '\'' + ", adRequestStartTime='" + this.adRequestStartTime + '}';
    }

    public String getAdvertiserAppId() {
        String appID2 = getAppID();
        String appID3 = getAppID();
        if (appID3 != null && appID3.length() > 3) {
            try {
                JSONObject jSONObject = new JSONObject(appID3.substring(3));
                appID2 = jSONObject.isNull("app_id") ? null : jSONObject.optString("app_id", (String) null);
            } catch (JSONException e) {
                Log.e("Advertisement", "JsonException : ", e);
            }
        }
        return TextUtils.isEmpty(appID2) ? "unknown" : appID2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCampaignId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 1
            if (r1 < r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCampaignId():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCreativeId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 2
            if (r1 < r2) goto L_0x0018
            r1 = 1
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCreativeId():java.lang.String");
    }
}
