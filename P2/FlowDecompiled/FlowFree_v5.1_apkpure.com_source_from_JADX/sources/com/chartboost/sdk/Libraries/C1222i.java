package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.chartboost.sdk.C1279f;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.i */
public class C1222i {

    /* renamed from: a */
    private C1223a f2684a;

    /* renamed from: b */
    private final C1279f f2685b;

    /* renamed from: c */
    private float f2686c = 1.0f;

    /* renamed from: com.chartboost.sdk.Libraries.i$a */
    public static class C1223a {

        /* renamed from: a */
        private int f2687a;

        /* renamed from: b */
        private final String f2688b;

        /* renamed from: c */
        private final File f2689c;

        /* renamed from: d */
        private Bitmap f2690d;

        /* renamed from: e */
        private final C1220g f2691e;

        /* renamed from: f */
        private int f2692f = -1;

        /* renamed from: g */
        private int f2693g = -1;

        public C1223a(String str, File file, C1220g gVar) {
            this.f2689c = file;
            this.f2688b = str;
            this.f2690d = null;
            this.f2687a = 1;
            this.f2691e = gVar;
        }

        /* renamed from: b */
        private void m2969b() {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.f2689c.getAbsolutePath(), options);
                this.f2692f = options.outWidth;
                this.f2693g = options.outHeight;
            } catch (Exception e) {
                CBLogging.m2904a("MemoryBitmap", "Error decoding file size", e);
            }
        }

        /* renamed from: a */
        public void mo10061a() {
            if (this.f2690d == null) {
                CBLogging.m2903a("MemoryBitmap", "Loading image '" + this.f2688b + "' from cache");
                byte[] b = this.f2691e.mo10050b(this.f2689c);
                if (b == null) {
                    CBLogging.m2905b("MemoryBitmap", "decode() - bitmap not found");
                    return;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(b, 0, b.length, options);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inDither = false;
                options2.inPurgeable = true;
                options2.inInputShareable = true;
                options2.inTempStorage = new byte[32768];
                options2.inSampleSize = 1;
                while (true) {
                    if (options2.inSampleSize >= 32) {
                        break;
                    }
                    try {
                        this.f2690d = BitmapFactory.decodeByteArray(b, 0, b.length, options2);
                        break;
                    } catch (OutOfMemoryError e) {
                        CBLogging.m2904a("MemoryBitmap", "OutOfMemoryError suppressed - trying larger sample size", e);
                        options2.inSampleSize *= 2;
                    } catch (Exception e2) {
                        CBLogging.m2904a("MemoryBitmap", "Exception raised decoding bitmap", e2);
                    }
                }
                this.f2687a = options2.inSampleSize;
            }
            return;
            if (this.f2690d == null) {
                this.f2689c.delete();
                throw new RuntimeException("Unable to decode " + this.f2688b);
            }
            this.f2687a = options2.inSampleSize;
        }

        /* renamed from: c */
        public Bitmap mo10062c() {
            if (this.f2690d == null) {
                mo10061a();
            }
            return this.f2690d;
        }

        /* renamed from: d */
        public int mo10063d() {
            Bitmap bitmap = this.f2690d;
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            int i = this.f2693g;
            if (i >= 0) {
                return i;
            }
            m2969b();
            return this.f2693g;
        }

        /* renamed from: e */
        public int mo10064e() {
            Bitmap bitmap = this.f2690d;
            if (bitmap != null) {
                return bitmap.getWidth();
            }
            int i = this.f2692f;
            if (i >= 0) {
                return i;
            }
            m2969b();
            return this.f2692f;
        }

        /* renamed from: f */
        public int mo10065f() {
            return this.f2687a;
        }
    }

    public C1222i(C1279f fVar) {
        this.f2685b = fVar;
    }

    /* renamed from: a */
    public boolean mo10055a(String str) {
        return mo10056a(this.f2685b.mo10340e(), str);
    }

    /* renamed from: b */
    public Bitmap mo10057b() {
        C1223a aVar = this.f2684a;
        if (aVar != null) {
            return aVar.mo10062c();
        }
        return null;
    }

    /* renamed from: c */
    public int mo10058c() {
        return this.f2684a.mo10063d() * this.f2684a.mo10065f();
    }

    /* renamed from: d */
    public int mo10059d() {
        return this.f2684a.mo10064e() * this.f2684a.mo10065f();
    }

    /* renamed from: e */
    public boolean mo10060e() {
        return this.f2684a != null;
    }

    /* renamed from: a */
    public boolean mo10056a(JSONObject jSONObject, String str) {
        JSONObject a = C1217e.m2936a(jSONObject, str);
        if (a == null) {
            return true;
        }
        String optString = a.optString("url");
        this.f2686c = (float) a.optDouble("scale", 1.0d);
        if (optString.isEmpty()) {
            return true;
        }
        String optString2 = a.optString("checksum");
        if (optString2.isEmpty()) {
            return false;
        }
        C1223a b = this.f2685b.f3004g.f2745k.mo10160b(optString2);
        this.f2684a = b;
        if (b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public float mo10054a() {
        return this.f2686c;
    }
}
