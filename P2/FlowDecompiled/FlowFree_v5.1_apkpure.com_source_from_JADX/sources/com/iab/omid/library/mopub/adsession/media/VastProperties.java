package com.iab.omid.library.mopub.adsession.media;

import com.iab.omid.library.mopub.p044d.C2390c;
import com.iab.omid.library.mopub.p044d.C2392e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a */
    private final boolean f5357a;

    /* renamed from: b */
    private final Float f5358b;

    /* renamed from: c */
    private final boolean f5359c;

    /* renamed from: d */
    private final Position f5360d;

    private VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f5357a = z;
        this.f5358b = f;
        this.f5359c = z2;
        this.f5360d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z, Position position) {
        C2392e.m5597a((Object) position, "Position is null");
        return new VastProperties(false, (Float) null, z, position);
    }

    /* renamed from: a */
    public JSONObject mo24015a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f5357a);
            if (this.f5357a) {
                jSONObject.put("skipOffset", this.f5358b);
            }
            jSONObject.put("autoPlay", this.f5359c);
            jSONObject.put("position", this.f5360d);
        } catch (JSONException e) {
            C2390c.m5592a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
