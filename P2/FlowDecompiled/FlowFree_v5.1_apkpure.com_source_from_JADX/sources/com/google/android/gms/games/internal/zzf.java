package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games.zzfe;
import com.google.android.gms.internal.games.zzfi;
import com.google.android.gms.internal.games.zzgh;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public class zzf extends GmsClient<zzac> {
    private final zzfe zzdh = new zze(this);
    private final String zzdi;
    private final zzae zzdl;
    private boolean zzdm = false;
    private final long zzdn;
    private final Games.GamesOptions zzdp;

    public zzf(Context context, Looper looper, ClientSettings clientSettings, Games.GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzdi = clientSettings.getRealClientPackageName();
        this.zzdl = zzae.zza(this, clientSettings.getGravityForPopups());
        this.zzdn = (long) hashCode();
        this.zzdp = gamesOptions;
        if (gamesOptions.zzaq) {
            return;
        }
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zza(clientSettings.getViewForPopups());
        }
    }

    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    public boolean requiresAccount() {
        return true;
    }

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    private static abstract class zzaq<T> extends zza {
        private final BaseImplementation$ResultHolder<T> zzep;

        zzaq(BaseImplementation$ResultHolder<T> baseImplementation$ResultHolder) {
            Preconditions.checkNotNull(baseImplementation$ResultHolder, "Holder must not be null");
            this.zzep = baseImplementation$ResultHolder;
        }

        /* access modifiers changed from: package-private */
        public final void setResult(T t) {
            this.zzep.setResult(t);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    private static final class zzav extends zza {
        private final TaskCompletionSource<SnapshotsClient.DataOrConflict<Snapshot>> zzdv;

        zzav(TaskCompletionSource<SnapshotsClient.DataOrConflict<Snapshot>> taskCompletionSource) {
            this.zzdv = taskCompletionSource;
        }

        public final void zza(DataHolder dataHolder, Contents contents) {
            int statusCode = dataHolder.getStatusCode();
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                SnapshotEntity snapshotEntity = snapshotMetadataBuffer.getCount() > 0 ? new SnapshotEntity((SnapshotMetadata) ((SnapshotMetadata) snapshotMetadataBuffer.get(0)).freeze(), new SnapshotContentsEntity(contents)) : null;
                snapshotMetadataBuffer.close();
                if (statusCode == 0) {
                    this.zzdv.setResult(new SnapshotsClient.DataOrConflict(snapshotEntity, (SnapshotsClient.SnapshotConflict) null));
                    return;
                } else if (statusCode != 4002 || snapshotEntity == null || snapshotEntity.getMetadata() == null) {
                    zzf.zzb(this.zzdv, statusCode);
                    return;
                } else {
                    this.zzdv.setException(new SnapshotsClient.SnapshotContentUnavailableApiException(GamesStatusCodes.zza(statusCode), snapshotEntity.getMetadata()));
                    return;
                }
            } catch (Throwable th) {
                zzgh.zza(th, th);
            }
            throw th;
        }

        public final void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() >= 2 && str != null) {
                    if (contents3 != null) {
                        SnapshotEntity snapshotEntity = new SnapshotEntity((SnapshotMetadata) ((SnapshotMetadata) snapshotMetadataBuffer.get(0)).freeze(), new SnapshotContentsEntity(contents));
                        SnapshotEntity snapshotEntity2 = new SnapshotEntity((SnapshotMetadata) ((SnapshotMetadata) snapshotMetadataBuffer.get(1)).freeze(), new SnapshotContentsEntity(contents2));
                        snapshotMetadataBuffer.close();
                        this.zzdv.setResult(new SnapshotsClient.DataOrConflict(null, new SnapshotsClient.SnapshotConflict(snapshotEntity, str, snapshotEntity2, new SnapshotContentsEntity(contents3))));
                        return;
                    }
                }
                this.zzdv.setResult(null);
                snapshotMetadataBuffer.close();
                return;
            } catch (Throwable th) {
                zzgh.zza(th, th);
            }
            throw th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    private static final class zzg extends zza {
        private final TaskCompletionSource<SnapshotMetadata> zzdv;

        zzg(TaskCompletionSource<SnapshotMetadata> taskCompletionSource) {
            this.zzdv = taskCompletionSource;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.games.snapshot.SnapshotMetadata} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void zzah(com.google.android.gms.common.data.DataHolder r3) {
            /*
                r2 = this;
                int r0 = r3.getStatusCode()
                if (r0 == 0) goto L_0x000f
                com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.games.snapshot.SnapshotMetadata> r1 = r2.zzdv
                com.google.android.gms.games.internal.zzf.zzb(r1, (int) r0)
                r3.close()
                return
            L_0x000f:
                r0 = 0
                com.google.android.gms.games.snapshot.SnapshotMetadataBuffer r1 = new com.google.android.gms.games.snapshot.SnapshotMetadataBuffer
                r1.<init>(r3)
                int r3 = r1.getCount()     // Catch:{ all -> 0x0032 }
                if (r3 <= 0) goto L_0x0029
                r3 = 0
                java.lang.Object r3 = r1.get((int) r3)     // Catch:{ all -> 0x0032 }
                com.google.android.gms.games.snapshot.SnapshotMetadata r3 = (com.google.android.gms.games.snapshot.SnapshotMetadata) r3     // Catch:{ all -> 0x0032 }
                java.lang.Object r3 = r3.freeze()     // Catch:{ all -> 0x0032 }
                r0 = r3
                com.google.android.gms.games.snapshot.SnapshotMetadata r0 = (com.google.android.gms.games.snapshot.SnapshotMetadata) r0     // Catch:{ all -> 0x0032 }
            L_0x0029:
                r1.close()
                com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.games.snapshot.SnapshotMetadata> r3 = r2.zzdv
                r3.setResult(r0)
                return
            L_0x0032:
                r3 = move-exception
                r1.close()     // Catch:{ all -> 0x0037 }
                goto L_0x003b
            L_0x0037:
                r0 = move-exception
                com.google.android.gms.internal.games.zzgh.zza(r3, r0)
            L_0x003b:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzf.zzg.zzah(com.google.android.gms.common.data.DataHolder):void");
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    private static final class zzd extends zza {
        private final TaskCompletionSource<Void> zzdv;

        zzd(TaskCompletionSource<Void> taskCompletionSource) {
            this.zzdv = taskCompletionSource;
        }

        public final void zzb(int i, String str) {
            if (i == 0 || i == 3003) {
                this.zzdv.setResult(null);
            } else {
                zzf.zzb(this.zzdv, i);
            }
        }
    }

    public boolean requiresSignIn() {
        Games.GamesOptions gamesOptions = this.zzdp;
        return gamesOptions.zzaw != 1 && gamesOptions.zzat == null && !gamesOptions.zzaq;
    }

    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzdm = false;
    }

    public final void zza(View view) {
        this.zzdl.zzb(view);
    }

    public void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super.connect(connectionProgressReportCallbacks);
    }

    public void disconnect() {
        this.zzdm = false;
        if (isConnected()) {
            try {
                this.zzdh.flush();
                ((zzac) getService()).zza(this.zzdn);
            } catch (RemoteException unused) {
                zzz.m4853w("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public Bundle getConnectionHint() {
        try {
            Bundle connectionHint = ((zzac) getService()).getConnectionHint();
            if (connectionHint != null) {
                connectionHint.setClassLoader(zzf.class.getClassLoader());
            }
            return connectionHint;
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzj = this.zzdp.zzj();
        zzj.putString("com.google.android.gms.games.key.gamePackageName", this.zzdi);
        zzj.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzj.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzdl.zzbm()));
        if (!zzj.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            zzj.putInt("com.google.android.gms.games.key.API_VERSION", 8);
        }
        zzj.putBundle("com.google.android.gms.games.key.signInOptions", SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return zzj;
    }

    public final Intent zzaq() {
        try {
            return ((zzac) getService()).zzaq();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzb(TaskCompletionSource<Void> taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzac) getService()).zzb(taskCompletionSource == null ? null : new zzd(taskCompletionSource), str, this.zzdl.zzbm(), this.zzdl.zzbl());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzb(new zzx(signOutCallbacks));
        } catch (RemoteException unused) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    public final void zzb(BaseImplementation$ResultHolder<Status> baseImplementation$ResultHolder) throws RemoteException {
        this.zzdh.flush();
        try {
            ((zzac) getService()).zza((zzy) new zzw(baseImplementation$ResultHolder));
        } catch (SecurityException e) {
            zza(baseImplementation$ResultHolder, e);
        }
    }

    public final void zza(TaskCompletionSource<SnapshotsClient.DataOrConflict<Snapshot>> taskCompletionSource, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzac) getService()).zza((zzy) new zzav(taskCompletionSource), str, z, i);
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zza(TaskCompletionSource<SnapshotMetadata> taskCompletionSource, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zzcl = snapshotMetadataChange.zzcl();
        if (zzcl != null) {
            zzcl.setTempDir(getContext().getCacheDir());
        }
        Contents zzck = snapshotContents.zzck();
        snapshotContents.close();
        try {
            ((zzac) getService()).zza((zzy) new zzg(taskCompletionSource), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzck);
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((zzac) getService()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbd() {
        if (isConnected()) {
            try {
                ((zzac) getService()).zzbd();
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    private static void zza(RemoteException remoteException) {
        zzz.m4854w("GamesGmsClientImpl", "service died", remoteException);
    }

    private static <R> void zza(BaseImplementation$ResultHolder<R> baseImplementation$ResultHolder, SecurityException securityException) {
        if (baseImplementation$ResultHolder != null) {
            baseImplementation$ResultHolder.setFailedResult(GamesClientStatusCodes.zza(4));
        }
    }

    private static <R> void zza(TaskCompletionSource<R> taskCompletionSource, SecurityException securityException) {
        if (taskCompletionSource != null) {
            taskCompletionSource.setException(new ApiException(GamesClientStatusCodes.zza(4)));
        }
    }

    /* access modifiers changed from: private */
    public static <R> void zzb(TaskCompletionSource<R> taskCompletionSource, int i) {
        int i2;
        Status zza = GamesStatusCodes.zza(i);
        int statusCode = zza.getStatusCode();
        if (statusCode == 1) {
            i2 = 8;
        } else if (statusCode == 2) {
            i2 = 26502;
        } else if (statusCode == 3) {
            i2 = 26503;
        } else if (statusCode == 4) {
            i2 = 26504;
        } else if (statusCode == 5) {
            i2 = 26505;
        } else if (statusCode != 6) {
            if (statusCode != 7) {
                if (statusCode == 1500) {
                    i2 = 26540;
                } else if (statusCode != 1501) {
                    switch (statusCode) {
                        case 7:
                            break;
                        case 8:
                            i2 = 26508;
                            break;
                        case 9:
                            i2 = 26509;
                            break;
                        case 500:
                            i2 = 26520;
                            break;
                        case 9000:
                            i2 = 26620;
                            break;
                        case 9001:
                            i2 = 26621;
                            break;
                        case 9002:
                            i2 = 26622;
                            break;
                        case 9003:
                            i2 = 26623;
                            break;
                        case 9004:
                            i2 = 26624;
                            break;
                        case 9006:
                            i2 = 26625;
                            break;
                        case 9009:
                            i2 = 26626;
                            break;
                        case 9010:
                            i2 = 26627;
                            break;
                        case 9011:
                            i2 = 26628;
                            break;
                        case 9012:
                            i2 = 26629;
                            break;
                        case 9016:
                            i2 = 26630;
                            break;
                        case 9017:
                            i2 = 26631;
                            break;
                        case 9018:
                            i2 = 26632;
                            break;
                        case 9200:
                            i2 = 26650;
                            break;
                        case 9202:
                            i2 = 26652;
                            break;
                        case 10000:
                            i2 = 26700;
                            break;
                        case 10001:
                            i2 = 26701;
                            break;
                        case 10002:
                            i2 = 26702;
                            break;
                        case 10003:
                            i2 = 26703;
                            break;
                        case 10004:
                            i2 = 26704;
                            break;
                        default:
                            switch (statusCode) {
                                case 1000:
                                    i2 = 26530;
                                    break;
                                case AdError.NO_FILL_ERROR_CODE:
                                    i2 = 26531;
                                    break;
                                case AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE:
                                    i2 = 26532;
                                    break;
                                case 1003:
                                    i2 = 26533;
                                    break;
                                case 1004:
                                    i2 = 26534;
                                    break;
                                case 1005:
                                    i2 = 26535;
                                    break;
                                case 1006:
                                    i2 = 26536;
                                    break;
                                default:
                                    switch (statusCode) {
                                        case AdError.SERVER_ERROR_CODE:
                                            i2 = 26550;
                                            break;
                                        case AdError.INTERNAL_ERROR_CODE:
                                            i2 = 26551;
                                            break;
                                        case AdError.CACHE_ERROR_CODE:
                                            i2 = 26552;
                                            break;
                                        default:
                                            switch (statusCode) {
                                                case 3000:
                                                    i2 = 26560;
                                                    break;
                                                case AdError.MEDIATION_ERROR_CODE:
                                                    i2 = 26561;
                                                    break;
                                                case 3002:
                                                    i2 = 26562;
                                                    break;
                                                case 3003:
                                                    i2 = 26563;
                                                    break;
                                                default:
                                                    switch (statusCode) {
                                                        case 4000:
                                                            i2 = 26570;
                                                            break;
                                                        case 4001:
                                                            i2 = 26571;
                                                            break;
                                                        case 4002:
                                                            i2 = 26572;
                                                            break;
                                                        case 4003:
                                                            i2 = 26573;
                                                            break;
                                                        case 4004:
                                                            i2 = 26574;
                                                            break;
                                                        case 4005:
                                                            i2 = 26575;
                                                            break;
                                                        case 4006:
                                                            i2 = 26576;
                                                            break;
                                                        default:
                                                            switch (statusCode) {
                                                                case 6000:
                                                                    i2 = 26580;
                                                                    break;
                                                                case AdError.MEDIAVIEW_MISSING_ERROR_CODE:
                                                                    i2 = 26581;
                                                                    break;
                                                                case AdError.ICONVIEW_MISSING_ERROR_CODE:
                                                                    i2 = 26582;
                                                                    break;
                                                                case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE:
                                                                    i2 = 26583;
                                                                    break;
                                                                case 6004:
                                                                    i2 = 26584;
                                                                    break;
                                                                default:
                                                                    switch (statusCode) {
                                                                        case 6500:
                                                                            i2 = 26590;
                                                                            break;
                                                                        case 6501:
                                                                            i2 = 26591;
                                                                            break;
                                                                        case 6502:
                                                                            i2 = 26592;
                                                                            break;
                                                                        case 6503:
                                                                            i2 = 26593;
                                                                            break;
                                                                        case 6504:
                                                                            i2 = 26594;
                                                                            break;
                                                                        case 6505:
                                                                            i2 = 26595;
                                                                            break;
                                                                        case 6506:
                                                                            i2 = 26596;
                                                                            break;
                                                                        case 6507:
                                                                            i2 = 26597;
                                                                            break;
                                                                        default:
                                                                            switch (statusCode) {
                                                                                case 7000:
                                                                                    i2 = 26600;
                                                                                    break;
                                                                                case AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE:
                                                                                    i2 = 26601;
                                                                                    break;
                                                                                case AdError.LOAD_CALLED_WHILE_SHOWING_AD:
                                                                                    i2 = 26602;
                                                                                    break;
                                                                                case AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED:
                                                                                    i2 = 26603;
                                                                                    break;
                                                                                case AdError.INCORRECT_STATE_ERROR:
                                                                                    i2 = 26604;
                                                                                    break;
                                                                                case AdError.MISSING_DEPENDENCIES_ERROR:
                                                                                    i2 = 26605;
                                                                                    break;
                                                                                case AdError.API_NOT_SUPPORTED:
                                                                                    i2 = 26606;
                                                                                    break;
                                                                                case AdError.NATIVE_AD_IS_NOT_LOADED:
                                                                                    i2 = 26607;
                                                                                    break;
                                                                                default:
                                                                                    switch (statusCode) {
                                                                                        case 8000:
                                                                                            i2 = 26610;
                                                                                            break;
                                                                                        case 8001:
                                                                                            i2 = 26611;
                                                                                            break;
                                                                                        case 8002:
                                                                                            i2 = 26612;
                                                                                            break;
                                                                                        case 8003:
                                                                                            i2 = 26613;
                                                                                            break;
                                                                                        default:
                                                                                            i2 = statusCode;
                                                                                            break;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    i2 = 26541;
                }
            }
            i2 = 26507;
        } else {
            i2 = 26506;
        }
        if (i2 != zza.getStatusCode()) {
            if (!GamesStatusCodes.getStatusString(zza.getStatusCode()).equals(zza.getStatusMessage())) {
                switch (statusCode) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                        break;
                    default:
                        zza = new Status(i2, zza.getStatusMessage(), zza.getResolution());
                        break;
                }
            } else {
                zza = GamesClientStatusCodes.zza(i2, zza.getResolution());
            }
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(zza));
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(zzf.class.getClassLoader());
            this.zzdm = bundle.getBoolean("show_welcome_popup");
            PlayerEntity playerEntity = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            GameEntity gameEntity = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    public /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        zzac zzac = (zzac) iInterface;
        super.onConnectedLocked(zzac);
        if (this.zzdm) {
            this.zzdl.zzbo();
            this.zzdm = false;
        }
        Games.GamesOptions gamesOptions = this.zzdp;
        if (!gamesOptions.zzaj && !gamesOptions.zzaq) {
            try {
                zzac.zza((zzaa) new zzr(new zzfi(this.zzdl.zzbn())), this.zzdn);
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (queryLocalInterface instanceof zzac) {
            return (zzac) queryLocalInterface;
        }
        return new zzaf(iBinder);
    }
}
