package com.iab.omid.library.mopub.p043c;

import android.view.View;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.p042b.C2372a;
import com.iab.omid.library.mopub.p043c.C2382a;
import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.p044d.C2393f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.c.c */
public class C2385c implements C2382a {

    /* renamed from: a */
    private final C2382a f5396a;

    public C2385c(C2382a aVar) {
        this.f5396a = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ArrayList<View> mo24064a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C2372a a = C2372a.m5503a();
        if (a != null) {
            Collection<C2370a> c = a.mo24023c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C2370a d : c) {
                View d2 = d.mo23990d();
                if (d2 != null && C2393f.m5609c(d2) && (rootView = d2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = C2393f.m5607a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C2393f.m5607a(arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public JSONObject mo24059a(View view) {
        return C2388b.m5576a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo24060a(View view, JSONObject jSONObject, C2382a.C2383a aVar, boolean z) {
        Iterator<View> it = mo24064a().iterator();
        while (it.hasNext()) {
            aVar.mo24061a(it.next(), this.f5396a, jSONObject);
        }
    }
}
