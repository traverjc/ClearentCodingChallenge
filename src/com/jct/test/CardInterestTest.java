package com.jct.test;

import com.jct.entity.Card;
import com.jct.entity.CardNetwork;
import com.jct.entity.Cardholder;
import com.jct.entity.ICard;
import com.jct.entity.ICardholder;
import com.jct.entity.IWallet;
import com.jct.MainClass;
import com.jct.entity.Wallet;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class CardInterestTest {

    @Test
    public void testCaseCalculatesInterest1() {
        ICard visaCard = new Card(CardNetwork.VISA, new BigDecimal(100L));
        ICard mastercardCard = new Card(CardNetwork.MASTERCARD, new BigDecimal(100L));
        ICard discoverCard = new Card(CardNetwork.DISCOVER, new BigDecimal(100L));

        IWallet wallet = new Wallet("Jim's wallet");
        wallet.addCard(visaCard);
        wallet.addCard(mastercardCard);
        wallet.addCard(discoverCard);

        ICardholder cardholder = new Cardholder("Jim", "Halperson");
        cardholder.addWallet(wallet);

        MainClass mainClass = new MainClass();

        assertEquals(new BigDecimal("10.00"), mainClass.calculateInterest(visaCard));
        assertEquals(new BigDecimal("5.00"), mainClass.calculateInterest(mastercardCard));
        assertEquals(new BigDecimal("1.00"), mainClass.calculateInterest(discoverCard));

        BigDecimal interest = mainClass.calculateInterest(cardholder);
        assertEquals(new BigDecimal("16.00"), interest);
    }

    @Test
    public void testCaseCalculatesInterest2() {
        IWallet wallet1 = new Wallet("Michael's wallet");
        wallet1.addCard(new Card(CardNetwork.VISA, new BigDecimal(100L)));
        wallet1.addCard(new Card(CardNetwork.DISCOVER, new BigDecimal(100L)));

        IWallet wallet2 = new Wallet("Michael's money clip");
        wallet2.addCard(new Card(CardNetwork.MASTERCARD, new BigDecimal(100L)));

        ICardholder cardholder = new Cardholder("Michael", "Scott", Arrays.asList(wallet1, wallet2));

        MainClass mainClass = new MainClass();

        Assert.assertEquals(new BigDecimal("11.00"), mainClass.calculateInterest(wallet1));
        Assert.assertEquals(new BigDecimal("5.00"), mainClass.calculateInterest(wallet2));

        Assert.assertEquals(new BigDecimal("16.00"), mainClass.calculateInterest(cardholder));
    }

    @Test
    public void testCaseCalculatesInterest3() {
        IWallet wallet1 = new Wallet("Pam's purse");
        wallet1.addCard(new Card(CardNetwork.MASTERCARD, new BigDecimal(100L)));
        wallet1.addCard(new Card(CardNetwork.VISA, new BigDecimal(100L)));
        ICardholder cardholder1 = new Cardholder("Pam", "Beesly", Arrays.asList(wallet1));

        IWallet wallet2 = new Wallet("Creed's bolsa");
        wallet2.addCard(new Card(CardNetwork.MASTERCARD, new BigDecimal(100L)));
        wallet2.addCard(new Card(CardNetwork.VISA, new BigDecimal(100L)));
        ICardholder cardholder2 = new Cardholder("Creed", "Bratton", Arrays.asList(wallet2));

        MainClass mainClass = new MainClass();

        Assert.assertEquals(new BigDecimal("15.00"), mainClass.calculateInterest(wallet1));
        Assert.assertEquals(new BigDecimal("15.00"), mainClass.calculateInterest(cardholder1));
        Assert.assertEquals(new BigDecimal("15.00"), mainClass.calculateInterest(wallet2));
        Assert.assertEquals(new BigDecimal("15.00"), mainClass.calculateInterest(cardholder2));
    }
}
