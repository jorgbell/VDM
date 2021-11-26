package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzea implements Runnable {
    /* synthetic */ zzea(zzdz zzdz) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            MessageDigest unused = zzeb.zzc = MessageDigest.getInstance("MD5");
            countDownLatch = zzeb.zzb;
        } catch (NoSuchAlgorithmException unused2) {
            countDownLatch = zzeb.zzb;
        } catch (Throwable th) {
            zzeb.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
