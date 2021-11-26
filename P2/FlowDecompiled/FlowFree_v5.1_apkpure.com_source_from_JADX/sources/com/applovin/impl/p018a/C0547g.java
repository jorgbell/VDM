package com.applovin.impl.p018a;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.g */
public class C0547g {

    /* renamed from: a */
    private String f207a;

    /* renamed from: b */
    private String f208b;

    /* renamed from: c */
    private String f209c;

    /* renamed from: d */
    private long f210d = -1;

    /* renamed from: e */
    private int f211e = -1;

    private C0547g() {
    }

    /* renamed from: a */
    private static int m275a(String str, C0542c cVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (cVar != null) {
            return cVar.mo7868h();
        }
        return 95;
    }

    /* renamed from: a */
    public static C0547g m276a(C1166t tVar, C0542c cVar, C1062k kVar) {
        TimeUnit timeUnit;
        long seconds;
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (kVar != null) {
            try {
                String c = tVar.mo9701c();
                if (C1155o.m2673b(c)) {
                    C0547g gVar = new C0547g();
                    gVar.f209c = c;
                    gVar.f207a = tVar.mo9699b().get("id");
                    gVar.f208b = tVar.mo9699b().get("event");
                    gVar.f211e = m275a(gVar.mo7882a(), cVar);
                    String str = tVar.mo9699b().get(VastIconXmlManager.OFFSET);
                    if (C1155o.m2673b(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            gVar.f211e = C1155o.m2660a(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(":")) {
                            List<String> a = C1117e.m2522a(trim, ":");
                            int size = a.size();
                            if (size > 0) {
                                long j = 0;
                                int i = size - 1;
                                for (int i2 = i; i2 >= 0; i2--) {
                                    String str2 = a.get(i2);
                                    if (C1155o.m2676d(str2)) {
                                        int parseInt = Integer.parseInt(str2);
                                        if (i2 == i) {
                                            seconds = (long) parseInt;
                                        } else {
                                            if (i2 == size - 2) {
                                                timeUnit = TimeUnit.MINUTES;
                                            } else if (i2 == size - 3) {
                                                timeUnit = TimeUnit.HOURS;
                                            }
                                            seconds = timeUnit.toSeconds((long) parseInt);
                                        }
                                        j += seconds;
                                    }
                                }
                                gVar.f210d = j;
                                gVar.f211e = -1;
                            }
                        } else {
                            kVar.mo9411z().mo9588e("VastTracker", "Unable to parse time offset from rawOffsetString = " + trim);
                        }
                    }
                    return gVar;
                }
                kVar.mo9411z().mo9588e("VastTracker", "Unable to create tracker. Could not find URL.");
                return null;
            } catch (Throwable th) {
                kVar.mo9411z().mo9585b("VastTracker", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo7882a() {
        return this.f208b;
    }

    /* renamed from: a */
    public boolean mo7883a(long j, int i) {
        long j2 = this.f210d;
        boolean z = j2 >= 0;
        boolean z2 = j >= j2;
        int i2 = this.f211e;
        boolean z3 = i2 >= 0;
        boolean z4 = i >= i2;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    /* renamed from: b */
    public String mo7884b() {
        return this.f209c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0547g)) {
            return false;
        }
        C0547g gVar = (C0547g) obj;
        if (this.f210d != gVar.f210d || this.f211e != gVar.f211e) {
            return false;
        }
        String str = this.f207a;
        if (str == null ? gVar.f207a != null : !str.equals(gVar.f207a)) {
            return false;
        }
        String str2 = this.f208b;
        if (str2 == null ? gVar.f208b == null : str2.equals(gVar.f208b)) {
            return this.f209c.equals(gVar.f209c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f207a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f208b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        long j = this.f210d;
        return ((((((hashCode + i) * 31) + this.f209c.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f211e;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f207a + '\'' + ", event='" + this.f208b + '\'' + ", uriString='" + this.f209c + '\'' + ", offsetSeconds=" + this.f210d + ", offsetPercent=" + this.f211e + '}';
    }
}
