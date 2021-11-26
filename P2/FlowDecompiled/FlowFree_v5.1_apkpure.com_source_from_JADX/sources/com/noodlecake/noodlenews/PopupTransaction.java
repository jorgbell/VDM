package com.noodlecake.noodlenews;

public class PopupTransaction {
    private boolean acked;
    private String description;

    /* renamed from: id */
    private int f5605id;
    private boolean immediate;
    private String negative_button_text;
    private String parameter_1;
    private String parameter_2;
    private String parameter_3;
    private String parameter_4;
    private int popup_id;
    private String positive_button_text;
    private String title;
    private String type;

    public PopupTransaction(int i) {
        this.f5605id = i;
    }

    public int getId() {
        return this.f5605id;
    }

    public void setId(int i) {
        this.f5605id = i;
    }

    public int getPopupId() {
        return this.popup_id;
    }

    public void setPopupId(int i) {
        this.popup_id = i;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str.toUpperCase();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getPositiveButtonText() {
        return this.positive_button_text;
    }

    public void setPositiveButtonText(String str) {
        this.positive_button_text = str;
    }

    public String getNegativeButtonText() {
        return this.negative_button_text;
    }

    public void setNegativeButtonText(String str) {
        this.negative_button_text = str;
    }

    public String getParameter1() {
        return this.parameter_1;
    }

    public void setParameter1(String str) {
        this.parameter_1 = str;
    }

    public String getParameter2() {
        return this.parameter_2;
    }

    public void setParameter2(String str) {
        this.parameter_2 = str;
    }

    public String getParameter3() {
        return this.parameter_3;
    }

    public void setParameter3(String str) {
        this.parameter_3 = str;
    }

    public String getParameter4() {
        return this.parameter_4;
    }

    public void setParameter4(String str) {
        this.parameter_4 = str;
    }

    public boolean isImmediate() {
        return this.immediate;
    }

    public void setImmediate(boolean z) {
        this.immediate = z;
    }

    public boolean isAcked() {
        return this.acked;
    }

    public void setAcked(boolean z) {
        this.acked = z;
    }
}
