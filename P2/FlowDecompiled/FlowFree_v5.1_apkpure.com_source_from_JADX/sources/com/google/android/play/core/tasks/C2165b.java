package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.b */
final class C2165b<ResultT> implements C2170g<ResultT> {

    /* renamed from: a */
    private final Executor f5302a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f5303b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnCompleteListener<ResultT> f5304c;

    public C2165b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f5302a = executor;
        this.f5304c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo22187a(Task<ResultT> task) {
        synchronized (this.f5303b) {
            if (this.f5304c != null) {
                this.f5302a.execute(new C2164a(this, task));
            }
        }
    }
}
