package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwd {
    private final zzczk zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzdrb zzf;
    private final Clock zzg;
    private final zzfh zzh;

    public zzdwd(zzczk zzczk, zzbbq zzbbq, String str, String str2, Context context, zzdrb zzdrb, Clock clock, zzfh zzfh) {
        this.zza = zzczk;
        this.zzb = zzbbq.zza;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzdrb;
        this.zzg = clock;
        this.zzh = zzfh;
    }

    public static final List<String> zzd(int i, int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String zze2 : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append("2.");
            sb.append(i2);
            arrayList.add(zze(zze2, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    private static String zze(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    private static String zzf(String str) {
        return (TextUtils.isEmpty(str) || !zzbbj.zzj()) ? str : "fakeForAdDebugLog";
    }

    public final List<String> zza(zzdra zzdra, zzdqo zzdqo, List<String> list) {
        return zzb(zzdra, zzdqo, false, "", "", list);
    }

    public final List<String> zzb(zzdra zzdra, zzdqo zzdqo, boolean z, String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = true != z ? "0" : "1";
        for (String zze2 : list) {
            String zze3 = zze(zze(zze(zze2, "@gw_adlocid@", zzdra.zza.zza.zzf), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzb);
            if (zzdqo != null) {
                zze3 = zzazv.zza(zze(zze(zze(zze3, "@gw_qdata@", zzdqo.zzx), "@gw_adnetid@", zzdqo.zzw), "@gw_allocid@", zzdqo.zzv), this.zze, zzdqo.zzQ);
            }
            String zze4 = zze(zze(zze(zze3, "@gw_adnetstatus@", this.zza.zzb()), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z2 = false;
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbS)).booleanValue() && !TextUtils.isEmpty(str)) {
                z2 = true;
            }
            boolean z3 = !TextUtils.isEmpty(str2);
            if (!z2) {
                if (z3) {
                    z3 = true;
                } else {
                    arrayList.add(zze4);
                }
            }
            if (this.zzh.zza(Uri.parse(zze4))) {
                Uri.Builder buildUpon = Uri.parse(zze4).buildUpon();
                if (z2) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z3) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zze4 = buildUpon.build().toString();
            }
            arrayList.add(zze4);
        }
        return arrayList;
    }

    public final List<String> zzc(zzdqo zzdqo, List<String> list, zzaws zzaws) {
        String str;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzg.currentTimeMillis();
        try {
            String zzb2 = zzaws.zzb();
            String num = Integer.toString(zzaws.zzc());
            zzdrb zzdrb = this.zzf;
            String str2 = "";
            if (zzdrb == null) {
                str = str2;
            } else {
                str = zzf(zzdrb.zza);
            }
            zzdrb zzdrb2 = this.zzf;
            if (zzdrb2 != null) {
                str2 = zzf(zzdrb2.zzb);
            }
            for (String zze2 : list) {
                arrayList.add(zzazv.zza(zze(zze(zze(zze(zze(zze(zze2, "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(zzb2)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzb), this.zze, zzdqo.zzQ));
            }
            return arrayList;
        } catch (RemoteException e) {
            zzbbk.zzg("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
