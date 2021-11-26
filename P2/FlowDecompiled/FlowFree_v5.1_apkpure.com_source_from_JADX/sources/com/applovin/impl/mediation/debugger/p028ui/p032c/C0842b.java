package com.applovin.impl.mediation.debugger.p028ui.p032c;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0800a;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0804c;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0805d;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0852e;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1118f;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.C1199R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.c.b */
public class C0842b extends C0850d {

    /* renamed from: a */
    private final List<C0846c> f1096a;

    /* renamed from: b */
    private final List<C0846c> f1097b;

    /* renamed from: d */
    private final List<C0846c> f1098d;

    /* renamed from: e */
    private final List<C0846c> f1099e;

    /* renamed from: f */
    private final List<C0846c> f1100f;

    /* renamed from: g */
    private SpannedString f1101g;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.c.b$a */
    public enum C0843a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    C0842b(C0801b bVar, Context context) {
        super(context);
        if (bVar.mo8587a() == C0801b.C0802a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f1101g = new SpannedString(spannableString);
        } else {
            this.f1101g = new SpannedString("");
        }
        this.f1096a = m1297a(bVar);
        this.f1097b = m1299a(bVar.mo8603p());
        this.f1098d = m1298a(bVar.mo8605r());
        this.f1099e = m1302b(bVar.mo8604q());
        this.f1100f = m1306e(bVar);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private int m1295a(boolean z) {
        return z ? C1199R.C1200drawable.applovin_ic_check_mark_bordered : C1199R.C1200drawable.applovin_ic_x_mark;
    }

    /* renamed from: a */
    private C0846c m1296a(C0801b.C0803b bVar) {
        C0846c.C0848a p = C0846c.m1320p();
        if (bVar == C0801b.C0803b.READY) {
            p.mo8690a(this.f1153c);
        }
        return p.mo8692a("Test Mode").mo8697b(bVar.mo8609a()).mo8695b(bVar.mo8610b()).mo8701d(bVar.mo8611c()).mo8693a(true).mo8694a();
    }

    /* renamed from: a */
    private List<C0846c> m1297a(C0801b bVar) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(m1301b(bVar));
        arrayList.add(m1303c(bVar));
        arrayList.add(m1305d(bVar));
        return arrayList;
    }

