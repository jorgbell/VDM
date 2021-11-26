package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.flurry.sdk.cr */
public final class C1636cr {

    /* renamed from: a */
    public static final Charset f4138a = Charset.forName("UTF-8");

    /* renamed from: d */
    private static String m4300d(Context context) {
        return context.getPackageName() + ".variants";
    }

    /* renamed from: a */
    public static synchronized boolean m4291a(Context context) {
        synchronized (C1636cr.class) {
            if (context == null) {
                return false;
            }
            boolean b = m4296b(context, m4300d(context));
            return b;
        }
    }

    /* renamed from: b */
    private static synchronized boolean m4296b(Context context, String str) {
        boolean exists;
        synchronized (C1636cr.class) {
            exists = context.getFileStreamPath(str).exists();
        }
        return exists;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:46|(0)|50|51) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0061 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046 A[SYNTHETIC, Splitter:B:29:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0056 A[SYNTHETIC, Splitter:B:41:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x005e A[SYNTHETIC, Splitter:B:48:0x005e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x0061=Splitter:B:50:0x0061, B:16:0x002e=Splitter:B:16:0x002e} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String m4295b(android.content.Context r6) {
        /*
            java.lang.Class<com.flurry.sdk.cr> r0 = com.flurry.sdk.C1636cr.class
            monitor-enter(r0)
            r1 = 0
            if (r6 != 0) goto L_0x0008
            monitor-exit(r0)
            return r1
        L_0x0008:
            java.lang.String r2 = m4300d(r6)     // Catch:{ FileNotFoundException -> 0x004b, IOException -> 0x003b, all -> 0x0036 }
            java.io.FileInputStream r6 = r6.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x004b, IOException -> 0x003b, all -> 0x0036 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
        L_0x001f:
            java.lang.String r4 = r3.readLine()     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
            if (r4 == 0) goto L_0x0029
            r2.append(r4)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0034 }
            goto L_0x001f
        L_0x0029:
            if (r6 == 0) goto L_0x002e
            r6.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0062 }
            monitor-exit(r0)
            return r6
        L_0x0034:
            r2 = move-exception
            goto L_0x003d
        L_0x0036:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L_0x005c
        L_0x003b:
            r2 = move-exception
            r6 = r1
        L_0x003d:
            java.lang.String r3 = "ConfigUtils"
            java.lang.String r4 = "Error in reading file!"
            com.flurry.sdk.C1648cy.m4320a((java.lang.String) r3, (java.lang.String) r4, (java.lang.Throwable) r2)     // Catch:{ all -> 0x005b }
            if (r6 == 0) goto L_0x0049
            r6.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            monitor-exit(r0)
            return r1
        L_0x004b:
            r6 = r1
        L_0x004c:
            r2 = 5
            java.lang.String r3 = "ConfigUtils"
            java.lang.String r4 = "File not found!"
            com.flurry.sdk.C1648cy.m4317a((int) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x005b }
            if (r6 == 0) goto L_0x0059
            r6.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            monitor-exit(r0)
            return r1
        L_0x005b:
            r1 = move-exception
        L_0x005c:
            if (r6 == 0) goto L_0x0061
            r6.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0061:
            throw r1     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r6 = move-exception
            monitor-exit(r0)
            goto L_0x0066
        L_0x0065:
            throw r6
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1636cr.m4295b(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x003b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m4289a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.Class<com.flurry.sdk.cr> r0 = com.flurry.sdk.C1636cr.class
            monitor-enter(r0)
            if (r5 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            r1 = 0
            java.lang.String r2 = m4300d(r4)     // Catch:{ IOException -> 0x0023 }
            r3 = 0
            java.io.FileOutputStream r1 = r4.openFileOutput(r2, r3)     // Catch:{ IOException -> 0x0023 }
            byte[] r4 = r5.getBytes()     // Catch:{ IOException -> 0x0023 }
            r1.write(r4)     // Catch:{ IOException -> 0x0023 }
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ IOException -> 0x001f }
            monitor-exit(r0)
            return
        L_0x001f:
            monitor-exit(r0)
            return
        L_0x0021:
            r4 = move-exception
            goto L_0x0036
        L_0x0023:
            r4 = move-exception
            java.lang.String r5 = "ConfigUtils"
            java.lang.String r2 = "Error in writing data to file"
            com.flurry.sdk.C1648cy.m4320a((java.lang.String) r5, (java.lang.String) r2, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ IOException -> 0x0032 }
            monitor-exit(r0)
            return
        L_0x0032:
            monitor-exit(r0)
            return
        L_0x0034:
            monitor-exit(r0)
            return
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            throw r4     // Catch:{ all -> 0x003c }
        L_0x003c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1636cr.m4289a(android.content.Context, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return r4;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m4298c(android.content.Context r4) {
        /*
            java.lang.Class<com.flurry.sdk.cr> r0 = com.flurry.sdk.C1636cr.class
            monitor-enter(r0)
            if (r4 != 0) goto L_0x0008
            r4 = 0
            monitor-exit(r0)
            return r4
        L_0x0008:
            java.lang.String r1 = m4300d(r4)     // Catch:{ all -> 0x0024 }
            boolean r4 = r4.deleteFile(r1)     // Catch:{ all -> 0x0024 }
            r1 = 5
            if (r4 == 0) goto L_0x001b
            java.lang.String r2 = "ConfigUtils"
            java.lang.String r3 = "File removed from memory"
            com.flurry.sdk.C1648cy.m4317a((int) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0024 }
            goto L_0x0022
        L_0x001b:
            java.lang.String r2 = "ConfigUtils"
            java.lang.String r3 = "Error in clearing data from memory"
            com.flurry.sdk.C1648cy.m4317a((int) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)
            return r4
        L_0x0024:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1636cr.m4298c(android.content.Context):boolean");
    }

    /* renamed from: a */
    public static boolean m4293a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str) || (str4 = C1637cs.f4139a.get(str)) == null) {
            return false;
        }
        if (str.indexOf("com.flurry.configkey.prod.ec.") != -1) {
            return m4299c(str4, str2, str3);
        }
        return m4297b(str4, str2, str3);
    }

    /* renamed from: b */
    public static boolean m4297b(String str, String str2, String str3) {
        return m4294a(str, str2, str3, "RSA", "SHA256withRSA");
    }

    /* renamed from: c */
    public static boolean m4299c(String str, String str2, String str3) {
        return m4294a(str, str2, str3, "EC", "SHA256withECDSA");
    }

    /* renamed from: a */
    private static boolean m4294a(String str, String str2, String str3, String str4, String str5) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(str4).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            Signature instance = Signature.getInstance(str5);
            instance.initVerify(generatePublic);
            instance.update(str2.getBytes(f4138a));
            return instance.verify(Base64.decode(str3, 0));
        } catch (GeneralSecurityException e) {
            C1648cy.m4325b("ConfigUtils", "GeneralSecurityException for Signature: ".concat(String.valueOf(e)));
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4290a() {
        try {
            KeyFactory.getInstance("EC");
            Signature.getInstance("SHA256withECDSA");
            return true;
        } catch (NoSuchAlgorithmException e) {
            C1648cy.m4319a("ConfigUtils", "ECDSA encryption is not available: ".concat(String.valueOf(e)));
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4292a(String str) {
        return "com.flurry.configkey.prod.ec.2".equals(str) || "com.flurry.configkey.prod.rot.7".equals(str) || "com.flurry.configkey.prod.fs.0".equals(str);
    }
}
