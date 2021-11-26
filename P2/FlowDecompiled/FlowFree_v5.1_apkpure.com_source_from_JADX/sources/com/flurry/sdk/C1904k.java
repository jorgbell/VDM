package com.flurry.sdk;

import android.annotation.SuppressLint;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.flurry.sdk.k */
public final class C1904k<ObjectType> {

    /* renamed from: a */
    private C1688ds<ObjectType> f4704a;

    public C1904k(C1688ds<ObjectType> dsVar) {
        this.f4704a = dsVar;
    }

    /* renamed from: com.flurry.sdk.k$a */
    public enum C1905a {
        NONE(""),
        CRYPTO_ALGO_PADDING_7("AES/CBC/PKCS7Padding"),
        CRYPTO_ALGO_PADDING_5("AES/CBC/PKCS5Padding");
        

        /* renamed from: d */
        String f4709d;

        private C1905a(String str) {
            this.f4709d = str;
        }

        /* renamed from: a */
        public static C1905a m4801a(int i) {
            for (C1905a aVar : values()) {
                if (aVar.ordinal() == i) {
                    return aVar;
                }
            }
            return NONE;
        }
    }

    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    public final byte[] mo11567a(ObjectType objecttype, Key key, IvParameterSpec ivParameterSpec, C1905a aVar) throws IOException {
        if (objecttype == null || key == null || aVar == null) {
            C1648cy.m4317a(5, "FlurryCrypto", "Cannot encrypt, invalid params.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f4704a.mo11274a(byteArrayOutputStream, objecttype);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            Cipher instance = Cipher.getInstance(aVar.f4709d);
            instance.init(1, key, ivParameterSpec);
            return instance.doFinal(byteArray);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            C1648cy.m4317a(5, "FlurryCrypto", "Error in encrypt " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public final ObjectType mo11566a(byte[] bArr, Key key, IvParameterSpec ivParameterSpec, C1905a aVar) throws IOException {
        if (bArr == null || key == null || aVar == null) {
            C1648cy.m4317a(5, "FlurryCrypto", "Cannot decrypt, invalid params.");
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance(aVar.f4709d);
            instance.init(2, key, ivParameterSpec);
            return this.f4704a.mo11273a(new ByteArrayInputStream(instance.doFinal(bArr)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            C1648cy.m4317a(5, "FlurryCrypto", "Error in decrypt " + e.getMessage());
            return null;
        }
    }
}
