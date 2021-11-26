package com.vungle.warren.utility;

public interface Scheduler {
    void cancelAll();

    void schedule(Runnable runnable, long j);
}
