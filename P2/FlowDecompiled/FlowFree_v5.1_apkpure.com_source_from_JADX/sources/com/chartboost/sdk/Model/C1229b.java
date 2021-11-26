package com.chartboost.sdk.Model;

import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.mopub.common.AdType;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.b */
public class C1229b {

    /* renamed from: a */
    public final String f2728a;

    /* renamed from: b */
    public final String f2729b;

    /* renamed from: c */
    public final String f2730c;

    public C1229b(String str, String str2, String str3) {
        this.f2728a = str;
        this.f2729b = str2;
        this.f2730c = str3;
    }

    /* renamed from: a */
    private static Map<String, C1229b> m2978a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            CBLogging.m2903a("Asset", "deserializeAssets assetsJson is null");
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next2);
                hashMap.put(next2, new C1229b(next, jSONObject3.getString("filename"), jSONObject3.getString("url")));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static Map<String, C1229b> m2982b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("videos");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("id");
                    hashMap.put(string, new C1229b("videos", string, jSONObject2.getString("video")));
                } catch (JSONException e) {
                    CBLogging.m2905b("Asset", "deserializeNativeVideos (file): " + e.toString());
                }
            }
        } catch (JSONException e2) {
            CBLogging.m2905b("Asset", "deserializeNativeVideos (videos array): " + e2.toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    private static JSONObject m2981a(JSONArray jSONArray) throws JSONException {
        JSONObject a = C1217e.m2937a(new C1217e.C1218a[0]);
        if (jSONArray == null) {
            return a;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String optString = jSONObject.optString(MediationMetaData.KEY_NAME);
            String optString2 = jSONObject.optString("type");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("param");
            if (!"param".equals(optString2) && optString4.isEmpty()) {
                JSONObject optJSONObject = a.optJSONObject(optString2);
                if (optJSONObject == null) {
                    optJSONObject = C1217e.m2937a(new C1217e.C1218a[0]);
                    a.put(optString2, optJSONObject);
                }
                optJSONObject.put(AdType.HTML.equals(optString2) ? "body" : optString, C1217e.m2937a(C1217e.m2935a("filename", (Object) optString), C1217e.m2935a("url", (Object) optString3)));
            }
        }
        return a;
    }

    /* renamed from: b */
    public static Map<String, C1229b> m2983b(JSONObject jSONObject, int i) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("cache_assets");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("templates".equals(next)) {
                    hashMap.putAll(m2979a(jSONObject2, i));
                } else {
                    hashMap.putAll(m2980a(jSONObject2, next));
                }
            }
        } catch (JSONException e) {
            CBLogging.m2905b("Asset", "v2PrefetchToAssets: " + e.toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, C1229b> m2979a(JSONObject jSONObject, int i) throws JSONException {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("templates")) == null)) {
            int min = Math.min(i, optJSONArray.length());
            for (int i2 = 0; i2 < min; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                JSONObject jSONObject3 = null;
                if (jSONObject2 != null) {
                    jSONObject3 = m2981a(jSONObject2.getJSONArray("elements"));
                }
                for (Map.Entry<String, C1229b> value : m2978a(jSONObject3).entrySet()) {
                    C1229b bVar = (C1229b) value.getValue();
                    hashMap.put(bVar.f2729b, bVar);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, C1229b> m2980a(JSONObject jSONObject, String str) throws JSONException {
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || str == null)) {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString(MediationMetaData.KEY_NAME);
                hashMap.put(string, new C1229b(str, string, jSONObject2.getString("value")));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public File mo10077a(File file) {
        if (this.f2728a == null || this.f2729b == null) {
            CBLogging.m2903a("Asset", "Cannot create file. Directory or filename is null.");
        } else {
            String str = this.f2728a + "/" + this.f2729b;
            try {
                return new File(file, str);
            } catch (Exception e) {
                CBLogging.m2903a("Asset", "Cannot create file for path: " + str + ". Error: " + e.toString());
            }
        }
        return null;
    }
}
