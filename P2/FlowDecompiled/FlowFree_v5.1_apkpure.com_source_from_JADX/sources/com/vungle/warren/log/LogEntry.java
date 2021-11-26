package com.vungle.warren.log;

import com.google.gson.JsonObject;

class LogEntry {
    private String bundleID;
    private String context;
    private String creationDate;
    private String customData;
    private String eventID;
    private String exClass;
    private String level;
    private String message;
    private String threadId;
    private String timeZone;
    private String userAgent;

    LogEntry(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.level = str2;
        this.message = str;
        this.context = str3;
        this.eventID = str4;
        this.userAgent = str5;
        this.bundleID = str6;
        this.timeZone = str7;
        this.creationDate = str8;
        this.customData = str9;
        this.exClass = str10;
        this.threadId = str11;
    }

    public String toJsonString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("raw_log", this.message);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("metadata", jsonObject2);
        addMetadataProperty(jsonObject2, "log_level", this.level);
        addMetadataProperty(jsonObject2, "context", this.context);
        addMetadataProperty(jsonObject2, "event_id", this.eventID);
        addMetadataProperty(jsonObject2, "sdk_user_agent", this.userAgent);
        addMetadataProperty(jsonObject2, "bundle_id", this.bundleID);
        addMetadataProperty(jsonObject2, "time_zone", this.timeZone);
        addMetadataProperty(jsonObject2, "device_timestamp", this.creationDate);
        addMetadataProperty(jsonObject2, "custom_data", this.customData);
        addMetadataProperty(jsonObject2, "exception_class", this.exClass);
        addMetadataProperty(jsonObject2, "thread_id", this.threadId);
        return jsonObject.toString();
    }

    private void addMetadataProperty(JsonObject jsonObject, String str, String str2) {
        if (str2 != null) {
            jsonObject.addProperty(str, str2);
        }
    }
}
