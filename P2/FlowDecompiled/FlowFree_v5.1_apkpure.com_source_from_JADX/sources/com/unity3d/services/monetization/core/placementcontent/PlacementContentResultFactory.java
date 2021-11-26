package com.unity3d.services.monetization.core.placementcontent;

import com.unity3d.services.monetization.placementcontent.ads.ShowAdPlacementContent;
import com.unity3d.services.monetization.placementcontent.core.NoFillPlacementContent;
import com.unity3d.services.monetization.placementcontent.core.PlacementContent;
import com.unity3d.services.monetization.placementcontent.purchasing.PromoAdPlacementContent;
import java.util.Map;

public class PlacementContentResultFactory {

    public enum PlacementContentResultType {
        SHOW_AD,
        PROMO_AD,
        NO_FILL,
        CUSTOM;

        static PlacementContentResultType parse(String str) {
            if (str == null) {
                return CUSTOM;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return CUSTOM;
            }
        }
    }

    public static PlacementContent create(String str, Map<String, Object> map) {
        int i = C28791.f5620x294a2897[PlacementContentResultType.parse((String) map.get("type")).ordinal()];
        if (i == 1) {
            return new ShowAdPlacementContent(str, map);
        }
        if (i == 2) {
            return new PromoAdPlacementContent(str, map);
        }
        if (i != 3) {
            return new PlacementContent(str, map);
        }
        return new NoFillPlacementContent(str, map);
    }

    /* renamed from: com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory$1 */
    static /* synthetic */ class C28791 {

        /* renamed from: $SwitchMap$com$unity3d$services$monetization$core$placementcontent$PlacementContentResultFactory$PlacementContentResultType */
        static final /* synthetic */ int[] f5620x294a2897;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory$PlacementContentResultType[] r0 = com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory.PlacementContentResultType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5620x294a2897 = r0
                com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory$PlacementContentResultType r1 = com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory.PlacementContentResultType.SHOW_AD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5620x294a2897     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory$PlacementContentResultType r1 = com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory.PlacementContentResultType.PROMO_AD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5620x294a2897     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory$PlacementContentResultType r1 = com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory.PlacementContentResultType.NO_FILL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5620x294a2897     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory$PlacementContentResultType r1 = com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory.PlacementContentResultType.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory.C28791.<clinit>():void");
        }
    }
}
