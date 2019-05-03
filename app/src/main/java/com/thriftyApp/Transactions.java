package com.thriftyApp;

public class Transactions {

    String tag;
    int tid, uid, exin;
    long amount;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public long getAmount() {
        return amount;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getExin() {
        return exin;
    }

    public void setExin(int exin) {
        this.exin = exin;
    }
}
