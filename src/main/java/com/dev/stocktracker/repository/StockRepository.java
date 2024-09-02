package com.dev.stocktracker.repository;

import com.dev.stocktracker.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
}
