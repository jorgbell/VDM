package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Component.Builder<FirebaseInstallationsApi> builder = Component.builder(FirebaseInstallationsApi.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.optionalProvider(HeartBeatInfo.class));
        builder.add(Dependency.optionalProvider(UserAgentPublisher.class));
        builder.factory(FirebaseInstallationsRegistrar$$Lambda$1.lambdaFactory$());
        return Arrays.asList(new Component[]{builder.build(), LibraryVersionComponent.create("fire-installations", "16.3.5")});
    }

    static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class));
    }
}
