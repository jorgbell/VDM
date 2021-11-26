package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzdqo;
import com.google.android.gms.internal.ads.zzeby;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzzy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbn {
    public static boolean zza(int i) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzbQ)).booleanValue()) {
            return true;
        }
        return ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbR)).booleanValue() || i <= 15299999;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016f A[Catch:{ JSONException -> 0x0174 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zzb(android.content.Context r16, android.view.View r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "window"
            java.lang.String r3 = "relative_to"
            java.lang.String r4 = "y"
            java.lang.String r5 = "x"
            java.lang.String r6 = "height"
            java.lang.String r7 = "width"
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            if (r1 != 0) goto L_0x0018
            return r8
        L_0x0018:
            r9 = 2
            r10 = 1
            r11 = 0
            int[] r12 = zzg(r17)     // Catch:{ Exception -> 0x00fd }
            int[] r13 = new int[r9]     // Catch:{ Exception -> 0x00fd }
            int r14 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            r13[r11] = r14     // Catch:{ Exception -> 0x00fd }
            int r14 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            r13[r10] = r14     // Catch:{ Exception -> 0x00fd }
            android.view.ViewParent r14 = r17.getParent()     // Catch:{ Exception -> 0x00fd }
        L_0x0031:
            boolean r15 = r14 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x00fd }
            if (r15 == 0) goto L_0x0058
            r15 = r14
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ Exception -> 0x00fd }
            int r9 = r15.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            r10 = r13[r11]     // Catch:{ Exception -> 0x00fd }
            int r9 = java.lang.Math.min(r9, r10)     // Catch:{ Exception -> 0x00fd }
            r13[r11] = r9     // Catch:{ Exception -> 0x00fd }
            int r9 = r15.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            r10 = 1
            r15 = r13[r10]     // Catch:{ Exception -> 0x00fd }
            int r9 = java.lang.Math.min(r9, r15)     // Catch:{ Exception -> 0x00fd }
            r13[r10] = r9     // Catch:{ Exception -> 0x00fd }
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x00fd }
            r9 = 2
            r10 = 1
            goto L_0x0031
        L_0x0058:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            int r10 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r14 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zza(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put(r7, r10)     // Catch:{ Exception -> 0x00fd }
            int r10 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r14 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zza(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put(r6, r10)     // Catch:{ Exception -> 0x00fd }
            r10 = r12[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r14 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zza(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put(r5, r10)     // Catch:{ Exception -> 0x00fd }
            r10 = 1
            r14 = r12[r10]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r10 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r10 = r10.zza(r0, r14)     // Catch:{ Exception -> 0x00fd }
            r9.put(r4, r10)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "maximum_visible_width"
            r14 = r13[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r15 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r14 = r15.zza(r0, r14)     // Catch:{ Exception -> 0x00fd }
            r9.put(r10, r14)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "maximum_visible_height"
            r14 = 1
            r13 = r13[r14]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r14 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r13 = r14.zza(r0, r13)     // Catch:{ Exception -> 0x00fd }
            r9.put(r10, r13)     // Catch:{ Exception -> 0x00fd }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "frame"
            r8.put(r10, r9)     // Catch:{ Exception -> 0x00fd }
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            boolean r10 = r1.getGlobalVisibleRect(r9)     // Catch:{ Exception -> 0x00fd }
            if (r10 == 0) goto L_0x00cd
            org.json.JSONObject r0 = zzk(r0, r9)     // Catch:{ Exception -> 0x00fd }
            goto L_0x00f7
        L_0x00cd:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            r9.put(r7, r11)     // Catch:{ Exception -> 0x00fd }
            r9.put(r6, r11)     // Catch:{ Exception -> 0x00fd }
            r6 = r12[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r7 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r6 = r7.zza(r0, r6)     // Catch:{ Exception -> 0x00fd }
            r9.put(r5, r6)     // Catch:{ Exception -> 0x00fd }
            r5 = 1
            r6 = r12[r5]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzbbd r5 = com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ Exception -> 0x00fd }
            int r0 = r5.zza(r0, r6)     // Catch:{ Exception -> 0x00fd }
            r9.put(r4, r0)     // Catch:{ Exception -> 0x00fd }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x00fd }
            r0 = r9
        L_0x00f7:
            java.lang.String r2 = "visible_bounds"
            r8.put(r2, r0)     // Catch:{ Exception -> 0x00fd }
            goto L_0x0102
        L_0x00fd:
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
        L_0x0102:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzeq
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x017a
            android.view.ViewParent r0 = r17.getParent()
            if (r0 == 0) goto L_0x0139
            java.lang.Class r1 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.String r2 = "getTemplateTypeName"
            java.lang.Class[] r3 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.Object r0 = r1.invoke(r0, r2)     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            goto L_0x013b
        L_0x012f:
            r0 = move-exception
            goto L_0x0134
        L_0x0131:
            r0 = move-exception
            goto L_0x0134
        L_0x0133:
            r0 = move-exception
        L_0x0134:
            java.lang.String r1 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.internal.ads.zzbbk.zzg(r1, r0)
        L_0x0139:
            java.lang.String r0 = ""
        L_0x013b:
            int r1 = r0.hashCode()     // Catch:{ JSONException -> 0x0174 }
            r2 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r1 == r2) goto L_0x0154
            r2 = 2019754500(0x78630204, float:1.8417067E34)
            if (r1 == r2) goto L_0x014a
            goto L_0x015e
        L_0x014a:
            java.lang.String r1 = "medium_template"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x015e
            r0 = 1
            goto L_0x015f
        L_0x0154:
            java.lang.String r1 = "small_template"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x015e
            r0 = 0
            goto L_0x015f
        L_0x015e:
            r0 = -1
        L_0x015f:
            java.lang.String r1 = "native_template_type"
            if (r0 == 0) goto L_0x016f
            r2 = 1
            if (r0 == r2) goto L_0x016a
            r8.put(r1, r11)     // Catch:{ JSONException -> 0x0174 }
            goto L_0x017a
        L_0x016a:
            r2 = 2
            r8.put(r1, r2)     // Catch:{ JSONException -> 0x0174 }
            goto L_0x017a
        L_0x016f:
            r2 = 1
            r8.put(r1, r2)     // Catch:{ JSONException -> 0x0174 }
            goto L_0x017a
        L_0x0174:
            r0 = move-exception
            java.lang.String r1 = "Could not log native template signal to JSON"
            com.google.android.gms.internal.ads.zzbbk.zzg(r1, r0)
        L_0x017a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbn.zzb(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static JSONObject zzc(View view) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                boolean z = false;
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzff)).booleanValue()) {
                    zzs.zzc();
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof ScrollView)) {
                        parent = parent.getParent();
                    }
                    if (parent != null) {
                        z = true;
                    }
                    jSONObject.put("contained_in_scroll_view", z);
                } else {
                    zzs.zzc();
                    ViewParent parent2 = view.getParent();
                    while (parent2 != null && !(parent2 instanceof AdapterView)) {
                        parent2 = parent2.getParent();
                    }
                    if (parent2 == null) {
                        i = -1;
                    } else {
                        i = ((AdapterView) parent2).getPositionForView(view);
                    }
                    if (i != -1) {
                        z = true;
                    }
                    jSONObject.put("contained_in_scroll_view", z);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject zzd(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzs.zzc();
            jSONObject.put("can_show_on_lock_screen", zzr.zzt(view));
            zzs.zzc();
            jSONObject.put("is_keyguard_locked", zzr.zzF(context));
        } catch (JSONException unused) {
            zzbbk.zzi("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject zze(Context context, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Map.Entry entry;
        Context context2 = context;
        Map<String, WeakReference<View>> map3 = map2;
        JSONObject jSONObject3 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject3;
        }
        int[] zzg = zzg(view);
        Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            View view2 = (View) ((WeakReference) next.getValue()).get();
            if (view2 != null) {
                int[] zzg2 = zzg(view2);
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                Iterator<Map.Entry<String, WeakReference<View>>> it2 = it;
                try {
                    JSONObject jSONObject6 = jSONObject3;
                    try {
                        jSONObject5.put("width", zzzy.zza().zza(context2, view2.getMeasuredWidth()));
                        jSONObject5.put("height", zzzy.zza().zza(context2, view2.getMeasuredHeight()));
                        jSONObject5.put("x", zzzy.zza().zza(context2, zzg2[0] - zzg[0]));
                        jSONObject5.put("y", zzzy.zza().zza(context2, zzg2[1] - zzg[1]));
                        jSONObject5.put("relative_to", "ad_view");
                        jSONObject4.put("frame", jSONObject5);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject2 = zzk(context2, rect);
                        } else {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("width", 0);
                            jSONObject2.put("height", 0);
                            jSONObject2.put("x", zzzy.zza().zza(context2, zzg2[0] - zzg[0]));
                            jSONObject2.put("y", zzzy.zza().zza(context2, zzg2[1] - zzg[1]));
                            jSONObject2.put("relative_to", "ad_view");
                        }
                        jSONObject4.put("visible_bounds", jSONObject2);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject4.put("text_color", textView.getCurrentTextColor());
                            entry = next;
                            jSONObject4.put("font_size", (double) textView.getTextSize());
                            jSONObject4.put("text", textView.getText());
                        } else {
                            entry = next;
                        }
                        jSONObject4.put("is_clickable", map3 != null && map3.containsKey(entry.getKey()) && view2.isClickable());
                        jSONObject = jSONObject6;
                        try {
                            jSONObject.put((String) entry.getKey(), jSONObject4);
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        jSONObject = jSONObject6;
                        zzbbk.zzi("Unable to get asset views information");
                        jSONObject3 = jSONObject;
                        it = it2;
                    }
                } catch (JSONException unused3) {
                    jSONObject = jSONObject3;
                    zzbbk.zzi("Unable to get asset views information");
                    jSONObject3 = jSONObject;
                    it = it2;
                }
                jSONObject3 = jSONObject;
                it = it2;
            }
        }
        return jSONObject3;
    }

    public static JSONObject zzf(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("x", zzzy.zza().zza(context, point2.x));
                    jSONObject3.put("y", zzzy.zza().zza(context, point2.y));
                    jSONObject3.put("start_x", zzzy.zza().zza(context, point.x));
                    jSONObject3.put("start_y", zzzy.zza().zza(context, point.y));
                    jSONObject = jSONObject3;
                } catch (JSONException e) {
                    zzbbk.zzg("Error occurred while putting signals into JSON object.", e);
                }
                jSONObject2.put("click_point", jSONObject);
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                zzbbk.zzg("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
            zzbbk.zzg("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
    }

    public static int[] zzg(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static Point zzh(MotionEvent motionEvent, View view) {
        int[] zzg = zzg(view);
        float rawX = motionEvent.getRawX();
        return new Point(((int) rawX) - zzg[0], ((int) motionEvent.getRawY()) - zzg[1]);
    }

    public static boolean zzi(Context context, zzdqo zzdqo) {
        if (!zzdqo.zzI) {
            return false;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfg)).booleanValue()) {
            return ((Boolean) zzaaa.zzc().zzb(zzaeq.zzfj)).booleanValue();
        }
        String str = (String) zzaaa.zzc().zzb(zzaeq.zzfh);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            for (String equals : zzecq.zza(zzeby.zzb(';')).zzb(str)) {
                if (equals.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static WindowManager.LayoutParams zzj() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzaaa.zzc().zzb(zzaeq.zzfi)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    private static JSONObject zzk(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzzy.zza().zza(context, rect.right - rect.left));
        jSONObject.put("height", zzzy.zza().zza(context, rect.bottom - rect.top));
        jSONObject.put("x", zzzy.zza().zza(context, rect.left));
        jSONObject.put("y", zzzy.zza().zza(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }
}
