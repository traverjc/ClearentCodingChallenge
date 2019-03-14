package com.jct.entity;

import java.util.List;

public interface IWallet {
    String getName();
    List<ICard> getCards();
    void setCards(List<ICard> cards);
    void addCard(ICard card);
}
