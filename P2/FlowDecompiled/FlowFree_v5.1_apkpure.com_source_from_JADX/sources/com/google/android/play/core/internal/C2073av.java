package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import com.google.android.play.core.splitcompat.C2135a;
import com.google.android.play.core.splitcompat.C2137c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.play.core.internal.av */
public final class C2073av {

    /* renamed from: a */
    private final C2137c f5179a;

    /* renamed from: b */
    private final Context f5180b;

    /* renamed from: c */
    private final C2072au f5181c;

    /* renamed from: d */
    private PackageInfo f5182d;

    public C2073av(Context context, C2137c cVar, C2075ax axVar, byte[] bArr) {
        C2072au auVar = new C2072au(new C2135a(cVar));
        this.f5179a = cVar;
        this.f5180b = context;
        this.f5181c = auVar;
    }

    /* renamed from: d */
    private final PackageInfo m5184d() {
        if (this.f5182d == null) {
            try {
                this.f5182d = this.f5180b.getPackageManager().getPackageInfo(this.f5180b.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return this.f5182d;
    }

    /* renamed from: e */
    private static X509Certificate m5185e(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0058, code lost:
        android.util.Log.e("SplitCompat", r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0083, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r6).length() + 32);
        r3.append("Downloaded split ");
        r3.append(r6);
        r3.append(" is not signed.");
        r13 = r3.toString();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo22044a(java.io.File[] r13) {
        /*
            r12 = this;
            java.lang.String r0 = " is not signed."
            java.lang.String r1 = "Downloaded split "
            android.content.pm.PackageInfo r2 = r12.m5184d()
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x002a
            android.content.pm.Signature[] r5 = r2.signatures
            if (r5 != 0) goto L_0x0011
            goto L_0x002a
        L_0x0011:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.content.pm.Signature[] r2 = r2.signatures
            int r5 = r2.length
            r6 = 0
        L_0x001a:
            if (r6 >= r5) goto L_0x002a
            r7 = r2[r6]
            java.security.cert.X509Certificate r7 = m5185e(r7)
            if (r7 == 0) goto L_0x0027
            r3.add(r7)
        L_0x0027:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x002a:
            java.lang.String r2 = "SplitCompat"
            if (r3 == 0) goto L_0x00cf
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0036
            goto L_0x00cf
        L_0x0036:
            int r5 = r13.length
        L_0x0037:
            int r5 = r5 + -1
            if (r5 < 0) goto L_0x00cd
            r6 = r13[r5]
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00c6 }
            java.security.cert.X509Certificate[][] r7 = com.google.android.play.core.internal.C2109i.m5275g(r6)     // Catch:{ Exception -> 0x00a0 }
            if (r7 == 0) goto L_0x0083
            int r8 = r7.length     // Catch:{ Exception -> 0x00c6 }
            if (r8 == 0) goto L_0x0083
            r8 = r7[r4]     // Catch:{ Exception -> 0x00c6 }
            int r8 = r8.length     // Catch:{ Exception -> 0x00c6 }
            if (r8 != 0) goto L_0x0050
            goto L_0x0083
        L_0x0050:
            boolean r6 = r3.isEmpty()     // Catch:{ Exception -> 0x00c6 }
            if (r6 == 0) goto L_0x005c
            java.lang.String r13 = "No certificates found for app."
        L_0x0058:
            android.util.Log.e(r2, r13)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00c0
        L_0x005c:
            java.util.Iterator r6 = r3.iterator()     // Catch:{ Exception -> 0x00c6 }
        L_0x0060:
            boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x00c6 }
            if (r8 == 0) goto L_0x0037
            java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x00c6 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ Exception -> 0x00c6 }
            int r9 = r7.length     // Catch:{ Exception -> 0x00c6 }
            r10 = 0
        L_0x006e:
            if (r10 >= r9) goto L_0x007d
            r11 = r7[r10]     // Catch:{ Exception -> 0x00c6 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x00c6 }
            boolean r11 = r11.equals(r8)     // Catch:{ Exception -> 0x00c6 }
            if (r11 != 0) goto L_0x0060
            int r10 = r10 + 1
            goto L_0x006e
        L_0x007d:
            java.lang.String r13 = "There's an app certificate that doesn't sign the split."
            android.util.Log.i(r2, r13)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00c0
        L_0x0083:
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x00c6 }
            int r13 = r13.length()     // Catch:{ Exception -> 0x00c6 }
            int r13 = r13 + 32
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c6 }
            r3.<init>(r13)     // Catch:{ Exception -> 0x00c6 }
            r3.append(r1)     // Catch:{ Exception -> 0x00c6 }
            r3.append(r6)     // Catch:{ Exception -> 0x00c6 }
            r3.append(r0)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r13 = r3.toString()     // Catch:{ Exception -> 0x00c6 }
            goto L_0x0058
        L_0x00a0:
            r13 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x00c6 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x00c6 }
            int r3 = r3 + 32
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c6 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x00c6 }
            r5.append(r1)     // Catch:{ Exception -> 0x00c6 }
            r5.append(r6)     // Catch:{ Exception -> 0x00c6 }
            r5.append(r0)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x00c6 }
            android.util.Log.e(r2, r0, r13)     // Catch:{ Exception -> 0x00c6 }
        L_0x00c0:
            java.lang.String r13 = "Split verification failure."
            android.util.Log.e(r2, r13)     // Catch:{ Exception -> 0x00c6 }
            return r4
        L_0x00c6:
            r13 = move-exception
            java.lang.String r0 = "Split verification error."
            android.util.Log.e(r2, r0, r13)
            return r4
        L_0x00cd:
            r13 = 1
            return r13
        L_0x00cf:
            java.lang.String r13 = "No app certificates found."
            android.util.Log.e(r2, r13)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C2073av.mo22044a(java.io.File[]):boolean");
    }

    /* renamed from: b */
    public final boolean mo22045b(File[] fileArr) throws IOException, XmlPullParserException {
        PackageInfo d = m5184d();
        long longVersionCode = Build.VERSION.SDK_INT >= 28 ? d.getLongVersionCode() : (long) d.versionCode;
        AssetManager assetManager = (AssetManager) C2086bh.m5224c(AssetManager.class);
        int length = fileArr.length;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            this.f5181c.mo22042a(assetManager, fileArr[length]);
        } while (longVersionCode == this.f5181c.mo22043b());
        return false;
    }

    /* renamed from: c */
    public final boolean mo22046c(List<Intent> list) throws IOException {
        for (Intent stringExtra : list) {
            if (!this.f5179a.mo22135c(stringExtra.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
