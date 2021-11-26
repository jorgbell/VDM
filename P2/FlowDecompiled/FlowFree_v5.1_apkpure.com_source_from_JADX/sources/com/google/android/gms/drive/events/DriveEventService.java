package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.drive.zzet;
import com.google.android.gms.internal.drive.zzfp;
import com.google.android.gms.internal.drive.zzir;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class DriveEventService extends Service {
    /* access modifiers changed from: private */
    public static final GmsLogger zzbz = new GmsLogger("DriveEventService", "");
    private final String name;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public CountDownLatch zzcj;
    @GuardedBy("this")
    zza zzck;
    @GuardedBy("this")
    boolean zzcl;
    private int zzcm;

    final class zzb extends zzet {
        private zzb() {
        }

        public final void zzc(zzfp zzfp) throws RemoteException {
            synchronized (DriveEventService.this) {
                DriveEventService.this.zzw();
                zza zza = DriveEventService.this.zzck;
                if (zza != null) {
                    DriveEventService.this.zzck.sendMessage(zza.zzb(zzfp));
                } else {
                    DriveEventService.zzbz.mo13337e("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }

        /* synthetic */ zzb(DriveEventService driveEventService, zzh zzh) {
            this();
        }
    }

    protected DriveEventService(String str) {
        this.zzcl = false;
        this.zzcm = -1;
        this.name = str;
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    static final class zza extends zzir {
        private final WeakReference<DriveEventService> zzcp;

        private zza(DriveEventService driveEventService) {
            this.zzcp = new WeakReference<>(driveEventService);
        }

        /* access modifiers changed from: private */
        public final Message zzb(zzfp zzfp) {
            return obtainMessage(1, zzfp);
        }

        /* access modifiers changed from: private */
        public final Message zzy() {
            return obtainMessage(2);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DriveEventService driveEventService = (DriveEventService) this.zzcp.get();
                if (driveEventService != null) {
                    driveEventService.zza((zzfp) message.obj);
                } else {
                    getLooper().quit();
                }
            } else if (i != 2) {
                DriveEventService.zzbz.wfmt("DriveEventService", "Unexpected message type: %s", Integer.valueOf(message.what));
            } else {
                getLooper().quit();
            }
        }

        /* synthetic */ zza(DriveEventService driveEventService, zzh zzh) {
            this(driveEventService);
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (!"com.google.android.gms.drive.events.HANDLE_EVENT".equals(intent.getAction())) {
            return null;
        }
        if (this.zzck == null && !this.zzcl) {
            this.zzcl = true;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzcj = new CountDownLatch(1);
            new zzh(this, countDownLatch).start();
            try {
                if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                    zzbz.mo13337e("DriveEventService", "Failed to synchronously initialize event handler.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Unable to start event handler", e);
            }
        }
        zzb zzb2 = new zzb(this, (zzh) null);
        zzb2.asBinder();
        return zzb2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|6|(1:8)|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDestroy() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.drive.events.DriveEventService$zza r0 = r5.zzck     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0028
            android.os.Message r0 = r0.zzy()     // Catch:{ all -> 0x002d }
            com.google.android.gms.drive.events.DriveEventService$zza r1 = r5.zzck     // Catch:{ all -> 0x002d }
            r1.sendMessage(r0)     // Catch:{ all -> 0x002d }
            r0 = 0
            r5.zzck = r0     // Catch:{ all -> 0x002d }
            java.util.concurrent.CountDownLatch r1 = r5.zzcj     // Catch:{ InterruptedException -> 0x0026 }
            r2 = 5000(0x1388, double:2.4703E-320)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0026 }
            boolean r1 = r1.await(r2, r4)     // Catch:{ InterruptedException -> 0x0026 }
            if (r1 != 0) goto L_0x0026
            com.google.android.gms.common.internal.GmsLogger r1 = zzbz     // Catch:{ InterruptedException -> 0x0026 }
            java.lang.String r2 = "DriveEventService"
            java.lang.String r3 = "Failed to synchronously quit event handler. Will quit itself"
            r1.mo13340w(r2, r3)     // Catch:{ InterruptedException -> 0x0026 }
        L_0x0026:
            r5.zzcj = r0     // Catch:{ all -> 0x002d }
        L_0x0028:
            super.onDestroy()     // Catch:{ all -> 0x002d }
            monitor-exit(r5)
            return
        L_0x002d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.events.DriveEventService.onDestroy():void");
    }

    public void onChange(ChangeEvent changeEvent) {
        zzbz.wfmt("DriveEventService", "Unhandled change event in %s: %s", this.name, changeEvent);
    }

    public final void zza(zzb zzb2) {
        zzbz.wfmt("DriveEventService", "Unhandled changes available event in %s: %s", this.name, zzb2);
    }

    public void onCompletion(CompletionEvent completionEvent) {
        zzbz.wfmt("DriveEventService", "Unhandled completion event in %s: %s", this.name, completionEvent);
    }

    /* access modifiers changed from: protected */
    public int getCallingUid() {
        return Binder.getCallingUid();
    }

    /* access modifiers changed from: private */
    public final void zza(zzfp zzfp) {
        DriveEvent zzat = zzfp.zzat();
        try {
            int type = zzat.getType();
            if (type == 1) {
                onChange((ChangeEvent) zzat);
            } else if (type == 2) {
                onCompletion((CompletionEvent) zzat);
            } else if (type == 4) {
                zza((zzb) zzat);
            } else if (type != 7) {
                zzbz.wfmt("DriveEventService", "Unhandled event: %s", zzat);
            } else {
                zzbz.wfmt("DriveEventService", "Unhandled transfer state event in %s: %s", this.name, (zzv) zzat);
            }
        } catch (Exception e) {
            zzbz.mo13338e("DriveEventService", String.format("Error handling event in %s", new Object[]{this.name}), e);
        }
    }

    /* access modifiers changed from: private */
    public final void zzw() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzcm) {
            if (UidVerifier.isGooglePlayServicesUid(this, callingUid)) {
                this.zzcm = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }
}
