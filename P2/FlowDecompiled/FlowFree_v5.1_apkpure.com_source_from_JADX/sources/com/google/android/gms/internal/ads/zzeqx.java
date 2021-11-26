package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeqx extends ThreadLocal<Mac> {
    final /* synthetic */ zzeqy zza;

    zzeqx(zzeqy zzeqy) {
        this.zza = zzeqy;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac zza2 = zzeqk.zzb.zza(this.zza.zzb);
            zza2.init(this.zza.zzc);
            return zza2;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
