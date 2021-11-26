package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzett extends IOException {
    private zzeuo zza;

    public zzett(String str) {
        super(str);
    }

    static zzett zzb() {
        return new zzett("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzett zzc() {
        return new zzett("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzett zzd() {
        return new zzett("CodedInputStream encountered a malformed varint.");
    }

    static zzett zze() {
        return new zzett("Protocol message contained an invalid tag (zero).");
    }

    static zzett zzf() {
        return new zzett("Protocol message end-group tag did not match expected tag.");
    }

    static zzets zzg() {
        return new zzets("Protocol message tag had invalid wire type.");
    }

    static zzett zzh() {
        return new zzett("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzett zzi() {
        return new zzett("Failed to parse the message.");
    }

    static zzett zzj() {
        return new zzett("Protocol message had invalid UTF-8.");
    }

    public final zzett zza(zzeuo zzeuo) {
        this.zza = zzeuo;
        return this;
    }
}
