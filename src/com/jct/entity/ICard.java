package com.jct.entity;

import java.math.BigDecimal;

// Small, cohesive interfaces
public interface ICard {
    void setBalance(BigDecimal balance);
    BigDecimal getBalance();
    CardNetwork getCardNetwork();
}
