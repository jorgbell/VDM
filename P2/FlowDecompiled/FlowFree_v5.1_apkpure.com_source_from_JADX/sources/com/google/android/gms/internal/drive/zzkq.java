package com.google.android.gms.internal.drive;

import java.io.IOException;

public class zzkq extends IOException {
    public zzkq(String str) {
        super(str);
    }

    static zzkq zzdi() {
        return new zzkq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzkq zzdj() {
        return new zzkq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzkr zzdl() {
        return new zzkr("Protocol message tag had invalid wire type.");
    }
}
