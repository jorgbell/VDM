package com.google.android.gms.games.internal;

import com.google.android.gms.internal.games.zzfx;
import com.google.android.gms.internal.games.zzfy;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzd {
    public static final String zzda;
    public static final String zzdb;
    public static final String zzdc;
    public static final String zzdd;

    static {
        char[] cArr = {175, 171, 160, 184, 158, 179, 174, 166, 164, 179, 167, 164, 177, 158, 165, 177, 168, 164, 173, 163, 158, 178, 179, 160, 179, 180, 178};
        for (int i = 0; i < 27; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        zzda = new String(cArr);
        char[] cArr2 = {175, 171, 160, 184, 158, 179, 174, 166, 164, 179, 167, 164, 177, 158, 173, 168, 162, 170, 173, 160, 172, 164};
        for (int i2 = 0; i2 < 22; i2++) {
            cArr2[i2] = (char) (cArr2[i2] - '?');
        }
        zzdb = new String(cArr2);
        char[] cArr3 = {175, 171, 160, 184, 158, 179, 174, 166, 164, 179, 167, 164, 177, 158, 168, 173, 181, 168, 179, 160, 179, 168, 174, 173, 158, 173, 168, 162, 170, 173, 160, 172, 164};
        for (int i3 = 0; i3 < 33; i3++) {
            cArr3[i3] = (char) (cArr3[i3] - '?');
        }
        zzdc = new String(cArr3);
        char[] cArr4 = {173, 168, 162, 170, 173, 160, 172, 164, 158, 160, 161, 180, 178, 164, 158, 177, 164, 175, 174, 177, 179, 158, 179, 174, 170, 164, 173};
        for (int i4 = 0; i4 < 27; i4++) {
            cArr4[i4] = (char) (cArr4[i4] - '?');
        }
        String str = new String(cArr4);
        zzdd = str;
        zzfy zza = zzfy.zza("external_player_id", "profile_icon_image_id", "profile_hi_res_image_id", "profile_icon_image_uri", "profile_icon_image_url", "profile_hi_res_image_uri", "profile_hi_res_image_url", "profile_name", "last_updated", "is_in_circles", "has_all_public_acls", "has_debug_access", "is_profile_visible", "current_xp_total", "current_level", "current_level_min_xp", "current_level_max_xp", "next_level", "next_level_max_xp", "last_level_up_timestamp", "player_title", "most_recent_external_game_id", "most_recent_game_name", "most_recent_activity_timestamp", "most_recent_game_icon_id", "most_recent_game_icon_uri", "most_recent_game_hi_res_id", "most_recent_game_hi_res_uri", "most_recent_game_featured_id", "most_recent_game_featured_uri", "gamer_tag", "real_name", "banner_image_landscape_id", "banner_image_landscape_uri", "banner_image_landscape_url", "banner_image_portrait_id", "banner_image_portrait_uri", "banner_image_portrait_url", "total_unlocked_achievements", zzda, zzdb, zzdc, "profile_creation_timestamp", str, "friends_list_visibility");
        zzfy zza2 = zzfy.zza("gamer_friend_status", "gamer_friend_update_timestamp", "is_muted");
        String[] strArr = (String[]) zza.toArray(new String[0]);
        zzfx zzfx = new zzfx();
        zzfx.zza(zza2);
        zzfx zzfx2 = zzfx;
        zzfx2.zza(zza);
        String[] strArr2 = (String[]) zzfx2.zzct().toArray(new String[0]);
    }
}
