package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.e */
final class C2168e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f5310a;

    /* renamed from: b */
    final /* synthetic */ C2169f f5311b;

    C2168e(C2169f fVar, Task task) {
        this.f5311b = fVar;
        this.f5310a = task;
    }

    public final void run() {
        synchronized (this.f5311b.f5313b) {
            if (this.f5311b.f5314c != null) {
                this.f5311b.f5314c.onSuccess(this.f5310a.getResult());
            }
        }
    }
}
