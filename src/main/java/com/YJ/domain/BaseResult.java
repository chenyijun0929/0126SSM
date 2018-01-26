package com.YJ.domain;

import java.util.List;

/**
 * 生死有命
 * 富贵在天
 */
public class BaseResult<T> {
    private int total;
    private List<T> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
