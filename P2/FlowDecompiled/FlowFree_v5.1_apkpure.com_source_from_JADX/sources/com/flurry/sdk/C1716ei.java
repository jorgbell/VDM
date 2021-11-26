package com.flurry.sdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.flurry.sdk.ei */
public final class C1716ei {

    /* renamed from: com.flurry.sdk.ei$a */
    public static class C1717a {
        /* renamed from: a */
        public static MessageDigest m4472a(String str) {
            try {
                return MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
    }

    /* renamed from: com.flurry.sdk.ei$b */
    public static class C1718b {

        /* renamed from: a */
        private static final SecureRandom f4313a = new SecureRandom();

        /* renamed from: b */
        private static final char[] f4314b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

        /* renamed from: a */
        public static String m4473a() {
            char[] cArr = new char[32];
            for (int i = 0; i < 32; i++) {
                char[] cArr2 = f4314b;
                cArr[i] = cArr2[f4313a.nextInt(cArr2.length)];
            }
            return new String(cArr);
        }
    }
}
