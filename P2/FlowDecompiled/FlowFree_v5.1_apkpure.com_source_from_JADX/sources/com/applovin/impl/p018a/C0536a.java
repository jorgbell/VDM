package com.applovin.impl.p018a;

import android.net.Uri;
import com.applovin.impl.p018a.C0550j;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0973a;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.a */
public class C0536a extends C0934g {

    /* renamed from: a */
    private final String f138a;

    /* renamed from: b */
    private final String f139b;

    /* renamed from: c */
    private final C0546f f140c;

    /* renamed from: d */
    private final long f141d;

    /* renamed from: e */
    private final C0550j f142e;

    /* renamed from: f */
    private final C0541b f143f;

    /* renamed from: g */
    private final String f144g;

    /* renamed from: h */
    private final Set<C0547g> f145h;

    /* renamed from: i */
    private final Set<C0547g> f146i;

    /* renamed from: com.applovin.impl.a.a$a */
    public static class C0538a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public JSONObject f147a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public JSONObject f148b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C0925b f149c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C1062k f150d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f151e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f152f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public String f153g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public C0546f f154h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public C0550j f155i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public C0541b f156j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public Set<C0547g> f157k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public Set<C0547g> f158l;

        private C0538a() {
        }

        /* renamed from: a */
        public C0538a mo7841a(long j) {
            this.f151e = j;
            return this;
        }

        /* renamed from: a */
        public C0538a mo7842a(C0541b bVar) {
            this.f156j = bVar;
            return this;
        }

        /* renamed from: a */
        public C0538a mo7843a(C0546f fVar) {
            this.f154h = fVar;
            return this;
        }

        /* renamed from: a */
        public C0538a mo7844a(C0550j jVar) {
            this.f155i = jVar;
            return this;
        }

        /* renamed from: a */
        public C0538a mo7845a(C0925b bVar) {
            this.f149c = bVar;
            return this;
        }

        /* renamed from: a */
        public C0538a mo7846a(C1062k kVar) {
            if (kVar != null) {
                this.f150d = kVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        /* renamed from: a */
        public C0538a mo7847a(String str) {
            this.f152f = str;
            return this;
        }

        /* renamed from: a */
        public C0538a mo7848a(Set<C0547g> set) {
            this.f157k = set;
            return this;
        }

        /* renamed from: a */
        public C0538a mo7849a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f147a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        /* renamed from: a */
        public C0536a mo7850a() {
            return new C0536a(this);
        }

        /* renamed from: b */
        public C0538a mo7851b(String str) {
            this.f153g = str;
            return this;
        }

        /* renamed from: b */
        public C0538a mo7852b(Set<C0547g> set) {
            this.f158l = set;
            return this;
        }

        /* renamed from: b */
        public C0538a mo7853b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f148b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }
    }

    /* renamed from: com.applovin.impl.a.a$b */
    public enum C0539b {
        COMPANION_AD,
        VIDEO
    }

