package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzazv {
    public static String zza(String str, Context context, boolean z) {
        String zzl;
        if ((((Boolean) zzaaa.zzc().zzb(zzaeq.zzag)).booleanValue() && !z) || !zzs.zzA().zzb(context) || TextUtils.isEmpty(str) || (zzl = zzs.zzA().zzl(context)) == null) {
            return str;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzY)).booleanValue()) {
            String str2 = (String) zzaaa.zzc().zzb(zzaeq.zzZ);
            if (!str.contains(str2)) {
                return str;
            }
            if (zzs.zzc().zzl(str)) {
                zzs.zzA().zzn(context, zzl);
                return zzd(str, context).replace(str2, zzl);
            } else if (!zzs.zzc().zzm(str)) {
                return str;
            } else {
                zzs.zzA().zzo(context, zzl);
                return zzd(str, context).replace(str2, zzl);
            }
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (zzs.zzc().zzl(str)) {
                zzs.zzA().zzn(context, zzl);
                return zzc(zzd(str, context), "fbs_aeid", zzl).toString();
            } else if (!zzs.zzc().zzm(str)) {
                return str;
            } else {
                zzs.zzA().zzo(context, zzl);
                return zzc(zzd(str, context), "fbs_aeid", zzl).toString();
            }
        }
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzs.zzA().zzb(context)) {
            return uri.toString();
        }
        String zzl = zzs.zzA().zzl(context);
        if (zzl == null) {
            return uri.toString();
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzY)).booleanValue()) {
            String str = (String) zzaaa.zzc().zzb(zzaeq.zzZ);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzs.zzA().zzn(context, zzl);
                return zzd(uri2, context).replace(str, zzl);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String uri3 = zzc(zzd(uri.toString(), context), "fbs_aeid", zzl).toString();
            zzs.zzA().zzn(context, zzl);
            return uri3;
        }
        return uri.toString();
    }

    static Uri zzc(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    private static String zzd(String str, Context context) {
        String zzj = zzs.zzA().zzj(context);
        String zzk = zzs.zzA().zzk(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzj)) {
            str = zzc(str, "gmp_app_id", zzj).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzk)) ? str : zzc(str, "fbs_aiid", zzk).toString();
    }
}
