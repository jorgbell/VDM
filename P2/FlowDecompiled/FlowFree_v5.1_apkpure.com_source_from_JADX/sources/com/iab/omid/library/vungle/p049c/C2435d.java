package com.iab.omid.library.vungle.p049c;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.vungle.p049c.C2431a;
import com.iab.omid.library.vungle.p050d.C2437b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.c.d */
public class C2435d implements C2431a {

    /* renamed from: a */
    private final int[] f5492a = new int[2];

    /* renamed from: a */
    private void m5762a(ViewGroup viewGroup, JSONObject jSONObject, C2431a.C2432a aVar) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo24201a(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private void m5763b(ViewGroup viewGroup, JSONObject jSONObject, C2431a.C2432a aVar) {
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
                aVar.mo24201a((View) it2.next(), this, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo24199a(View view) {
        if (view == null) {
            return C2437b.m5771a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f5492a);
        int[] iArr = this.f5492a;
        return C2437b.m5771a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo24200a(View view, JSONObject jSONObject, C2431a.C2432a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m5762a(viewGroup, jSONObject, aVar);
            } else {
                m5763b(viewGroup, jSONObject, aVar);
            }
        }
    }
}
