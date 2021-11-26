package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastVideoViewController.kt */
final class VastVideoViewController$$special$$inlined$also$lambda$3 implements View.OnTouchListener {
    final /* synthetic */ VastVideoViewController this$0;

    VastVideoViewController$$special$$inlined$also$lambda$3(VastVideoViewController vastVideoViewController) {
        this.this$0 = vastVideoViewController;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        if (motionEvent.getAction() != 1) {
            return true;
        }
        VastVideoViewController vastVideoViewController = this.this$0;
        vastVideoViewController.setClosing(vastVideoViewController.isComplete());
        this.this$0.handleExitTrackers();
        this.this$0.getBaseVideoViewControllerListener().onVideoFinish(this.this$0.getCurrentPosition());
        return true;
    }
}
