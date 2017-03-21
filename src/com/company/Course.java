package com.company;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class Course {
    String id;
    String title;
    int credit;
    int tutionPerCredit;
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

    public int getTutionPerCredit() {
        return tutionPerCredit;
    }

    public void setTutionPerCredit(int tutionPerCredit) {
        this.tutionPerCredit = tutionPerCredit;
    }

    public int getSubTotal() {
        return subTotal = credit * tutionPerCredit;
    }
}
