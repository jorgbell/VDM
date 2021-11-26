package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeaa {
    public static boolean zza(zzhp zzhp) {
        zzhp zzhp2 = zzhp.UNSUPPORTED;
        int ordinal = zzhp.ordinal();
        return ordinal == 1 || ordinal == 2 || ordinal == 3 || ordinal == 4;
    }

    public static final zzhp zzb(Context context, zzdyu zzdyu) {
        zzhp zzhp;
        FileInputStream fileInputStream;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            if (zzdyu != null) {
                zzdyu.zzf(5017, "No lib/");
            }
            zzhp = zzhp.UNKNOWN;
        } else {
            File[] listFiles = file.listFiles(new zzeed(Pattern.compile(".*\\.so$", 2)));
            if (listFiles == null || listFiles.length == 0) {
                if (zzdyu != null) {
                    zzdyu.zzf(5017, "No .so");
                }
                zzhp = zzhp.UNKNOWN;
            } else {
                try {
                    fileInputStream = new FileInputStream(listFiles[0]);
                    byte[] bArr = new byte[20];
                    if (fileInputStream.read(bArr) == 20) {
                        byte[] bArr2 = {0, 0};
                        if (bArr[5] == 2) {
                            zzc(bArr, (String) null, context, zzdyu);
                            zzhp = zzhp.UNSUPPORTED;
                        } else {
                            bArr2[0] = bArr[19];
                            bArr2[1] = bArr[18];
                            short s = ByteBuffer.wrap(bArr2).getShort();
                            if (s == 3) {
                                zzhp = zzhp.X86;
                            } else if (s == 40) {
                                zzhp = zzhp.ARM7;
                            } else if (s == 62) {
                                zzhp = zzhp.X86_64;
                            } else if (s != 183) {
                                zzc(bArr, (String) null, context, zzdyu);
                                zzhp = zzhp.UNSUPPORTED;
                            } else {
                                zzhp = zzhp.ARM64;
                            }
                        }
                        fileInputStream.close();
                    } else {
                        fileInputStream.close();
                        zzhp = zzhp.UNSUPPORTED;
                    }
                } catch (IOException e) {
                    zzc((byte[]) null, e.toString(), context, zzdyu);
                } catch (Throwable th) {
                    zzerm.zza(th, th);
                }
            }
        }
        if (zzhp == zzhp.UNKNOWN) {
            String zzd = zzd(context, zzdyu);
            if (TextUtils.isEmpty(zzd)) {
                zzc((byte[]) null, "Empty dev arch", context, zzdyu);
                zzhp = zzhp.UNSUPPORTED;
            } else if (zzd.equalsIgnoreCase("i686") || zzd.equalsIgnoreCase("x86")) {
                zzhp = zzhp.X86;
            } else if (zzd.equalsIgnoreCase("x86_64")) {
                zzhp = zzhp.X86_64;
            } else if (zzd.equalsIgnoreCase("arm64-v8a")) {
                zzhp = zzhp.ARM64;
            } else if (zzd.equalsIgnoreCase("armeabi-v7a") || zzd.equalsIgnoreCase("armv71")) {
                zzhp = zzhp.ARM7;
            } else {
                zzc((byte[]) null, zzd, context, zzdyu);
                zzhp = zzhp.UNSUPPORTED;
            }
        }
        if (zzdyu != null) {
            zzdyu.zzf(5018, zzhp.name());
        }
        return zzhp;
        throw th;
    }

    private static final void zzc(byte[] bArr, String str, Context context, zzdyu zzdyu) {
        if (zzdyu != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("os.arch:");
            sb.append(zzecr.OS_ARCH.zza());
            sb.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
                if (strArr != null) {
                    sb.append("supported_abis:");
                    sb.append(Arrays.toString(strArr));
                    sb.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            sb.append("CPU_ABI:");
            sb.append(Build.CPU_ABI);
            sb.append(";CPU_ABI2:");
            sb.append(Build.CPU_ABI2);
            sb.append(";");
            if (bArr != null) {
                sb.append("ELF:");
                sb.append(Arrays.toString(bArr));
                sb.append(";");
            }
            if (str != null) {
                sb.append("dbg:");
                sb.append(str);
                sb.append(";");
            }
            zzdyu.zzf(4007, sb.toString());
        }
    }

    private static final String zzd(Context context, zzdyu zzdyu) {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String zza = zzecr.OS_ARCH.zza();
        if (!TextUtils.isEmpty(zza) && hashSet.contains(zza)) {
            return zza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            if (zzdyu != null) {
                zzdyu.zzd(2024, 0, e);
            }
        } catch (IllegalAccessException e2) {
            if (zzdyu != null) {
                zzdyu.zzd(2024, 0, e2);
            }
        }
        String str = Build.CPU_ABI;
        return str != null ? str : Build.CPU_ABI2;
    }
}
