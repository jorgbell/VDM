package com.applovin.impl.p018a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import java.util.Locale;

/* renamed from: com.applovin.impl.a.k */
public class C0553k {

    /* renamed from: a */
    private Uri f227a;

    /* renamed from: b */
    private Uri f228b;

    /* renamed from: c */
    private C0554a f229c;

    /* renamed from: d */
    private String f230d;

    /* renamed from: e */
    private int f231e;

    /* renamed from: f */
    private int f232f;

    /* renamed from: g */
    private int f233g;

    /* renamed from: com.applovin.impl.a.k$a */
    public enum C0554a {
        Progressive,
        Streaming
    }

    private C0553k() {
    }

    /* renamed from: a */
    private static C0554a m309a(String str) {
        if (C1155o.m2673b(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return C0554a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return C0554a.Streaming;
            }
        }
        return C0554a.Progressive;
    }

    /* renamed from: a */
    public static C0553k m310a(C1166t tVar, C1062k kVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (kVar != null) {
            try {
                String c = tVar.mo9701c();
                if (URLUtil.isValidUrl(c)) {
                    Uri parse = Uri.parse(c);
                    C0553k kVar2 = new C0553k();
                    kVar2.f227a = parse;
                    kVar2.f228b = parse;
                    kVar2.f233g = C1155o.m2660a(tVar.mo9699b().get("bitrate"));
                    kVar2.f229c = m309a(tVar.mo9699b().get("delivery"));
                    kVar2.f232f = C1155o.m2660a(tVar.mo9699b().get("height"));
                    kVar2.f231e = C1155o.m2660a(tVar.mo9699b().get("width"));
                    kVar2.f230d = tVar.mo9699b().get("type").toLowerCase(Locale.ENGLISH);
                    return kVar2;
                }
                kVar.mo9411z().mo9588e("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            } catch (Throwable th) {
                kVar.mo9411z().mo9585b("VastVideoFile", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo7899a() {
        return this.f227a;
    }

    /* renamed from: a */
    public void mo7900a(Uri uri) {
        this.f228b = uri;
    }

    /* renamed from: b */
    public Uri mo7901b() {
        return this.f228b;
    }

    /* renamed from: c */
    public String mo7902c() {
        return this.f230d;
    }

    /* renamed from: d */
    public int mo7903d() {
        return this.f233g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0553k)) {
            return false;
        }
        C0553k kVar = (C0553k) obj;
        if (this.f231e != kVar.f231e || this.f232f != kVar.f232f || this.f233g != kVar.f233g) {
            return false;
        }
        Uri uri = this.f227a;
        if (uri == null ? kVar.f227a != null : !uri.equals(kVar.f227a)) {
            return false;
        }
        Uri uri2 = this.f228b;
        if (uri2 == null ? kVar.f228b != null : !uri2.equals(kVar.f228b)) {
            return false;
        }
        if (this.f229c != kVar.f229c) {
            return false;
        }
        String str = this.f230d;
        String str2 = kVar.f230d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f227a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f228b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        C0554a aVar = this.f229c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f230d;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.f231e) * 31) + this.f232f) * 31) + this.f233g;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f227a + ", videoUri=" + this.f228b + ", deliveryType=" + this.f229c + ", fileType='" + this.f230d + '\'' + ", width=" + this.f231e + ", height=" + this.f232f + ", bitrate=" + this.f233g + '}';
    }
}
