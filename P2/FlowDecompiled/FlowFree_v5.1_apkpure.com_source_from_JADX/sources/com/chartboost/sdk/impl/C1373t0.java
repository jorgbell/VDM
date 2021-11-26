package com.chartboost.sdk.impl;

import com.chartboost.sdk.Tracking.C1261b;
import com.chartboost.sdk.Tracking.C1269h;
import com.chartboost.sdk.Tracking.C1270i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.t0 */
public class C1373t0 {
    /* renamed from: a */
    public String mo10609a(C1270i iVar, C1261b bVar) {
        String str;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        if (!(iVar == null || bVar == null)) {
            try {
                C1269h i = iVar.mo10285i();
                String str2 = "";
                if (i != null) {
                    str2 = i.mo10265b();
                    str = i.mo10264a();
                } else {
                    str = str2;
                }
                String a = iVar.mo10269a();
                if (a != null) {
                    a = a.toLowerCase();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("chartboost_sdk_autocache_enabled", bVar.mo10207c());
                jSONObject2.put("chartboost_sdk_gdpr", bVar.mo10211e());
                String d = bVar.mo10208d();
                if (d != null && d.length() > 0) {
                    jSONObject2.put("chartboost_sdk_ccpa", d);
                }
                jSONObject2.put("device_battery_level", bVar.mo10220h());
                jSONObject2.put("device_charging_status", bVar.mo10223i());
                jSONObject2.put("device_language", bVar.mo10230m());
                jSONObject2.put("device_timezone", bVar.mo10247u());
                jSONObject2.put("device_volume", bVar.mo10249w());
                jSONObject2.put("device_mute", bVar.mo10237p());
                jSONObject2.put("device_audio_output", bVar.mo10217g());
                jSONObject2.put("device_storage", bVar.mo10244t());
                jSONObject2.put("device_low_memory_warning", bVar.mo10232n());
                jSONObject2.put("device_up_time", bVar.mo10248v());
                String a2 = iVar.mo10269a();
                if (a2 != null && a2.length() > 0) {
                    char c = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != -174936018) {
                        if (hashCode != 769047372) {
                            if (hashCode == 1982491468) {
                                if (a2.equals("Banner")) {
                                    c = 2;
                                }
                            }
                        } else if (a2.equals("Interstitial")) {
                            c = 0;
                        }
                    } else if (a2.equals("Rewarded")) {
                        c = 1;
                    }
                    if (c == 0) {
                        jSONObject2.put("session_impression_count", bVar.mo10192I());
                    } else if (c == 1) {
                        jSONObject2.put("session_impression_count", bVar.mo10193J());
                    } else if (c == 2) {
                        jSONObject2.put("session_impression_count", bVar.mo10191H());
                    }
                }
                jSONObject2.put("session_duration", bVar.mo10189F());
                jSONObject.put("session_id", bVar.mo10190G());
                jSONObject.put("session_count", bVar.mo10188E());
                jSONObject.put("event_name", iVar.mo10282f());
                jSONObject.put("event_message", iVar.mo10281e());
                jSONObject.put("event_type", iVar.mo10286j().name());
                jSONObject.put("event_timestamp", iVar.mo10284h());
                jSONObject.put("event_latency", (double) iVar.mo10277c());
                jSONObject.put("ad_type", a);
                jSONObject.put("ad_impression_id", str2);
                jSONObject.put("ad_creative_id", str);
                jSONObject.put("app_id", bVar.mo10194a());
                jSONObject.put("chartboost_sdk_version", bVar.mo10214f());
                jSONObject.put("mediation_sdk", bVar.mo10185A());
                jSONObject.put("mediation_sdk_version", bVar.mo10187C());
                jSONObject.put("mediation_sdk_adapter_version", bVar.mo10186B());
                jSONObject.put("framework", bVar.mo10250x());
                jSONObject.put("framework_version", bVar.mo10252z());
                jSONObject.put("framework_adapter_version", bVar.mo10251y());
                jSONObject.put("device_id", bVar.mo10228l());
                jSONObject.put("device_model", bVar.mo10234o());
                jSONObject.put("device_os_version", bVar.mo10240r());
                jSONObject.put("device_platform", bVar.mo10242s());
                jSONObject.put("device_country", bVar.mo10226k());
                jSONObject.put("device_connection_type", bVar.mo10224j());
                jSONObject.put("device_orientation", bVar.mo10238q());
                jSONObject.put("payload", jSONObject2);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }
}
