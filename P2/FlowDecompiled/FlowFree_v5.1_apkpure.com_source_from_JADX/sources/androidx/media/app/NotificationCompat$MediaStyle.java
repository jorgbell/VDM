package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.p001v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R$id;
import androidx.media.R$integer;
import androidx.media.R$layout;

public class NotificationCompat$MediaStyle extends NotificationCompat.Style {
    int[] mActionsToShowInCompact = null;
    PendingIntent mCancelButtonIntent;
    boolean mShowCancelButton;
    MediaSessionCompat.Token mToken;

    public NotificationCompat$MediaStyle setShowActionsInCompactView(int... iArr) {
        this.mActionsToShowInCompact = iArr;
        return this;
    }

    public NotificationCompat$MediaStyle setMediaSession(MediaSessionCompat.Token token) {
        this.mToken = token;
        return this;
    }

    public NotificationCompat$MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
        this.mCancelButtonIntent = pendingIntent;
        return this;
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 21) {
            Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
            Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
            fillInMediaStyle(mediaStyle);
            builder.setStyle(mediaStyle);
        } else if (this.mShowCancelButton) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
    }

    /* access modifiers changed from: package-private */
    public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.mActionsToShowInCompact;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.mToken;
        if (token != null) {
            mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
        }
        return mediaStyle;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return generateContentView();
    }

    /* access modifiers changed from: package-private */
    public RemoteViews generateContentView() {
        int i;
        RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
        int size = this.mBuilder.mActions.size();
        int[] iArr = this.mActionsToShowInCompact;
        if (iArr == null) {
            i = 0;
        } else {
            i = Math.min(iArr.length, 3);
        }
        applyStandardTemplate.removeAllViews(R$id.media_actions);
        if (i > 0) {
            int i2 = 0;
            while (i2 < i) {
                if (i2 < size) {
                    applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i2])));
                    i2++;
                } else {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - 1)}));
                }
            }
        }
        if (this.mShowCancelButton) {
            applyStandardTemplate.setViewVisibility(R$id.end_padder, 8);
            int i3 = R$id.cancel_action;
            applyStandardTemplate.setViewVisibility(i3, 0);
            applyStandardTemplate.setOnClickPendingIntent(i3, this.mCancelButtonIntent);
            applyStandardTemplate.setInt(i3, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R$integer.cancel_button_image_alpha));
        } else {
            applyStandardTemplate.setViewVisibility(R$id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
        boolean z = action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R$layout.notification_media_action);
        int i = R$id.action0;
        remoteViews.setImageViewResource(i, action.getIcon());
        if (!z) {
            remoteViews.setOnClickPendingIntent(i, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(i, action.getTitle());
        }
        return remoteViews;
    }

    /* access modifiers changed from: package-private */
    public int getContentViewLayoutResource() {
        return R$layout.notification_template_media;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return generateBigContentView();
    }

    /* access modifiers changed from: package-private */
    public RemoteViews generateBigContentView() {
        int min = Math.min(this.mBuilder.mActions.size(), 5);
        RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
        applyStandardTemplate.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i = 0; i < min; i++) {
                applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i)));
            }
        }
        if (this.mShowCancelButton) {
            int i2 = R$id.cancel_action;
            applyStandardTemplate.setViewVisibility(i2, 0);
            applyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R$integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
        } else {
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    /* access modifiers changed from: package-private */
    public int getBigContentViewLayoutResource(int i) {
        return i <= 3 ? R$layout.notification_template_big_media_narrow : R$layout.notification_template_big_media;
    }
}
