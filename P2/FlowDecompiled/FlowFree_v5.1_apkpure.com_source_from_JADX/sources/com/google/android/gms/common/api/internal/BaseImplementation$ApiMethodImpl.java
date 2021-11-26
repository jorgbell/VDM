package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class BaseImplementation$ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements BaseImplementation$ResultHolder<R> {
    /* access modifiers changed from: protected */
    public abstract void doExecute(@RecentlyNonNull A a) throws RemoteException;

    /* access modifiers changed from: protected */
    public void onSetFailedResult(@RecentlyNonNull R r) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected BaseImplementation$ApiMethodImpl(@RecentlyNonNull Api<?> api, @RecentlyNonNull GoogleApiClient googleApiClient) {
        super(googleApiClient);
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
        Preconditions.checkNotNull(api, "Api must not be null");
        api.zac();
    }

    public final void run(@RecentlyNonNull A a) throws DeadObjectException {
        try {
            doExecute(a);
        } catch (DeadObjectException e) {
            setFailedResult((RemoteException) e);
            throw e;
        } catch (RemoteException e2) {
            setFailedResult(e2);
        }
    }

    public final void setFailedResult(@RecentlyNonNull Status status) {
        Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
        Result createFailedResult = createFailedResult(status);
        setResult(createFailedResult);
        onSetFailedResult(createFailedResult);
    }

    private void setFailedResult(RemoteException remoteException) {
        setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    public /* bridge */ /* synthetic */ void setResult(@RecentlyNonNull Object obj) {
        super.setResult((Result) obj);
    }
}
