package com.goofy.concurrency.solve.transaction;

import com.goofy.concurrency.solve.service.StockService;

// StockService를 실행시 Transaction이 어떻게 묶는지
public class TransactionStockService {
    private final StockService stockService;

    public TransactionStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public void decrease(Long id, Long quantity) {
        startTransaction();

        stockService.decrease(id, quantity);

        endTransaction(); // 트랜잭션이 끝나는 시점이 늦어지면? proxy를 타게되면, 스레드의 조율 어려움
    }

    public void startTransaction() {

    }

    public void endTransaction() {

    }
}
