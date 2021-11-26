package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1232e;
import com.chartboost.sdk.Model.C1233f;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1240a;
import com.chartboost.sdk.Networking.C1245e;
import com.chartboost.sdk.Networking.C1246f;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.r0 */
public class C1367r0 extends C1357p0 {

    /* renamed from: o */
    private static final String f3367o = "r0";

    public C1367r0(Context context, C1232e eVar, C1240a aVar) {
        super(eVar.f2761a, eVar.f2762b, eVar.f2763c, eVar.f2764d, eVar.f2765e);
        this.f3340k = new C1233f(context, eVar.f2763c, aVar).mo10115e();
    }

    /* renamed from: a */
    public C1245e<JSONObject> mo10143a(C1246f fVar) {
        if (fVar.f2862b == null) {
            return C1245e.m3092a(new CBError(CBError.C1227b.INVALID_RESPONSE, "Response is not a valid json object"));
        }
        try {
            return C1245e.m3093a(new JSONObject(new String(fVar.f2862b)));
        } catch (JSONException e) {
            String str = f3367o;
            CBLogging.m2905b(str, "parseServerResponse: " + e.toString());
            return C1245e.m3092a(new CBError(CBError.C1227b.HTTP_NOT_FOUND, "No Bid"));
        }
    }

    /* renamed from: c */
    public void mo10564c() {
    }
}
