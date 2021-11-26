package com.google.android.gms.internal.games;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzaq extends zzac implements GamesClient {
    public zzaq(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<Void> setViewForPopups(View view) {
        return zzb(new zzas(view));
    }
}
