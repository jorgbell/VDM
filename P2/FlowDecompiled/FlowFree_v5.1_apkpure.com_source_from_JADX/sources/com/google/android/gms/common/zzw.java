package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
class zzw {
    private static final zzw zzd = new zzw(true, (String) null, (Throwable) null);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;

    zzw(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzb = str;
        this.zzc = th;
    }

    static zzw zzb() {
        return zzd;
    }

    static zzw zzc(Callable<String> callable) {
        return new zzv(callable, (zzu) null);
    }

    static zzw zzd(String str) {
        return new zzw(false, str, (Throwable) null);
    }

    static zzw zze(String str, Throwable th) {
        return new zzw(false, str, th);
    }

    static String zzg(String str, zzi zzi, boolean z, boolean z2) {
        String str2 = true != z2 ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-1");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{str2, str, Hex.bytesToStringLowercase(zza2.digest(zzi.zzc())), Boolean.valueOf(z), "12451000.false"});
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzc != null) {
                Log.d("GoogleCertificatesRslt", zza(), this.zzc);
            } else {
                Log.d("GoogleCertificatesRslt", zza());
            }
        }
    }
}
