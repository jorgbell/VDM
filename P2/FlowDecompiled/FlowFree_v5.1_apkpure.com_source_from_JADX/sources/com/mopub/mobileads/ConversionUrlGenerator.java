package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;

class ConversionUrlGenerator extends BaseUrlGenerator {
    private String mAdUnit;
    private String mConsentedPrivacyPolicyVersion;
    private String mConsentedVendorListVersion;
    private Context mContext;
    private String mCurrentConsentStatus;
    private boolean mForceGdprApplies;
    private Boolean mGdprApplies;
    private boolean mSt;

    ConversionUrlGenerator(Context context, String str) {
        this.mContext = context;
        this.mAdUnit = str;
    }

    public ConversionUrlGenerator withCurrentConsentStatus(String str) {
        this.mCurrentConsentStatus = str;
        return this;
    }

    public ConversionUrlGenerator withGdprApplies(Boolean bool) {
        this.mGdprApplies = bool;
        return this;
    }

    public ConversionUrlGenerator withForceGdprApplies(boolean z) {
        this.mForceGdprApplies = z;
        return this;
    }

    public ConversionUrlGenerator withConsentedVendorListVersion(String str) {
        this.mConsentedVendorListVersion = str;
        return this;
    }

    public ConversionUrlGenerator withConsentedPrivacyPolicyVersion(String str) {
        this.mConsentedPrivacyPolicyVersion = str;
        return this;
    }

    public ConversionUrlGenerator withSessionTracker(boolean z) {
        this.mSt = z;
        return this;
    }

    public String generateUrlString(String str) {
        ClientMetadata instance = ClientMetadata.getInstance(this.mContext);
        initUrlString(str, Constants.CONVERSION_TRACKING_HANDLER);
        setApiVersion("6");
        setAppVersion(instance.getAppVersion());
        appendAdvertisingInfoTemplates();
        addParam("os", Constants.ANDROID_PLATFORM);
        addParam(GooglePlayServicesRewardedVideo.KEY_EXTRA_AD_UNIT_ID, this.mAdUnit);
        addParam("id", this.mContext.getPackageName());
        addParam("bundle", this.mContext.getPackageName());
        setDeviceInfo(instance.getDeviceManufacturer(), instance.getDeviceModel(), instance.getDeviceProduct());
        if (this.mSt) {
            addParam("st", Boolean.TRUE);
        }
        addParam("nv", MoPub.SDK_VERSION);
        appendAppEngineInfo();
        appendWrapperVersion();
        addParam("current_consent_status", this.mCurrentConsentStatus);
        addParam("consented_vendor_list_version", this.mConsentedVendorListVersion);
        addParam("consented_privacy_policy_version", this.mConsentedPrivacyPolicyVersion);
        addParam("gdpr_applies", this.mGdprApplies);
        addParam("force_gdpr_applies", Boolean.valueOf(this.mForceGdprApplies));
        return getFinalUrlString();
    }
}
