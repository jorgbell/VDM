package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd$Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzahl extends NativeAd$Image {
    private final zzahk zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzahl(zzahk zzahk) {
        Drawable drawable;
        double d;
        int i;
        this.zza = zzahk;
        Uri uri = null;
        try {
            IObjectWrapper zzb2 = zzahk.zzb();
            if (zzb2 != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzb2);
                this.zzb = drawable;
                uri = this.zza.zzc();
                this.zzc = uri;
                d = this.zza.zzd();
                this.zzd = d;
                int i2 = -1;
                i = this.zza.zze();
                this.zze = i;
                i2 = this.zza.zzf();
                this.zzf = i2;
            }
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
        drawable = null;
        this.zzb = drawable;
        try {
            uri = this.zza.zzc();
        } catch (RemoteException e2) {
            zzbbk.zzg("", e2);
        }
        this.zzc = uri;
        try {
            d = this.zza.zzd();
        } catch (RemoteException e3) {
            zzbbk.zzg("", e3);
            d = 1.0d;
        }
        this.zzd = d;
        int i22 = -1;
        try {
            i = this.zza.zze();
        } catch (RemoteException e4) {
            zzbbk.zzg("", e4);
            i = -1;
        }
        this.zze = i;
        try {
            i22 = this.zza.zzf();
        } catch (RemoteException e5) {
            zzbbk.zzg("", e5);
        }
        this.zzf = i22;
    }

    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    public final Uri getUri() {
        return this.zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }
}
