package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final /* synthetic */ class zzdm implements RemoteCall {
    private final Snapshot zzge;
    private final SnapshotMetadataChange zzgf;

    zzdm(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        this.zzge = snapshot;
        this.zzgf = snapshotMetadataChange;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzf) obj).zza((TaskCompletionSource) obj2, this.zzge, this.zzgf);
    }
}
