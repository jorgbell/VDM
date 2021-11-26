package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.flurry.sdk.cm */
public final class C1631cm extends C1634cp {

    /* renamed from: i */
    private static String f4125i;

    /* renamed from: j */
    private HttpsURLConnection f4126j;

    /* renamed from: k */
    private String f4127k;

    /* renamed from: l */
    private boolean f4128l;

    C1631cm(String str) {
        this.f4130a = str;
        f4125i = "Flurry-Config/1.0 (Android " + Build.VERSION.RELEASE + "/" + Build.ID + ")";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.InputStream mo11408a() throws java.io.IOException {
        /*
            r6 = this;
            java.net.URL r0 = new java.net.URL
            java.lang.String r1 = r6.f4130a
            r0.<init>(r1)
            java.net.URLConnection r0 = r0.openConnection()
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            r6.f4126j = r0
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setReadTimeout(r1)
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            r1 = 15000(0x3a98, float:2.102E-41)
            r0.setConnectTimeout(r1)
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            java.lang.String r1 = "POST"
            r0.setRequestMethod(r1)
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            java.lang.String r1 = f4125i
            java.lang.String r2 = "User-Agent"
            r0.setRequestProperty(r2, r1)
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            r0.setRequestProperty(r1, r2)
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            r1 = 1
            r0.setDoInput(r1)
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            r0.setDoOutput(r1)
            r0 = 1234(0x4d2, float:1.729E-42)
            android.net.TrafficStats.setThreadStatsTag(r0)
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            r0.connect()
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            com.flurry.sdk.C1664dg.m4373a(r0)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r1)
            r6.f4132c = r0
            r0 = 0
            javax.net.ssl.HttpsURLConnection r1 = r6.f4126j     // Catch:{ all -> 0x0111 }
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch:{ all -> 0x0111 }
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ all -> 0x010c }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x010c }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r1, r4)     // Catch:{ all -> 0x010c }
            r2.<init>(r3)     // Catch:{ all -> 0x010c }
            java.lang.String r0 = r6.f4132c     // Catch:{ all -> 0x010a }
            java.lang.String r0 = com.flurry.sdk.C1633co.m4278a(r0)     // Catch:{ all -> 0x010a }
            r2.write(r0)     // Catch:{ all -> 0x010a }
            r2.close()
            if (r1 == 0) goto L_0x0082
            r1.close()
        L_0x0082:
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            int r0 = r0.getResponseCode()
            r1 = 400(0x190, float:5.6E-43)
            if (r0 >= r1) goto L_0x00fa
            javax.net.ssl.HttpsURLConnection r1 = r6.f4126j
            java.lang.String r2 = "Content-Signature"
            java.lang.String r1 = r1.getHeaderField(r2)
            r6.f4127k = r1
            javax.net.ssl.HttpsURLConnection r1 = r6.f4126j
            java.lang.String r2 = "ETag"
            java.lang.String r1 = r1.getHeaderField(r2)
            r6.f4136g = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Content-Signature: "
            r1.<init>(r2)
            java.lang.String r2 = r6.f4127k
            r1.append(r2)
            java.lang.String r2 = ", ETag: "
            r1.append(r2)
            java.lang.String r2 = r6.f4136g
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "HttpTransport"
            com.flurry.sdk.C1648cy.m4319a(r2, r1)
            r1 = 304(0x130, float:4.26E-43)
            if (r0 != r1) goto L_0x00f3
            java.lang.String r0 = r6.f4132c
            boolean r0 = r6.mo11409a(r0)
            if (r0 == 0) goto L_0x00d5
            com.flurry.sdk.cc r0 = com.flurry.sdk.C1618cc.f4085b
            r6.f4131b = r0
            java.lang.String r0 = "Empty 304 payload; No Change."
            com.flurry.sdk.C1648cy.m4319a(r2, r0)
            goto L_0x00f3
        L_0x00d5:
            com.flurry.sdk.cc r0 = new com.flurry.sdk.cc
            com.flurry.sdk.cc$a r1 = com.flurry.sdk.C1618cc.C1619a.AUTHENTICATE
            java.lang.String r3 = "GUID Signature Error."
            r0.<init>(r1, r3)
            r6.f4131b = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Authentication error: "
            r0.<init>(r1)
            com.flurry.sdk.cc r1 = r6.f4131b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.flurry.sdk.C1648cy.m4325b(r2, r0)
        L_0x00f3:
            javax.net.ssl.HttpsURLConnection r0 = r6.f4126j
            java.io.InputStream r0 = r0.getInputStream()
            return r0
        L_0x00fa:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Server response code is "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L_0x010a:
            r0 = move-exception
            goto L_0x0115
        L_0x010c:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0115
        L_0x0111:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x0115:
            if (r2 == 0) goto L_0x011a
            r2.close()
        L_0x011a:
            if (r1 == 0) goto L_0x011f
            r1.close()
        L_0x011f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1631cm.mo11408a():java.io.InputStream");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo11410b() {
        HttpsURLConnection httpsURLConnection = this.f4126j;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    /* renamed from: c */
    public final boolean mo11411c() {
        return "https://cfg.flurry.com/sdk/v1/config".equals(this.f4130a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo11409a(String str) {
        boolean z;
        if (!m4271b(this.f4127k)) {
            return false;
        }
        if (this.f4128l) {
            z = C1636cr.m4299c(this.f4134e, str, this.f4135f);
        } else {
            z = C1636cr.m4297b(this.f4134e, str, this.f4135f);
        }
        if (z) {
            return true;
        }
        C1648cy.m4325b("HttpTransport", "Incorrect signature for response.");
        return false;
    }

    /* renamed from: b */
    private boolean m4271b(String str) {
        if (TextUtils.isEmpty(str)) {
            C1648cy.m4325b("HttpTransport", "Content-Signature is empty.");
            return false;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(";")) {
            int indexOf = str2.indexOf("=");
            if (indexOf > 0) {
                hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        String str3 = (String) hashMap.get("keyid");
        this.f4133d = str3;
        if (TextUtils.isEmpty(str3)) {
            C1648cy.m4325b("HttpTransport", "Error to get keyid from Signature.");
            return false;
        }
        this.f4134e = C1637cs.f4139a.get(this.f4133d);
        C1648cy.m4319a("HttpTransport", "Signature keyid: " + this.f4133d + ", key: " + this.f4134e);
        if (this.f4134e == null) {
            C1648cy.m4325b("HttpTransport", "Unknown keyid from Signature.");
            return false;
        }
        String str4 = "sha256ecdsa";
        boolean containsKey = hashMap.containsKey(str4);
        this.f4128l = containsKey;
        if (!containsKey) {
            str4 = "sha256rsa";
        }
        String str5 = (String) hashMap.get(str4);
        this.f4135f = str5;
        if (TextUtils.isEmpty(str5)) {
            C1648cy.m4325b("HttpTransport", "Error to get rsa from Signature.");
            return false;
        }
        C1648cy.m4319a("HttpTransport", "Signature rsa: " + this.f4135f);
        return true;
    }
}
