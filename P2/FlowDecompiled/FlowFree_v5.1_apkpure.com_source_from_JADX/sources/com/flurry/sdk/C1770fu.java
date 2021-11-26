package com.flurry.sdk;

/* renamed from: com.flurry.sdk.fu */
public interface C1770fu {

    /* renamed from: a */
    public static final C1771a f4413a = new C1771a(C1772b.DO_NOT_DROP, (C1895jq) null);

    /* renamed from: b */
    public static final C1771a f4414b = new C1771a(C1772b.DROP_EVENTS_UNIQUE_NAME_EXCEEDED, (C1895jq) null);

    /* renamed from: c */
    public static final C1771a f4415c = new C1771a(C1772b.DROP_EVENTS_NAME_INVALID, (C1895jq) null);

    /* renamed from: d */
    public static final C1771a f4416d = new C1771a(C1772b.DROP_EVENTS_COUNT_EXCEEDED, (C1895jq) null);

    /* renamed from: e */
    public static final C1771a f4417e = new C1771a(C1772b.DROP_TIMED_EVENTS_START_NOT_FOUND, (C1895jq) null);

    /* renamed from: f */
    public static final C1771a f4418f = new C1771a(C1772b.DROP_EVENTS_REASON_UNKNOWN, (C1895jq) null);

    /* renamed from: g */
    public static final C1771a f4419g = new C1771a(C1772b.DROP_ERROR_COUNT_EXCEEDED, (C1895jq) null);

    /* renamed from: h */
    public static final C1771a f4420h = new C1771a(C1772b.DROP_ORIGINS_COUNT_EXCEEDED, (C1895jq) null);

    /* renamed from: i */
    public static final C1771a f4421i = new C1771a(C1772b.DROP_SESSION_PROPERTIES_COUNT_EXCEEDED, (C1895jq) null);

    /* renamed from: a */
    C1771a mo11527a(C1895jq jqVar);

    /* renamed from: a */
    void mo11528a();

    /* renamed from: com.flurry.sdk.fu$b */
    public enum C1772b {
        DO_NOT_DROP("DoNotDrop"),
        DROP_EVENTS_UNIQUE_NAME_EXCEEDED("Unique Event Name exceeded"),
        DROP_EVENTS_NAME_INVALID("Invalid Event Name"),
        DROP_EVENTS_COUNT_EXCEEDED("Events count exceeded"),
        DROP_TIMED_EVENTS_START_NOT_FOUND("End Timed Event but Start not found"),
        DROP_EVENTS_REASON_UNKNOWN("reason unknown"),
        DROP_ERROR_COUNT_EXCEEDED("Error count exceeded"),
        DROP_ORIGINS_COUNT_EXCEEDED("Origins count exceeded"),
        DROP_SESSION_PROPERTIES_COUNT_EXCEEDED("Session properties count exceeded");
        

        /* renamed from: j */
        public final String f4434j;

        private C1772b(String str) {
            this.f4434j = str;
        }
    }

    /* renamed from: com.flurry.sdk.fu$a */
    public static class C1771a {

        /* renamed from: a */
        public C1772b f4422a;

        /* renamed from: b */
        public C1895jq f4423b;

        C1771a(C1772b bVar, C1895jq jqVar) {
            this.f4422a = bVar;
            this.f4423b = jqVar;
        }
    }
}
