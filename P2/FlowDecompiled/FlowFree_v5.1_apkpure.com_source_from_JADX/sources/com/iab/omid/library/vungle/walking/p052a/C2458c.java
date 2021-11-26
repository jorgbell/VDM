package com.iab.omid.library.vungle.walking.p052a;

import com.iab.omid.library.vungle.walking.p052a.C2455b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.vungle.walking.a.c */
public class C2458c implements C2455b.C2456a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f5538a;

    /* renamed from: b */
    private final ThreadPoolExecutor f5539b;

    /* renamed from: c */
    private final ArrayDeque<C2455b> f5540c = new ArrayDeque<>();

    /* renamed from: d */
    private C2455b f5541d = null;

    public C2458c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f5538a = linkedBlockingQueue;
        this.f5539b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    /* renamed from: a */
    private void m5859a() {
        C2455b poll = this.f5540c.poll();
        this.f5541d = poll;
        if (poll != null) {
            poll.mo24245a(this.f5539b);
        }
    }

    /* renamed from: a */
    public void mo24247a(C2455b bVar) {
        this.f5541d = null;
        m5859a();
    }

    /* renamed from: b */
    public void mo24250b(C2455b bVar) {
        bVar.mo24243a((C2455b.C2456a) this);
        this.f5540c.add(bVar);
        if (this.f5541d == null) {
            m5859a();
        }
    }
}
