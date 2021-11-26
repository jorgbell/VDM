package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.drive.Contents;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface SnapshotContents extends Parcelable {
    void close();

    boolean isClosed();

    @RecentlyNonNull
    byte[] readFully() throws IOException;

    boolean writeBytes(@RecentlyNonNull byte[] bArr);

    @RecentlyNonNull
    Contents zzck();
}
