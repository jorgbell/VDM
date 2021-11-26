package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.security.DigestOutputStream;

/* renamed from: com.flurry.sdk.gc */
public final class C1788gc {
    /* renamed from: a */
    public final synchronized byte[] mo11541a(C1895jq jqVar) {
        byte[] bArr;
        DataOutputStream dataOutputStream;
        bArr = null;
        try {
            C1877j jVar = new C1877j();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(640);
            DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, jVar);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                C1648cy.m4317a(3, "FrameSerializer", "Adding frame " + jqVar.mo11542a() + " payload " + jqVar.mo11559e());
                dataOutputStream.writeByte(jqVar.mo11561g());
                int i = jqVar.mo11542a().f4693N;
                byte[] bArr2 = new byte[4];
                bArr2[0] = (byte) (i >> 16);
                bArr2[1] = (byte) (i >> 8);
                bArr2[2] = (byte) (i >> 0);
                for (int i2 = 0; i2 < 3; i2++) {
                    dataOutputStream.write(bArr2[i2]);
                }
                dataOutputStream.writeLong(jqVar.mo11557c());
                dataOutputStream.writeLong(jqVar.mo11558d());
                byte[] bytes = jqVar.mo11559e().getBytes("UTF-8");
                dataOutputStream.writeInt(bytes.length);
                dataOutputStream.write(bytes);
                if (jqVar.mo11562h()) {
                    digestOutputStream.on(false);
                    dataOutputStream.writeInt(jVar.mo11552a());
                }
                dataOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                try {
                    C1648cy.m4318a(3, "FrameSerializer", "Error when generating report", th);
                    C1698dz.m4444a((Closeable) dataOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    C1698dz.m4444a((Closeable) dataOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            C1648cy.m4318a(3, "FrameSerializer", "Error when generating report", th);
            C1698dz.m4444a((Closeable) dataOutputStream);
            return bArr;
        }
        C1698dz.m4444a((Closeable) dataOutputStream);
        return bArr;
    }
}
