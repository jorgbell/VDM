package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.a */
final class C2164a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f5300a;

    /* renamed from: b */
    final /* synthetic */ C2165b f5301b;

    C2164a(C2165b bVar, Task task) {
        this.f5301b = bVar;
        this.f5300a = task;
    }

    public final void run() {
        synchronized (this.f5301b.f5303b) {
            if (this.f5301b.f5304c != null) {
                this.f5301b.f5304c.onComplete(this.f5300a);
            }
        }
    }
}
