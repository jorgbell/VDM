package com.noodlecake.flow.config;

public class FlowConfig {
    public static final int DISTRO_AMAZON = 1;
    public static final int DISTRO_AMAZON_DASH = 2;
    public static final int DISTRO_GOOGLE_PLAY = 0;
    public static final int DISTRO_PREMIUM = 3;
    public static final int DISTRO_UNKNOWN = 4;
    public static final boolean debug = false;
    public static final boolean isAmazon = false;
    public static final boolean isAmazonDash = false;
    public static final boolean isBridges = false;
    public static final boolean isClassic = true;
    public static final boolean isGoogle = true;
    public static final boolean isHexes = false;
    public static final boolean isPremium = false;
    public static final boolean isWarps = false;

    public static String getDistroLogString() {
        return "Google";
    }

    public static String getProductLogString() {
        if (isClassic) {
            return "Flow Free";
        }
        if (isBridges) {
            return "Flow Free: Bridges";
        }
        if (isHexes) {
            return "Flow Free: Hexes";
        }
        return isWarps ? "Flow Free: Warps" : "Flow Free: UNKNOWN";
    }
}
