package com.jct.Processors;

import com.jct.entity.ICard;

import java.math.BigDecimal;

public abstract class SimpleInterestProcessor implements IProcessor {
    // Normally, would set this to 0.0 to make it obvious if base class interest rate hasn't been overridden by subclass
    // For demo purposes, show polymorphic effect of DiscoverProcessor not overriding this
    // Also, information hiding to external classes
    protected BigDecimal interestRate = new BigDecimal("0.01");

    // share this functionality with closely related processor classes, where
    // the 'simple interest' method of interest calculation has been prescribed
    public BigDecimal calculateInterest(ICard card) {
        return card.getBalance().multiply(getInterestRate());
    }
    public abstract BigDecimal getInterestRate();
}
