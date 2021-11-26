package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zztz extends PushbackInputStream {
    final /* synthetic */ zzua zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zztz(zzua zzua, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzua;
    }

    public final synchronized void close() throws IOException {
        zzuc.zzb(this.zza.zzc);
        super.close();
    }
}
