package com.mopub.mobileads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mopub.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@Mockable
/* compiled from: VastResource.kt */
public class VastResource implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> VALID_APPLICATION_TYPES = CollectionsKt__CollectionsJVMKt.listOf("application/x-javascript");
    /* access modifiers changed from: private */
    public static final List<String> VALID_IMAGE_TYPES = CollectionsKt__CollectionsKt.listOf("image/jpeg", "image/png", "image/bmp", "image/gif", "image/jpg");
    @SerializedName("creative_type")
    @Expose
    private final CreativeType creativeType;
    @SerializedName("height")
    @Expose
    private final int height;
    @SerializedName("resource")
    @Expose
    private final String resource;
    @SerializedName("type")
    @Expose
    private final Type type;
    @SerializedName("width")
    @Expose
    private final int width;

    /* compiled from: VastResource.kt */
    public enum CreativeType {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* compiled from: VastResource.kt */
    public enum Type {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE,
        BLURRED_LAST_FRAME
    }

    public static final VastResource fromVastResourceXmlManager(VastResourceXmlManager vastResourceXmlManager, int i, int i2) {
        return Companion.fromVastResourceXmlManager(vastResourceXmlManager, i, i2);
    }

    public static final VastResource fromVastResourceXmlManager(VastResourceXmlManager vastResourceXmlManager, Type type2, int i, int i2) {
        return Companion.fromVastResourceXmlManager(vastResourceXmlManager, type2, i, i2);
    }

    public VastResource(String str, Type type2, CreativeType creativeType2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, Constants.VAST_RESOURCE);
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(creativeType2, VastResourceXmlManager.CREATIVE_TYPE);
        this.resource = str;
        this.type = type2;
        this.creativeType = creativeType2;
        this.width = i;
        this.height = i2;
    }

    public String getResource() {
        return this.resource;
    }

    public Type getType() {
        return this.type;
    }

    public CreativeType getCreativeType() {
        return this.creativeType;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void initializeWebView(VastWebView vastWebView) {
        Intrinsics.checkNotNullParameter(vastWebView, "webView");
        String htmlResourceValue = getHtmlResourceValue();
        if (htmlResourceValue != null) {
            vastWebView.loadData(htmlResourceValue);
        }
    }

    public String getHtmlResourceValue() {
        if (getType() == Type.HTML_RESOURCE) {
            return getResource();
        }
        if (getType() == Type.IFRAME_RESOURCE) {
            return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\"" + " width=\"" + getWidth() + '\"' + " height=\"" + getHeight() + '\"' + " src=\"" + getResource() + "\"></iframe>";
        }
        Type type2 = getType();
        Type type3 = Type.STATIC_RESOURCE;
        if (type2 == type3 && getCreativeType() == CreativeType.IMAGE) {
            return "<html>" + "<head></head><body style=\"margin:0;padding:0\"><img src=\"" + getResource() + '\"' + " width=\"100%\" style=\"max-width:100%;max-height:100%;\" />" + "</body></html>";
        } else if (getType() == type3 && getCreativeType() == CreativeType.JAVASCRIPT) {
            return "<script src=\"" + getResource() + "\"></script>";
        } else if (getType() == Type.BLURRED_LAST_FRAME) {
            return getResource();
        } else {
            return null;
        }
    }

    public String getCorrectClickThroughUrl(String str, String str2) {
        if (!(getType() == Type.HTML_RESOURCE || getType() == Type.IFRAME_RESOURCE)) {
            Type type2 = getType();
            Type type3 = Type.STATIC_RESOURCE;
            if (type2 == type3 && getCreativeType() == CreativeType.IMAGE) {
                return str;
            }
            if (!(getType() == type3 && getCreativeType() == CreativeType.JAVASCRIPT)) {
                if (getType() == Type.BLURRED_LAST_FRAME) {
                    return str;
                }
                return null;
            }
        }
        return str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastResource)) {
            return false;
        }
        VastResource vastResource = (VastResource) obj;
        return !(Intrinsics.areEqual(getResource(), vastResource.getResource()) ^ true) && getType() == vastResource.getType() && getCreativeType() == vastResource.getCreativeType() && getWidth() == vastResource.getWidth() && getHeight() == vastResource.getHeight();
    }

    public int hashCode() {
        return (((((((getResource().hashCode() * 31) + getType().hashCode()) * 31) + getCreativeType().hashCode()) * 31) + getWidth()) * 31) + getHeight();
    }

    public String toString() {
        return "VastResource(resource='" + getResource() + "', type=" + getType() + ", creativeType=" + getCreativeType() + ", width=" + getWidth() + ", height=" + getHeight() + ')';
    }

    /* compiled from: VastResource.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[Type.STATIC_RESOURCE.ordinal()] = 1;
                iArr[Type.HTML_RESOURCE.ordinal()] = 2;
                iArr[Type.IFRAME_RESOURCE.ordinal()] = 3;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VastResource fromVastResourceXmlManager(VastResourceXmlManager vastResourceXmlManager, int i, int i2) {
            Intrinsics.checkNotNullParameter(vastResourceXmlManager, "resourceXmlManager");
            Type[] values = Type.values();
            ArrayList arrayList = new ArrayList();
            for (Type fromVastResourceXmlManager : values) {
                VastResource fromVastResourceXmlManager2 = VastResource.Companion.fromVastResourceXmlManager(vastResourceXmlManager, fromVastResourceXmlManager, i, i2);
                if (fromVastResourceXmlManager2 != null) {
                    arrayList.add(fromVastResourceXmlManager2);
                }
            }
            return (VastResource) CollectionsKt___CollectionsKt.firstOrNull(arrayList);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.mopub.mobileads.VastResource fromVastResourceXmlManager(com.mopub.mobileads.VastResourceXmlManager r12, com.mopub.mobileads.VastResource.Type r13, int r14, int r15) {
            /*
                r11 = this;
                java.lang.String r0 = "resourceXmlManager"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                java.lang.String r0 = "type"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                java.lang.String r0 = r12.getStaticResourceType()
                com.mopub.mobileads.VastResource$CreativeType r1 = com.mopub.mobileads.VastResource.CreativeType.NONE
                int[] r2 = com.mopub.mobileads.VastResource.Companion.WhenMappings.$EnumSwitchMapping$0
                int r3 = r13.ordinal()
                r2 = r2[r3]
                r3 = 1
                r4 = 0
                if (r2 == r3) goto L_0x0031
                r0 = 2
                if (r2 == r0) goto L_0x002a
                r0 = 3
                if (r2 == r0) goto L_0x0025
                r8 = r1
                r6 = r4
                goto L_0x0064
            L_0x0025:
                java.lang.String r12 = r12.getIFrameResource()
                goto L_0x002e
            L_0x002a:
                java.lang.String r12 = r12.getHTMLResource()
            L_0x002e:
                r6 = r12
                r8 = r1
                goto L_0x0064
            L_0x0031:
                java.lang.String r12 = r12.getStaticResource()
                java.util.List r1 = com.mopub.mobileads.VastResource.VALID_IMAGE_TYPES
                boolean r1 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r1, r0)
                if (r1 != 0) goto L_0x004b
                java.util.List r1 = com.mopub.mobileads.VastResource.VALID_APPLICATION_TYPES
                boolean r1 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r1, r0)
                if (r1 == 0) goto L_0x004a
                goto L_0x004b
            L_0x004a:
                r3 = 0
            L_0x004b:
                if (r3 == 0) goto L_0x004e
                goto L_0x004f
            L_0x004e:
                r12 = r4
            L_0x004f:
                com.mopub.mobileads.VastResource$CreativeType r1 = com.mopub.mobileads.VastResource.CreativeType.IMAGE
                java.util.List r2 = com.mopub.mobileads.VastResource.VALID_IMAGE_TYPES
                boolean r0 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r2, r0)
                if (r0 == 0) goto L_0x005c
                goto L_0x005d
            L_0x005c:
                r1 = r4
            L_0x005d:
                if (r1 == 0) goto L_0x0060
                goto L_0x002e
            L_0x0060:
                com.mopub.mobileads.VastResource$CreativeType r0 = com.mopub.mobileads.VastResource.CreativeType.JAVASCRIPT
                r1 = r0
                goto L_0x002e
            L_0x0064:
                if (r6 == 0) goto L_0x006f
                com.mopub.mobileads.VastResource r4 = new com.mopub.mobileads.VastResource
                r5 = r4
                r7 = r13
                r9 = r14
                r10 = r15
                r5.<init>(r6, r7, r8, r9, r10)
            L_0x006f:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastResource.Companion.fromVastResourceXmlManager(com.mopub.mobileads.VastResourceXmlManager, com.mopub.mobileads.VastResource$Type, int, int):com.mopub.mobileads.VastResource");
        }
    }
}
