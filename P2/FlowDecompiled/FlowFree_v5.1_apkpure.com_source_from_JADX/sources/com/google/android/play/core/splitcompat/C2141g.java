package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.internal.C2098bz;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.g */
final class C2141g implements C2143i {

    /* renamed from: a */
    final /* synthetic */ Set f5260a;

    /* renamed from: b */
    final /* synthetic */ C2151q f5261b;

    /* renamed from: c */
    final /* synthetic */ ZipFile f5262c;

    C2141g(Set set, C2151q qVar, ZipFile zipFile) {
        this.f5260a = set;
        this.f5261b = qVar;
        this.f5262c = zipFile;
    }

    /* renamed from: a */
    public final void mo22147a(C2144j jVar, File file, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        this.f5260a.add(file);
        if (!z) {
            Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", new Object[]{this.f5261b.mo22155b(), jVar.f5263a, this.f5261b.mo22154a().getAbsolutePath(), jVar.f5264b.getName(), file.getAbsolutePath()}));
            ZipFile zipFile = this.f5262c;
            ZipEntry zipEntry = jVar.f5264b;
            int i = C2145k.f5265a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        C2098bz.m5252a(th, th2);
                    }
                }
                throw th;
            }
        } else {
            return;
        }
        throw th;
    }
}
