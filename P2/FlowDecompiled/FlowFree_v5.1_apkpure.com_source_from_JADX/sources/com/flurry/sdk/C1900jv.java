package com.flurry.sdk;

import com.flurry.sdk.C1720ex;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.flurry.sdk.jv */
public final class C1900jv extends C1730f implements C1899ju {

    /* renamed from: a */
    public C1903jw f4696a = null;

    /* renamed from: b */
    public C1896jr f4697b;

    public C1900jv(C1896jr jrVar) {
        super("VNodeFileProcessor", C1720ex.m4478a(C1720ex.C1722a.DATA_PROCESSOR));
        this.f4697b = jrVar;
    }

    /* renamed from: a */
    public final void mo11564a(final List<File> list) {
        if (list != null && list.size() != 0) {
            runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    C1648cy.m4317a(2, "VNodeFileProcessor", "Number of files already pending: in VNodeListener " + list.size());
                    ArrayList arrayList = new ArrayList();
                    for (File file : list) {
                        if (file.exists()) {
                            arrayList.add(file.getAbsolutePath());
                        }
                    }
                    if (C1900jv.this.f4697b != null) {
                        C1900jv.this.f4697b.mo11493a(arrayList);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo11563a(String str) {
        String b = C1740ff.m4519b();
        File file = new File(b + File.separator + str);
        if (file.exists()) {
            mo11564a((List<File>) Arrays.asList(new File[]{file}));
        }
    }
}
