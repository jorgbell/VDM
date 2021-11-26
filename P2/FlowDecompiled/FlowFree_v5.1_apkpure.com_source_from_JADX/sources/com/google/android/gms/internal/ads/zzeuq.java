package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeuq {
    static String zza(zzeuo zzeuo, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzeuo, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzevr.zza(zzesf.zzu((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzesf) {
                sb.append(": \"");
                sb.append(zzevr.zza((zzesf) obj));
                sb.append('\"');
            } else if (obj instanceof zzeth) {
                sb.append(" {");
                zzc((zzeth) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, "key", entry.getKey());
                zzb(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static void zzc(zzeuo zzeuo, StringBuilder sb, int i) {
        String str;
        boolean z;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzeuo.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str4 : treeSet) {
            String substring = str4.startsWith("get") ? str4.substring(3) : str4;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                if (valueOf2.length() != 0) {
                    str3 = valueOf.concat(valueOf2);
                } else {
                    str3 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str4);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzd(str3), zzeth.zzaA(method2, zzeuo, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                if (valueOf4.length() != 0) {
                    str2 = valueOf3.concat(valueOf4);
                } else {
                    str2 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str4);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzd(str2), zzeth.zzaA(method3, zzeuo, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(substring);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(substring.substring(1));
                String concat = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(substring);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(substring);
                if (valueOf10.length() != 0) {
                    str = "has".concat(valueOf10);
                } else {
                    str = new String("has");
                }
                Method method5 = (Method) hashMap.get(str);
                if (method4 != null) {
                    Object zzaA = zzeth.zzaA(method4, zzeuo, new Object[0]);
                    if (method5 == null) {
                        if (zzaA instanceof Boolean) {
                            if (!((Boolean) zzaA).booleanValue()) {
                            }
                        } else if (zzaA instanceof Integer) {
                            if (((Integer) zzaA).intValue() == 0) {
                            }
                        } else if (zzaA instanceof Float) {
                            if (((Float) zzaA).floatValue() == 0.0f) {
                            }
                        } else if (!(zzaA instanceof Double)) {
                            if (zzaA instanceof String) {
                                z = zzaA.equals("");
                            } else if (zzaA instanceof zzesf) {
                                z = zzaA.equals(zzesf.zzb);
                            } else if (zzaA instanceof zzeuo) {
                                if (zzaA == ((zzeuo) zzaA).zzbe()) {
                                }
                            } else if ((zzaA instanceof Enum) && ((Enum) zzaA).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (((Double) zzaA).doubleValue() == 0.0d) {
                        }
                    } else if (!((Boolean) zzeth.zzaA(method5, zzeuo, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i, zzd(concat), zzaA);
                }
            }
        }
        if (!(zzeuo instanceof zzete)) {
            zzevu zzevu = ((zzeth) zzeuo).zzc;
            if (zzevu != null) {
                zzevu.zzg(sb, i);
                return;
            }
            return;
        }
        zzesy zzesy = ((zzete) zzeuo).zzb;
        throw null;
    }

    private static final String zzd(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
