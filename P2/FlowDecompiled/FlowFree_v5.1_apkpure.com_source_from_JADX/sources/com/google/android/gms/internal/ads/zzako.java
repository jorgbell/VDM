package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URISyntaxException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzako {
    public static final zzakp<zzbgf> zza = zzaju.zza;
    public static final zzakp<zzbgf> zzb = zzajv.zza;
    public static final zzakp<zzbgf> zzc = zzajw.zza;
    public static final zzakp<zzbgf> zzd = zzaka.zza;
    public static final zzakp<zzbgf> zze = new zzakg();
    public static final zzakp<zzbgf> zzf = new zzakh();
    public static final zzakp<zzbgf> zzg = zzakb.zza;
    public static final zzakp<Object> zzh = new zzaki();
    public static final zzakp<zzbgf> zzi = new zzakj();
    public static final zzakp<zzbgf> zzj = zzakc.zza;
    public static final zzakp<zzbgf> zzk = new zzakk();
    public static final zzakp<zzbgf> zzl = new zzakl();
    public static final zzakp<zzbdp> zzm = new zzbfc();
    public static final zzakp<zzbdp> zzn = new zzbfd();
    public static final zzakp<zzbgf> zzo = new zzajt();
    public static final zzald zzp = new zzald();
    public static final zzakp<zzbgf> zzq = new zzakm();
    public static final zzakp<zzbgf> zzr = new zzakn();
    public static final zzakp<zzbgf> zzs = new zzakd();
    public static final zzakp<zzbgf> zzt = new zzake();

    public static zzefw<String> zza(zzbgf zzbgf, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzfh zzU = zzbgf.zzU();
            if (zzU != null && zzU.zza(parse)) {
                parse = zzU.zze(parse, zzbgf.getContext(), zzbgf.zzH(), zzbgf.zzj());
            }
        } catch (zzfi unused) {
            zzbbk.zzi(str.length() != 0 ? "Unable to append parameter to URL: ".concat(str) : new String("Unable to append parameter to URL: "));
        }
        String zzb2 = zzazv.zzb(parse, zzbgf.getContext());
        if (!zzagc.zzf.zze().booleanValue()) {
            return zzefo.zza(zzb2);
        }
        zzeff<String> zzw = zzeff.zzw(zzbgf.zzaE());
        zzecb zzecb = zzajx.zza;
        zzefx zzefx = zzbbw.zzf;
        return zzefo.zze(zzefo.zzi(zzefo.zze(zzw, Throwable.class, zzecb, zzefx), new zzajy(zzb2), zzefx), Throwable.class, new zzajz(zzb2), zzefx);
    }

    static final /* synthetic */ void zzb(zzbhh zzbhh, Map map) {
        String str;
        PackageManager packageManager = zzbhh.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                URISyntaxException uRISyntaxException = e;
                                String valueOf = String.valueOf(optString7);
                                if (valueOf.length() != 0) {
                                    str = "Error parsing the url: ".concat(valueOf);
                                } else {
                                    str = new String("Error parsing the url: ");
                                }
                                zzbbk.zzg(str, uRISyntaxException);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzbbk.zzg("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzbbk.zzg("Error parsing the intent data.", e3);
                    }
                }
                ((zzang) zzbhh).zzd("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzang) zzbhh).zzd("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzang) zzbhh).zzd("openableIntents", new JSONObject());
        }
    }
}
