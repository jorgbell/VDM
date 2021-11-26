package com.google.android.gms.games;

import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface GamesClient {
    @RecentlyNonNull
    Task<Void> setViewForPopups(@RecentlyNonNull View view);
}
