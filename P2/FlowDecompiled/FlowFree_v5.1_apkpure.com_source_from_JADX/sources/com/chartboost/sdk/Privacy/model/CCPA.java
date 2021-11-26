package com.chartboost.sdk.Privacy.model;

import org.json.JSONObject;

public class CCPA extends C1256a {
    public static final String CCPA_STANDARD = "us_privacy";

    public enum CCPA_CONSENT {
        OPT_OUT_SALE("1NY-"),
        OPT_IN_SALE("1NN-");
        
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f2892a;

        private CCPA_CONSENT(String str) {
            this.f2892a = str;
        }

        public static CCPA_CONSENT fromValue(String str) {
            CCPA_CONSENT ccpa_consent = OPT_OUT_SALE;
            if (ccpa_consent.getValue().equals(str)) {
                return ccpa_consent;
            }
            CCPA_CONSENT ccpa_consent2 = OPT_IN_SALE;
            if (ccpa_consent2.getValue().equals(str)) {
                return ccpa_consent2;
            }
            return null;
        }

        public String getValue() {
            return this.f2892a;
        }
    }

    public CCPA(CCPA_CONSENT ccpa_consent) {
        if (ccpa_consent == null || !isValidConsent(ccpa_consent.getValue())) {
            mo10181a("Invalid CCPA consent values. Use provided values or Custom class. Value: " + ccpa_consent);
            return;
        }
        this.f2894a = CCPA_STANDARD;
        this.f2895b = ccpa_consent.getValue();
    }

    public /* bridge */ /* synthetic */ String getConsent() {
        return super.getConsent();
    }

    public /* bridge */ /* synthetic */ String getPrivacyStandard() {
        return super.getPrivacyStandard();
    }

    public boolean isValidConsent(String str) {
        return CCPA_CONSENT.OPT_OUT_SALE.f2892a.equals(str) || CCPA_CONSENT.OPT_IN_SALE.f2892a.equals(str);
    }

    public /* bridge */ /* synthetic */ JSONObject toJson() {
        return super.toJson();
    }
}
