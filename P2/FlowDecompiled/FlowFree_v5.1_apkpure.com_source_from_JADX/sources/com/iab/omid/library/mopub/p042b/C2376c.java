package com.iab.omid.library.mopub.p042b;

import android.view.View;
import com.iab.omid.library.mopub.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mopub.p045e.C2394a;

/* renamed from: com.iab.omid.library.mopub.b.c */
public class C2376c {

    /* renamed from: a */
    private final C2394a f5372a;

    /* renamed from: b */
    private final String f5373b;

    /* renamed from: c */
    private final FriendlyObstructionPurpose f5374c;

    /* renamed from: d */
    private final String f5375d;

    public C2376c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f5372a = new C2394a(view);
        this.f5373b = view.getClass().getCanonicalName();
        this.f5374c = friendlyObstructionPurpose;
        this.f5375d = str;
    }

    /* renamed from: a */
    public C2394a mo24033a() {
        return this.f5372a;
    }

    /* renamed from: b */
    public String mo24034b() {
        return this.f5373b;
    }

    /* renamed from: c */
    public FriendlyObstructionPurpose mo24035c() {
        return this.f5374c;
    }

    /* renamed from: d */
    public String mo24036d() {
        return this.f5375d;
    }
}
