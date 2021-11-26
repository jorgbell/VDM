package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface ExperienceEvent extends Parcelable, Freezable<ExperienceEvent> {
    @RecentlyNonNull
    Game getGame();

    @RecentlyNonNull
    Uri getIconImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    int getType();

    @RecentlyNonNull
    String zzbq();

    @RecentlyNonNull
    String zzbr();

    @RecentlyNonNull
    String zzbs();

    long zzbt();

    long zzbu();

    long zzbv();

    int zzbw();
}
