package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.C2156k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.ba */
final class C2079ba implements C2074aw {

    /* renamed from: a */
    private final /* synthetic */ int f5184a = 0;

    C2079ba() {
    }

    C2079ba(byte[] bArr) {
    }

    C2079ba(char[] cArr) {
    }

    C2079ba(float[] fArr) {
    }

    C2079ba(int[] iArr) {
    }

    C2079ba(short[] sArr) {
    }

    C2079ba(boolean[] zArr) {
    }

    C2079ba(byte[][] bArr) {
    }

    /* renamed from: c */
    static void m5199c(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                Log.d("Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "));
                hashSet.add(next.getParentFile());
            }
            C2085bg e = C2086bh.m5226e(m5201e(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) e.mo22054a()));
            synchronized (C2156k.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                Log.d("Splitcompat", sb.toString());
                e.mo22058e(hashSet);
            }
        }
    }

    /* renamed from: d */
    static boolean m5200d(ClassLoader classLoader, File file, File file2, boolean z, C2077az azVar, String str, C2076ay ayVar) {
        ArrayList arrayList = new ArrayList();
        Object e = m5201e(classLoader);
        C2085bg e2 = C2086bh.m5226e(e, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) e2.mo22054a());
        ArrayList arrayList2 = new ArrayList();
        for (Object d : asList) {
            arrayList2.add(C2086bh.m5225d(d, str, File.class).mo22054a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || ayVar.mo22049a(e, file2, file)) {
            e2.mo22057d(Arrays.asList(azVar.mo22050a(e, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            C2084bf bfVar = new C2084bf("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList.get(i);
                Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                C2098bz.m5252a(bfVar, iOException);
            }
            C2086bh.m5226e(e, "dexElementsSuppressedExceptions", IOException.class).mo22057d(arrayList);
            throw bfVar;
        }
        String valueOf = String.valueOf(file2.getPath());
        Log.w("SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "));
        return false;
    }

    /* renamed from: e */
    static Object m5201e(ClassLoader classLoader) {
        return C2086bh.m5225d(classLoader, "pathList", Object.class).mo22054a();
    }

    /* renamed from: f */
    static C2077az m5202f() {
        return new C2080bb((byte[]) null);
    }

    /* renamed from: g */
    static C2076ay m5203g() {
        return new C2083be((byte[]) null);
    }

    /* renamed from: h */
    public static void m5204h(ClassLoader classLoader, Set<File> set, C2081bc bcVar) {
        Class<C2156k> cls = C2156k.class;
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object e = m5201e(classLoader);
            C2085bg<List> d = C2086bh.m5225d(e, "nativeLibraryDirectories", List.class);
            synchronized (cls) {
                ArrayList arrayList = new ArrayList(d.mo22054a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                d.mo22055b(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a = bcVar.mo22053a(e, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                C2084bf bfVar = new C2084bf("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    C2098bz.m5252a(bfVar, (IOException) arrayList2.get(i));
                }
                throw bfVar;
            }
            synchronized (cls) {
                C2086bh.m5226e(e, "nativeLibraryPathElements", Object.class).mo22058e(Arrays.asList(a));
            }
        }
    }

    /* renamed from: i */
    static C2077az m5205i() {
        return new C2080bb();
    }

    /* renamed from: j */
    static C2081bc m5206j() {
        return new C2082bd((byte[]) null);
    }

    /* renamed from: k */
    public static boolean m5207k(ClassLoader classLoader, File file, File file2, boolean z) {
        return m5200d(classLoader, file, file2, z, m5205i(), "zip", m5203g());
    }

    /* renamed from: l */
    static void m5208l(ClassLoader classLoader, Set<File> set) {
        m5204h(classLoader, set, new C2082bd());
    }

    /* renamed from: m */
    static boolean m5209m(ClassLoader classLoader, File file, File file2, boolean z) {
        return m5200d(classLoader, file, file2, z, m5205i(), "path", new C2083be());
    }

    /* renamed from: a */
    public final void mo22047a(ClassLoader classLoader, Set set) {
        switch (this.f5184a) {
            case 0:
                m5199c(classLoader, set);
                return;
            case 1:
                m5199c(classLoader, set);
                return;
            case 2:
            case 3:
            case 4:
                m5204h(classLoader, set, m5206j());
                return;
            case 5:
                m5208l(classLoader, set);
                return;
            case 6:
                m5208l(classLoader, set);
                return;
            default:
                m5208l(classLoader, set);
                return;
        }
    }

    /* renamed from: b */
    public final boolean mo22048b(ClassLoader classLoader, File file, File file2, boolean z) {
        C2077az f;
        C2076ay g;
        String str;
        switch (this.f5184a) {
            case 0:
            case 1:
                f = m5202f();
                g = m5203g();
                str = "zip";
                break;
            case 2:
                return m5207k(classLoader, file, file2, z);
            case 3:
                return m5207k(classLoader, file, file2, z);
            case 4:
                return m5207k(classLoader, file, file2, z);
            case 5:
                return m5209m(classLoader, file, file2, z);
            case 6:
                return m5209m(classLoader, file, file2, z);
            default:
                f = m5205i();
                g = new C2083be((char[]) null);
                str = "path";
                break;
        }
        return m5200d(classLoader, file, file2, z, f, str, g);
    }
}
