package kotlin.jvm;

import java.util.Objects;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: JvmClassMapping.kt */
public final class JvmClassMappingKt {
    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$javaObjectType");
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            Objects.requireNonNull(jClass, "null cannot be cast to non-null type java.lang.Class<T>");
            return jClass;
        }
        String name = jClass.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        jClass = Double.class;
                        break;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        jClass = Integer.class;
                        break;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        jClass = Byte.class;
                        break;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        jClass = Character.class;
                        break;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        jClass = Long.class;
                        break;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        jClass = Void.class;
                        break;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        jClass = Boolean.class;
                        break;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        jClass = Float.class;
                        break;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        jClass = Short.class;
                        break;
                    }
                    break;
            }
        }
        Objects.requireNonNull(jClass, "null cannot be cast to non-null type java.lang.Class<T>");
        return jClass;
    }
}
