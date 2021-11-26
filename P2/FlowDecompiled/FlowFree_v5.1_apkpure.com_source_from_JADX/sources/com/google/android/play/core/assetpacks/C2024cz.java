package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2098bz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* renamed from: com.google.android.play.core.assetpacks.cz */
final class C2024cz {

    /* renamed from: a */
    private static final C2058ag f5075a = new C2058ag("SliceMetadataManager");

    /* renamed from: b */
    private final byte[] f5076b = new byte[8192];

    /* renamed from: c */
    private final C1970au f5077c;

    /* renamed from: d */
    private final String f5078d;

    /* renamed from: e */
    private final int f5079e;

    /* renamed from: f */
    private final long f5080f;

    /* renamed from: g */
    private final String f5081g;

    /* renamed from: h */
    private int f5082h;

    C2024cz(C1970au auVar, String str, int i, long j, String str2) {
        this.f5077c = auVar;
        this.f5078d = str;
        this.f5079e = i;
        this.f5080f = j;
        this.f5081g = str2;
        this.f5082h = -1;
    }

    /* renamed from: n */
    private final File m5067n() {
        File o = this.f5077c.mo21889o(this.f5078d, this.f5079e, this.f5080f, this.f5081g);
        if (!o.exists()) {
            o.mkdirs();
        }
        return o;
    }

    /* renamed from: o */
    private final File m5068o() throws IOException {
        File m = this.f5077c.mo21887m(this.f5078d, this.f5079e, this.f5080f, this.f5081g);
        m.getParentFile().mkdirs();
        m.createNewFile();
        return m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo21980a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f5082h));
        FileOutputStream fileOutputStream = new FileOutputStream(m5068o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo21981b(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f5082h));
        FileOutputStream fileOutputStream = new FileOutputStream(m5068o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File n = this.f5077c.mo21888n(this.f5078d, this.f5079e, this.f5080f, this.f5081g);
            if (n.exists()) {
                n.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(n);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                return;
            } catch (Throwable th) {
                C2098bz.m5252a(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            C2098bz.m5252a(th, th2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo21982c(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(mo21989j().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f5082h));
        FileOutputStream fileOutputStream = new FileOutputStream(m5068o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo21983d(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f5082h));
        FileOutputStream fileOutputStream = new FileOutputStream(m5068o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final C2023cy mo21984e() throws IOException {
        File m = this.f5077c.mo21887m(this.f5078d, this.f5079e, this.f5080f, this.f5081g);
        if (m.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(m);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new C1985bk("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f5082h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new C2023cy(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e) {
                    throw new C1985bk("Slice checkpoint file corrupt.", (Exception) e);
                }
            } catch (Throwable th) {
                C2098bz.m5252a(th, th);
            }
        } else {
            throw new C1985bk("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo21985f(InputStream inputStream, long j) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo21989j(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                read = inputStream.read(this.f5076b);
                if (read > 0) {
                    randomAccessFile.write(this.f5076b, 0, read);
                }
            } while (read == 8192);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo21986g(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        this.f5082h++;
        try {
            fileOutputStream = new FileOutputStream(new File(m5067n(), String.format("%s-LFH.dat", new Object[]{Integer.valueOf(this.f5082h)})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e) {
            throw new C1985bk("Could not write metadata file.", (Exception) e);
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo21987h(byte[] bArr, InputStream inputStream) throws IOException {
        this.f5082h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo21989j());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.f5076b);
            while (read > 0) {
                fileOutputStream.write(this.f5076b, 0, read);
                read = inputStream.read(this.f5076b);
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo21988i(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo21989j(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final File mo21989j() {
        return new File(m5067n(), String.format("%s-NAM.dat", new Object[]{Integer.valueOf(this.f5082h)}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final int mo21990k() throws IOException {
        File m = this.f5077c.mo21887m(this.f5078d, this.f5079e, this.f5080f, this.f5081g);
        if (!m.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(m);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new C1985bk("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final boolean mo21991l() {
        FileInputStream fileInputStream;
        File m = this.f5077c.mo21887m(this.f5078d, this.f5079e, this.f5080f, this.f5081g);
        if (!m.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(m);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") != null) {
                return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
            }
            f5075a.mo22025b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
            return false;
        } catch (IOException e) {
            f5075a.mo22025b("Could not read checkpoint while checking if extraction finished. %s", e);
            return false;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final void mo21992m(byte[] bArr, int i) throws IOException {
        this.f5082h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo21989j());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }
}
