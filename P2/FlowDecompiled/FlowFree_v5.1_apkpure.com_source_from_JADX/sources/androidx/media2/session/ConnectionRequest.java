package androidx.media2.session;

import android.os.Bundle;
import androidx.versionedparcelable.VersionedParcelable;

class ConnectionRequest implements VersionedParcelable {
    Bundle mConnectionHints;
    String mPackageName;
    int mPid;
    int mVersion;

    ConnectionRequest() {
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPid() {
        return this.mPid;
    }

    public Bundle getConnectionHints() {
        return this.mConnectionHints;
    }
}
