package com.mopub.common;

import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import java.io.Serializable;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViewabilityVendor implements Serializable {
    private final URL javascriptResourceUrl;
    private final String vendorKey;
    private String verificationNotExecuted;
    private final String verificationParameters;

    private ViewabilityVendor(Builder builder) throws Exception {
        if (!"omid".equalsIgnoreCase(builder.apiFramework) || TextUtils.isEmpty(builder.javascriptResourceUrl)) {
            throw new InvalidParameterException("ViewabilityVendor cannot be created.");
        }
        this.vendorKey = builder.vendorKey;
        this.javascriptResourceUrl = new URL(builder.javascriptResourceUrl);
        this.verificationParameters = builder.verificationParameters;
        this.verificationNotExecuted = builder.verificationNotExecuted;
    }

    public String getVendorKey() {
        return this.vendorKey;
    }

    public URL getJavascriptResourceUrl() {
        return this.javascriptResourceUrl;
    }

    public String getVerificationParameters() {
        return this.verificationParameters;
    }

    public String getVerificationNotExecuted() {
        return this.verificationNotExecuted;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewabilityVendor)) {
            return false;
        }
        ViewabilityVendor viewabilityVendor = (ViewabilityVendor) obj;
        if (Objects.equals(this.vendorKey, viewabilityVendor.vendorKey) && Objects.equals(this.javascriptResourceUrl, viewabilityVendor.javascriptResourceUrl) && Objects.equals(this.verificationParameters, viewabilityVendor.verificationParameters)) {
            return Objects.equals(this.verificationNotExecuted, viewabilityVendor.verificationNotExecuted);
        }
        return false;
    }

    public int hashCode() {
        String str = this.vendorKey;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.javascriptResourceUrl.hashCode()) * 31;
        String str2 = this.verificationParameters;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.verificationNotExecuted;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return this.vendorKey + "\n" + this.javascriptResourceUrl + "\n" + this.verificationParameters + "\n";
    }

    static ViewabilityVendor createFromJson(JSONObject jSONObject) {
        Builder builder = new Builder(jSONObject.optString("javascriptResourceUrl"));
        builder.withApiFramework(jSONObject.optString("apiFramework", "")).withVendorKey(jSONObject.optString("vendorKey", "")).withVerificationParameters(jSONObject.optString("verificationParameters", ""));
        return builder.build();
    }

    public static Set<ViewabilityVendor> createFromJsonArray(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                ViewabilityVendor createFromJson = createFromJson(jSONArray.optJSONObject(i));
                if (createFromJson != null) {
                    hashSet.add(createFromJson);
                }
            }
        }
        return hashSet;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String apiFramework = "omid";
        /* access modifiers changed from: private */
        public String javascriptResourceUrl;
        /* access modifiers changed from: private */
        public String vendorKey;
        /* access modifiers changed from: private */
        public String verificationNotExecuted;
        /* access modifiers changed from: private */
        public String verificationParameters;

        public Builder(String str) {
            this.javascriptResourceUrl = str;
        }

        public Builder withVendorKey(String str) {
            this.vendorKey = str;
            return this;
        }

        public Builder withVerificationParameters(String str) {
            this.verificationParameters = str;
            return this;
        }

        public Builder withApiFramework(String str) {
            this.apiFramework = str;
            return this;
        }

        public Builder withVerificationNotExecuted(String str) {
            this.verificationNotExecuted = str;
            return this;
        }

        public ViewabilityVendor build() {
            try {
                return new ViewabilityVendor(this);
            } catch (Exception e) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Warning: " + e.getLocalizedMessage());
                return null;
            }
        }
    }
}
