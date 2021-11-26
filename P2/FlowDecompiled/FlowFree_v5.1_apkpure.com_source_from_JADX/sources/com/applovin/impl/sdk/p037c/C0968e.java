package com.applovin.impl.sdk.p037c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1160r;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.e */
public final class C0968e {

    /* renamed from: a */
    private static C1062k f1874a;

    /* renamed from: b */
    private static SharedPreferences f1875b;

    /* renamed from: c */
    private final SharedPreferences f1876c;

    public C0968e(C1062k kVar) {
        this.f1876c = kVar.mo9334J().getSharedPreferences("com.applovin.sdk.preferences." + kVar.mo9409x(), 0);
        if (!kVar.mo9389e()) {
            f1874a = kVar;
        }
    }

    /* renamed from: a */
    private static SharedPreferences m1765a(Context context) {
        if (f1875b == null) {
            f1875b = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f1875b;
    }

    /* renamed from: a */
    public static <T> T m1766a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        T t2;
        long j;
        int i;
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    t2 = Boolean.valueOf(t != null ? sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()) : sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    t2 = Float.valueOf(t != null ? sharedPreferences.getFloat(str, ((Float) t).floatValue()) : sharedPreferences.getFloat(str, 0.0f));
                } else if (cls3.equals(cls)) {
                    if (t != null) {
                        i = sharedPreferences.getInt(str, t.getClass().equals(cls2) ? ((Long) t).intValue() : ((Integer) t).intValue());
                    } else {
                        i = sharedPreferences.getInt(str, 0);
                    }
                    t2 = Integer.valueOf(i);
                } else if (cls2.equals(cls)) {
                    if (t != null) {
                        j = sharedPreferences.getLong(str, t.getClass().equals(cls3) ? ((Integer) t).longValue() : ((Long) t).longValue());
                    } else {
                        j = sharedPreferences.getLong(str, 0);
                    }
                    t2 = Long.valueOf(j);
                } else {
                    t2 = String.class.equals(cls) ? sharedPreferences.getString(str, (String) t) : Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) t) : t;
                }
                if (t2 != null) {
                    return cls.cast(t2);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t;
        } catch (Throwable th) {
            C1107r.m2480c("SharedPreferencesManager", "Error getting value for key: " + str, th);
            return t;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: a */
    private static void m1767a(final SharedPreferences.Editor editor) {
        try {
            C1062k kVar = f1874a;
            if (kVar != null && ((Boolean) kVar.mo9350a(C0965b.f1791eG)).booleanValue()) {
                if (!C1160r.m2744b()) {
                    editor.commit();
                    return;
                } else if (f1874a.mo9340Q() != null) {
                    f1874a.mo9340Q().mo9266a((C0989a) new C1042y(f1874a, new Runnable() {
                        public void run() {
                            editor.commit();
                        }
                    }), C1020o.C1022a.BACKGROUND);
                    return;
                }
            }
            editor.apply();
        } catch (Throwable th) {
            C1107r.m2480c("SharedPreferencesManager", "Unable to apply changes", th);
        }
    }

    /* renamed from: a */
    public static <T> void m1768a(C0967d<T> dVar, Context context) {
        m1767a(m1765a(context).edit().remove(dVar.mo9130a()));
    }

    /* renamed from: a */
    public static <T> void m1769a(C0967d<T> dVar, T t, Context context) {
        m1770a(dVar.mo9130a(), t, m1765a(context), (SharedPreferences.Editor) null);
    }

    /* renamed from: a */
    public static <T> void m1770a(String str, T t, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z = true;
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (t == null) {
            editor.remove(str);
        } else if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        } else if (t instanceof String) {
            editor.putString(str, (String) t);
        } else if (t instanceof Set) {
            editor.putStringSet(str, (Set) t);
        } else {
            C1107r.m2484i("SharedPreferencesManager", "Unable to put default value of invalid type: " + t);
            z = false;
        }
        if (z && !z2) {
            m1767a(editor);
        }
    }

    /* renamed from: b */
    public static <T> T m1771b(C0967d<T> dVar, T t, Context context) {
        return m1766a(dVar.mo9130a(), t, (Class) dVar.mo9131b(), m1765a(context));
    }

    /* renamed from: a */
    public void mo9133a(SharedPreferences sharedPreferences) {
        m1767a(sharedPreferences.edit().clear());
    }

    /* renamed from: a */
    public <T> void mo9134a(C0967d<T> dVar) {
        m1767a(this.f1876c.edit().remove(dVar.mo9130a()));
    }

    /* renamed from: a */
    public <T> void mo9135a(C0967d<T> dVar, T t) {
        mo9136a(dVar, t, this.f1876c);
    }

    /* renamed from: a */
    public <T> void mo9136a(C0967d<T> dVar, T t, SharedPreferences sharedPreferences) {
        mo9138a(dVar.mo9130a(), t, sharedPreferences);
    }

    /* renamed from: a */
    public <T> void mo9137a(String str, T t, SharedPreferences.Editor editor) {
        m1770a(str, t, (SharedPreferences) null, editor);
    }

    /* renamed from: a */
    public <T> void mo9138a(String str, T t, SharedPreferences sharedPreferences) {
        m1770a(str, t, sharedPreferences, (SharedPreferences.Editor) null);
    }

    /* renamed from: b */
    public <T> T mo9139b(C0967d<T> dVar, T t) {
        return mo9140b(dVar, t, this.f1876c);
    }

    /* renamed from: b */
    public <T> T mo9140b(C0967d<T> dVar, T t, SharedPreferences sharedPreferences) {
        return m1766a(dVar.mo9130a(), t, (Class) dVar.mo9131b(), sharedPreferences);
    }
}
