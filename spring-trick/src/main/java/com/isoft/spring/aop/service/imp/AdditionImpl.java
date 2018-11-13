package com.isoft.spring.aop.service.imp;

import com.isoft.spring.aop.service.IAddition;

public class AdditionImpl implements IAddition {

    @Override
    public void addtional() {
        System.out.println("out additional...");
    }

}

