package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzpq;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzpp<T extends zzpq> extends Handler implements Runnable {
    public final int zza;
    final /* synthetic */ zzps zzb;
    private final T zzc;
    private final zzpo<T> zzd;
    private final long zze;
    private IOException zzf;
    private int zzg;
    private volatile Thread zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzpp(zzps zzps, Looper looper, T t, zzpo<T> zzpo, int i, long j) {
        super(looper);
        this.zzb = zzps;
        this.zzc = t;
        this.zzd = zzpo;
        this.zza = i;
        this.zze = j;
    }

    private final void zzd() {
        this.zzf = null;
        this.zzb.zza.execute(this.zzb.zzb);
    }

    public final void handleMessage(Message message) {
        if (!this.zzi) {
            int i = message.what;
            if (i == 0) {
                zzd();
            } else if (i != 4) {
                zzpp unused = this.zzb.zzb = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zze;
                if (this.zzc.zzc()) {
                    this.zzd.zzr(this.zzc, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                int i3 = 1;
                if (i2 == 1) {
                    this.zzd.zzr(this.zzc, elapsedRealtime, j, false);
                } else if (i2 == 2) {
                    this.zzd.zzs(this.zzc, elapsedRealtime, j);
                } else if (i2 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zzf = iOException;
                    int zzq = this.zzd.zzq(this.zzc, elapsedRealtime, j, iOException);
                    if (zzq == 3) {
                        IOException unused2 = this.zzb.zzc = this.zzf;
                    } else if (zzq != 2) {
                        if (zzq != 1) {
                            i3 = 1 + this.zzg;
                        }
                        this.zzg = i3;
                        zzb((long) Math.min((i3 - 1) * 1000, 5000));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        try {
            this.zzh = Thread.currentThread();
            if (!this.zzc.zzc()) {
                String valueOf = String.valueOf(this.zzc.getClass().getSimpleName());
                zzqh.zza(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                this.zzc.zzd();
                zzqh.zzb();
            }
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzpu.zzd(this.zzc.zzc());
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.zzi) {
                obtainMessage(3, new zzpr(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.zzi) {
                obtainMessage(3, new zzpr(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzi) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzqh.zzb();
            throw th;
        }
    }

    public final void zza(int i) throws IOException {
        IOException iOException = this.zzf;
        if (iOException != null && this.zzg > i) {
            throw iOException;
        }
    }

    public final void zzb(long j) {
        zzpu.zzd(this.zzb.zzb == null);
        zzpp unused = this.zzb.zzb = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zzf = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
                return;
            }
        } else {
            this.zzc.zzb();
            if (this.zzh != null) {
                this.zzh.interrupt();
            }
            if (!z) {
                return;
            }
        }
        zzpp unused = this.zzb.zzb = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzd.zzr(this.zzc, elapsedRealtime, elapsedRealtime - this.zze, true);
    }
}
