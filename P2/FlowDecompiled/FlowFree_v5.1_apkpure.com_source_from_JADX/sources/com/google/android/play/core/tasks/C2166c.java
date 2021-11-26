package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.c */
final class C2166c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f5305a;

    /* renamed from: b */
    final /* synthetic */ C2167d f5306b;

    C2166c(C2167d dVar, Task task) {
        this.f5306b = dVar;
        this.f5305a = task;
    }

    public final void run() {
        synchronized (this.f5306b.f5308b) {
            if (this.f5306b.f5309c != null) {
                this.f5306b.f5309c.onFailure(this.f5305a.getException());
            }
        }
    }
}
