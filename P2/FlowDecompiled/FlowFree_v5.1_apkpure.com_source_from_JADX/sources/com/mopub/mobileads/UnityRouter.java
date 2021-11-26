package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.common.privacy.PersonalInfoManager;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.MetaData;
import java.util.Map;

public class UnityRouter {
    private static final String ADAPTER_NAME = "UnityRouter";
    public static final String GAME_ID_KEY = "gameId";
    public static final String PLACEMENT_ID_KEY = "placementId";
    public static final String ZONE_ID_KEY = "zoneId";

    static void initUnityAds(Map<String, String> map, Context context, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        initGdpr(context);
        String str = map.get(GAME_ID_KEY);
        if (str == null || str.isEmpty()) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "gameId is missing or entered incorrectly in the MoPub UI");
        }
        initMediationMetadata(context);
        UnityAds.initialize(context, str, false, true, iUnityAdsInitializationListener);
    }

    static void initGdpr(Context context) {
        Boolean bool;
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
        boolean shouldAllowLegitimateInterest = MoPub.shouldAllowLegitimateInterest();
        if (personalInformationManager != null && personalInformationManager.gdprApplies() == (bool = Boolean.TRUE)) {
            MetaData metaData = new MetaData(context);
            if (!shouldAllowLegitimateInterest) {
                metaData.set("gdpr.consent", (Object) Boolean.valueOf(canCollectPersonalInformation));
            } else if (personalInformationManager.getPersonalInfoConsentStatus() == ConsentStatus.EXPLICIT_NO || personalInformationManager.getPersonalInfoConsentStatus() == ConsentStatus.DNT) {
                metaData.set("gdpr.consent", (Object) Boolean.FALSE);
            } else {
                metaData.set("gdpr.consent", (Object) bool);
            }
            metaData.commit();
        }
    }

    static void initMediationMetadata(Context context) {
        MediationMetaData mediationMetaData = new MediationMetaData(context);
        mediationMetaData.setName(MoPubLog.LOGTAG);
        mediationMetaData.setVersion(MoPub.SDK_VERSION);
        mediationMetaData.set("adapter_version", (Object) "3.7.1.0");
        mediationMetaData.commit();
    }

    static String placementIdForServerExtras(Map<String, String> map, String str) {
        String str2;
        if (map.containsKey(PLACEMENT_ID_KEY)) {
            str2 = map.get(PLACEMENT_ID_KEY);
        } else {
            str2 = map.containsKey(ZONE_ID_KEY) ? map.get(ZONE_ID_KEY) : null;
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }
}
