package com.jct.Processors;

import com.jct.entity.ICard;

import java.math.BigDecimal;

// in the real world, this could be an interface to a processor API,
// for interest rate, balance, transaction history, etc.
public interface IProcessor {
    BigDecimal calculateInterest(ICard card);
    BigDecimal getInterestRate();
}
