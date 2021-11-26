package com.flurry.sdk;

import com.flurry.sdk.C1818h;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.i */
public class C1848i extends C1818h {

    /* renamed from: a */
    private final Deque<C1818h.C1820a> f4582a = new LinkedList();

    /* renamed from: b */
    private C1818h.C1820a f4583b;

    /* access modifiers changed from: protected */
    public boolean wrapRunnable(Runnable runnable) {
        return false;
    }

    C1848i(String str, C1818h hVar, boolean z) {
        super(str, hVar, z);
    }

    /* access modifiers changed from: protected */
    public void runSync(Runnable runnable) throws CancellationException {
        C1818h.C1820a aVar = new C1818h.C1820a(this, C1818h.f4549c);
        synchronized (this) {
            this.f4582a.add(aVar);
            mo11264a();
        }
        if (this.syncFlush) {
            for (C1818h hVar = this.target; hVar != null; hVar = hVar.target) {
                hVar.flush(aVar);
            }
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
        cleanupTask(aVar);
    }

    /* access modifiers changed from: protected */
    public Future<Void> runAsync(Runnable runnable) {
        C1818h.C1820a aVar;
        if (runnable instanceof C1818h.C1820a) {
            aVar = (C1818h.C1820a) runnable;
        } else {
            aVar = new C1818h.C1820a(this, this, runnable) {
                {
                    r2.getClass();
                }

                /* access modifiers changed from: protected */
                public final void done() {
                    this.f4551b.cleanupTask(this);
                }
            };
        }
        synchronized (this) {
            this.f4582a.add(aVar);
            mo11264a();
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public Future<Void> runAfter(Runnable runnable, long j) {
        C1818h.C1820a aVar;
        if (runnable instanceof C1818h.C1820a) {
            aVar = (C1818h.C1820a) runnable;
        } else {
            aVar = new C1818h.C1820a(this, this, runnable) {
                {
                    r2.getClass();
                }

                /* access modifiers changed from: protected */
                public final void done() {
                    this.f4551b.cleanupTask(this);
                }
            };
        }
        C1818h hVar = this.target;
        if (hVar != null) {
            hVar.runAfter(aVar, j);
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public boolean onActive(C1818h.C1820a aVar) {
        C1818h hVar = this.target;
        if (hVar == null) {
            return true;
        }
        hVar.runAsync(aVar);
        return true;
    }

    /* access modifiers changed from: protected */
    public void cleanupTask(Runnable runnable) {
        synchronized (this) {
            if (this.f4583b == runnable) {
                this.f4583b = null;
            }
        }
        mo11264a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void mo11264a() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.concurrent     // Catch:{ all -> 0x0058 }
            r1 = 0
            if (r0 == 0) goto L_0x002d
        L_0x0006:
            java.util.Deque<com.flurry.sdk.h$a> r0 = r3.f4582a     // Catch:{ all -> 0x0058 }
            int r0 = r0.size()     // Catch:{ all -> 0x0058 }
            if (r0 <= 0) goto L_0x0056
            java.util.Deque<com.flurry.sdk.h$a> r0 = r3.f4582a     // Catch:{ all -> 0x0058 }
            java.lang.Object r0 = r0.remove()     // Catch:{ all -> 0x0058 }
            com.flurry.sdk.h$a r0 = (com.flurry.sdk.C1818h.C1820a) r0     // Catch:{ all -> 0x0058 }
            boolean r2 = r0.isDone()     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0006
            r3.f4583b = r0     // Catch:{ all -> 0x0058 }
            boolean r2 = r3.onActive(r0)     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0006
            r3.f4583b = r1     // Catch:{ all -> 0x0058 }
            java.util.Deque<com.flurry.sdk.h$a> r1 = r3.f4582a     // Catch:{ all -> 0x0058 }
            r1.addFirst(r0)     // Catch:{ all -> 0x0058 }
            monitor-exit(r3)
            return
        L_0x002d:
            com.flurry.sdk.h$a r0 = r3.f4583b     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x0056
            java.util.Deque<com.flurry.sdk.h$a> r0 = r3.f4582a     // Catch:{ all -> 0x0058 }
            int r0 = r0.size()     // Catch:{ all -> 0x0058 }
            if (r0 <= 0) goto L_0x0056
            java.util.Deque<com.flurry.sdk.h$a> r0 = r3.f4582a     // Catch:{ all -> 0x0058 }
            java.lang.Object r0 = r0.remove()     // Catch:{ all -> 0x0058 }
            com.flurry.sdk.h$a r0 = (com.flurry.sdk.C1818h.C1820a) r0     // Catch:{ all -> 0x0058 }
            boolean r2 = r0.isDone()     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0056
            r3.f4583b = r0     // Catch:{ all -> 0x0058 }
            boolean r2 = r3.onActive(r0)     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0056
            r3.f4583b = r1     // Catch:{ all -> 0x0058 }
            java.util.Deque<com.flurry.sdk.h$a> r1 = r3.f4582a     // Catch:{ all -> 0x0058 }
            r1.addFirst(r0)     // Catch:{ all -> 0x0058 }
        L_0x0056:
            monitor-exit(r3)
            return
        L_0x0058:
            r0 = move-exception
            monitor-exit(r3)
            goto L_0x005c
        L_0x005b:
            throw r0
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1848i.mo11264a():void");
    }
}
