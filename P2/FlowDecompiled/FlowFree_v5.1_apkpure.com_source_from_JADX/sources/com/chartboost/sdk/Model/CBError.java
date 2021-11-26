package com.chartboost.sdk.Model;

public final class CBError {

    /* renamed from: a */
    private final C1227b f2695a;

    /* renamed from: b */
    private final String f2696b;

    /* renamed from: c */
    private boolean f2697c = true;

    public enum CBClickError {
        URI_INVALID,
        URI_UNRECOGNIZED,
        AGE_GATE_FAILURE,
        NO_HOST_ACTIVITY,
        INTERNAL
    }

    public enum CBImpressionError {
        INTERNAL,
        INTERNET_UNAVAILABLE,
        TOO_MANY_CONNECTIONS,
        WRONG_ORIENTATION,
        FIRST_SESSION_INTERSTITIALS_DISABLED,
        NETWORK_FAILURE,
        NO_AD_FOUND,
        SESSION_NOT_STARTED,
        IMPRESSION_ALREADY_VISIBLE,
        NO_HOST_ACTIVITY,
        USER_CANCELLATION,
        INVALID_LOCATION,
        VIDEO_UNAVAILABLE,
        VIDEO_ID_MISSING,
        ERROR_PLAYING_VIDEO,
        INVALID_RESPONSE,
        ASSETS_DOWNLOAD_FAILURE,
        ERROR_CREATING_VIEW,
        ERROR_DISPLAYING_VIEW,
        INCOMPATIBLE_API_VERSION,
        ERROR_LOADING_WEB_VIEW,
        ASSET_PREFETCH_IN_PROGRESS,
        ACTIVITY_MISSING_IN_MANIFEST,
        EMPTY_LOCAL_VIDEO_LIST,
        END_POINT_DISABLED,
        HARDWARE_ACCELERATION_DISABLED,
        PENDING_IMPRESSION_ERROR,
        VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION,
        ASSET_MISSING,
        WEB_VIEW_PAGE_LOAD_TIMEOUT,
        WEB_VIEW_CLIENT_RECEIVED_ERROR,
        INTERNET_UNAVAILABLE_AT_SHOW;
        
        private String adID;

        public String getAdId() {
            return this.adID;
        }

        public String setAdId(String str) {
            this.adID = str;
            return str;
        }
    }

    /* renamed from: com.chartboost.sdk.Model.CBError$a */
    static /* synthetic */ class C1226a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2699a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.chartboost.sdk.Model.CBError$b[] r0 = com.chartboost.sdk.Model.CBError.C1227b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2699a = r0
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C1227b.MISCELLANEOUS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2699a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C1227b.UNEXPECTED_RESPONSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2699a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C1227b.PUBLIC_KEY_MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2699a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C1227b.INTERNET_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2699a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C1227b.HTTP_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f2699a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C1227b.NETWORK_FAILURE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f2699a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C1227b.INVALID_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Model.CBError.C1226a.<clinit>():void");
        }
    }

    /* renamed from: com.chartboost.sdk.Model.CBError$b */
    public enum C1227b {
        MISCELLANEOUS,
        INTERNET_UNAVAILABLE,
        INVALID_RESPONSE,
        UNEXPECTED_RESPONSE,
        NETWORK_FAILURE,
        PUBLIC_KEY_MISSING,
        HTTP_NOT_FOUND
    }

    public CBError(C1227b bVar, String str) {
        this.f2695a = bVar;
        this.f2696b = str;
    }

    public C1227b getError() {
        return this.f2695a;
    }

    public String getErrorDesc() {
        return this.f2696b;
    }

    public CBImpressionError getImpressionError() {
        int i = C1226a.f2699a[this.f2695a.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return CBImpressionError.INTERNAL;
        }
        if (i == 4) {
            return CBImpressionError.INTERNET_UNAVAILABLE;
        }
        if (i != 5) {
            return CBImpressionError.NETWORK_FAILURE;
        }
        return CBImpressionError.NO_AD_FOUND;
    }

    public boolean isRecoverable() {
        return this.f2697c;
    }

    public void setRecoverable(boolean z) {
        this.f2697c = z;
    }
}
