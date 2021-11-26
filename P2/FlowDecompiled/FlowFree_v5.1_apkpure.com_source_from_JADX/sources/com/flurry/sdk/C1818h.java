package com.flurry.sdk;

import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* renamed from: com.flurry.sdk.h */
public abstract class C1818h {

    /* renamed from: c */
    static Runnable f4549c = new Runnable() {
        public final void run() {
        }
    };
    protected final boolean concurrent;
    protected final String description;
    protected final boolean syncFlush;
    protected final C1818h target;

    /* access modifiers changed from: protected */
    public abstract void cleanupTask(Runnable runnable);

    /* access modifiers changed from: protected */
    public void flush(Runnable runnable) {
    }

    /* access modifiers changed from: protected */
    public abstract Future<Void> runAfter(Runnable runnable, long j);

    /* access modifiers changed from: protected */
    public abstract Future<Void> runAsync(Runnable runnable);

    /* access modifiers changed from: protected */
    public abstract void runSync(Runnable runnable) throws CancellationException;

    /* access modifiers changed from: protected */
    public boolean wrapRunnable(Runnable runnable) {
        return false;
    }

    /* renamed from: com.flurry.sdk.h$a */
    public class C1820a extends FutureTask<Void> {

        /* renamed from: a */
        private TimerTask f4550a;

        /* renamed from: b */
        public final C1818h f4551b;

        /* renamed from: d */
        private final int f4553d = 0;

        /* renamed from: e */
        private final int f4554e = 1;

        /* renamed from: f */
        private final int f4555f = 2;

        /* renamed from: g */
        private int f4556g;

        C1820a(C1818h hVar, Runnable runnable) {
            super(runnable, (Object) null);
            this.f4551b = hVar;
            if (runnable == C1818h.f4549c) {
                this.f4556g = 0;
            } else {
                this.f4556g = 1;
            }
        }

        /* renamed from: a */
        public final synchronized boolean mo11547a() {
            return this.f4556g == 0;
        }

        public synchronized boolean cancel(boolean z) {
            super.cancel(z);
            TimerTask timerTask = this.f4550a;
            if (timerTask != null) {
                timerTask.cancel();
            }
            return true;
        }

        /* renamed from: a */
        public final synchronized void mo11546a(TimerTask timerTask) {
            if (!isDone()) {
                this.f4550a = timerTask;
            } else {
                this.f4550a.cancel();
            }
        }

        public synchronized void run() {
            if (this.f4556g == 1) {
                this.f4556g = 2;
                if (!this.f4551b.wrapRunnable(this)) {
                    this.f4551b.wrapNextRunnable(this);
                }
                this.f4556g = 1;
                return;
            }
            super.run();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    C1818h(String str, C1818h hVar, boolean z) {
        this(str, hVar, z, hVar == null ? false : hVar.syncFlush);
    }

    private C1818h(String str, C1818h hVar, boolean z, boolean z2) {
        this.description = str;
        this.target = hVar;
        this.concurrent = z;
        this.syncFlush = z2;
    }

    /* access modifiers changed from: protected */
    public final boolean wrapNextRunnable(Runnable runnable) {
        for (C1818h hVar = this.target; hVar != null; hVar = hVar.target) {
            if (hVar.wrapRunnable(runnable)) {
                return true;
            }
        }
        runnable.run();
        return true;
    }
}
