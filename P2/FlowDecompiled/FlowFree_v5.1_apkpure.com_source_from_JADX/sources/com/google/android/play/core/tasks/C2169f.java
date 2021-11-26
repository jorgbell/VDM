package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.f */
final class C2169f<ResultT> implements C2170g<ResultT> {

    /* renamed from: a */
    private final Executor f5312a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f5313b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnSuccessListener<? super ResultT> f5314c;

    public C2169f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f5312a = executor;
        this.f5314c = onSuccessListener;
    }

    /* renamed from: a */
    public final void mo22187a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.f5313b) {
                if (this.f5314c != null) {
                    this.f5312a.execute(new C2168e(this, task));
                }
            }
        }
    }
}
