package com.vungle.warren.model;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.vungle.warren.AdConfig;
import com.vungle.warren.SessionData;
import java.util.ArrayList;
import java.util.List;

public class Report {
    long adDuration;
    String adSize;
    long adStartTime;
    String adToken;
    String adType;
    String appId;
    public long assetDownloadDuration;
    String campaign;
    final List<String> clickedThrough = new ArrayList();
    final List<String> errors = new ArrayList();
    boolean headerBidding;
    boolean incentivized;
    public long initTimeStamp;
    int ordinal;
    String placementId;
    int status = 0;
    String templateId;
    long ttDownload;
    String url;
    final List<UserAction> userActions = new ArrayList();
    String userID;
    long videoLength;
    int videoViewed;
    volatile boolean wasCTAClicked;

    Report() {
    }

    public Report(Advertisement advertisement, Placement placement, long j, String str, SessionData sessionData) {
        this.placementId = placement.getId();
        this.adToken = advertisement.getAdToken();
        advertisement.getId();
        this.appId = advertisement.getAppID();
        this.incentivized = placement.isIncentivized();
        this.headerBidding = placement.isHeaderBidding();
        this.adStartTime = j;
        this.url = advertisement.getUrl();
        this.ttDownload = -1;
        this.campaign = advertisement.getCampaign();
        this.initTimeStamp = sessionData != null ? sessionData.getInitTimeStamp() : 0;
        this.assetDownloadDuration = advertisement.getAssetDownloadDuration();
        int adType2 = advertisement.getAdType();
        if (adType2 == 0) {
            this.adType = "vungle_local";
        } else if (adType2 == 1) {
            this.adType = "vungle_mraid";
        } else {
            throw new IllegalArgumentException("Unknown ad type, cannot process!");
        }
        this.templateId = advertisement.getTemplateId();
        if (str == null) {
            this.userID = "";
        } else {
            this.userID = str;
        }
        this.ordinal = advertisement.getAdConfig().getOrdinal();
        AdConfig.AdSize adSize2 = advertisement.getAdConfig().getAdSize();
        if (AdConfig.AdSize.isBannerAdSize(adSize2)) {
            this.adSize = adSize2.getName();
        }
    }

    public synchronized void recordAction(String str, String str2, long j) {
        this.userActions.add(new UserAction(str, str2, j));
        this.clickedThrough.add(str);
        if (str.equals("download")) {
            this.wasCTAClicked = true;
        }
    }

    public synchronized void recordError(String str) {
        this.errors.add(str);
    }

    public void recordProgress(int i) {
        this.videoViewed = i;
    }

    public void setVideoLength(long j) {
        this.videoLength = j;
    }

    public void setAdDuration(long j) {
        this.adDuration = j;
    }

    public long getAdDuration() {
        return this.adDuration;
    }

    public void setTtDownload(long j) {
        this.ttDownload = j;
    }

    public boolean isCTAClicked() {
        return this.wasCTAClicked;
    }

    public String getUserID() {
        return this.userID;
    }

    public synchronized JsonObject toReportBody() {
        JsonObject jsonObject;
        jsonObject = new JsonObject();
        jsonObject.addProperty("placement_reference_id", this.placementId);
        jsonObject.addProperty("ad_token", this.adToken);
        jsonObject.addProperty("app_id", this.appId);
        jsonObject.addProperty("incentivized", (Number) Integer.valueOf(this.incentivized ? 1 : 0));
        jsonObject.addProperty("header_bidding", Boolean.valueOf(this.headerBidding));
        jsonObject.addProperty("adStartTime", (Number) Long.valueOf(this.adStartTime));
        if (!TextUtils.isEmpty(this.url)) {
            jsonObject.addProperty("url", this.url);
        }
        jsonObject.addProperty("adDuration", (Number) Long.valueOf(this.adDuration));
        jsonObject.addProperty("ttDownload", (Number) Long.valueOf(this.ttDownload));
        jsonObject.addProperty("campaign", this.campaign);
        jsonObject.addProperty("adType", this.adType);
        jsonObject.addProperty("templateId", this.templateId);
        jsonObject.addProperty("init_timestamp", (Number) Long.valueOf(this.initTimeStamp));
        jsonObject.addProperty("asset_download_duration", (Number) Long.valueOf(this.assetDownloadDuration));
        if (!TextUtils.isEmpty(this.adSize)) {
            jsonObject.addProperty("ad_size", this.adSize);
        }
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("startTime", (Number) Long.valueOf(this.adStartTime));
        int i = this.videoViewed;
        if (i > 0) {
            jsonObject2.addProperty("videoViewed", (Number) Integer.valueOf(i));
        }
        long j = this.videoLength;
        if (j > 0) {
            jsonObject2.addProperty("videoLength", (Number) Long.valueOf(j));
        }
        JsonArray jsonArray2 = new JsonArray();
        for (UserAction json : this.userActions) {
            jsonArray2.add((JsonElement) json.toJson());
        }
        jsonObject2.add("userActions", jsonArray2);
        jsonArray.add((JsonElement) jsonObject2);
        jsonObject.add("plays", jsonArray);
        JsonArray jsonArray3 = new JsonArray();
        for (String add : this.errors) {
            jsonArray3.add(add);
        }
        jsonObject.add("errors", jsonArray3);
        JsonArray jsonArray4 = new JsonArray();
        for (String add2 : this.clickedThrough) {
            jsonArray4.add(add2);
        }
        jsonObject.add("clickedThrough", jsonArray4);
        if (this.incentivized && !TextUtils.isEmpty(this.userID)) {
            jsonObject.addProperty("user", this.userID);
        }
        int i2 = this.ordinal;
        if (i2 > 0) {
            jsonObject.addProperty("ordinal_view", (Number) Integer.valueOf(i2));
        }
        return jsonObject;
    }

