package com.mopub.network;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class MoPubNetworkError extends VolleyError {
    private final Reason mReason;
    private final Integer mRefreshTimeMillis;

    public enum Reason {
        WARMING_UP,
        NO_FILL,
        BAD_HEADER_DATA,
        BAD_BODY,
        TRACKING_FAILURE,
        TOO_MANY_REQUESTS,
        UNSPECIFIED
    }

    public MoPubNetworkError(Reason reason) {
        this.mReason = reason;
        this.mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(NetworkResponse networkResponse, Reason reason) {
        super(networkResponse);
        this.mReason = reason;
        this.mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(Throwable th, Reason reason) {
        super(th);
        this.mReason = reason;
        this.mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(String str, Reason reason) {
        this(str, reason, (Integer) null);
    }

    public MoPubNetworkError(String str, Throwable th, Reason reason) {
        super(str, th);
        this.mReason = reason;
        this.mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(String str, Reason reason, Integer num) {
        super(str);
        this.mReason = reason;
        this.mRefreshTimeMillis = num;
    }

    public Reason getReason() {
        return this.mReason;
    }

    public Integer getRefreshTimeMillis() {
        return this.mRefreshTimeMillis;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MoPubNetworkError moPubNetworkError = (MoPubNetworkError) obj;
        if (this.mReason != moPubNetworkError.mReason) {
            return false;
        }
        Integer num = this.mRefreshTimeMillis;
        if (num != null) {
            return num.equals(moPubNetworkError.mRefreshTimeMillis);
        }
        if (moPubNetworkError.mRefreshTimeMillis == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.mReason.hashCode() * 31;
        Integer num = this.mRefreshTimeMillis;
        return hashCode + (num != null ? num.hashCode() : 0);
    }
}
