package com.jct.service;

import com.jct.Processors.DiscoverProcessor;
import com.jct.Processors.IProcessor;
import com.jct.Processors.MastercardProcessor;
import com.jct.Processors.VisaProcessor;
import com.jct.entity.CardNetwork;
import com.jct.entity.ICard;

public class ProcessorService implements IProcessorService {
    // we could also have used dependency injection via Spring @AutoWired annotation
    // on private service instance members here.
    public IProcessor getProcessorForCardNetwork(CardNetwork cardNetwork) {
        switch (cardNetwork) {
            case DISCOVER:
                return new DiscoverProcessor();
            case MASTERCARD:
                return new MastercardProcessor();
            case VISA:
                return new VisaProcessor();
        }
        throw new IllegalArgumentException("invalid card processor: " + cardNetwork.toString());
    }
    public IProcessor getProcessorForCard(ICard card) {
        return getProcessorForCardNetwork(card.getCardNetwork());
    }
}
