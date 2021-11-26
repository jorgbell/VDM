package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public interface RemoteCall<T, U> {
    void accept(@RecentlyNonNull T t, @RecentlyNonNull U u) throws RemoteException;
}
