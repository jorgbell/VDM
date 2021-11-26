package com.amazon.device.iap.internal.p008b.p011c;

import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import java.util.Set;

/* renamed from: com.amazon.device.iap.internal.b.c.c */
/* compiled from: GetItemDataCommandBase */
abstract class C0494c extends C0516i {

    /* renamed from: a */
    protected final Set<String> f45a;

    C0494c(C0501e eVar, String str, Set<String> set) {
        super(eVar, "getItem_data", str);
        this.f45a = set;
        mo7468a("skus", set);
    }
}
