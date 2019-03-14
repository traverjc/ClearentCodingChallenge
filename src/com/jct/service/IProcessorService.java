package com.jct.service;

import com.jct.Processors.IProcessor;
import com.jct.entity.CardNetwork;
import com.jct.entity.ICard;

public interface IProcessorService {
    IProcessor getProcessorForCard(ICard card);
    IProcessor getProcessorForCardNetwork(CardNetwork cardNetwork);
}
