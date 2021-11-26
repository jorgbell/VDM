package com.google.android.play.core.review;

import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.splitcompat.C2150p;

public class ReviewManagerFactory {
    public static ReviewManager create(Context context) {
        PlayCoreDialogWrapperActivity.m5129a(context);
        return new C2128c(new C2134i(C2150p.m5402c(context)));
    }
}
