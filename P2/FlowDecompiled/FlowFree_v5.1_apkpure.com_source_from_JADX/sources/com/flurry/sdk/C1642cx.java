package com.flurry.sdk;

import com.flurry.sdk.C1703ec;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.flurry.sdk.cx */
public class C1642cx<T extends C1703ec> {

    /* renamed from: a */
    final HashMap<T, Future<?>> f4145a = new HashMap<>();

    /* renamed from: b */
    private final C1639cu<Object, T> f4146b = new C1639cu<>();

    /* renamed from: c */
    private final HashMap<T, Object> f4147c = new HashMap<>();

    /* renamed from: d */
    private final ThreadPoolExecutor f4148d;

    public C1642cx(String str, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        C16431 r0 = new ThreadPoolExecutor(timeUnit, blockingQueue) {
            /* access modifiers changed from: protected */
            public final void beforeExecute(Thread thread, Runnable runnable) {
                super.beforeExecute(thread, runnable);
                final C1703ec a = C1642cx.m4307a(runnable);
                if (a != null) {
                    new C1702eb() {
                        /* renamed from: a */
                        public final void mo11257a() {
                        }
                    }.run();
                }
            }

            /* access modifiers changed from: protected */
            public final void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                final C1703ec a = C1642cx.m4307a(runnable);
                if (a != null) {
                    synchronized (C1642cx.this.f4145a) {
                        C1642cx.this.f4145a.remove(a);
                    }
                    C1642cx.this.mo11423a(a);
                    new C1702eb() {
                        /* renamed from: a */
                        public final void mo11257a() {
                        }
                    }.run();
                }
            }

            /* access modifiers changed from: protected */
            public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
                C1641cw cwVar = new C1641cw(runnable, v);
                synchronized (C1642cx.this.f4145a) {
                    C1642cx.this.f4145a.put((C1703ec) runnable, cwVar);
                }
                return cwVar;
            }

            /* access modifiers changed from: protected */
            public final <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
                throw new UnsupportedOperationException("Callable not supported");
            }
        };
        this.f4148d = r0;
        r0.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy() {
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                final C1703ec a = C1642cx.m4307a(runnable);
                if (a != null) {
                    synchronized (C1642cx.this.f4145a) {
                        C1642cx.this.f4145a.remove(a);
                    }
                    C1642cx.this.mo11423a(a);
                    new C1702eb() {
                        /* renamed from: a */
                        public final void mo11257a() {
                        }
                    }.run();
                }
            }
        });
        r0.setThreadFactory(new C1694dw(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo11423a(T t) {
        m4308b(this.f4147c.get(t), t);
    }

    /* renamed from: b */
    private synchronized void m4308b(Object obj, T t) {
        List<T> a;
        C1639cu<Object, T> cuVar = this.f4146b;
        if (!(obj == null || (a = cuVar.mo11419a(obj, false)) == null)) {
            a.remove(t);
            if (a.size() == 0) {
                cuVar.f4141a.remove(obj);
            }
        }
        this.f4147c.remove(t);
    }

    /* renamed from: a */
    public final synchronized void mo11424a(Object obj, T t) {
        if (obj != null) {
            m4309c(obj, t);
            this.f4148d.submit(t);
        }
    }

    /* renamed from: c */
    private synchronized void m4309c(Object obj, T t) {
        this.f4146b.mo11420a(obj, t);
        this.f4147c.put(t, obj);
    }

    /* renamed from: a */
    static /* synthetic */ C1703ec m4307a(Runnable runnable) {
        if (runnable instanceof C1641cw) {
            return (C1703ec) ((C1641cw) runnable).mo11422a();
        }
        if (runnable instanceof C1703ec) {
            return (C1703ec) runnable;
        }
        C1648cy.m4317a(6, "TrackedThreadPoolExecutor", "Unknown runnable class: " + runnable.getClass().getName());
        return null;
    }
}
