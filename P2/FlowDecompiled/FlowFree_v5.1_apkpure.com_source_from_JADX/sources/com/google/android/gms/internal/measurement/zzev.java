package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzev implements zzes {
    private static zzev zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzev() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzev(Context context) {
        this.zzb = context;
        zzeu zzeu = new zzeu(this, (Handler) null);
        this.zzc = zzeu;
        context.getContentResolver().registerContentObserver(zzej.zza, true, zzeu);
    }

    static zzev zza(Context context) {
        zzev zzev;
        synchronized (zzev.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzev(context) : new zzev();
            }
            zzev = zza;
        }
        return zzev;
    }

    static synchronized void zzc() {
        Context context;
        synchronized (zzev.class) {
            zzev zzev = zza;
            if (!(zzev == null || (context = zzev.zzb) == null || zzev.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* renamed from: zzb */
    public final String zze(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzeq.zza(new zzet(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzej.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
