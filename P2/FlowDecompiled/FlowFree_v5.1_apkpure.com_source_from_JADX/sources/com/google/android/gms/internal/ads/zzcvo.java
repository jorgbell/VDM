package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcvo implements DialogInterface.OnClickListener {
    private final zzcvk zza;
    private final String zzb;
    private final zzcni zzc;
    private final Activity zzd;
    private final zzdvo zze;
    private final zzm zzf;

    zzcvo(zzcvk zzcvk, String str, zzcni zzcni, Activity activity, zzdvo zzdvo, zzm zzm) {
        this.zza = zzcvk;
        this.zzb = str;
        this.zzc = zzcni;
        this.zzd = activity;
        this.zze = zzdvo;
        this.zzf = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzcvk zzcvk = this.zza;
        String str = this.zzb;
        zzcni zzcni = this.zzc;
        Activity activity = this.zzd;
        zzdvo zzdvo = this.zze;
        zzm zzm = this.zzf;
        zzcvk.zzd(str);
        if (zzcni != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcvs.zzh(activity, zzcni, zzdvo, zzcvk, str, "dialog_click", hashMap);
        }
        if (zzm != null) {
            zzm.zzb();
        }
    }
}
