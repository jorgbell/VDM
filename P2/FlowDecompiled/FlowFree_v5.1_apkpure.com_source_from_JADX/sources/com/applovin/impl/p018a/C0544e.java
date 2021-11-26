package com.applovin.impl.p018a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import com.mopub.mobileads.VastResourceXmlManager;

/* renamed from: com.applovin.impl.a.e */
public class C0544e {

    /* renamed from: a */
    private C0545a f197a;

    /* renamed from: b */
    private Uri f198b;

    /* renamed from: c */
    private String f199c;

    /* renamed from: com.applovin.impl.a.e$a */
    public enum C0545a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private C0544e() {
    }

    /* renamed from: a */
    static C0544e m266a(C1166t tVar, C0544e eVar, C1062k kVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (kVar != null) {
            if (eVar == null) {
                try {
                    eVar = new C0544e();
                } catch (Throwable th) {
                    kVar.mo9411z().mo9585b("VastNonVideoResource", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (eVar.f198b == null && !C1155o.m2673b(eVar.f199c)) {
                String a = m267a(tVar, VastResourceXmlManager.STATIC_RESOURCE);
                if (URLUtil.isValidUrl(a)) {
                    eVar.f198b = Uri.parse(a);
                    eVar.f197a = C0545a.STATIC;
                    return eVar;
                }
                String a2 = m267a(tVar, VastResourceXmlManager.IFRAME_RESOURCE);
                if (C1155o.m2673b(a2)) {
                    eVar.f197a = C0545a.IFRAME;
                    if (URLUtil.isValidUrl(a2)) {
                        eVar.f198b = Uri.parse(a2);
                    } else {
                        eVar.f199c = a2;
                    }
                    return eVar;
                }
                String a3 = m267a(tVar, VastResourceXmlManager.HTML_RESOURCE);
                if (C1155o.m2673b(a3)) {
                    eVar.f197a = C0545a.HTML;
                    if (URLUtil.isValidUrl(a3)) {
                        eVar.f198b = Uri.parse(a3);
                    } else {
                        eVar.f199c = a3;
                    }
                }
            }
            return eVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static String m267a(C1166t tVar, String str) {
        C1166t b = tVar.mo9698b(str);
        if (b != null) {
            return b.mo9701c();
        }
        return null;
    }

    /* renamed from: a */
    public C0545a mo7870a() {
        return this.f197a;
    }

    /* renamed from: a */
    public void mo7871a(Uri uri) {
        this.f198b = uri;
    }

    /* renamed from: a */
    public void mo7872a(String str) {
        this.f199c = str;
    }

    /* renamed from: b */
    public Uri mo7873b() {
        return this.f198b;
    }

    /* renamed from: c */
    public String mo7874c() {
        return this.f199c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0544e)) {
            return false;
        }
        C0544e eVar = (C0544e) obj;
        if (this.f197a != eVar.f197a) {
            return false;
        }
        Uri uri = this.f198b;
        if (uri == null ? eVar.f198b != null : !uri.equals(eVar.f198b)) {
            return false;
        }
        String str = this.f199c;
        String str2 = eVar.f199c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        C0545a aVar = this.f197a;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f198b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f199c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f197a + ", resourceUri=" + this.f198b + ", resourceContents='" + this.f199c + '\'' + '}';
    }
}
