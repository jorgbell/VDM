package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cc */
public final class C2102cc<T> implements C2103ce, C2100ca {

    /* renamed from: a */
    private static final Object f5201a = new Object();

    /* renamed from: b */
    private volatile C2103ce<T> f5202b;

    /* renamed from: c */
    private volatile Object f5203c = f5201a;

    private C2102cc(C2103ce<T> ceVar) {
        this.f5202b = ceVar;
    }

    /* renamed from: b */
    public static <P extends C2103ce<T>, T> C2103ce<T> m5258b(P p) {
        C2086bh.m5231j(p);
        return p instanceof C2102cc ? p : new C2102cc(p);
    }

    /* renamed from: c */
    public static <P extends C2103ce<T>, T> C2100ca<T> m5259c(P p) {
        if (p instanceof C2100ca) {
            return (C2100ca) p;
        }
        C2086bh.m5231j(p);
        return new C2102cc(p);
    }

    /* renamed from: a */
    public final T mo21822a() {
        T t = this.f5203c;
        T t2 = f5201a;
        if (t == t2) {
            synchronized (this) {
                t = this.f5203c;
                if (t == t2) {
                    t = this.f5202b.mo21822a();
                    T t3 = this.f5203c;
                    if (t3 != t2) {
                        if (t3 != t) {
                            String valueOf = String.valueOf(t3);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f5203c = t;
                    this.f5202b = null;
                }
            }
        }
        return t;
    }
}
