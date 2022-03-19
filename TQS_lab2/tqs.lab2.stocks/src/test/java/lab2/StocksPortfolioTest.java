package lab2;

//Junit
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

//Mockito
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {
    @Mock
    IStockMarket market;

    @InjectMocks
    StocksPortfolio portfolio;
    
    @Test
    void getTotalValueTest(){
        when(market.lookUpPrice("EBAY")).thenReturn(4.0);
        when(market.lookUpPrice("MSFT")).thenReturn(1.5);
        // when(market.lookUpPrice("NOTUSED")).thenReturn(1.5);

        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("MSFT", 4));
        double result = portfolio.getTotalValue();

        assertThat(result,is(14));
        //verify(market, times(2)).lookUpPrice(anyString());
    }

    
}
