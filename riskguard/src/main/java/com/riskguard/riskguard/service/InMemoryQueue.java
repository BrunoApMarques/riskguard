package com.riskguard.riskguard.service;

import com.riskguard.riskguard.domain.Trade;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class InMemoryQueue {
    private final BlockingQueue<Trade> queue = new LinkedBlockingQueue<>();

    public void enqueue(Trade t) { queue.offer(t); }
    public Trade take() throws InterruptedException { return queue.take(); }
    public int size() { return queue.size(); }
}
