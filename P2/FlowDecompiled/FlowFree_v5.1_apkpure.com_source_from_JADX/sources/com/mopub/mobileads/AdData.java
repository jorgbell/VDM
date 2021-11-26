package com.mopub.mobileads;

import android.os.Parcel;
import android.os.Parcelable;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.ViewabilityVendor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdData.kt */
public final class AdData implements Parcelable {
    public static final long COUNTDOWN_UPDATE_INTERVAL_MILLIS = 250;
    public static final Parcelable.Creator<AdData> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_DURATION_FOR_CLOSE_BUTTON_MILLIS = 30000;
    public static final int DEFAULT_DURATION_FOR_CLOSE_BUTTON_SECONDS = 30;
    public static final int DEFAULT_DURATION_FOR_REWARDED_IMAGE_CLOSE_BUTTON_MILLIS = 5000;
    public static final int DEFAULT_FULLSCREEN_TIMEOUT_DELAY = 30000;
    public static final int DEFAULT_INLINE_TIMEOUT_DELAY = 10000;
    public static final int DEFAULT_UNSPECIFIED_TIMEOUT_DELAY = 30000;
    public static final int MILLIS_IN_SECOND = 1000;
    private Integer adHeight;
    private String adPayload;
    private String adType;
    private String adUnit;
    private Integer adWidth;
    private boolean allowCustomClose;
    private long broadcastIdentifier;
    private int currencyAmount;
    private String currencyName;
    private String customerId;
    private String dspCreativeId;
    private Map<String, String> extras;
    private String fullAdType;
    private String impressionMinVisibleDips;
    private String impressionMinVisibleMs;
    private boolean isRewarded;
    private CreativeOrientation orientation;
    private int rewardedDurationSeconds;
    private int timeoutDelayMillis;
    private String vastVideoConfigString;
    private Set<? extends ViewabilityVendor> viewabilityVendors;

