package com.jct;

import com.jct.Processors.IProcessor;
import com.jct.entity.CardNetwork;
import com.jct.entity.ICard;
import com.jct.entity.ICardholder;
import com.jct.entity.IWallet;
import com.jct.service.IProcessorService;
import com.jct.service.ProcessorService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

// at the business logic layer, we do violate Single Responsibility a bit
// in that the class is responsible for "knowing" that it needs to request
// its service for each card type to calculate interest
public class MainClass {
    private static final IProcessorService processorService = new ProcessorService();

    public MainClass() {}

    public BigDecimal calculateInterest(ICard card) {
        // not exactly dependency injection, but MainClass remains decoupled from
        // any knowledge of specific processors or implementation.
        IProcessor processor = processorService.getProcessorForCard(card);
        BigDecimal interest = processor.calculateInterest(card);
        System.out.println(String.format("Interest for %s card with balance %f: %f", card.getCardNetwork(), card.getBalance(), interest));
        return interest;
    }
    // overloading
    // also, interfaces everywhere! we've gone interface-crazy!
    public BigDecimal calculateInterest(IWallet wallet) {
        BigDecimal totalInterest = BigDecimal.ZERO;

        // fetch each processor only once (or less)
        Map<CardNetwork,List<ICard>> map = wallet.getCards().stream().collect(groupingBy(ICard::getCardNetwork));

        for(CardNetwork cardNetwork : map.keySet()) {
            // MainClass "knows" that cards require additional information from Processors,
            // but this is part and parcel of BLL, and MainClass is not coupled to a specific,
            // concrete class / provider for that service
            IProcessor processor = processorService.getProcessorForCardNetwork(cardNetwork);
            totalInterest = totalInterest.add(map.get(cardNetwork).stream().map(processor::calculateInterest).reduce(BigDecimal.ZERO,BigDecimal::add));
        }
        System.out.println(String.format("Interest for wallet %s: %f", wallet.getName(), totalInterest));
        return totalInterest;
    }
    // more method overloading
    public BigDecimal calculateInterest(ICardholder cardholder) {
        System.out.println(String.format("Calculating interest for cardholder: %s %s", cardholder.getFirstName(), cardholder.getLastName()));
        BigDecimal interest = BigDecimal.ZERO;

        for(IWallet wallet : cardholder.getWallets()) {
            interest = interest.add(calculateInterest(wallet));
        }
        System.out.println(String.format("Interest for cardholder %s: %f", cardholder.getFirstName(), interest));
        return interest;
    }
}
