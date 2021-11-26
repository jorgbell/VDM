package com.google.android.gms.internal.drive;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.drive.DriveId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public final class zzaw extends GmsClient<zzeo> {
    private final String zzeb;
    @GuardedBy("changeEventCallbackMap")
    private final Map<DriveId, Map<Object, Object>> zzeg = new HashMap();
    @GuardedBy("changesAvailableEventCallbackMap")
    private final Map<Object, Object> zzeh = new HashMap();
    @GuardedBy("uploadProgressEventCallbackMap")
    private final Map<DriveId, Map<Object, Object>> zzei = new HashMap();
    @GuardedBy("pinnedDownloadProgressEventCallbackMap")
    private final Map<DriveId, Map<Object, Object>> zzej = new HashMap();
    private final Bundle zzz;

    public zzaw(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzeb = clientSettings.getRealClientPackageName();
        this.zzz = bundle;
        Intent intent = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        int size = queryIntentServices.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            if (!serviceInfo.exported) {
                String str = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 60);
                sb.append("Drive event service ");
                sb.append(str);
                sb.append(" must be exported in AndroidManifest.xml");
                throw new IllegalStateException(sb.toString());
            }
            return;
        }
        String action = intent.getAction();
        StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 72);
        sb2.append("AndroidManifest.xml can only define one service that handles the ");
        sb2.append(action);
        sb2.append(" action");
        throw new IllegalStateException(sb2.toString());
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    public final boolean requiresAccount() {
        return true;
    }

    public final boolean requiresSignIn() {
        return !getContext().getPackageName().equals(this.zzeb) || !UidVerifier.isGooglePlayServicesUid(getContext(), Process.myUid());
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        String packageName = getContext().getPackageName();
        Preconditions.checkNotNull(packageName);
        Preconditions.checkState(!getClientSettings().getAllRequestedScopes().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzeb)) {
            bundle.putString("proxy_package_name", this.zzeb);
        }
        bundle.putAll(this.zzz);
        return bundle;
    }

    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzeo) getService()).zza(new zzad());
            } catch (RemoteException unused) {
            }
        }
        super.disconnect();
        synchronized (this.zzeg) {
            this.zzeg.clear();
        }
        synchronized (this.zzeh) {
            this.zzeh.clear();
        }
        synchronized (this.zzei) {
            this.zzei.clear();
        }
        synchronized (this.zzej) {
            this.zzej.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(zzaw.class.getClassLoader());
            DriveId driveId = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            DriveId driveId2 = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
        if (queryLocalInterface instanceof zzeo) {
            return (zzeo) queryLocalInterface;
        }
        return new zzep(iBinder);
    }
}
