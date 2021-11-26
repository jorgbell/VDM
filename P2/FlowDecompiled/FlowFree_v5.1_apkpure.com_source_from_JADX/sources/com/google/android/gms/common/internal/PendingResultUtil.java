package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class PendingResultUtil {
    private static final zaa zaa = new zan();

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface ResultConverter<R extends Result, T> {
        @RecentlyNonNull
        T convert(@RecentlyNonNull R r);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface zaa {
        ApiException zaa(Status status);
    }

    @RecentlyNonNull
    public static <R extends Result, T> Task<T> toTask(@RecentlyNonNull PendingResult<R> pendingResult, @RecentlyNonNull ResultConverter<R, T> resultConverter) {
        zaa zaa2 = zaa;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zap(pendingResult, taskCompletionSource, resultConverter, zaa2));
        return taskCompletionSource.getTask();
    }

    @RecentlyNonNull
    public static <R extends Result> Task<Void> toVoidTask(@RecentlyNonNull PendingResult<R> pendingResult) {
        return toTask(pendingResult, new zaq());
    }
}
