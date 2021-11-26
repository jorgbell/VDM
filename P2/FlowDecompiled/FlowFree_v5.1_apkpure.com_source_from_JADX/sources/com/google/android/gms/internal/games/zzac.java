package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public class zzac extends GoogleApi<Games.GamesOptions> {
    public zzac(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, Games.API, gamesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    protected zzac(Context context, Games.GamesOptions gamesOptions) {
        super(context, Games.API, gamesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* access modifiers changed from: protected */
    public ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (!(getApiOptions() == null || ((Games.GamesOptions) getApiOptions()).zzat == null)) {
            createClientSettingsBuilder.setRealClientPackageName(((Games.GamesOptions) getApiOptions()).zzat);
        }
        return createClientSettingsBuilder;
    }

    /* access modifiers changed from: protected */
    public final <ResultT> Task<ResultT> zzb(RemoteCall<zzf, TaskCompletionSource<ResultT>> remoteCall) {
        return doWrite(zzc(remoteCall));
    }

    private static <ResultT> TaskApiCall<zzf, ResultT> zzc(RemoteCall<zzf, TaskCompletionSource<ResultT>> remoteCall) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.run(new zzaf(remoteCall));
        return builder.build();
    }
}
