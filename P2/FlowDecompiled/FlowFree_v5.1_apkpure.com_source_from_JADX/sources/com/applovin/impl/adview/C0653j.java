package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.applovin.impl.adview.j */
public final class C0653j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1107r f549a;

    /* renamed from: b */
    private final Handler f550b;

    /* renamed from: c */
    private final Set<C0656b> f551c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AtomicInteger f552d = new AtomicInteger();

    /* renamed from: com.applovin.impl.adview.j$a */
    public interface C0655a {
        /* renamed from: a */
        void mo8020a();

        /* renamed from: b */
        boolean mo8021b();
    }

    /* renamed from: com.applovin.impl.adview.j$b */
    private static class C0656b {

        /* renamed from: a */
        private final String f556a;

        /* renamed from: b */
        private final C0655a f557b;

        /* renamed from: c */
        private final long f558c;

        private C0656b(String str, long j, C0655a aVar) {
            this.f556a = str;
            this.f558c = j;
            this.f557b = aVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m636a() {
            return this.f556a;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public long m638b() {
            return this.f558c;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public C0655a m641c() {
            return this.f557b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0656b)) {
                return false;
            }
            String str = this.f556a;
            String str2 = ((C0656b) obj).f556a;
            return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.f556a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.f556a + '\'' + ", countdownStepMillis=" + this.f558c + '}';
        }
    }

    public C0653j(Handler handler, C1062k kVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (kVar != null) {
            this.f550b = handler;
            this.f549a = kVar.mo9411z();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m627a(final C0656b bVar, final int i) {
        this.f550b.postDelayed(new Runnable() {
            public void run() {
                C0655a b = bVar.m641c();
                if (!b.mo8021b()) {
                    C1107r b2 = C0653j.this.f549a;
                    b2.mo9584b("CountdownManager", "Ending countdown for " + bVar.m636a());
                } else if (C0653j.this.f552d.get() == i) {
                    try {
                        b.mo8020a();
                    } catch (Throwable th) {
                        C1107r b3 = C0653j.this.f549a;
                        b3.mo9585b("CountdownManager", "Encountered error on countdown step for: " + bVar.m636a(), th);
                    }
                    C0653j.this.m627a(bVar, i);
                } else {
                    C1107r b4 = C0653j.this.f549a;
                    b4.mo9587d("CountdownManager", "Killing duplicate countdown from previous generation: " + bVar.m636a());
                }
            }
        }, bVar.m638b());
    }

    /* renamed from: a */
    public void mo8194a() {
        HashSet<C0656b> hashSet = new HashSet<>(this.f551c);
        C1107r rVar = this.f549a;
        rVar.mo9584b("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        int incrementAndGet = this.f552d.incrementAndGet();
        for (C0656b bVar : hashSet) {
            C1107r rVar2 = this.f549a;
            rVar2.mo9584b("CountdownManager", "Starting countdown: " + bVar.m636a() + " for generation " + incrementAndGet + "...");
            m627a(bVar, incrementAndGet);
        }
    }

    /* renamed from: a */
    public void mo8195a(String str, long j, C0655a aVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.f550b != null) {
            C1107r rVar = this.f549a;
            rVar.mo9584b("CountdownManager", "Adding countdown: " + str);
            this.f551c.add(new C0656b(str, j, aVar));
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    /* renamed from: b */
    public void mo8196b() {
        this.f549a.mo9584b("CountdownManager", "Removing all countdowns...");
        mo8197c();
        this.f551c.clear();
    }

    /* renamed from: c */
    public void mo8197c() {
        this.f549a.mo9584b("CountdownManager", "Stopping countdowns...");
        this.f552d.incrementAndGet();
        this.f550b.removeCallbacksAndMessages((Object) null);
    }
}
