package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaw;
import com.google.android.gms.common.internal.zay;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class SignInButton extends FrameLayout implements View.OnClickListener {
    private int zaa;
    private int zab;
    private View zac;
    private View.OnClickListener zad;

    public SignInButton(@RecentlyNonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(@RecentlyNonNull Context context, AttributeSet attributeSet, @RecentlyNonNull int i) {
        super(context, attributeSet, i);
        this.zad = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.zaa = obtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.zab = obtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.zaa, this.zab);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setSize(@RecentlyNonNull int i) {
        setStyle(i, this.zab);
    }

    public final void setColorScheme(@RecentlyNonNull int i) {
        setStyle(this.zaa, i);
    }

    @Deprecated
    public final void setScopes(@RecentlyNonNull Scope[] scopeArr) {
        setStyle(this.zaa, this.zab);
    }

    public final void setStyle(@RecentlyNonNull int i, @RecentlyNonNull int i2) {
        this.zaa = i;
        this.zab = i2;
        Context context = getContext();
        View view = this.zac;
        if (view != null) {
            removeView(view);
        }
        try {
            this.zac = zaw.zaa(context, this.zaa, this.zab);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.zaa;
            int i4 = this.zab;
            zay zay = new zay(context);
            zay.zaa(context.getResources(), i3, i4);
            this.zac = zay;
        }
        addView(this.zac);
        this.zac.setEnabled(isEnabled());
        this.zac.setOnClickListener(this);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zad = onClickListener;
        View view = this.zac;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    public final void setEnabled(@RecentlyNonNull boolean z) {
        super.setEnabled(z);
        this.zac.setEnabled(z);
    }

    public final void onClick(@RecentlyNonNull View view) {
        View.OnClickListener onClickListener = this.zad;
        if (onClickListener != null && view == this.zac) {
            onClickListener.onClick(this);
        }
    }
}
