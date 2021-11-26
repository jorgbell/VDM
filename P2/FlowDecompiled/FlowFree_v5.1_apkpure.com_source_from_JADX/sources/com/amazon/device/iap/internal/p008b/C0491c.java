package com.amazon.device.iap.internal.p008b;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.internal.C0517c;
import com.amazon.device.iap.internal.p008b.p009a.C0484d;
import com.amazon.device.iap.internal.p008b.p010b.C0490d;
import com.amazon.device.iap.internal.p008b.p011c.C0495d;
import com.amazon.device.iap.internal.p008b.p012d.C0497a;
import com.amazon.device.iap.internal.p008b.p013e.C0503a;
import com.amazon.device.iap.internal.p008b.p015g.C0513b;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* renamed from: com.amazon.device.iap.internal.b.c */
/* compiled from: KiwiRequestHandler */
public final class C0491c implements C0517c {

    /* renamed from: a */
    private static final String f42a = "c";

    /* renamed from: a */
    public void mo7433a(RequestId requestId) {
        C0532e.m187a(f42a, "sendGetUserData");
        new C0503a(requestId).mo7458e();
    }

    /* renamed from: a */
    public void mo7434a(RequestId requestId, String str) {
        C0532e.m187a(f42a, "sendPurchaseRequest");
        new C0490d(requestId, str).mo7458e();
    }

    /* renamed from: a */
    public void mo7436a(RequestId requestId, Set<String> set) {
        C0532e.m187a(f42a, "sendGetProductDataRequest");
        new C0495d(requestId, set).mo7458e();
    }

    /* renamed from: a */
    public void mo7437a(RequestId requestId, boolean z) {
        C0532e.m187a(f42a, "sendGetPurchaseUpdates");
        new C0497a(requestId, z).mo7458e();
    }

    /* renamed from: a */
    public void mo7435a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        C0532e.m187a(f42a, "sendNotifyFulfillment");
        new C0513b(requestId, str, fulfillmentResult).mo7458e();
    }

    /* renamed from: a */
    public void mo7432a(Context context, Intent intent) {
        String str = f42a;
        C0532e.m187a(str, "handleResponse");
        String stringExtra = intent.getStringExtra("response_type");
        if (stringExtra == null) {
            C0532e.m187a(str, "Invalid response type: null");
            return;
        }
        C0532e.m187a(str, "Found response type: " + stringExtra);
        if ("purchase_response".equals(stringExtra)) {
            new C0484d(RequestId.fromString(intent.getStringExtra("requestId"))).mo7458e();
        }
    }
}
