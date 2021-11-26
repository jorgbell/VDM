package com.google.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzbbk;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class MediationServerParameters {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static final class MappingException extends Exception {
        public MappingException(@RecentlyNonNull String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    protected @interface Parameter {
        @RecentlyNonNull
        String name();

        boolean required() default true;
    }

    public void load(@RecentlyNonNull Map<String, String> map) throws MappingException {
        String str;
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzbbk.zzi("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry next : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(next.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, next.getValue());
                } catch (IllegalAccessException unused) {
                    String str2 = (String) next.getKey();
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 49);
                    sb.append("Server option \"");
                    sb.append(str2);
                    sb.append("\" could not be set: Illegal Access");
                    zzbbk.zzi(sb.toString());
                } catch (IllegalArgumentException unused2) {
                    String str3 = (String) next.getKey();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 43);
                    sb2.append("Server option \"");
                    sb2.append(str3);
                    sb2.append("\" could not be set: Bad Type");
                    zzbbk.zzi(sb2.toString());
                }
            } else {
                String str4 = (String) next.getKey();
                String str5 = (String) next.getValue();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str4).length() + 31 + String.valueOf(str5).length());
                sb3.append("Unexpected server option: ");
                sb3.append(str4);
                sb3.append(" = \"");
                sb3.append(str5);
                sb3.append("\"");
                zzbbk.zzd(sb3.toString());
            }
        }
        StringBuilder sb4 = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).required()) {
                String valueOf = String.valueOf(((Parameter) field3.getAnnotation(Parameter.class)).name());
                zzbbk.zzi(valueOf.length() != 0 ? "Required server option missing: ".concat(valueOf) : new String("Required server option missing: "));
                if (sb4.length() > 0) {
                    sb4.append(", ");
                }
                sb4.append(((Parameter) field3.getAnnotation(Parameter.class)).name());
            }
        }
        if (sb4.length() > 0) {
            String valueOf2 = String.valueOf(sb4.toString());
            if (valueOf2.length() != 0) {
                str = "Required server option(s) missing: ".concat(valueOf2);
            } else {
                str = new String("Required server option(s) missing: ");
            }
            throw new MappingException(str);
        }
    }
}
