package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

/* renamed from: com.google.android.play.core.internal.bg */
public final class C2085bg<T> {

    /* renamed from: a */
    private final Object f5188a;

    /* renamed from: b */
    private final Field f5189b;

    /* renamed from: c */
    private final Class<T> f5190c;

    C2085bg(Object obj, Field field, Class<T> cls) {
        this.f5188a = obj;
        this.f5189b = field;
        this.f5190c = cls;
    }

    C2085bg(Object obj, Field field, Class cls, byte[] bArr) {
        this(obj, field, Array.newInstance(cls, 0).getClass());
    }

    /* renamed from: f */
    private Class m5216f() {
        return mo22056c().getType().getComponentType();
    }

    /* renamed from: a */
    public final T mo22054a() {
        try {
            return this.f5190c.cast(this.f5189b.get(this.f5188a));
        } catch (Exception e) {
            throw new C2087bi(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.f5189b.getName(), this.f5188a.getClass().getName(), this.f5190c.getName()}), e);
        }
    }

    /* renamed from: b */
    public final void mo22055b(T t) {
        try {
            this.f5189b.set(this.f5188a, t);
        } catch (Exception e) {
            throw new C2087bi(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.f5189b.getName(), this.f5188a.getClass().getName(), this.f5190c.getName()}), e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final Field mo22056c() {
        return this.f5189b;
    }

    /* renamed from: d */
    public void mo22057d(Collection collection) {
        Object[] objArr = (Object[]) mo22054a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(m5216f(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        mo22055b(objArr2);
    }

    /* renamed from: e */
    public void mo22058e(Collection collection) {
        Object[] objArr = (Object[]) mo22054a();
        int i = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(m5216f(), (objArr == null ? 0 : objArr.length) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i] = obj;
            i++;
        }
        mo22055b(objArr2);
    }
}
