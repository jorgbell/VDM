package com.flurry.sdk;

import com.flurry.sdk.C1548be;
import com.flurry.sdk.C1770fu;
import com.flurry.sdk.C1776fy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.fk */
final class C1747fk extends C1762fr {

    /* renamed from: a */
    protected List<C1770fu> f4363a;

    /* renamed from: b */
    protected final Map<String, List<C1895jq>> f4364b = new HashMap();

    /* renamed from: d */
    protected C1548be.C1549a f4365d;

    C1747fk(C1752fm fmVar) {
        super("DropModule", fmVar);
        ArrayList arrayList = new ArrayList();
        this.f4363a = arrayList;
        arrayList.add(new C1769ft());
        this.f4363a.add(new C1768fs());
        this.f4363a.add(new C1773fv());
        this.f4363a.add(new C1774fw());
        this.f4365d = new C1548be.C1549a();
    }

    /* renamed from: a */
    public final void mo11508a(final C1895jq jqVar) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1747fk.m4529a(C1747fk.this, C1747fk.m4528a(C1747fk.this, jqVar));
                C1747fk.m4532b(C1747fk.this, jqVar);
            }
        });
    }

    /* renamed from: e */
    private List<C1895jq> m4533e(C1895jq jqVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<C1895jq>> value : this.f4364b.entrySet()) {
            for (C1895jq f : (List) value.getValue()) {
                C1804gn gnVar = (C1804gn) f.mo11560f();
                String str = gnVar.f4516a;
                int i = gnVar.f4517b;
                long currentTimeMillis = System.currentTimeMillis();
                arrayList.add(C1802gm.m4658a(str, i, gnVar.f4518c, gnVar.f4519d, currentTimeMillis, currentTimeMillis - gnVar.f4524i));
                this.f4365d.f3920c++;
            }
        }
        arrayList.add(jqVar);
        return arrayList;
    }

    /* renamed from: a */
    private static void m4531a(C1895jq jqVar, C1895jq jqVar2) {
        C1804gn gnVar = (C1804gn) jqVar.mo11560f();
        C1804gn gnVar2 = (C1804gn) jqVar2.mo11560f();
        gnVar2.f4517b = gnVar.f4517b;
        gnVar2.f4522g = gnVar2.f4524i - gnVar.f4524i;
        Map<String, String> map = gnVar.f4518c;
        Map<String, String> map2 = gnVar2.f4518c;
        if (map != null && map2 != null) {
            Map<String, String> map3 = gnVar.f4519d;
            Map<String, String> map4 = gnVar2.f4519d;
            if (map3.get(C1698dz.m4447b("fl.parameter.limit.exceeded")) != null) {
                map4.putAll(map3);
                map2.clear();
                return;
            }
            if (!map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    if (!map2.containsKey(next.getKey())) {
                        map2.put(next.getKey(), next.getValue());
                    }
                }
            }
            if (map2.size() > 10) {
                map4.put(C1698dz.m4447b("fl.parameter.limit.exceeded.on.endevent"), C1698dz.m4447b(String.valueOf(map2.size())));
                map2.clear();
                map2.putAll(map);
            }
        }
    }

    /* renamed from: f */
    private static boolean m4534f(C1895jq jqVar) {
        return jqVar.mo11542a().equals(C1893jo.FLUSH_FRAME) && ((C1866ip) jqVar.mo11560f()).f4603b.equals(C1776fy.C1777a.REASON_SESSION_FINALIZE.f4447j);
    }

    /* renamed from: a */
    private void m4530a(C1770fu.C1771a aVar, C1895jq jqVar) {
        C1548be.C1549a aVar2 = this.f4365d;
        aVar2.f3918a++;
        aVar2.f3919b.add(jqVar.mo11542a());
        HashMap hashMap = new HashMap();
        hashMap.put("fl.drop.reason", aVar.f4422a.f4434j);
        hashMap.put("fl.drop.frame.type", String.valueOf(jqVar.mo11542a()));
        C1548be.m4072a();
        C1548be.m4074a("Flurry.SDKReport.DropFrame", hashMap);
    }

    /* renamed from: a */
    public final C1548be.C1549a mo11264a() {
        return this.f4365d;
    }

    /* renamed from: a */
    static /* synthetic */ List m4528a(C1747fk fkVar, C1895jq jqVar) {
        if (jqVar.mo11542a().equals(C1893jo.ANALYTICS_EVENT) && ((C1804gn) jqVar.mo11560f()).f4520e) {
            ArrayList arrayList = new ArrayList();
            String str = ((C1804gn) jqVar.mo11560f()).f4516a;
            List list = fkVar.f4364b.get(str);
            if (((C1804gn) jqVar.mo11560f()).f4521f) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(jqVar);
                fkVar.f4364b.put(str, list);
                arrayList.add(jqVar);
                return arrayList;
            } else if (list == null || list.isEmpty()) {
                fkVar.m4530a(C1770fu.f4417e, jqVar);
                return arrayList;
            } else {
                m4531a((C1895jq) list.remove(0), jqVar);
                arrayList.add(jqVar);
                return arrayList;
            }
        } else if (m4534f(jqVar)) {
            return fkVar.m4533e(jqVar);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(jqVar);
            return arrayList2;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4529a(C1747fk fkVar, List list) {
        boolean z;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1895jq jqVar = (C1895jq) it.next();
            Iterator<C1770fu> it2 = fkVar.f4363a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                C1770fu.C1771a a = it2.next().mo11527a(jqVar);
                if (!a.f4422a.equals(C1770fu.C1772b.DO_NOT_DROP)) {
                    fkVar.m4530a(a, jqVar);
                    z = true;
                    break;
                }
                C1895jq jqVar2 = a.f4423b;
                if (jqVar2 != null) {
                    fkVar.mo11526d(jqVar2);
                }
            }
            if (!z) {
                C1648cy.m4317a(4, "DropModule", "Adding Frame:" + jqVar.mo11559e());
                fkVar.mo11526d(jqVar);
            } else {
                C1648cy.m4317a(4, "DropModule", "Dropping Frame: " + jqVar.mo11542a() + ": " + jqVar.mo11559e());
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m4532b(C1747fk fkVar, C1895jq jqVar) {
        if (m4534f(jqVar)) {
            C1648cy.m4317a(4, "DropModule", "Resetting drop rules");
            for (C1770fu a : fkVar.f4363a) {
                a.mo11528a();
            }
            C1648cy.m4317a(4, "DropModule", "Reset start timed event record");
            fkVar.f4364b.clear();
        }
    }
}
