package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.util.Base64;
import com.flurry.android.Constants;
import com.google.android.play.core.internal.C2098bz;
import com.google.android.play.core.splitcompat.C2150p;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ck */
public final class C2009ck {

    /* renamed from: a */
    private static C1952a f5019a;

    /* renamed from: a */
    static String m5039a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File fileInputStream : list) {
            FileInputStream fileInputStream2 = new FileInputStream(fileInputStream);
            do {
                try {
                    read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    C2098bz.m5252a(th, th);
                }
            } while (read != -1);
            fileInputStream2.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    /* renamed from: d */
    static long m5040d(byte[] bArr, int i) {
        return ((long) ((m5041e(bArr, i + 2) << 16) | m5041e(bArr, i))) & 4294967295L;
    }

    /* renamed from: e */
    static int m5041e(byte[] bArr, int i) {
        return ((bArr[i + 1] & Constants.UNKNOWN) << 8) | (bArr[i] & Constants.UNKNOWN);
    }

    /* renamed from: f */
    public static boolean m5042f(int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    /* renamed from: g */
    public static boolean m5043g(int i) {
        return i == 5 || i == 6 || i == 4;
    }

    /* renamed from: h */
    public static boolean m5044h(int i) {
        return i == 2 || i == 7 || i == 3;
    }

    /* renamed from: i */
    static boolean m5045i(int i, int i2) {
        if (i == 5) {
            if (i2 != 5) {
                return true;
            }
            i = 5;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i == 2) {
            return i2 == 1 || i2 == 8;
        }
        return false;
    }

    /* renamed from: j */
    static synchronized C1952a m5046j(Context context) {
        C1952a aVar;
        synchronized (C2009ck.class) {
            if (f5019a == null) {
                C1981bg bgVar = new C1981bg((byte[]) null);
                bgVar.mo21924b(new C2037l(C2150p.m5402c(context)));
                f5019a = bgVar.mo21923a();
            }
            aVar = f5019a;
        }
        return aVar;
    }
}
