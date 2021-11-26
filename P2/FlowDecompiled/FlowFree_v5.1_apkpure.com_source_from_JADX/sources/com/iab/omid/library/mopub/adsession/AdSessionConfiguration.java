package com.iab.omid.library.mopub.adsession;

import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.p044d.C2392e;
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
        C2392e.m5597a((Object) creativeType2, "CreativeType is null");
        C2392e.m5597a((Object) impressionType2, "ImpressionType is null");
        C2392e.m5597a((Object) owner, "Impression owner is null");
        C2392e.m5595a(owner, creativeType2, impressionType2);
        return new AdSessionConfiguration(creativeType2, impressionType2, owner, owner2, z);
    }

    public boolean isNativeImpressionOwner() {
        return Owner.NATIVE == this.impressionOwner;
    }

    public boolean isNativeMediaEventsOwner() {
        return Owner.NATIVE == this.mediaEventsOwner;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C2388b.m5581a(jSONObject, "impressionOwner", this.impressionOwner);
        C2388b.m5581a(jSONObject, "mediaEventsOwner", this.mediaEventsOwner);
        C2388b.m5581a(jSONObject, VastResourceXmlManager.CREATIVE_TYPE, this.creativeType);
        C2388b.m5581a(jSONObject, "impressionType", this.impressionType);
        C2388b.m5581a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.isolateVerificationScripts));
        return jSONObject;
    }
}
