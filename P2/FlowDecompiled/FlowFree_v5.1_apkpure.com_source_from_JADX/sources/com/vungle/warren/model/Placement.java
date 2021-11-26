package com.vungle.warren.model;

import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vungle.warren.AdConfig;
import java.util.Iterator;

public class Placement {
    int adRefreshDuration;
    protected AdConfig.AdSize adSize;
    int autoCachePriority;
    boolean autoCached;
    boolean headerBidding;
    String identifier;
    boolean incentivized;
    boolean isValid;
    int placementAdType = 0;
    long wakeupTime;

    Placement() {
    }

    public Placement(JsonObject jsonObject) throws IllegalArgumentException {
        if (jsonObject.has("reference_id")) {
            this.identifier = jsonObject.get("reference_id").getAsString();
            this.autoCached = jsonObject.has("is_auto_cached") && jsonObject.get("is_auto_cached").getAsBoolean();
            if (!jsonObject.has("cache_priority") || !this.autoCached) {
                this.autoCachePriority = Integer.MAX_VALUE;
            } else {
                try {
                    int asInt = jsonObject.get("cache_priority").getAsInt();
                    this.autoCachePriority = asInt;
                    if (asInt < 1) {
                        this.autoCachePriority = Integer.MAX_VALUE;
                    }
                } catch (Exception unused) {
                    this.autoCachePriority = Integer.MAX_VALUE;
                }
            }
            this.incentivized = jsonObject.has("is_incentivized") && jsonObject.get("is_incentivized").getAsBoolean();
            this.adRefreshDuration = jsonObject.has("ad_refresh_duration") ? jsonObject.get("ad_refresh_duration").getAsInt() : 0;
            this.headerBidding = jsonObject.has("header_bidding") && jsonObject.get("header_bidding").getAsBoolean();
            if (JsonUtil.hasNonNull(jsonObject, "supported_template_types")) {
                Iterator<JsonElement> it = jsonObject.getAsJsonArray("supported_template_types").iterator();
                if (it.hasNext()) {
                    JsonElement next = it.next();
                    Log.d("PlacementModel", "SupportedTemplatesTypes : " + next.getAsString());
                    if (next.getAsString().equals("banner")) {
                        this.placementAdType = 1;
                    } else if (next.getAsString().equals("flexfeed") || next.getAsString().equals("flexview")) {
                        this.placementAdType = 2;
                    } else {
                        this.placementAdType = 0;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing placement reference ID, cannot use placement!");
        }
    }

    public void snooze(long j) {
        this.wakeupTime = System.currentTimeMillis() + (j * 1000);
    }

    public long getWakeupTime() {
        return this.wakeupTime;
    }

    public void setWakeupTime(long j) {
        this.wakeupTime = j;
    }

    public String getId() {
        return this.identifier;
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    public int getPlacementAdType() {
        return this.placementAdType;
    }

    public AdConfig.AdSize getAdSize() {
        AdConfig.AdSize adSize2 = this.adSize;
        return adSize2 == null ? AdConfig.AdSize.VUNGLE_DEFAULT : adSize2;
    }

    public void setAdSize(AdConfig.AdSize adSize2) {
        this.adSize = adSize2;
    }

    public int getAutoCachePriority() {
        return this.autoCachePriority;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Placement.class != obj.getClass()) {
            return false;
        }
        Placement placement = (Placement) obj;
        if (this.autoCached != placement.autoCached || this.incentivized != placement.incentivized || this.headerBidding != placement.headerBidding || this.wakeupTime != placement.wakeupTime || this.isValid != placement.isValid || this.adRefreshDuration != placement.adRefreshDuration || getAdSize() != placement.getAdSize()) {
            return false;
        }
        String str = this.identifier;
        String str2 = placement.identifier;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.identifier;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.wakeupTime;
        int i = this.adRefreshDuration;
        return (((((((((((hashCode * 31) + (this.autoCached ? 1 : 0)) * 31) + (this.incentivized ? 1 : 0)) * 31) + (this.headerBidding ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (i ^ (i >>> 32))) * 31) + getAdSize().hashCode();
    }

    public boolean isAutoCached() {
        if (AdConfig.AdSize.isBannerAdSize(this.adSize)) {
            return true;
        }
        return this.autoCached;
    }

    public boolean isIncentivized() {
        return this.incentivized;
    }

    public boolean isHeaderBidding() {
        return this.headerBidding;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String toString() {
        return "Placement{identifier='" + this.identifier + '\'' + ", autoCached=" + this.autoCached + ", incentivized=" + this.incentivized + ", headerBidding=" + this.headerBidding + ", wakeupTime=" + this.wakeupTime + ", refreshTime=" + this.adRefreshDuration + ", adSize=" + getAdSize().getName() + ", autoCachePriority=" + this.autoCachePriority + '}';
    }
}
