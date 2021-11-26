package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* renamed from: com.google.android.play.core.internal.g */
final class C2107g extends C2108h {

    /* renamed from: a */
    private final byte[] f5212a;

    public C2107g(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f5212a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f5212a;
    }
}
