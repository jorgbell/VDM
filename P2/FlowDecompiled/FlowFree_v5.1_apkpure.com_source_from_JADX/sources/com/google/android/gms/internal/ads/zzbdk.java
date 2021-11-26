package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbdk implements Runnable {
    zzbdk(zzbdm zzbdm) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
