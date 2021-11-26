package com.flurry.sdk;

/* renamed from: com.flurry.sdk.co */
public final class C1633co {
    /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|(2:10|8)|38|11|(1:13)(1:14)|15|(3:17|(1:19)|(1:21))|22|(1:24)|25|(4:29|(2:32|30)|39|33)|36|37) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040 A[Catch:{ JSONException -> 0x016c }, LOOP:0: B:8:0x003a->B:10:0x0040, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a A[Catch:{ JSONException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d A[Catch:{ JSONException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084 A[Catch:{ JSONException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x012b A[Catch:{ JSONException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x014b A[Catch:{ JSONException -> 0x016c }, LOOP:1: B:30:0x0145->B:32:0x014b, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4278a(java.lang.String r8) {
        /*
            java.lang.String r0 = "id"
            java.lang.String r1 = "ParameterProvider"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "timestamp"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x016c }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r3 = "guid"
            r2.put(r3, r8)     // Catch:{ JSONException -> 0x016c }
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ JSONException -> 0x016c }
            r8.<init>()     // Catch:{ JSONException -> 0x016c }
            java.lang.String r3 = "APP"
            r8.put(r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r3 = "com.flurry.android.config.killswitch.KillSwitch"
            java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x002e }
            java.lang.String r3 = "KILLSWITCH"
            r8.put(r3)     // Catch:{ ClassNotFoundException -> 0x002e }
        L_0x002e:
            java.util.Map r3 = com.flurry.sdk.C1623cg.m4238a()     // Catch:{ JSONException -> 0x016c }
            java.util.Set r3 = r3.keySet()     // Catch:{ JSONException -> 0x016c }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ JSONException -> 0x016c }
        L_0x003a:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x016c }
            if (r4 == 0) goto L_0x004a
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x016c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x016c }
            r8.put(r4)     // Catch:{ JSONException -> 0x016c }
            goto L_0x003a
        L_0x004a:
            java.lang.String r3 = "documents"
            r2.put(r3, r8)     // Catch:{ JSONException -> 0x016c }
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ JSONException -> 0x016c }
            r8.<init>()     // Catch:{ JSONException -> 0x016c }
            boolean r3 = com.flurry.sdk.C1636cr.m4290a()     // Catch:{ JSONException -> 0x016c }
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = "com.flurry.configkey.prod.ec.2"
            goto L_0x005f
        L_0x005d:
            java.lang.String r3 = "com.flurry.configkey.prod.rot.7"
        L_0x005f:
            r8.put(r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r3 = "com.flurry.configkey.prod.fs.0"
            r8.put(r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r3 = "signatureKeys"
            r2.put(r3, r8)     // Catch:{ JSONException -> 0x016c }
            com.flurry.sdk.bl r8 = com.flurry.sdk.C1564bl.m4094a()     // Catch:{ JSONException -> 0x016c }
            android.content.Context r3 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ JSONException -> 0x016c }
            com.flurry.sdk.bz r4 = com.flurry.sdk.C1607bz.m4189a()     // Catch:{ JSONException -> 0x016c }
            com.flurry.sdk.ca r5 = r4.f4050a     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = r5.mo11379d()     // Catch:{ JSONException -> 0x016c }
            boolean r6 = com.flurry.sdk.C1636cr.m4292a((java.lang.String) r6)     // Catch:{ JSONException -> 0x016c }
            if (r6 == 0) goto L_0x0096
            android.content.SharedPreferences r5 = r5.f4079a     // Catch:{ JSONException -> 0x016c }
            r6 = 0
            if (r5 == 0) goto L_0x008f
            java.lang.String r7 = "lastETag"
            java.lang.String r6 = r5.getString(r7, r6)     // Catch:{ JSONException -> 0x016c }
        L_0x008f:
            if (r6 == 0) goto L_0x0096
            java.lang.String r5 = "etag"
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x016c }
        L_0x0096:
            java.lang.String r5 = "apiKey"
            com.flurry.sdk.n r6 = com.flurry.sdk.C1913n.m4811a()     // Catch:{ JSONException -> 0x016c }
            com.flurry.sdk.ac r6 = r6.f4729h     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = r6.f3706a     // Catch:{ JSONException -> 0x016c }
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r5 = "appVersion"
            java.lang.String r8 = r8.mo11320b()     // Catch:{ JSONException -> 0x016c }
            r2.put(r5, r8)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r8 = "appBuild"
            int r5 = com.flurry.sdk.C1564bl.m4096b(r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ JSONException -> 0x016c }
            r2.put(r8, r5)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r8 = "sdkVersion"
            int r5 = com.flurry.android.FlurryAgent.getAgentVersion()     // Catch:{ JSONException -> 0x016c }
            r2.put(r8, r5)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r8 = "platform"
            r5 = 3
            r2.put(r8, r5)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r8 = "platformVersion"
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x016c }
            r2.put(r8, r5)     // Catch:{ JSONException -> 0x016c }
            org.json.JSONArray r8 = com.flurry.sdk.C1620cd.m4230a()     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = "deviceIds"
            r2.put(r6, r8)     // Catch:{ JSONException -> 0x016c }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x016c }
            r8.<init>()     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = "brand"
            java.lang.String r7 = android.os.Build.BRAND     // Catch:{ JSONException -> 0x016c }
            r8.put(r6, r7)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = "device"
            java.lang.String r7 = android.os.Build.DEVICE     // Catch:{ JSONException -> 0x016c }
            r8.put(r6, r7)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = android.os.Build.ID     // Catch:{ JSONException -> 0x016c }
            r8.put(r0, r6)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = "model"
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x016c }
            r8.put(r6, r7)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = "product"
            java.lang.String r7 = android.os.Build.PRODUCT     // Catch:{ JSONException -> 0x016c }
            r8.put(r6, r7)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = "version_release"
            r8.put(r6, r5)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r5 = "deviceTags"
            r2.put(r5, r8)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r8 = "bundleId"
            java.lang.String r3 = com.flurry.sdk.C1695dx.m4430a(r3)     // Catch:{ JSONException -> 0x016c }
            r2.put(r8, r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r8 = "locale"
            com.flurry.sdk.C1913n.m4811a()     // Catch:{ JSONException -> 0x016c }
            java.lang.String r3 = com.flurry.sdk.C1512ar.m4010a()     // Catch:{ JSONException -> 0x016c }
            r2.put(r8, r3)     // Catch:{ JSONException -> 0x016c }
            com.flurry.sdk.n r8 = com.flurry.sdk.C1913n.m4811a()     // Catch:{ JSONException -> 0x016c }
            com.flurry.sdk.ac r8 = r8.f4729h     // Catch:{ JSONException -> 0x016c }
            java.lang.String r8 = r8.f3707b     // Catch:{ JSONException -> 0x016c }
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x016c }
            if (r3 != 0) goto L_0x0130
            java.lang.String r3 = "publisherUserId"
            r2.put(r3, r8)     // Catch:{ JSONException -> 0x016c }
        L_0x0130:
            java.util.List r8 = r4.mo11371e()     // Catch:{ JSONException -> 0x016c }
            if (r8 == 0) goto L_0x0172
            int r3 = r8.size()     // Catch:{ JSONException -> 0x016c }
            if (r3 <= 0) goto L_0x0172
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x016c }
            r3.<init>()     // Catch:{ JSONException -> 0x016c }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ JSONException -> 0x016c }
        L_0x0145:
            boolean r4 = r8.hasNext()     // Catch:{ JSONException -> 0x016c }
            if (r4 == 0) goto L_0x0166
            java.lang.Object r4 = r8.next()     // Catch:{ JSONException -> 0x016c }
            com.flurry.sdk.cj r4 = (com.flurry.sdk.C1628cj) r4     // Catch:{ JSONException -> 0x016c }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x016c }
            r5.<init>()     // Catch:{ JSONException -> 0x016c }
            int r6 = r4.f4117b     // Catch:{ JSONException -> 0x016c }
            r5.put(r0, r6)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r6 = "version"
            int r4 = r4.f4118c     // Catch:{ JSONException -> 0x016c }
            r5.put(r6, r4)     // Catch:{ JSONException -> 0x016c }
            r3.put(r5)     // Catch:{ JSONException -> 0x016c }
            goto L_0x0145
        L_0x0166:
            java.lang.String r8 = "currentVariants"
            r2.put(r8, r3)     // Catch:{ JSONException -> 0x016c }
            goto L_0x0172
        L_0x016c:
            r8 = move-exception
            java.lang.String r0 = "ParameterProvider error"
            com.flurry.sdk.C1648cy.m4320a((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x0172:
            java.lang.String r8 = r2.toString()
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r2 = "Request Parameters: "
            java.lang.String r0 = r2.concat(r0)
            com.flurry.sdk.C1648cy.m4319a(r1, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1633co.m4278a(java.lang.String):java.lang.String");
    }
}
