package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbfd implements zzakp<zzbdp> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbdp zzbdp = (zzbdp) obj;
        zzbhb zzh = zzbdp.zzh();
        if (zzh == null) {
            try {
                zzbhb zzbhb = new zzbhb(zzbdp, Float.parseFloat((String) map.get(VastIconXmlManager.DURATION)), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzbdp.zzx(zzbhb);
                zzh = zzbhb;
            } catch (NullPointerException e) {
                e = e;
                zzbbk.zzg("Unable to parse videoMeta message.", e);
                zzs.zzg().zzg(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                zzbbk.zzg("Unable to parse videoMeta message.", e);
                zzs.zzg().zzg(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get(VastIconXmlManager.DURATION));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        int i = 0;
        if (parseInt >= 0) {
            if (parseInt <= 3) {
                i = parseInt;
            }
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zzbbk.zzm(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(parseFloat2);
            sb.append(" , duration : ");
            sb.append(parseFloat);
            sb.append(" , isMuted : ");
            sb.append(equals);
            sb.append(" , playbackState : ");
            sb.append(i);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            zzbbk.zzd(sb.toString());
        }
        zzh.zzs(parseFloat2, parseFloat, i, equals, parseFloat3);
    }
}
