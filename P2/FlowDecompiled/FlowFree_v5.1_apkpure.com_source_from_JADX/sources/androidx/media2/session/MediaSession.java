package androidx.media2.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.p001v4.media.session.MediaSessionCompat;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.SessionPlayer;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.HashMap;

public class MediaSession implements AutoCloseable {
    private static final HashMap<String, MediaSession> SESSION_ID_TO_SESSION_MAP = new HashMap<>();
    private static final Object STATIC_LOCK = new Object();
    private final MediaSessionImpl mImpl;

    static abstract class ControllerCb {
    }

    interface MediaSessionImpl extends AutoCloseable {
        void connectFromService(IMediaController iMediaController, String str, int i, int i2, Bundle bundle);

        SessionCallback getCallback();

        String getId();

        IBinder getLegacyBrowserServiceBinder();

        SessionPlayer getPlayer();

        PendingIntent getSessionActivity();

        MediaSessionCompat getSessionCompat();

        Uri getUri();

        boolean isClosed();
    }

    /* access modifiers changed from: package-private */
    public MediaSessionImpl getImpl() {
        return this.mImpl;
    }

    static MediaSession getSession(Uri uri) {
        synchronized (STATIC_LOCK) {
            for (MediaSession next : SESSION_ID_TO_SESSION_MAP.values()) {
                if (ObjectsCompat.equals(next.getUri(), uri)) {
                    return next;
                }
            }
            return null;
        }
    }

    public void close() {
        try {
            synchronized (STATIC_LOCK) {
                SESSION_ID_TO_SESSION_MAP.remove(this.mImpl.getId());
            }
            this.mImpl.close();
        } catch (Exception unused) {
        }
    }

    public boolean isClosed() {
        return this.mImpl.isClosed();
    }

    public SessionPlayer getPlayer() {
        return this.mImpl.getPlayer();
    }

    public String getId() {
        return this.mImpl.getId();
    }

    /* access modifiers changed from: package-private */
    public SessionCallback getCallback() {
        return this.mImpl.getCallback();
    }

    public MediaSessionCompat getSessionCompat() {
        return this.mImpl.getSessionCompat();
    }

    /* access modifiers changed from: package-private */
    public void handleControllerConnectionFromService(IMediaController iMediaController, String str, int i, int i2, Bundle bundle) {
        this.mImpl.connectFromService(iMediaController, str, i, i2, bundle);
    }

    /* access modifiers changed from: package-private */
    public IBinder getLegacyBrowerServiceBinder() {
        return this.mImpl.getLegacyBrowserServiceBinder();
    }

    private Uri getUri() {
        return this.mImpl.getUri();
    }

    public static abstract class SessionCallback {
        /* access modifiers changed from: package-private */
        public abstract void setForegroundServiceEventCallback(ForegroundServiceEventCallback foregroundServiceEventCallback);

        static abstract class ForegroundServiceEventCallback {
            ForegroundServiceEventCallback() {
            }
        }
    }

    public static final class ControllerInfo {
        private final ControllerCb mControllerCb;
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        ControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, boolean z, ControllerCb controllerCb, Bundle bundle) {
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mControllerCb, this.mRemoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.mControllerCb;
            if (controllerCb == null && controllerInfo.mControllerCb == null) {
                return this.mRemoteUserInfo.equals(controllerInfo.mRemoteUserInfo);
            }
            return ObjectsCompat.equals(controllerCb, controllerInfo.mControllerCb);
        }

        public String toString() {
            return "ControllerInfo {pkg=" + this.mRemoteUserInfo.getPackageName() + ", uid=" + this.mRemoteUserInfo.getUid() + "})";
        }
    }

    public static final class CommandButton implements VersionedParcelable {
        SessionCommand mCommand;
        CharSequence mDisplayName;
        boolean mEnabled;
        Bundle mExtras;
        int mIconResId;

        CommandButton() {
        }
    }
}
