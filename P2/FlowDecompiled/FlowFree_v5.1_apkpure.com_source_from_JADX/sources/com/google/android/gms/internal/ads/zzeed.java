package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeed implements FilenameFilter {
    private final Pattern zza;

    public zzeed(Pattern pattern) {
        Objects.requireNonNull(pattern);
        this.zza = pattern;
    }

    public final boolean accept(@NullableDecl File file, String str) {
        return this.zza.matcher(str).matches();
    }
}
