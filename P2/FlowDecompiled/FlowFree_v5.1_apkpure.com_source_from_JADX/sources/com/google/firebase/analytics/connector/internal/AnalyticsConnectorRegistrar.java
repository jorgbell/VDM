package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.3 */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @RecentlyNonNull
    @SuppressLint({"MissingPermission"})
    @Keep
    public List<Component<?>> getComponents() {
        Component.Builder<AnalyticsConnector> builder = Component.builder(AnalyticsConnector.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory(zzb.zza);
        builder.eagerInDefaultApp();
        return Arrays.asList(new Component[]{builder.build(), LibraryVersionComponent.create("fire-analytics", "18.0.3")});
    }
}
