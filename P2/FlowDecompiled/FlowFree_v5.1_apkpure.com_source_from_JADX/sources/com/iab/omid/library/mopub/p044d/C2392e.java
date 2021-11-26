package com.iab.omid.library.mopub.p044d;

import android.text.TextUtils;
import com.iab.omid.library.mopub.Omid;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.adsession.CreativeType;
import com.iab.omid.library.mopub.adsession.ImpressionType;
import com.iab.omid.library.mopub.adsession.Owner;

/* renamed from: com.iab.omid.library.mopub.d.e */
public class C2392e {
    /* renamed from: a */
    public static void m5594a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m5595a(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    /* renamed from: a */
    public static void m5596a(C2370a aVar) {
        if (aVar.mo23992f()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public static void m5597a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m5598a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m5599a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m5600b(C2370a aVar) {
        if (aVar.mo23993g()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m5601c(C2370a aVar) {
        m5606h(aVar);
        m5600b(aVar);
    }

    /* renamed from: d */
    public static void m5602d(C2370a aVar) {
        if (aVar.getAdSessionStatePublisher().mo24080c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: e */
    public static void m5603e(C2370a aVar) {
        if (aVar.getAdSessionStatePublisher().mo24081d() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    /* renamed from: f */
    public static void m5604f(C2370a aVar) {
        if (!aVar.mo23996h()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: g */
    public static void m5605g(C2370a aVar) {
        if (!aVar.mo23997i()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    /* renamed from: h */
    private static void m5606h(C2370a aVar) {
        if (!aVar.mo23992f()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
