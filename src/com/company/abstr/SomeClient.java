package com.company.abstr;

public class SomeClient {
    public SomeAbstract make() {
        return new SomeAbstract() {
            @Override
            public SomeObj obj() {
                return null;
            }
        };
    }
}
