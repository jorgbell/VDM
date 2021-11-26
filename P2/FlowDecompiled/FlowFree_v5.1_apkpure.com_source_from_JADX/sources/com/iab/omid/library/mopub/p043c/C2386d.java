package com.iab.omid.library.mopub.p043c;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.mopub.p043c.C2382a;
import com.iab.omid.library.mopub.p044d.C2388b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.c.d */
public class C2386d implements C2382a {

    /* renamed from: a */
    private final int[] f5397a = new int[2];

    /* renamed from: a */
    private void m5567a(ViewGroup viewGroup, JSONObject jSONObject, C2382a.C2383a aVar) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo24061a(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private void m5568b(ViewGroup viewGroup, JSONObject jSONObject, C2382a.C2383a aVar) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.mo24061a((View) it2.next(), this, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo24059a(View view) {
        if (view == null) {
            return C2388b.m5576a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f5397a);
        int[] iArr = this.f5397a;
        return C2388b.m5576a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo24060a(View view, JSONObject jSONObject, C2382a.C2383a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m5567a(viewGroup, jSONObject, aVar);
            } else {
                m5568b(viewGroup, jSONObject, aVar);
            }
        }
    }
}
