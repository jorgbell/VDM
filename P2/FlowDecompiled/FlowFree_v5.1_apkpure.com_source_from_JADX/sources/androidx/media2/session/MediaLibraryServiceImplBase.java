package androidx.media2.session;

import android.content.Intent;
import android.os.IBinder;

class MediaLibraryServiceImplBase extends MediaSessionServiceImplBase {
    MediaLibraryServiceImplBase() {
    }

    public IBinder onBind(Intent intent) {
        if ("androidx.media2.session.MediaLibraryService".equals(intent.getAction())) {
            return getServiceBinder();
        }
        return super.onBind(intent);
    }
}
