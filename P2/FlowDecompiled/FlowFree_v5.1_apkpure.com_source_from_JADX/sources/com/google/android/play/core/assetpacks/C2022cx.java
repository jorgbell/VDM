package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2086bh;
import com.google.android.play.core.internal.C2098bz;
import com.google.android.play.core.internal.C2100ca;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.play.core.assetpacks.cx */
final class C2022cx {

    /* renamed from: a */
    private static final C2058ag f5067a = new C2058ag("PatchSliceTaskHandler");

    /* renamed from: b */
    private final C1970au f5068b;

    /* renamed from: c */
    private final C2100ca<C2046t> f5069c;

    C2022cx(C1970au auVar, C2100ca<C2046t> caVar) {
        this.f5068b = auVar;
        this.f5069c = caVar;
    }

    /* renamed from: a */
    public final void mo21971a(C2021cw cwVar) {
        InputStream inputStream;
        File f = this.f5068b.mo21880f(cwVar.f5000k, cwVar.f5059a, cwVar.f5060b);
        C1970au auVar = this.f5068b;
        String str = cwVar.f5000k;
        int i = cwVar.f5059a;
        long j = cwVar.f5060b;
        File file = new File(auVar.mo21881g(str, i, j), cwVar.f5064f);
        try {
            inputStream = cwVar.f5066h;
            if (cwVar.f5063e == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            C1972aw awVar = new C1972aw(f, file);
            File h = this.f5068b.mo21882h(cwVar.f5000k, cwVar.f5061c, cwVar.f5062d, cwVar.f5064f);
            if (!h.exists()) {
                h.mkdirs();
            }
            C2024cz czVar = new C2024cz(this.f5068b, cwVar.f5000k, cwVar.f5061c, cwVar.f5062d, cwVar.f5064f);
            C2086bh.m5233l(awVar, inputStream, new C1988bn(h, czVar), cwVar.f5065g);
            czVar.mo21983d(0);
            inputStream.close();
            f5067a.mo22027d("Patching and extraction finished for slice %s of pack %s.", cwVar.f5064f, cwVar.f5000k);
            this.f5069c.mo22065a().mo21860e(cwVar.f4999j, cwVar.f5000k, cwVar.f5064f, 0);
            try {
                cwVar.f5066h.close();
                return;
            } catch (IOException unused) {
                f5067a.mo22028e("Could not close file for slice %s of pack %s.", cwVar.f5064f, cwVar.f5000k);
                return;
            }
        } catch (IOException e) {
            f5067a.mo22025b("IOException during patching %s.", e.getMessage());
            throw new C1985bk(String.format("Error patching slice %s of pack %s.", new Object[]{cwVar.f5064f, cwVar.f5000k}), e, cwVar.f4999j);
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }
}
