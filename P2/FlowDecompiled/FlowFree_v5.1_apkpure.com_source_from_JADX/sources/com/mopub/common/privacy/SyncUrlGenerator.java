package com.mopub.common.privacy;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.network.PlayServicesUrlRewriter;

public class SyncUrlGenerator extends BaseUrlGenerator {
    private String mAdUnitId;
    private String mCachedVendorListIabHash;
    private String mConsentChangeReason;
    private String mConsentedIfa;
    private String mConsentedPrivacyPolicyVersion;
    private String mConsentedVendorListVersion;
    private final Context mContext;
    private final String mCurrentConsentStatus;
    private String mExtras;
    private boolean mForceGdprApplies;
    private Boolean mForceGdprAppliesChanged;
    private Boolean mGdprApplies;
    private String mLastChangedMs;
    private String mLastConsentStatus;

    public SyncUrlGenerator(Context context, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        this.mContext = context.getApplicationContext();
        this.mCurrentConsentStatus = str;
    }

    public SyncUrlGenerator withAdUnitId(String str) {
        this.mAdUnitId = str;
        return this;
    }

    public SyncUrlGenerator withConsentedIfa(String str) {
        this.mConsentedIfa = str;
        return this;
    }

    public SyncUrlGenerator withGdprApplies(Boolean bool) {
        this.mGdprApplies = bool;
        return this;
    }

    public SyncUrlGenerator withForceGdprApplies(boolean z) {
        this.mForceGdprApplies = z;
        return this;
    }

    public SyncUrlGenerator withForceGdprAppliesChanged(Boolean bool) {
        this.mForceGdprAppliesChanged = bool;
        return this;
    }

    public SyncUrlGenerator withLastChangedMs(String str) {
        this.mLastChangedMs = str;
        return this;
    }

    public SyncUrlGenerator withLastConsentStatus(ConsentStatus consentStatus) {
        this.mLastConsentStatus = consentStatus == null ? null : consentStatus.getValue();
        return this;
    }

    public SyncUrlGenerator withConsentChangeReason(String str) {
        this.mConsentChangeReason = str;
        return this;
    }

    public SyncUrlGenerator withConsentedVendorListVersion(String str) {
        this.mConsentedVendorListVersion = str;
        return this;
    }

    public SyncUrlGenerator withConsentedPrivacyPolicyVersion(String str) {
        this.mConsentedPrivacyPolicyVersion = str;
        return this;
    }

    public SyncUrlGenerator withCachedVendorListIabHash(String str) {
        this.mCachedVendorListIabHash = str;
        return this;
    }

    public SyncUrlGenerator withExtras(String str) {
        this.mExtras = str;
        return this;
    }

    public String generateUrlString(String str) {
        initUrlString(str, Constants.GDPR_SYNC_HANDLER);
        addParam("id", this.mAdUnitId);
        addParam("nv", MoPub.SDK_VERSION);
        appendAppEngineInfo();
        appendWrapperVersion();
        addParam("last_changed_ms", this.mLastChangedMs);
        addParam("last_consent_status", this.mLastConsentStatus);
        addParam("current_consent_status", this.mCurrentConsentStatus);
        addParam("consent_change_reason", this.mConsentChangeReason);
        addParam("consented_vendor_list_version", this.mConsentedVendorListVersion);
        addParam("consented_privacy_policy_version", this.mConsentedPrivacyPolicyVersion);
        addParam("cached_vendor_list_iab_hash", this.mCachedVendorListIabHash);
        addParam("extras", this.mExtras);
        addParam("consent_ifa", this.mConsentedIfa);
        addParam("gdpr_applies", this.mGdprApplies);
        addParam("force_gdpr_applies", Boolean.valueOf(this.mForceGdprApplies));
        addParam("forced_gdpr_applies_changed", this.mForceGdprAppliesChanged);
        addParam("bundle", ClientMetadata.getInstance(this.mContext).getAppPackageName());
        addParam("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
        addParam("mid", PlayServicesUrlRewriter.MOPUB_ID_TEMPLATE);
        return getFinalUrlString();
    }
}
