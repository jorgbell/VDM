package androidx.media2.session;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.media2.session.MediaSession;
import java.util.List;
import java.util.Objects;

public abstract class MediaSessionService extends Service {
    private final MediaSessionServiceImpl mImpl = createImpl();

    interface MediaSessionServiceImpl {
        void addSession(MediaSession mediaSession);

        List<MediaSession> getSessions();

        IBinder onBind(Intent intent);

        void onCreate(MediaSessionService mediaSessionService);

        void onDestroy();

        int onStartCommand(Intent intent, int i, int i2);

        MediaNotification onUpdateNotification(MediaSession mediaSession);
    }

    public abstract MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo);

    /* access modifiers changed from: package-private */
    public MediaSessionServiceImpl createImpl() {
        return new MediaSessionServiceImplBase();
    }

    public void onCreate() {
        super.onCreate();
        this.mImpl.onCreate(this);
    }

    public final void addSession(MediaSession mediaSession) {
        Objects.requireNonNull(mediaSession, "session shouldn't be null");
        if (!mediaSession.isClosed()) {
            this.mImpl.addSession(mediaSession);
            return;
        }
        throw new IllegalArgumentException("session is already closed");
    }

    public MediaNotification onUpdateNotification(MediaSession mediaSession) {
        Objects.requireNonNull(mediaSession, "session shouldn't be null");
        return this.mImpl.onUpdateNotification(mediaSession);
    }

    public final List<MediaSession> getSessions() {
        return this.mImpl.getSessions();
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return this.mImpl.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mImpl.onDestroy();
    }

    public static class MediaNotification {
        private final Notification mNotification;
        private final int mNotificationId;

        public MediaNotification(int i, Notification notification) {
            Objects.requireNonNull(notification, "notification shouldn't be null");
            this.mNotificationId = i;
            this.mNotification = notification;
        }

        public int getNotificationId() {
            return this.mNotificationId;
        }

        public Notification getNotification() {
            return this.mNotification;
        }
    }
}
