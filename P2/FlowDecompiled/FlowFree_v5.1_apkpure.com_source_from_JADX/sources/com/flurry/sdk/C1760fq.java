package com.flurry.sdk;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.fq */
final class C1760fq extends C1762fr {

    /* renamed from: a */
    protected static C1893jo[] f4389a = {C1893jo.SESSION_INFO, C1893jo.APP_INFO, C1893jo.REPORTED_ID, C1893jo.DEVICE_PROPERTIES, C1893jo.NOTIFICATION, C1893jo.REFERRER, C1893jo.LAUNCH_OPTIONS, C1893jo.CONSENT, C1893jo.APP_STATE, C1893jo.NETWORK, C1893jo.LOCALE, C1893jo.TIMEZONE, C1893jo.APP_ORIENTATION, C1893jo.DYNAMIC_SESSION_INFO, C1893jo.LOCATION, C1893jo.USER_ID, C1893jo.BIRTHDATE, C1893jo.GENDER};

    /* renamed from: b */
    protected static C1893jo[] f4390b = {C1893jo.ORIGIN_ATTRIBUTE};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EnumMap<C1893jo, C1895jq> f4391d;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public EnumMap<C1893jo, List<C1895jq>> f4392h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1760fq(C1752fm fmVar) {
        super("StickyModule", fmVar);
        Class<C1893jo> cls = C1893jo.class;
        this.f4391d = new EnumMap<>(cls);
        this.f4392h = new EnumMap<>(cls);
        for (C1893jo put : f4389a) {
            this.f4391d.put(put, (Object) null);
        }
        for (C1893jo put2 : f4390b) {
            this.f4392h.put(put2, (Object) null);
        }
    }

    /* renamed from: a */
    public final void mo11508a(final C1895jq jqVar) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1760fq.this.mo11526d(jqVar);
                C1760fq.m4568a(C1760fq.this, jqVar);
                if (C1893jo.FLUSH_FRAME.equals(jqVar.mo11542a())) {
                    for (Map.Entry value : C1760fq.this.f4391d.entrySet()) {
                        C1895jq jqVar = (C1895jq) value.getValue();
                        if (jqVar != null) {
                            C1760fq.this.mo11526d(jqVar);
                        }
                    }
                    for (Map.Entry value2 : C1760fq.this.f4392h.entrySet()) {
                        List list = (List) value2.getValue();
                        if (!(list == null || list.size() == 0)) {
                            for (int i = 0; i < list.size(); i++) {
                                C1760fq.this.mo11526d((C1895jq) list.get(i));
                            }
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m4568a(C1760fq fqVar, C1895jq jqVar) {
        C1893jo a = jqVar.mo11542a();
        List arrayList = new ArrayList();
        if (fqVar.f4391d.containsKey(a)) {
            fqVar.f4391d.put(a, jqVar);
        }
        if (fqVar.f4392h.containsKey(a)) {
            if (fqVar.f4392h.get(a) != null) {
                arrayList = fqVar.f4392h.get(a);
            }
            arrayList.add(jqVar);
            fqVar.f4392h.put(a, arrayList);
        }
    }
}
