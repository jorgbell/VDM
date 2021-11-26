package com.mopub.network;

import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.ViewabilityVendor;
import com.mopub.common.util.DateAndTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdResponse implements Serializable {
    private final String mAdGroupId;
    private final Integer mAdTimeoutDelayMillis;
    private final String mAdType;
    private final String mAdUnitId;
    private final List<String> mAfterLoadFailUrls;
    private final List<String> mAfterLoadSuccessUrls;
    private final List<String> mAfterLoadUrls;
    private final boolean mAllowCustomClose;
    private final String mBannerImpressionMinVisibleDips;
    private final String mBannerImpressionMinVisibleMs;
    private final String mBaseAdClassName;
    private final List<String> mBeforeLoadUrls;
    private final MoPub.BrowserAgent mBrowserAgent;
    private final List<String> mClickTrackingUrls;
    private final String mDspCreativeId;
    private final String mFailoverUrl;
    private final String mFullAdType;
    private final Integer mHeight;
    private final ImpressionData mImpressionData;
    private final List<String> mImpressionTrackingUrls;
    private final JSONObject mJsonBody;
    private final String mNetworkType;
    private final Integer mRefreshTimeMillis;
    private final String mRequestId;
    private final String mResponseBody;
    private final String mRewardedAdCompletionUrl;
    private final String mRewardedAdCurrencyAmount;
    private final String mRewardedAdCurrencyName;
    private final String mRewardedCurrencies;
    private final Integer mRewardedDuration;
    private final Map<String, String> mServerExtras;
    private final long mTimestamp;
    private final Set<ViewabilityVendor> mViewabilityVendors;
    private final Integer mWidth;

    private AdResponse(Builder builder) {
        this.mAdType = builder.adType;
        this.mAdGroupId = builder.adGroupId;
        this.mAdUnitId = builder.adUnitId;
        this.mFullAdType = builder.fullAdType;
        this.mNetworkType = builder.networkType;
        this.mRewardedAdCurrencyName = builder.rewardedAdCurrencyName;
        this.mRewardedAdCurrencyAmount = builder.rewardedAdCurrencyAmount;
        this.mRewardedCurrencies = builder.rewardedCurrencies;
        this.mRewardedAdCompletionUrl = builder.rewardedAdCompletionUrl;
        this.mRewardedDuration = builder.rewardedDuration;
        this.mImpressionData = builder.impressionData;
        this.mClickTrackingUrls = builder.clickTrackingUrls;
        this.mImpressionTrackingUrls = builder.impressionTrackingUrls;
        this.mFailoverUrl = builder.failoverUrl;
        this.mBeforeLoadUrls = builder.beforeLoadUrls;
        this.mAfterLoadUrls = builder.afterLoadUrls;
        this.mAfterLoadSuccessUrls = builder.afterLoadSuccessUrls;
        this.mAfterLoadFailUrls = builder.afterLoadFailUrls;
        this.mRequestId = builder.requestId;
        this.mWidth = builder.width;
        this.mHeight = builder.height;
        this.mAdTimeoutDelayMillis = builder.adTimeoutDelayMillis;
        this.mRefreshTimeMillis = builder.refreshTimeMillis;
        this.mBannerImpressionMinVisibleDips = builder.bannerImpressionMinVisibleDips;
        this.mBannerImpressionMinVisibleMs = builder.bannerImpressionMinVisibleMs;
        this.mDspCreativeId = builder.dspCreativeId;
        this.mResponseBody = builder.responseBody;
        this.mJsonBody = builder.jsonBody;
        this.mBaseAdClassName = builder.customEventClassName;
        this.mBrowserAgent = builder.browserAgent;
        this.mServerExtras = builder.serverExtras;
        this.mTimestamp = DateAndTime.now().getTime();
        this.mAllowCustomClose = builder.allowCustomClose;
        this.mViewabilityVendors = builder.viewabilityVendors;
    }

    public boolean hasJson() {
        return this.mJsonBody != null;
    }

    public JSONObject getJsonBody() {
        return this.mJsonBody;
    }

    public String getStringBody() {
        return this.mResponseBody;
    }

    public String getAdType() {
        return this.mAdType;
    }

    public String getAdGroupId() {
        return this.mAdGroupId;
    }

    public String getFullAdType() {
        return this.mFullAdType;
    }

    public String getAdUnitId() {
        return this.mAdUnitId;
    }

    public String getNetworkType() {
        return this.mNetworkType;
    }

    public String getRewardedAdCurrencyName() {
        return this.mRewardedAdCurrencyName;
    }

    public String getRewardedAdCurrencyAmount() {
        return this.mRewardedAdCurrencyAmount;
    }

    public String getRewardedCurrencies() {
        return this.mRewardedCurrencies;
    }

    public String getRewardedAdCompletionUrl() {
        return this.mRewardedAdCompletionUrl;
    }

    public Integer getRewardedDuration() {
        return this.mRewardedDuration;
    }

    public ImpressionData getImpressionData() {
        return this.mImpressionData;
    }

    public List<String> getClickTrackingUrls() {
        return this.mClickTrackingUrls;
    }

    public List<String> getImpressionTrackingUrls() {
        return this.mImpressionTrackingUrls;
    }

    @Deprecated
    public String getFailoverUrl() {
        return this.mFailoverUrl;
    }

    public List<String> getBeforeLoadUrls() {
        return this.mBeforeLoadUrls;
    }

    public List<String> getAfterLoadUrls() {
        return this.mAfterLoadUrls;
    }

    public List<String> getAfterLoadSuccessUrls() {
        return this.mAfterLoadSuccessUrls;
    }

    public List<String> getAfterLoadFailUrls() {
        return this.mAfterLoadFailUrls;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public Integer getWidth() {
        return this.mWidth;
    }

    public Integer getHeight() {
        return this.mHeight;
    }

    public Integer getAdTimeoutMillis(int i) {
        Integer num = this.mAdTimeoutDelayMillis;
        if (num == null || num.intValue() < 1000) {
            return Integer.valueOf(i);
        }
        return this.mAdTimeoutDelayMillis;
    }

    public Integer getRefreshTimeMillis() {
        return this.mRefreshTimeMillis;
    }

    public String getImpressionMinVisibleDips() {
        return this.mBannerImpressionMinVisibleDips;
    }

    public String getImpressionMinVisibleMs() {
        return this.mBannerImpressionMinVisibleMs;
    }

    public String getDspCreativeId() {
        return this.mDspCreativeId;
    }

    @Deprecated
    public String getCustomEventClassName() {
        return getBaseAdClassName();
    }

    public String getBaseAdClassName() {
        return this.mBaseAdClassName;
    }

    public MoPub.BrowserAgent getBrowserAgent() {
        return this.mBrowserAgent;
    }

    public Map<String, String> getServerExtras() {
        return new TreeMap(this.mServerExtras);
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public boolean allowCustomClose() {
        return this.mAllowCustomClose;
    }

    public Set<ViewabilityVendor> getViewabilityVendors() {
        return this.mViewabilityVendors;
    }

    public Builder toBuilder() {
        return new Builder().setAdType(this.mAdType).setAdGroupId(this.mAdGroupId).setNetworkType(this.mNetworkType).setRewardedAdCurrencyName(this.mRewardedAdCurrencyName).setRewardedAdCurrencyAmount(this.mRewardedAdCurrencyAmount).setRewardedCurrencies(this.mRewardedCurrencies).setRewardedAdCompletionUrl(this.mRewardedAdCompletionUrl).setRewardedDuration(this.mRewardedDuration).setAllowCustomClose(this.mAllowCustomClose).setImpressionData(this.mImpressionData).setClickTrackingUrls(this.mClickTrackingUrls).setImpressionTrackingUrls(this.mImpressionTrackingUrls).setFailoverUrl(this.mFailoverUrl).setBeforeLoadUrls(this.mBeforeLoadUrls).setAfterLoadUrls(this.mAfterLoadUrls).setAfterLoadSuccessUrls(this.mAfterLoadSuccessUrls).setAfterLoadFailUrls(this.mAfterLoadFailUrls).setDimensions(this.mWidth, this.mHeight).setAdTimeoutDelayMilliseconds(this.mAdTimeoutDelayMillis).setRefreshTimeMilliseconds(this.mRefreshTimeMillis).setBannerImpressionMinVisibleDips(this.mBannerImpressionMinVisibleDips).setBannerImpressionMinVisibleMs(this.mBannerImpressionMinVisibleMs).setDspCreativeId(this.mDspCreativeId).setResponseBody(this.mResponseBody).setJsonBody(this.mJsonBody).setBaseAdClassName(this.mBaseAdClassName).setBrowserAgent(this.mBrowserAgent).setAllowCustomClose(this.mAllowCustomClose).setServerExtras(this.mServerExtras).setViewabilityVendors(this.mViewabilityVendors);
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String adGroupId;
        /* access modifiers changed from: private */
        public Integer adTimeoutDelayMillis;
        /* access modifiers changed from: private */
        public String adType;
        /* access modifiers changed from: private */
        public String adUnitId;
        /* access modifiers changed from: private */
        public List<String> afterLoadFailUrls = new ArrayList();
        /* access modifiers changed from: private */
        public List<String> afterLoadSuccessUrls = new ArrayList();
        /* access modifiers changed from: private */
        public List<String> afterLoadUrls = new ArrayList();
        /* access modifiers changed from: private */
        public boolean allowCustomClose = false;
        /* access modifiers changed from: private */
        public String bannerImpressionMinVisibleDips;
        /* access modifiers changed from: private */
        public String bannerImpressionMinVisibleMs;
        /* access modifiers changed from: private */
        public List<String> beforeLoadUrls = new ArrayList();
        /* access modifiers changed from: private */
        public MoPub.BrowserAgent browserAgent;
        /* access modifiers changed from: private */
        public List<String> clickTrackingUrls = new ArrayList();
        /* access modifiers changed from: private */
        public String customEventClassName;
        /* access modifiers changed from: private */
        public String dspCreativeId;
        /* access modifiers changed from: private */
        public String failoverUrl;
        /* access modifiers changed from: private */
        public String fullAdType;
        /* access modifiers changed from: private */
        public Integer height;
        /* access modifiers changed from: private */
        public ImpressionData impressionData;
        /* access modifiers changed from: private */
        public List<String> impressionTrackingUrls = new ArrayList();
        /* access modifiers changed from: private */
        public JSONObject jsonBody;
        /* access modifiers changed from: private */
        public String networkType;
        /* access modifiers changed from: private */
        public Integer refreshTimeMillis;
        /* access modifiers changed from: private */
        public String requestId;
        /* access modifiers changed from: private */
        public String responseBody;
        /* access modifiers changed from: private */
        public String rewardedAdCompletionUrl;
        /* access modifiers changed from: private */
        public String rewardedAdCurrencyAmount;
        /* access modifiers changed from: private */
        public String rewardedAdCurrencyName;
        /* access modifiers changed from: private */
        public String rewardedCurrencies;
        /* access modifiers changed from: private */
        public Integer rewardedDuration;
        /* access modifiers changed from: private */
        public Map<String, String> serverExtras = new TreeMap();
        /* access modifiers changed from: private */
        public Set<ViewabilityVendor> viewabilityVendors = null;
        /* access modifiers changed from: private */
        public Integer width;

        public Builder setAdType(String str) {
            this.adType = str;
            return this;
        }

        public Builder setAdGroupId(String str) {
            this.adGroupId = str;
            return this;
        }

        public Builder setAdUnitId(String str) {
            this.adUnitId = str;
            return this;
        }

        public Builder setFullAdType(String str) {
            this.fullAdType = str;
            return this;
        }

        public Builder setNetworkType(String str) {
            this.networkType = str;
            return this;
        }

        public Builder setRewardedAdCurrencyName(String str) {
            this.rewardedAdCurrencyName = str;
            return this;
        }

        public Builder setRewardedAdCurrencyAmount(String str) {
            this.rewardedAdCurrencyAmount = str;
            return this;
        }

        public Builder setRewardedCurrencies(String str) {
            this.rewardedCurrencies = str;
            return this;
        }

        public Builder setRewardedAdCompletionUrl(String str) {
            this.rewardedAdCompletionUrl = str;
            return this;
        }

        public Builder setRewardedDuration(Integer num) {
            this.rewardedDuration = num;
            return this;
        }

        public Builder setImpressionData(ImpressionData impressionData2) {
            this.impressionData = impressionData2;
            return this;
        }

        public Builder setClickTrackingUrls(List<String> list) {
            Preconditions.checkNotNull(list);
            this.clickTrackingUrls = list;
            return this;
        }

        public Builder setImpressionTrackingUrls(List<String> list) {
            Preconditions.checkNotNull(list);
            this.impressionTrackingUrls = list;
            return this;
        }

        public Builder setFailoverUrl(String str) {
            this.failoverUrl = str;
            return this;
        }

        public Builder setBeforeLoadUrls(List<String> list) {
            Preconditions.checkNotNull(list);
            this.beforeLoadUrls = list;
            return this;
        }

        public Builder setAfterLoadUrls(List<String> list) {
            Preconditions.checkNotNull(list);
            this.afterLoadUrls = list;
            return this;
        }

        public Builder setAfterLoadSuccessUrls(List<String> list) {
            Preconditions.checkNotNull(list);
            this.afterLoadSuccessUrls = list;
            return this;
        }

        public Builder setAfterLoadFailUrls(List<String> list) {
            Preconditions.checkNotNull(list);
            this.afterLoadFailUrls = list;
            return this;
        }

        public Builder setRequestId(String str) {
            this.requestId = str;
            return this;
        }

        public Builder setDimensions(Integer num, Integer num2) {
            this.width = num;
            this.height = num2;
            return this;
        }

        public Builder setAdTimeoutDelayMilliseconds(Integer num) {
            this.adTimeoutDelayMillis = num;
            return this;
        }

        public Builder setRefreshTimeMilliseconds(Integer num) {
            this.refreshTimeMillis = num;
            return this;
        }

        public Builder setBannerImpressionMinVisibleDips(String str) {
            this.bannerImpressionMinVisibleDips = str;
            return this;
        }

        public Builder setBannerImpressionMinVisibleMs(String str) {
            this.bannerImpressionMinVisibleMs = str;
            return this;
        }

        public Builder setDspCreativeId(String str) {
            this.dspCreativeId = str;
            return this;
        }

        public Builder setResponseBody(String str) {
            this.responseBody = str;
            return this;
        }

        public Builder setJsonBody(JSONObject jSONObject) {
            this.jsonBody = jSONObject;
            return this;
        }

        public Builder setBaseAdClassName(String str) {
            this.customEventClassName = str;
            return this;
        }

        public Builder setBrowserAgent(MoPub.BrowserAgent browserAgent2) {
            this.browserAgent = browserAgent2;
            return this;
        }

        public Builder setServerExtras(Map<String, String> map) {
            if (map == null) {
                this.serverExtras = new TreeMap();
            } else {
                this.serverExtras = new TreeMap(map);
            }
            return this;
        }

        public Builder setAllowCustomClose(boolean z) {
            this.allowCustomClose = z;
            return this;
        }

        public Builder setViewabilityVendors(Set<ViewabilityVendor> set) {
            this.viewabilityVendors = set;
            return this;
        }

        public AdResponse build() {
            return new AdResponse(this);
        }
    }
}
