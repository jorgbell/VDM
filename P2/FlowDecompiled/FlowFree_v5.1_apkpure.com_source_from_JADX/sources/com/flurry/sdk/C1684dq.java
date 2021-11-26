package com.flurry.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.flurry.sdk.dq */
public final class C1684dq<ObjectType> extends C1683dp<ObjectType> {
    public C1684dq(C1688ds<ObjectType> dsVar) {
        super(dsVar);
    }

    /* renamed from: a */
    public final void mo11274a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                try {
                    super.mo11274a(gZIPOutputStream2, objecttype);
                    C1698dz.m4444a((Closeable) gZIPOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    C1698dz.m4444a((Closeable) gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C1698dz.m4444a((Closeable) gZIPOutputStream);
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final ObjectType mo11273a(InputStream inputStream) throws IOException {
        GZIPInputStream gZIPInputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                ObjectType a = super.mo11273a(gZIPInputStream2);
                C1698dz.m4444a((Closeable) gZIPInputStream2);
                return a;
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                C1698dz.m4444a((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C1698dz.m4444a((Closeable) gZIPInputStream);
            throw th;
        }
    }
}
