package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2098bz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.assetpacks.au */
final class C1970au {

    /* renamed from: a */
    private static final C2058ag f4853a = new C2058ag("AssetPackStorage");

    /* renamed from: b */
    private static final long f4854b;

    /* renamed from: c */
    private static final long f4855c;

    /* renamed from: d */
    private final Context f4856d;

    /* renamed from: e */
    private final C2020cv f4857e;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        f4854b = timeUnit.toMillis(14);
        f4855c = timeUnit.toMillis(28);
    }

    C1970au(Context context, C2020cv cvVar) {
        this.f4856d = context;
        this.f4857e = cvVar;
    }

    /* renamed from: D */
    private final File m4929D(String str, int i) {
        return new File(m4930E(str), String.valueOf(i));
    }

    /* renamed from: E */
    private final File m4930E(String str) {
        return new File(m4939O(), str);
    }

    /* renamed from: F */
    private final File m4931F(String str, int i, long j) {
        return new File(mo21884j(str, i, j), "merge.tmp");
    }

    /* renamed from: G */
    private static void m4932G(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long J = m4935J(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(J)) && !file2.getName().equals("stale.tmp")) {
                    m4940P(file2);
                }
            }
        }
    }

    /* renamed from: H */
    private static long m4933H(File file) {
        return m4934I(file, true);
    }

    /* renamed from: I */
    private static long m4934I(File file, boolean z) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        if (z && file.listFiles().length > 1) {
            f4853a.mo22028e("Multiple pack versions found, using highest version code.", new Object[0]);
        }
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e) {
            f4853a.mo22026c(e, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    /* renamed from: J */
    private static long m4935J(File file) {
        return m4934I(file, false);
    }

    /* renamed from: L */
    private final List<File> m4936L() {
        ArrayList arrayList = new ArrayList();
        try {
            if (m4939O().exists()) {
                if (m4939O().listFiles() != null) {
                    for (File file : m4939O().listFiles()) {
                        if (!file.getCanonicalPath().equals(m4938N().getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e) {
            f4853a.mo22025b("Could not process directory while scanning installed packs. %s", e);
        }
    }

    /* renamed from: M */
    private final File m4937M(String str, int i, long j) {
        return new File(new File(new File(m4938N(), str), String.valueOf(i)), String.valueOf(j));
    }

    /* renamed from: N */
    private final File m4938N() {
        return new File(m4939O(), "_tmp");
    }

    /* renamed from: O */
    private final File m4939O() {
        return new File(this.f4856d.getFilesDir(), "assetpacks");
    }

    /* renamed from: P */
    private static boolean m4940P(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File P : listFiles) {
                z &= m4940P(P);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public final void mo21873A(List<String> list) {
        int a = this.f4857e.mo21970a();
        for (File next : m4936L()) {
            if (!list.contains(next.getName()) && m4933H(next) != ((long) a)) {
                m4940P(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public final void mo21874B(String str, int i, long j) {
        if (m4937M(str, i, j).exists()) {
            m4940P(m4937M(str, i, j));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public final void mo21875C(String str, int i, long j) {
        if (mo21880f(str, i, j).exists()) {
            m4940P(mo21880f(str, i, j));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Map<String, AssetPackLocation> mo21876b() {
        HashMap hashMap = new HashMap();
        try {
            for (File next : m4936L()) {
                AssetPackLocation d = mo21878d(next.getName());
                if (d != null) {
                    hashMap.put(next.getName(), d);
                }
            }
        } catch (IOException e) {
            f4853a.mo22025b("Could not process directory while scanning installed packs: %s", e);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Map<String, Long> mo21877c() {
        HashMap hashMap = new HashMap();
        for (String next : mo21876b().keySet()) {
            hashMap.put(next, Long.valueOf(mo21894u(next)));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final AssetPackLocation mo21878d(String str) throws IOException {
        String e = mo21879e(str);
        if (e == null) {
            return null;
        }
        File file = new File(e, "assets");
        if (file.isDirectory()) {
            return AssetPackLocation.m4862b(e, file.getCanonicalPath());
        }
        f4853a.mo22025b("Failed to find assets directory: %s", file);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final String mo21879e(String str) throws IOException {
        int length;
        File file = new File(m4939O(), str);
        if (!file.exists()) {
            f4853a.mo22024a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.f4857e.mo21970a()));
        if (!file2.exists()) {
            f4853a.mo22024a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.f4857e.mo21970a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            f4853a.mo22024a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.f4857e.mo21970a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            f4853a.mo22025b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.f4857e.mo21970a()));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final File mo21880f(String str, int i, long j) {
        return new File(m4929D(str, i), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final File mo21881g(String str, int i, long j) {
        return new File(mo21880f(str, i, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final File mo21882h(String str, int i, long j, String str2) {
        return new File(new File(new File(m4937M(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final File mo21883i(String str, int i, long j, String str2) {
        return new File(new File(new File(m4937M(str, i, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final File mo21884j(String str, int i, long j) {
        return new File(m4937M(str, i, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final int mo21885k(String str, int i, long j) throws IOException {
        File F = m4931F(str, i, j);
        if (!F.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(F);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e) {
                    throw new C1985bk("Merge checkpoint file corrupt.", (Exception) e);
                }
            } else {
                throw new C1985bk("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            C2098bz.m5252a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final void mo21886l(String str, int i, long j, int i2) throws IOException {
        File F = m4931F(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        F.getParentFile().mkdirs();
        F.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(F);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final File mo21887m(String str, int i, long j, String str2) {
        return new File(mo21889o(str, i, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final File mo21888n(String str, int i, long j, String str2) {
        return new File(mo21889o(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final File mo21889o(String str, int i, long j, String str2) {
        return new File(mo21890p(str, i, j), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final File mo21890p(String str, int i, long j) {
        return new File(new File(m4937M(str, i, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public final void mo21891r(String str, int i, long j) {
        File E = m4930E(str);
        if (E.exists()) {
            for (File file : E.listFiles()) {
                if (!file.getName().equals(String.valueOf(i)) && !file.getName().equals("stale.tmp")) {
                    m4940P(file);
                } else if (file.getName().equals(String.valueOf(i))) {
                    for (File file2 : file.listFiles()) {
                        if (!file2.getName().equals(String.valueOf(j))) {
                            m4940P(file2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public final void mo21892s() {
        for (File next : m4936L()) {
            if (next.listFiles() != null) {
                m4932G(next);
                long J = m4935J(next);
                if (((long) this.f4857e.mo21970a()) != J) {
                    try {
                        new File(new File(next, String.valueOf(J)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        f4853a.mo22025b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File G : next.listFiles()) {
                    m4932G(G);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public final int mo21893t(String str) {
        return (int) m4933H(m4930E(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public final long mo21894u(String str) {
        return m4933H(m4929D(str, mo21893t(str)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public final void mo21895v() {
        for (File next : m4936L()) {
            if (next.listFiles() != null) {
                for (File file : next.listFiles()) {
                    File file2 = new File(file, "stale.tmp");
                    if (file2.exists() && System.currentTimeMillis() - file2.lastModified() > f4855c) {
                        m4940P(file);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public final void mo21896w() {
        if (m4938N().exists()) {
            for (File file : m4938N().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > f4854b) {
                    m4940P(file);
                } else {
                    m4932G(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public final void mo21897x() {
        m4940P(m4939O());
    }
}
