package com.mopub.common.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import java.util.Locale;

class PersonalInfoData implements ConsentData {
    private String mAdUnitId = "";
    private final Context mAppContext;
    private String mCachedLastAdUnitIdUsedForInit;
    private String mConsentChangeReason;
    private ConsentStatus mConsentStatus = ConsentStatus.UNKNOWN;
    private ConsentStatus mConsentStatusBeforeDnt;
    private String mConsentedPrivacyPolicyVersion;
    private String mConsentedVendorListIabFormat;
    private String mConsentedVendorListVersion;
    private String mCurrentPrivacyPolicyLink;
    private String mCurrentPrivacyPolicyVersion;
    private String mCurrentVendorListIabFormat;
    private String mCurrentVendorListIabHash;
    private String mCurrentVendorListLink;
    private String mCurrentVendorListVersion;
    private String mExtras;
    private boolean mForceGdprApplies;
    private Boolean mGdprApplies;
    private String mIfa;
    private boolean mIsWhitelisted;
    private String mLastChangedMs;
    private ConsentStatus mLastSuccessfullySyncedConsentStatus;
    private boolean mReacquireConsent;

    PersonalInfoData(Context context) {
        Preconditions.checkNotNull(context);
        this.mAppContext = context.getApplicationContext();
        getStateFromDisk();
    }

