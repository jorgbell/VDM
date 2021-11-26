package com.chartboost.sdk.Privacy.model;

import org.json.JSONObject;

public class GDPR extends C1256a {
    public static final String GDPR_STANDARD = "gdpr";

    public enum GDPR_CONSENT {
        NON_BEHAVIORAL("0"),
        BEHAVIORAL("1");
        
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f2893a;

        private GDPR_CONSENT(String str) {
            this.f2893a = str;
        }

        public static GDPR_CONSENT fromValue(String str) {
            GDPR_CONSENT gdpr_consent = NON_BEHAVIORAL;
            if (gdpr_consent.getValue().equals(str)) {
                return gdpr_consent;
            }
            GDPR_CONSENT gdpr_consent2 = BEHAVIORAL;
            if (gdpr_consent2.getValue().equals(str)) {
                return gdpr_consent2;
            }
            return null;
        }

        public String getValue() {
            return this.f2893a;
        }
    }

    public GDPR(GDPR_CONSENT gdpr_consent) {
        if (gdpr_consent == null || !isValidConsent(gdpr_consent.getValue())) {
            mo10181a("Invalid GDPR consent values. Use provided values or Custom class. Value: " + gdpr_consent);
            return;
        }
        this.f2894a = GDPR_STANDARD;
        this.f2895b = gdpr_consent.getValue();
    }

    public /* bridge */ /* synthetic */ String getConsent() {
        return super.getConsent();
    }

    public /* bridge */ /* synthetic */ String getPrivacyStandard() {
        return super.getPrivacyStandard();
    }

    public boolean isValidConsent(String str) {
        return GDPR_CONSENT.NON_BEHAVIORAL.f2893a.equals(str) || GDPR_CONSENT.BEHAVIORAL.f2893a.equals(str);
    }

    public /* bridge */ /* synthetic */ JSONObject toJson() {
        return super.toJson();
    }
}
