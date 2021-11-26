package com.noodlecake.lib.font;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Hashtable;

public class NoodleTypefaces {
    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public static Typeface get(Context context, String str) {
        Typeface typeface;
        Hashtable<String, Typeface> hashtable = cache;
        synchronized (hashtable) {
            if (!hashtable.containsKey(str)) {
                hashtable.put(str, Typeface.createFromAsset(context.getAssets(), str));
            }
            typeface = hashtable.get(str);
        }
        return typeface;
    }
}
