package com.chartboost.sdk.impl;

import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Privacy.model.GDPR;

/* renamed from: com.chartboost.sdk.impl.v0 */
public class C1380v0 {

    /* renamed from: a */
    public static Chartboost.CBPIDataUseConsent f3390a = Chartboost.CBPIDataUseConsent.UNKNOWN;

    /* renamed from: a */
    public static int m3737a() {
        return Math.max(0, f3390a.getValue());
    }

    /* renamed from: b */
    public static int m3741b() {
        return f3390a == Chartboost.CBPIDataUseConsent.UNKNOWN ? 0 : 1;
    }

    /* renamed from: a */
    public static void m3739a(DataUseConsent dataUseConsent) {
        if (GDPR.GDPR_STANDARD.equals(dataUseConsent.getPrivacyStandard())) {
            try {
                m3738a(Integer.parseInt(dataUseConsent.getConsent()));
            } catch (NumberFormatException unused) {
                CBLogging.m2905b("PrivacyManager", "Cannot parse consent while setting GDPR");
            }
        }
    }

    /* renamed from: a */
    public static void m3740a(String str) {
        if (GDPR.GDPR_STANDARD.equals(str)) {
            m3738a(Chartboost.CBPIDataUseConsent.UNKNOWN.getValue());
        }
    }

    /* renamed from: a */
    public static void m3738a(int i) {
        Chartboost.CBPIDataUseConsent valueOf = Chartboost.CBPIDataUseConsent.valueOf(i);
        f3390a = valueOf;
        if (valueOf == Chartboost.CBPIDataUseConsent.UNKNOWN) {
            CBLogging.m2909e("PrivacyManager", "setPersonalInformationDataUseConsent set consent to UNKNOWN");
        }
    }
}
