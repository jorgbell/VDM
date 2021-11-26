package com.unity3d.services.core.request;

import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class WebRequest {
    private ByteArrayOutputStream _baos;
    private String _body;
    private boolean _canceled;
    private int _connectTimeout;
    private long _contentLength;
    private Map<String, List<String>> _headers;
    private IWebRequestProgressListener _progressListener;
    private int _readTimeout;
    private String _requestType;
    private int _responseCode;
    private Map<String, List<String>> _responseHeaders;
    private URL _url;

    public enum RequestType {
        POST,
        GET,
        HEAD
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map) throws MalformedURLException {
        this(str, str2, map, 30000, 30000);
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map, int i, int i2) throws MalformedURLException {
        this._requestType = RequestType.GET.name();
        this._responseCode = -1;
        this._contentLength = -1;
        this._canceled = false;
        this._url = new URL(str);
        this._requestType = str2;
        this._headers = map;
        this._connectTimeout = i;
        this._readTimeout = i2;
    }

    public void cancel() {
        this._canceled = true;
    }

    public boolean isCanceled() {
        return this._canceled;
    }

    public URL getUrl() {
        return this._url;
    }

    public String getRequestType() {
        return this._requestType;
    }

    public String getBody() {
        return this._body;
    }

    public void setBody(String str) {
        this._body = str;
    }

    public String getQuery() {
        URL url = this._url;
        if (url != null) {
            return url.getQuery();
        }
        return null;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this._responseHeaders;
    }

    public Map<String, List<String>> getHeaders() {
        return this._headers;
    }

    public int getResponseCode() {
        return this._responseCode;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public void setConnectTimeout(int i) {
        this._connectTimeout = i;
    }

    public int getReadTimeout() {
        return this._readTimeout;
    }

    public void setReadTimeout(int i) {
        this._readTimeout = i;
    }

    public void setProgressListener(IWebRequestProgressListener iWebRequestProgressListener) {
        this._progressListener = iWebRequestProgressListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[SYNTHETIC, Splitter:B:27:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long makeStreamRequest(java.io.OutputStream r19) throws java.lang.Exception {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = "Error closing writer"
            java.net.HttpURLConnection r3 = r18.getHttpUrlConnectionWithHeaders()
            r0 = 1
            r3.setDoInput(r0)
            java.lang.String r4 = r18.getRequestType()
            com.unity3d.services.core.request.WebRequest$RequestType r5 = com.unity3d.services.core.request.WebRequest.RequestType.POST
            java.lang.String r5 = r5.name()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0088
            r3.setDoOutput(r0)
            r4 = 0
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ IOException -> 0x005a }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x005a }
            java.io.OutputStream r7 = r3.getOutputStream()     // Catch:{ IOException -> 0x005a }
            java.lang.String r8 = "UTF-8"
            r6.<init>(r7, r8)     // Catch:{ IOException -> 0x005a }
            r5.<init>(r6, r0)     // Catch:{ IOException -> 0x005a }
            java.lang.String r0 = r18.getBody()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            if (r0 != 0) goto L_0x003e
            java.lang.String r0 = r18.getQuery()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            r5.print(r0)     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            goto L_0x0045
        L_0x003e:
            java.lang.String r0 = r18.getBody()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            r5.print(r0)     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
        L_0x0045:
            r5.flush()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            r5.close()     // Catch:{ Exception -> 0x004c }
            goto L_0x0088
        L_0x004c:
            r0 = move-exception
            r3 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r2, r3)
            throw r3
        L_0x0052:
            r0 = move-exception
            r4 = r5
            goto L_0x007b
        L_0x0055:
            r0 = move-exception
            r4 = r5
            goto L_0x005b
        L_0x0058:
            r0 = move-exception
            goto L_0x007b
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            java.lang.String r3 = "Error while writing POST params"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x0058 }
            com.unity3d.services.core.request.NetworkIOException r3 = new com.unity3d.services.core.request.NetworkIOException     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r5.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = "Error writing POST params: "
            r5.append(r6)     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0058 }
            r5.append(r0)     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0058 }
            r3.<init>(r0)     // Catch:{ all -> 0x0058 }
            throw r3     // Catch:{ all -> 0x0058 }
        L_0x007b:
            if (r4 == 0) goto L_0x0087
            r4.close()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0087
        L_0x0081:
            r0 = move-exception
            r3 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r2, r3)
            throw r3
        L_0x0087:
            throw r0
        L_0x0088:
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x017f, RuntimeException -> 0x017d }
            r1._responseCode = r0     // Catch:{ IOException -> 0x017f, RuntimeException -> 0x017d }
            int r0 = r3.getContentLength()
            long r4 = (long) r0
            r1._contentLength = r4
            r6 = -1
            r2 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x00a5
            java.lang.String r0 = "X-OrigLength"
            int r0 = r3.getHeaderFieldInt(r0, r2)
            long r4 = (long) r0
            r1._contentLength = r4
        L_0x00a5:
            java.io.ByteArrayOutputStream r0 = r1._baos
            r4 = 0
            r6 = r19
            if (r0 == 0) goto L_0x00c0
            if (r0 != r6) goto L_0x00c0
            long r7 = r1._contentLength
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c0
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            long r6 = r1._contentLength
            int r7 = (int) r6
            r0.<init>(r7)
            r1._baos = r0
            r6 = r0
        L_0x00c0:
            java.util.Map r0 = r3.getHeaderFields()
            if (r0 == 0) goto L_0x00cc
            java.util.Map r0 = r3.getHeaderFields()
            r1._responseHeaders = r0
        L_0x00cc:
            java.io.InputStream r0 = r3.getInputStream()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d9
        L_0x00d1:
            r0 = move-exception
            r7 = r0
            java.io.InputStream r0 = r3.getErrorStream()
            if (r0 == 0) goto L_0x0162
        L_0x00d9:
            com.unity3d.services.core.request.IWebRequestProgressListener r7 = r1._progressListener
            if (r7 == 0) goto L_0x00ee
            java.net.URL r8 = r18.getUrl()
            java.lang.String r8 = r8.toString()
            long r9 = r1._contentLength
            int r11 = r1._responseCode
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12 = r1._responseHeaders
            r7.onRequestStart(r8, r9, r11, r12)
        L_0x00ee:
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream
            r7.<init>(r0)
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]
            r8 = 0
            r9 = 0
        L_0x00f9:
            boolean r10 = r18.isCanceled()
            if (r10 != 0) goto L_0x015b
            if (r9 == r2) goto L_0x015b
            int r9 = r7.read(r0)     // Catch:{ IOException -> 0x013e, Exception -> 0x0121 }
            if (r9 <= 0) goto L_0x00f9
            r6.write(r0, r8, r9)
            long r10 = (long) r9
            long r4 = r4 + r10
            com.unity3d.services.core.request.IWebRequestProgressListener r12 = r1._progressListener
            if (r12 == 0) goto L_0x00f9
            java.net.URL r10 = r18.getUrl()
            java.lang.String r13 = r10.toString()
            long r10 = r1._contentLength
            r14 = r4
            r16 = r10
            r12.onRequestProgress(r13, r14, r16)
            goto L_0x00f9
        L_0x0121:
            r0 = move-exception
            r2 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unknown Exception: "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x013e:
            r0 = move-exception
            r2 = r0
            com.unity3d.services.core.request.NetworkIOException r0 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Network exception: "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x015b:
            r3.disconnect()
            r6.flush()
            return r4
        L_0x0162:
            com.unity3d.services.core.request.NetworkIOException r0 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Can't open error stream: "
            r2.append(r3)
            java.lang.String r3 = r7.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x017d:
            r0 = move-exception
            goto L_0x0180
        L_0x017f:
            r0 = move-exception
        L_0x0180:
            com.unity3d.services.core.request.NetworkIOException r2 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Response code: "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            goto L_0x019c
        L_0x019b:
            throw r2
        L_0x019c:
            goto L_0x019b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.request.WebRequest.makeStreamRequest(java.io.OutputStream):long");
    }

    public String makeRequest() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this._baos = byteArrayOutputStream;
        makeStreamRequest(byteArrayOutputStream);
        return this._baos.toString("UTF-8");
    }

    private HttpURLConnection getHttpUrlConnectionWithHeaders() throws NetworkIOException, IllegalArgumentException {
        HttpURLConnection httpURLConnection;
        if (getUrl().toString().startsWith("https://")) {
            try {
                httpURLConnection = (HttpsURLConnection) getUrl().openConnection();
            } catch (IOException e) {
                throw new NetworkIOException("Open HTTPS connection: " + e.getMessage());
            }
        } else if (getUrl().toString().startsWith("http://")) {
            try {
                httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            } catch (IOException e2) {
                throw new NetworkIOException("Open HTTP connection: " + e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Invalid url-protocol in url: " + getUrl().toString());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(getConnectTimeout());
        httpURLConnection.setReadTimeout(getReadTimeout());
        try {
            httpURLConnection.setRequestMethod(getRequestType());
            if (getHeaders() != null && getHeaders().size() > 0) {
                for (String next : getHeaders().keySet()) {
                    for (String str : getHeaders().get(next)) {
                        DeviceLog.debug("Setting header: " + next + "=" + str);
                        httpURLConnection.setRequestProperty(next, str);
                    }
                }
            }
            return httpURLConnection;
        } catch (ProtocolException e3) {
            throw new NetworkIOException("Set Request Method: " + getRequestType() + ", " + e3.getMessage());
        }
    }
}
