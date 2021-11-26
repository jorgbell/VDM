package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzym extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzym> CREATOR = new zzyn();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public zzym zzd;
    public IBinder zze;

    public zzym(int i, String str, String str2, zzym zzym, IBinder iBinder) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzym;
        this.zze = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zza() {
        AdError adError;
        zzym zzym = this.zzd;
        if (zzym == null) {
            adError = null;
        } else {
            adError = new AdError(zzym.zza, zzym.zzb, zzym.zzc);
        }
        return new AdError(this.zza, this.zzb, this.zzc, adError);
    }

    public final LoadAdError zzb() {
        AdError adError;
        zzym zzym = this.zzd;
        zzacg zzacg = null;
        if (zzym == null) {
            adError = null;
        } else {
            adError = new AdError(zzym.zza, zzym.zzb, zzym.zzc);
        }
        int i = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        IBinder iBinder = this.zze;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzacg = queryLocalInterface instanceof zzacg ? (zzacg) queryLocalInterface : new zzace(iBinder);
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.zzb(zzacg));
    }
}
