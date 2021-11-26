package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
public class AbtRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Component.Builder<AbtComponent> builder = Component.builder(AbtComponent.class);
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.optional(AnalyticsConnector.class));
        builder.factory(AbtRegistrar$$Lambda$1.lambdaFactory$());
        return Arrays.asList(new Component[]{builder.build(), LibraryVersionComponent.create("fire-abt", "20.0.0")});
    }

    static /* synthetic */ AbtComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new AbtComponent((Context) componentContainer.get(Context.class), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
    }
}
