package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.CBError;
import java.util.IdentityHashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.f */
public abstract class C1279f {

    /* renamed from: a */
    public final Handler f2998a;

    /* renamed from: b */
    public final C1275d f2999b;

    /* renamed from: c */
    public boolean f3000c = false;

    /* renamed from: d */
    private boolean f3001d;

    /* renamed from: e */
    protected JSONObject f3002e;

    /* renamed from: f */
    private C1281b f3003f;

    /* renamed from: g */
    public final C1230c f3004g;

    /* renamed from: h */
    protected int f3005h;

    /* renamed from: i */
    public final Map<View, Runnable> f3006i = new IdentityHashMap();

    /* renamed from: j */
    protected boolean f3007j = true;

    /* renamed from: k */
    protected boolean f3008k = true;

    /* renamed from: l */
    private Context f3009l;

    /* renamed from: com.chartboost.sdk.f$a */
    class C1280a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f3010a;

        /* renamed from: b */
        final /* synthetic */ View f3011b;

        C1280a(boolean z, View view) {
            this.f3010a = z;
            this.f3011b = view;
        }

        public void run() {
            if (!this.f3010a) {
                this.f3011b.setVisibility(8);
                this.f3011b.setClickable(false);
            }
            synchronized (C1279f.this.f3006i) {
                C1279f.this.f3006i.remove(this.f3011b);
            }
        }
    }

    public C1279f(Context context, C1230c cVar, Handler handler, C1275d dVar) {
        this.f3009l = context;
        this.f2998a = handler;
        this.f2999b = dVar;
        this.f3004g = cVar;
        this.f3003f = null;
        this.f3005h = CBUtility.m2918b(context);
        this.f3001d = false;
    }

    /* renamed from: b */
    public static boolean m3312b(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    /* renamed from: a */
    public CBError.CBImpressionError mo10327a(RelativeLayout relativeLayout) {
        if (this.f3003f != null) {
            return null;
        }
        if (relativeLayout == null || relativeLayout.getContext() == null) {
            return CBError.CBImpressionError.ERROR_CREATING_VIEW;
        }
        this.f3003f = mo10328a(relativeLayout.getContext());
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C1281b mo10328a(Context context);

    /* renamed from: c */
    public void mo10338c() {
        C1281b bVar = this.f3003f;
        if (bVar != null) {
            bVar.mo10351a();
        }
        this.f3003f = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo10339d() {
        this.f3004g.mo10103s();
    }

    /* renamed from: e */
    public JSONObject mo10340e() {
        return this.f3002e;
    }

    /* renamed from: f */
    public int mo10341f() {
        return this.f3005h;
    }

    /* renamed from: g */
    public float mo10342g() {
        return 0.0f;
    }

    /* renamed from: h */
    public float mo10343h() {
        return 0.0f;
    }

    /* renamed from: i */
    public C1281b mo10344i() {
        return this.f3003f;
    }

    /* renamed from: j */
    public boolean mo10345j() {
        return false;
    }

    /* renamed from: k */
    public void mo10346k() {
        this.f3000c = true;
    }

    /* renamed from: l */
    public void mo10347l() {
        if (this.f3000c) {
            this.f3000c = false;
        }
        C1281b i = mo10344i();
        if (i == null) {
            return;
        }
        if (i.f3018f == null || CBUtility.m2918b(this.f3009l) != i.f3018f.intValue()) {
            i.mo10354a(false);
        }
    }

    /* renamed from: m */
    public void mo10348m() {
        mo10339d();
    }

    /* renamed from: n */
    public CBError.CBImpressionError mo10349n() {
        Activity e = this.f2999b.mo10306e();
        if (e == null) {
            this.f3003f = null;
            return CBError.CBImpressionError.NO_HOST_ACTIVITY;
        } else if (!this.f3008k && !this.f3007j) {
            return CBError.CBImpressionError.WRONG_ORIENTATION;
        } else {
            if (this.f3003f == null) {
                this.f3003f = mo10328a((Context) e);
            }
            if (this.f3004g.f2751q.f2709b != 0 || this.f3003f.mo10355a(e)) {
                return null;
            }
            this.f3003f = null;
            return CBError.CBImpressionError.ERROR_CREATING_VIEW;
        }
    }

    /* renamed from: com.chartboost.sdk.f$b */
    public abstract class C1281b extends RelativeLayout {

        /* renamed from: a */
        private boolean f3013a = false;

        /* renamed from: b */
        private int f3014b = -1;

        /* renamed from: c */
        private int f3015c = -1;

        /* renamed from: d */
        private int f3016d = -1;

        /* renamed from: e */
        private int f3017e = -1;

        /* renamed from: f */
        Integer f3018f = null;

        /* renamed from: g */
        private Context f3019g;

        /* renamed from: com.chartboost.sdk.f$b$a */
        class C1282a implements Runnable {
            C1282a() {
            }

            public void run() {
                C1281b.this.requestLayout();
            }
        }

        public C1281b(Context context) {
            super(context);
            this.f3019g = context;
            setFocusableInTouchMode(true);
            requestFocus();
        }

        /* renamed from: b */
        private boolean m3336b(int i, int i2) {
            Integer num;
            C1230c cVar = C1279f.this.f3004g;
            boolean z = true;
            if (cVar != null && cVar.f2751q.f2709b == 1) {
                return true;
            }
            if (this.f3013a) {
                return false;
            }
            int b = CBUtility.m2918b(this.f3019g);
            if (this.f3014b == i && this.f3015c == i2 && (num = this.f3018f) != null && num.intValue() == b) {
                return true;
            }
            this.f3013a = true;
            try {
                if (C1279f.this.f3007j && CBUtility.m2921b(b)) {
                    C1279f.this.f3005h = b;
                } else if (C1279f.this.f3008k && CBUtility.m2916a(b)) {
                    C1279f.this.f3005h = b;
                }
                mo10352a(i, i2);
                post(new C1282a());
                this.f3014b = i;
                this.f3015c = i2;
                this.f3018f = Integer.valueOf(b);
            } catch (Exception e) {
                CBLogging.m2904a("CBViewProtocol", "Exception raised while layouting Subviews", e);
                z = false;
            }
            this.f3013a = false;
            return z;
        }

        /* renamed from: a */
        public void mo10351a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo10352a(int i, int i2);

        /* renamed from: a */
        public final void mo10354a(boolean z) {
            if (z) {
                this.f3018f = null;
            }
            mo10355a((Activity) getContext());
        }

        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            synchronized (C1279f.this.f3006i) {
                for (Runnable removeCallbacks : C1279f.this.f3006i.values()) {
                    C1279f.this.f2998a.removeCallbacks(removeCallbacks);
                }
                C1279f.this.f3006i.clear();
            }
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            C1230c cVar;
            super.onSizeChanged(i, i2, i3, i4);
            this.f3016d = i;
            this.f3017e = i2;
            if (this.f3014b != -1 && this.f3015c != -1 && (cVar = C1279f.this.f3004g) != null && cVar.f2751q.f2709b == 0) {
                mo10356b();
            }
        }

        /* renamed from: a */
        public boolean mo10355a(Activity activity) {
            int i;
            int i2;
            if (this.f3016d == -1 || this.f3017e == -1) {
                try {
                    i2 = getWidth();
                    i = getHeight();
                    if (i2 == 0 || i == 0) {
                        View findViewById = activity.getWindow().findViewById(16908290);
                        if (findViewById == null) {
                            findViewById = activity.getWindow().getDecorView();
                        }
                        int width = findViewById.getWidth();
                        i = findViewById.getHeight();
                        i2 = width;
                    }
                } catch (Exception unused) {
                    i2 = 0;
                    i = 0;
                }
                if (i2 == 0 || i == 0) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    int i3 = displayMetrics.widthPixels;
                    i = displayMetrics.heightPixels;
                    i2 = i3;
                }
                this.f3016d = i2;
                this.f3017e = i;
            }
            return m3336b(this.f3016d, this.f3017e);
        }

        /* renamed from: a */
        public final void mo10353a(View view) {
            int i = 200;
            if (200 == getId()) {
                i = 201;
            }
            View findViewById = findViewById(i);
            while (findViewById != null) {
                i++;
                findViewById = findViewById(i);
            }
            view.setId(i);
            view.setSaveEnabled(false);
        }

        /* renamed from: b */
        public final void mo10356b() {
            mo10354a(false);
        }
    }

    /* renamed from: b */
    public boolean mo10337b(JSONObject jSONObject) {
        JSONObject a = C1217e.m2936a(jSONObject, "assets");
        this.f3002e = a;
        if (a != null) {
            return true;
        }
        this.f3002e = new JSONObject();
        CBLogging.m2905b("CBViewProtocol", "Media got from the response is null or empty");
        mo10331a(CBError.CBImpressionError.INVALID_RESPONSE);
        return false;
    }

    /* renamed from: a */
    public void mo10331a(CBError.CBImpressionError cBImpressionError) {
        this.f3004g.mo10085a(cBImpressionError);
    }

    /* renamed from: a */
    public void mo10329a() {
        if (!this.f3001d) {
            this.f3001d = true;
            this.f3004g.mo10102r();
        }
    }

    /* renamed from: b */
    public void mo10336b() {
        mo10338c();
        synchronized (this.f3006i) {
            for (Runnable removeCallbacks : this.f3006i.values()) {
                this.f2998a.removeCallbacks(removeCallbacks);
            }
            this.f3006i.clear();
        }
    }

    /* renamed from: a */
    public boolean mo10335a(JSONObject jSONObject) {
        return this.f3004g.mo10090b(jSONObject);
    }

    /* renamed from: a */
    public void mo10332a(String str, JSONObject jSONObject) {
        this.f3004g.mo10089b(str, jSONObject);
    }

    /* renamed from: a */
    public void mo10333a(boolean z, View view) {
        mo10334a(z, view, true);
    }

    /* renamed from: a */
    public void mo10334a(boolean z, View view, boolean z2) {
        int i = 8;
        if ((z && view.getVisibility() == 0) || (!z && view.getVisibility() == 8)) {
            synchronized (this.f3006i) {
                if (!this.f3006i.containsKey(view)) {
                    return;
                }
            }
        }
        if (!z2) {
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
            view.setClickable(z);
            return;
        }
        C1280a aVar = new C1280a(z, view);
        C1230c cVar = this.f3004g;
        int i2 = cVar.f2751q.f2709b;
        cVar.f2744j.f2989a.mo10515a(z, view, 500);
        mo10330a(view, (Runnable) aVar, 500);
    }

    /* renamed from: a */
    public void mo10330a(View view, Runnable runnable, long j) {
        synchronized (this.f3006i) {
            Runnable runnable2 = this.f3006i.get(view);
            if (runnable2 != null) {
                this.f2998a.removeCallbacks(runnable2);
            }
            this.f3006i.put(view, runnable);
        }
        this.f2998a.postDelayed(runnable, j);
    }

    /* renamed from: a */
    public static int m3311a(String str) {
        if (str != null) {
            if (!str.startsWith("#")) {
                try {
                    return Color.parseColor(str);
                } catch (IllegalArgumentException unused) {
                    str = "#" + str;
                }
            }
            if (str.length() == 4 || str.length() == 5) {
                StringBuilder sb = new StringBuilder((str.length() * 2) + 1);
                sb.append("#");
                int i = 0;
                while (i < str.length() - 1) {
                    i++;
                    sb.append(str.charAt(i));
                    sb.append(str.charAt(i));
                }
                str = sb.toString();
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException e) {
                CBLogging.m2906b("CBViewProtocol", "error parsing color " + str, e);
            }
        }
        return 0;
    }
}
