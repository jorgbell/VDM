package androidx.media2.session;

import android.annotation.SuppressLint;
import androidx.versionedparcelable.VersionedParcelable;

@SuppressLint({"ObsoleteSdkInt"})
public final class SessionToken implements VersionedParcelable {
    SessionTokenImpl mImpl;

    interface SessionTokenImpl extends VersionedParcelable {
    }

    SessionToken() {
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionToken)) {
            return false;
        }
        return this.mImpl.equals(((SessionToken) obj).mImpl);
    }

    public String toString() {
        return this.mImpl.toString();
    }
}
