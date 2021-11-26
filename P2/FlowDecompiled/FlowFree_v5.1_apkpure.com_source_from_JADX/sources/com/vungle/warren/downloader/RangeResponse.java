package com.vungle.warren.downloader;

class RangeResponse {
    public final String dimension;
    public final long rangeStart;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0060 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RangeResponse(java.lang.String r9) {
        /*
            r8 = this;
            r8.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = -1
            r3 = 0
            if (r0 != 0) goto L_0x0074
            java.lang.String r9 = r9.trim()
            java.lang.String r0 = "\\s+"
            java.lang.String[] r9 = r9.split(r0)
            int r0 = r9.length
            r4 = 2
            if (r0 < r4) goto L_0x0074
            int r0 = r9.length
            r5 = 0
            if (r0 <= 0) goto L_0x0020
            r3 = r9[r5]
        L_0x0020:
            int r0 = r9.length
            r6 = 1
            if (r0 <= r6) goto L_0x0074
            r0 = r9[r6]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0074
            r9 = r9[r6]
            java.lang.String r0 = "/"
            java.lang.String[] r9 = r9.split(r0)
            int r0 = r9.length
            if (r0 != r4) goto L_0x0074
            r0 = r9[r5]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0067
            r0 = r9[r5]
            java.lang.String r7 = "-"
            java.lang.String[] r0 = r0.split(r7)
            int r7 = r0.length
            if (r7 != r4) goto L_0x0067
            r4 = r0[r5]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0067
            r4 = r0[r6]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0067
            r4 = r0[r5]     // Catch:{ all -> 0x0060 }
            long r1 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r0 = r0[r6]     // Catch:{ all -> 0x0066 }
            java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x0066 }
            goto L_0x0067
        L_0x0066:
        L_0x0067:
            r0 = r9[r6]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0074
            r9 = r9[r6]     // Catch:{ all -> 0x0074 }
            java.lang.Long.parseLong(r9)     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r8.rangeStart = r1
            r8.dimension = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.RangeResponse.<init>(java.lang.String):void");
    }
}
