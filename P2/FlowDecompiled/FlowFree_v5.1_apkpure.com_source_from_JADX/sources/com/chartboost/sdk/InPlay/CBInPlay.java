package com.chartboost.sdk.InPlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.chartboost.sdk.C1274c;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Events.ChartboostError;
import com.chartboost.sdk.Libraries.C1219f;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1228a;
import com.chartboost.sdk.Model.C1229b;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Networking.C1249i;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1305g;
import com.chartboost.sdk.impl.C1318i;
import com.chartboost.sdk.impl.C1357p0;
import com.chartboost.sdk.impl.C1387w0;
import com.chartboost.sdk.impl.C1406x;
import com.mopub.mobileads.ChartboostShared;
import java.io.File;
import java.util.concurrent.Executor;

public final class CBInPlay {

    /* renamed from: a */
    private final C1305g f2655a;
    public final String appName;

    /* renamed from: b */
    private final C1247g f2656b;

    /* renamed from: c */
    private final C1234g f2657c;

    /* renamed from: d */
    private final C1249i f2658d;

    /* renamed from: e */
    private final C1228a f2659e;

    /* renamed from: f */
    private Bitmap f2660f;

    /* renamed from: g */
    private Context f2661g;
    public final File largeAppIconFile;
    public final String largeAppIconUrl;
    public final String location;

    private CBInPlay(Context context, C1305g gVar, C1247g gVar2, C1234g gVar3, C1249i iVar, C1228a aVar, String str, File file, String str2, C1387w0 w0Var) {
        this.f2661g = context;
        this.f2655a = gVar;
        this.f2656b = gVar2;
        this.f2657c = gVar3;
        this.f2658d = iVar;
        this.f2659e = aVar;
        this.appName = aVar.f2725r;
        this.largeAppIconUrl = str;
        this.largeAppIconFile = file;
        this.location = str2;
    }

