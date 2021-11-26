package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2068aq;
import com.google.android.play.core.internal.C2088bp;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.splitcompat.C2150p;
import com.google.android.play.core.tasks.C2172i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.an */
final class C1963an implements C2046t {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C2058ag f4828a = new C2058ag("AssetPackServiceImpl");

    /* renamed from: b */
    private static final Intent f4829b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f4830c;

    /* renamed from: d */
    private final C1989bo f4831d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2068aq<C2115t> f4832e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2068aq<C2115t> f4833f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicBoolean f4834g = new AtomicBoolean();

    C1963an(Context context, C1989bo boVar) {
        this.f4830c = context.getPackageName();
        this.f4831d = boVar;
        if (C2088bp.m5239a(context)) {
            Context c = C2150p.m5402c(context);
            C2058ag agVar = f4828a;
            Intent intent = f4829b;
            this.f4832e = new C2068aq(c, agVar, "AssetPackService", intent, C2047u.f5136b);
            this.f4833f = new C2068aq(C2150p.m5402c(context), agVar, "AssetPackService-keepAlive", intent, C2047u.f5135a);
        }
        f4828a.mo22024a("AssetPackService initiated.", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public static Bundle m4898A(int i, String str) {
        Bundle B = m4899B(i);
        B.putString("module_name", str);
        return B;
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public static Bundle m4899B(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public static Bundle m4900C() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    /* renamed from: k */
    static /* synthetic */ ArrayList m4901k(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: m */
    static /* synthetic */ Bundle m4903m(Map map) {
        Bundle C = m4900C();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        C.putParcelableArrayList("installed_asset_module", arrayList);
        return C;
    }

    /* renamed from: r */
    static /* synthetic */ Bundle m4907r(int i, String str, String str2, int i2) {
        Bundle A = m4898A(i, str);
        A.putString("slice_id", str2);
        A.putInt("chunk_number", i2);
        return A;
    }

    /* renamed from: v */
    static /* synthetic */ List m4911v(C1963an anVar, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AssetPackState next = AssetPackStates.m4868b((Bundle) it.next(), anVar.f4831d).packStates().values().iterator().next();
            if (next == null) {
                f4828a.mo22025b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (C2009ck.m5042f(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public final void m4914y(int i, String str, int i2) {
        if (this.f4832e != null) {
            f4828a.mo22027d("notifyModuleCompleted", new Object[0]);
            C2172i iVar = new C2172i();
            this.f4832e.mo22036a(new C1954ac(this, iVar, i, str, iVar, i2));
            return;
        }
        throw new C1985bk("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: z */
    private static <T> Task<T> m4915z() {
        f4828a.mo22025b("onError(%d)", -11);
        return Tasks.m5431b(new AssetPackException(-11));
    }

    /* renamed from: b */
    public final void mo21858b(List<String> list) {
        if (this.f4832e != null) {
            f4828a.mo22027d("cancelDownloads(%s)", list);
            C2172i iVar = new C2172i();
            this.f4832e.mo22036a(new C2048y(this, iVar, list, iVar));
        }
    }

    /* renamed from: c */
    public final Task<List<String>> mo21859c(Map<String, Long> map) {
        if (this.f4832e == null) {
            return m4915z();
        }
        f4828a.mo22027d("syncPacks", new Object[0]);
        C2172i iVar = new C2172i();
        this.f4832e.mo22036a(new C2049z(this, iVar, map, iVar));
        return iVar.mo22194c();
    }

    /* renamed from: e */
    public final void mo21860e(int i, String str, String str2, int i2) {
        if (this.f4832e != null) {
            f4828a.mo22027d("notifyChunkTransferred", new Object[0]);
            C2172i iVar = new C2172i();
            this.f4832e.mo22036a(new C1953ab(this, iVar, i, str, str2, i2, iVar));
            return;
        }
        throw new C1985bk("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: f */
    public final void mo21861f(int i, String str) {
        m4914y(i, str, 10);
    }

    /* renamed from: g */
    public final void mo21862g(int i) {
        if (this.f4832e != null) {
            f4828a.mo22027d("notifySessionFailed", new Object[0]);
            C2172i iVar = new C2172i();
            this.f4832e.mo22036a(new C1955ad(this, iVar, i, iVar));
            return;
        }
        throw new C1985bk("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: h */
    public final Task<ParcelFileDescriptor> mo21863h(int i, String str, String str2, int i2) {
        if (this.f4832e == null) {
            return m4915z();
        }
        f4828a.mo22027d("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i2), Integer.valueOf(i));
        C2172i iVar = new C2172i();
        this.f4832e.mo22036a(new C1956ae(this, iVar, i, str, str2, i2, iVar));
        return iVar.mo22194c();
    }

    /* renamed from: j */
    public final synchronized void mo21864j() {
        if (this.f4833f == null) {
            f4828a.mo22028e("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        C2058ag agVar = f4828a;
        agVar.mo22027d("keepAlive", new Object[0]);
        if (!this.f4834g.compareAndSet(false, true)) {
            agVar.mo22027d("Service is already kept alive.", new Object[0]);
            return;
        }
        C2172i iVar = new C2172i();
        this.f4833f.mo22036a(new C1957af(this, iVar, iVar));
    }
}
