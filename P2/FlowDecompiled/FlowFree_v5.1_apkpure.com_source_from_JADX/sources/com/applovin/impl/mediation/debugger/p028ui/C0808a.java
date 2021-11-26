package com.applovin.impl.mediation.debugger.p028ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.sdk.C0923a;
import com.applovin.impl.sdk.utils.C1112a;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a */
public class C0808a extends Activity {

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a$a */
    public interface C0810a<T extends Activity> {
        /* renamed from: a */
        void mo8623a(T t);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (!C1160r.m2756e((Context) this)) {
            setTheme(C1199R.style.com_applovin_mediation_MaxDebuggerActivity_Theme_Live);
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void startActivity(final Class cls, final C0923a aVar, final C0810a aVar2) {
        aVar.mo8945a(new C1112a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (cls.isInstance(activity)) {
                    aVar2.mo8623a(activity);
                    aVar.mo8947b(this);
                }
            }
        });
        startActivity(new Intent(this, cls));
    }
}
