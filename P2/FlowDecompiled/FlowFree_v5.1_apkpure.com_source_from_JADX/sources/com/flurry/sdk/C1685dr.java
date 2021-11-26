package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.sdk.dr */
public final class C1685dr<T> implements C1688ds<List<T>> {

    /* renamed from: a */
    C1688ds<T> f4280a;

    /* renamed from: a */
    public final /* synthetic */ void mo11274a(OutputStream outputStream, Object obj) throws IOException {
        List list = (List) obj;
        if (outputStream != null) {
            C16861 r0 = new DataOutputStream(outputStream) {
                public final void close() {
                }
            };
            int size = list != null ? list.size() : 0;
            r0.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.f4280a.mo11274a(outputStream, list.get(i));
            }
            r0.flush();
        }
    }

    public C1685dr(C1688ds<T> dsVar) {
        this.f4280a = dsVar;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo11273a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        int readInt = new DataInputStream(inputStream) {
            public final void close() {
            }
        }.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        int i = 0;
        while (i < readInt) {
            T a = this.f4280a.mo11273a(inputStream);
            if (a != null) {
                arrayList.add(a);
                i++;
            } else {
                throw new IOException("Missing record.");
            }
        }
        return arrayList;
    }
}
