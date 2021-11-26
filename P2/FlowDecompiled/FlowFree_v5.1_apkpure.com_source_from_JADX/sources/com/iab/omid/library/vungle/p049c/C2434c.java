package com.iab.omid.library.vungle.p049c;

import android.view.View;
import com.iab.omid.library.vungle.adsession.C2421a;
import com.iab.omid.library.vungle.p048b.C2423a;
import com.iab.omid.library.vungle.p049c.C2431a;
import com.iab.omid.library.vungle.p050d.C2437b;
import com.iab.omid.library.vungle.p050d.C2442f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.c.c */
public class C2434c implements C2431a {

    /* renamed from: a */
    private final C2431a f5491a;

    public C2434c(C2431a aVar) {
        this.f5491a = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ArrayList<View> mo24204a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C2423a a = C2423a.m5714a();
        if (a != null) {
            Collection<C2421a> c = a.mo24169c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C2421a d : c) {
                View d2 = d.mo24158d();
                if (d2 != null && C2442f.m5796c(d2) && (rootView = d2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = C2442f.m5794a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C2442f.m5794a(arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public JSONObject mo24199a(View view) {
        return C2437b.m5771a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo24200a(View view, JSONObject jSONObject, C2431a.C2432a aVar, boolean z) {
        Iterator<View> it = mo24204a().iterator();
        while (it.hasNext()) {
            aVar.mo24201a(it.next(), this.f5491a, jSONObject);
        }
    }
}
