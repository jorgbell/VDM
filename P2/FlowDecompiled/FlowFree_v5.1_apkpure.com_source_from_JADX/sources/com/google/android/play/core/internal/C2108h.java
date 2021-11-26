package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.h */
class C2108h extends X509Certificate {

    /* renamed from: a */
    private final X509Certificate f5213a;

    public C2108h(X509Certificate x509Certificate) {
        this.f5213a = x509Certificate;
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.f5213a.checkValidity();
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.f5213a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.f5213a.getBasicConstraints();
    }

    public final Set<String> getCriticalExtensionOIDs() {
        return this.f5213a.getCriticalExtensionOIDs();
    }

    public final byte[] getExtensionValue(String str) {
        return this.f5213a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.f5213a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.f5213a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.f5213a.getKeyUsage();
    }

    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.f5213a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.f5213a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.f5213a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.f5213a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.f5213a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.f5213a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.f5213a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.f5213a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.f5213a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.f5213a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.f5213a.getSubjectUniqueID();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f5213a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.f5213a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.f5213a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.f5213a.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f5213a.verify(publicKey);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f5213a.verify(publicKey, str);
    }
}
