package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    private final BasePendingResult<R> zaa;

    public OptionalPendingResultImpl(@RecentlyNonNull PendingResult<R> pendingResult) {
        this.zaa = (BasePendingResult) pendingResult;
    }

    @RecentlyNonNull
    public final R await(@RecentlyNonNull long j, @RecentlyNonNull TimeUnit timeUnit) {
        return this.zaa.await(j, timeUnit);
    }

    public final void addStatusListener(@RecentlyNonNull PendingResult.StatusListener statusListener) {
        this.zaa.addStatusListener(statusListener);
    }
}
