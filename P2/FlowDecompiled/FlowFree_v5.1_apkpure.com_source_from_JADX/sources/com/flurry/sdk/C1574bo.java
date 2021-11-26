package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* renamed from: com.flurry.sdk.bo */
public final class C1574bo {

    /* renamed from: a */
    String f3987a;

    /* renamed from: b */
    byte[] f3988b;

    /* synthetic */ C1574bo(byte b) {
        this();
    }

    private C1574bo() {
        this.f3987a = null;
        this.f3988b = null;
    }

    public C1574bo(byte[] bArr) {
        this.f3987a = null;
        this.f3988b = null;
        this.f3987a = UUID.randomUUID().toString();
        this.f3988b = bArr;
    }

    /* renamed from: a */
    public static String m4120a(String str) {
        return ".yflurrydatasenderblock.".concat(String.valueOf(str));
    }

    /* renamed from: com.flurry.sdk.bo$a */
    public static class C1576a implements C1688ds<C1574bo> {

        /* renamed from: a */
        private int f3989a = 1;

        /* renamed from: a */
        public final /* synthetic */ void mo11274a(OutputStream outputStream, Object obj) throws IOException {
            C1574bo boVar = (C1574bo) obj;
            if (outputStream != null && boVar != null) {
                C15771 r0 = new DataOutputStream(outputStream) {
                    public final void close() {
                    }
                };
                int length = boVar.f3988b.length;
                if (this.f3989a == 1) {
                    r0.writeShort(length);
                } else {
                    r0.writeInt(length);
                }
                r0.write(boVar.f3988b);
                r0.writeShort(0);
                r0.flush();
            }
        }

        public C1576a(int i) {
            this.f3989a = i;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo11273a(InputStream inputStream) throws IOException {
            int i;
            if (inputStream == null) {
                return null;
            }
            C15782 r1 = new DataInputStream(inputStream) {
                public final void close() {
                }
            };
            C1574bo boVar = new C1574bo((byte) 0);
            if (this.f3989a == 1) {
                i = r1.readShort();
            } else {
                i = r1.readInt();
            }
            if (i == 0) {
                return null;
            }
            byte[] bArr = new byte[i];
            boVar.f3988b = bArr;
            r1.readFully(bArr);
            r1.readUnsignedShort();
            return boVar;
        }
    }

    /* renamed from: b */
    public static C1906l<C1574bo> m4121b(String str) {
        return new C1906l<>(C1536b.m4057a().getFileStreamPath(m4120a(str)), ".yflurrydatasenderblock.", 2, new C1693dv<C1574bo>() {
            /* renamed from: a */
            public final C1688ds<C1574bo> mo11281a(int i) {
                return new C1576a(i);
            }
        });
    }
}
