package androidx.media2.common;

import android.os.ParcelFileDescriptor;
import android.util.Log;

public class FileMediaItem extends MediaItem {
    boolean mClosed;
    long mFDLength = 576460752303423487L;
    long mFDOffset = 0;
    ParcelFileDescriptor mPFD;
    Integer mRefCount = new Integer(0);

    FileMediaItem() {
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mPFD;
    }

    public long getFileDescriptorOffset() {
        return this.mFDOffset;
    }

    public long getFileDescriptorLength() {
        return this.mFDLength;
    }

    public void increaseRefCount() {
        synchronized (this.mRefCount) {
            if (this.mClosed) {
                Log.w("FileMediaItem", "ParcelFileDescriptorClient is already closed.");
            } else {
                this.mRefCount = Integer.valueOf(this.mRefCount.intValue() + 1);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decreaseRefCount() {
        /*
            r6 = this;
            java.lang.Integer r0 = r6.mRefCount
            monitor-enter(r0)
            boolean r1 = r6.mClosed     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x0010
            java.lang.String r1 = "FileMediaItem"
            java.lang.String r2 = "ParcelFileDescriptorClient is already closed."
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x004f }
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return
        L_0x0010:
            java.lang.Integer r1 = r6.mRefCount     // Catch:{ all -> 0x004f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004f }
            r2 = 1
            int r1 = r1 - r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x004f }
            r6.mRefCount = r1     // Catch:{ all -> 0x004f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004f }
            if (r1 > 0) goto L_0x004d
            android.os.ParcelFileDescriptor r1 = r6.mPFD     // Catch:{ IOException -> 0x0030 }
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x002b:
            r6.mClosed = r2     // Catch:{ all -> 0x004f }
            goto L_0x004d
        L_0x002e:
            r1 = move-exception
            goto L_0x004a
        L_0x0030:
            r1 = move-exception
            java.lang.String r3 = "FileMediaItem"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r4.<init>()     // Catch:{ all -> 0x002e }
            java.lang.String r5 = "Failed to close the ParcelFileDescriptor "
            r4.append(r5)     // Catch:{ all -> 0x002e }
            android.os.ParcelFileDescriptor r5 = r6.mPFD     // Catch:{ all -> 0x002e }
            r4.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002e }
            android.util.Log.e(r3, r4, r1)     // Catch:{ all -> 0x002e }
            goto L_0x002b
        L_0x004a:
            r6.mClosed = r2     // Catch:{ all -> 0x004f }
            throw r1     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return
        L_0x004f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            goto L_0x0053
        L_0x0052:
            throw r1
        L_0x0053:
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.common.FileMediaItem.decreaseRefCount():void");
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.mRefCount) {
            z = this.mClosed;
        }
        return z;
    }
}
