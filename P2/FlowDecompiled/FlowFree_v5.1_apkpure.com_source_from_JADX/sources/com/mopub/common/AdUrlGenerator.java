package com.mopub.common;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.text.TextUtils;
import android.view.WindowInsets;
import com.mopub.common.ClientMetadata;
import com.mopub.common.privacy.ConsentData;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.DateAndTime;
import com.mopub.network.RequestRateTracker;

public abstract class AdUrlGenerator extends BaseUrlGenerator {
    protected String mAdUnitId;
    private final ConsentData mConsentData;
    protected Context mContext;
    protected String mKeywords;
    private final PersonalInfoManager mPersonalInfoManager;
    protected Point mRequestedAdSize;
    protected String mUserDataKeywords;
    protected WindowInsets mWindowInsets;

    @Deprecated
    public AdUrlGenerator withFacebookSupported(boolean z) {
        return this;
    }

    public AdUrlGenerator(Context context) {
        this.mContext = context;
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        this.mPersonalInfoManager = personalInformationManager;
        if (personalInformationManager == null) {
            this.mConsentData = null;
        } else {
            this.mConsentData = personalInformationManager.getConsentData();
        }
    }

    public AdUrlGenerator withAdUnitId(String str) {
        this.mAdUnitId = str;
        return this;
    }

    public AdUrlGenerator withKeywords(String str) {
        this.mKeywords = str;
        return this;
    }

    public AdUrlGenerator withUserDataKeywords(String str) {
        this.mUserDataKeywords = str;
        return this;
    }

    public AdUrlGenerator withRequestedAdSize(Point point) {
        this.mRequestedAdSize = point;
        return this;
    }

