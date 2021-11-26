package com.chartboost.sdk.Networking;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.chartboost.sdk.C1272a;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1357p0;
import com.mopub.common.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executor;

/* renamed from: com.chartboost.sdk.Networking.i */
public class C1249i {

    /* renamed from: a */
    private final Executor f2871a;

    /* renamed from: b */
    private final C1247g f2872b;

    /* renamed from: c */
    final C1248h f2873c;

    /* renamed from: d */
    final Handler f2874d;

    /* renamed from: com.chartboost.sdk.Networking.i$a */
    class C1250a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f2875a;

        /* renamed from: b */
        final /* synthetic */ Context f2876b;

        /* renamed from: c */
        final /* synthetic */ C1230c f2877c;

        /* renamed from: d */
        final /* synthetic */ C1357p0 f2878d;

        /* renamed from: com.chartboost.sdk.Networking.i$a$a */
        class C1251a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f2880a;

            C1251a(String str) {
                this.f2880a = str;
            }

            public void run() {
                try {
                    C1250a aVar = C1250a.this;
                    C1249i.this.mo10157c(aVar.f2876b, aVar.f2877c, this.f2880a, aVar.f2878d);
                } catch (Exception e) {
                    CBLogging.m2905b("CBURLOpener", "open openOnUiThread Runnable.run: " + e.toString());
                }
            }
        }

        C1250a(String str, Context context, C1230c cVar, C1357p0 p0Var) {
            this.f2875a = str;
            this.f2876b = context;
            this.f2877c = cVar;
            this.f2878d = p0Var;
        }

        /* renamed from: a */
        private void m3106a(String str) {
            C1249i.this.f2874d.post(new C1251a(str));
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x004e A[Catch:{ Exception -> 0x0056 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = "CBURLOpener"
                java.lang.String r1 = r6.f2875a     // Catch:{ Exception -> 0x0056 }
                com.chartboost.sdk.Networking.i r2 = com.chartboost.sdk.Networking.C1249i.this     // Catch:{ Exception -> 0x0056 }
                com.chartboost.sdk.Networking.h r2 = r2.f2873c     // Catch:{ Exception -> 0x0056 }
                boolean r2 = r2.mo10152d()     // Catch:{ Exception -> 0x0056 }
                if (r2 == 0) goto L_0x0052
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
                java.lang.String r4 = r6.f2875a     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
                r2 = 0
                r3.setInstanceFollowRedirects(r2)     // Catch:{ Exception -> 0x0037 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r3.setConnectTimeout(r2)     // Catch:{ Exception -> 0x0037 }
                r3.setReadTimeout(r2)     // Catch:{ Exception -> 0x0037 }
                java.lang.String r2 = "Location"
                java.lang.String r2 = r3.getHeaderField(r2)     // Catch:{ Exception -> 0x0037 }
                if (r2 == 0) goto L_0x0031
                r1 = r2
            L_0x0031:
                if (r3 == 0) goto L_0x0052
                r3.disconnect()     // Catch:{ Exception -> 0x0056 }
                goto L_0x0052
            L_0x0037:
                r2 = move-exception
                goto L_0x003f
            L_0x0039:
                r1 = move-exception
                goto L_0x004c
            L_0x003b:
                r3 = move-exception
                r5 = r3
                r3 = r2
                r2 = r5
            L_0x003f:
                java.lang.String r4 = "Exception raised while opening a HTTP Conection"
                com.chartboost.sdk.Libraries.CBLogging.m2904a(r0, r4, r2)     // Catch:{ all -> 0x004a }
                if (r3 == 0) goto L_0x0052
                r3.disconnect()     // Catch:{ Exception -> 0x0056 }
                goto L_0x0052
            L_0x004a:
                r1 = move-exception
                r2 = r3
            L_0x004c:
                if (r2 == 0) goto L_0x0051
                r2.disconnect()     // Catch:{ Exception -> 0x0056 }
            L_0x0051:
                throw r1     // Catch:{ Exception -> 0x0056 }
            L_0x0052:
                r6.m3106a(r1)     // Catch:{ Exception -> 0x0056 }
                goto L_0x006f
            L_0x0056:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "open followTask: "
                r2.append(r3)
                java.lang.String r1 = r1.toString()
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                com.chartboost.sdk.Libraries.CBLogging.m2905b(r0, r1)
            L_0x006f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Networking.C1249i.C1250a.run():void");
        }
    }

    public C1249i(Executor executor, C1247g gVar, C1248h hVar, Handler handler) {
        this.f2871a = executor;
        this.f2872b = gVar;
        this.f2873c = hVar;
        this.f2874d = handler;
    }

    /* renamed from: a */
    public void mo10154a(C1230c cVar, boolean z, String str, CBError.CBClickError cBClickError, C1357p0 p0Var) {
        C1357p0 p0Var2;
        if (cVar != null) {
            cVar.f2732B = false;
            if (cVar.mo10080G()) {
                cVar.f2736b = 4;
            }
        }
        if (!z) {
            C1272a aVar = C1418k.f3534d;
            if (aVar != null) {
                aVar.didFailToRecordClick(str, cBClickError);
            }
        } else if (cVar != null && (p0Var2 = cVar.f2758x) != null) {
            this.f2872b.mo10147a(p0Var2);
        } else if (p0Var != null) {
            this.f2872b.mo10147a(p0Var);
        }
    }

    /* renamed from: b */
    public void mo10156b(Context context, C1230c cVar, String str, C1357p0 p0Var) {
        try {
            String scheme = new URI(str).getScheme();
            if (scheme == null) {
                m3100a(str, cVar);
                mo10154a(cVar, false, str, CBError.CBClickError.URI_INVALID, p0Var);
            } else if (scheme.equals("http") || scheme.equals(Constants.HTTPS)) {
                this.f2871a.execute(new C1250a(str, context, cVar, p0Var));
            } else {
                mo10157c(context, cVar, str, p0Var);
            }
        } catch (URISyntaxException unused) {
            m3100a(str, cVar);
            mo10154a(cVar, false, str, CBError.CBClickError.URI_INVALID, p0Var);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10157c(Context context, C1230c cVar, String str, C1357p0 p0Var) {
        if (cVar != null && cVar.mo10080G()) {
            cVar.f2736b = 5;
        }
        if (context == null) {
            mo10154a(cVar, false, str, CBError.CBClickError.NO_HOST_ACTIVITY, p0Var);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (Exception unused) {
            if (str.startsWith("market://")) {
                try {
                    str = "http://market.android.com/" + str.substring(9);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    intent2.setData(Uri.parse(str));
                    context.startActivity(intent2);
                } catch (Exception e) {
                    CBLogging.m2904a("CBURLOpener", "Exception raised openeing an inavld playstore URL", e);
                    mo10154a(cVar, false, str, CBError.CBClickError.URI_UNRECOGNIZED, p0Var);
                    return;
                }
            } else {
                mo10154a(cVar, false, str, CBError.CBClickError.URI_UNRECOGNIZED, p0Var);
            }
        }
        mo10154a(cVar, true, str, (CBError.CBClickError) null, p0Var);
    }

    /* renamed from: a */
    private void m3100a(String str, C1230c cVar) {
        String str2;
        String str3 = "";
        if (cVar != null) {
            C1286a e = cVar.mo10092e();
            str2 = cVar.f2747m;
            if (e != null) {
                str3 = e.f3036b;
            }
        } else {
            str2 = str3;
        }
        C1266e.m3223e(new C1260a("click_invalid_url_error", str, str3, str2));
    }

    /* renamed from: a */
    public boolean mo10155a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            if (context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            CBLogging.m2904a("CBURLOpener", "Cannot open URL", e);
            return false;
        }
    }

    /* renamed from: a */
    public void mo10153a(Context context, C1230c cVar, String str, C1357p0 p0Var) {
        mo10156b(context, cVar, str, p0Var);
    }
}
