package com.vungle.warren;

import android.annotation.TargetApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.VisionData;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.NetworkProvider;
import com.vungle.warren.vision.VisionAggregationData;
import com.vungle.warren.vision.VisionAggregationInfo;
import com.vungle.warren.vision.VisionConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

class VisionController {
    private VisionConfig config = new VisionConfig();
    private final NetworkProvider networkProvider;
    private final Repository repository;

    VisionController(Repository repository2, NetworkProvider networkProvider2) {
        this.repository = repository2;
        this.networkProvider = networkProvider2;
    }

    private String getDataScienceCache() {
        Cookie cookie = this.repository.load("visionCookie", Cookie.class).get();
        if (cookie == null) {
            return null;
        }
        return cookie.getString("data_science_cache");
    }

    /* access modifiers changed from: package-private */
    public void setDataScienceCache(String str) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie("visionCookie");
        if (str != null) {
            cookie.putValue("data_science_cache", str);
        }
        this.repository.save(cookie);
    }

    /* access modifiers changed from: package-private */
    public void setConfig(VisionConfig visionConfig) throws DatabaseHelper.DBException {
        this.config = visionConfig;
        if (visionConfig.enabled) {
            Repository repository2 = this.repository;
            VisionConfig.Limits limits = visionConfig.viewLimit;
            repository2.trimVisionData(limits != null ? limits.device : 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void reportData(String str, String str2, String str3) throws DatabaseHelper.DBException {
        this.repository.save(new VisionData(System.currentTimeMillis(), str, str2, str3));
        Repository repository2 = this.repository;
        VisionConfig.Limits limits = this.config.viewLimit;
        repository2.trimVisionData(limits != null ? limits.device : 0);
    }

    @TargetApi(21)
    public JsonObject getPayload() {
        int i;
        int i2;
        VisionController visionController = this;
        JsonObject jsonObject = new JsonObject();
        String dataScienceCache = getDataScienceCache();
        if (dataScienceCache != null) {
            jsonObject.addProperty("data_science_cache", dataScienceCache);
        }
        if (visionController.config.viewLimit != null) {
            int currentNetworkType = visionController.networkProvider.getCurrentNetworkType();
            if (currentNetworkType != 0) {
                if (currentNetworkType != 1) {
                    if (currentNetworkType != 4) {
                        if (currentNetworkType != 9) {
                            if (currentNetworkType != 17) {
                                if (currentNetworkType != 6) {
                                    if (currentNetworkType != 7) {
                                        i = visionController.config.viewLimit.device;
                                    }
                                }
                            }
                        }
                    }
                }
                VisionConfig.Limits limits = visionController.config.viewLimit;
                i2 = limits.wifi;
                if (i2 <= 0) {
                    i = limits.device;
                }
                i = i2;
            }
            VisionConfig.Limits limits2 = visionController.config.viewLimit;
            i2 = limits2.mobile;
            if (i2 <= 0) {
                i = limits2.device;
            }
            i = i2;
        } else {
            i = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JsonArray jsonArray = new JsonArray();
        jsonObject.add("aggregate", jsonArray);
        int[] iArr = visionController.config.aggregationTimeWindows;
        if (iArr != null) {
            int length = iArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr[i3];
                long millis = currentTimeMillis - TimeUnit.DAYS.toMillis((long) i4);
                VisionAggregationInfo visionAggregationInfo = visionController.repository.getVisionAggregationInfo(millis).get();
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("window", (Number) Integer.valueOf(i4));
                jsonObject2.addProperty("last_viewed_creative_id", visionAggregationInfo != null ? visionAggregationInfo.lastCreative : null);
                jsonObject2.addProperty("total_view_count", (Number) Integer.valueOf(visionAggregationInfo != null ? visionAggregationInfo.totalCount : 0));
                String[] strArr = visionController.config.aggregationFilters;
                if (strArr != null) {
                    int length2 = strArr.length;
                    int i5 = 0;
                    while (i5 < length2) {
                        String str = strArr[i5];
                        long j = currentTimeMillis;
                        JsonArray jsonArray2 = new JsonArray();
                        jsonObject2.add(str, jsonArray2);
                        String filterName = visionController.getFilterName(str);
                        List list = visionController.repository.getVisionAggregationData(millis, i, filterName).get();
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                VisionAggregationData visionAggregationData = (VisionAggregationData) it.next();
                                int i6 = i;
                                JsonObject jsonObject3 = new JsonObject();
                                Iterator it2 = it;
                                jsonObject3.addProperty(filterName + "_id", visionAggregationData.f5624id);
                                jsonObject3.addProperty("view_count", (Number) Integer.valueOf(visionAggregationData.viewCount));
                                jsonObject3.addProperty("last_time_viewed", (Number) Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(visionAggregationData.lastTimeStamp)));
                                jsonArray2.add((JsonElement) jsonObject3);
                                iArr = iArr;
                                i = i6;
                                it = it2;
                                filterName = filterName;
                                length = length;
                            }
                        }
                        i5++;
                        visionController = this;
                        iArr = iArr;
                        currentTimeMillis = j;
                        i = i;
                        length = length;
                    }
                }
                jsonArray.add((JsonElement) jsonObject2);
                i3++;
                visionController = this;
                iArr = iArr;
                currentTimeMillis = currentTimeMillis;
                i = i;
                length = length;
            }
        }
        return jsonObject;
    }

    /* access modifiers changed from: package-private */
    public String getFilterName(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1329100269:
                if (str.equals("campaign_details")) {
                    c = 0;
                    break;
                }
                break;
            case 1272113586:
                if (str.equals("creative_details")) {
                    c = 1;
                    break;
                }
                break;
            case 1845893934:
                if (str.equals("advertiser_details")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "campaign";
            case 1:
                return "creative";
            case 2:
                return "advertiser";
            default:
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isEnabled() {
        return this.config.enabled;
    }
}
