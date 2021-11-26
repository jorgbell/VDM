package com.mopub.mobileads;

import android.app.Activity;
import android.location.Location;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;

@Deprecated
public class MoPubRewardedVideoManager {
    @Deprecated
    public static void init(Activity activity, MediationSettings... mediationSettingsArr) {
        MoPubRewardedAdManager.init(activity, mediationSettingsArr);
    }

    @Deprecated
    public static void updateActivity(Activity activity) {
        MoPubRewardedAdManager.updateActivity(activity);
    }

    @Deprecated
    public static <T extends MediationSettings> T getGlobalMediationSettings(Class<T> cls) {
        return MoPubRewardedAdManager.getGlobalMediationSettings(cls);
    }

    @Deprecated
    public static <T extends MediationSettings> T getInstanceMediationSettings(Class<T> cls, String str) {
        return MoPubRewardedAdManager.getInstanceMediationSettings(cls, str);
    }

    @Deprecated
    public static void setRewardedVideoListener(MoPubRewardedVideoListener moPubRewardedVideoListener) {
        MoPubRewardedVideos.setRewardedVideoListener(moPubRewardedVideoListener);
    }

    @Deprecated
    public static final class RequestParameters {
        @Deprecated
        public final String mCustomerId;
        @Deprecated
        public final String mKeywords;
        @Deprecated
        public final Location mLocation;
        @Deprecated
        public final String mUserDataKeywords;

        @Deprecated
        public RequestParameters(String str) {
            this(str, (String) null);
        }

        @Deprecated
        public RequestParameters(String str, String str2) {
            this(str, str2, (Location) null);
        }

        @Deprecated
        public RequestParameters(String str, String str2, Location location) {
            this(str, str2, location, (String) null);
        }

        @Deprecated
        public RequestParameters(String str, String str2, Location location, String str3) {
            this.mKeywords = str;
            this.mCustomerId = str3;
            boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
            this.mUserDataKeywords = !canCollectPersonalInformation ? null : str2;
            this.mLocation = !canCollectPersonalInformation ? null : location;
        }
    }
}