    public AdUrlGenerator withWindowInsets(WindowInsets windowInsets) {
        this.mWindowInsets = windowInsets;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setAdUnitId(String str) {
        addParam("id", str);
    }

    /* access modifiers changed from: protected */
    public void setSdkVersion(String str) {
        addParam("nv", str);
    }

    /* access modifiers changed from: protected */
    public void setKeywords(String str) {
        addParam("q", str);
    }

    /* access modifiers changed from: protected */
    public void setUserDataKeywords(String str) {
        if (MoPub.canCollectPersonalInformation()) {
            addParam("user_data_q", str);
        }
    }

    /* access modifiers changed from: protected */
    public void setLocation() {
        Location lastKnownLocation;
        if (MoPub.canCollectPersonalInformation() && (lastKnownLocation = LocationService.getLastKnownLocation(this.mContext)) != null) {
            addParam("ll", lastKnownLocation.getLatitude() + "," + lastKnownLocation.getLongitude());
            addParam("lla", String.valueOf((int) lastKnownLocation.getAccuracy()));
            addParam("llf", String.valueOf(calculateLocationStalenessInMilliseconds(lastKnownLocation)));
            addParam("llsdk", "1");
        }
    }

    /* access modifiers changed from: protected */
    public void setTimezone(String str) {
        addParam("z", str);
    }

    /* access modifiers changed from: protected */
    public void setOrientation(String str) {
        addParam("o", str);
    }

    /* access modifiers changed from: protected */
    public void setDensity(float f) {
        addParam("sc", "" + f);
    }

    /* access modifiers changed from: protected */
    public void setMraidFlag(boolean z) {
        if (z) {
            addParam("mr", "1");
        }
    }

    /* access modifiers changed from: protected */
    public void setMccCode(String str) {
        addParam("mcc", str == null ? "" : str.substring(0, mncPortionLength(str)));
    }

    /* access modifiers changed from: protected */
    public void setMncCode(String str) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str.substring(mncPortionLength(str));
        }
        addParam("mnc", str2);
    }

    /* access modifiers changed from: protected */
    public void setIsoCountryCode(String str) {
        addParam("iso", str);
    }

    /* access modifiers changed from: protected */
    public void setCarrierName(String str) {
        addParam("cn", str);
    }

    /* access modifiers changed from: protected */
    public void setNetworkType(ClientMetadata.MoPubNetworkType moPubNetworkType) {
        addParam("ct", moPubNetworkType);
    }

    /* access modifiers changed from: protected */
    public void setBundleId(String str) {
        if (!TextUtils.isEmpty(str)) {
            addParam("bundle", str);
        }
    }

    /* access modifiers changed from: protected */
    public void setViewability() {
        addParam("vv", String.valueOf(ViewabilityManager.isViewabilityEnabled() ? 4 : 0));
        addParam("vver", ViewabilityManager.getOmidVersion());
    }

    /* access modifiers changed from: protected */
    public void setAdvancedBiddingTokens() {
        addParam("abt", MoPub.getAdvancedBiddingTokensJson(this.mContext));
    }

    /* access modifiers changed from: protected */
    public void setGdprApplies() {
        PersonalInfoManager personalInfoManager = this.mPersonalInfoManager;
        if (personalInfoManager != null) {
            addParam("gdpr_applies", personalInfoManager.gdprApplies());
        }
    }

    /* access modifiers changed from: protected */
    public void setForceGdprApplies() {
        ConsentData consentData = this.mConsentData;
        if (consentData != null) {
            addParam("force_gdpr_applies", Boolean.valueOf(consentData.isForceGdprApplies()));
        }
    }

    /* access modifiers changed from: protected */
    public void setCurrentConsentStatus() {
        PersonalInfoManager personalInfoManager = this.mPersonalInfoManager;
        if (personalInfoManager != null) {
            addParam("current_consent_status", personalInfoManager.getPersonalInfoConsentStatus().getValue());
        }
    }

    /* access modifiers changed from: protected */
    public void setConsentedPrivacyPolicyVersion() {
        ConsentData consentData = this.mConsentData;
        if (consentData != null) {
            addParam("consented_privacy_policy_version", consentData.getConsentedPrivacyPolicyVersion());
        }
    }

    /* access modifiers changed from: protected */
    public void setConsentedVendorListVersion() {
        ConsentData consentData = this.mConsentData;
        if (consentData != null) {
            addParam("consented_vendor_list_version", consentData.getConsentedVendorListVersion());
        }
    }

    /* access modifiers changed from: protected */
    public void addBaseParams(ClientMetadata clientMetadata) {
        setAdUnitId(this.mAdUnitId);
        setSdkVersion(clientMetadata.getSdkVersion());
        appendAppEngineInfo();
        appendWrapperVersion();
        setDeviceInfo(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        setBundleId(clientMetadata.getAppPackageName());
        setKeywords(this.mKeywords);
        if (MoPub.canCollectPersonalInformation()) {
            setUserDataKeywords(this.mUserDataKeywords);
            setLocation();
        }
        setTimezone(DateAndTime.getTimeZoneOffsetString());
        setOrientation(clientMetadata.getOrientationString());
        setDeviceDimensions(clientMetadata.getDeviceDimensions(), this.mRequestedAdSize, this.mWindowInsets);
        setDensity(clientMetadata.getDensity());
        String networkOperatorForUrl = clientMetadata.getNetworkOperatorForUrl();
        setMccCode(networkOperatorForUrl);
        setMncCode(networkOperatorForUrl);
        setIsoCountryCode(clientMetadata.getIsoCountryCode());
        setCarrierName(clientMetadata.getNetworkOperatorName());
        setNetworkType(clientMetadata.getActiveNetworkType());
        setAppVersion(clientMetadata.getAppVersion());
        setAdvancedBiddingTokens();
        appendAdvertisingInfoTemplates();
        setGdprApplies();
        setForceGdprApplies();
        setCurrentConsentStatus();
        setConsentedPrivacyPolicyVersion();
        setConsentedVendorListVersion();
        addRequestRateParameters();
        setViewability();
    }

    private void addParam(String str, ClientMetadata.MoPubNetworkType moPubNetworkType) {
        addParam(str, moPubNetworkType.toString());
    }

    private int mncPortionLength(String str) {
        return Math.min(3, str.length());
    }

    private static int calculateLocationStalenessInMilliseconds(Location location) {
        Preconditions.checkNotNull(location);
        return (int) (System.currentTimeMillis() - location.getTime());
    }

    private void addRequestRateParameters() {
        int i;
        RequestRateTracker.TimeRecord recordForAdUnit = RequestRateTracker.getInstance().getRecordForAdUnit(this.mAdUnitId);
        if (recordForAdUnit != null && (i = recordForAdUnit.mBlockIntervalMs) >= 1) {
            addParam("backoff_ms", String.valueOf(i));
            addParam("backoff_reason", recordForAdUnit.mReason);
        }
    }
}
