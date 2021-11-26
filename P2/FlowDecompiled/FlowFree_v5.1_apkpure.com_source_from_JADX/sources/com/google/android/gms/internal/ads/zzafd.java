package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzafd {
    private final Map<String, zzafc> zza = new HashMap();
    private final zzaff zzb;

    public zzafd(zzaff zzaff) {
        this.zzb = zzaff;
    }

    public final void zza(String str, zzafc zzafc) {
        this.zza.put(str, zzafc);
    }

    public final void zzb(String str, String str2, long j) {
        zzaff zzaff = this.zzb;
        zzafc zzafc = this.zza.get(str2);
        String[] strArr = {str};
        if (zzafc != null) {
            zzaff.zzb(zzafc, j, strArr);
        }
        this.zza.put(str, new zzafc(j, (String) null, (zzafc) null));
    }

    public final zzaff zzc() {
        return this.zzb;
    }
}
