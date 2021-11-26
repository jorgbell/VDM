package com.mopub.mobileads.factories;

import com.mopub.mobileads.BaseAd;
import java.lang.reflect.Constructor;

public class BaseAdFactory {
    protected static BaseAdFactory instance = new BaseAdFactory();

    @Deprecated
    public static void setInstance(BaseAdFactory baseAdFactory) {
        instance = baseAdFactory;
    }

    public static BaseAd create(String str) throws Exception {
        return instance.internalCreate(str);
    }

    /* access modifiers changed from: protected */
    public BaseAd internalCreate(String str) throws Exception {
        Constructor<? extends U> declaredConstructor = Class.forName(str).asSubclass(BaseAd.class).getDeclaredConstructor((Class[]) null);
        declaredConstructor.setAccessible(true);
        return (BaseAd) declaredConstructor.newInstance(new Object[0]);
    }
}
