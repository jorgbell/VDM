package com.chartboost.sdk.Events;

import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Model.CBError;

public class BannerErrorMap {

    /* renamed from: com.chartboost.sdk.Events.BannerErrorMap$1 */
    static /* synthetic */ class C12111 {
        static final /* synthetic */ int[] $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.chartboost.sdk.Model.CBError$CBImpressionError[] r0 = com.chartboost.sdk.Model.CBError.CBImpressionError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError = r0
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.INVALID_LOCATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x001d }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.WRONG_ORIENTATION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.NO_AD_FOUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x003e }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.ASSET_MISSING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.NETWORK_FAILURE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.INTERNET_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_SHOW     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x006c }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.ERROR_CREATING_VIEW     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.ERROR_DISPLAYING_VIEW     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.PENDING_IMPRESSION_ERROR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x009c }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.WEB_VIEW_CLIENT_RECEIVED_ERROR     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.WEB_VIEW_PAGE_LOAD_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Events.BannerErrorMap.C12111.<clinit>():void");
        }
    }

    private static ChartboostCacheError createBannerCacheError(ChartboostCacheError.Code code) {
        return new ChartboostCacheError(code);
    }

    private static ChartboostShowError createBannerShowError(ChartboostShowError.Code code, boolean z) {
        return new ChartboostShowError(code, z);
    }

    public static ChartboostError mapImpressionErrorToBannerCacheError(CBError.CBImpressionError cBImpressionError) {
        switch (C12111.$SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[cBImpressionError.ordinal()]) {
            case 1:
            case 3:
            case 4:
                return createBannerCacheError(ChartboostCacheError.Code.NO_AD_FOUND);
            case 2:
                return createBannerCacheError(ChartboostCacheError.Code.ASSET_DOWNLOAD_FAILURE);
            case 5:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return createBannerCacheError(ChartboostCacheError.Code.INTERNAL);
            case 6:
                return createBannerCacheError(ChartboostCacheError.Code.NETWORK_FAILURE);
            case 7:
                return createBannerCacheError(ChartboostCacheError.Code.INTERNET_UNAVAILABLE);
            default:
                return createBannerCacheError(ChartboostCacheError.Code.INTERNAL);
        }
    }

    public static ChartboostError mapImpressionErrorToBannerShowError(CBError.CBImpressionError cBImpressionError) {
        switch (C12111.$SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[cBImpressionError.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return createBannerShowError(ChartboostShowError.Code.NO_CACHED_AD, false);
            case 7:
            case 8:
                return createBannerShowError(ChartboostShowError.Code.INTERNET_UNAVAILABLE, false);
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return createBannerShowError(ChartboostShowError.Code.PRESENTATION_FAILURE, true);
            case 14:
                return createBannerShowError(ChartboostShowError.Code.INTERNET_UNAVAILABLE, true);
            default:
                return createBannerShowError(ChartboostShowError.Code.INTERNAL, false);
        }
    }
}
