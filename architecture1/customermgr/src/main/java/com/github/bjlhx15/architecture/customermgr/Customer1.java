package com.github.bjlhx15.architecture.customermgr;

import com.github.bjlhx15.architecture.common.Base1;

public class Customer1 {
    public void c1(String s){
        new Base1().base1("Customer invoke " +s);
        System.out.println("now in c1="+s);
    }
}
