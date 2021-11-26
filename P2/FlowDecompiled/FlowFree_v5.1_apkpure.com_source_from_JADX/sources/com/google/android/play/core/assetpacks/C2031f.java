package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.f */
final /* synthetic */ class C2031f implements OnSuccessListener {

    /* renamed from: a */
    private final C1970au f5099a;

    private C2031f(C1970au auVar) {
        this.f5099a = auVar;
    }

    /* renamed from: a */
    static OnSuccessListener m5095a(C1970au auVar) {
        return new C2031f(auVar);
    }

    public final void onSuccess(Object obj) {
        this.f5099a.mo21873A((List) obj);
    }
}
