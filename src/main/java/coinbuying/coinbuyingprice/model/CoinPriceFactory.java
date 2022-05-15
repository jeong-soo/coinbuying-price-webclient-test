package coinbuying.coinbuyingprice.model;

import coinbuying.coinbuyingprice.entity.CoinType;
import coinbuying.coinbuyingprice.entity.MarketType;
import coinbuying.coinbuyingprice.entity.CoinPrice;

import java.time.LocalDateTime;
import java.util.List;

public interface CoinPriceFactory {
    CoinPrice userAssetBuilder(String coin_id, String market, Double price, LocalDateTime updateDttm);
    CoinPrice userAssetBuilder(CoinType coinType, MarketType market, Double price, LocalDateTime updateDttm);
    List<CoinPrice> setupListBuilder();
}