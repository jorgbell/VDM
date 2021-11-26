package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Component.Builder<FirebaseCrashlytics> builder = Component.builder(FirebaseCrashlytics.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.optional(AnalyticsConnector.class));
        builder.add(Dependency.optional(CrashlyticsNativeComponent.class));
        builder.factory(CrashlyticsRegistrar$$Lambda$1.lambdaFactory$(this));
        builder.eagerInDefaultApp();
        return Arrays.asList(new Component[]{builder.build(), LibraryVersionComponent.create("fire-cls", "17.4.1")});
    }

    /* access modifiers changed from: private */
    public FirebaseCrashlytics buildCrashlytics(ComponentContainer componentContainer) {
        return FirebaseCrashlytics.init((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), (CrashlyticsNativeComponent) componentContainer.get(CrashlyticsNativeComponent.class), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
    }
}
