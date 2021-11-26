package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;

/* renamed from: com.applovin.impl.sdk.utils.l */
public class C1152l {

    /* renamed from: a */
    private final StringBuilder f2473a = new StringBuilder();

    /* renamed from: a */
    public C1152l mo9643a() {
        this.f2473a.append("\n========================================");
        return this;
    }

    /* renamed from: a */
    public C1152l mo9644a(AppLovinAdView appLovinAdView) {
        return mo9649a("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).mo9649a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).mo9649a("Visibility", C1163s.m2770b(appLovinAdView.getVisibility()));
    }

    /* renamed from: a */
    public C1152l mo9645a(C0733a aVar) {
        return mo9649a("Network", aVar.mo8444K()).mo9649a("Format", aVar.getFormat().getLabel()).mo9649a("Ad Unit ID", aVar.getAdUnitId()).mo9649a("Placement", aVar.getPlacement()).mo9649a("Network Placement", aVar.mo8401i()).mo9649a("Serve ID", aVar.mo8390e()).mo9649a("Creative ID", C1155o.m2673b(aVar.getCreativeId()) ? aVar.getCreativeId() : "None").mo9649a("Server Parameters", aVar.mo8450Q());
    }

    /* renamed from: a */
    public C1152l mo9646a(C0934g gVar) {
        boolean z = gVar instanceof C0536a;
        mo9649a("Format", gVar.getAdZone().mo8973b() != null ? gVar.getAdZone().mo8973b().getLabel() : null).mo9649a("Ad ID", Long.valueOf(gVar.getAdIdNumber())).mo9649a("Zone ID", gVar.getAdZone().mo8972a()).mo9649a("Source", gVar.getSource()).mo9649a("Ad Class", z ? "VastAd" : "AdServerAd");
        String q = gVar.mo9065q();
        if (C1155o.m2673b(q)) {
            mo9649a("DSP Name", q);
        }
        if (z) {
            mo9649a("VAST DSP", ((C0536a) gVar).mo7836k());
        }
        return this;
    }

    /* renamed from: a */
    public C1152l mo9647a(C1062k kVar) {
        return mo9649a("Muted", Boolean.valueOf(kVar.mo9400p().isMuted()));
    }

    /* renamed from: a */
    public C1152l mo9648a(String str) {
        StringBuilder sb = this.f2473a;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    /* renamed from: a */
    public C1152l mo9649a(String str, Object obj) {
        return mo9650a(str, obj, "");
    }

    /* renamed from: a */
    public C1152l mo9650a(String str, Object obj, String str2) {
        StringBuilder sb = this.f2473a;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    /* renamed from: b */
    public C1152l mo9651b(C0934g gVar) {
        mo9649a("Target", gVar.mo9064p()).mo9649a("close_style", gVar.mo9069u()).mo9650a("close_delay_graphic", Long.valueOf(gVar.mo9068t()), "s");
        if (gVar.hasVideoUrl()) {
            mo9650a("close_delay", Long.valueOf(gVar.mo9066r()), "s").mo9649a("skip_style", gVar.mo9070v()).mo9649a("Streaming", Boolean.valueOf(gVar.mo7826e())).mo9649a("Video Location", gVar.mo7825d()).mo9649a("video_button_properties", gVar.mo8994B());
        }
        return this;
    }

    /* renamed from: b */
    public C1152l mo9652b(String str) {
        this.f2473a.append(str);
        return this;
    }

    public String toString() {
        return this.f2473a.toString();
    }
}
