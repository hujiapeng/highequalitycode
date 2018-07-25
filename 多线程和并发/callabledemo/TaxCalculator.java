package com.hjp.callabledemo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TaxCalculator implements Callable<Integer> {

    //本金
    private int seedMoney;

    //接收主线程提供的参数
    public TaxCalculator(int _seedMoney) {
        this.seedMoney = _seedMoney;
    }

    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(10000);
        return seedMoney / 10;
    }
}
