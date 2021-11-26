package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.dp */
public class C1683dp<ObjectType> implements C1688ds<ObjectType> {

    /* renamed from: a */
    protected final C1688ds<ObjectType> f4279a;

    public C1683dp(C1688ds<ObjectType> dsVar) {
        this.f4279a = dsVar;
    }

    /* renamed from: a */
    public void mo11274a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        C1688ds<ObjectType> dsVar = this.f4279a;
        if (dsVar != null && outputStream != null && objecttype != null) {
            dsVar.mo11274a(outputStream, objecttype);
        }
    }

    /* renamed from: a */
    public ObjectType mo11273a(InputStream inputStream) throws IOException {
        C1688ds<ObjectType> dsVar = this.f4279a;
        if (dsVar == null || inputStream == null) {
            return null;
        }
        return dsVar.mo11273a(inputStream);
    }
}
