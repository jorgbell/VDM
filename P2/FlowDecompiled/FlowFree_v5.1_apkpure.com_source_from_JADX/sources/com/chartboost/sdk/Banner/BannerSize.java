package com.chartboost.sdk.Banner;

import android.util.Size;

public enum BannerSize {
    STANDARD,
    MEDIUM,
    LEADERBOARD;

    /* renamed from: com.chartboost.sdk.Banner.BannerSize$a */
    static /* synthetic */ class C1204a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2630a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.chartboost.sdk.Banner.BannerSize[] r0 = com.chartboost.sdk.Banner.BannerSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2630a = r0
                com.chartboost.sdk.Banner.BannerSize r1 = com.chartboost.sdk.Banner.BannerSize.STANDARD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2630a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.chartboost.sdk.Banner.BannerSize r1 = com.chartboost.sdk.Banner.BannerSize.MEDIUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2630a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.chartboost.sdk.Banner.BannerSize r1 = com.chartboost.sdk.Banner.BannerSize.LEADERBOARD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Banner.BannerSize.C1204a.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static Size m2843a(BannerSize bannerSize) {
        Size size = new Size(320, 50);
        Size size2 = new Size(300, 250);
        Size size3 = new Size(728, 90);
        int i = C1204a.f2630a[bannerSize.ordinal()];
        if (i == 1) {
            return size;
        }
        if (i == 2) {
            return size2;
        }
        if (i != 3) {
            return null;
        }
        return size3;
    }

    public static BannerSize fromInteger(int i) {
        if (i == 0) {
            return STANDARD;
        }
        if (i == 1) {
            return MEDIUM;
        }
        if (i != 2) {
            return null;
        }
        return LEADERBOARD;
    }

    public static int getHeight(BannerSize bannerSize) {
        Size a = m2843a(bannerSize);
        if (a != null) {
            return a.getHeight();
        }
        return 0;
    }

    public static int getWidth(BannerSize bannerSize) {
        Size a = m2843a(bannerSize);
        if (a != null) {
            return a.getWidth();
        }
        return 0;
    }
}
