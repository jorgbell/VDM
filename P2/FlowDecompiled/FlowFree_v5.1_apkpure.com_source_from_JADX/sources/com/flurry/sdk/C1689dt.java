package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.dt */
public final class C1689dt implements C1688ds<String> {
    /* renamed from: a */
    public final /* synthetic */ void mo11274a(OutputStream outputStream, Object obj) throws IOException {
        String str = (String) obj;
        if (outputStream != null && str != null) {
            byte[] bytes = str.getBytes("utf-8");
            outputStream.write(bytes, 0, bytes.length);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo11273a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1698dz.m4439a(inputStream, (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toString();
    }
}
