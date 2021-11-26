package com.chartboost.sdk.Model;

import com.mopub.common.AdType;
import com.mopub.common.Constants;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.a */
public class C1228a {

    /* renamed from: a */
    public final JSONObject f2708a;

    /* renamed from: b */
    public int f2709b;

    /* renamed from: c */
    public final Map<String, C1229b> f2710c;

    /* renamed from: d */
    public final Map<String, String> f2711d;

    /* renamed from: e */
    public final String f2712e;

    /* renamed from: f */
    public String f2713f;

    /* renamed from: g */
    public String f2714g;

    /* renamed from: h */
    public String f2715h;

    /* renamed from: i */
    public String f2716i;

    /* renamed from: j */
    public final String f2717j;

    /* renamed from: k */
    public final String f2718k;

    /* renamed from: l */
    public final int f2719l;

    /* renamed from: m */
    public final String f2720m;

    /* renamed from: n */
    public final String f2721n;

    /* renamed from: o */
    public final Map<String, List<String>> f2722o;

    /* renamed from: p */
    public final int f2723p;

    /* renamed from: q */
    public String f2724q;

    /* renamed from: r */
    public final String f2725r;

    /* renamed from: s */
    public C1229b f2726s;

    /* renamed from: t */
    public final HashSet<String> f2727t;

    public C1228a() {
        this.f2708a = null;
        this.f2709b = 1;
        this.f2710c = new HashMap();
        this.f2711d = new HashMap();
        this.f2712e = "dummy_template";
        this.f2713f = "";
        this.f2714g = "";
        this.f2715h = "";
        this.f2716i = "";
        this.f2717j = "";
        this.f2718k = "";
        this.f2719l = 0;
        this.f2720m = "";
        this.f2721n = "";
        this.f2722o = new HashMap();
        this.f2723p = 0;
        this.f2724q = "";
        this.f2725r = "";
        this.f2726s = new C1229b("", "", "");
        this.f2727t = new HashSet<>();
    }

    public C1228a(int i, JSONObject jSONObject, boolean z) throws JSONException {
        String str;
        this.f2709b = i;
        this.f2708a = jSONObject;
        this.f2713f = jSONObject.getString("ad_id");
        this.f2714g = jSONObject.getString("cgn");
        this.f2715h = jSONObject.getString("creative");
        this.f2717j = jSONObject.optString("deep-link");
        this.f2718k = jSONObject.getString("link");
        this.f2721n = jSONObject.getString("to");
        this.f2723p = jSONObject.optInt("animation");
        this.f2724q = jSONObject.optString("media-type");
        this.f2725r = jSONObject.optString(MediationMetaData.KEY_NAME);
        HashMap hashMap = new HashMap();
        this.f2710c = hashMap;
        this.f2711d = new HashMap();
        this.f2722o = new HashMap();
        this.f2727t = new HashSet<>();
        String str2 = "";
        if (i == 1) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("webview");
            JSONArray jSONArray = jSONObject2.getJSONArray("elements");
            int i2 = 0;
            int i3 = 0;
            while (true) {
                str = "body";
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                String string = jSONObject3.getString(MediationMetaData.KEY_NAME);
                String optString = jSONObject3.optString("param");
                String string2 = jSONObject3.getString("type");
                String string3 = jSONObject3.getString("value");
                if ("impression_id".equals(string)) {
                    this.f2716i = string3;
                }
                if (string2.equals("param")) {
                    this.f2711d.put(optString, string3);
                    if (string.equals("reward_amount")) {
                        i3 = Integer.valueOf(string3).intValue();
                    } else if (string.equals("reward_currency")) {
                        str2 = string3;
                    }
                } else {
                    this.f2710c.put((!string2.equals(AdType.HTML) || !optString.isEmpty()) ? optString.isEmpty() ? string : optString : str, new C1229b(string2, string, string3));
                }
                i2++;
            }
            this.f2719l = i3;
            this.f2720m = str2;
            C1229b bVar = this.f2710c.get(str);
            this.f2726s = bVar;
            if (bVar != null) {
                this.f2712e = jSONObject2.getString("template");
                JSONObject optJSONObject = jSONObject.optJSONObject(Constants.VIDEO_TRACKING_EVENTS_KEY);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray jSONArray2 = optJSONObject.getJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                            arrayList.add(jSONArray2.getString(i4));
                        }
                        this.f2722o.put(next, arrayList);
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("certification_providers");
                if (optJSONArray != null) {
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        this.f2727t.add(optJSONArray.getString(i5));
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("WebView AdUnit does not have a template html body asset");
        }
        if (z) {
            String string4 = jSONObject.getJSONObject("icons").getString("lg");
            hashMap.put("lg", new C1229b("inPlayIcons", string4.substring(string4.lastIndexOf("/") + 1), string4));
            this.f2719l = 0;
            this.f2720m = str2;
        } else {
            JSONObject jSONObject4 = jSONObject.getJSONObject("assets");
            Iterator<String> keys2 = jSONObject4.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject jSONObject5 = jSONObject4.getJSONObject(next2);
                String str3 = (next2.equals("video-portrait") || next2.equals("video-landscape")) ? "videos" : "images";
                String optString2 = jSONObject5.optString("id", (String) null);
                if (optString2 == null) {
                    optString2 = jSONObject5.getString("checksum") + ".png";
                }
                this.f2710c.put(next2, new C1229b(str3, optString2, jSONObject5.getString("url")));
            }
            this.f2719l = jSONObject.optInt("reward");
            this.f2720m = jSONObject.optString("currency-name");
        }
        this.f2726s = null;
        this.f2712e = str2;
    }
}
