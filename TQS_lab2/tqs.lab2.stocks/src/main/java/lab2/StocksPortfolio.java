package lab2;

import java.util.ArrayList;

public class StocksPortfolio {

    private IStockMarket marketService;
    private ArrayList<Stock> stocks = new ArrayList<>();

    public StocksPortfolio(IStockMarket marketservice){
        this.marketService = marketservice;
    }

    public double getTotalValue(){
        double total = 0;

        for(Stock s : this.stocks){
            total += (marketService.lookUpPrice(s.getLabel()) * s.getQuantity());
        }

        return total;
    }

    public void addStock(Stock newStock){
        this.stocks.add(newStock);
    }
    
}
