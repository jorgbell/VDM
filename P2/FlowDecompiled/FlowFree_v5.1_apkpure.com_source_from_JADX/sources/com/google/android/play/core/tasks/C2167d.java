package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.d */
final class C2167d<ResultT> implements C2170g<ResultT> {

    /* renamed from: a */
    private final Executor f5307a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f5308b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnFailureListener f5309c;

    public C2167d(Executor executor, OnFailureListener onFailureListener) {
        this.f5307a = executor;
        this.f5309c = onFailureListener;
    }

    /* renamed from: a */
    public final void mo22187a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.f5308b) {
                if (this.f5309c != null) {
                    this.f5307a.execute(new C2166c(this, task));
                }
            }
        }
    }
}
