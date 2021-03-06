package androidx.media2.exoplayer.external.upstream;

import android.net.Uri;
import androidx.media2.exoplayer.external.util.Assertions;
import androidx.media2.exoplayer.external.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private boolean opened;
    private Uri uri;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    public long open(DataSpec dataSpec) throws FileDataSourceException {
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            transferInitializing(dataSpec);
            String path = uri2.getPath();
            Assertions.checkNotNull(path);
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.file = randomAccessFile;
            randomAccessFile.seek(dataSpec.position);
            long j = dataSpec.length;
            if (j == -1) {
                j = randomAccessFile.length() - dataSpec.position;
            }
            this.bytesRemaining = j;
            if (j >= 0) {
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.file;
            Util.castNonNull(randomAccessFile);
            int read = randomAccessFile.read(bArr, i, (int) Math.min(this.bytesRemaining, (long) i2));
            if (read > 0) {
                this.bytesRemaining -= (long) read;
                bytesTransferred(read);
            }
            return read;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public Uri getUri() {
        return this.uri;
    }

    public void close() throws FileDataSourceException {
        this.uri = null;
        try {
            RandomAccessFile randomAccessFile = this.file;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        } catch (Throwable th) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th;
        }
    }
}
