package com.google.android.gms.internal.games;

import android.content.Context;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzdg extends zzac implements SnapshotsClient {
    public zzdg(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(String str, boolean z, int i) {
        return zzb(new zzdn(str, z, i));
    }

    public final Task<SnapshotMetadata> commitAndClose(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return zzb(new zzdm(snapshot, snapshotMetadataChange));
    }
}
