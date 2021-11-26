package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class ListenerHolder$ListenerKey<L> {
    private final L zaa;
    private final String zab;

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListenerHolder$ListenerKey)) {
            return false;
        }
        ListenerHolder$ListenerKey listenerHolder$ListenerKey = (ListenerHolder$ListenerKey) obj;
        return this.zaa == listenerHolder$ListenerKey.zaa && this.zab.equals(listenerHolder$ListenerKey.zab);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
    }
}
