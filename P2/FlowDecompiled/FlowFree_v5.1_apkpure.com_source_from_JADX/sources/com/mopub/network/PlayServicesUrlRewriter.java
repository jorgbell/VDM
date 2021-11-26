package com.mopub.network;

import android.net.Uri;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.privacy.AdvertisingId;
import com.mopub.volley.toolbox.HurlStack;

public class PlayServicesUrlRewriter implements HurlStack.UrlRewriter {
    public static final String DO_NOT_TRACK_TEMPLATE = "mp_tmpl_do_not_track";
    public static final String IFA_TEMPLATE = "mp_tmpl_advertising_id";
    public static final String MOPUB_ID_TEMPLATE = "mp_tmpl_mopub_id";
    public static final String TAS_TEMPLATE = "mp_tmpl_tas";

    public String rewriteUrl(String str) {
        String str2;
        ClientMetadata instance = ClientMetadata.getInstance();
        if (instance == null) {
            return str;
        }
        AdvertisingId advertisingInfo = instance.getMoPubIdentifier().getAdvertisingInfo();
        String replace = str.replace(DO_NOT_TRACK_TEMPLATE, advertisingInfo.isDoNotTrack() ? "1" : "0").replace(TAS_TEMPLATE, advertisingInfo.isDoNotTrack() ? Constants.TAS_DENIED : Constants.TAS_AUTHORIZED);
        if (!MoPub.canCollectPersonalInformation() || advertisingInfo.isDoNotTrack()) {
            str2 = replace.replace("&ifa=mp_tmpl_advertising_id", "");
        } else {
            str2 = replace.replace(IFA_TEMPLATE, Uri.encode(advertisingInfo.getIdentifier(true)));
        }
        return str2.replace(MOPUB_ID_TEMPLATE, Uri.encode(advertisingInfo.getIdentifier(false)));
    }
}
