package com.tsutsuku.githubdemo;

/**
 * Created by Administrator on 2018/12/27.
 */

public class BillListItemBean {

    private String month;
    private String time;
    private String name;

    private boolean checkItem;

    public boolean isCheckItem() {
        return checkItem;
    }

    public void setCheckItem(boolean checkItem) {
        this.checkItem = checkItem;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
