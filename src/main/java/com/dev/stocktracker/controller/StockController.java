package com.dev.stocktracker.controller;

import com.dev.stocktracker.controller.request.StockRequest;
import com.dev.stocktracker.entity.Stock;
import com.dev.stocktracker.entity.StockPurchase;
import com.dev.stocktracker.repository.StockPurchaseRespository;
import com.dev.stocktracker.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockRepository stockRepository;
    private final StockPurchaseRespository stockPurchaseRespository;

    //Primeira compra de uma ação
    @PostMapping
    public void savePurchase(@RequestBody StockRequest request){
        var stock = new Stock();
        stock.setStock(request.getStock());

        var stockPurchase = new StockPurchase();
        stockPurchase.setPrice(request.getPrice());
        stockPurchase.setQuantity(request.getQuantity());
        stockPurchase.setDate(request.getDate());
        StockPurchase saved = stockPurchaseRespository.save(stockPurchase);
        stock.setPurchases(List.of(saved));
        stockRepository.save(stock);
    }

}
