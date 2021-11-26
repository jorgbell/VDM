package com.google.firebase;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class FirebaseException extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseException(@RecentlyNonNull String str) {
        super(str);
        Preconditions.checkNotEmpty(str, "Detail message must not be empty");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseException(@RecentlyNonNull String str, @RecentlyNonNull Throwable th) {
        super(str, th);
        Preconditions.checkNotEmpty(str, "Detail message must not be empty");
    }
}
