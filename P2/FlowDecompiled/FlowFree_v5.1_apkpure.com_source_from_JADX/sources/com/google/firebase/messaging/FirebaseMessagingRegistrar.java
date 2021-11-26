package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    private static class DevNullTransport<T> implements Transport<T> {
        private DevNullTransport() {
        }

        public void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
            transportScheduleCallback.onSchedule((Exception) null);
        }

        public void send(Event<T> event) {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    public static class DevNullTransportFactory implements TransportFactory {
        public <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
            return new DevNullTransport();
        }
    }

    static TransportFactory determineFactory(TransportFactory transportFactory) {
        if (transportFactory == null) {
            return new DevNullTransportFactory();
        }
        try {
            transportFactory.getTransport("test", String.class, Encoding.m4837of("json"), FirebaseMessagingRegistrar$$Lambda$1.$instance);
            return transportFactory;
        } catch (IllegalArgumentException unused) {
            return new DevNullTransportFactory();
        }
    }

    static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.get(FirebaseInstanceIdInternal.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), determineFactory((TransportFactory) componentContainer.get(TransportFactory.class)), (Subscriber) componentContainer.get(Subscriber.class));
    }

    @Keep
    public List<Component<?>> getComponents() {
        Component.Builder<FirebaseMessaging> builder = Component.builder(FirebaseMessaging.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.optional(FirebaseInstanceIdInternal.class));
        builder.add(Dependency.optionalProvider(UserAgentPublisher.class));
        builder.add(Dependency.optionalProvider(HeartBeatInfo.class));
        builder.add(Dependency.optional(TransportFactory.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory(FirebaseMessagingRegistrar$$Lambda$0.$instance);
        builder.alwaysEager();
        return Arrays.asList(new Component[]{builder.build(), LibraryVersionComponent.create("fire-fcm", "20.1.7_1p")});
    }
}
