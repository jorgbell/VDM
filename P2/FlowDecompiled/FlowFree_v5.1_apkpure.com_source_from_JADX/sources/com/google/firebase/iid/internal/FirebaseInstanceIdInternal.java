package com.google.firebase.iid.internal;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
public interface FirebaseInstanceIdInternal {

    /* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
    public interface NewTokenListener {
        void onNewToken(String str);
    }

    void addNewTokenListener(NewTokenListener newTokenListener);

    String getToken();

    Task<String> getTokenTask();
}
