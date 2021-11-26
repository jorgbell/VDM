package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzes implements zzeat {
    final /* synthetic */ zzdyq zza;

    zzes(zzeu zzeu, zzdyq zzdyq) {
        this.zza = zzdyq;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
