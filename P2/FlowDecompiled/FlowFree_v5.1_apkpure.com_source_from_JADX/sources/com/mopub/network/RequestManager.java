package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.RequestManager.RequestFactory;
import com.mopub.volley.Request;

public abstract class RequestManager<T extends RequestFactory> {
    protected BackoffPolicy mBackoffPolicy;
    protected Request<?> mCurrentRequest;
    protected T mRequestFactory;

    public interface RequestFactory {
    }

    /* access modifiers changed from: package-private */
    public abstract Request<?> createRequest();

    public RequestManager(Looper looper) {
        new Handler(looper);
    }

    public boolean isAtCapacity() {
        return this.mCurrentRequest != null;
    }

    public void makeRequest(T t, BackoffPolicy backoffPolicy) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(backoffPolicy);
        cancelRequest();
        this.mRequestFactory = t;
        this.mBackoffPolicy = backoffPolicy;
        makeRequestInternal();
    }

    public void cancelRequest() {
        Request<?> request;
        MoPubRequestQueue requestQueue = C2676Networking.getRequestQueue();
        if (!(requestQueue == null || (request = this.mCurrentRequest) == null)) {
            requestQueue.cancel(request);
        }
        clearRequest();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void makeRequestInternal() {
        this.mCurrentRequest = createRequest();
        MoPubRequestQueue requestQueue = C2676Networking.getRequestQueue();
        if (requestQueue == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "MoPubRequest queue is null. Clearing request.");
            clearRequest();
        } else if (this.mBackoffPolicy.getRetryCount() == 0) {
            requestQueue.add(this.mCurrentRequest);
        } else {
            requestQueue.addDelayedRequest(this.mCurrentRequest, this.mBackoffPolicy.getBackoffMs());
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void clearRequest() {
        this.mCurrentRequest = null;
        this.mBackoffPolicy = null;
    }
}
