package com.unity3d.services.p053ar;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableException;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unity3d.services.ar.ARUtils */
public class ARUtils {
    public static final int AR_CHECK_NOT_SUPPORTED = 0;
    public static final int AR_CHECK_SUPPORTED = 1;
    public static final int AR_CHECK_TRANSIENT = 2;
    private static Config.LightEstimationMode[] lightEstimationModes;
    private static Config.PlaneFindingMode[] planeFindingModes;
    private static Config.UpdateMode[] updateModes;

    public static int isSupported(Context context) {
        if (!ARCheck.isFrameworkPresent()) {
            return 0;
        }
        if (planeFindingModes == null) {
            planeFindingModes = Config.PlaneFindingMode.values();
            lightEstimationModes = Config.LightEstimationMode.values();
            updateModes = Config.UpdateMode.values();
        }
        ArCoreApk.Availability checkAvailability = ArCoreApk.getInstance().checkAvailability(context);
        if (checkAvailability.isTransient()) {
            return 2;
        }
        if (checkAvailability == ArCoreApk.Availability.SUPPORTED_INSTALLED) {
            try {
                new Session(context);
                return 1;
            } catch (FatalException | UnavailableException unused) {
            } catch (SecurityException unused2) {
                return 1;
            }
        }
        return 0;
    }

    public static Config createConfiguration(JSONObject jSONObject, Session session) {
        Config config = new Config(session);
        int i = 0;
        if (jSONObject.has("lightEstimationMode")) {
            try {
                String string = jSONObject.getString("lightEstimationMode");
                Config.LightEstimationMode[] lightEstimationModeArr = lightEstimationModes;
                int length = lightEstimationModeArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Config.LightEstimationMode lightEstimationMode = lightEstimationModeArr[i2];
                    if (string.equalsIgnoreCase(lightEstimationMode.name())) {
                        config.setLightEstimationMode(lightEstimationMode);
                        break;
                    }
                    i2++;
                }
            } catch (JSONException unused) {
                DeviceLog.warning("lightEstimationEnabled is not a string.");
            }
        }
        if (jSONObject.has("planeFindingMode")) {
            try {
                String string2 = jSONObject.getString("planeFindingMode");
                Config.PlaneFindingMode[] planeFindingModeArr = planeFindingModes;
                int length2 = planeFindingModeArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    Config.PlaneFindingMode planeFindingMode = planeFindingModeArr[i3];
                    if (string2.equalsIgnoreCase(planeFindingMode.name())) {
                        config.setPlaneFindingMode(planeFindingMode);
                        break;
                    }
                    i3++;
                }
            } catch (JSONException unused2) {
                DeviceLog.warning("planeFindingMode is not a string.");
            }
        }
        if (jSONObject.has("updateMode")) {
            try {
                String string3 = jSONObject.getString("updateMode");
                Config.UpdateMode[] updateModeArr = updateModes;
                int length3 = updateModeArr.length;
                while (true) {
                    if (i >= length3) {
                        break;
                    }
                    Config.UpdateMode updateMode = updateModeArr[i];
                    if (string3.equalsIgnoreCase(updateMode.name())) {
                        config.setUpdateMode(updateMode);
                        break;
                    }
                    i++;
                }
            } catch (JSONException unused3) {
                DeviceLog.warning("updateMode is not a string.");
            }
        }
        return config;
    }

    @TargetApi(19)
    public static JSONObject getConfigEnums() {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            for (Config.LightEstimationMode name : Config.LightEstimationMode.values()) {
                arrayList.add(name.name());
            }
            jSONObject.put("lightEstimationMode", new JSONArray(arrayList.toArray()));
            arrayList.clear();
            for (Config.PlaneFindingMode name2 : Config.PlaneFindingMode.values()) {
                arrayList.add(name2.name());
            }
            jSONObject.put("planeFindingMode", new JSONArray(arrayList.toArray()));
            arrayList.clear();
            for (Config.UpdateMode name3 : Config.UpdateMode.values()) {
                arrayList.add(name3.name());
            }
            jSONObject.put("updateMode", new JSONArray(arrayList.toArray()));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
