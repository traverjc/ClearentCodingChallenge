package com.jct.entity;

import java.math.BigDecimal;

public class Card implements ICard {
    private BigDecimal balance;
    private CardNetwork cardNetwork;

    public Card(CardNetwork cardNetwork, BigDecimal balance) {
        this.cardNetwork = cardNetwork;
        this.balance = balance;
    }
    @Override

    public CardNetwork getCardNetwork() {
        return cardNetwork;
    }
    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}
