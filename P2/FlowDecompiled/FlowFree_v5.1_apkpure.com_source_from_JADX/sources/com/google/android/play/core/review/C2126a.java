package com.google.android.play.core.review;

import android.app.PendingIntent;
import java.util.Objects;

/* renamed from: com.google.android.play.core.review.a */
final class C2126a extends ReviewInfo {

    /* renamed from: a */
    private final PendingIntent f5232a;

    C2126a(PendingIntent pendingIntent) {
        Objects.requireNonNull(pendingIntent, "Null pendingIntent");
        this.f5232a = pendingIntent;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PendingIntent mo22120a() {
        return this.f5232a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f5232a.equals(((ReviewInfo) obj).mo22120a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f5232a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5232a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("ReviewInfo{pendingIntent=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
