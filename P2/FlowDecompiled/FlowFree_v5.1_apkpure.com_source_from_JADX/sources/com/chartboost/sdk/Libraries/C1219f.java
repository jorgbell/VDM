package com.chartboost.sdk.Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.chartboost.sdk.Libraries.f */
public class C1219f {

    /* renamed from: a */
    private static final byte[] f2677a = new byte[0];

    /* renamed from: a */
    public static FileInputStream m2942a(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        r5.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        throw r1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m2947b(java.io.File r5) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = m2942a((java.io.File) r5)
            long r1 = r5.length()     // Catch:{ all -> 0x001d }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0013
            byte[] r5 = m2945a((java.io.InputStream) r0, (long) r1)     // Catch:{ all -> 0x001d }
            goto L_0x0017
        L_0x0013:
            byte[] r5 = m2943a((java.io.InputStream) r0)     // Catch:{ all -> 0x001d }
        L_0x0017:
            if (r0 == 0) goto L_0x001c
            r0.close()
        L_0x001c:
            return r5
        L_0x001d:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x001f }
        L_0x001f:
            r1 = move-exception
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r5.addSuppressed(r0)
        L_0x002a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Libraries.C1219f.m2947b(java.io.File):byte[]");
    }

    /* renamed from: b */
    public static long m2946b(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m2940a(inputStream, outputStream, 8192);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r1 = move-exception;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m2943a(java.io.InputStream r2) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            m2939a((java.io.InputStream) r2, (java.io.OutputStream) r0)     // Catch:{ all -> 0x0010 }
            byte[] r2 = r0.toByteArray()     // Catch:{ all -> 0x0010 }
            r0.close()
            return r2
        L_0x0010:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x001b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Libraries.C1219f.m2943a(java.io.InputStream):byte[]");
    }

    /* renamed from: a */
    public static byte[] m2945a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return m2944a(inputStream, (int) j);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
    }

    /* renamed from: a */
    public static byte[] m2944a(InputStream inputStream, int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
        } else if (i == 0) {
            return f2677a;
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException("Unexpected read size. current: " + i2 + ", expected: " + i);
        }
    }

    /* renamed from: a */
    public static int m2939a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long b = m2946b(inputStream, outputStream);
        if (b > 2147483647L) {
            return -1;
        }
        return (int) b;
    }

    /* renamed from: a */
    public static long m2940a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        return m2941a(inputStream, outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static long m2941a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
