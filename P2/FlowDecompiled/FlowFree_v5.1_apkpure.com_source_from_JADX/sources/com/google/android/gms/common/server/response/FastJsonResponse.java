package com.google.android.gms.common.server.response;

import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class FastJsonResponse {

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public interface FieldConverter<I, O> {
        @RecentlyNonNull
        I zaa(@RecentlyNonNull O o);
    }

    @RecentlyNonNull
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    /* access modifiers changed from: protected */
    @RecentlyNullable
    public abstract Object getValueObject(@RecentlyNonNull String str);

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public abstract boolean isPrimitiveFieldSet(@RecentlyNonNull String str);

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public boolean isFieldSet(@RecentlyNonNull Field field) {
        if (field.zac != 11) {
            return isPrimitiveFieldSet(field.zae);
        }
        if (field.zad) {
            String str = field.zae;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        String str2 = field.zae;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();
        @RecentlyNonNull
        protected final int zaa;
        @RecentlyNonNull
        protected final boolean zab;
        @RecentlyNonNull
        protected final int zac;
        @RecentlyNonNull
        protected final boolean zad;
        @RecentlyNonNull
        protected final String zae;
        @RecentlyNonNull
        protected final int zaf;
        @RecentlyNullable
        protected final Class<? extends FastJsonResponse> zag;
        private final int zah;
        private final String zai;
        private zal zaj;
        /* access modifiers changed from: private */
        public FieldConverter<I, O> zak;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zaa zaa2) {
            this.zah = i;
            this.zaa = i2;
            this.zab = z;
            this.zac = i3;
            this.zad = z2;
            this.zae = str;
            this.zaf = i4;
            if (str2 == null) {
                this.zag = null;
                this.zai = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zai = str2;
            }
            if (zaa2 == null) {
                this.zak = null;
            } else {
                this.zak = zaa2.zaa();
            }
        }

        private Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            this.zah = 1;
            this.zaa = i;
            this.zab = z;
            this.zac = i2;
            this.zad = z2;
            this.zae = str;
            this.zaf = i3;
            this.zag = cls;
            if (cls == null) {
                this.zai = null;
            } else {
                this.zai = cls.getCanonicalName();
            }
            this.zak = fieldConverter;
        }

        @RecentlyNonNull
        public int getSafeParcelableFieldId() {
            return this.zaf;
        }

        private final String zae() {
            String str = this.zai;
            if (str == null) {
                return null;
            }
            return str;
        }

        @RecentlyNonNull
        public final boolean zab() {
            return this.zak != null;
        }

        public final void zaa(zal zal) {
            this.zaj = zal;
        }

        private final zaa zaf() {
            FieldConverter<I, O> fieldConverter = this.zak;
            if (fieldConverter == null) {
                return null;
            }
            return zaa.zaa(fieldConverter);
        }

        @RecentlyNonNull
        public final Map<String, Field<?, ?>> zad() {
            Preconditions.checkNotNull(this.zai);
            Preconditions.checkNotNull(this.zaj);
            Map<String, Field<?, ?>> zaa2 = this.zaj.zaa(this.zai);
            Preconditions.checkNotNull(zaa2);
            return zaa2;
        }

        @RecentlyNonNull
        public final I zab(@RecentlyNonNull O o) {
            Preconditions.checkNotNull(this.zak);
            return this.zak.zaa(o);
        }

        @RecentlyNonNull
        public static Field<Integer, Integer> forInteger(@RecentlyNonNull String str, @RecentlyNonNull int i) {
            return new Field(0, false, 0, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        public static Field<String, String> forString(@RecentlyNonNull String str, @RecentlyNonNull int i) {
            return new Field(7, false, 7, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(@RecentlyNonNull String str, @RecentlyNonNull int i) {
            return new Field(7, true, 7, true, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        public static Field<byte[], byte[]> forBase64(@RecentlyNonNull String str, @RecentlyNonNull int i) {
            return new Field(8, false, 8, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull Class<T> cls) {
            return new Field(11, false, 11, false, str, i, cls, (FieldConverter) null);
        }

        @RecentlyNonNull
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull Class<T> cls) {
            return new Field(11, true, 11, true, str, i, cls, (FieldConverter) null);
        }

        public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zah);
            SafeParcelWriter.writeInt(parcel, 2, this.zaa);
            SafeParcelWriter.writeBoolean(parcel, 3, this.zab);
            SafeParcelWriter.writeInt(parcel, 4, this.zac);
            SafeParcelWriter.writeBoolean(parcel, 5, this.zad);
            SafeParcelWriter.writeString(parcel, 6, this.zae, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, zae(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, zaf(), i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @RecentlyNonNull
        public String toString() {
            Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
            stringHelper.add("versionCode", Integer.valueOf(this.zah));
            stringHelper.add("typeIn", Integer.valueOf(this.zaa));
            stringHelper.add("typeInArray", Boolean.valueOf(this.zab));
            stringHelper.add("typeOut", Integer.valueOf(this.zac));
            stringHelper.add("typeOutArray", Boolean.valueOf(this.zad));
            stringHelper.add("outputFieldName", this.zae);
            stringHelper.add("safeParcelFieldId", Integer.valueOf(this.zaf));
            stringHelper.add("concreteTypeName", zae());
            Class<? extends FastJsonResponse> cls = this.zag;
            if (cls != null) {
                stringHelper.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.zak;
            if (fieldConverter != null) {
                stringHelper.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return stringHelper.toString();
        }
    }

    @RecentlyNonNull
    protected static <O, I> I zaa(@RecentlyNonNull Field<I, O> field, Object obj) {
        return field.zak != null ? field.zab(obj) : obj;
    }

    @RecentlyNonNull
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String next : fieldMappings.keySet()) {
            Field field = fieldMappings.get(next);
            if (isFieldSet(field)) {
                Object zaa = zaa(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(next);
                sb.append("\":");
                if (zaa != null) {
                    switch (field.zac) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.encode((byte[]) zaa));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe((byte[]) zaa));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) zaa);
                            break;
                        default:
                            if (!field.zab) {
                                zaa(sb, field, zaa);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) zaa;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        zaa(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @RecentlyNullable
    public Object getFieldValue(@RecentlyNonNull Field field) {
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        Preconditions.checkState(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.zae);
        boolean z = field.zad;
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void zaa(StringBuilder sb, Field field, Object obj) {
        int i = field.zaa;
        if (i == 11) {
            Class<? extends FastJsonResponse> cls = field.zag;
            Preconditions.checkNotNull(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else if (i == 7) {
            sb.append("\"");
            sb.append(JsonUtils.escapeString((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }
}
