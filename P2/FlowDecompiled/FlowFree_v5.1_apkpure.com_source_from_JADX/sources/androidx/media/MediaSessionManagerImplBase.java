package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean DEBUG = MediaSessionManager.DEBUG;
    ContentResolver mContentResolver;
    Context mContext;

    MediaSessionManagerImplBase(Context context) {
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        try {
            if (this.mContext.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0) == null) {
                return false;
            }
            if (isPermissionGranted(remoteUserInfoImpl, "android.permission.STATUS_BAR_SERVICE") || isPermissionGranted(remoteUserInfoImpl, "android.permission.MEDIA_CONTENT_CONTROL") || remoteUserInfoImpl.getUid() == 1000 || isEnabledNotificationListener(remoteUserInfoImpl)) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            if (DEBUG) {
                Log.d("MediaSessionManager", "Package " + remoteUserInfoImpl.getPackageName() + " doesn't exist");
            }
            return false;
        }
    }

    private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, String str) {
        if (remoteUserInfoImpl.getPid() < 0) {
            if (this.mContext.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0) {
                return true;
            }
            return false;
        } else if (this.mContext.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isEnabledNotificationListener(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        String string = Settings.Secure.getString(this.mContentResolver, "enabled_notification_listeners");
        if (string != null) {
            String[] split = string.split(":");
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null && unflattenFromString2.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
        private String mPackageName;
        private int mPid;
        private int mUid;

        RemoteUserInfoImplBase(String str, int i, int i2) {
            this.mPackageName = str;
            this.mPid = i;
            this.mUid = i2;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public int getPid() {
            return this.mPid;
        }

        public int getUid() {
            return this.mUid;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
            if (this.mPid == -1 || remoteUserInfoImplBase.mPid == -1) {
                if (!TextUtils.equals(this.mPackageName, remoteUserInfoImplBase.mPackageName) || this.mUid != remoteUserInfoImplBase.mUid) {
                    return false;
                }
                return true;
            } else if (TextUtils.equals(this.mPackageName, remoteUserInfoImplBase.mPackageName) && this.mPid == remoteUserInfoImplBase.mPid && this.mUid == remoteUserInfoImplBase.mUid) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mPackageName, Integer.valueOf(this.mUid));
        }
    }
}
