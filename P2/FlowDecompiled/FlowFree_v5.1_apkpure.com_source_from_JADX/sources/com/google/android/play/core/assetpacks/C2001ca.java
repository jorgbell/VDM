package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2100ca;
import com.google.android.play.core.internal.C2109i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.play.core.assetpacks.ca */
final class C2001ca {

    /* renamed from: a */
    private static final C2058ag f4987a = new C2058ag("ExtractorSessionStoreView");

    /* renamed from: b */
    private final C1970au f4988b;

    /* renamed from: c */
    private final C2100ca<C2046t> f4989c;

    /* renamed from: d */
    private final C1989bo f4990d;

    /* renamed from: e */
    private final C2100ca<Executor> f4991e;

    /* renamed from: f */
    private final Map<Integer, C1998bx> f4992f = new HashMap();

    /* renamed from: g */
    private final ReentrantLock f4993g = new ReentrantLock();

    C2001ca(C1970au auVar, C2100ca<C2046t> caVar, C1989bo boVar, C2100ca<Executor> caVar2) {
        this.f4988b = auVar;
        this.f4989c = caVar;
        this.f4990d = boVar;
        this.f4991e = caVar2;
    }

    /* renamed from: q */
    private final Map<String, C1998bx> m5002q(List<String> list) {
        return (Map) m5003r(new C1994bt(this, list, (byte[]) null));
    }

    /* renamed from: r */
    private final <T> T m5003r(C2000bz<T> bzVar) {
        try {
            mo21936a();
            return bzVar.mo21934a();
        } finally {
            mo21937b();
        }
    }

    /* renamed from: s */
    private final C1998bx m5004s(int i) {
        Map<Integer, C1998bx> map = this.f4992f;
        Integer valueOf = Integer.valueOf(i);
        C1998bx bxVar = map.get(valueOf);
        if (bxVar != null) {
            return bxVar;
        }
        throw new C1985bk(String.format("Could not find session %d while trying to get it", new Object[]{valueOf}), i);
    }

    /* renamed from: t */
    private static String m5005t(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new C1985bk("Session without pack received.");
    }

