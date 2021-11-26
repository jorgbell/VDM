package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManagerImplBase;

class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    MediaSessionManagerImplApi28(Context context) {
        super(context);
        MediaSessionManager mediaSessionManager = (MediaSessionManager) context.getSystemService("media_session");
    }

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return super.isTrustedForMediaControl(remoteUserInfoImpl);
    }

    static final class RemoteUserInfoImplApi28 extends MediaSessionManagerImplBase.RemoteUserInfoImplBase {
        RemoteUserInfoImplApi28(String str, int i, int i2) {
            super(str, i, i2);
            new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }
    }
}
