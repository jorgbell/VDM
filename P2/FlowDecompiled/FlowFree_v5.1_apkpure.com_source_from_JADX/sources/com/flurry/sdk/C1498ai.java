package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.C1494ah;
import com.flurry.sdk.C1904k;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.flurry.sdk.ai */
public final class C1498ai {

    /* renamed from: a */
    byte[] f3762a;

    /* renamed from: b */
    private C1500aj f3763b;

    /* renamed from: c */
    private int f3764c;

    /* renamed from: d */
    private final C1904k<byte[]> f3765d;

    /* renamed from: e */
    private C1906l<C1494ah> f3766e;

    C1498ai() {
        this.f3763b = null;
        this.f3764c = 0;
        this.f3762a = null;
        this.f3766e = null;
        this.f3765d = new C1904k<>(new C1682do());
        this.f3763b = new C1500aj();
    }

    /* renamed from: a */
    public final void mo11277a() {
        if (this.f3766e == null) {
            this.f3766e = new C1906l<>(m3983c(), "installationNum", 1, new C1693dv<C1494ah>() {
                /* renamed from: a */
                public final C1688ds<C1494ah> mo11281a(int i) {
                    return new C1494ah.C1495a();
                }
            });
            byte[] a = mo11279a(m3984d());
            if (a != null && Build.VERSION.SDK_INT >= 23) {
                C1696dy.m4437b(m3983c());
                mo11278a(a, C1904k.C1905a.CRYPTO_ALGO_PADDING_7);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo11278a(byte[] bArr, C1904k.C1905a aVar) {
        C1494ah ahVar;
        try {
            C1696dy.m4437b(m3983c());
            byte[] e = m3985e();
            byte[] a = this.f3765d.mo11567a(bArr, mo11280b(), new IvParameterSpec(e), aVar);
            if (a != null) {
                ahVar = new C1494ah(a, e, true, aVar.ordinal());
            } else {
                ahVar = new C1494ah(bArr, new byte[0], false, aVar.ordinal());
            }
            this.f3766e.mo11569a(ahVar);
            return true;
        } catch (IOException e2) {
            C1648cy.m4318a(5, "InstallationIdProvider", "Error while generating UUID" + e2.getMessage(), e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final byte[] mo11279a(Key key) {
        try {
            C1494ah a = this.f3766e.mo11568a();
            if (a == null) {
                return null;
            }
            if (!a.f3756a) {
                return a.f3758c;
            }
            byte[] bArr = a.f3757b;
            byte[] bArr2 = a.f3758c;
            C1904k.C1905a a2 = C1904k.C1905a.m4801a(a.f3759d);
            if (bArr == null || bArr2 == null) {
                return null;
            }
            return this.f3765d.mo11566a(bArr2, key, new IvParameterSpec(bArr), a2);
        } catch (IOException unused) {
            C1648cy.m4317a(5, "InstallationIdProvider", "Error while reading Android Install Id. Deleting file.");
            return null;
        }
    }

    /* renamed from: c */
    private static File m3983c() {
        return new File(C1696dy.m4436b().getPath() + File.separator + "installationNum");
    }

    /* renamed from: d */
    private static SecretKey m3984d() {
        C1561bi a = C1561bi.m4088a();
        C1648cy.m4317a(3, "APIKeyProvider", "Getting legacy apikey: " + a.f3954b);
        String str = a.f3954b;
        String a2 = C1695dx.m4430a(C1536b.m4057a());
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), ByteBuffer.allocate(8).putLong(!TextUtils.isEmpty(a2) ? C1698dz.m4450e(a2) : Long.MIN_VALUE).array(), 1000, 256)).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            C1648cy.m4318a(4, "InstallationIdProvider", "Error in generate secret key", e);
            return null;
        }
    }

    @SuppressLint({"all"})
    /* renamed from: e */
    private static byte[] m3985e() {
        try {
            byte[] bArr = new byte[16];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return bArr;
        } catch (NoSuchAlgorithmException e) {
            C1648cy.m4318a(4, "InstallationIdProvider", "Error in generating iv", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Key mo11280b() {
        if (Build.VERSION.SDK_INT < 23) {
            return m3984d();
        }
        return this.f3763b.mo11282a();
    }
}
