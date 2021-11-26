package com.google.firebase.crashlytics.ndk;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: CrashlyticsNdkRegistrar */
final /* synthetic */ class CrashlyticsNdkRegistrar$$Lambda$1 implements ComponentFactory {
    private final CrashlyticsNdkRegistrar arg$1;

    private CrashlyticsNdkRegistrar$$Lambda$1(CrashlyticsNdkRegistrar crashlyticsNdkRegistrar) {
        this.arg$1 = crashlyticsNdkRegistrar;
    }

    public static ComponentFactory lambdaFactory$(CrashlyticsNdkRegistrar crashlyticsNdkRegistrar) {
        return new CrashlyticsNdkRegistrar$$Lambda$1(crashlyticsNdkRegistrar);
    }

    public Object create(ComponentContainer componentContainer) {
        return this.arg$1.buildCrashlyticsNdk(componentContainer);
    }
}