    /* renamed from: com.applovin.impl.a.a$c */
    public enum C0540c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        ERROR
    }

    private C0536a(C0538a aVar) {
        super(aVar.f147a, aVar.f148b, aVar.f149c, aVar.f150d);
        this.f138a = aVar.f152f;
        this.f140c = aVar.f154h;
        this.f139b = aVar.f153g;
        this.f142e = aVar.f155i;
        this.f143f = aVar.f156j;
        this.f145h = aVar.f157k;
        this.f146i = aVar.f158l;
        Uri g = mo7829g();
        this.f144g = g != null ? g.toString() : "";
        this.f141d = aVar.f151e;
    }

    /* renamed from: a */
    private Set<C0547g> m197a(C0539b bVar, String[] strArr) {
        C0541b bVar2;
        C0550j jVar;
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptySet();
        }
        Map<String, Set<C0547g>> map = null;
        if (bVar == C0539b.VIDEO && (jVar = this.f142e) != null) {
            map = jVar.mo7893e();
        } else if (bVar == C0539b.COMPANION_AD && (bVar2 = this.f143f) != null) {
            map = bVar2.mo7857d();
        }
        HashSet hashSet = new HashSet();
        if (map != null && !map.isEmpty()) {
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    hashSet.addAll(map.get(str));
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: aQ */
    public static C0538a m198aQ() {
        return new C0538a();
    }

    /* renamed from: aR */
    private String m199aR() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* renamed from: aS */
    private C0550j.C0552a m200aS() {
        C0550j.C0552a[] values = C0550j.C0552a.values();
        int intValue = ((Integer) this.sdk.mo9350a(C0965b.f1815eh)).intValue();
        return (intValue < 0 || intValue >= values.length) ? C0550j.C0552a.UNSPECIFIED : values[intValue];
    }

    /* renamed from: aT */
    private Set<C0547g> m201aT() {
        C0550j jVar = this.f142e;
        return jVar != null ? jVar.mo7892d() : Collections.emptySet();
    }

    /* renamed from: aU */
    private Set<C0547g> m202aU() {
        C0541b bVar = this.f143f;
        return bVar != null ? bVar.mo7856c() : Collections.emptySet();
    }

    /* renamed from: C */
    public boolean mo7812C() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && mo7834i() != null;
    }

    /* renamed from: a */
    public Set<C0547g> mo7813a(C0540c cVar, String str) {
        return mo7814a(cVar, new String[]{str});
    }

    /* renamed from: a */
    public Set<C0547g> mo7814a(C0540c cVar, String[] strArr) {
        C1107r z = this.sdk.mo9411z();
        z.mo9584b("VastAd", "Retrieving trackers of type '" + cVar + "' and events '" + strArr + "'...");
        if (cVar == C0540c.IMPRESSION) {
            return this.f145h;
        }
        if (cVar == C0540c.VIDEO_CLICK) {
            return m201aT();
        }
        if (cVar == C0540c.COMPANION_CLICK) {
            return m202aU();
        }
        if (cVar == C0540c.VIDEO) {
            return m197a(C0539b.VIDEO, strArr);
        }
        if (cVar == C0540c.COMPANION) {
            return m197a(C0539b.COMPANION_AD, strArr);
        }
        if (cVar == C0540c.ERROR) {
            return this.f146i;
        }
        C1107r z2 = this.sdk.mo9411z();
        z2.mo9588e("VastAd", "Failed to retrieve trackers of invalid type '" + cVar + "' and events '" + strArr + "'");
        return Collections.emptySet();
    }

    /* renamed from: a */
    public void mo7815a() {
    }

    /* renamed from: a */
    public void mo7816a(String str) {
        synchronized (this.adObjectLock) {
            C1123j.m2584a(this.adObject, "html_template", str, this.sdk);
        }
    }

    /* renamed from: aL */
    public boolean mo7817aL() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    /* renamed from: aM */
    public String mo7818aM() {
        return getStringFromAdObject("html_template", "");
    }

    /* renamed from: aN */
    public Uri mo7819aN() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", (String) null);
        if (C1155o.m2673b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aO */
    public boolean mo7820aO() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    /* renamed from: aP */
    public boolean mo7821aP() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    /* renamed from: as */
    public List<C0973a> mo7822as() {
        List<C0973a> a;
        synchronized (this.adObjectLock) {
            a = C1160r.m2714a("vimp_urls", this.adObject, getClCode(), C1117e.m2524a("{SOC}", String.valueOf(mo9043ak())), m199aR(), mo9051at(), mo9072x(), this.sdk);
        }
        return a;
    }

    /* renamed from: b */
    public JSONObject mo7823b() {
        return this.fullResponse;
    }

    /* renamed from: c */
    public void mo7824c() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    /* renamed from: d */
    public String mo7825d() {
        return this.f144g;
    }

    /* renamed from: e */
    public boolean mo7826e() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0536a) || !super.equals(obj)) {
            return false;
        }
        C0536a aVar = (C0536a) obj;
        String str = this.f138a;
        if (str == null ? aVar.f138a != null : !str.equals(aVar.f138a)) {
            return false;
        }
        String str2 = this.f139b;
        if (str2 == null ? aVar.f139b != null : !str2.equals(aVar.f139b)) {
            return false;
        }
        C0546f fVar = this.f140c;
        if (fVar == null ? aVar.f140c != null : !fVar.equals(aVar.f140c)) {
            return false;
        }
        C0550j jVar = this.f142e;
        if (jVar == null ? aVar.f142e != null : !jVar.equals(aVar.f142e)) {
            return false;
        }
        C0541b bVar = this.f143f;
        if (bVar == null ? aVar.f143f != null : !bVar.equals(aVar.f143f)) {
            return false;
        }
        Set<C0547g> set = this.f145h;
        if (set == null ? aVar.f145h != null : !set.equals(aVar.f145h)) {
            return false;
        }
        Set<C0547g> set2 = this.f146i;
        Set<C0547g> set3 = aVar.f146i;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    /* renamed from: f */
    public C0539b mo7828f() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? C0539b.COMPANION_AD : C0539b.VIDEO;
    }

    /* renamed from: g */
    public Uri mo7829g() {
        C0553k m = mo7838m();
        if (m != null) {
            return m.mo7901b();
        }
        return null;
    }

    public long getCreatedAtMillis() {
        return this.f141d;
    }

    /* renamed from: h */
    public boolean mo7831h() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.mo7889a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasVideoUrl() {
        /*
            r2 = this;
            com.applovin.impl.a.j r0 = r2.f142e
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.mo7889a()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0012
            r1 = 1
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p018a.C0536a.hasVideoUrl():boolean");
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f138a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f139b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        C0546f fVar = this.f140c;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        C0550j jVar = this.f142e;
        int hashCode5 = (hashCode4 + (jVar != null ? jVar.hashCode() : 0)) * 31;
        C0541b bVar = this.f143f;
        int hashCode6 = (hashCode5 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        Set<C0547g> set = this.f145h;
        int hashCode7 = (hashCode6 + (set != null ? set.hashCode() : 0)) * 31;
        Set<C0547g> set2 = this.f146i;
        if (set2 != null) {
            i = set2.hashCode();
        }
        return hashCode7 + i;
    }

    /* renamed from: i */
    public Uri mo7834i() {
        C0550j jVar = this.f142e;
        if (jVar != null) {
            return jVar.mo7891c();
        }
        return null;
    }

    /* renamed from: j */
    public Uri mo7835j() {
        return mo7834i();
    }

    /* renamed from: k */
    public C0546f mo7836k() {
        return this.f140c;
    }

    /* renamed from: l */
    public C0550j mo7837l() {
        return this.f142e;
    }

    /* renamed from: m */
    public C0553k mo7838m() {
        C0550j jVar = this.f142e;
        if (jVar != null) {
            return jVar.mo7888a(m200aS());
        }
        return null;
    }

    /* renamed from: n */
    public C0541b mo7839n() {
        return this.f143f;
    }

    public String toString() {
        return "VastAd{title='" + this.f138a + '\'' + ", adDescription='" + this.f139b + '\'' + ", systemInfo=" + this.f140c + ", videoCreative=" + this.f142e + ", companionAd=" + this.f143f + ", impressionTrackers=" + this.f145h + ", errorTrackers=" + this.f146i + '}';
    }
}
