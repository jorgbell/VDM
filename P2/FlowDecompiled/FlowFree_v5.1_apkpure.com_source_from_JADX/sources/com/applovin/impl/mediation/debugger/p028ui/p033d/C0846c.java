package com.applovin.impl.mediation.debugger.p028ui.p033d;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.C1118f;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.c */
public class C0846c {

    /* renamed from: b */
    protected C0849b f1117b;

    /* renamed from: c */
    protected boolean f1118c;

    /* renamed from: d */
    protected SpannedString f1119d;

    /* renamed from: e */
    protected SpannedString f1120e;

    /* renamed from: f */
    protected String f1121f;

    /* renamed from: g */
    protected String f1122g;

    /* renamed from: h */
    protected int f1123h;

    /* renamed from: i */
    protected int f1124i;

    /* renamed from: j */
    protected int f1125j;

    /* renamed from: k */
    protected int f1126k;

    /* renamed from: l */
    protected int f1127l;

    /* renamed from: m */
    protected int f1128m;

    /* renamed from: n */
    protected boolean f1129n;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.c$a */
    public static class C0848a {

        /* renamed from: a */
        final C0849b f1130a;

        /* renamed from: b */
        boolean f1131b;

        /* renamed from: c */
        SpannedString f1132c;

        /* renamed from: d */
        SpannedString f1133d;

        /* renamed from: e */
        String f1134e;

        /* renamed from: f */
        String f1135f;

        /* renamed from: g */
        int f1136g = 0;

        /* renamed from: h */
        int f1137h = 0;

        /* renamed from: i */
        int f1138i = -16777216;

        /* renamed from: j */
        int f1139j = -16777216;

        /* renamed from: k */
        int f1140k = 0;

        /* renamed from: l */
        int f1141l = 0;

        /* renamed from: m */
        boolean f1142m;

        public C0848a(C0849b bVar) {
            this.f1130a = bVar;
        }

        /* renamed from: a */
        public C0848a mo8689a(int i) {
            this.f1137h = i;
            return this;
        }

        /* renamed from: a */
        public C0848a mo8690a(Context context) {
            this.f1137h = C1199R.C1200drawable.applovin_ic_disclosure_arrow;
            this.f1141l = C1118f.m2525a(C1199R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        /* renamed from: a */
        public C0848a mo8691a(SpannedString spannedString) {
            this.f1132c = spannedString;
            return this;
        }

        /* renamed from: a */
        public C0848a mo8692a(String str) {
            return mo8691a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        /* renamed from: a */
        public C0848a mo8693a(boolean z) {
            this.f1131b = z;
            return this;
        }

        /* renamed from: a */
        public C0846c mo8694a() {
            return new C0846c(this);
        }

        /* renamed from: b */
        public C0848a mo8695b(int i) {
            this.f1139j = i;
            return this;
        }

        /* renamed from: b */
        public C0848a mo8696b(SpannedString spannedString) {
            this.f1133d = spannedString;
            return this;
        }

        /* renamed from: b */
        public C0848a mo8697b(String str) {
            return mo8696b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        /* renamed from: b */
        public C0848a mo8698b(boolean z) {
            this.f1142m = z;
            return this;
        }

        /* renamed from: c */
        public C0848a mo8699c(int i) {
            this.f1141l = i;
            return this;
        }

        /* renamed from: c */
        public C0848a mo8700c(String str) {
            this.f1134e = str;
            return this;
        }

        /* renamed from: d */
        public C0848a mo8701d(String str) {
            this.f1135f = str;
            return this;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.c$b */
    public enum C0849b {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);
        

        /* renamed from: g */
        private final int f1150g;

        private C0849b(int i) {
            this.f1150g = i;
        }

        /* renamed from: a */
        public int mo8702a() {
            return this.f1150g;
        }

        /* renamed from: b */
        public int mo8703b() {
            if (this == SECTION) {
                return C1199R.layout.list_section;
            }
            if (this == SECTION_CENTERED) {
                return C1199R.layout.list_section_centered;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            return this == DETAIL ? C1199R.layout.list_item_detail : C1199R.layout.list_item_right_detail;
        }
    }

    private C0846c(C0848a aVar) {
        this.f1123h = 0;
        this.f1124i = 0;
        this.f1125j = -16777216;
        this.f1126k = -16777216;
        this.f1127l = 0;
        this.f1128m = 0;
        this.f1117b = aVar.f1130a;
        this.f1118c = aVar.f1131b;
        this.f1119d = aVar.f1132c;
        this.f1120e = aVar.f1133d;
        this.f1121f = aVar.f1134e;
        this.f1122g = aVar.f1135f;
        this.f1123h = aVar.f1136g;
        this.f1124i = aVar.f1137h;
        this.f1125j = aVar.f1138i;
        this.f1126k = aVar.f1139j;
        this.f1127l = aVar.f1140k;
        this.f1128m = aVar.f1141l;
        this.f1129n = aVar.f1142m;
    }

    protected C0846c(C0849b bVar) {
        this.f1123h = 0;
        this.f1124i = 0;
        this.f1125j = -16777216;
        this.f1126k = -16777216;
        this.f1127l = 0;
        this.f1128m = 0;
        this.f1117b = bVar;
    }

    /* renamed from: a */
    public static C0848a m1318a(C0849b bVar) {
        return new C0848a(bVar);
    }

    /* renamed from: h */
    public static int m1319h() {
        return C0849b.COUNT.mo8702a();
    }

    /* renamed from: p */
    public static C0848a m1320p() {
        return m1318a(C0849b.RIGHT_DETAIL);
    }

    /* renamed from: a_ */
    public SpannedString mo8660a_() {
        return this.f1120e;
    }

    /* renamed from: b */
    public boolean mo8637b() {
        return this.f1118c;
    }

    /* renamed from: b_ */
    public boolean mo8661b_() {
        return this.f1129n;
    }

    /* renamed from: c */
    public int mo8638c() {
        return this.f1126k;
    }

    /* renamed from: e */
    public int mo8656e() {
        return this.f1123h;
    }

    /* renamed from: f */
    public int mo8657f() {
        return this.f1124i;
    }

    /* renamed from: g */
    public int mo8658g() {
        return this.f1128m;
    }

    /* renamed from: i */
    public int mo8682i() {
        return this.f1117b.mo8702a();
    }

    /* renamed from: j */
    public int mo8683j() {
        return this.f1117b.mo8703b();
    }

    /* renamed from: k */
    public SpannedString mo8684k() {
        return this.f1119d;
    }

    /* renamed from: l */
    public String mo8685l() {
        return this.f1121f;
    }

    /* renamed from: m */
    public String mo8686m() {
        return this.f1122g;
    }

    /* renamed from: n */
    public int mo8687n() {
        return this.f1125j;
    }

    /* renamed from: o */
    public int mo8688o() {
        return this.f1127l;
    }
}
