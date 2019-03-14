package com.jct.Processors;

import java.math.BigDecimal;

public class MastercardProcessor extends SimpleInterestProcessor {
    private final static BigDecimal interestRate = new BigDecimal("0.05");

    @Override
    // Mastercard's rate will be applied, but SimpleInterestProcessor's interest calculation will be used
    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