    /* renamed from: a */
    private List<C0846c> m1298a(C0804c cVar) {
        ArrayList arrayList = new ArrayList(1);
        if (cVar.mo8612a()) {
            boolean b = cVar.mo8613b();
            arrayList.add(C0846c.m1318a(b ? C0846c.C0849b.RIGHT_DETAIL : C0846c.C0849b.DETAIL).mo8692a("Cleartext Traffic").mo8696b(b ? null : this.f1101g).mo8701d(cVar.mo8614c()).mo8689a(m1295a(b)).mo8699c(m1300b(b)).mo8693a(true ^ b).mo8694a());
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C0846c> m1299a(List<C0805d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (C0805d next : list) {
                boolean c = next.mo8617c();
                arrayList.add(C0846c.m1318a(c ? C0846c.C0849b.RIGHT_DETAIL : C0846c.C0849b.DETAIL).mo8692a(next.mo8615a()).mo8696b(c ? null : this.f1101g).mo8701d(next.mo8616b()).mo8689a(m1295a(c)).mo8699c(m1300b(c)).mo8693a(!c).mo8694a());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m1300b(boolean z) {
        return C1118f.m2525a(z ? C1199R.color.applovin_sdk_checkmarkColor : C1199R.color.applovin_sdk_xmarkColor, this.f1153c);
    }

    /* renamed from: b */
    private C0846c m1301b(C0801b bVar) {
        C0846c.C0848a b = C0846c.m1320p().mo8692a("SDK").mo8697b(bVar.mo8596i());
        if (TextUtils.isEmpty(bVar.mo8596i())) {
            b.mo8689a(m1295a(bVar.mo8591d())).mo8699c(m1300b(bVar.mo8591d()));
        }
        return b.mo8694a();
    }

    /* renamed from: b */
    private List<C0846c> m1302b(List<C0800a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (C0800a next : list) {
                boolean c = next.mo8585c();
                arrayList.add(C0846c.m1318a(c ? C0846c.C0849b.RIGHT_DETAIL : C0846c.C0849b.DETAIL).mo8692a(next.mo8583a()).mo8696b(c ? null : this.f1101g).mo8701d(next.mo8584b()).mo8689a(m1295a(c)).mo8699c(m1300b(c)).mo8693a(!c).mo8694a());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private C0846c m1303c(C0801b bVar) {
        C0846c.C0848a b = C0846c.m1320p().mo8692a("Adapter").mo8697b(bVar.mo8597j());
        if (TextUtils.isEmpty(bVar.mo8597j())) {
            b.mo8689a(m1295a(bVar.mo8592e())).mo8699c(m1300b(bVar.mo8592e()));
        }
        return b.mo8694a();
    }

    /* renamed from: c */
    private C0846c m1304c(List<String> list) {
        return C0846c.m1320p().mo8692a("Region/VPN Required").mo8697b(C1117e.m2518a(list, ", ", list.size())).mo8694a();
    }

    /* renamed from: d */
    private C0846c m1305d(C0801b bVar) {
        boolean z;
        String str;
        String str2;
        boolean e = m1307e(bVar.mo8588b());
        boolean z2 = false;
        if (bVar.mo8606s().mo9326B().mo8744b()) {
            z = true;
            str2 = "Initialize with Activity Context";
            str = "Please ensure that you are initializing the AppLovin MAX SDK with an Activity Context.";
        } else {
            str = null;
            z2 = e;
            str2 = "Adapter Initialized";
            z = false;
        }
        return C0846c.m1320p().mo8692a(str2).mo8701d(str).mo8689a(m1295a(z2)).mo8699c(m1300b(z2)).mo8693a(z).mo8694a();
    }

    /* renamed from: e */
    private List<C0846c> m1306e(C0801b bVar) {
        ArrayList arrayList = new ArrayList(2);
        if (bVar.mo8589c() != C0801b.C0803b.NOT_SUPPORTED) {
            if (bVar.mo8600m() != null) {
                arrayList.add(m1304c(bVar.mo8600m()));
            }
            arrayList.add(m1296a(bVar.mo8589c()));
        }
        return arrayList;
    }

    /* renamed from: e */
    private boolean m1307e(int i) {
        return (i == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || i == MaxAdapter.InitializationStatus.INITIALIZING.getCode()) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo8631a(int i) {
        return (i == C0843a.INTEGRATIONS.ordinal() ? this.f1096a : i == C0843a.PERMISSIONS.ordinal() ? this.f1097b : i == C0843a.CONFIGURATION.ordinal() ? this.f1098d : i == C0843a.DEPENDENCIES.ordinal() ? this.f1099e : this.f1100f).size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo8633b() {
        return C0843a.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0846c mo8634b(int i) {
        return i == C0843a.INTEGRATIONS.ordinal() ? new C0852e("INTEGRATIONS") : i == C0843a.PERMISSIONS.ordinal() ? new C0852e("PERMISSIONS") : i == C0843a.CONFIGURATION.ordinal() ? new C0852e("CONFIGURATION") : i == C0843a.DEPENDENCIES.ordinal() ? new C0852e("DEPENDENCIES") : new C0852e("TEST ADS");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public List<C0846c> mo8635c(int i) {
        return i == C0843a.INTEGRATIONS.ordinal() ? this.f1096a : i == C0843a.PERMISSIONS.ordinal() ? this.f1097b : i == C0843a.CONFIGURATION.ordinal() ? this.f1098d : i == C0843a.DEPENDENCIES.ordinal() ? this.f1099e : this.f1100f;
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }
}
