package com.jct.Processors;

import java.math.BigDecimal;

// Open, yet closed. A "new" visa processor could be created if needed,
// or a new extension of SimpleInterestProcessor for AMEX, or a new type
// of "processor" completely via a new abstract base class implementing
// IProcessor
public class VisaProcessor extends SimpleInterestProcessor {
    private final static BigDecimal interestRate = new BigDecimal("0.10");

    @Override
    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
