package com.vungle.warren.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

class LogSender {
    private static final String TAG = "LogSender";
    private int batchId = getBatchId();
    private Context context;
    private final String deviceId = getDeviceId();
    private VungleApiClient vungleApiClient;

    LogSender(Context context2, VungleApiClient vungleApiClient2) {
        this.context = context2;
        this.vungleApiClient = vungleApiClient2;
    }

    /* access modifiers changed from: package-private */
    public void sendLogs(File[] fileArr) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("batch_id", (Number) Integer.valueOf(this.batchId));
            jsonObject.addProperty("device_guid", this.deviceId);
            try {
                JsonArray payload = getPayload(file);
                if (payload == null) {
                    FileUtility.delete(file);
                    i++;
                } else {
                    jsonObject.add("payload", payload);
                    if (this.vungleApiClient.sendLog(jsonObject).execute().isSuccessful()) {
                        FileUtility.delete(file);
                    }
                    if (this.batchId >= Integer.MAX_VALUE) {
                        this.batchId = -1;
                    }
                    this.batchId++;
                    i++;
                }
            } catch (IOException unused) {
                Log.e(TAG, "Failed to generate request payload.");
            }
        }
        saveBatchId();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        android.util.Log.e(TAG, "Invalidate log document file.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        com.vungle.warren.utility.FileUtility.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.JsonArray getPayload(java.io.File r5) {
        /*
            r4 = this;
            com.google.gson.JsonArray r0 = new com.google.gson.JsonArray
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
        L_0x0010:
            java.lang.String r5 = r2.readLine()     // Catch:{ Exception -> 0x0029 }
            if (r5 == 0) goto L_0x0022
            com.google.gson.JsonElement r5 = com.google.gson.JsonParser.parseString(r5)     // Catch:{ Exception -> 0x0029 }
            com.google.gson.JsonObject r5 = r5.getAsJsonObject()     // Catch:{ Exception -> 0x0029 }
            r0.add((com.google.gson.JsonElement) r5)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0010
        L_0x0022:
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
            return r0
        L_0x0026:
            r5 = move-exception
            goto L_0x0036
        L_0x0028:
            r2 = r1
        L_0x0029:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = "Invalidate log document file."
            android.util.Log.e(r5, r0)     // Catch:{ all -> 0x0034 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
            return r1
        L_0x0034:
            r5 = move-exception
            r1 = r2
        L_0x0036:
            com.vungle.warren.utility.FileUtility.closeQuietly(r1)
            goto L_0x003b
        L_0x003a:
            throw r5
        L_0x003b:
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogSender.getPayload(java.io.File):com.google.gson.JsonArray");
    }

    private String getDeviceId() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("vungle_logger_prefs", 0);
        String string = sharedPreferences.getString("device_id", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("device_id", uuid);
        edit.apply();
        return uuid;
    }

    private int getBatchId() {
        return this.context.getSharedPreferences("vungle_logger_prefs", 0).getInt("batch_id", 0);
    }

    private void saveBatchId() {
        SharedPreferences.Editor edit = this.context.getSharedPreferences("vungle_logger_prefs", 0).edit();
        edit.putInt("batch_id", this.batchId);
        edit.apply();
    }
}
