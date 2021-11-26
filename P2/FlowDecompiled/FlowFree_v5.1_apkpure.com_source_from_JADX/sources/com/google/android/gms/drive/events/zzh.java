package com.google.android.gms.drive.events;

import android.os.Looper;
import com.google.android.gms.drive.events.DriveEventService;
import java.util.concurrent.CountDownLatch;

final class zzh extends Thread {
    private final /* synthetic */ CountDownLatch zzcn;
    private final /* synthetic */ DriveEventService zzco;

    zzh(DriveEventService driveEventService, CountDownLatch countDownLatch) {
        this.zzco = driveEventService;
        this.zzcn = countDownLatch;
    }

    public final void run() {
        try {
            Looper.prepare();
            this.zzco.zzck = new DriveEventService.zza(this.zzco, (zzh) null);
            this.zzco.zzcl = false;
            this.zzcn.countDown();
            Looper.loop();
        } finally {
            if (this.zzco.zzcj != null) {
                this.zzco.zzcj.countDown();
            }
        }
    }
}
