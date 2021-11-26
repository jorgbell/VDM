package androidx.media2.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.media2.common.BaseResult;
import androidx.media2.common.MediaItem;
import androidx.versionedparcelable.CustomVersionedParcelable;

public class SessionResult extends CustomVersionedParcelable implements BaseResult {
    long mCompletionTime;
    Bundle mCustomCommandResult;
    MediaItem mParcelableItem;
    int mResultCode;

    public SessionResult(int i, Bundle bundle) {
        this(i, bundle, (MediaItem) null, SystemClock.elapsedRealtime());
    }

    SessionResult() {
    }

    SessionResult(int i, Bundle bundle, MediaItem mediaItem, long j) {
        this.mResultCode = i;
        this.mCustomCommandResult = bundle;
        this.mCompletionTime = j;
    }

    public int getResultCode() {
        return this.mResultCode;
    }
}
