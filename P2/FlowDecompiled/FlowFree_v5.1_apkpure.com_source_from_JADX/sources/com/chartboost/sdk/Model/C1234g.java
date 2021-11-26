package com.chartboost.sdk.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.chartboost.sdk.C1284h;
import com.chartboost.sdk.Libraries.C1215d;
import com.chartboost.sdk.Libraries.C1224j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Networking.C1248h;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Tracking.C1268g;
import com.chartboost.sdk.impl.C1301e1;
import com.chartboost.sdk.impl.C1304f1;
import com.chartboost.sdk.impl.C1311g1;
import com.chartboost.sdk.impl.C1327i1;
import com.chartboost.sdk.impl.C1387w0;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.g */
public class C1234g {

    /* renamed from: a */
    public final C1215d f2778a;

    /* renamed from: b */
    public final C1248h f2779b;

    /* renamed from: c */
    public final AtomicReference<C1236h> f2780c;

    /* renamed from: d */
    public final C1224j f2781d;

    /* renamed from: e */
    public final String f2782e;

    /* renamed from: f */
    public final String f2783f;

    /* renamed from: g */
    public final String f2784g;

    /* renamed from: h */
    public final String f2785h;

    /* renamed from: i */
    public String f2786i;

    /* renamed from: j */
    public String f2787j;

    /* renamed from: k */
    public final String f2788k;

    /* renamed from: l */
    public final String f2789l;

    /* renamed from: m */
    public final String f2790m;

    /* renamed from: n */
    public final String f2791n;

    /* renamed from: o */
    public final JSONObject f2792o;

    /* renamed from: p */
    public final String f2793p;

    /* renamed from: q */
    public final boolean f2794q;

    /* renamed from: r */
    public final String f2795r;

    /* renamed from: s */
    public final C1387w0 f2796s;

    /* renamed from: t */
    private final C1268g f2797t;

    /* renamed from: u */
    private final Context f2798u;

    /* renamed from: com.chartboost.sdk.Model.g$a */
    public static class C1235a {

        /* renamed from: a */
        public int f2799a = 0;

        /* renamed from: b */
        public int f2800b = 0;

        /* renamed from: c */
        public int f2801c = 0;

        /* renamed from: d */
        public int f2802d = 0;

        /* renamed from: e */
        public float f2803e = 0.0f;

        /* renamed from: f */
        public String f2804f = "";
    }

    public C1234g(Context context, String str, C1215d dVar, C1248h hVar, AtomicReference<C1236h> atomicReference, SharedPreferences sharedPreferences, C1224j jVar, C1304f1 f1Var, C1268g gVar, C1387w0 w0Var) {
        String str2;
        this.f2798u = context;
        this.f2778a = dVar;
        this.f2779b = hVar;
        this.f2780c = atomicReference;
        this.f2781d = jVar;
        this.f2797t = gVar;
        this.f2796s = w0Var;
        this.f2789l = str;
        String str3 = Build.PRODUCT;
        if ("sdk".equals(str3) || "google_sdk".equals(str3) || ((str2 = Build.MANUFACTURER) != null && str2.contains("Genymotion"))) {
            this.f2782e = "Android Simulator";
        } else {
            this.f2782e = Build.MODEL;
        }
        this.f2790m = Build.MANUFACTURER + " " + Build.MODEL;
        this.f2791n = C1327i1.m3550d(context);
        this.f2783f = "Android " + Build.VERSION.RELEASE;
        this.f2784g = Locale.getDefault().getCountry();
        this.f2785h = Locale.getDefault().getLanguage();
        this.f2788k = "8.2.0";
        try {
            String packageName = context.getPackageName();
            this.f2786i = context.getPackageManager().getPackageInfo(packageName, 128).versionName;
            this.f2787j = packageName;
        } catch (Exception e) {
            CBLogging.m2904a("RequestBody", "Exception raised getting package mager object", e);
        }
        C1301e1 a = m3047a(context, f1Var);
        this.f2793p = m3048a(a);
        this.f2792o = m3049a(a, f1Var);
        this.f2794q = CBUtility.m2926f();
        this.f2795r = CBUtility.m2924d();
        hVar.mo10148a(context);
    }

    /* renamed from: a */
    public int mo10116a() {
        return this.f2779b.mo10148a(this.f2798u);
    }

    /* renamed from: b */
    public int mo10118b() {
        return this.f2779b.mo10150b();
    }

    /* renamed from: c */
    public String mo10119c() {
        return this.f2779b.mo10149a();
    }

    /* renamed from: d */
    public C1235a mo10120d() {
        C1235a aVar = new C1235a();
        Context context = this.f2798u;
        if (context == null) {
            return aVar;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        aVar.f2799a = displayMetrics.widthPixels;
        aVar.f2800b = displayMetrics.heightPixels;
        DisplayMetrics displayMetrics2 = (DisplayMetrics) C1284h.m3343a().mo10361a(new DisplayMetrics());
        displayMetrics2.setTo(displayMetrics);
        WindowManager windowManager = (WindowManager) this.f2798u.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics2);
        }
        aVar.f2801c = displayMetrics2.widthPixels;
        aVar.f2802d = displayMetrics2.heightPixels;
        aVar.f2803e = displayMetrics2.density;
        aVar.f2804f = "" + displayMetrics2.densityDpi;
        return aVar;
    }

    /* renamed from: e */
    public C1215d.C1216a mo10121e() {
        return this.f2778a.mo10043c(this.f2798u);
    }

    /* renamed from: f */
    public int mo10122f() {
        return this.f2796s.mo10666a();
    }

    /* renamed from: g */
    public int mo10123g() {
        return this.f2796s.mo10670b();
    }

    /* renamed from: h */
    public JSONObject mo10124h() {
        return this.f2796s.mo10672c();
    }

    /* renamed from: i */
    public C1268g mo10125i() {
        return this.f2797t;
    }

    /* renamed from: j */
    public int mo10126j() {
        C1268g gVar = this.f2797t;
        if (gVar != null) {
            return gVar.mo10261c();
        }
        return -1;
    }

    /* renamed from: k */
    public List<DataUseConsent> mo10127k() {
        return this.f2796s.mo10673d();
    }

    /* renamed from: l */
    public boolean mo10128l() {
        return CBUtility.m2921b(CBUtility.m2918b(this.f2798u));
    }

    /* renamed from: a */
    private String m3048a(C1301e1 e1Var) {
        return e1Var != null ? e1Var.mo10407d() : "";
    }

    /* renamed from: a */
    private JSONObject m3049a(C1301e1 e1Var, C1304f1 f1Var) {
        if (e1Var == null || f1Var == null) {
            return new JSONObject();
        }
        return mo10117a(e1Var, new C1311g1());
    }

    /* renamed from: a */
    private C1301e1 m3047a(Context context, C1304f1 f1Var) {
        if (f1Var != null) {
            return f1Var.mo10411a(context);
        }
        return null;
    }

    /* renamed from: a */
    public JSONObject mo10117a(C1301e1 e1Var, C1311g1 g1Var) {
        if (g1Var != null) {
            return g1Var.mo10433a(e1Var);
        }
        return new JSONObject();
    }
}