    public static void cacheInPlay(String str) {
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c()) {
            if (C1406x.m3823b().mo10696a((CharSequence) str)) {
                CBLogging.m2905b("CBInPlay", "cacheInPlay location cannot be empty");
                Handler handler = b.f3493B;
                C1286a aVar = b.f3517t;
                aVar.getClass();
                handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (ChartboostError) null, false, ""));
                return;
            }
            C1236h hVar = b.f3492A.get();
            if ((!hVar.f2823q || !hVar.f2824r) && (!hVar.f2811e || !hVar.f2812f)) {
                Handler handler2 = b.f3493B;
                C1286a aVar2 = b.f3517t;
                aVar2.getClass();
                handler2.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (ChartboostError) null, false, ""));
                return;
            }
            C1305g gVar = b.f3516s;
            gVar.getClass();
            b.f3514q.execute(new C1305g.C1307b(3, str, (C1312h) null, (CBError.CBImpressionError) null));
        }
    }

    public static CBInPlay getInPlay(Context context, String str) {
        String str2 = str;
        C1414j b = C1414j.m3867b();
        CBInPlay cBInPlay = null;
        if (b != null && C1274c.m3275c()) {
            if (C1406x.m3823b().mo10696a((CharSequence) str2)) {
                CBLogging.m2905b("CBInPlay", "Inplay location cannot be empty");
                Handler handler = b.f3493B;
                C1286a aVar = b.f3517t;
                aVar.getClass();
                handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (ChartboostError) null, false, ""));
                return null;
            }
            C1236h hVar = b.f3492A.get();
            C1387w0 a = C1414j.m3860a(context);
            CBError.CBImpressionError cBImpressionError = CBError.CBImpressionError.NO_AD_FOUND;
            if ((hVar.f2823q && hVar.f2824r) || (hVar.f2811e && hVar.f2812f)) {
                C1228a f = b.f3516s.mo10422f(str2);
                if (f != null) {
                    C1229b bVar = f.f2710c.get("lg");
                    if (bVar != null) {
                        File a2 = bVar.mo10077a(b.f3516s.f3094c.mo10046a().f2680a);
                        if (!a2.exists()) {
                            cBImpressionError = CBError.CBImpressionError.ASSET_MISSING;
                        } else {
                            cBInPlay = new CBInPlay(context, b.f3516s, b.f3520w, b.f3521x, b.f3495D, f, bVar.f2730c, a2, str, a);
                        }
                    }
                    Executor executor = b.f3514q;
                    C1305g gVar = b.f3516s;
                    gVar.getClass();
                    executor.execute(new C1305g.C1307b(8, str, (C1312h) null, (CBError.CBImpressionError) null));
                }
                if (cBInPlay == null) {
                    Executor executor2 = b.f3514q;
                    C1305g gVar2 = b.f3516s;
                    gVar2.getClass();
                    executor2.execute(new C1305g.C1307b(3, str, (C1312h) null, (CBError.CBImpressionError) null));
                }
            }
            CBError.CBImpressionError cBImpressionError2 = cBImpressionError;
            if (cBInPlay == null) {
                Handler handler2 = b.f3493B;
                C1286a aVar2 = b.f3517t;
                aVar2.getClass();
                handler2.post(new C1286a.C1287a(4, str, cBImpressionError2, (ChartboostError) null, false, ""));
            }
        }
        return cBInPlay;
    }

    public static boolean hasInPlay(String str) {
        C1414j b = C1414j.m3867b();
        if (b == null || !C1274c.m3275c()) {
            return false;
        }
        if (C1406x.m3823b().mo10696a((CharSequence) str)) {
            CBLogging.m2905b("CBInPlay", "hasInPlay location cannot be empty");
            Handler handler = b.f3493B;
            C1286a aVar = b.f3517t;
            aVar.getClass();
            handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (ChartboostError) null, true, ""));
            return false;
        } else if (b.f3516s.mo10422f(str) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void click() {
        C1228a aVar = this.f2659e;
        String str = aVar.f2718k;
        String str2 = aVar.f2717j;
        String str3 = (str2.isEmpty() || !this.f2658d.mo10155a(this.f2661g, str2)) ? str : str2;
        C1357p0 p0Var = new C1357p0("https://live.chartboost.com", "/api/click", this.f2657c, 2, (C1357p0.C1358a) null);
        p0Var.mo10562a(ChartboostShared.LOCATION_KEY, (Object) this.location);
        p0Var.mo10562a("to", (Object) this.f2659e.f2721n);
        p0Var.mo10562a("cgn", (Object) this.f2659e.f2714g);
        p0Var.mo10562a("creative", (Object) this.f2659e.f2715h);
        p0Var.mo10562a("ad_id", (Object) this.f2659e.f2713f);
        p0Var.mo10562a("type", (Object) "native");
        if (str3 == null || str3.isEmpty()) {
            this.f2658d.mo10154a((C1230c) null, false, str3, CBError.CBClickError.URI_INVALID, p0Var);
        } else {
            this.f2658d.mo10153a(this.f2661g, (C1230c) null, str3, p0Var);
        }
    }

    public Bitmap getAppIcon() throws Exception {
        if (this.f2660f == null) {
            try {
                byte[] b = C1219f.m2947b(this.largeAppIconFile);
                if (b != null) {
                    this.f2660f = C1406x.m3823b().mo10692a(b);
                }
                if (this.f2660f == null) {
                    CBLogging.m2905b("CBInPlay", "Error decoding inplay bitmap " + this.largeAppIconFile.getAbsolutePath());
                    if (!this.largeAppIconFile.delete()) {
                        CBLogging.m2905b("CBInPlay", "Unable to delete corrupt inplay bitmap " + this.largeAppIconFile.getAbsolutePath());
                    }
                    throw new Exception("decodeByteArrayToBitmap returned null");
                }
            } catch (OutOfMemoryError e) {
                CBLogging.m2905b("CBInPlay", "Out of memory decoding inplay bitmap " + this.largeAppIconFile.getAbsolutePath());
                throw new Exception(e);
            }
        }
        return this.f2660f;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getLocation() {
        return this.location;
    }

    public void show() {
        C1357p0 p0Var = new C1357p0("https://live.chartboost.com", "/inplay/show", this.f2657c, 2, new C1318i(this.f2655a, this.location));
        p0Var.f2855i = 1;
        p0Var.mo10562a("inplay-dictionary", (Object) this.f2659e.f2708a);
        p0Var.mo10562a(ChartboostShared.LOCATION_KEY, (Object) this.location);
        this.f2656b.mo10147a(p0Var);
    }
}
