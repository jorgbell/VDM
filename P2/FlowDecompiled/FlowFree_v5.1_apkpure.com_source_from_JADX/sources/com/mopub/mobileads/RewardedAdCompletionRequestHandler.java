package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.RewardedAdCompletionRequest;
import com.mopub.network.C2676Networking;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;

public class RewardedAdCompletionRequestHandler implements RewardedAdCompletionRequest.RewardedAdCompletionRequestListener {
    static final int[] RETRY_TIMES = {5000, 10000, 20000, 40000, 60000};
    private final Context mContext;
    private final Handler mHandler;
    private final RequestQueue mRequestQueue;
    private int mRetryCount;
    private volatile boolean mShouldStop;
    private final String mUrl;

    RewardedAdCompletionRequestHandler(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        this(context, str, str2, str3, str4, str5, str6, new Handler());
    }

    @VisibleForTesting
    RewardedAdCompletionRequestHandler(Context context, String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str3);
        Preconditions.checkNotNull(str4);
        Preconditions.checkNotNull(handler);
        this.mUrl = appendParameters(str, str2, str3, str4, str5, str6);
        this.mRetryCount = 0;
        this.mHandler = handler;
        this.mRequestQueue = C2676Networking.getRequestQueue(context);
        this.mContext = context.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    public void makeRewardedAdCompletionRequest() {
        if (this.mShouldStop) {
            this.mRequestQueue.cancelAll((Object) this.mUrl);
            return;
        }
        RewardedAdCompletionRequest rewardedAdCompletionRequest = new RewardedAdCompletionRequest(this.mContext, this.mUrl, new DefaultRetryPolicy(getTimeout(this.mRetryCount) - 1000, 0, 0.0f), this);
        rewardedAdCompletionRequest.setTag(this.mUrl);
        this.mRequestQueue.add(rewardedAdCompletionRequest);
        int i = this.mRetryCount;
        if (i >= 17) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Exceeded number of retries for rewarded video completion request.");
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                RewardedAdCompletionRequestHandler.this.makeRewardedAdCompletionRequest();
            }
        }, (long) getTimeout(i));
        this.mRetryCount++;
    }

    public void onResponse(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 500 || num.intValue() >= 600) {
            this.mShouldStop = true;
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        NetworkResponse networkResponse;
        if (volleyError != null && (networkResponse = volleyError.networkResponse) != null) {
            int i = networkResponse.statusCode;
            if (i < 500 || i >= 600) {
                this.mShouldStop = true;
            }
        }
    }

    public static void makeRewardedAdCompletionRequest(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (context != null && !TextUtils.isEmpty(str) && str3 != null && str4 != null) {
            new RewardedAdCompletionRequestHandler(context, str, str2, str3, str4, str5, str6).makeRewardedAdCompletionRequest();
        }
    }

    static int getTimeout(int i) {
        if (i >= 0) {
            int[] iArr = RETRY_TIMES;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        int[] iArr2 = RETRY_TIMES;
        return iArr2[iArr2.length - 1];
    }

    private static String appendParameters(String str, String str2, String str3, String str4, String str5, String str6) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str3);
        Preconditions.checkNotNull(str4);
        StringBuilder sb = new StringBuilder(str);
        sb.append("&customer_id=");
        String str7 = "";
        sb.append(str2 == null ? str7 : Uri.encode(str2));
        sb.append("&rcn=");
        sb.append(Uri.encode(str3));
        sb.append("&rca=");
        sb.append(Uri.encode(str4));
        sb.append("&nv=");
        sb.append(Uri.encode(MoPub.SDK_VERSION));
        sb.append("&v=");
        sb.append(1);
        sb.append("&cec=");
        if (str5 != null) {
            str7 = Uri.encode(str5);
        }
        sb.append(str7);
        if (!TextUtils.isEmpty(str6)) {
            sb.append("&rcd=");
            sb.append(Uri.encode(str6));
        }
        return sb.toString();
    }
}
