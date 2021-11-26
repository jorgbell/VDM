package com.iab.omid.library.vungle.adsession;

import com.iab.omid.library.vungle.p050d.C2437b;
import com.iab.omid.library.vungle.p050d.C2441e;
import com.mopub.mobileads.VastResourceXmlManager;
import org.json.JSONObject;

public class AdSessionConfiguration {
    private final CreativeType creativeType;
    private final Owner impressionOwner;
    private final ImpressionType impressionType;
    private final boolean isolateVerificationScripts;
    private final Owner mediaEventsOwner;

    private AdSessionConfiguration(CreativeType creativeType2, ImpressionType impressionType2, Owner owner, Owner owner2, boolean z) {
        this.creativeType = creativeType2;
        this.impressionType = impressionType2;
        this.impressionOwner = owner;
        if (owner2 == null) {
            this.mediaEventsOwner = Owner.NONE;
        } else {
            this.mediaEventsOwner = owner2;
        }
        this.isolateVerificationScripts = z;
    }

    public static AdSessionConfiguration createAdSessionConfiguration(CreativeType creativeType2, ImpressionType impressionType2, Owner owner, Owner owner2, boolean z) {
        C2441e.m5791a((Object) creativeType2, "CreativeType is null");
        C2441e.m5791a((Object) impressionType2, "ImpressionType is null");
        C2441e.m5791a((Object) owner, "Impression owner is null");
        C2441e.m5790a(owner, creativeType2, impressionType2);
        return new AdSessionConfiguration(creativeType2, impressionType2, owner, owner2, z);
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C2437b.m5776a(jSONObject, "impressionOwner", this.impressionOwner);
        C2437b.m5776a(jSONObject, "mediaEventsOwner", this.mediaEventsOwner);
        C2437b.m5776a(jSONObject, VastResourceXmlManager.CREATIVE_TYPE, this.creativeType);
        C2437b.m5776a(jSONObject, "impressionType", this.impressionType);
        C2437b.m5776a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.isolateVerificationScripts));
        return jSONObject;
    }
}
