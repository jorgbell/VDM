package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Personalization {
    private final AnalyticsConnector analyticsConnector;
    private final Map<String, String> loggedChoiceIds = Collections.synchronizedMap(new HashMap());

    public Personalization(AnalyticsConnector analyticsConnector2) {
        this.analyticsConnector = analyticsConnector2;
    }

    public void logArmActive(String str, ConfigContainer configContainer) {
        JSONObject optJSONObject;
        JSONObject personalizationMetadata = configContainer.getPersonalizationMetadata();
        if (personalizationMetadata.length() >= 1) {
            JSONObject configs = configContainer.getConfigs();
            if (configs.length() >= 1 && (optJSONObject = personalizationMetadata.optJSONObject(str)) != null) {
                String optString = optJSONObject.optString("choiceId");
                if (!optString.isEmpty()) {
                    synchronized (this.loggedChoiceIds) {
                        if (!optString.equals(this.loggedChoiceIds.get(str))) {
                            this.loggedChoiceIds.put(str, optString);
                            Bundle bundle = new Bundle();
                            bundle.putString("arm_key", str);
                            bundle.putString("arm_value", configs.optString(str));
                            bundle.putString("personalization_id", optJSONObject.optString("personalizationId"));
                            bundle.putInt("arm_index", optJSONObject.optInt("armIndex", -1));
                            bundle.putString("group", optJSONObject.optString("group"));
                            this.analyticsConnector.logEvent("fp", "personalization_assignment", bundle);
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("_fpid", optString);
                            this.analyticsConnector.logEvent("fp", "_fpc", bundle2);
                        }
                    }
                }
            }
        }
    }
}
