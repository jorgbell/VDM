package com.flurry.sdk;

import android.os.Handler;
import android.os.Looper;
import com.flurry.sdk.C1818h;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.f */
public class C1730f extends C1848i {

    /* renamed from: a */
    private static final ThreadLocal<C1730f> f4338a = new ThreadLocal<>();

    /* renamed from: b */
    private Thread f4339b;

    /* renamed from: com.flurry.sdk.f$a */
    public class C1731a extends C1818h {

        /* renamed from: b */
        private Deque<Runnable> f4341b = new LinkedList();

        /* renamed from: d */
        private int f4342d = 1;

        public final void cleanupTask(Runnable runnable) {
        }

        public C1731a(String str, C1730f fVar) {
            super(str, fVar, true);
        }

        public final void runSync(Runnable runnable) throws CancellationException {
            boolean z;
            synchronized (this) {
                z = this.f4342d == 0;
            }
            if (z) {
                this.target.runSync(runnable);
                return;
            }
            C1818h.C1820a aVar = new C1818h.C1820a(this.target, C1818h.f4549c);
            synchronized (this) {
                this.f4341b.add(aVar);
            }
            while (!aVar.isDone()) {
                try {
                    aVar.get();
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
            if (!wrapRunnable(runnable)) {
                wrapNextRunnable(runnable);
            }
            aVar.f4551b.cleanupTask(aVar);
        }

        public final synchronized Future<Void> runAsync(Runnable runnable) {
            if (this.f4342d == 0) {
                return this.target.runAsync(runnable);
            }
            C17321 r0 = new C1818h.C1820a(this.target, runnable) {
                /* access modifiers changed from: protected */
                public final void done() {
                    this.f4551b.cleanupTask(this);
                }
            };
            this.f4341b.add(r0);
            return r0;
        }

        public final synchronized Future<Void> runAfter(Runnable runnable, long j) {
            return this.target.runAfter(new C1818h.C1820a(this, runnable) {
                /* access modifiers changed from: protected */
                public final void done() {
                    this.f4551b.cleanupTask(this);
                }
            }, j);
        }
    }

    public static C1730f currentActor() {
        return f4338a.get();
    }

    public C1730f(String str, C1818h hVar) {
        super(str, hVar, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runSync(java.lang.Runnable r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Thread r0 = r2.f4339b     // Catch:{ all -> 0x001f }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001f }
            if (r0 != r1) goto L_0x001a
            boolean r0 = r3 instanceof com.flurry.sdk.C1818h.C1820a     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0015
            com.flurry.sdk.h r0 = r2.target     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0018
            r0.runSync(r3)     // Catch:{ all -> 0x001f }
            goto L_0x0018
        L_0x0015:
            r3.run()     // Catch:{ all -> 0x001f }
        L_0x0018:
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            return
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            super.runSync(r3)
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1730f.runSync(java.lang.Runnable):void");
    }

    public Future<Void> runAsync(Runnable runnable) {
        return super.runAsync(runnable);
    }

    /* access modifiers changed from: protected */
    public Future<Void> runAfter(Runnable runnable, long j) {
        return super.runAfter(runnable, j);
    }

    /* access modifiers changed from: protected */
    public boolean wrapRunnable(Runnable runnable) {
        ThreadLocal<C1730f> threadLocal;
        C1730f fVar;
        Thread thread;
        synchronized (this) {
            threadLocal = f4338a;
            fVar = threadLocal.get();
            threadLocal.set(this);
            thread = this.f4339b;
            this.f4339b = Thread.currentThread();
        }
        try {
            wrapNextRunnable(runnable);
            synchronized (this) {
                this.f4339b = thread;
                threadLocal.set(fVar);
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                this.f4339b = thread;
                f4338a.set(fVar);
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void flush(Runnable runnable) {
        if (Thread.currentThread() == this.f4339b) {
            runnable.run();
        }
    }

    /* access modifiers changed from: protected */
    public C1731a createDeferredQueue(String str) {
        return new C1731a(str, this);
    }

    /* access modifiers changed from: protected */
    public void postOnMainThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
