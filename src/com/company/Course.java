package com.company;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class Course {
    String id;
    String title;
    int credit;
    int tpCredit;
    int subTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTuitionPerCredit() {
        return tpCredit;
    }

    public void setTuitionPerCredit(int tuitionPerCredit) {
        this.tpCredit = tuitionPerCredit;
    }

    public int getSubTotal() {
        return subTotal = credit * tpCredit;
    }
}
