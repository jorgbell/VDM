package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.zzf;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzw extends zzf.zzaq<Status> {
    zzw(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        super(baseImplementation$ResultHolder);
    }

    public final void onSignOutComplete() {
        setResult(GamesStatusCodes.zza(0));
    }
}
