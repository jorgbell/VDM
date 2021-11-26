package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.C0725c;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.network.C1094f;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.mopub.mobileads.applovin.BuildConfig;
import com.mopub.network.ImpressionData;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.g */
public class C1047g implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    private final C1062k f2127a;

    /* renamed from: b */
    private final AppLovinCommunicator f2128b;

    C1047g(C1062k kVar) {
        this.f2127a = kVar;
        AppLovinCommunicator instance = AppLovinCommunicator.getInstance(kVar.mo9334J());
        this.f2128b = instance;
        if (!kVar.mo9389e()) {
            instance.mo7799a(kVar);
            instance.subscribe((AppLovinCommunicatorSubscriber) this, C0725c.f728a);
        }
    }

    /* renamed from: b */
    private Bundle m2064b(C0733a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("id", aVar.mo8390e());
        bundle.putString(ImpressionData.NETWORK_NAME, aVar.mo8443J());
        bundle.putString("max_ad_unit_id", aVar.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", aVar.mo8401i());
        bundle.putString("ad_format", aVar.getFormat().getLabel());
        if (C1155o.m2673b(aVar.getCreativeId())) {
            bundle.putString("creative_id", aVar.getCreativeId());
        }
        bundle.putAll(C1123j.m2602c(aVar.mo8385a()));
        return bundle;
    }

    /* renamed from: a */
    public void mo9302a(Bundle bundle, String str) {
        if (!this.f2127a.mo9389e()) {
            this.f2128b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this, this.f2127a.mo9381b(C0965b.f1798eN).contains(str)));
        }
    }

    /* renamed from: a */
    public void mo9303a(C0733a aVar) {
        Bundle b = m2064b(aVar);
        b.putAll(C1123j.m2602c(aVar.mo8387b()));
        b.putString("country_code", this.f2127a.mo9402r().getCountryCode());
        mo9302a(b, "max_revenue_events");
    }

    /* renamed from: a */
    public void mo9304a(C0733a aVar, String str) {
        Bundle b = m2064b(aVar);
        b.putString("type", str);
        mo9302a(b, "max_ad_events");
    }

    /* renamed from: a */
    public void mo9305a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("adapter_class", str);
        bundle.putInt("init_status", initializationStatus.getCode());
        mo9302a(bundle, "adapter_initialization_status");
    }

    /* renamed from: a */
    public void mo9306a(String str, String str2, int i, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("url", str2);
        bundle.putInt("code", i);
        bundle.putBundle("body", C1123j.m2567a(obj));
        mo9302a(bundle, "receive_http_response");
    }

    /* renamed from: a */
    public void mo9307a(JSONObject jSONObject, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2127a.mo9409x());
        bundle.putString("applovin_random_token", this.f2127a.mo9399o());
        bundle.putString("compass_random_token", this.f2127a.mo9398n());
        bundle.putString("device_type", AppLovinSdkUtils.isTablet(this.f2127a.mo9334J()) ? "tablet" : "phone");
        bundle.putString("init_success", String.valueOf(z));
        bundle.putParcelableArrayList("installed_mediation_adapters", C1123j.m2572a(C0788c.m1111a(this.f2127a)));
        JSONObject b = C1123j.m2600b(jSONObject, "communicator_settings", new JSONObject(), this.f2127a);
        ((Bundle) bundle.clone()).putBundle("settings", C1123j.m2602c(C1123j.m2600b(b, "safedk_settings", new JSONObject(), this.f2127a)));
        mo9302a(bundle, "safedk_init");
        ((Bundle) bundle.clone()).putBundle("settings", C1123j.m2602c(C1123j.m2600b(b, "adjust_settings", new JSONObject(), this.f2127a)));
        mo9302a(bundle, "adjust_init");
    }

    public String getCommunicatorId() {
        return BuildConfig.NETWORK_NAME;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            Map<String, String> a = C1123j.m2575a(messageData.getBundle("query_params"));
            Map<String, Object> map = BundleUtils.toMap(messageData.getBundle("post_body"));
            Map<String, String> a2 = C1123j.m2575a(messageData.getBundle("headers"));
            String string = messageData.getString("id", "");
            if (!map.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2127a.mo9409x());
            }
            this.f2127a.mo9342S().mo9499a(new C1094f.C1096a().mo9528c(messageData.getString("url")).mo9531d(messageData.getString("backup_url")).mo9522a(a).mo9529c(map).mo9526b(a2).mo9523a(((Boolean) this.f2127a.mo9350a(C0965b.f1818ek)).booleanValue()).mo9521a(string).mo9524a());
        }
    }
}
