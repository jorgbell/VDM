package org.cocos2dx.lib;

/* compiled from: Cocos2dxActivity */
class DialogMessage {
    public String button1;
    public String button2;
    public String message;
    public String title;

    public DialogMessage(String str, String str2) {
        this.message = str2;
        this.title = str;
    }

    public DialogMessage(String str, String str2, String str3, String str4) {
        this.message = str2;
        this.title = str;
        this.button1 = str3;
        this.button2 = str4;
    }
}
