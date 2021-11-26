package com.flurry.sdk;

import com.flurry.sdk.C1720ex;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.m */
public class C1907m<T> extends C1730f {
    protected Set<C1914o<T>> observers;

    public void refresh() {
    }

    public void start() {
    }

    protected C1907m(String str) {
        super(str, C1720ex.m4478a(C1720ex.C1722a.PROVIDER));
        this.observers = null;
        this.observers = new HashSet();
    }

    public void subscribe(final C1914o<T> oVar) {
        if (oVar != null) {
            runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() {
                    C1907m.this.observers.add(oVar);
                }
            });
        }
    }

    public void unsubscribe(final C1914o<T> oVar) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1907m.this.observers.remove(oVar);
            }
        });
    }

    public void destroy() {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1907m.this.observers.clear();
            }
        });
    }

    public void notifyObservers(final T t) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                for (final C1914o next : C1907m.this.observers) {
                    Future unused = C1907m.this.runAsync(new C1702eb() {
                        /* renamed from: a */
                        public final void mo11257a() {
                            next.mo11263a(t);
                        }
                    });
                }
            }
        });
    }
}
