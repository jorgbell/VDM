package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbn extends zzexw implements Closeable {
    static {
        zzeyd.zzb(zzbn.class);
    }

    public zzbn(zzexx zzexx, zzbm zzbm) throws IOException {
        zze(zzexx, zzexx.zzb(), zzbm);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
