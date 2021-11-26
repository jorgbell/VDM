package com.mopub.mobileads;

import android.content.Context;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;

public class RewardedAdCompletionRequest extends MoPubRequest<Integer> {
    final RewardedAdCompletionRequestListener mListener;

    public interface RewardedAdCompletionRequestListener extends Response.ErrorListener {
        /* synthetic */ void onErrorResponse(VolleyError volleyError);

        void onResponse(Integer num);
    }

    public RewardedAdCompletionRequest(Context context, String str, RetryPolicy retryPolicy, RewardedAdCompletionRequestListener rewardedAdCompletionRequestListener) {
        super(context, str, rewardedAdCompletionRequestListener);
        setShouldCache(false);
        setRetryPolicy(retryPolicy);
        this.mListener = rewardedAdCompletionRequestListener;
    }

    /* access modifiers changed from: protected */
    public Response<Integer> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(Integer.valueOf(networkResponse.statusCode), HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(Integer num) {
        this.mListener.onResponse(num);
    }
}
