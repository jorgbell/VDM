package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public interface ConnectionCallbacks {
    void onConnected(Bundle bundle);

    void onConnectionSuspended(@RecentlyNonNull int i);
}
