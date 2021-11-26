package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class Objects {

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static final class ToStringHelper {
        private final List<String> zza = new ArrayList();
        private final Object zzb;

        /* synthetic */ ToStringHelper(Object obj, zzag zzag) {
            Preconditions.checkNotNull(obj);
            this.zzb = obj;
        }

        @RecentlyNonNull
        public ToStringHelper add(@RecentlyNonNull String str, Object obj) {
            List<String> list = this.zza;
            Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(valueOf).length());
            sb.append(str);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @RecentlyNonNull
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzb.getClass().getSimpleName());
            sb.append('{');
            int size = this.zza.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.zza.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(@RecentlyNonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @RecentlyNonNull
    public static ToStringHelper toStringHelper(@RecentlyNonNull Object obj) {
        return new ToStringHelper(obj, (zzag) null);
    }
}
