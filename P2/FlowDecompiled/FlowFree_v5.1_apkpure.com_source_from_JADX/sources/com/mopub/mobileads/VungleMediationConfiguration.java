package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.MediationSettings;
import com.vungle.warren.AdConfig;
import java.util.HashMap;
import java.util.Map;

public class VungleMediationConfiguration implements MediationSettings {
    private final int mAdOrientation;
    private final String mBody;
    private final String mCloseButtonText;
    private final Map<String, Object> mExtras;
    private final boolean mIsStartMuted;
    private final String mKeepWatchingButtonText;
    private final int mOrdinalViewCount;
    private final String mTitle;
    private final String mUserId;

    public String getUserId() {
        return this.mUserId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getBody() {
        return this.mBody;
    }

    public String getCloseButtonText() {
        return this.mCloseButtonText;
    }

    public String getKeepWatchingButtonText() {
        return this.mKeepWatchingButtonText;
    }

    public boolean isStartMuted() {
        return this.mIsStartMuted;
    }

    public int getOrdinalViewCount() {
        return this.mOrdinalViewCount;
    }

    public int getAdOrientation() {
        return this.mAdOrientation;
    }

    public Map<String, Object> getExtrasMap() {
        return this.mExtras;
    }

    static void adConfigWithExtras(AdConfig adConfig, Map<String, String> map) {
        if (map.containsKey("startMuted")) {
            adConfig.setMuted(Boolean.parseBoolean(map.get("startMuted")));
        } else if (map.containsKey(VungleInterstitial.SOUND_ENABLED_KEY)) {
            String str = map.get(VungleInterstitial.SOUND_ENABLED_KEY);
            if (!TextUtils.isEmpty(str)) {
                adConfig.setMuted(!Boolean.parseBoolean(str));
            }
        }
        String str2 = map.get(VungleInterstitial.ORDINAL_VIEW_COUNT_KEY);
        if (!TextUtils.isEmpty(str2)) {
            try {
                adConfig.setOrdinal(Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
            }
        }
        String str3 = map.get(VungleInterstitial.AD_ORIENTATION_KEY);
        if (TextUtils.isEmpty(str3)) {
            str3 = VungleAdapterConfiguration.getWithAutoRotate();
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                adConfig.setAdOrientation(Integer.parseInt(str3));
            } catch (NumberFormatException unused2) {
            }
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int mAdOrientation = 2;
        /* access modifiers changed from: private */
        public String mBody;
        /* access modifiers changed from: private */
        public String mCloseButtonText;
        /* access modifiers changed from: private */
        public Map<String, Object> mExtras = new HashMap();
        /* access modifiers changed from: private */
        public boolean mIsStartMuted = false;
        /* access modifiers changed from: private */
        public String mKeepWatchingButtonText;
        /* access modifiers changed from: private */
        public int mOrdinalViewCount = 0;
        /* access modifiers changed from: private */
        public String mTitle;
        /* access modifiers changed from: private */
        public String mUserId;

        public Builder withUserId(String str) {
            this.mUserId = str;
            return this;
        }

        public Builder withCancelDialogTitle(String str) {
            this.mTitle = str;
            return this;
        }

        public Builder withCancelDialogBody(String str) {
            this.mBody = str;
            return this;
        }

        public Builder withCancelDialogCloseButton(String str) {
            this.mCloseButtonText = str;
            return this;
        }

        public Builder withCancelDialogKeepWatchingButton(String str) {
            this.mKeepWatchingButtonText = str;
            return this;
        }

        @Deprecated
        public Builder withSoundEnabled(boolean z) {
            return withStartMuted(!z);
        }

        public Builder withStartMuted(boolean z) {
            this.mIsStartMuted = z;
            this.mExtras.put("startMuted", Boolean.valueOf(z));
            return this;
        }

        public Builder withOrdinalViewCount(int i) {
            this.mOrdinalViewCount = i;
            this.mExtras.put(VungleInterstitial.ORDINAL_VIEW_COUNT_KEY, Integer.valueOf(i));
            return this;
        }

        public Builder withAutoRotate(int i) {
            this.mAdOrientation = i;
            this.mExtras.put(VungleInterstitial.AD_ORIENTATION_KEY, Integer.valueOf(i));
            return this;
        }

        public VungleMediationConfiguration build() {
            return new VungleMediationConfiguration(this);
        }
    }

    VungleMediationConfiguration(Builder builder) {
        this.mUserId = builder.mUserId;
        this.mTitle = builder.mTitle;
        this.mBody = builder.mBody;
        this.mCloseButtonText = builder.mCloseButtonText;
        this.mKeepWatchingButtonText = builder.mKeepWatchingButtonText;
        this.mIsStartMuted = builder.mIsStartMuted;
        this.mOrdinalViewCount = builder.mOrdinalViewCount;
        this.mAdOrientation = builder.mAdOrientation;
        this.mExtras = builder.mExtras;
    }
}
