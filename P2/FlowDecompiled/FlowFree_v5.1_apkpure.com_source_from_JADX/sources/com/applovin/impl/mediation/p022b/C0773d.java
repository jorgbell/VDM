package com.applovin.impl.mediation.p022b;

import android.net.Uri;
import com.applovin.impl.mediation.C0861e;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1094f;
import com.applovin.impl.sdk.network.C1097g;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.d */
public class C0773d extends C0989a {

    /* renamed from: a */
    private final String f871a;

    /* renamed from: c */
    private final String f872c;

    /* renamed from: d */
    private final C0737e f873d;

    /* renamed from: e */
    private final Map<String, String> f874e;

    /* renamed from: f */
    private final Map<String, String> f875f;

    /* renamed from: g */
    private final C0861e f876g;

    public C0773d(String str, Map<String, String> map, C0861e eVar, C0737e eVar2, C1062k kVar) {
        super("TaskFireMediationPostbacks", kVar);
        this.f871a = str;
        this.f872c = str + "_urls";
        this.f874e = C1160r.m2741b(map);
        this.f876g = eVar != null ? eVar : C0861e.EMPTY;
        this.f873d = eVar2;
        HashMap hashMap = new HashMap(7);
        hashMap.put("AppLovin-Event-Type", str);
        hashMap.put("AppLovin-Ad-Network-Name", eVar2.mo8443J());
        if (eVar2 instanceof C0733a) {
            C0733a aVar = (C0733a) eVar2;
            hashMap.put("AppLovin-Ad-Unit-Id", aVar.getAdUnitId());
            hashMap.put("AppLovin-Ad-Format", aVar.getFormat().getLabel());
            hashMap.put("AppLovin-Third-Party-Ad-Placement-ID", aVar.mo8401i());
        }
        if (eVar != null) {
            hashMap.put("AppLovin-Error-Code", String.valueOf(eVar.getErrorCode()));
            hashMap.put("AppLovin-Error-Message", eVar.getErrorMessage());
        }
        this.f875f = hashMap;
    }

    /* renamed from: a */
    private String m1060a(String str, C0861e eVar) {
        int i;
        String str2;
        if (eVar instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) eVar;
            i = maxAdapterError.getThirdPartySdkErrorCode();
            str2 = maxAdapterError.getThirdPartySdkErrorMessage();
        } else {
            i = 0;
            str2 = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(eVar.getErrorCode())).replace("{ERROR_MESSAGE}", C1155o.m2678f(eVar.getErrorMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", C1155o.m2678f(str2));
    }

    /* renamed from: a */
    private List<String> m1061a(List<String> list, Map<String, String> map, Map<String, String> map2, C0861e eVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (String next2 : map.keySet()) {
                next = next.replace(next2, this.f873d.mo8472e(map.get(next2)));
            }
            arrayList.add(m1060a(m1066b(next, map2), eVar));
        }
        return arrayList;
    }

    /* renamed from: a */
    private Map<String, String> m1062a() {
        try {
            return C1123j.m2577a(new JSONObject((String) this.f1980b.mo9350a(C0964a.f1550i)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    /* renamed from: a */
    private void m1064a(String str, Map<String, Object> map) {
        mo9215d().mo9342S().mo9499a(C1094f.m2366o().mo9528c(str).mo9525b("POST").mo9526b(this.f875f).mo9523a(false).mo9529c(map).mo9527b(((Boolean) this.f1980b.mo9350a(C0964a.f1541S)).booleanValue()).mo9524a());
    }

    /* renamed from: a */
    private void m1065a(List<String> list) {
        if (!list.isEmpty()) {
            for (String c : list) {
                mo9215d().mo9342S().mo9499a(C1094f.m2366o().mo9528c(c).mo9523a(false).mo9526b(this.f875f).mo9524a());
            }
        }
    }

    /* renamed from: b */
    private String m1066b(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            str = str.replace(next, map.get(next));
        }
        return str;
    }

    /* renamed from: b */
    private void m1067b(List<String> list) {
        if (!list.isEmpty()) {
            for (String d : list) {
                mo9215d().mo9346W().dispatchPostbackRequest(C1097g.m2402b(mo9215d()).mo9481a(d).mo9492c(false).mo9488b(this.f875f).mo9485a(), C1020o.C1022a.MEDIATION_POSTBACKS, new AppLovinPostbackListener() {
                    public void onPostbackFailure(String str, int i) {
                        C0773d dVar = C0773d.this;
                        dVar.mo9216d("Failed to fire postback with code: " + i + " and url: " + str);
                    }

                    public void onPostbackSuccess(String str) {
                    }
                });
            }
        }
    }

    public void run() {
        List<String> d = this.f873d.mo8471d(this.f872c);
        Map<String, String> a = m1062a();
        if (((Boolean) mo9215d().mo9350a(C0964a.f1538P)).booleanValue()) {
            for (String b : d) {
                Uri parse = Uri.parse(m1060a(m1066b(b, this.f874e), this.f876g));
                Uri.Builder clearQuery = parse.buildUpon().clearQuery();
                HashMap hashMap = new HashMap(a.size());
                for (String next : parse.getQueryParameterNames()) {
                    String queryParameter = parse.getQueryParameter(next);
                    if (a.containsKey(queryParameter)) {
                        hashMap.put(next, this.f873d.mo8472e(a.get(queryParameter)));
                    } else {
                        clearQuery.appendQueryParameter(next, queryParameter);
                    }
                }
                m1064a(clearQuery.build().toString(), (Map<String, Object>) hashMap);
            }
            return;
        }
        List<String> a2 = m1061a(d, a, this.f874e, this.f876g);
        if (((Boolean) mo9215d().mo9350a(C0964a.f1551j)).booleanValue()) {
            m1065a(a2);
        } else {
            m1067b(a2);
        }
    }
}
