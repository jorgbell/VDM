package com.google.android.gms.internal.drive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzky extends zziw<String> implements zzkz, RandomAccess {
    private static final zzky zztk;
    private final List<Object> zziu;

    public zzky() {
        this(10);
    }

    public zzky(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzky(ArrayList<Object> arrayList) {
        this.zziu = arrayList;
    }

    public final int size() {
        return this.zziu.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbq();
        if (collection instanceof zzkz) {
            collection = ((zzkz) collection).zzdr();
        }
        boolean addAll = this.zziu.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbq();
        this.zziu.clear();
        this.modCount++;
    }

    public final Object zzao(int i) {
        return this.zziu.get(i);
    }

    private static String zzf(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzjc) {
            return ((zzjc) obj).zzbt();
        }
        return zzkm.zze((byte[]) obj);
    }

    public final List<?> zzdr() {
        return Collections.unmodifiableList(this.zziu);
    }

    public final zzkz zzds() {
        return zzbo() ? new zzna(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzbq();
        return zzf(this.zziu.set(i, (String) obj));
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        Object remove = this.zziu.remove(i);
        this.modCount++;
        return zzf(remove);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzbq();
        this.zziu.add(i, (String) obj);
        this.modCount++;
    }

    public final /* synthetic */ zzkp zzr(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zziu);
            return new zzky((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zziu.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzjc) {
            zzjc zzjc = (zzjc) obj;
            String zzbt = zzjc.zzbt();
            if (zzjc.zzbu()) {
                this.zziu.set(i, zzbt);
            }
            return zzbt;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzkm.zze(bArr);
        if (zzkm.zzd(bArr)) {
            this.zziu.set(i, zze);
        }
        return zze;
    }

    static {
        zzky zzky = new zzky();
        zztk = zzky;
        zzky.zzbp();
    }
}
