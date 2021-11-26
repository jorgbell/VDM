package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Component.Builder<CrashlyticsNativeComponent> builder = Component.builder(CrashlyticsNativeComponent.class);
        builder.add(Dependency.required(Context.class));
        builder.factory(CrashlyticsNdkRegistrar$$Lambda$1.lambdaFactory$(this));
        builder.eagerInDefaultApp();
        return Arrays.asList(new Component[]{builder.build(), LibraryVersionComponent.create("fire-cls-ndk", "17.4.1")});
    }

    /* access modifiers changed from: private */
    public CrashlyticsNativeComponent buildCrashlyticsNdk(ComponentContainer componentContainer) {
        return FirebaseCrashlyticsNdk.create((Context) componentContainer.get(Context.class));
    }
}
