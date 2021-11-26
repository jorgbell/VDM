package com.google.android.gms.common.api;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ApiException extends Exception {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ApiException(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Status r4) {
        /*
            r3 = this;
            int r0 = r4.getStatusCode()
            java.lang.String r1 = r4.getStatusMessage()
            if (r1 == 0) goto L_0x000f
            java.lang.String r4 = r4.getStatusMessage()
            goto L_0x0011
        L_0x000f:
            java.lang.String r4 = ""
        L_0x0011:
            java.lang.String r1 = java.lang.String.valueOf(r4)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 13
            r2.<init>(r1)
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }
}
