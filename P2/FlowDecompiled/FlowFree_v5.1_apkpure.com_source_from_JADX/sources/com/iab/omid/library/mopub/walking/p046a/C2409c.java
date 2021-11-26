package com.iab.omid.library.mopub.walking.p046a;

import com.iab.omid.library.mopub.walking.p046a.C2406b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.mopub.walking.a.c */
public class C2409c implements C2406b.C2407a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f5445a;

    /* renamed from: b */
    private final ThreadPoolExecutor f5446b;

    /* renamed from: c */
    private final ArrayDeque<C2406b> f5447c = new ArrayDeque<>();

    /* renamed from: d */
    private C2406b f5448d = null;

    public C2409c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f5445a = linkedBlockingQueue;
        this.f5446b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    /* renamed from: a */
    private void m5681a() {
        C2406b poll = this.f5447c.poll();
        this.f5448d = poll;
        if (poll != null) {
            poll.mo24114a(this.f5446b);
        }
    }

    /* renamed from: a */
    public void mo24116a(C2406b bVar) {
        this.f5448d = null;
        m5681a();
    }

    /* renamed from: b */
    public void mo24119b(C2406b bVar) {
        bVar.mo24112a((C2406b.C2407a) this);
        this.f5447c.add(bVar);
        if (this.f5448d == null) {
            m5681a();
        }
    }
}
