package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.internal.C2075ax;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.c */
public final class C2137c {

    /* renamed from: a */
    private final long f5249a;

    /* renamed from: b */
    private final Context f5250b;

    /* renamed from: c */
    private File f5251c;

    public C2137c(Context context) throws PackageManager.NameNotFoundException {
        this.f5250b = context;
        this.f5249a = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    /* renamed from: o */
    public static void m5365o(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File o : listFiles) {
                m5365o(o);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: p */
    private final File m5366p() throws IOException {
        File file = new File(m5367q(), "verified-splits");
        m5373w(file);
        return file;
    }

    /* renamed from: q */
    private final File m5367q() throws IOException {
        File file = new File(m5368r(), Long.toString(this.f5249a));
        m5373w(file);
        return file;
    }

    /* renamed from: r */
    private final File m5368r() throws IOException {
        if (this.f5251c == null) {
            Context context = this.f5250b;
            if (context != null) {
                this.f5251c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.f5251c, "splitcompat");
        m5373w(file);
        return file;
    }

    /* renamed from: s */
    private final File m5369s() throws IOException {
        File file = new File(m5367q(), "native-libraries");
        m5373w(file);
        return file;
    }

    /* renamed from: t */
    private final File m5370t(String str) throws IOException {
        File u = m5371u(m5369s(), str);
        m5373w(u);
        return u;
    }

    /* renamed from: u */
    private static File m5371u(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    /* renamed from: v */
    private static String m5372v(String str) {
        return String.valueOf(str).concat(".apk");
    }

    /* renamed from: w */
    private static void m5373w(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    /* renamed from: a */
    public final void mo22133a() throws IOException {
        File r = m5368r();
        String[] list = r.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f5249a))) {
                    File file = new File(r, str);
                    String valueOf = String.valueOf(file);
                    long j = this.f5249a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    m5365o(file);
                }
            }
        }
    }

    /* renamed from: b */
    public final File mo22134b(String str) throws IOException {
        return m5371u(mo22139g(), m5372v(str));
    }

    /* renamed from: c */
    public final File mo22135c(String str) throws IOException {
        return m5371u(m5366p(), m5372v(str));
    }

    /* renamed from: d */
    public final File mo22136d(File file) throws IOException {
        return m5371u(m5366p(), file.getName());
    }

    /* renamed from: e */
    public final File mo22137e(String str, String str2) throws IOException {
        return m5371u(m5370t(str), str2);
    }

    /* renamed from: f */
    public final File mo22138f() throws IOException {
        return new File(m5367q(), "lock.tmp");
    }

    /* renamed from: g */
    public final File mo22139g() throws IOException {
        File file = new File(m5367q(), "unverified-splits");
        m5373w(file);
        return file;
    }

    /* renamed from: h */
    public final File mo22140h(String str) throws IOException {
        File file = new File(m5367q(), "dex");
        m5373w(file);
        File u = m5371u(file, str);
        m5373w(u);
        return u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final Set<C2151q> mo22141i() throws IOException {
        File p = m5366p();
        HashSet hashSet = new HashSet();
        File[] listFiles = p.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new C2151q(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final List<String> mo22142j() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = m5369s().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final void mo22143k(String str) throws IOException {
        m5365o(m5370t(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final void mo22144l(File file) throws IOException {
        C2075ax.m5193c(file.getParentFile().getParentFile().equals(m5369s()), "File to remove is not a native library");
        m5365o(file);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final Set<File> mo22145m(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = m5370t(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final void mo22146n(String str) throws IOException {
        m5365o(mo22135c(str));
    }
}
