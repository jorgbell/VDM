package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzuc {
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public zztr zza;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Object zzd = new Object();

    zzuc(Context context) {
        this.zzc = context;
    }

    /* access modifiers changed from: package-private */
    public final Future<zzue> zza(zzts zzts) {
        zztw zztw = new zztw(this);
        zzua zzua = new zzua(this, zzts, zztw);
        zzub zzub = new zzub(this, zztw);
        synchronized (this.zzd) {
            zztr zztr = new zztr(this.zzc, zzs.zzq().zza(), zzua, zzub);
            this.zza = zztr;
            zztr.checkAvailabilityAndConnect();
        }
        return zztw;
    }

    static /* synthetic */ void zzb(zzuc zzuc) {
        synchronized (zzuc.zzd) {
            zztr zztr = zzuc.zza;
            if (zztr != null) {
                zztr.disconnect();
                zzuc.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
