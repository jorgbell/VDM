package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.j */
public class C1123j {
    /* renamed from: a */
    public static double m2564a(JSONObject jSONObject, String str, double d, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return d;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException e) {
            if (kVar == null) {
                return d;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve double property for key = " + str, e);
            return d;
        }
    }

    /* renamed from: a */
    public static float m2565a(JSONObject jSONObject, String str, float f, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f;
        }
        try {
            double d = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d || d >= 3.4028234663852886E38d) ? f : (float) d;
        } catch (JSONException e) {
            if (kVar == null) {
                return f;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve float property for key = " + str, e);
            return f;
        }
    }

    /* renamed from: a */
    public static long m2566a(JSONObject jSONObject, String str, long j, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return j;
        }
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e) {
            if (kVar == null) {
                return j;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve long property for key = " + str, e);
            return j;
        }
    }

    /* renamed from: a */
    public static Bundle m2567a(Object obj) {
        JSONObject jSONObject;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            if (obj instanceof String) {
                try {
                    jSONObject = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            jSONObject = null;
        }
        return m2602c(jSONObject);
    }

    /* renamed from: a */
    public static Boolean m2568a(JSONObject jSONObject, String str, Boolean bool, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return bool;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (JSONException unused) {
            boolean z = true;
            if (m2592b(jSONObject, str, (bool == null || !bool.booleanValue()) ? 0 : 1, kVar) <= 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    public static Float m2569a(JSONObject jSONObject, String str, Float f, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f;
        }
        try {
            double d = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d || d >= 3.4028234663852886E38d) ? f : Float.valueOf((float) d);
        } catch (JSONException e) {
            if (kVar == null) {
                return f;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve float property for key = " + str, e);
            return f;
        }
    }

    /* renamed from: a */
    public static Object m2570a(JSONArray jSONArray, int i, Object obj, C1062k kVar) {
        if (jSONArray == null || jSONArray.length() <= i) {
            return obj;
        }
        try {
            return jSONArray.get(i);
        } catch (JSONException e) {
            if (kVar == null) {
                return obj;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve object at index " + i + " for JSON array", e);
            return obj;
        }
    }

    /* renamed from: a */
    public static String m2571a(Map<String, Object> map, String str, C1062k kVar) {
        try {
            return m2580a((Map<String, ?>) map).toString();
        } catch (JSONException e) {
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to convert map '" + map + "' to JSON string.", e);
            return str;
        }
    }

    /* renamed from: a */
    public static ArrayList<Bundle> m2572a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m2602c(jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <T> List<T> m2573a(JSONArray jSONArray, List<T> list) {
        try {
            return m2596b(jSONArray, list);
        } catch (JSONException unused) {
            return list;
        }
    }

    /* renamed from: a */
    public static List m2574a(JSONObject jSONObject, String str, List list, C1062k kVar) {
        try {
            JSONArray b = m2599b(jSONObject, str, (JSONArray) null, kVar);
            return b != null ? m2595b(b) : list;
        } catch (JSONException unused) {
            return list;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m2575a(Bundle bundle) {
        if (bundle == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            hashMap.put(str, String.valueOf(bundle.get(str)));
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, Object> m2576a(String str, Map<String, Object> map, C1062k kVar) {
        try {
            return m2597b(new JSONObject(str));
        } catch (JSONException e) {
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to convert json string '" + str + "' to map", e);
            return map;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m2577a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, m2603c(jSONObject.get(next)).toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONObject m2578a(String str, C1062k kVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            C1107r z = kVar.mo9411z();
            z.mo9588e("JsonUtils", "Failed to deserialize into JSON: " + str);
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m2579a(String str, JSONObject jSONObject, C1062k kVar) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (kVar != null) {
                C1107r z = kVar.mo9411z();
                z.mo9585b("JsonUtils", "Failed to convert JSON string '" + str + "' to JSONObject", e);
            }
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static JSONObject m2580a(Map<String, ?> map) throws JSONException {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m2581a(JSONArray jSONArray, int i, JSONObject jSONObject, C1062k kVar) {
        if (jSONArray == null || i >= jSONArray.length()) {
            return jSONObject;
        }
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            if (kVar == null) {
                return jSONObject;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve JSON object from array for index = " + i, e);
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static void m2582a(JSONObject jSONObject, String str, int i, C1062k kVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, i);
            } catch (JSONException e) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("JsonUtils", "Failed to put int property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2583a(JSONObject jSONObject, String str, Object obj, C1062k kVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("JsonUtils", "Failed to put Object property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2584a(JSONObject jSONObject, String str, String str2, C1062k kVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("JsonUtils", "Failed to put String property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2585a(JSONObject jSONObject, String str, JSONArray jSONArray, C1062k kVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException e) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("JsonUtils", "Failed to put JSONArray property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2586a(JSONObject jSONObject, String str, JSONObject jSONObject2, C1062k kVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException e) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("JsonUtils", "Failed to put JSON property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2587a(JSONObject jSONObject, String str, boolean z, C1062k kVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, z);
            } catch (JSONException e) {
                if (kVar != null) {
                    C1107r z2 = kVar.mo9411z();
                    z2.mo9585b("JsonUtils", "Failed to put boolean property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2588a(JSONObject jSONObject, JSONObject jSONObject2, C1062k kVar) {
        if (jSONObject != null && jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object b = m2593b(jSONObject2, next, (Object) null, kVar);
                if (b != null) {
                    m2583a(jSONObject, next, b, kVar);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2589a(JSONObject jSONObject, String[] strArr) {
        for (String remove : strArr) {
            jSONObject.remove(remove);
        }
    }

    /* renamed from: a */
    public static boolean m2590a(String str, JSONArray jSONArray) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                Object obj = jSONArray.get(i);
                if ((obj instanceof String) && ((String) obj).equalsIgnoreCase(str)) {
                    return true;
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2591a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: b */
    public static int m2592b(JSONObject jSONObject, String str, int i, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return i;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            if (kVar == null) {
                return i;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve int property for key = " + str, e);
            return i;
        }
    }

    /* renamed from: b */
    public static Object m2593b(JSONObject jSONObject, String str, Object obj, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return obj;
        }
        try {
            Object obj2 = jSONObject.get(str);
            return obj2 != null ? obj2 : obj;
        } catch (JSONException e) {
            if (kVar == null) {
                return obj;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve Object for key = " + str, e);
            return obj;
        }
    }

    /* renamed from: b */
    public static String m2594b(JSONObject jSONObject, String str, String str2, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return str2;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            if (kVar == null) {
                return str2;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve string property for key = " + str, e);
            return str2;
        }
    }

    /* renamed from: b */
    public static <T> List<T> m2595b(JSONArray jSONArray) throws JSONException {
        return m2596b(jSONArray, new ArrayList());
    }

    /* renamed from: b */
    private static <T> List<T> m2596b(JSONArray jSONArray, List<T> list) throws JSONException {
        if (jSONArray == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m2603c(jSONArray.get(i)));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static Map<String, Object> m2597b(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, m2603c(jSONObject.get(next)));
        }
        return hashMap;
    }

    /* renamed from: b */
    public static JSONArray m2598b(Object obj) {
        if (obj == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(obj);
        return jSONArray;
    }

    /* renamed from: b */
    public static JSONArray m2599b(JSONObject jSONObject, String str, JSONArray jSONArray, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONArray;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            if (kVar == null) {
                return jSONArray;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve JSON array for key = " + str, e);
            return jSONArray;
        }
    }

    /* renamed from: b */
    public static JSONObject m2600b(JSONObject jSONObject, String str, JSONObject jSONObject2, C1062k kVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONObject2;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            if (kVar == null) {
                return jSONObject2;
            }
            C1107r z = kVar.mo9411z();
            z.mo9585b("JsonUtils", "Failed to retrieve JSON property for key = " + str, e);
            return jSONObject2;
        }
    }

    /* renamed from: b */
    public static void m2601b(JSONObject jSONObject, String str, long j, C1062k kVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, j);
            } catch (JSONException e) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("JsonUtils", "Failed to put long property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: c */
    public static Bundle m2602c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (jSONObject.isNull(next)) {
                bundle.putString(next, (String) null);
            } else {
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    bundle.putBundle(next, m2602c((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (jSONArray.length() == 0) {
                        bundle.putStringArrayList(next, new ArrayList(0));
                    } else if (m2570a(jSONArray, 0, (Object) null, (C1062k) null) instanceof String) {
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add((String) m2570a(jSONArray, i, (Object) null, (C1062k) null));
                        }
                        bundle.putStringArrayList(next, arrayList);
                    } else {
                        bundle.putParcelableArrayList(next, m2572a(jSONArray));
                    }
                } else if (opt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) opt).booleanValue());
                } else if (opt instanceof String) {
                    bundle.putString(next, (String) opt);
                } else if (opt instanceof Integer) {
                    bundle.putInt(next, ((Integer) opt).intValue());
                } else if (opt instanceof Long) {
                    bundle.putLong(next, ((Long) opt).longValue());
                } else if (opt instanceof Double) {
                    bundle.putDouble(next, ((Double) opt).doubleValue());
                }
            }
        }
        return bundle;
    }

    /* renamed from: c */
    private static Object m2603c(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof JSONObject ? m2597b((JSONObject) obj) : obj instanceof JSONArray ? m2595b((JSONArray) obj) : obj;
    }

    /* renamed from: c */
    public static JSONArray m2604c(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    obj = m2606e((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = m2604c((JSONArray) obj);
                }
                jSONArray2.put(i, obj);
            } catch (JSONException unused) {
                C1107r.m2483h("JsonUtils", "Failed to copy over item at index " + i + " to JSONArray deep copy");
            }
        }
        return jSONArray2;
    }

    /* renamed from: d */
    public static JSONObject m2605d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.get(next));
            } catch (JSONException unused) {
                C1107r.m2483h("JsonUtils", "Failed to copy over item for key '" + next + "' to JSONObject copy");
            }
        }
        return jSONObject2;
    }

    /* renamed from: e */
    public static JSONObject m2606e(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    obj = m2606e((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = m2604c((JSONArray) obj);
                }
                jSONObject2.put(next, obj);
            } catch (JSONException unused) {
                C1107r.m2483h("JsonUtils", "Failed to copy over item for key '" + next + "' to JSONObject deep copy");
            }
        }
        return jSONObject2;
    }

    /* renamed from: f */
    public static String m2607f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.toString(4);
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }
}
