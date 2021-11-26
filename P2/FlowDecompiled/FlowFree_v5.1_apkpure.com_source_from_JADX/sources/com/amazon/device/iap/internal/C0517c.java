package com.amazon.device.iap.internal;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* renamed from: com.amazon.device.iap.internal.c */
/* compiled from: RequestHandler */
public interface C0517c {
    /* renamed from: a */
    void mo7432a(Context context, Intent intent);

    /* renamed from: a */
    void mo7433a(RequestId requestId);

    /* renamed from: a */
    void mo7434a(RequestId requestId, String str);

    /* renamed from: a */
    void mo7435a(RequestId requestId, String str, FulfillmentResult fulfillmentResult);

    /* renamed from: a */
    void mo7436a(RequestId requestId, Set<String> set);

    /* renamed from: a */
    void mo7437a(RequestId requestId, boolean z);
}
