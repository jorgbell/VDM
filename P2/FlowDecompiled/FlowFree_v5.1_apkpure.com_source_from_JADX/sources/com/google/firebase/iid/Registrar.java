package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final class Registrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    private static class FIIDInternalAdapter implements FirebaseInstanceIdInternal {
        final FirebaseInstanceId fiid;

        public FIIDInternalAdapter(FirebaseInstanceId firebaseInstanceId) {
            this.fiid = firebaseInstanceId;
        }

        public void addNewTokenListener(FirebaseInstanceIdInternal.NewTokenListener newTokenListener) {
            this.fiid.addNewTokenListener(newTokenListener);
        }

        public String getToken() {
            return this.fiid.getToken();
        }

        public Task<String> getTokenTask() {
            String token = this.fiid.getToken();
            if (token != null) {
                return Tasks.forResult(token);
            }
            return this.fiid.getInstanceId().continueWith(Registrar$FIIDInternalAdapter$$Lambda$0.$instance);
        }
    }

    static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class));
    }

    static final /* synthetic */ FirebaseInstanceIdInternal lambda$getComponents$1$Registrar(ComponentContainer componentContainer) {
        return new FIIDInternalAdapter((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }

    @Keep
    public List<Component<?>> getComponents() {
        Class<FirebaseInstanceId> cls = FirebaseInstanceId.class;
        Component.Builder<FirebaseInstanceId> builder = Component.builder(cls);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.optionalProvider(UserAgentPublisher.class));
        builder.add(Dependency.optionalProvider(HeartBeatInfo.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.factory(Registrar$$Lambda$0.$instance);
        builder.alwaysEager();
        Component<FirebaseInstanceId> build = builder.build();
        Component.Builder<FirebaseInstanceIdInternal> builder2 = Component.builder(FirebaseInstanceIdInternal.class);
        builder2.add(Dependency.required(cls));
        builder2.factory(Registrar$$Lambda$1.$instance);
        return Arrays.asList(new Component[]{build, builder2.build(), LibraryVersionComponent.create("fire-iid", "21.1.0")});
    }
}
