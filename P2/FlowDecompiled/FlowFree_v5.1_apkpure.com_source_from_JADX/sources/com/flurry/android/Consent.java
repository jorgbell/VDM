package com.flurry.android;

import java.util.Map;

public abstract class Consent {
    protected Map<String, String> consentStrings;
    protected boolean isGdprScope;

    public boolean isGdprScope() {
        return this.isGdprScope;
    }

    public Map<String, String> getConsentStrings() {
        return this.consentStrings;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r2 = r4.consentStrings;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 == 0) goto L_0x0032
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x0012
            goto L_0x0032
        L_0x0012:
            com.flurry.android.Consent r5 = (com.flurry.android.Consent) r5
            boolean r2 = r4.isGdprScope
            boolean r3 = r5.isGdprScope()
            if (r2 != r3) goto L_0x0032
            java.util.Map<java.lang.String, java.lang.String> r2 = r4.consentStrings
            if (r2 == 0) goto L_0x002b
            java.util.Map r5 = r5.getConsentStrings()
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L_0x0032
            goto L_0x0031
        L_0x002b:
            java.util.Map r5 = r5.getConsentStrings()
            if (r5 != 0) goto L_0x0032
        L_0x0031:
            return r0
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.android.Consent.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.isGdprScope ? 1 : 0) * true;
        Map<String, String> map = this.consentStrings;
        return i + (map != null ? map.hashCode() : 0);
    }
}
