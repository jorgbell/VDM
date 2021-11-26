package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgt extends zzhm {
    public zzgt(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "HDBr8nc5ubdBn1y5M6IpuatOFh1+XK9blifaQQrU1HNvfw3hhdVJEUnkWE7sod57", "A6vbZ9nEwiHcLSfXI6B1ZE45FocqpxNzrogO6LWG5xM=", zzcn, i, 24);
    }

    private final void zzc() {
        AdvertisingIdClient zzr = this.zzb.zzr();
        if (zzr != null) {
            try {
                AdvertisingIdClient.Info info = zzr.getInfo();
                String zza = zzgh.zza(info.getId());
                if (zza != null) {
                    synchronized (this.zze) {
                        this.zze.zzX(zza);
                        this.zze.zzZ(info.isLimitAdTrackingEnabled());
                        this.zze.zzY(zzct.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzb();
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (!this.zzb.zzh()) {
            synchronized (this.zze) {
                this.zze.zzX((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()}));
            }
            return;
        }
        zzc();
    }

    public final Void zzb() throws Exception {
        if (this.zzb.zzc()) {
            super.zzb();
            return null;
        }
        if (this.zzb.zzh()) {
            zzc();
        }
        return null;
    }
}