    public String getId() {
        return this.placementId + "_" + this.adStartTime;
    }

    public long getAdStartTime() {
        return this.adStartTime;
    }

    public static class UserAction {
        @SerializedName("action")
        private String action;
        @SerializedName("timestamp")
        private long timestamp;
        @SerializedName("value")
        private String value;

        public UserAction(String str, String str2, long j) {
            this.action = str;
            this.value = str2;
            this.timestamp = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UserAction userAction = (UserAction) obj;
            return userAction.action.equals(this.action) && userAction.value.equals(this.value) && userAction.timestamp == this.timestamp;
        }

        public int hashCode() {
            long j = this.timestamp;
            return (((this.action.hashCode() * 31) + this.value.hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public JsonObject toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("action", this.action);
            String str = this.value;
            if (str != null && !str.isEmpty()) {
                jsonObject.addProperty("value", this.value);
            }
            jsonObject.addProperty("timestamp_millis", (Number) Long.valueOf(this.timestamp));
            return jsonObject;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0167, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 1
            if (r7 != r8) goto L_0x0006
            monitor-exit(r7)
            return r0
        L_0x0006:
            r1 = 0
            if (r8 == 0) goto L_0x0166
            java.lang.Class r2 = r7.getClass()     // Catch:{ all -> 0x0163 }
            java.lang.Class r3 = r8.getClass()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x0015
            goto L_0x0166
        L_0x0015:
            com.vungle.warren.model.Report r8 = (com.vungle.warren.model.Report) r8     // Catch:{ all -> 0x0163 }
            java.lang.String r2 = r8.placementId     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.placementId     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x0023
            monitor-exit(r7)
            return r1
        L_0x0023:
            java.lang.String r2 = r8.adToken     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.adToken     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x002f
            monitor-exit(r7)
            return r1
        L_0x002f:
            java.lang.String r2 = r8.appId     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.appId     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x003b
            monitor-exit(r7)
            return r1
        L_0x003b:
            boolean r2 = r8.incentivized     // Catch:{ all -> 0x0163 }
            boolean r3 = r7.incentivized     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x0043
            monitor-exit(r7)
            return r1
        L_0x0043:
            boolean r2 = r8.headerBidding     // Catch:{ all -> 0x0163 }
            boolean r3 = r7.headerBidding     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x004b
            monitor-exit(r7)
            return r1
        L_0x004b:
            long r2 = r8.adStartTime     // Catch:{ all -> 0x0163 }
            long r4 = r7.adStartTime     // Catch:{ all -> 0x0163 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0055
            monitor-exit(r7)
            return r1
        L_0x0055:
            java.lang.String r2 = r8.url     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.url     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x0061
            monitor-exit(r7)
            return r1
        L_0x0061:
            long r2 = r8.videoLength     // Catch:{ all -> 0x0163 }
            long r4 = r7.videoLength     // Catch:{ all -> 0x0163 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x006b
            monitor-exit(r7)
            return r1
        L_0x006b:
            long r2 = r8.adDuration     // Catch:{ all -> 0x0163 }
            long r4 = r7.adDuration     // Catch:{ all -> 0x0163 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0075
            monitor-exit(r7)
            return r1
        L_0x0075:
            long r2 = r8.ttDownload     // Catch:{ all -> 0x0163 }
            long r4 = r7.ttDownload     // Catch:{ all -> 0x0163 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x007f
            monitor-exit(r7)
            return r1
        L_0x007f:
            java.lang.String r2 = r8.campaign     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.campaign     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x008b
            monitor-exit(r7)
            return r1
        L_0x008b:
            java.lang.String r2 = r8.adType     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.adType     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x0097
            monitor-exit(r7)
            return r1
        L_0x0097:
            java.lang.String r2 = r8.templateId     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.templateId     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x00a3
            monitor-exit(r7)
            return r1
        L_0x00a3:
            boolean r2 = r8.wasCTAClicked     // Catch:{ all -> 0x0163 }
            boolean r3 = r7.wasCTAClicked     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x00ab
            monitor-exit(r7)
            return r1
        L_0x00ab:
            java.lang.String r2 = r8.userID     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r7.userID     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x00b7
            monitor-exit(r7)
            return r1
        L_0x00b7:
            long r2 = r8.initTimeStamp     // Catch:{ all -> 0x0163 }
            long r4 = r7.initTimeStamp     // Catch:{ all -> 0x0163 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00c1
            monitor-exit(r7)
            return r1
        L_0x00c1:
            long r2 = r8.assetDownloadDuration     // Catch:{ all -> 0x0163 }
            long r4 = r7.assetDownloadDuration     // Catch:{ all -> 0x0163 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00cb
            monitor-exit(r7)
            return r1
        L_0x00cb:
            java.util.List<java.lang.String> r2 = r8.clickedThrough     // Catch:{ all -> 0x0163 }
            int r2 = r2.size()     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r3 = r7.clickedThrough     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x00db
            monitor-exit(r7)
            return r1
        L_0x00db:
            r2 = 0
        L_0x00dc:
            java.util.List<java.lang.String> r3 = r7.clickedThrough     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 >= r3) goto L_0x00fd
            java.util.List<java.lang.String> r3 = r8.clickedThrough     // Catch:{ all -> 0x0163 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r4 = r7.clickedThrough     // Catch:{ all -> 0x0163 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0163 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0163 }
            if (r3 != 0) goto L_0x00fa
            monitor-exit(r7)
            return r1
        L_0x00fa:
            int r2 = r2 + 1
            goto L_0x00dc
        L_0x00fd:
            java.util.List<java.lang.String> r2 = r8.errors     // Catch:{ all -> 0x0163 }
            int r2 = r2.size()     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r3 = r7.errors     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x010d
            monitor-exit(r7)
            return r1
        L_0x010d:
            r2 = 0
        L_0x010e:
            java.util.List<java.lang.String> r3 = r7.errors     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 >= r3) goto L_0x012f
            java.util.List<java.lang.String> r3 = r8.errors     // Catch:{ all -> 0x0163 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r4 = r7.errors     // Catch:{ all -> 0x0163 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0163 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0163 }
            if (r3 != 0) goto L_0x012c
            monitor-exit(r7)
            return r1
        L_0x012c:
            int r2 = r2 + 1
            goto L_0x010e
        L_0x012f:
            java.util.List<com.vungle.warren.model.Report$UserAction> r2 = r8.userActions     // Catch:{ all -> 0x0163 }
            int r2 = r2.size()     // Catch:{ all -> 0x0163 }
            java.util.List<com.vungle.warren.model.Report$UserAction> r3 = r7.userActions     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x013f
            monitor-exit(r7)
            return r1
        L_0x013f:
            r2 = 0
        L_0x0140:
            java.util.List<com.vungle.warren.model.Report$UserAction> r3 = r7.userActions     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 >= r3) goto L_0x0161
            java.util.List<com.vungle.warren.model.Report$UserAction> r3 = r8.userActions     // Catch:{ all -> 0x0163 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0163 }
            com.vungle.warren.model.Report$UserAction r3 = (com.vungle.warren.model.Report.UserAction) r3     // Catch:{ all -> 0x0163 }
            java.util.List<com.vungle.warren.model.Report$UserAction> r4 = r7.userActions     // Catch:{ all -> 0x0163 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0163 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0163 }
            if (r3 != 0) goto L_0x015e
            monitor-exit(r7)
            return r1
        L_0x015e:
            int r2 = r2 + 1
            goto L_0x0140
        L_0x0161:
            monitor-exit(r7)
            return r0
        L_0x0163:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0166:
            monitor-exit(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Report.equals(java.lang.Object):boolean");
    }

    public synchronized int hashCode() {
        int i;
        int hashCode;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        i = 1;
        hashCode = ((((((this.placementId.hashCode() * 31) + this.adToken.hashCode()) * 31) + this.appId.hashCode()) * 31) + (this.incentivized ? 1 : 0)) * 31;
        if (!this.headerBidding) {
            i = 0;
        }
        j = this.adStartTime;
        j2 = this.videoLength;
        j3 = this.adDuration;
        j4 = this.ttDownload;
        j5 = this.initTimeStamp;
        j6 = this.assetDownloadDuration;
        return ((((((((((((((((((((((((((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.url.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.campaign.hashCode()) * 31) + this.userActions.hashCode()) * 31) + this.clickedThrough.hashCode()) * 31) + this.errors.hashCode()) * 31) + this.adType.hashCode()) * 31) + this.templateId.hashCode()) * 31) + this.userID.hashCode()) * 31) + (this.wasCTAClicked ? 1 : 0);
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
