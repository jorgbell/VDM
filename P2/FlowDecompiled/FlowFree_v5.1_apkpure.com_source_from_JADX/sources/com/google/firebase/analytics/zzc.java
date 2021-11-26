package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.measurement.internal.zzhs;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.3 */
final class zzc implements zzhs {
    final /* synthetic */ zzbs zza;

    zzc(zzbs zzbs) {
        this.zza = zzbs;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzh(str, str2, bundle);
    }

    public final Map<String, Object> zzc(String str, String str2, boolean z) {
        return this.zza.zzB(str, str2, z);
    }

    public final String zzg() {
        return this.zza.zzz();
    }

    public final String zzh() {
        return this.zza.zzA();
    }

    public final String zzi() {
        return this.zza.zzx();
    }

    public final String zzj() {
        return this.zza.zzw();
    }

    public final long zzk() {
        return this.zza.zzy();
    }

    public final void zzl(String str) {
        this.zza.zzu(str);
    }

    public final void zzm(String str) {
        this.zza.zzv(str);
    }

    public final void zzn(Bundle bundle) {
        this.zza.zzk(bundle);
    }

    public final void zzo(String str, String str2, Bundle bundle) {
        this.zza.zzl(str, str2, bundle);
    }

    public final List<Bundle> zzp(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    public final int zzq(String str) {
        return this.zza.zzE(str);
    }
}
