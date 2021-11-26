package com.mopub.common.privacy;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.UUID;

public class AdvertisingId implements Serializable {
    final String mAdvertisingId;
    final boolean mDoNotTrack;
    final String mMopubId;

    AdvertisingId(String str, String str2, boolean z) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.mAdvertisingId = str;
        this.mMopubId = str2;
        this.mDoNotTrack = z;
    }

    public String getIdentifier(boolean z) {
        return (this.mDoNotTrack || !z) ? this.mMopubId : this.mAdvertisingId;
    }

    public String getIdWithPrefix(boolean z) {
        if (this.mDoNotTrack || !z || this.mAdvertisingId.isEmpty()) {
            return "mopub:" + this.mMopubId;
        }
        return "ifa:" + this.mAdvertisingId;
    }

    /* access modifiers changed from: package-private */
    public String getIfa() {
        return this.mAdvertisingId;
    }

    public boolean isDoNotTrack() {
        return this.mDoNotTrack;
    }

    static AdvertisingId generateFreshAdvertisingId() {
        return new AdvertisingId("", generateIdString(), false);
    }

    static String generateIdString() {
        return UUID.randomUUID().toString();
    }

    public String toString() {
        return "AdvertisingId{, mAdvertisingId='" + this.mAdvertisingId + '\'' + ", mMopubId='" + this.mMopubId + '\'' + ", mDoNotTrack=" + this.mDoNotTrack + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertisingId)) {
            return false;
        }
        AdvertisingId advertisingId = (AdvertisingId) obj;
        if (this.mDoNotTrack == advertisingId.mDoNotTrack && this.mAdvertisingId.equals(advertisingId.mAdvertisingId)) {
            return this.mMopubId.equals(advertisingId.mMopubId);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mAdvertisingId.hashCode() * 31) + this.mMopubId.hashCode()) * 31) + (this.mDoNotTrack ? 1 : 0);
    }
}
