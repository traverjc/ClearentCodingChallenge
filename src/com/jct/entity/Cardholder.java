package com.jct.entity;

import java.util.ArrayList;
import java.util.List;

public class Cardholder implements ICardholder {
    private String firstName;
    private String lastName;
    private List<IWallet> wallets;

    public Cardholder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Cardholder(String firstName, String lastName, List<IWallet> wallets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallets = wallets;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setWallets(List<IWallet> wallets) {this.wallets = wallets;}

    @Override
    public List<IWallet> getWallets() {
        return wallets;
    }

    @Override
    public void addWallet(IWallet wallet) {
        if(wallets == null)
            wallets = new ArrayList<>();
        wallets.add(wallet);
    }
}
