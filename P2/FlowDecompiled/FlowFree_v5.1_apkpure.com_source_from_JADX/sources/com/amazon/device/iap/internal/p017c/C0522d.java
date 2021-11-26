package com.amazon.device.iap.internal.p017c;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amazon.device.iap.internal.c.d */
/* compiled from: PendingReceipt */
class C0522d {

    /* renamed from: a */
    private final String f95a;

    /* renamed from: b */
    private final String f96b;

    /* renamed from: c */
    private final long f97c;

    /* renamed from: d */
    private final String f98d;

    /* renamed from: a */
    public String mo7489a() {
        return this.f98d;
    }

    /* renamed from: b */
    public String mo7490b() {
        return this.f96b;
    }

    /* renamed from: c */
    public long mo7491c() {
        return this.f97c;
    }

    public C0522d(String str, String str2, String str3, long j) {
        this.f95a = str;
        this.f96b = str2;
        this.f98d = str3;
        this.f97c = j;
    }

    /* renamed from: a */
    public static C0522d m151a(String str) throws C0523e {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new C0522d(jSONObject.getString("KEY_USER_ID"), jSONObject.getString("KEY_RECEIPT_STRING"), jSONObject.getString("KEY_REQUEST_ID"), jSONObject.getLong("KEY_TIMESTAMP"));
        } catch (Throwable th) {
            throw new C0523e("Input invalid for PendingReceipt Object:" + str, th);
        }
    }

    /* renamed from: d */
    public String mo7492d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("KEY_USER_ID", this.f95a);
        jSONObject.put("KEY_RECEIPT_STRING", this.f96b);
        jSONObject.put("KEY_REQUEST_ID", this.f98d);
        jSONObject.put("KEY_TIMESTAMP", this.f97c);
        return jSONObject.toString();
    }
}
