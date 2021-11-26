package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2058ag;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.play.core.assetpacks.dd */
final class C2028dd {

    /* renamed from: a */
    private static final C2058ag f5089a = new C2058ag("VerifySliceTaskHandler");

    /* renamed from: b */
    private final C1970au f5090b;

    C2028dd(C1970au auVar) {
        this.f5090b = auVar;
    }

    /* renamed from: b */
    private final void m5084b(C2027dc dcVar, File file) {
        try {
            File o = this.f5090b.mo21889o(dcVar.f5000k, dcVar.f5085a, dcVar.f5086b, dcVar.f5087c);
            if (o.exists()) {
                try {
                    if (C2009ck.m5039a(C2026db.m5082a(file, o)).equals(dcVar.f5088d)) {
                        f5089a.mo22027d("Verification of slice %s of pack %s successful.", dcVar.f5087c, dcVar.f5000k);
                        return;
                    }
                    throw new C1985bk(String.format("Verification failed for slice %s.", new Object[]{dcVar.f5087c}), dcVar.f4999j);
                } catch (NoSuchAlgorithmException e) {
                    throw new C1985bk("SHA256 algorithm not supported.", e, dcVar.f4999j);
                } catch (IOException e2) {
                    throw new C1985bk(String.format("Could not digest file during verification for slice %s.", new Object[]{dcVar.f5087c}), e2, dcVar.f4999j);
                }
            } else {
                throw new C1985bk(String.format("Cannot find metadata files for slice %s.", new Object[]{dcVar.f5087c}), dcVar.f4999j);
            }
        } catch (IOException e3) {
            throw new C1985bk(String.format("Could not reconstruct slice archive during verification for slice %s.", new Object[]{dcVar.f5087c}), e3, dcVar.f4999j);
        }
    }

    /* renamed from: a */
    public final void mo21994a(C2027dc dcVar) {
        File h = this.f5090b.mo21882h(dcVar.f5000k, dcVar.f5085a, dcVar.f5086b, dcVar.f5087c);
        if (h.exists()) {
            m5084b(dcVar, h);
            File i = this.f5090b.mo21883i(dcVar.f5000k, dcVar.f5085a, dcVar.f5086b, dcVar.f5087c);
            if (!i.exists()) {
                i.mkdirs();
            }
            if (!h.renameTo(i)) {
                throw new C1985bk(String.format("Failed to move slice %s after verification.", new Object[]{dcVar.f5087c}), dcVar.f4999j);
            }
            return;
        }
        throw new C1985bk(String.format("Cannot find unverified files for slice %s.", new Object[]{dcVar.f5087c}), dcVar.f4999j);
    }
}
