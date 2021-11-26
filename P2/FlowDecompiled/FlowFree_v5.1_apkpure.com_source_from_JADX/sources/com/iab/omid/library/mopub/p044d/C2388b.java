package com.iab.omid.library.mopub.p044d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.iab.omid.library.mopub.p042b.C2376c;
import com.iab.omid.library.mopub.walking.C2403a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.d.b */
public class C2388b {

    /* renamed from: a */
    static float f5398a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f5399b;

    /* renamed from: c */
    private static String[] f5400c = {"x", "y", "width", "height"};

    /* renamed from: com.iab.omid.library.mopub.d.b$a */
    private static class C2389a {

        /* renamed from: a */
        final float f5401a;

        /* renamed from: b */
        final float f5402b;

        C2389a(float f, float f2) {
            this.f5401a = f;
            this.f5402b = f2;
        }
    }

    /* renamed from: a */
    static float m5575a(int i) {
        return ((float) i) / f5398a;
    }

    /* renamed from: a */
    public static JSONObject m5576a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m5575a(i));
            jSONObject.put("y", (double) m5575a(i2));
            jSONObject.put("width", (double) m5575a(i3));
            jSONObject.put("height", (double) m5575a(i4));
        } catch (JSONException e) {
            C2390c.m5592a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m5577a(Context context) {
        if (context != null) {
            f5398a = context.getResources().getDisplayMetrics().density;
            f5399b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m5578a(JSONObject jSONObject) {
        C2389a b = m5584b(jSONObject);
        try {
            jSONObject.put("width", (double) b.f5401a);
            jSONObject.put("height", (double) b.f5402b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m5579a(JSONObject jSONObject, C2403a.C2404a aVar) {
        C2376c a = aVar.mo24109a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.mo24111b()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a.mo24034b());
            jSONObject.put("friendlyObstructionPurpose", a.mo24035c());
            jSONObject.put("friendlyObstructionReason", a.mo24036d());
        } catch (JSONException e) {
            C2390c.m5592a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m5580a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C2390c.m5592a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m5581a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C2390c.m5592a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m5582a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m5583a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    private static C2389a m5584b(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
                return new C2389a(f2, f);
            }
        } else if (f5399b != null) {
            Point point = new Point(0, 0);
            f5399b.getDefaultDisplay().getRealSize(point);
            f2 = m5575a(point.x);
            f = m5575a(point.y);
            return new C2389a(f2, f);
        }
        f = 0.0f;
        return new C2389a(f2, f);
    }

    /* renamed from: b */
    public static void m5585b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C2390c.m5592a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: b */
    public static boolean m5586b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m5587c(jSONObject, jSONObject2) && m5588d(jSONObject, jSONObject2) && m5589e(jSONObject, jSONObject2) && m5590f(jSONObject, jSONObject2);
    }

    /* renamed from: c */
    private static boolean m5587c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f5400c) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m5588d(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: e */
    private static boolean m5589e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m5583a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!optJSONArray.optString(i, "").equals(optJSONArray2.optString(i, ""))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m5590f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m5583a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m5586b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
