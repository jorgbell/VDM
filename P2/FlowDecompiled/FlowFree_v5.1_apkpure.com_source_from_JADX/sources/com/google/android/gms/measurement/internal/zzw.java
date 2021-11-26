package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzce;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
abstract class zzw {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    zzw(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, zzck zzck, boolean z, String str2, List<String> list, String str3, zzem zzem) {
        if (zzck == zzck.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzck != zzck.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        zzcd zzcd = zzcd.UNKNOWN_COMPARISON_TYPE;
        switch (zzck.ordinal()) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzem != null) {
                        zzem.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zze(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean zzf(String str, zzcl zzcl, zzem zzem) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzcl);
        if (str == null || !zzcl.zza() || zzcl.zzb() == zzck.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzck zzb2 = zzcl.zzb();
        zzck zzck = zzck.IN_LIST;
        if (zzb2 == zzck) {
            if (zzcl.zzh() == 0) {
                return null;
            }
        } else if (!zzcl.zzc()) {
            return null;
        }
        zzck zzb3 = zzcl.zzb();
        boolean zzf2 = zzcl.zzf();
        if (zzf2 || zzb3 == zzck.REGEXP || zzb3 == zzck) {
            str2 = zzcl.zzd();
        } else {
            str2 = zzcl.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzcl.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg2 = zzcl.zzg();
            if (!zzf2) {
                ArrayList arrayList = new ArrayList(zzg2.size());
                for (String upperCase : zzg2) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzg2 = Collections.unmodifiableList(arrayList);
            }
            list = zzg2;
        }
        return zzd(str, zzb3, zzf2, str3, list, zzb3 == zzck.REGEXP ? str3 : null, zzem);
    }

    static Boolean zzg(long j, zzce zzce) {
        try {
            return zzj(new BigDecimal(j), zzce, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzh(double d, zzce zzce) {
        try {
            return zzj(new BigDecimal(d), zzce, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzi(String str, zzce zzce) {
        if (!zzkk.zzl(str)) {
            return null;
        }
        try {
            return zzj(new BigDecimal(str), zzce, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzj(BigDecimal bigDecimal, zzce zzce, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzce);
        if (zzce.zza() && zzce.zzb() != zzcd.UNKNOWN_COMPARISON_TYPE) {
            zzcd zzb2 = zzce.zzb();
            zzcd zzcd = zzcd.BETWEEN;
            if (zzb2 == zzcd) {
                if (!zzce.zzg() || !zzce.zzi()) {
                    return null;
                }
            } else if (!zzce.zze()) {
                return null;
            }
            zzcd zzb3 = zzce.zzb();
            if (zzce.zzb() == zzcd) {
                if (zzkk.zzl(zzce.zzh()) && zzkk.zzl(zzce.zzj())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzce.zzh());
                        bigDecimal3 = new BigDecimal(zzce.zzj());
                        bigDecimal2 = bigDecimal5;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!zzkk.zzl(zzce.zzf())) {
                return null;
            } else {
                try {
                    bigDecimal4 = new BigDecimal(zzce.zzf());
                    bigDecimal2 = null;
                    bigDecimal3 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (zzb3 == zzcd) {
                if (bigDecimal2 == null) {
                    return null;
                }
            } else if (bigDecimal4 == null) {
                return null;
            }
            zzck zzck = zzck.UNKNOWN_MATCH_TYPE;
            int ordinal = zzb3.ordinal();
            boolean z = true;
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4 || bigDecimal2 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (d != 0.0d) {
                            if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d).multiply(new BigDecimal(2)))) >= 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                        if (bigDecimal.compareTo(bigDecimal4) != 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            } else if (bigDecimal4 == null) {
                return null;
            } else {
                if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc();
}
