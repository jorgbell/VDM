package androidx.media2.session;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import androidx.versionedparcelable.VersionedParcelable;

public abstract class MediaLibraryService extends MediaSessionService {

    public static final class MediaLibrarySession extends MediaSession {
    }

    public abstract MediaLibrarySession onGetSession(MediaSession.ControllerInfo controllerInfo);

    /* access modifiers changed from: package-private */
    public MediaSessionService.MediaSessionServiceImpl createImpl() {
        return new MediaLibraryServiceImplBase();
    }

    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public static final class LibraryParams implements VersionedParcelable {
        Bundle mBundle;
        int mOffline;
        int mRecent;
        int mSuggested;

        LibraryParams() {
        }
    }
}
