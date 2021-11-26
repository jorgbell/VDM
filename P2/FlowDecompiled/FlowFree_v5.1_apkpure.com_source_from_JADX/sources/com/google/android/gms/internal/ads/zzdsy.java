package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdsy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdsy> CREATOR = new zzdsz();
    @Nullable
    public final Context zza;
    public final zzdsv zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzdsv[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzdsy(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzdsv[] values = zzdsv.values();
        this.zzh = values;
        int[] zza2 = zzdsw.zza();
        this.zzl = zza2;
        int[] zza3 = zzdsx.zza();
        this.zzm = zza3;
        this.zza = null;
        this.zzi = i;
        this.zzb = values[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = zza2[i5];
        this.zzk = i6;
        int i7 = zza3[i6];
    }

    public static zzdsy zza(zzdsv zzdsv, Context context) {
        if (zzdsv == zzdsv.Rewarded) {
            return new zzdsy(context, zzdsv, ((Integer) zzaaa.zzc().zzb(zzaeq.zzev)).intValue(), ((Integer) zzaaa.zzc().zzb(zzaeq.zzeB)).intValue(), ((Integer) zzaaa.zzc().zzb(zzaeq.zzeD)).intValue(), (String) zzaaa.zzc().zzb(zzaeq.zzeF), (String) zzaaa.zzc().zzb(zzaeq.zzex), (String) zzaaa.zzc().zzb(zzaeq.zzez));
        } else if (zzdsv == zzdsv.Interstitial) {
            return new zzdsy(context, zzdsv, ((Integer) zzaaa.zzc().zzb(zzaeq.zzew)).intValue(), ((Integer) zzaaa.zzc().zzb(zzaeq.zzeC)).intValue(), ((Integer) zzaaa.zzc().zzb(zzaeq.zzeE)).intValue(), (String) zzaaa.zzc().zzb(zzaeq.zzeG), (String) zzaaa.zzc().zzb(zzaeq.zzey), (String) zzaaa.zzc().zzb(zzaeq.zzeA));
        } else if (zzdsv != zzdsv.AppOpen) {
            return null;
        } else {
            return new zzdsy(context, zzdsv, ((Integer) zzaaa.zzc().zzb(zzaeq.zzeJ)).intValue(), ((Integer) zzaaa.zzc().zzb(zzaeq.zzeL)).intValue(), ((Integer) zzaaa.zzc().zzb(zzaeq.zzeM)).intValue(), (String) zzaaa.zzc().zzb(zzaeq.zzeH), (String) zzaaa.zzc().zzb(zzaeq.zzeI), (String) zzaaa.zzc().zzb(zzaeq.zzeK));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzdsy(@Nullable Context context, zzdsv zzdsv, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzh = zzdsv.values();
        this.zzl = zzdsw.zza();
        this.zzm = zzdsx.zza();
        this.zza = context;
        this.zzi = zzdsv.ordinal();
        this.zzb = zzdsv;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        int i4 = 2;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i4 = 3;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
