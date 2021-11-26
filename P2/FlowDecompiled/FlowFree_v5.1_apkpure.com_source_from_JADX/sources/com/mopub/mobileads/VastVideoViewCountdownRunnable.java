package com.mopub.mobileads;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastVideoViewCountdownRunnable.kt */
public class VastVideoViewCountdownRunnable extends RepeatingHandlerRunnable {
    private final VastVideoViewController videoViewController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VastVideoViewCountdownRunnable(VastVideoViewController vastVideoViewController, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(vastVideoViewController, "videoViewController");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.videoViewController = vastVideoViewController;
    }

    public void doWork() {
        VastVideoViewController.updateCountdown$default(this.videoViewController, false, 1, (Object) null);
    }
}
