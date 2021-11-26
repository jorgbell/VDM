package com.noodlecake.noodlenews;

import android.app.Activity;
import android.content.Context;

public class Push {
    public static void initPush(String str, String str2, String str3, Context context, Class<? extends Activity> cls) {
        str.replace(".", "-");
    }
}
