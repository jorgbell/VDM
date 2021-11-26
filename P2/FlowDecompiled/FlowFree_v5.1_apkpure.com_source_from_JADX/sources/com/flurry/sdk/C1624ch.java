package com.flurry.sdk;

/* renamed from: com.flurry.sdk.ch */
public final class C1624ch {

    /* renamed from: a */
    final C1625a f4106a;

    /* renamed from: b */
    private int f4107b = m4240b();

    /* renamed from: com.flurry.sdk.ch$a */
    public enum C1625a {
        TEN_SEC(10),
        THIRTY_SEC(30),
        THREE_MIN(180),
        ABANDON(0);
        

        /* renamed from: e */
        int f4113e;

        private C1625a(int i) {
            this.f4113e = i;
        }

        /* renamed from: a */
        public final C1625a mo11389a() {
            if (ordinal() == values().length - 1) {
                return this;
            }
            return values()[ordinal() + 1];
        }
    }

    public C1624ch(C1625a aVar) {
        this.f4106a = aVar;
    }

    /* renamed from: b */
    private static int m4240b() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /* renamed from: a */
    public final int mo11388a() {
        return (this.f4106a.f4113e + this.f4107b) - m4240b();
    }
}
