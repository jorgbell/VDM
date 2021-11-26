package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.HtmlController;

public class HtmlControllerFactory {
    protected static HtmlControllerFactory instance = new HtmlControllerFactory();

    @VisibleForTesting
    public static void setInstance(HtmlControllerFactory htmlControllerFactory) {
        instance = htmlControllerFactory;
    }

    public static HtmlController create(Context context, String str) {
        return instance.internalCreate(context, str);
    }

    /* access modifiers changed from: protected */
    public HtmlController internalCreate(Context context, String str) {
        return new HtmlController(context, str);
    }
}
