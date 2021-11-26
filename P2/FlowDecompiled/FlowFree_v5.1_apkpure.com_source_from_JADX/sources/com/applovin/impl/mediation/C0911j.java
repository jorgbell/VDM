package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p021a.C0733a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.j */
public class C0911j {

    /* renamed from: a */
    private final List<C0912a> f1328a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.mediation.j$a */
    public interface C0912a {
        /* renamed from: a */
        void mo8849a(C0733a aVar);
    }

    /* renamed from: a */
    public void mo8846a(C0733a aVar) {
        Iterator it = new ArrayList(this.f1328a).iterator();
        while (it.hasNext()) {
            ((C0912a) it.next()).mo8849a(aVar);
        }
    }

    /* renamed from: a */
    public void mo8847a(C0912a aVar) {
        this.f1328a.add(aVar);
    }

    /* renamed from: b */
    public void mo8848b(C0912a aVar) {
        this.f1328a.remove(aVar);
    }
}
