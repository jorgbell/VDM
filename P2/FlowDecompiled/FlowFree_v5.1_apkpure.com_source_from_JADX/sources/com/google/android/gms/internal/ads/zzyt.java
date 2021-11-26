package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzyt {
    private Bundle zza = new Bundle();
    private List<String> zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List<String> zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List<String> zzj = new ArrayList();
    private int zzk = 60000;

    public final zzys zza() {
        return new zzys(8, -1, this.zza, -1, this.zzb, this.zzc, this.zzd, false, (String) null, (zzadu) null, (Location) null, (String) null, this.zze, this.zzf, this.zzg, (String) null, (String) null, false, (zzyk) null, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    public final zzyt zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzyt zzc(List<String> list) {
        this.zzb = list;
        return this;
    }

    public final zzyt zzd(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzyt zze(int i) {
        this.zzd = i;
        return this;
    }

    public final zzyt zzf(int i) {
        this.zzh = i;
        return this;
    }

    public final zzyt zzg(String str) {
        this.zzi = str;
        return this;
    }

    public final zzyt zzh(int i) {
        this.zzk = i;
        return this;
    }
}
