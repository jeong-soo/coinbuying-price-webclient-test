package coinbuying.coinbuyingprice.service;

import coinbuying.coinbuyingprice.vo.BithumbCandlestickResponse;
import org.springframework.stereotype.Service;

@Service
public class BithumbCandleService {
    public void printCandle(BithumbCandlestickResponse response) {
        System.out.println(response);
    }
}
