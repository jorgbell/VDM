package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class HashAccumulator {
    private static int zaa = 31;
    private int zab = 1;

    @RecentlyNonNull
    public HashAccumulator addObject(Object obj) {
        this.zab = (zaa * this.zab) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @RecentlyNonNull
    public final HashAccumulator zaa(@RecentlyNonNull boolean z) {
        this.zab = (zaa * this.zab) + (z ? 1 : 0);
        return this;
    }

    @RecentlyNonNull
    public int hash() {
        return this.zab;
    }
}
