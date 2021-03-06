package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

public class WebViewAdUrlGenerator extends AdUrlGenerator {
    public WebViewAdUrlGenerator(Context context) {
        super(context);
    }

    public String generateUrlString(String str) {
        initUrlString(str, Constants.AD_HANDLER);
        setApiVersion("6");
        addBaseParams(ClientMetadata.getInstance(this.mContext));
        setMraidFlag(true);
        return getFinalUrlString();
    }
}
