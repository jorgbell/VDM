package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    public abstract void clearListener();

    @RecentlyNullable
    public abstract Feature[] getRequiredFeatures();

    /* access modifiers changed from: protected */
    public abstract void registerListener(@RecentlyNonNull A a, @RecentlyNonNull TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    @RecentlyNonNull
    public final boolean zaa() {
        throw null;
    }
}
