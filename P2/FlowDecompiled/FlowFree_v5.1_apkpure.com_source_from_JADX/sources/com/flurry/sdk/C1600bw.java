package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.bw */
public final class C1600bw {

    /* renamed from: a */
    public final C1621ce f4026a;

    /* renamed from: b */
    public C1629ck f4027b;

    public C1600bw(C1621ce ceVar, C1629ck ckVar) {
        this.f4026a = ceVar;
        this.f4027b = ckVar;
    }

    /* renamed from: a */
    public final String mo11355a(String str, String str2, C1623cg cgVar) {
        C1605by a = this.f4027b.mo11397a(str, cgVar);
        if (a == null) {
            a = this.f4026a.mo11381a(str);
        }
        return a != null ? a.mo11362a() : str2;
    }

    /* renamed from: a */
    public final int mo11353a(String str, int i, C1623cg cgVar) {
        C1605by a = this.f4027b.mo11397a(str, cgVar);
        if (a == null) {
            a = this.f4026a.mo11381a(str);
        }
        if (a != null) {
            try {
                return Integer.decode(a.mo11362a()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public final float mo11352a(String str, float f, C1623cg cgVar) {
        C1605by a = this.f4027b.mo11397a(str, cgVar);
        if (a == null) {
            a = this.f4026a.mo11381a(str);
        }
        if (a != null) {
            try {
                return Float.parseFloat(a.mo11362a());
            } catch (NumberFormatException unused) {
            }
        }
        return f;
    }

    /* renamed from: a */
    public final long mo11354a(String str, long j, C1623cg cgVar) {
        C1605by a = this.f4027b.mo11397a(str, cgVar);
        if (a == null) {
            a = this.f4026a.mo11381a(str);
        }
        if (a != null) {
            try {
                return Long.decode(a.mo11362a()).longValue();
            } catch (NumberFormatException unused) {
            }
        }
        return j;
    }

    /* renamed from: a */
    public final double mo11351a(String str, double d, C1623cg cgVar) {
        C1605by a = this.f4027b.mo11397a(str, cgVar);
        if (a == null) {
            a = this.f4026a.mo11381a(str);
        }
        if (a != null) {
            try {
                return Double.parseDouble(a.mo11362a());
            } catch (NumberFormatException unused) {
            }
        }
        return d;
    }

    /* renamed from: a */
    public final Map<String, String> mo11356a(C1623cg cgVar) {
        C1629ck ckVar = this.f4027b;
        HashMap hashMap = new HashMap();
        if (cgVar == null) {
            for (Map<String, C1605by> entrySet : ckVar.f4122b.values()) {
                for (Map.Entry entry : entrySet.entrySet()) {
                    hashMap.put(entry.getKey(), ((C1605by) entry.getValue()).mo11362a());
                }
            }
        } else {
            Map map = ckVar.f4122b.get(cgVar);
            if (map != null) {
                for (Map.Entry entry2 : map.entrySet()) {
                    hashMap.put(entry2.getKey(), ((C1605by) entry2.getValue()).mo11362a());
                }
            }
        }
        return hashMap;
    }
}
