package com.example.csh.mvptest.entity;

/**
 * <p/>作者： lxg
 * <p/>创建时间: 17/11/01 10:21.
 */

public class FunctionItem {
    private String name;
    private int imageId;
    private int count;
    //是否启用，默认启用
    private boolean isEnabled = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
