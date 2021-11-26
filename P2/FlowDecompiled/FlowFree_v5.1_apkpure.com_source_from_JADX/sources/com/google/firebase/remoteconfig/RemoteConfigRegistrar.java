package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
public class RemoteConfigRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Component.Builder<RemoteConfigComponent> builder = Component.builder(RemoteConfigComponent.class);
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(AbtComponent.class));
        builder.add(Dependency.optional(AnalyticsConnector.class));
        builder.factory(RemoteConfigRegistrar$$Lambda$1.lambdaFactory$());
        builder.eagerInDefaultApp();
        return Arrays.asList(new Component[]{builder.build(), LibraryVersionComponent.create("fire-rc", "20.0.4")});
    }

    static /* synthetic */ RemoteConfigComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new RemoteConfigComponent((Context) componentContainer.get(Context.class), (FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), ((AbtComponent) componentContainer.get(AbtComponent.class)).get("frc"), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
    }
}
