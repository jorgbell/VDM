package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzbh {
    static <ResultT> TaskApiCall<zzf, ResultT> zzd(RemoteCall<zzf, TaskCompletionSource<ResultT>> remoteCall) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.run(new zzbg(remoteCall));
        return builder.build();
    }
}
