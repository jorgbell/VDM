package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbs extends zzexu {
    private Date zza;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk = 1.0d;
    private float zzl = 1.0f;
    private zzeye zzm = zzeye.zzj;
    private long zzn;

    public zzbs() {
        super("mvhd");
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zza + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzd() {
        return this.zzi;
    }

    public final long zze() {
        return this.zzj;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        zzi(byteBuffer);
        if (zzh() == 1) {
            this.zza = zzexz.zza(zzbo.zzd(byteBuffer));
            this.zzh = zzexz.zza(zzbo.zzd(byteBuffer));
            this.zzi = zzbo.zza(byteBuffer);
            this.zzj = zzbo.zzd(byteBuffer);
        } else {
            this.zza = zzexz.zza(zzbo.zza(byteBuffer));
            this.zzh = zzexz.zza(zzbo.zza(byteBuffer));
            this.zzi = zzbo.zza(byteBuffer);
            this.zzj = zzbo.zza(byteBuffer);
        }
        this.zzk = zzbo.zze(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((float) ((short) ((bArr[1] & Constants.UNKNOWN) | ((short) ((bArr[0] << 8) & 65280))))) / 256.0f;
        zzbo.zzb(byteBuffer);
        zzbo.zza(byteBuffer);
        zzbo.zza(byteBuffer);
        this.zzm = zzeye.zza(byteBuffer);
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzbo.zza(byteBuffer);
    }
}
