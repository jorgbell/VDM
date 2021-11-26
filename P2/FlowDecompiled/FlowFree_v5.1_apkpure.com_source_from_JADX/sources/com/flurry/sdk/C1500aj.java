package com.flurry.sdk;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;

/* renamed from: com.flurry.sdk.aj */
public final class C1500aj {

    /* renamed from: a */
    private KeyStore f3768a;

    @TargetApi(23)
    C1500aj() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                this.f3768a = instance;
                instance.load((KeyStore.LoadStoreParameter) null);
                KeyStore keyStore = this.f3768a;
                if (keyStore != null && !keyStore.containsAlias("fl.install.id.sec.key")) {
                    KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    instance2.init(new KeyGenParameterSpec.Builder("fl.install.id.sec.key", 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setRandomizedEncryptionRequired(false).setDigests(new String[]{"SHA-256", "SHA-512"}).build());
                    instance2.generateKey();
                }
            } catch (IOException | NullPointerException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e) {
                C1648cy.m4318a(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
            } catch (Exception e2) {
                C1648cy.m4318a(5, "KeystoreProvider", "Unknown Error while generating Key" + e2.getMessage(), e2);
            }
        }
    }

    /* renamed from: a */
    public final Key mo11282a() {
        KeyStore keyStore;
        if (Build.VERSION.SDK_INT < 23 || (keyStore = this.f3768a) == null) {
            return null;
        }
        try {
            return keyStore.getKey("fl.install.id.sec.key", (char[]) null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException unused) {
            C1648cy.m4317a(6, "KeystoreProvider", "Error in getting key.");
            return null;
        }
    }
}
