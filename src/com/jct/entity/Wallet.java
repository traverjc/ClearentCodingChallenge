package com.jct.entity;

import java.util.ArrayList;
import java.util.List;

public class Wallet implements IWallet {
    private List<ICard> cards;
    private String name;

    public Wallet(String name) {
        this.name = name;
    }

    @Override
    public List<ICard> getCards() {
        return cards;
    }
    @Override
    public void setCards(List<ICard> cards) {
        this.cards = cards;
    }
    @Override
    public void addCard(ICard card) {
        if(cards == null) cards = new ArrayList<>();
        cards.add(card);
    }
    @Override
    public String getName() {
        return name;
    }
}
