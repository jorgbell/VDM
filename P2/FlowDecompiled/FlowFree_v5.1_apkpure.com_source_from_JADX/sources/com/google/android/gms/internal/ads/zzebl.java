package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzebl extends zzebe {
    private zzect<Integer> zza;
    private zzect<Integer> zzb;
    private zzebk zzc = null;
    private HttpURLConnection zzd;

    zzebl() {
        zzect<Integer> zzect = zzebg.zza;
        zzect<Integer> zzect2 = zzebh.zza;
        this.zza = zzect;
        this.zzb = zzect2;
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzd;
        zzebf.zzb();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final HttpURLConnection zzb(zzebk zzebk, int i, int i2) throws IOException {
        zzebi zzebi = new zzebi(265);
        this.zza = zzebi;
        this.zzb = new zzebj(-1);
        this.zzc = zzebk;
        zzebf.zza(((Integer) zzebi.zza()).intValue(), this.zzb.zza().intValue());
        zzebk zzebk2 = this.zzc;
        Objects.requireNonNull(zzebk2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzebk2.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }
}
