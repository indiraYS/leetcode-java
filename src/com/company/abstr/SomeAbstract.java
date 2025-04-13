package com.company.abstr;

import java.util.Random;

public abstract class SomeAbstract {
    public abstract SomeObj obj();

    public int rnd() {
        return (new Random()).nextInt();
    }
}
