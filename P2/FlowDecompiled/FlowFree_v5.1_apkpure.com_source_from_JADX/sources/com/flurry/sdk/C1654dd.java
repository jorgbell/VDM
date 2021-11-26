package com.flurry.sdk;

import com.flurry.sdk.C1659df;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.dd */
public final class C1654dd<RequestObjectType, ResponseObjectType> extends C1659df {

    /* renamed from: a */
    public C1656a<RequestObjectType, ResponseObjectType> f4172a;

    /* renamed from: b */
    public RequestObjectType f4173b;

    /* renamed from: c */
    public C1688ds<RequestObjectType> f4174c;

    /* renamed from: d */
    public C1688ds<ResponseObjectType> f4175d;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ResponseObjectType f4176q;

    /* renamed from: com.flurry.sdk.dd$a */
    public interface C1656a<RequestObjectType, ResponseObjectType> {
        /* renamed from: a */
        void mo11330a(C1654dd<RequestObjectType, ResponseObjectType> ddVar, ResponseObjectType responseobjecttype);
    }

    /* renamed from: a */
    public final void mo11257a() {
        this.f4189h = new C1659df.C1663b() {
            /* renamed from: a */
            public final void mo11434a(OutputStream outputStream) throws Exception {
                if (C1654dd.this.f4173b != null && C1654dd.this.f4174c != null) {
                    C1654dd.this.f4174c.mo11274a(outputStream, C1654dd.this.f4173b);
                }
            }

            /* renamed from: a */
            public final void mo11433a(InputStream inputStream) throws Exception {
                if (C1654dd.this.f4175d != null) {
                    C1654dd ddVar = C1654dd.this;
                    Object unused = ddVar.f4176q = ddVar.f4175d.mo11273a(inputStream);
                }
            }

            /* renamed from: a */
            public final void mo11432a() {
                C1654dd.m4355d(C1654dd.this);
            }
        };
        super.mo11257a();
    }

    /* renamed from: d */
    static /* synthetic */ void m4355d(C1654dd ddVar) {
        if (ddVar.f4172a != null && !ddVar.mo11440c()) {
            ddVar.f4172a.mo11330a(ddVar, ddVar.f4176q);
        }
    }
}
