package com.applovin.impl.mediation.debugger.p028ui.p030b.p031a;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.sdk.C1048h;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a.b */
public class C0834b extends C0846c {

    /* renamed from: a */
    private final C1048h.C1049a f1060a;

    /* renamed from: o */
    private final Context f1061o;

    /* renamed from: p */
    private final boolean f1062p;

    public C0834b(C1048h.C1049a aVar, boolean z, Context context) {
        super(C0846c.C0849b.RIGHT_DETAIL);
        this.f1060a = aVar;
        this.f1061o = context;
        this.f1119d = new SpannedString(aVar.mo9309a());
        this.f1062p = z;
    }

    /* renamed from: a_ */
    public SpannedString mo8660a_() {
        return new SpannedString(this.f1060a.mo9310b(this.f1061o));
    }

    /* renamed from: b */
    public boolean mo8637b() {
        return true;
    }

    /* renamed from: b_ */
    public boolean mo8661b_() {
        Boolean a = this.f1060a.mo9308a(this.f1061o);
        if (a != null) {
            return a.equals(Boolean.valueOf(this.f1062p));
        }
        return false;
    }
}
