package com.vungle.warren;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

public class AdConfig {
    @SerializedName("adOrientation")
    private int adOrientation = 2;
    @SerializedName("adSize")
    private AdSize adSize = AdSize.VUNGLE_DEFAULT;
    @SerializedName("ordinal")
    private int ordinal;
    @SerializedName("settings")
    private int settings;

    @Keep
    public enum AdSize {
        VUNGLE_MREC("mrec", 300, 250),
        VUNGLE_DEFAULT("default", -1, -1),
        BANNER("banner", 320, 50),
        BANNER_SHORT("banner_short", 300, 50),
        BANNER_LEADERBOARD("banner_leaderboard", 728, 90);
        
        private final int height;
        private final String name;
        private final int width;

        private AdSize(String str, int i, int i2) {
            this.width = i;
            this.height = i2;
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public static AdSize fromName(String str) {
            for (AdSize adSize : values()) {
                if (adSize.name.equals(str)) {
                    return adSize;
                }
            }
            return VUNGLE_DEFAULT;
        }

        public static boolean isDefaultAdSize(AdSize adSize) {
            return adSize == VUNGLE_DEFAULT || adSize == VUNGLE_MREC;
        }

        public static boolean isBannerAdSize(AdSize adSize) {
            return adSize == BANNER || adSize == BANNER_LEADERBOARD || adSize == BANNER_SHORT;
        }
    }

    public int getSettings() {
        return this.settings;
    }

    public void setMuted(boolean z) {
        if (z) {
            this.settings |= 1;
        } else {
            this.settings &= -2;
        }
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public void setOrdinal(int i) {
        this.ordinal = i;
    }

    public AdSize getAdSize() {
        AdSize adSize2 = this.adSize;
        return adSize2 == null ? AdSize.VUNGLE_DEFAULT : adSize2;
    }

    public void setAdSize(AdSize adSize2) {
        this.adSize = adSize2;
    }

    public int getAdOrientation() {
        return this.adOrientation;
    }

    public void setAdOrientation(int i) {
        this.adOrientation = i;
    }
}
