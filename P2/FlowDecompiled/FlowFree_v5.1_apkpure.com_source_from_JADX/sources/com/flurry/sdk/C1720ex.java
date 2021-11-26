package com.flurry.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.flurry.sdk.ex */
public final class C1720ex {

    /* renamed from: a */
    private static final Map<C1722a, C1699e> f4317a;

    /* renamed from: com.flurry.sdk.ex$a */
    public enum C1722a {
        CORE,
        DATA_PROCESSOR,
        PROVIDER,
        PUBLIC_API,
        REPORTS,
        CONFIG,
        MISC
    }

    static {
        Executor executor;
        HashMap hashMap = new HashMap();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (C1722a aVar : C1722a.values()) {
            String name = aVar.name();
            int i = C17211.f4318a[aVar.ordinal()];
            if (i == 1) {
                executor = m4479a();
            } else if (i == 2) {
                executor = m4480a(availableProcessors);
            } else if (i == 3) {
                executor = m4479a();
            } else if (i == 4) {
                executor = m4480a(availableProcessors);
            } else if (i != 5) {
                executor = m4479a();
            } else {
                executor = m4479a();
            }
            hashMap.put(aVar, new C1699e(executor, name));
        }
        f4317a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: com.flurry.sdk.ex$1 */
    static /* synthetic */ class C17211 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4318a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flurry.sdk.ex$a[] r0 = com.flurry.sdk.C1720ex.C1722a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4318a = r0
                com.flurry.sdk.ex$a r1 = com.flurry.sdk.C1720ex.C1722a.PUBLIC_API     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4318a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flurry.sdk.ex$a r1 = com.flurry.sdk.C1720ex.C1722a.CORE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4318a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flurry.sdk.ex$a r1 = com.flurry.sdk.C1720ex.C1722a.DATA_PROCESSOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4318a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flurry.sdk.ex$a r1 = com.flurry.sdk.C1720ex.C1722a.PROVIDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4318a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flurry.sdk.ex$a r1 = com.flurry.sdk.C1720ex.C1722a.CONFIG     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1720ex.C17211.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static synchronized C1699e m4478a(C1722a aVar) {
        C1699e eVar;
        synchronized (C1720ex.class) {
            eVar = f4317a.get(aVar);
        }
        return eVar;
    }

    /* renamed from: a */
    private static Executor m4480a(int i) {
        return new ThreadPoolExecutor(0, i, 6, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1724c(), new C1723b((byte) 0));
    }

    /* renamed from: a */
    private static Executor m4479a() {
        return new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1724c(), new C1723b((byte) 0));
    }

    /* renamed from: com.flurry.sdk.ex$b */
    static class C1723b implements RejectedExecutionHandler {
        private C1723b() {
        }

        /* synthetic */ C1723b(byte b) {
            this();
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            C1648cy.m4317a(6, "ActorFactory", runnable.toString() + "is rejected");
        }
    }

    /* renamed from: com.flurry.sdk.ex$c */
    static class C1724c implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f4327a = new AtomicInteger(0);

        /* renamed from: b */
        private final String f4328b = "Flurry #";

        C1724c() {
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4328b + this.f4327a.incrementAndGet());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(10);
            return thread;
        }
    }
}
