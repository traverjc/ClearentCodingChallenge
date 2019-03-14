package com.jct.Processors;

import java.math.BigDecimal;

// enjoys inherited "simple interest" method of interest calculation
public class DiscoverProcessor extends SimpleInterestProcessor {
    @Override
    // polymorphism in action
    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
