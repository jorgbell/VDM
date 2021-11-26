package com.google.android.gms.ads.query;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class QueryInfoGenerationCallback {
    public abstract void onFailure(@RecentlyNonNull String str);

    public abstract void onSuccess(@RecentlyNonNull QueryInfo queryInfo);
}
