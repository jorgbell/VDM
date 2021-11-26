package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzd {
    public final String name;
    public final String zzbe;
    public final String zzbj;
    public final String zzce;
    public final String zzhz;
    public final String zzia;
    public final String zzib;
    public final String zzic;
    public final String zzid;
    public final String zzie;
    public final String zzif;
    public final String zzig;
    public final String zzih;
    public final String zzii;
    public final String zzij;
    public final String zzik;
    public final String zzil;
    public final String zzim;
    public final String zzin;
    public final String zzio;
    public final String zziq;
    public final String zzir;
    public final String zzis;
    public final String zzit;
    public final String zziu;
    public final String zziv;
    public final String zziw;
    public final String zzix;
    public final String zziy;
    public final String zziz;
    public final String zzja;
    public final String zzjb;
    public final String zzjf;
    public final String zzjg;
    public final String zzjh;
    public final String zzji;
    public final String zzjk;

    public zzd(String str) {
        String str2;
        String str3 = "most_recent_activity_timestamp";
        String str4 = "most_recent_game_name";
        String str5 = "most_recent_external_game_id";
        String str6 = "is_profile_visible";
        String str7 = "player_title";
        String str8 = "last_level_up_timestamp";
        String str9 = "next_level_max_xp";
        if (TextUtils.isEmpty((CharSequence) null)) {
            this.zzhz = "external_player_id";
            this.zzia = "profile_name";
            this.zzib = "profile_icon_image_uri";
            this.zzic = "profile_icon_image_url";
            this.zzid = "profile_hi_res_image_uri";
            this.zzie = "profile_hi_res_image_url";
            this.zzif = "last_updated";
            this.zzig = "is_in_circles";
            this.zzih = "played_with_timestamp";
            this.zzii = "current_xp_total";
            this.zzij = "current_level";
            this.zzik = "current_level_min_xp";
            this.zzil = "current_level_max_xp";
            this.zzim = "next_level";
            this.zzin = str9;
            this.zzio = str8;
            this.zzbe = str7;
            this.zziq = str6;
            this.zzir = str5;
            this.zzis = str4;
            this.zzit = str3;
            this.zziu = "most_recent_game_icon_uri";
            this.zziv = "most_recent_game_hi_res_uri";
            this.zziw = "most_recent_game_featured_uri";
            this.zzix = "has_debug_access";
            this.zzbj = "gamer_tag";
            this.name = "real_name";
            this.zziy = "banner_image_landscape_uri";
            this.zziz = "banner_image_landscape_url";
            this.zzja = "banner_image_portrait_uri";
            this.zzjb = "banner_image_portrait_url";
            this.zzjf = "total_unlocked_achievements";
            this.zzjg = com.google.android.gms.games.internal.zzd.zzda;
            this.zzjh = com.google.android.gms.games.internal.zzd.zzdb;
            this.zzji = com.google.android.gms.games.internal.zzd.zzdc;
            this.zzce = com.google.android.gms.games.internal.zzd.zzdd;
            str2 = "friends_list_visibility";
        } else {
            String str10 = str9;
            this.zzhz = "external_player_id".length() != 0 ? "null".concat("external_player_id") : new String("null");
            this.zzia = "profile_name".length() != 0 ? "null".concat("profile_name") : new String("null");
            this.zzib = "profile_icon_image_uri".length() != 0 ? "null".concat("profile_icon_image_uri") : new String("null");
            this.zzic = "profile_icon_image_url".length() != 0 ? "null".concat("profile_icon_image_url") : new String("null");
            this.zzid = "profile_hi_res_image_uri".length() != 0 ? "null".concat("profile_hi_res_image_uri") : new String("null");
            this.zzie = "profile_hi_res_image_url".length() != 0 ? "null".concat("profile_hi_res_image_url") : new String("null");
            this.zzif = "last_updated".length() != 0 ? "null".concat("last_updated") : new String("null");
            this.zzig = "is_in_circles".length() != 0 ? "null".concat("is_in_circles") : new String("null");
            this.zzih = "played_with_timestamp".length() != 0 ? "null".concat("played_with_timestamp") : new String("null");
            this.zzii = "current_xp_total".length() != 0 ? "null".concat("current_xp_total") : new String("null");
            this.zzij = "current_level".length() != 0 ? "null".concat("current_level") : new String("null");
            this.zzik = "current_level_min_xp".length() != 0 ? "null".concat("current_level_min_xp") : new String("null");
            this.zzil = "current_level_max_xp".length() != 0 ? "null".concat("current_level_max_xp") : new String("null");
            this.zzim = "next_level".length() != 0 ? "null".concat("next_level") : new String("null");
            this.zzin = str10.length() != 0 ? "null".concat(str10) : new String("null");
            this.zzio = str8.length() != 0 ? "null".concat(str8) : new String("null");
            this.zzbe = str7.length() != 0 ? "null".concat(str7) : new String("null");
            if ("has_all_public_acls".length() != 0) {
                "null".concat("has_all_public_acls");
            } else {
                new String("null");
            }
            this.zziq = str6.length() != 0 ? "null".concat(str6) : new String("null");
            this.zzir = str5.length() != 0 ? "null".concat(str5) : new String("null");
            this.zzis = str4.length() != 0 ? "null".concat(str4) : new String("null");
            this.zzit = str3.length() != 0 ? "null".concat(str3) : new String("null");
            this.zziu = "most_recent_game_icon_uri".length() != 0 ? "null".concat("most_recent_game_icon_uri") : new String("null");
            this.zziv = "most_recent_game_hi_res_uri".length() != 0 ? "null".concat("most_recent_game_hi_res_uri") : new String("null");
            this.zziw = "most_recent_game_featured_uri".length() != 0 ? "null".concat("most_recent_game_featured_uri") : new String("null");
            this.zzix = "has_debug_access".length() != 0 ? "null".concat("has_debug_access") : new String("null");
            this.zzbj = "gamer_tag".length() != 0 ? "null".concat("gamer_tag") : new String("null");
            this.name = "real_name".length() != 0 ? "null".concat("real_name") : new String("null");
            this.zziy = "banner_image_landscape_uri".length() != 0 ? "null".concat("banner_image_landscape_uri") : new String("null");
            this.zziz = "banner_image_landscape_url".length() != 0 ? "null".concat("banner_image_landscape_url") : new String("null");
            this.zzja = "banner_image_portrait_uri".length() != 0 ? "null".concat("banner_image_portrait_uri") : new String("null");
            this.zzjb = "banner_image_portrait_url".length() != 0 ? "null".concat("banner_image_portrait_url") : new String("null");
            if ("gamer_friend_status".length() != 0) {
                "null".concat("gamer_friend_status");
            } else {
                new String("null");
            }
            if ("gamer_friend_update_timestamp".length() != 0) {
                "null".concat("gamer_friend_update_timestamp");
            } else {
                new String("null");
            }
            if ("is_muted".length() != 0) {
                "null".concat("is_muted");
            } else {
                new String("null");
            }
            this.zzjf = "total_unlocked_achievements".length() != 0 ? "null".concat("total_unlocked_achievements") : new String("null");
            String valueOf = String.valueOf(com.google.android.gms.games.internal.zzd.zzda);
            this.zzjg = valueOf.length() != 0 ? "null".concat(valueOf) : new String("null");
            String valueOf2 = String.valueOf(com.google.android.gms.games.internal.zzd.zzdb);
            this.zzjh = valueOf2.length() != 0 ? "null".concat(valueOf2) : new String("null");
            String valueOf3 = String.valueOf(com.google.android.gms.games.internal.zzd.zzdc);
            this.zzji = valueOf3.length() != 0 ? "null".concat(valueOf3) : new String("null");
            if ("profile_creation_timestamp".length() != 0) {
                "null".concat("profile_creation_timestamp");
            } else {
                new String("null");
            }
            String valueOf4 = String.valueOf(com.google.android.gms.games.internal.zzd.zzdd);
            this.zzce = valueOf4.length() != 0 ? "null".concat(valueOf4) : new String("null");
            str2 = "friends_list_visibility".length() != 0 ? "null".concat("friends_list_visibility") : new String("null");
        }
        this.zzjk = str2;
    }
}
