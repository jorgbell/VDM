package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.sdk.o */
public class C1102o {

    /* renamed from: a */
    private final String f2354a = UUID.randomUUID().toString();

    /* renamed from: b */
    private final String f2355b;

    /* renamed from: c */
    private final Map<String, Object> f2356c;

    /* renamed from: d */
    private final long f2357d;

    public C1102o(String str, Map<String, String> map, Map<String, Object> map2) {
        this.f2355b = str;
        HashMap hashMap = new HashMap();
        this.f2356c = hashMap;
        hashMap.putAll(map);
        hashMap.put("applovin_sdk_super_properties", map2);
        this.f2357d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public String mo9555a() {
        return this.f2355b;
    }

    /* renamed from: b */
    public Map<String, Object> mo9556b() {
        return this.f2356c;
    }

    /* renamed from: c */
    public long mo9557c() {
        return this.f2357d;
    }

    /* renamed from: d */
    public String mo9558d() {
        return this.f2354a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1102o oVar = (C1102o) obj;
        if (this.f2357d != oVar.f2357d) {
            return false;
        }
        String str = this.f2355b;
        if (str == null ? oVar.f2355b != null : !str.equals(oVar.f2355b)) {
            return false;
        }
        Map<String, Object> map = this.f2356c;
        if (map == null ? oVar.f2356c != null : !map.equals(oVar.f2356c)) {
            return false;
        }
        String str2 = this.f2354a;
        String str3 = oVar.f2354a;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.f2355b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.f2356c;
        int hashCode2 = map != null ? map.hashCode() : 0;
        long j = this.f2357d;
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f2354a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Event{name='" + this.f2355b + '\'' + ", id='" + this.f2354a + '\'' + ", creationTimestampMillis=" + this.f2357d + ", parameters=" + this.f2356c + '}';
    }
}
