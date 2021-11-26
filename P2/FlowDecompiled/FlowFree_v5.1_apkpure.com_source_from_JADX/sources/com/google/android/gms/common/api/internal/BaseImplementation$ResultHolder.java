package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public interface BaseImplementation$ResultHolder<R> {
    void setFailedResult(@RecentlyNonNull Status status);

    void setResult(@RecentlyNonNull R r);
}