    private void getStateFromDisk() {
        SharedPreferences sharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.mAppContext, "com.mopub.privacy");
        this.mAdUnitId = sharedPreferences.getString("info/adunit", "");
        this.mCachedLastAdUnitIdUsedForInit = sharedPreferences.getString("info/cached_last_ad_unit_id_used_for_init", (String) null);
        this.mConsentStatus = ConsentStatus.fromString(sharedPreferences.getString("info/consent_status", ConsentStatus.UNKNOWN.name()));
        String string = sharedPreferences.getString("info/last_successfully_synced_consent_status", (String) null);
        if (TextUtils.isEmpty(string)) {
            this.mLastSuccessfullySyncedConsentStatus = null;
        } else {
            this.mLastSuccessfullySyncedConsentStatus = ConsentStatus.fromString(string);
        }
        this.mIsWhitelisted = sharedPreferences.getBoolean("info/is_whitelisted", false);
        this.mCurrentVendorListVersion = sharedPreferences.getString("info/current_vendor_list_version", (String) null);
        this.mCurrentVendorListLink = sharedPreferences.getString("info/current_vendor_list_link", (String) null);
        this.mCurrentPrivacyPolicyVersion = sharedPreferences.getString("info/current_privacy_policy_version", (String) null);
        this.mCurrentPrivacyPolicyLink = sharedPreferences.getString("info/current_privacy_policy_link", (String) null);
        this.mCurrentVendorListIabFormat = sharedPreferences.getString("info/current_vendor_list_iab_format", (String) null);
        this.mCurrentVendorListIabHash = sharedPreferences.getString("info/current_vendor_list_iab_hash", (String) null);
        this.mConsentedVendorListVersion = sharedPreferences.getString("info/consented_vendor_list_version", (String) null);
        this.mConsentedPrivacyPolicyVersion = sharedPreferences.getString("info/consented_privacy_policy_version", (String) null);
        this.mConsentedVendorListIabFormat = sharedPreferences.getString("info/consented_vendor_list_iab_format", (String) null);
        this.mExtras = sharedPreferences.getString("info/extras", (String) null);
        this.mConsentChangeReason = sharedPreferences.getString("info/consent_change_reason", (String) null);
        this.mReacquireConsent = sharedPreferences.getBoolean("info/reacquire_consent", false);
        String string2 = sharedPreferences.getString("info/gdpr_applies", (String) null);
        if (TextUtils.isEmpty(string2)) {
            this.mGdprApplies = null;
        } else {
            this.mGdprApplies = Boolean.valueOf(Boolean.parseBoolean(string2));
        }
        this.mForceGdprApplies = sharedPreferences.getBoolean("info/force_gdpr_applies", false);
        String string3 = sharedPreferences.getString("info/udid", (String) null);
        if (!TextUtils.isEmpty(string3)) {
            this.mIfa = string3.replace("ifa:", "");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("info/ifa", this.mIfa);
            edit.remove("info/udid");
            edit.apply();
        } else {
            this.mIfa = sharedPreferences.getString("info/ifa", (String) null);
        }
        this.mLastChangedMs = sharedPreferences.getString("info/last_changed_ms", (String) null);
        String string4 = sharedPreferences.getString("info/consent_status_before_dnt", (String) null);
        if (TextUtils.isEmpty(string4)) {
            this.mConsentStatusBeforeDnt = null;
        } else {
            this.mConsentStatusBeforeDnt = ConsentStatus.fromString(string4);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeToDisk() {
        String str;
        String str2;
        SharedPreferences.Editor edit = SharedPreferencesHelper.getSharedPreferences(this.mAppContext, "com.mopub.privacy").edit();
        edit.putString("info/adunit", this.mAdUnitId);
        edit.putString("info/cached_last_ad_unit_id_used_for_init", this.mCachedLastAdUnitIdUsedForInit);
        edit.putString("info/consent_status", this.mConsentStatus.name());
        ConsentStatus consentStatus = this.mLastSuccessfullySyncedConsentStatus;
        String str3 = null;
        if (consentStatus == null) {
            str = null;
        } else {
            str = consentStatus.name();
        }
        edit.putString("info/last_successfully_synced_consent_status", str);
        edit.putBoolean("info/is_whitelisted", this.mIsWhitelisted);
        edit.putString("info/current_vendor_list_version", this.mCurrentVendorListVersion);
        edit.putString("info/current_vendor_list_link", this.mCurrentVendorListLink);
        edit.putString("info/current_privacy_policy_version", this.mCurrentPrivacyPolicyVersion);
        edit.putString("info/current_privacy_policy_link", this.mCurrentPrivacyPolicyLink);
        edit.putString("info/current_vendor_list_iab_format", this.mCurrentVendorListIabFormat);
        edit.putString("info/current_vendor_list_iab_hash", this.mCurrentVendorListIabHash);
        edit.putString("info/consented_vendor_list_version", this.mConsentedVendorListVersion);
        edit.putString("info/consented_privacy_policy_version", this.mConsentedPrivacyPolicyVersion);
        edit.putString("info/consented_vendor_list_iab_format", this.mConsentedVendorListIabFormat);
        edit.putString("info/extras", this.mExtras);
        edit.putString("info/consent_change_reason", this.mConsentChangeReason);
        edit.putBoolean("info/reacquire_consent", this.mReacquireConsent);
        Boolean bool = this.mGdprApplies;
        if (bool == null) {
            str2 = null;
        } else {
            str2 = bool.toString();
        }
        edit.putString("info/gdpr_applies", str2);
        edit.putBoolean("info/force_gdpr_applies", this.mForceGdprApplies);
        edit.putString("info/ifa", this.mIfa);
        edit.putString("info/last_changed_ms", this.mLastChangedMs);
        ConsentStatus consentStatus2 = this.mConsentStatusBeforeDnt;
        if (consentStatus2 != null) {
            str3 = consentStatus2.name();
        }
        edit.putString("info/consent_status_before_dnt", str3);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public String getAdUnitId() {
        return this.mAdUnitId;
    }

    /* access modifiers changed from: package-private */
    public void setAdUnit(String str) {
        this.mAdUnitId = str;
    }

    /* access modifiers changed from: package-private */
    public String getCachedLastAdUnitIdUsedForInit() {
        return this.mCachedLastAdUnitIdUsedForInit;
    }

    /* access modifiers changed from: package-private */
    public void setCachedLastAdUnitIdUsedForInit(String str) {
        this.mCachedLastAdUnitIdUsedForInit = str;
    }

    public String chooseAdUnit() {
        String str = this.mAdUnitId;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return this.mCachedLastAdUnitIdUsedForInit;
    }

    /* access modifiers changed from: package-private */
    public ConsentStatus getConsentStatus() {
        return this.mConsentStatus;
    }

    /* access modifiers changed from: package-private */
    public void setConsentStatus(ConsentStatus consentStatus) {
        this.mConsentStatus = consentStatus;
    }

    /* access modifiers changed from: package-private */
    public ConsentStatus getLastSuccessfullySyncedConsentStatus() {
        return this.mLastSuccessfullySyncedConsentStatus;
    }

    /* access modifiers changed from: package-private */
    public void setLastSuccessfullySyncedConsentStatus(ConsentStatus consentStatus) {
        this.mLastSuccessfullySyncedConsentStatus = consentStatus;
    }

    /* access modifiers changed from: package-private */
    public boolean isWhitelisted() {
        return this.mIsWhitelisted;
    }

    /* access modifiers changed from: package-private */
    public void setWhitelisted(boolean z) {
        this.mIsWhitelisted = z;
    }

    public String getCurrentVendorListVersion() {
        return this.mCurrentVendorListVersion;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentVendorListVersion(String str) {
        this.mCurrentVendorListVersion = str;
    }

    public String getCurrentVendorListLink() {
        return getCurrentVendorListLink((String) null);
    }

    public String getCurrentVendorListLink(String str) {
        return replaceLanguageMacro(this.mCurrentVendorListLink, this.mAppContext, str);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentVendorListLink(String str) {
        this.mCurrentVendorListLink = str;
    }

    public String getCurrentPrivacyPolicyVersion() {
        return this.mCurrentPrivacyPolicyVersion;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentPrivacyPolicyVersion(String str) {
        this.mCurrentPrivacyPolicyVersion = str;
    }

    public String getCurrentPrivacyPolicyLink() {
        return getCurrentPrivacyPolicyLink((String) null);
    }

    public String getCurrentPrivacyPolicyLink(String str) {
        return replaceLanguageMacro(this.mCurrentPrivacyPolicyLink, this.mAppContext, str);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentPrivacyPolicyLink(String str) {
        this.mCurrentPrivacyPolicyLink = str;
    }

    public String getCurrentVendorListIabFormat() {
        return this.mCurrentVendorListIabFormat;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentVendorListIabFormat(String str) {
        this.mCurrentVendorListIabFormat = str;
    }

    /* access modifiers changed from: package-private */
    public String getCurrentVendorListIabHash() {
        return this.mCurrentVendorListIabHash;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentVendorListIabHash(String str) {
        this.mCurrentVendorListIabHash = str;
    }

    public String getConsentedVendorListVersion() {
        return this.mConsentedVendorListVersion;
    }

    /* access modifiers changed from: package-private */
    public void setConsentedVendorListVersion(String str) {
        this.mConsentedVendorListVersion = str;
    }

    public String getConsentedPrivacyPolicyVersion() {
        return this.mConsentedPrivacyPolicyVersion;
    }

    /* access modifiers changed from: package-private */
    public void setConsentedPrivacyPolicyVersion(String str) {
        this.mConsentedPrivacyPolicyVersion = str;
    }

    public String getConsentedVendorListIabFormat() {
        return this.mConsentedVendorListIabFormat;
    }

    /* access modifiers changed from: package-private */
    public void setConsentedVendorListIabFormat(String str) {
        this.mConsentedVendorListIabFormat = str;
    }

    public String getExtras() {
        return this.mExtras;
    }

    public void setExtras(String str) {
        this.mExtras = str;
    }

    /* access modifiers changed from: package-private */
    public String getConsentChangeReason() {
        return this.mConsentChangeReason;
    }

    /* access modifiers changed from: package-private */
    public void setConsentChangeReason(String str) {
        this.mConsentChangeReason = str;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldReacquireConsent() {
        return this.mReacquireConsent;
    }

    /* access modifiers changed from: package-private */
    public void setShouldReacquireConsent(boolean z) {
        this.mReacquireConsent = z;
    }

    /* access modifiers changed from: package-private */
    public Boolean getGdprApplies() {
        return this.mGdprApplies;
    }

    /* access modifiers changed from: package-private */
    public void setGdprApplies(Boolean bool) {
        this.mGdprApplies = bool;
    }

    public boolean isForceGdprApplies() {
        return this.mForceGdprApplies;
    }

    /* access modifiers changed from: package-private */
    public void setForceGdprApplies(boolean z) {
        this.mForceGdprApplies = z;
    }

    /* access modifiers changed from: package-private */
    public String getIfa() {
        return this.mIfa;
    }

    /* access modifiers changed from: package-private */
    public void setIfa(String str) {
        this.mIfa = str;
    }

    /* access modifiers changed from: package-private */
    public String getLastChangedMs() {
        return this.mLastChangedMs;
    }

    /* access modifiers changed from: package-private */
    public void setLastChangedMs(String str) {
        this.mLastChangedMs = str;
    }

    /* access modifiers changed from: package-private */
    public ConsentStatus getConsentStatusBeforeDnt() {
        return this.mConsentStatusBeforeDnt;
    }

    /* access modifiers changed from: package-private */
    public void setConsentStatusBeforeDnt(ConsentStatus consentStatus) {
        this.mConsentStatusBeforeDnt = consentStatus;
    }

    @VisibleForTesting
    static String replaceLanguageMacro(String str, Context context, String str2) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("%%LANGUAGE%%", validateLanguage(context, str2));
    }

    private static String validateLanguage(Context context, String str) {
        Preconditions.checkNotNull(context);
        for (String str2 : Locale.getISOLanguages()) {
            if (str2 != null && str2.equals(str)) {
                return str;
            }
        }
        return ClientMetadata.getCurrentLanguage(context);
    }
}
