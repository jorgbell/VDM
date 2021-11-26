package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zaj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object zaa = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> zab = new HashSet<>();
    /* access modifiers changed from: private */
    public final Context zad;
    /* access modifiers changed from: private */
    public final Handler zae;
    /* access modifiers changed from: private */
    public final ExecutorService zaf;
    /* access modifiers changed from: private */
    public final zaj zah;
    /* access modifiers changed from: private */
    public final Map<zab, ImageReceiver> zai;
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zaj;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zak;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    private final class zac implements Runnable {
        private final Uri zaa;
        private final ParcelFileDescriptor zab;
        private final /* synthetic */ ImageManager zac;

        public zac(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zaa = uri;
            this.zab = parcelFileDescriptor;
        }

        public final void run() {
            boolean z;
            Bitmap bitmap;
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.zab;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.zaa);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                }
                try {
                    this.zab.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zac.zae.post(new zad(this.zac, this.zaa, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.zaa);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    private final class zad implements Runnable {
        private final Uri zaa;
        private final Bitmap zab;
        private final CountDownLatch zac;
        private final /* synthetic */ ImageManager zae;

        public zad(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zaa = uri;
            this.zab = bitmap;
            this.zac = countDownLatch;
        }

        public final void run() {
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.zab != null;
            ImageReceiver imageReceiver = (ImageReceiver) this.zae.zaj.remove(this.zaa);
            if (imageReceiver != null) {
                ArrayList zaa2 = imageReceiver.zab;
                int size = zaa2.size();
                for (int i = 0; i < size; i++) {
                    zab zab2 = (zab) zaa2.get(i);
                    if (this.zab == null || !z) {
                        this.zae.zak.put(this.zaa, Long.valueOf(SystemClock.elapsedRealtime()));
                        zab2.zaa(this.zae.zad, this.zae.zah, false);
                    } else {
                        zab2.zaa(this.zae.zad, this.zab, false);
                    }
                    this.zae.zai.remove(zab2);
                }
            }
            this.zac.countDown();
            synchronized (ImageManager.zaa) {
                ImageManager.zab.remove(this.zaa);
            }
        }
    }

    @KeepName
    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    private final class ImageReceiver extends ResultReceiver {
        private final Uri zaa;
        /* access modifiers changed from: private */
        public final ArrayList<zab> zab;
        private final /* synthetic */ ImageManager zac;

        public final void onReceiveResult(int i, Bundle bundle) {
            this.zac.zaf.execute(new zac(this.zac, this.zaa, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }
}
