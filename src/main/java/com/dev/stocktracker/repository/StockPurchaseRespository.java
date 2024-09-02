package com.dev.stocktracker.repository;

import com.dev.stocktracker.entity.StockPurchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockPurchaseRespository extends MongoRepository<StockPurchase, String> {
}
