package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class GmsClientSupervisor {
    private static int zza = 4225;
    private static final Object zzb = new Object();
    private static GmsClientSupervisor zzc;

    public static int getDefaultBindFlags() {
        return zza;
    }

    @RecentlyNonNull
    public static GmsClientSupervisor getInstance(@RecentlyNonNull Context context) {
        synchronized (zzb) {
            if (zzc == null) {
                zzc = new zzq(context.getApplicationContext());
            }
        }
        return zzc;
    }

    public final void zza(@RecentlyNonNull String str, @RecentlyNonNull String str2, int i, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, boolean z) {
        zzc(new zzm(str, str2, i, z), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzb(zzm zzm, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void zzc(zzm zzm, ServiceConnection serviceConnection, String str);
}
