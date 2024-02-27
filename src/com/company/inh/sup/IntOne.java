package com.company.inh.sup;

public interface IntOne {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}
