package com.applovin.impl.p018a;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.j */
public class C0550j {

    /* renamed from: a */
    private List<C0553k> f215a;

    /* renamed from: b */
    private List<String> f216b;

    /* renamed from: c */
    private int f217c;

    /* renamed from: d */
    private Uri f218d;

    /* renamed from: e */
    private final Set<C0547g> f219e = new HashSet();

    /* renamed from: f */
    private final Map<String, Set<C0547g>> f220f = new HashMap();

    /* renamed from: com.applovin.impl.a.j$a */
    public enum C0552a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH
    }

    private C0550j() {
        List<C0553k> list = Collections.EMPTY_LIST;
        this.f215a = list;
        this.f216b = list;
    }

    private C0550j(C0542c cVar) {
        List<C0553k> list = Collections.EMPTY_LIST;
        this.f215a = list;
        this.f216b = list;
        this.f216b = cVar.mo7867g();
    }

    /* renamed from: a */
    private static int m299a(String str, C1062k kVar) {
        try {
            List<String> a = C1117e.m2522a(str, ":");
            if (a.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) C1155o.m2660a(a.get(0))) + TimeUnit.MINUTES.toSeconds((long) C1155o.m2660a(a.get(1))) + ((long) C1155o.m2660a(a.get(2))));
            }
        } catch (Throwable unused) {
            C1107r z = kVar.mo9411z();
            z.mo9588e("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
        }
        return 0;
    }

    /* renamed from: a */
    public static C0550j m300a(C1166t tVar, C0550j jVar, C0542c cVar, C1062k kVar) {
        C1166t b;
        List<C0553k> a;
        C1166t b2;
        int a2;
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (cVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (kVar != null) {
            if (jVar == null) {
                try {
                    jVar = new C0550j(cVar);
                } catch (Throwable th) {
                    kVar.mo9411z().mo9585b("VastVideoCreative", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (jVar.f217c == 0 && (b2 = tVar.mo9698b("Duration")) != null && (a2 = m299a(b2.mo9701c(), kVar)) > 0) {
                jVar.f217c = a2;
            }
            C1166t b3 = tVar.mo9698b("MediaFiles");
            if (!(b3 == null || (a = m301a(b3, kVar)) == null || a.size() <= 0)) {
                List<C0553k> list = jVar.f215a;
                if (list != null) {
                    a.addAll(list);
                }
                jVar.f215a = a;
            }
            C1166t b4 = tVar.mo9698b("VideoClicks");
            if (b4 != null) {
                if (jVar.f218d == null && (b = b4.mo9698b("ClickThrough")) != null) {
                    String c = b.mo9701c();
                    if (C1155o.m2673b(c)) {
                        jVar.f218d = Uri.parse(c);
                    }
                }
                C0549i.m290a(b4.mo9697a("ClickTracking"), jVar.f219e, cVar, kVar);
            }
            C0549i.m289a(tVar, jVar.f220f, cVar, kVar);
            return jVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static List<C0553k> m301a(C1166t tVar, C1062k kVar) {
        List<C1166t> a = tVar.mo9697a("MediaFile");
        ArrayList arrayList = new ArrayList(a.size());
        List<String> a2 = C1117e.m2521a((String) kVar.mo9350a(C0965b.f1813ef));
        List<String> a3 = C1117e.m2521a((String) kVar.mo9350a(C0965b.f1812ee));
        for (C1166t a4 : a) {
            C0553k a5 = C0553k.m310a(a4, kVar);
            if (a5 != null) {
                try {
                    String c = a5.mo7902c();
                    if (!C1155o.m2673b(c) || a2.contains(c)) {
                        if (((Boolean) kVar.mo9350a(C0965b.f1814eg)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a5.mo7901b().toString());
                            if (C1155o.m2673b(fileExtensionFromUrl) && !a3.contains(fileExtensionFromUrl)) {
                            }
                        }
                        C1107r z = kVar.mo9411z();
                        z.mo9587d("VastVideoCreative", "Video file not supported: " + a5);
                    }
                    arrayList.add(a5);
                } catch (Throwable th) {
                    C1107r z2 = kVar.mo9411z();
                    z2.mo9585b("VastVideoCreative", "Failed to validate video file: " + a5, th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C0553k mo7888a(C0552a aVar) {
        List<C0553k> list = this.f215a;
        if (list == null || list.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(3);
        for (String next : this.f216b) {
            for (C0553k next2 : this.f215a) {
                String c = next2.mo7902c();
                if (C1155o.m2673b(c) && next.equalsIgnoreCase(c)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f215a;
        }
        if (C1119g.m2530c()) {
            Collections.sort(arrayList, new Comparator<C0553k>() {
                @TargetApi(19)
                /* renamed from: a */
                public int compare(C0553k kVar, C0553k kVar2) {
                    return Integer.compare(kVar.mo7903d(), kVar2.mo7903d());
                }
            });
        }
        return (C0553k) arrayList.get(aVar == C0552a.LOW ? 0 : aVar == C0552a.MEDIUM ? arrayList.size() / 2 : arrayList.size() - 1);
    }

    /* renamed from: a */
    public List<C0553k> mo7889a() {
        return this.f215a;
    }

    /* renamed from: b */
    public int mo7890b() {
        return this.f217c;
    }

    /* renamed from: c */
    public Uri mo7891c() {
        return this.f218d;
    }

    /* renamed from: d */
    public Set<C0547g> mo7892d() {
        return this.f219e;
    }

    /* renamed from: e */
    public Map<String, Set<C0547g>> mo7893e() {
        return this.f220f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0550j)) {
            return false;
        }
        C0550j jVar = (C0550j) obj;
        if (this.f217c != jVar.f217c) {
            return false;
        }
        List<C0553k> list = this.f215a;
        if (list == null ? jVar.f215a != null : !list.equals(jVar.f215a)) {
            return false;
        }
        Uri uri = this.f218d;
        if (uri == null ? jVar.f218d != null : !uri.equals(jVar.f218d)) {
            return false;
        }
        Set<C0547g> set = this.f219e;
        if (set == null ? jVar.f219e != null : !set.equals(jVar.f219e)) {
            return false;
        }
        Map<String, Set<C0547g>> map = this.f220f;
        Map<String, Set<C0547g>> map2 = jVar.f220f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        List<C0553k> list = this.f215a;
        int i = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f217c) * 31;
        Uri uri = this.f218d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<C0547g> set = this.f219e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C0547g>> map = this.f220f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f215a + ", durationSeconds=" + this.f217c + ", destinationUri=" + this.f218d + ", clickTrackers=" + this.f219e + ", eventTrackers=" + this.f220f + '}';
    }
}
