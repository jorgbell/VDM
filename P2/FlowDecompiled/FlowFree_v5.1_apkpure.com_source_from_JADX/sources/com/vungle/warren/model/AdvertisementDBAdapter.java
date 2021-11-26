package com.vungle.warren.model;

import android.content.ContentValues;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vungle.warren.AdConfig;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.persistence.ContentValuesUtil;
import com.vungle.warren.persistence.DBAdapter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class AdvertisementDBAdapter implements DBAdapter<Advertisement> {
    private Type cacheableMapType = new TypeToken<Map<String, Pair<String, String>>>(this) {
    }.getType();
    private Type checkpointListType = new TypeToken<List<Advertisement.Checkpoint>>(this) {
    }.getType();
    private Gson gson = new GsonBuilder().create();
    private Type stringArrayType = new TypeToken<String[]>(this) {
    }.getType();
    private Type stringMapType = new TypeToken<Map<String, String>>(this) {
    }.getType();

    public String tableName() {
        return "advertisement";
    }

    public ContentValues toContentValues(Advertisement advertisement) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", advertisement.identifier);
        contentValues.put("ad_type", Integer.valueOf(advertisement.getAdType()));
        contentValues.put("expire_time", Long.valueOf(advertisement.expireTime));
        contentValues.put("delay", Integer.valueOf(advertisement.delay));
        contentValues.put("show_close_delay", Integer.valueOf(advertisement.showCloseDelay));
        contentValues.put("show_close_incentivized", Integer.valueOf(advertisement.showCloseIncentivized));
        contentValues.put("countdown", Integer.valueOf(advertisement.countdown));
        contentValues.put("video_width", Integer.valueOf(advertisement.videoWidth));
        contentValues.put("video_height", Integer.valueOf(advertisement.videoHeight));
        contentValues.put("cta_overlay_enabled", Boolean.valueOf(advertisement.ctaOverlayEnabled));
        contentValues.put("cta_click_area", Boolean.valueOf(advertisement.ctaClickArea));
        contentValues.put("retry_count", Integer.valueOf(advertisement.retryCount));
        contentValues.put("requires_non_market_install", Boolean.valueOf(advertisement.requiresNonMarketInstall));
        contentValues.put("app_id", advertisement.appID);
        contentValues.put("campaign", advertisement.campaign);
        contentValues.put("video_url", advertisement.videoUrl);
        contentValues.put("md5", advertisement.md5);
        contentValues.put("postroll_bundle_url", advertisement.postrollBundleUrl);
        contentValues.put("cta_destination_url", advertisement.ctaDestinationUrl);
        contentValues.put("cta_url", advertisement.ctaUrl);
        contentValues.put("ad_token", advertisement.adToken);
        contentValues.put("video_identifier", advertisement.videoIdentifier);
        contentValues.put("template_url", advertisement.templateUrl);
        contentValues.put("TEMPLATE_ID", advertisement.templateId);
        contentValues.put("TEMPLATE_TYPE", advertisement.templateType);
        contentValues.put("ad_market_id", advertisement.adMarketId);
        contentValues.put("bid_token", advertisement.bidToken);
        contentValues.put("state", Integer.valueOf(advertisement.state));
        contentValues.put("placement_id", advertisement.placementId);
        contentValues.put("ad_config", this.gson.toJson((Object) advertisement.adConfig));
        contentValues.put("mute_urls", this.gson.toJson((Object) advertisement.muteUrls, this.stringArrayType));
        contentValues.put("unmute_urls", this.gson.toJson((Object) advertisement.unmuteUrls, this.stringArrayType));
        contentValues.put("close_urls", this.gson.toJson((Object) advertisement.closeUrls, this.stringArrayType));
        contentValues.put("postroll_click_urls", this.gson.toJson((Object) advertisement.postRollClickUrls, this.stringArrayType));
        contentValues.put("postroll_view_urls", this.gson.toJson((Object) advertisement.postRollViewUrls, this.stringArrayType));
        contentValues.put("click_urls", this.gson.toJson((Object) advertisement.clickUrls, this.stringArrayType));
        contentValues.put("video_click_urls", this.gson.toJson((Object) advertisement.videoClickUrls, this.stringArrayType));
        contentValues.put("checkpoints", this.gson.toJson((Object) advertisement.checkpoints, this.checkpointListType));
        contentValues.put("template_settings", this.gson.toJson((Object) advertisement.templateSettings, this.stringMapType));
        contentValues.put("mraid_files", this.gson.toJson((Object) advertisement.mraidFiles, this.stringMapType));
        contentValues.put("cacheable_assets", this.gson.toJson((Object) advertisement.cacheableAssets, this.cacheableMapType));
        contentValues.put("tt_download", Long.valueOf(advertisement.ttDownload));
        contentValues.put("asset_download_timestamp", Long.valueOf(advertisement.assetDownloadStartTime));
        contentValues.put("asset_download_duration", Long.valueOf(advertisement.assetDownloadDuration));
        contentValues.put("ad_request_start_time", Long.valueOf(advertisement.adRequestStartTime));
        contentValues.put("column_enable_om_sdk", Boolean.valueOf(advertisement.enableOm));
        contentValues.put("column_om_sdk_extra_vast", advertisement.omExtraVast);
        return contentValues;
    }

    public Advertisement fromContentValues(ContentValues contentValues) {
        Advertisement advertisement = new Advertisement();
        advertisement.identifier = contentValues.getAsString("item_id");
        advertisement.adType = contentValues.getAsInteger("ad_type").intValue();
        advertisement.expireTime = contentValues.getAsLong("expire_time").longValue();
        advertisement.delay = contentValues.getAsInteger("delay").intValue();
        advertisement.showCloseDelay = contentValues.getAsInteger("show_close_delay").intValue();
        advertisement.showCloseIncentivized = contentValues.getAsInteger("show_close_incentivized").intValue();
        advertisement.countdown = contentValues.getAsInteger("countdown").intValue();
        advertisement.videoWidth = contentValues.getAsInteger("video_width").intValue();
        advertisement.videoHeight = contentValues.getAsInteger("video_height").intValue();
        advertisement.retryCount = contentValues.getAsInteger("retry_count").intValue();
        advertisement.requiresNonMarketInstall = ContentValuesUtil.getBoolean(contentValues, "requires_non_market_install");
        advertisement.appID = contentValues.getAsString("app_id");
        advertisement.campaign = contentValues.getAsString("campaign");
        advertisement.videoUrl = contentValues.getAsString("video_url");
        advertisement.md5 = contentValues.getAsString("md5");
        advertisement.postrollBundleUrl = contentValues.getAsString("postroll_bundle_url");
        advertisement.ctaDestinationUrl = contentValues.getAsString("cta_destination_url");
        advertisement.ctaUrl = contentValues.getAsString("cta_url");
        advertisement.adToken = contentValues.getAsString("ad_token");
        advertisement.videoIdentifier = contentValues.getAsString("video_identifier");
        advertisement.templateUrl = contentValues.getAsString("template_url");
        advertisement.templateId = contentValues.getAsString("TEMPLATE_ID");
        advertisement.templateType = contentValues.getAsString("TEMPLATE_TYPE");
        advertisement.adMarketId = contentValues.getAsString("ad_market_id");
        advertisement.bidToken = contentValues.getAsString("bid_token");
        advertisement.state = contentValues.getAsInteger("state").intValue();
        advertisement.placementId = contentValues.getAsString("placement_id");
        advertisement.ctaOverlayEnabled = ContentValuesUtil.getBoolean(contentValues, "cta_overlay_enabled");
        advertisement.ctaClickArea = ContentValuesUtil.getBoolean(contentValues, "cta_click_area");
        advertisement.adConfig = (AdConfig) this.gson.fromJson(contentValues.getAsString("ad_config"), AdConfig.class);
        advertisement.muteUrls = (String[]) this.gson.fromJson(contentValues.getAsString("mute_urls"), this.stringArrayType);
        advertisement.unmuteUrls = (String[]) this.gson.fromJson(contentValues.getAsString("unmute_urls"), this.stringArrayType);
        advertisement.closeUrls = (String[]) this.gson.fromJson(contentValues.getAsString("close_urls"), this.stringArrayType);
        advertisement.postRollClickUrls = (String[]) this.gson.fromJson(contentValues.getAsString("postroll_click_urls"), this.stringArrayType);
        advertisement.postRollViewUrls = (String[]) this.gson.fromJson(contentValues.getAsString("postroll_view_urls"), this.stringArrayType);
        advertisement.clickUrls = (String[]) this.gson.fromJson(contentValues.getAsString("click_urls"), this.stringArrayType);
        advertisement.videoClickUrls = (String[]) this.gson.fromJson(contentValues.getAsString("video_click_urls"), this.stringArrayType);
        advertisement.checkpoints = (List) this.gson.fromJson(contentValues.getAsString("checkpoints"), this.checkpointListType);
        advertisement.templateSettings = (Map) this.gson.fromJson(contentValues.getAsString("template_settings"), this.stringMapType);
        advertisement.mraidFiles = (Map) this.gson.fromJson(contentValues.getAsString("mraid_files"), this.stringMapType);
        advertisement.cacheableAssets = (Map) this.gson.fromJson(contentValues.getAsString("cacheable_assets"), this.cacheableMapType);
        advertisement.ttDownload = contentValues.getAsLong("tt_download").longValue();
        advertisement.assetDownloadStartTime = contentValues.getAsLong("asset_download_timestamp").longValue();
        advertisement.assetDownloadDuration = contentValues.getAsLong("asset_download_duration").longValue();
        advertisement.adRequestStartTime = contentValues.getAsLong("ad_request_start_time").longValue();
        advertisement.enableOm = ContentValuesUtil.getBoolean(contentValues, "column_enable_om_sdk");
        advertisement.omExtraVast = contentValues.getAsString("column_om_sdk_extra_vast");
        return advertisement;
    }
}
