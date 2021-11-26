package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface AchievementsClient {
    @RecentlyNonNull
    Task<Intent> getAchievementsIntent();

    void unlock(@RecentlyNonNull String str);
}
