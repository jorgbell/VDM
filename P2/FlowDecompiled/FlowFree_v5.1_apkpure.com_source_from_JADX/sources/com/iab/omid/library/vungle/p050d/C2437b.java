package com.iab.omid.library.vungle.p050d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.iab.omid.library.vungle.p048b.C2426c;
import com.iab.omid.library.vungle.walking.C2452a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.d.b */
public class C2437b {

    /* renamed from: a */
    static float f5493a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f5494b;

    /* renamed from: c */
    private static String[] f5495c = {"x", "y", "width", "height"};

    /* renamed from: com.iab.omid.library.vungle.d.b$a */
    private static class C2438a {

        /* renamed from: a */
        final float f5496a;

        /* renamed from: b */
        final float f5497b;

        C2438a(float f, float f2) {
            this.f5496a = f;
            this.f5497b = f2;
        }
    }

    /* renamed from: a */
    static float m5770a(int i) {
        return ((float) i) / f5493a;
    }

    /* renamed from: a */
    public static JSONObject m5771a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m5770a(i));
            jSONObject.put("y", (double) m5770a(i2));
            jSONObject.put("width", (double) m5770a(i3));
            jSONObject.put("height", (double) m5770a(i4));
        } catch (JSONException e) {
            C2439c.m5787a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m5772a(Context context) {
        if (context != null) {
            f5493a = context.getResources().getDisplayMetrics().density;
            f5494b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m5773a(JSONObject jSONObject) {
        C2438a b = m5779b(jSONObject);
        try {
            jSONObject.put("width", (double) b.f5496a);
            jSONObject.put("height", (double) b.f5497b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m5774a(JSONObject jSONObject, C2452a.C2453a aVar) {
        C2426c a = aVar.mo24240a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.mo24242b()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a.mo24178b());
            jSONObject.put("friendlyObstructionPurpose", a.mo24179c());
            jSONObject.put("friendlyObstructionReason", a.mo24180d());
        } catch (JSONException e) {
            C2439c.m5787a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m5775a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C2439c.m5787a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m5776a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C2439c.m5787a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m5777a(JSONObject jSONObject, JSONObject jSONObject2) {
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
    private static boolean m5778a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    private static C2438a m5779b(JSONObject jSONObject) {
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
                return new C2438a(f2, f);
            }
        } else if (f5494b != null) {
            Point point = new Point(0, 0);
            f5494b.getDefaultDisplay().getRealSize(point);
            f2 = m5770a(point.x);
            f = m5770a(point.y);
            return new C2438a(f2, f);
        }
        f = 0.0f;
        return new C2438a(f2, f);
    }

    /* renamed from: b */
    public static void m5780b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C2439c.m5787a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: b */
    public static boolean m5781b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m5782c(jSONObject, jSONObject2) && m5783d(jSONObject, jSONObject2) && m5784e(jSONObject, jSONObject2) && m5785f(jSONObject, jSONObject2);
    }

    /* renamed from: c */
    private static boolean m5782c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f5495c) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m5783d(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: e */
    private static boolean m5784e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m5778a(optJSONArray, optJSONArray2)) {
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
    private static boolean m5785f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m5778a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m5781b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
