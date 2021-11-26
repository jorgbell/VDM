package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbbk;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zza {
    public static final boolean zza(Context context, Intent intent, zzw zzw, zzu zzu, boolean z) {
        if (z) {
            return zzc(context, intent.getData(), zzw, zzu);
        }
        try {
            String valueOf = String.valueOf(intent.toURI());
            zze.zza(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzs.zzc();
            zzr.zzN(context, intent);
            if (zzw != null) {
                zzw.zzf();
            }
            if (zzu != null) {
                zzu.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzbbk.zzi(e.getMessage());
            if (zzu != null) {
                zzu.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, zzc zzc, zzw zzw, zzu zzu) {
        int i = 0;
        if (zzc == null) {
            zzbbk.zzi("No intent data for launcher overlay.");
            return false;
        }
        zzaeq.zza(context);
        Intent intent = zzc.zzh;
        if (intent != null) {
            return zza(context, intent, zzw, zzu, zzc.zzj);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzc.zzb)) {
            zzbbk.zzi("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.zzc)) {
            intent2.setDataAndType(Uri.parse(zzc.zzb), zzc.zzc);
        } else {
            intent2.setData(Uri.parse(zzc.zzb));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.zzd)) {
            intent2.setPackage(zzc.zzd);
        }
        if (!TextUtils.isEmpty(zzc.zze)) {
            String[] split = zzc.zze.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzc.zze);
                zzbbk.zzi(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzc.zzf;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzbbk.zzi("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcI)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcH)).booleanValue()) {
                zzs.zzc();
                zzr.zzu(context, intent2);
            }
        }
        return zza(context, intent2, zzw, zzu, zzc.zzj);
    }

    private static final boolean zzc(Context context, Uri uri, zzw zzw, zzu zzu) {
        int i;
        try {
            i = zzs.zzc().zzs(context, uri);
            if (zzw != null) {
                zzw.zzf();
            }
        } catch (ActivityNotFoundException e) {
            zzbbk.zzi(e.getMessage());
            i = 6;
        }
        if (zzu != null) {
            zzu.zzb(i);
        }
        return i == 5;
    }
}
