package com.flurry.sdk;

/* renamed from: com.flurry.sdk.fy */
public interface C1776fy {
    /* renamed from: a */
    void mo11529a();

    /* renamed from: a */
    void mo11530a(C1895jq jqVar);

    /* renamed from: com.flurry.sdk.fy$a */
    public enum C1777a {
        DO_NOT_FLUSH("DO_NOT_FLUSH"),
        REASON_STICKY_SET_COMPLETE("Sticky set is complete"),
        REASON_APP_STATE_CHANGE("App State has changed"),
        REASON_SESSION_FINALIZE("Session Finalized"),
        REASON_APP_CRASH("App crashed"),
        REASON_FORCE_FLUSH("Force to Flush"),
        REASON_STARTUP("App Started"),
        REASON_PUSH_TOKEN_REFRESH("Push Token Refreshed"),
        REASON_DATA_DELETION("Delete Data");
        

        /* renamed from: j */
        public final String f4447j;

        private C1777a(String str) {
            this.f4447j = str;
        }
    }
}
