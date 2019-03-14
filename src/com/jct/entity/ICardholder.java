package com.jct.entity;

import java.util.List;

public interface ICardholder {
    String getFirstName();
    String getLastName();
    List<IWallet> getWallets();
    void setWallets(List<IWallet> wallets);
    void addWallet(IWallet wallet);
}
