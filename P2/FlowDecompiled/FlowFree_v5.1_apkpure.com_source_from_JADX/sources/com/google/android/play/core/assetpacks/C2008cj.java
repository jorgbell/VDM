package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2075ax;
import com.google.android.play.core.internal.C2100ca;
import com.google.android.play.core.internal.C2109i;
import com.google.android.play.core.tasks.C2172i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.play.core.assetpacks.cj */
final class C2008cj implements C2046t {

    /* renamed from: a */
    private static final C2058ag f5012a = new C2058ag("FakeAssetPackService");

    /* renamed from: b */
    private final String f5013b;

    /* renamed from: c */
    private final C1967ar f5014c;

    /* renamed from: e */
    private final Context f5015e;

    /* renamed from: f */
    private final C2020cv f5016f;

    /* renamed from: g */
    private final C2100ca<Executor> f5017g;

    /* renamed from: i */
    private final Handler f5018i = new Handler(Looper.getMainLooper());

    static {
        new AtomicInteger(1);
    }

    C2008cj(File file, C1967ar arVar, C1989bo boVar, Context context, C2020cv cvVar, C2100ca<Executor> caVar) {
        this.f5013b = file.getAbsolutePath();
        this.f5014c = arVar;
        this.f5015e = context;
        this.f5016f = cvVar;
        this.f5017g = caVar;
    }

    /* renamed from: k */
    static long m5026k(int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0;
    }

    /* renamed from: q */
    private final File[] m5027q(String str) throws LocalTestingException {
        File file = new File(this.f5013b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new C2006ch(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File b : listFiles) {
                        if (C2075ax.m5192b(b).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    /* renamed from: r */
    private static String m5028r(File file) throws LocalTestingException {
        try {
            return C2009ck.m5039a(Arrays.asList(new File[]{file}));
        } catch (NoSuchAlgorithmException e) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e);
        } catch (IOException e2) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", new Object[]{file}), e2);
        }
    }

    /* renamed from: s */
    private final void m5029s(int i, String str, int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f5016f.mo21970a());
        bundle.putInt("session_id", i);
        File[] q = m5027q(str);
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (File file : q) {
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String b = C2075ax.m5192b(file);
            bundle.putParcelableArrayList(C2109i.m5274f("chunk_intents", str, b), arrayList2);
            bundle.putString(C2109i.m5274f("uncompressed_hash_sha256", str, b), m5028r(file));
            bundle.putLong(C2109i.m5274f("uncompressed_size", str, b), file.length());
            arrayList.add(b);
        }
        bundle.putStringArrayList(C2109i.m5273e("slice_ids", str), arrayList);
        bundle.putLong(C2109i.m5273e("pack_version", str), (long) this.f5016f.mo21970a());
        bundle.putInt(C2109i.m5273e("status", str), i2);
        bundle.putInt(C2109i.m5273e("error_code", str), 0);
        bundle.putLong(C2109i.m5273e("bytes_downloaded", str), m5026k(i2, j));
        bundle.putLong(C2109i.m5273e("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(new String[]{str})));
        bundle.putLong("bytes_downloaded", m5026k(i2, j));
        bundle.putLong("total_bytes_to_download", j);
        this.f5018i.post(new C2007ci(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    /* renamed from: b */
    public final void mo21858b(List<String> list) {
        f5012a.mo22027d("cancelDownload(%s)", list);
    }

    /* renamed from: c */
    public final Task<List<String>> mo21859c(Map<String, Long> map) {
        f5012a.mo22027d("syncPacks()", new Object[0]);
        return Tasks.m5430a(new ArrayList());
    }

    /* renamed from: e */
    public final void mo21860e(int i, String str, String str2, int i2) {
        f5012a.mo22027d("notifyChunkTransferred", new Object[0]);
    }

    /* renamed from: f */
    public final void mo21861f(int i, String str) {
        f5012a.mo22027d("notifyModuleCompleted", new Object[0]);
        this.f5017g.mo22065a().execute(new C2005cg(this, i, str));
    }

    /* renamed from: g */
    public final void mo21862g(int i) {
        f5012a.mo22027d("notifySessionFailed", new Object[0]);
    }

    /* renamed from: h */
    public final Task<ParcelFileDescriptor> mo21863h(int i, String str, String str2, int i2) {
        f5012a.mo22027d("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        C2172i iVar = new C2172i();
        try {
            for (File file : m5027q(str)) {
                if (C2075ax.m5192b(file).equals(str2)) {
                    iVar.mo22192a(ParcelFileDescriptor.open(file, 268435456));
                    return iVar.mo22194c();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e) {
            f5012a.mo22028e("getChunkFileDescriptor failed", e);
            iVar.mo22193b(new LocalTestingException("Asset Slice file not found.", e));
        } catch (LocalTestingException e2) {
            f5012a.mo22028e("getChunkFileDescriptor failed", e2);
            iVar.mo22193b(e2);
        }
    }

    /* renamed from: j */
    public final void mo21864j() {
        f5012a.mo22027d("keepAlive", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ void mo21955l(Intent intent) {
        this.f5014c.mo21868a(this.f5015e, intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* synthetic */ void mo21956m(int i, String str) {
        try {
            m5029s(i, str, 4);
        } catch (LocalTestingException e) {
            f5012a.mo22028e("notifyModuleCompleted failed", e);
        }
    }
}
