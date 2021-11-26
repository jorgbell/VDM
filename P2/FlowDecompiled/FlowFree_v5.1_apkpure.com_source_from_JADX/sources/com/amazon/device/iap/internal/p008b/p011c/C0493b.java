package com.amazon.device.iap.internal.p008b.p011c;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.venezia.command.SuccessResult;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amazon.device.iap.internal.b.c.b */
/* compiled from: GetItemDataCommandV1 */
public final class C0493b extends C0494c {

    /* renamed from: b */
    private static final String f44b = C0493b.class.getSimpleName();

    public C0493b(C0501e eVar, Set<String> set) {
        super(eVar, "1.0", set);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws RemoteException, KiwiException {
        Map data = successResult.getData();
        String str = f44b;
        C0532e.m187a(str, "data: " + data);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashMap hashMap = new HashMap();
        for (String next : this.f45a) {
            if (!data.containsKey(next)) {
                linkedHashSet.add(next);
            } else {
                try {
                    hashMap.put(next, m77a(next, data));
                } catch (IllegalArgumentException e) {
                    linkedHashSet.add(next);
                    String str2 = f44b;
                    C0532e.m189b(str2, "Error parsing JSON for SKU " + next + ": " + e.getMessage());
                }
            }
        }
        C0501e b = mo7469b();
        b.mo7457d().mo7463a((Object) new ProductDataResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(ProductDataResponse.RequestStatus.SUCCESSFUL).setUnavailableSkus(linkedHashSet).setProductData(hashMap).build());
        return true;
    }

    /* renamed from: a */
    private Product m77a(String str, Map map) throws IllegalArgumentException {
        String str2 = (String) map.get(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ProductType valueOf = ProductType.valueOf(jSONObject.getString("itemType").toUpperCase());
            String string = jSONObject.getString("description");
            String optString = jSONObject.optString("price");
            String string2 = jSONObject.getString("title");
            String string3 = jSONObject.getString("iconUrl");
            return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(string).setPrice(optString).setSmallIconUrl(string3).setTitle(string2).setCoinsRewardAmount(jSONObject.optInt("coinsRewardAmount", 0)).build();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("error in parsing json string" + str2);
        }
    }
}
