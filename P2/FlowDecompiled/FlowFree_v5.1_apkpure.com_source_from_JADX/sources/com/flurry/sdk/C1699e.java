package com.flurry.sdk;

import com.flurry.sdk.C1818h;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.e */
public final class C1699e extends C1783g {

    /* renamed from: b */
    private static Timer f4292b = new Timer("ExecutorQueue Global Timer", true);

    /* renamed from: a */
    Executor f4293a;

    public C1699e(Executor executor, String str) {
        super(str);
        this.f4293a = executor;
    }

    public final Future<Void> runAfter(Runnable runnable, long j) {
        final C1818h.C1820a aVar;
        if (runnable instanceof C1818h.C1820a) {
            aVar = (C1818h.C1820a) runnable;
        } else {
            aVar = new C1818h.C1820a(this, runnable);
        }
        C17001 r0 = new TimerTask() {
            public final void run() {
                C1818h.C1820a aVar = aVar;
                aVar.f4551b.runAsync(aVar);
            }
        };
        aVar.mo11546a(r0);
        f4292b.schedule(r0, j);
        return aVar;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean onActive(com.flurry.sdk.C1818h.C1820a r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r2.mo11547a()     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            if (r0 == 0) goto L_0x000b
            r2.run()     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            goto L_0x0010
        L_0x000b:
            java.util.concurrent.Executor r0 = r1.f4293a     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r0.execute(r2)     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
        L_0x0010:
            r2 = 1
            monitor-exit(r1)
            return r2
        L_0x0013:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0016:
            r2 = 0
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1699e.onActive(com.flurry.sdk.h$a):boolean");
    }
}
