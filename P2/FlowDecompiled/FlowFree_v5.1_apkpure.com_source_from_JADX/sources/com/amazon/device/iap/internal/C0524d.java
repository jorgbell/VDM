package com.amazon.device.iap.internal;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.amazon.device.iap.internal.d */
/* compiled from: PurchasingManager */
public class C0524d {

    /* renamed from: a */
    private static String f99a = "d";

    /* renamed from: b */
    private static String f100b = "sku";

    /* renamed from: c */
    private static C0524d f101c = new C0524d();

    /* renamed from: d */
    private final C0517c f102d = C0525e.m169b();

    /* renamed from: e */
    private Context f103e;

    /* renamed from: f */
    private PurchasingListener f104f;

    private C0524d() {
    }

    /* renamed from: a */
    public PurchasingListener mo7493a() {
        return this.f104f;
    }

    /* renamed from: b */
    public Context mo7500b() {
        return this.f103e;
    }

    /* renamed from: e */
    private void m157e() {
        if (this.f104f == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    /* renamed from: a */
    public void mo7498a(Context context, PurchasingListener purchasingListener) {
        String str = f99a;
        C0532e.m187a(str, "PurchasingListener registered: " + purchasingListener);
        String str2 = f99a;
        C0532e.m187a(str2, "PurchasingListener Context: " + context);
        if (purchasingListener == null || context == null) {
            throw new IllegalArgumentException("Neither PurchasingListener or its Context can be null");
        }
        this.f103e = context.getApplicationContext();
        this.f104f = purchasingListener;
    }

    /* renamed from: c */
    public RequestId mo7501c() {
        m157e();
        RequestId requestId = new RequestId();
        this.f102d.mo7433a(requestId);
        return requestId;
    }

    /* renamed from: a */
    public RequestId mo7494a(String str) {
        C0531d.m183a((Object) str, f100b);
        m157e();
        RequestId requestId = new RequestId();
        this.f102d.mo7434a(requestId, str);
        return requestId;
    }

    /* renamed from: a */
    public RequestId mo7495a(Set<String> set) {
        C0531d.m183a((Object) set, "skus");
        C0531d.m185a((Collection<? extends Object>) set, "skus");
        for (String trim : set) {
            if (trim.trim().length() == 0) {
                throw new IllegalArgumentException("Empty SKU values are not allowed");
            }
        }
        if (set.size() <= 100) {
            m157e();
            RequestId requestId = new RequestId();
            this.f102d.mo7436a(requestId, (Set<String>) new LinkedHashSet(set));
            return requestId;
        }
        throw new IllegalArgumentException(set.size() + " SKUs were provided, but no more than " + 100 + " SKUs are allowed");
    }

    /* renamed from: a */
    public RequestId mo7496a(boolean z) {
        m157e();
        RequestId requestId = new RequestId();
        this.f102d.mo7437a(requestId, z);
        return requestId;
    }

    /* renamed from: a */
    public void mo7499a(String str, FulfillmentResult fulfillmentResult) {
        if (!C0531d.m186a(str)) {
            C0531d.m183a((Object) fulfillmentResult, "fulfillmentResult");
            m157e();
            this.f102d.mo7435a(new RequestId(), str, fulfillmentResult);
            return;
        }
        throw new IllegalArgumentException("Empty receiptId is not allowed");
    }

    /* renamed from: a */
    public void mo7497a(Context context, Intent intent) {
        try {
            this.f102d.mo7432a(context, intent);
        } catch (Exception e) {
            String str = f99a;
            C0532e.m189b(str, "Error in onReceive: " + e);
        }
    }

    /* renamed from: d */
    public static C0524d m156d() {
        return f101c;
    }
}
