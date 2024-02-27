package com.company.inh.sup;

public class ImpTor implements IntOne, IntSecond{
    @Override
    public String getName() {
        return IntOne.super.getName();
    }
}
