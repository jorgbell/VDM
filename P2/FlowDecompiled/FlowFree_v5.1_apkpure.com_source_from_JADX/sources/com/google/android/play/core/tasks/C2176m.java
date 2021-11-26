package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C2075ax;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.m */
final class C2176m<ResultT> extends Task<ResultT> {

    /* renamed from: a */
    private final Object f5320a = new Object();

    /* renamed from: b */
    private final C2171h<ResultT> f5321b = new C2171h<>();

    /* renamed from: c */
    private boolean f5322c;

    /* renamed from: d */
    private ResultT f5323d;

    /* renamed from: e */
    private Exception f5324e;

    C2176m() {
    }

    /* renamed from: e */
    private final void m5451e() {
        C2075ax.m5193c(this.f5322c, "Task is not yet complete");
    }

    /* renamed from: f */
    private final void m5452f() {
        C2075ax.m5193c(!this.f5322c, "Task is already complete");
    }

    /* renamed from: g */
    private final void m5453g() {
        synchronized (this.f5320a) {
            if (this.f5322c) {
                this.f5321b.mo22191b(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo22199a(ResultT resultt) {
        synchronized (this.f5320a) {
            m5452f();
            this.f5322c = true;
            this.f5323d = resultt;
        }
        this.f5321b.mo22191b(this);
    }

    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.f5321b.mo22190a(new C2165b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        m5453g();
        return this;
    }

    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f5321b.mo22190a(new C2167d(executor, onFailureListener));
        m5453g();
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f5321b.mo22190a(new C2169f(executor, onSuccessListener));
        m5453g();
        return this;
    }

    /* renamed from: b */
    public final boolean mo22200b(ResultT resultt) {
        synchronized (this.f5320a) {
            if (this.f5322c) {
                return false;
            }
            this.f5322c = true;
            this.f5323d = resultt;
            this.f5321b.mo22191b(this);
            return true;
        }
    }

    /* renamed from: c */
    public final void mo22201c(Exception exc) {
        synchronized (this.f5320a) {
            m5452f();
            this.f5322c = true;
            this.f5324e = exc;
        }
        this.f5321b.mo22191b(this);
    }

    /* renamed from: d */
    public final boolean mo22202d(Exception exc) {
        synchronized (this.f5320a) {
            if (this.f5322c) {
                return false;
            }
            this.f5322c = true;
            this.f5324e = exc;
            this.f5321b.mo22191b(this);
            return true;
        }
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.f5320a) {
            exc = this.f5324e;
        }
        return exc;
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f5320a) {
            m5451e();
            Exception exc = this.f5324e;
            if (exc == null) {
                resultt = this.f5323d;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return resultt;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f5320a) {
            z = this.f5322c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f5320a) {
            z = false;
            if (this.f5322c && this.f5324e == null) {
                z = true;
            }
        }
        return z;
    }
}
