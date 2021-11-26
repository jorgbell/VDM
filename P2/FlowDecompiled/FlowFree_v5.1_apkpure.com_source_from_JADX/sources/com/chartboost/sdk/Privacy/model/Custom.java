package com.chartboost.sdk.Privacy.model;

import org.json.JSONObject;

public class Custom extends C1256a {
    public Custom(String str, String str2) {
        if (str == null || str2 == null) {
            mo10181a("Invalid Custom privacy standard name. Values cannot be null");
        } else if (m3121b(str)) {
            mo10181a("Invalid Custom privacy standard name. Cannot use GDPR as privacy standard");
        } else if (!isValidConsent(str) || !isValidConsent(str2)) {
            mo10181a("Invalid Custom consent values. Use valid values between 0 and 100 characters. privacyStandard: " + str + " consent: " + str2);
        } else {
            this.f2894a = str;
            this.f2895b = str2;
        }
    }

    /* renamed from: b */
    private boolean m3121b(String str) {
        return GDPR.GDPR_STANDARD.equals(str.trim().toLowerCase());
    }

    public /* bridge */ /* synthetic */ String getConsent() {
        return super.getConsent();
    }

    public /* bridge */ /* synthetic */ String getPrivacyStandard() {
        return super.getPrivacyStandard();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r3 = r3.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValidConsent(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x000e
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x000e
            r1 = 100
            if (r3 >= r1) goto L_0x000e
            r0 = 1
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Privacy.model.Custom.isValidConsent(java.lang.String):boolean");
    }

    public /* bridge */ /* synthetic */ JSONObject toJson() {
        return super.toJson();
    }
}
