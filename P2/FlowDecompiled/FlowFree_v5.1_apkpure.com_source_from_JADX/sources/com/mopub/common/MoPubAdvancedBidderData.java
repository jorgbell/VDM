package com.mopub.common;

import com.mopub.common.logging.MoPubLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubAdvancedBidderData {
    final String mToken;

    public MoPubAdvancedBidderData(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.mToken = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", this.mToken);
        } catch (JSONException unused) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent, "Invalid token format: " + this.mToken);
        }
        return jSONObject;
    }
}