    /* renamed from: u */
    private static <T> List<T> m5006u(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo21936a() {
        this.f4993g.lock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo21937b() {
        this.f4993g.unlock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Map<Integer, C1998bx> mo21938c() {
        return this.f4992f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo21939d(Bundle bundle) {
        return ((Boolean) m5003r(new C1991bq(this, bundle, (byte[]) null))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo21940e(Bundle bundle) {
        return ((Boolean) m5003r(new C1991bq(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo21941f(String str, int i, long j) {
        m5003r(new C1992br(this, str, i, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo21942g(int i) {
        m5003r(new C1993bs(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final /* synthetic */ Map mo21943i(List list) {
        int i;
        Map<String, C1998bx> q = m5002q(list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C1998bx bxVar = q.get(str);
            if (bxVar == null) {
                i = 8;
            } else {
                if (C2009ck.m5042f(bxVar.f4980c.f4975c)) {
                    try {
                        bxVar.f4980c.f4975c = 6;
                        this.f4991e.mo22065a().execute(new C1995bu(this, bxVar));
                        this.f4990d.mo21931a(str);
                    } catch (C1985bk unused) {
                        f4987a.mo22027d("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(bxVar.f4978a), str);
                    }
                }
                i = bxVar.f4980c.f4975c;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ Map mo21944j(List list) {
        HashMap hashMap = new HashMap();
        for (C1998bx next : this.f4992f.values()) {
            String str = next.f4980c.f4973a;
            if (list.contains(str)) {
                C1998bx bxVar = (C1998bx) hashMap.get(str);
                if ((bxVar == null ? -1 : bxVar.f4978a) < next.f4978a) {
                    hashMap.put(str, next);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final /* synthetic */ Boolean mo21945k(Bundle bundle) {
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return Boolean.TRUE;
        }
        Map<Integer, C1998bx> map = this.f4992f;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return Boolean.TRUE;
        }
        C1998bx bxVar = this.f4992f.get(valueOf);
        if (bxVar.f4980c.f4975c == 6) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(!C2009ck.m5045i(bxVar.f4980c.f4975c, bundle.getInt(C2109i.m5273e("status", m5005t(bundle)))));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ Boolean mo21946l(Bundle bundle) {
        C1999by byVar;
        Bundle bundle2 = bundle;
        int i = bundle2.getInt("session_id");
        if (i == 0) {
            return Boolean.FALSE;
        }
        Map<Integer, C1998bx> map = this.f4992f;
        Integer valueOf = Integer.valueOf(i);
        boolean z = true;
        if (map.containsKey(valueOf)) {
            C1998bx s = m5004s(i);
            int i2 = bundle2.getInt(C2109i.m5273e("status", s.f4980c.f4973a));
            if (C2009ck.m5045i(s.f4980c.f4975c, i2)) {
                f4987a.mo22024a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(s.f4980c.f4975c));
                C1997bw bwVar = s.f4980c;
                String str = bwVar.f4973a;
                int i3 = bwVar.f4975c;
                if (i3 == 4) {
                    this.f4989c.mo22065a().mo21861f(i, str);
                } else if (i3 == 5) {
                    this.f4989c.mo22065a().mo21862g(i);
                } else if (i3 == 6) {
                    this.f4989c.mo22065a().mo21858b(Arrays.asList(new String[]{str}));
                }
            } else {
                s.f4980c.f4975c = i2;
                if (C2009ck.m5043g(i2)) {
                    mo21942g(i);
                    this.f4990d.mo21931a(s.f4980c.f4973a);
                } else {
                    for (C1999by next : s.f4980c.f4977e) {
                        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(C2109i.m5274f("chunk_intents", s.f4980c.f4973a, next.f4981a));
                        if (parcelableArrayList != null) {
                            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                                if (!(parcelableArrayList.get(i4) == null || ((Intent) parcelableArrayList.get(i4)).getData() == null)) {
                                    next.f4984d.get(i4).f4972a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String t = m5005t(bundle);
            long j = bundle2.getLong(C2109i.m5273e("pack_version", t));
            int i5 = bundle2.getInt(C2109i.m5273e("status", t));
            long j2 = bundle2.getLong(C2109i.m5273e("total_bytes_to_download", t));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(C2109i.m5273e("slice_ids", t));
            ArrayList arrayList = new ArrayList();
            for (T t2 : m5006u(stringArrayList)) {
                ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList(C2109i.m5274f("chunk_intents", t, t2));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : m5006u(parcelableArrayList2)) {
                    if (intent == null) {
                        z = false;
                    }
                    arrayList2.add(new C1996bv(z));
                    z = true;
                }
                String string = bundle2.getString(C2109i.m5274f("uncompressed_hash_sha256", t, t2));
                long j3 = bundle2.getLong(C2109i.m5274f("uncompressed_size", t, t2));
                int i6 = bundle2.getInt(C2109i.m5274f("patch_format", t, t2), 0);
                if (i6 != 0) {
                    byVar = new C1999by(t2, string, j3, arrayList2, 0, i6);
                } else {
                    byVar = new C1999by(t2, string, j3, arrayList2, bundle2.getInt(C2109i.m5274f("compression_format", t, t2), 0), 0);
                }
                arrayList.add(byVar);
                z = true;
            }
            this.f4992f.put(Integer.valueOf(i), new C1998bx(i, bundle2.getInt("app_version_code"), new C1997bw(t, j, i5, j2, arrayList)));
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* synthetic */ void mo21947m(String str, int i, long j) {
        C1998bx bxVar = m5002q(Arrays.asList(new String[]{str})).get(str);
        if (bxVar == null || C2009ck.m5043g(bxVar.f4980c.f4975c)) {
            f4987a.mo22025b(String.format("Could not find pack %s while trying to complete it", new Object[]{str}), new Object[0]);
        }
        this.f4988b.mo21874B(str, i, j);
        bxVar.f4980c.f4975c = 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void mo21948n(int i) {
        m5004s(i).f4980c.f4975c = 5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void mo21949o(int i) {
        C1998bx s = m5004s(i);
        if (C2009ck.m5043g(s.f4980c.f4975c)) {
            C1970au auVar = this.f4988b;
            C1997bw bwVar = s.f4980c;
            auVar.mo21874B(bwVar.f4973a, s.f4979b, bwVar.f4974b);
            C1997bw bwVar2 = s.f4980c;
            int i2 = bwVar2.f4975c;
            if (i2 == 5 || i2 == 6) {
                this.f4988b.mo21875C(bwVar2.f4973a, s.f4979b, bwVar2.f4974b);
                return;
            }
            return;
        }
        throw new C1985bk(String.format("Could not safely delete session %d because it is not in a terminal state.", new Object[]{Integer.valueOf(i)}), i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final void mo21950p(int i) {
        m5003r(new C1993bs(this, i, (byte[]) null));
    }
}
