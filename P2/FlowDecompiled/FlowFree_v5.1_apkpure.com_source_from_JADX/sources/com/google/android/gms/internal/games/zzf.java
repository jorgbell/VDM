package com.google.android.gms.internal.games;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzf extends zzac implements AchievementsClient {
    public zzf(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public final Task<Intent> getAchievementsIntent() {
        return doRead(zzbh.zzd(zze.zzev));
    }

    public final void unlock(String str) {
        doWrite(zzbh.zzd(new zzi(str)));
    }
}
