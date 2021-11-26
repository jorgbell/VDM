package com.applovin.impl.mediation.debugger.p028ui.p033d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.sdk.C1199R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.d */
public abstract class C0850d extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a */
    private final LayoutInflater f1151a;

    /* renamed from: b */
    private List<C0846c> f1152b = new ArrayList();
    /* access modifiers changed from: protected */

    /* renamed from: c */
    public final Context f1153c;

    /* renamed from: d */
    private Map<Integer, Integer> f1154d = new HashMap();

    /* renamed from: e */
    private C0851a f1155e;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.d$a */
    public interface C0851a {
        /* renamed from: a */
        void mo8627a(C0844a aVar, C0846c cVar);
    }

    protected C0850d(Context context) {
        this.f1153c = context;
        this.f1151a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: e */
    private C0844a m1350e(int i) {
        for (int i2 = 0; i2 < mo8633b(); i2++) {
            Integer num = this.f1154d.get(Integer.valueOf(i2));
            if (num != null) {
                if (i <= num.intValue() + mo8631a(i2)) {
                    return new C0844a(i2, i - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo8631a(int i);

    /* renamed from: a */
    public void mo8704a(C0851a aVar) {
        this.f1155e = aVar;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo8633b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract C0846c mo8634b(int i);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract List<C0846c> mo8635c(int i);

    /* renamed from: d */
    public C0846c getItem(int i) {
        return this.f1152b.get(i);
    }

    public int getCount() {
        return this.f1152b.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return getItem(i).mo8682i();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0845b bVar;
        C0846c d = getItem(i);
        if (view == null) {
            view = this.f1151a.inflate(d.mo8683j(), viewGroup, false);
            bVar = new C0845b();
            bVar.f1111a = (TextView) view.findViewById(16908308);
            bVar.f1112b = (TextView) view.findViewById(16908309);
            bVar.f1113c = (ImageView) view.findViewById(C1199R.C1201id.imageView);
            bVar.f1114d = (ImageView) view.findViewById(C1199R.C1201id.detailImageView);
            view.setTag(bVar);
            view.setOnClickListener(this);
        } else {
            bVar = (C0845b) view.getTag();
        }
        bVar.mo8679a(i);
        bVar.mo8680a(d);
        view.setEnabled(d.mo8637b());
        return view;
    }

    public int getViewTypeCount() {
        return C0846c.m1319h();
    }

    public boolean isEnabled(int i) {
        return getItem(i).mo8637b();
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f1152b = new ArrayList();
        Integer valueOf = Integer.valueOf(mo8633b());
        this.f1154d = new HashMap(valueOf.intValue());
        Integer num = 0;
        for (int i = 0; i < valueOf.intValue(); i++) {
            Integer valueOf2 = Integer.valueOf(mo8631a(i));
            if (valueOf2.intValue() != 0) {
                this.f1152b.add(mo8634b(i));
                this.f1152b.addAll(mo8635c(i));
                this.f1154d.put(Integer.valueOf(i), num);
                num = Integer.valueOf(num.intValue() + valueOf2.intValue() + 1);
            }
        }
        this.f1152b.add(new C0852e(""));
    }

    public void onClick(View view) {
        C0845b bVar = (C0845b) view.getTag();
        C0846c b = bVar.mo8681b();
        C0844a e = m1350e(bVar.mo8678a());
        C0851a aVar = this.f1155e;
        if (aVar != null && e != null) {
            aVar.mo8627a(e, b);
        }
    }
}
