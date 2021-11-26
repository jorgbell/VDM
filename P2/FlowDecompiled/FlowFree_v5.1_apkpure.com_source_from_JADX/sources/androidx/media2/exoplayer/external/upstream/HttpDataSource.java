package androidx.media2.exoplayer.external.upstream;

import androidx.media2.exoplayer.external.upstream.DataSource;
import androidx.media2.exoplayer.external.util.Predicate;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface HttpDataSource extends DataSource {

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements DataSource.Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        /* access modifiers changed from: protected */
        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }
    }

    static {
        Predicate predicate = HttpDataSource$$Lambda$0.$instance;
    }

    public static class HttpDataSourceException extends IOException {
        public HttpDataSourceException(String str, DataSpec dataSpec, int i) {
            super(str);
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i) {
            super(iOException);
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i) {
            super(str, iOException);
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidContentTypeException(java.lang.String r3, androidx.media2.exoplayer.external.upstream.DataSpec r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "Invalid content type: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r0 = 1
                r2.<init>((java.lang.String) r3, (androidx.media2.exoplayer.external.upstream.DataSpec) r4, (int) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.exoplayer.external.upstream.HttpDataSource.InvalidContentTypeException.<init>(java.lang.String, androidx.media2.exoplayer.external.upstream.DataSpec):void");
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final int responseCode;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidResponseCodeException(int r1, java.lang.String r2, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3, androidx.media2.exoplayer.external.upstream.DataSpec r4) {
            /*
                r0 = this;
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 26
                r2.<init>(r3)
                java.lang.String r3 = "Response code: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r2 = r2.toString()
                r3 = 1
                r0.<init>((java.lang.String) r2, (androidx.media2.exoplayer.external.upstream.DataSpec) r4, (int) r3)
                r0.responseCode = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.exoplayer.external.upstream.HttpDataSource.InvalidResponseCodeException.<init>(int, java.lang.String, java.util.Map, androidx.media2.exoplayer.external.upstream.DataSpec):void");
        }
    }
}
