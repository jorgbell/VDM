package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.List;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Component.Builder<TransportFactory> builder = Component.builder(TransportFactory.class);
        builder.add(Dependency.required(Context.class));
        builder.factory(TransportRegistrar$$Lambda$1.lambdaFactory$());
        return Collections.singletonList(builder.build());
    }
}
