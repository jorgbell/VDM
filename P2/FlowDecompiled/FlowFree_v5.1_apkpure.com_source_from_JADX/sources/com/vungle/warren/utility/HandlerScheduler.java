package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public class HandlerScheduler implements Scheduler {
    private Handler handler = new Handler(Looper.getMainLooper());

    private long calculateTime(long j) {
        return SystemClock.uptimeMillis() + j;
    }

    public void schedule(Runnable runnable, long j) {
        this.handler.postAtTime(runnable, calculateTime(j));
    }

    public void cancelAll() {
        this.handler.removeCallbacksAndMessages((Object) null);
    }
}
