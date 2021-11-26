package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.flurry.sdk.cn */
public final class C1632cn extends C1634cp {

    /* renamed from: i */
    private final Context f4129i;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo11410b() {
    }

    C1632cn(Context context, String str) {
        this.f4129i = context;
        this.f4130a = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final InputStream mo11408a() throws IOException {
        if (this.f4129i != null && !TextUtils.isEmpty(this.f4130a)) {
            try {
                return this.f4129i.getAssets().open(this.f4130a);
            } catch (FileNotFoundException unused) {
                C1648cy.m4325b("LocalAssetsTransport", "File Not Found when opening " + this.f4130a);
            } catch (IOException unused2) {
                C1648cy.m4325b("LocalAssetsTransport", "IO Exception when opening " + this.f4130a);
            }
        }
        return null;
    }
}
