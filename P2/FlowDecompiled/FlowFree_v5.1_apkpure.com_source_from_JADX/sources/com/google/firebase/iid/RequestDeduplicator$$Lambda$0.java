package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
final /* synthetic */ class RequestDeduplicator$$Lambda$0 implements Continuation {
    private final RequestDeduplicator arg$1;
    private final Pair arg$2;

    RequestDeduplicator$$Lambda$0(RequestDeduplicator requestDeduplicator, Pair pair) {
        this.arg$1 = requestDeduplicator;
        this.arg$2 = pair;
    }

    public Object then(Task task) {
        this.arg$1.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.arg$2, task);
        return task;
    }
}