    public static class Creator implements Parcelable.Creator<AdData> {
        public final AdData createFromParcel(Parcel parcel) {
            LinkedHashSet linkedHashSet;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            CreativeOrientation creativeOrientation = parcel.readInt() != 0 ? (CreativeOrientation) Enum.valueOf(CreativeOrientation.class, parcel.readString()) : null;
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            while (readInt2 != 0) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
                readInt2--;
            }
            boolean z = parcel.readInt() != 0;
            int readInt3 = parcel.readInt();
            String readString6 = parcel.readString();
            int readInt4 = parcel.readInt();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                int readInt5 = parcel.readInt();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(readInt5);
                while (readInt5 != 0) {
                    linkedHashSet2.add((ViewabilityVendor) parcel.readSerializable());
                    readInt5--;
                }
                linkedHashSet = linkedHashSet2;
            } else {
                linkedHashSet = null;
            }
            return new AdData(readString, creativeOrientation, readLong, readInt, readString2, readString3, readString4, readString5, linkedHashMap, z, readInt3, readString6, readInt4, valueOf, valueOf2, readString7, readString8, readString9, readString10, z2, linkedHashSet);
        }

        public final AdData[] newArray(int i) {
            return new AdData[i];
        }
    }

    public static /* synthetic */ AdData copy$default(AdData adData, String str, CreativeOrientation creativeOrientation, long j, int i, String str2, String str3, String str4, String str5, Map map, boolean z, int i2, String str6, int i3, Integer num, Integer num2, String str7, String str8, String str9, String str10, boolean z2, Set set, int i4, Object obj) {
        AdData adData2 = adData;
        int i5 = i4;
        return adData.copy((i5 & 1) != 0 ? adData2.vastVideoConfigString : str, (i5 & 2) != 0 ? adData2.orientation : creativeOrientation, (i5 & 4) != 0 ? adData2.broadcastIdentifier : j, (i5 & 8) != 0 ? adData2.timeoutDelayMillis : i, (i5 & 16) != 0 ? adData2.impressionMinVisibleDips : str2, (i5 & 32) != 0 ? adData2.impressionMinVisibleMs : str3, (i5 & 64) != 0 ? adData2.dspCreativeId : str4, (i5 & 128) != 0 ? adData2.adPayload : str5, (i5 & 256) != 0 ? adData2.extras : map, (i5 & 512) != 0 ? adData2.isRewarded : z, (i5 & 1024) != 0 ? adData2.rewardedDurationSeconds : i2, (i5 & 2048) != 0 ? adData2.currencyName : str6, (i5 & 4096) != 0 ? adData2.currencyAmount : i3, (i5 & 8192) != 0 ? adData2.adWidth : num, (i5 & 16384) != 0 ? adData2.adHeight : num2, (i5 & 32768) != 0 ? adData2.adUnit : str7, (i5 & 65536) != 0 ? adData2.adType : str8, (i5 & 131072) != 0 ? adData2.fullAdType : str9, (i5 & 262144) != 0 ? adData2.customerId : str10, (i5 & 524288) != 0 ? adData2.allowCustomClose : z2, (i5 & 1048576) != 0 ? adData2.viewabilityVendors : set);
    }

    public final String component1() {
        return this.vastVideoConfigString;
    }

    public final boolean component10() {
        return this.isRewarded;
    }

    public final int component11() {
        return this.rewardedDurationSeconds;
    }

    public final String component12() {
        return this.currencyName;
    }

    public final int component13() {
        return this.currencyAmount;
    }

    public final Integer component14() {
        return this.adWidth;
    }

    public final Integer component15() {
        return this.adHeight;
    }

    public final String component16() {
        return this.adUnit;
    }

    public final String component17() {
        return this.adType;
    }

    public final String component18() {
        return this.fullAdType;
    }

    public final String component19() {
        return this.customerId;
    }

    public final CreativeOrientation component2() {
        return this.orientation;
    }

    public final boolean component20() {
        return this.allowCustomClose;
    }

    public final Set<ViewabilityVendor> component21() {
        return this.viewabilityVendors;
    }

    public final long component3() {
        return this.broadcastIdentifier;
    }

    public final int component4() {
        return this.timeoutDelayMillis;
    }

    public final String component5() {
        return this.impressionMinVisibleDips;
    }

    public final String component6() {
        return this.impressionMinVisibleMs;
    }

    public final String component7() {
        return this.dspCreativeId;
    }

    public final String component8() {
        return this.adPayload;
    }

    public final Map<String, String> component9() {
        return this.extras;
    }

    public final AdData copy(String str, CreativeOrientation creativeOrientation, long j, int i, String str2, String str3, String str4, String str5, Map<String, String> map, boolean z, int i2, String str6, int i3, Integer num, Integer num2, String str7, String str8, String str9, String str10, boolean z2, Set<? extends ViewabilityVendor> set) {
        String str11 = str;
        Intrinsics.checkNotNullParameter(str5, "adPayload");
        Intrinsics.checkNotNullParameter(map, "extras");
        return new AdData(str, creativeOrientation, j, i, str2, str3, str4, str5, map, z, i2, str6, i3, num, num2, str7, str8, str9, str10, z2, set);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        return Intrinsics.areEqual(this.vastVideoConfigString, adData.vastVideoConfigString) && Intrinsics.areEqual(this.orientation, adData.orientation) && this.broadcastIdentifier == adData.broadcastIdentifier && this.timeoutDelayMillis == adData.timeoutDelayMillis && Intrinsics.areEqual(this.impressionMinVisibleDips, adData.impressionMinVisibleDips) && Intrinsics.areEqual(this.impressionMinVisibleMs, adData.impressionMinVisibleMs) && Intrinsics.areEqual(this.dspCreativeId, adData.dspCreativeId) && Intrinsics.areEqual(this.adPayload, adData.adPayload) && Intrinsics.areEqual(this.extras, adData.extras) && this.isRewarded == adData.isRewarded && this.rewardedDurationSeconds == adData.rewardedDurationSeconds && Intrinsics.areEqual(this.currencyName, adData.currencyName) && this.currencyAmount == adData.currencyAmount && Intrinsics.areEqual(this.adWidth, adData.adWidth) && Intrinsics.areEqual(this.adHeight, adData.adHeight) && Intrinsics.areEqual(this.adUnit, adData.adUnit) && Intrinsics.areEqual(this.adType, adData.adType) && Intrinsics.areEqual(this.fullAdType, adData.fullAdType) && Intrinsics.areEqual(this.customerId, adData.customerId) && this.allowCustomClose == adData.allowCustomClose && Intrinsics.areEqual(this.viewabilityVendors, adData.viewabilityVendors);
    }

    public int hashCode() {
        String str = this.vastVideoConfigString;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CreativeOrientation creativeOrientation = this.orientation;
        int hashCode2 = (((((hashCode + (creativeOrientation != null ? creativeOrientation.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.broadcastIdentifier)) * 31) + this.timeoutDelayMillis) * 31;
        String str2 = this.impressionMinVisibleDips;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.impressionMinVisibleMs;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.dspCreativeId;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.adPayload;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Map<String, String> map = this.extras;
        int hashCode7 = (hashCode6 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z = this.isRewarded;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (((hashCode7 + (z ? 1 : 0)) * 31) + this.rewardedDurationSeconds) * 31;
        String str6 = this.currencyName;
        int hashCode8 = (((i2 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.currencyAmount) * 31;
        Integer num = this.adWidth;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.adHeight;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str7 = this.adUnit;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.adType;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.fullAdType;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.customerId;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        boolean z3 = this.allowCustomClose;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (hashCode14 + (z2 ? 1 : 0)) * 31;
        Set<? extends ViewabilityVendor> set = this.viewabilityVendors;
        if (set != null) {
            i = set.hashCode();
        }
        return i3 + i;
    }

    public String toString() {
        return "AdData(vastVideoConfigString=" + this.vastVideoConfigString + ", orientation=" + this.orientation + ", broadcastIdentifier=" + this.broadcastIdentifier + ", timeoutDelayMillis=" + this.timeoutDelayMillis + ", impressionMinVisibleDips=" + this.impressionMinVisibleDips + ", impressionMinVisibleMs=" + this.impressionMinVisibleMs + ", dspCreativeId=" + this.dspCreativeId + ", adPayload=" + this.adPayload + ", extras=" + this.extras + ", isRewarded=" + this.isRewarded + ", rewardedDurationSeconds=" + this.rewardedDurationSeconds + ", currencyName=" + this.currencyName + ", currencyAmount=" + this.currencyAmount + ", adWidth=" + this.adWidth + ", adHeight=" + this.adHeight + ", adUnit=" + this.adUnit + ", adType=" + this.adType + ", fullAdType=" + this.fullAdType + ", customerId=" + this.customerId + ", allowCustomClose=" + this.allowCustomClose + ", viewabilityVendors=" + this.viewabilityVendors + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.vastVideoConfigString);
        CreativeOrientation creativeOrientation = this.orientation;
        if (creativeOrientation != null) {
            parcel.writeInt(1);
            parcel.writeString(creativeOrientation.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeLong(this.broadcastIdentifier);
        parcel.writeInt(this.timeoutDelayMillis);
        parcel.writeString(this.impressionMinVisibleDips);
        parcel.writeString(this.impressionMinVisibleMs);
        parcel.writeString(this.dspCreativeId);
        parcel.writeString(this.adPayload);
        Map<String, String> map = this.extras;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> next : map.entrySet()) {
            parcel.writeString(next.getKey());
            parcel.writeString(next.getValue());
        }
        parcel.writeInt(this.isRewarded ? 1 : 0);
        parcel.writeInt(this.rewardedDurationSeconds);
        parcel.writeString(this.currencyName);
        parcel.writeInt(this.currencyAmount);
        Integer num = this.adWidth;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.adHeight;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.adUnit);
        parcel.writeString(this.adType);
        parcel.writeString(this.fullAdType);
        parcel.writeString(this.customerId);
        parcel.writeInt(this.allowCustomClose ? 1 : 0);
        Set<? extends ViewabilityVendor> set = this.viewabilityVendors;
        if (set != null) {
            parcel.writeInt(1);
            parcel.writeInt(set.size());
            for (ViewabilityVendor writeSerializable : set) {
                parcel.writeSerializable(writeSerializable);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public /* synthetic */ AdData(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public AdData(String str, CreativeOrientation creativeOrientation, long j, int i, String str2, String str3, String str4, String str5, Map<String, String> map, boolean z, int i2, String str6, int i3, Integer num, Integer num2, String str7, String str8, String str9, String str10, boolean z2, Set<? extends ViewabilityVendor> set) {
        Intrinsics.checkNotNullParameter(str5, "adPayload");
        Intrinsics.checkNotNullParameter(map, "extras");
        this.vastVideoConfigString = str;
        this.orientation = creativeOrientation;
        this.broadcastIdentifier = j;
        this.timeoutDelayMillis = i;
        this.impressionMinVisibleDips = str2;
        this.impressionMinVisibleMs = str3;
        this.dspCreativeId = str4;
        this.adPayload = str5;
        this.extras = map;
        this.isRewarded = z;
        this.rewardedDurationSeconds = i2;
        this.currencyName = str6;
        this.currencyAmount = i3;
        this.adWidth = num;
        this.adHeight = num2;
        this.adUnit = str7;
        this.adType = str8;
        this.fullAdType = str9;
        this.customerId = str10;
        this.allowCustomClose = z2;
        this.viewabilityVendors = set;
    }

    public final String getVastVideoConfigString() {
        return this.vastVideoConfigString;
    }

    public final void setVastVideoConfigString(String str) {
        this.vastVideoConfigString = str;
    }

    public final CreativeOrientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(CreativeOrientation creativeOrientation) {
        this.orientation = creativeOrientation;
    }

    public final long getBroadcastIdentifier() {
        return this.broadcastIdentifier;
    }

    public final void setBroadcastIdentifier(long j) {
        this.broadcastIdentifier = j;
    }

    public final int getTimeoutDelayMillis() {
        return this.timeoutDelayMillis;
    }

    public final void setTimeoutDelayMillis(int i) {
        this.timeoutDelayMillis = i;
    }

    public final String getImpressionMinVisibleDips() {
        return this.impressionMinVisibleDips;
    }

    public final void setImpressionMinVisibleDips(String str) {
        this.impressionMinVisibleDips = str;
    }

    public final String getImpressionMinVisibleMs() {
        return this.impressionMinVisibleMs;
    }

    public final void setImpressionMinVisibleMs(String str) {
        this.impressionMinVisibleMs = str;
    }

    public final String getDspCreativeId() {
        return this.dspCreativeId;
    }

    public final void setDspCreativeId(String str) {
        this.dspCreativeId = str;
    }

    public final String getAdPayload() {
        return this.adPayload;
    }

    public final void setAdPayload(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adPayload = str;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final void setExtras(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extras = map;
    }

    public final boolean isRewarded() {
        return this.isRewarded;
    }

    public final void setRewarded(boolean z) {
        this.isRewarded = z;
    }

    public final int getRewardedDurationSeconds() {
        return this.rewardedDurationSeconds;
    }

    public final void setRewardedDurationSeconds(int i) {
        this.rewardedDurationSeconds = i;
    }

    public final String getCurrencyName() {
        return this.currencyName;
    }

    public final void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public final int getCurrencyAmount() {
        return this.currencyAmount;
    }

    public final void setCurrencyAmount(int i) {
        this.currencyAmount = i;
    }

    public final Integer getAdWidth() {
        return this.adWidth;
    }

    public final void setAdWidth(Integer num) {
        this.adWidth = num;
    }

    public final Integer getAdHeight() {
        return this.adHeight;
    }

    public final void setAdHeight(Integer num) {
        this.adHeight = num;
    }

    public final String getAdUnit() {
        return this.adUnit;
    }

    public final void setAdUnit(String str) {
        this.adUnit = str;
    }

    public final String getAdType() {
        return this.adType;
    }

    public final void setAdType(String str) {
        this.adType = str;
    }

    public final String getFullAdType() {
        return this.fullAdType;
    }

    public final void setFullAdType(String str) {
        this.fullAdType = str;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public final boolean getAllowCustomClose() {
        return this.allowCustomClose;
    }

    public final void setAllowCustomClose(boolean z) {
        this.allowCustomClose = z;
    }

    public final Set<ViewabilityVendor> getViewabilityVendors() {
        return this.viewabilityVendors;
    }

    public final void setViewabilityVendors(Set<? extends ViewabilityVendor> set) {
        this.viewabilityVendors = set;
    }

    /* compiled from: AdData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private AdData(Builder builder) {
        this(builder.getVastVideoConfigString(), builder.getOrientation(), builder.getBroadcastIdentifier(), builder.getTimeoutDelayMillis(), builder.getImpressionMinVisibleDips(), builder.getImpressionMinVisibleMs(), builder.getDspCreativeId(), builder.getAdPayload(), builder.getExtras(), builder.isRewarded(), builder.getRewardedDurationSeconds(), builder.getCurrencyName(), builder.getCurrencyAmount(), builder.getAdWidth(), builder.getAdHeight(), builder.getAdUnit(), builder.getAdType(), builder.getFullAdType(), builder.getCustomerId(), builder.getAllowCustomClose(), builder.getViewabilityVendors());
    }

    /* compiled from: AdData.kt */
    public static final class Builder {
        private Integer adHeight;
        private String adPayload = "";
        private String adType;
        private String adUnit;
        private Integer adWidth;
        private boolean allowCustomClose;
        private long broadcastIdentifier;
        private int currencyAmount;
        private String currencyName;
        private String customerId;
        private String dspCreativeId = "";
        private Map<String, String> extras = new HashMap();
        private String fullAdType;
        private String impressionMinVisibleDips;
        private String impressionMinVisibleMs;
        private boolean isRewarded;
        private CreativeOrientation orientation;
        private int rewardedDurationSeconds = 30;
        private int timeoutDelayMillis = 30000;
        private String vastVideoConfigString;
        private Set<? extends ViewabilityVendor> viewabilityVendors;

        public final String getVastVideoConfigString() {
            return this.vastVideoConfigString;
        }

        public final CreativeOrientation getOrientation() {
            return this.orientation;
        }

        public final long getBroadcastIdentifier() {
            return this.broadcastIdentifier;
        }

        public final int getTimeoutDelayMillis() {
            return this.timeoutDelayMillis;
        }

        public final String getImpressionMinVisibleDips() {
            return this.impressionMinVisibleDips;
        }

        public final String getImpressionMinVisibleMs() {
            return this.impressionMinVisibleMs;
        }

        public final String getDspCreativeId() {
            return this.dspCreativeId;
        }

        public final String getAdPayload() {
            return this.adPayload;
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        public final boolean isRewarded() {
            return this.isRewarded;
        }

        public final int getRewardedDurationSeconds() {
            return this.rewardedDurationSeconds;
        }

        public final String getCurrencyName() {
            return this.currencyName;
        }

        public final int getCurrencyAmount() {
            return this.currencyAmount;
        }

        public final Integer getAdWidth() {
            return this.adWidth;
        }

        public final Integer getAdHeight() {
            return this.adHeight;
        }

        public final String getAdUnit() {
            return this.adUnit;
        }

        public final String getAdType() {
            return this.adType;
        }

        public final String getFullAdType() {
            return this.fullAdType;
        }

        public final String getCustomerId() {
            return this.customerId;
        }

        public final boolean getAllowCustomClose() {
            return this.allowCustomClose;
        }

        public final Set<ViewabilityVendor> getViewabilityVendors() {
            return this.viewabilityVendors;
        }

        public final Builder vastVideoConfig(String str) {
            this.vastVideoConfigString = str;
            return this;
        }

        public final Builder orientation(CreativeOrientation creativeOrientation) {
            this.orientation = creativeOrientation;
            return this;
        }

        public final Builder broadcastIdentifier(long j) {
            this.broadcastIdentifier = j;
            return this;
        }

        public final Builder timeoutDelayMillis(int i) {
            this.timeoutDelayMillis = i;
            return this;
        }

        public final Builder impressionMinVisibleDips(String str) {
            this.impressionMinVisibleDips = str;
            return this;
        }

        public final Builder impressionMinVisibleMs(String str) {
            this.impressionMinVisibleMs = str;
            return this;
        }

        public final Builder dspCreativeId(String str) {
            this.dspCreativeId = str;
            return this;
        }

        public final Builder adPayload(String str) {
            Intrinsics.checkNotNullParameter(str, "adPayload");
            this.adPayload = str;
            return this;
        }

        public final Builder extras(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "extras");
            this.extras = new TreeMap(map);
            return this;
        }

        public final Builder isRewarded(boolean z) {
            this.isRewarded = z;
            return this;
        }

        public final Builder rewardedDurationSeconds(int i) {
            this.rewardedDurationSeconds = i;
            return this;
        }

        public final Builder currencyName(String str) {
            this.currencyName = str;
            return this;
        }

        public final Builder currencyAmount(int i) {
            this.currencyAmount = i;
            return this;
        }

        public final Builder adWidth(Integer num) {
            this.adWidth = num;
            return this;
        }

        public final Builder adHeight(Integer num) {
            this.adHeight = num;
            return this;
        }

        public final Builder adUnit(String str) {
            this.adUnit = str;
            return this;
        }

        public final Builder adType(String str) {
            this.adType = str;
            return this;
        }

        public final Builder fullAdType(String str) {
            this.fullAdType = str;
            return this;
        }

        public final Builder customerId(String str) {
            this.customerId = str;
            return this;
        }

        public final Builder allowCustomClose(boolean z) {
            this.allowCustomClose = z;
            return this;
        }

        public final Builder viewabilityVendors(Set<? extends ViewabilityVendor> set) {
            this.viewabilityVendors = set != null ? new HashSet(CollectionsKt___CollectionsKt.filterNotNull(set)) : null;
            return this;
        }

        public final AdData build() {
            return new AdData(this, (DefaultConstructorMarker) null);
        }

        public final Builder fromAdData(AdData adData) {
            Intrinsics.checkNotNullParameter(adData, "adData");
            this.vastVideoConfigString = adData.getVastVideoConfigString();
            this.orientation = adData.getOrientation();
            this.broadcastIdentifier = adData.getBroadcastIdentifier();
            this.timeoutDelayMillis = adData.getTimeoutDelayMillis();
            this.impressionMinVisibleDips = adData.getImpressionMinVisibleDips();
            this.impressionMinVisibleMs = adData.getImpressionMinVisibleMs();
            this.dspCreativeId = adData.getDspCreativeId();
            this.adPayload = adData.getAdPayload();
            this.extras = adData.getExtras();
            this.isRewarded = adData.isRewarded();
            this.rewardedDurationSeconds = adData.getRewardedDurationSeconds();
            this.currencyName = adData.getCurrencyName();
            this.currencyAmount = adData.getCurrencyAmount();
            this.adWidth = adData.getAdWidth();
            this.adHeight = adData.getAdHeight();
            this.adUnit = adData.getAdUnit();
            this.adType = adData.getAdType();
            this.fullAdType = adData.getFullAdType();
            this.customerId = adData.getCustomerId();
            this.allowCustomClose = adData.getAllowCustomClose();
            this.viewabilityVendors = adData.getViewabilityVendors();
            return this;
        }
    }
}
