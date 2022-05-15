package coinbuying.coinbuyingprice.model;

import coinbuying.coinbuyingprice.entity.CoinType;
import coinbuying.coinbuyingprice.entity.MarketType;
import coinbuying.coinbuyingprice.entity.CoinPrice;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class CoinPriceFactoryImpl implements CoinPriceFactory {
    @Override
    public CoinPrice userAssetBuilder(String ticker, String market, Double price, LocalDateTime updateDttm) {
        return CoinPrice.builder().ticker(ticker).market(market).price(price).updateDttm(updateDttm).build();
    }

    @Override
    public CoinPrice userAssetBuilder(CoinType coinType, MarketType market, Double price, LocalDateTime updateDttm) {
        return this.userAssetBuilder(coinType.getTicker(), market.getName(), price, updateDttm);
    }

    @Override
    public List<CoinPrice> setupListBuilder() {
        return Arrays.asList(
                this.userAssetBuilder(CoinType.BTC, MarketType.BITHUMB, 400000000.0, LocalDateTime.now()),
                this.userAssetBuilder(CoinType.ETH, MarketType.BITHUMB, 400000000.0, LocalDateTime.now()),
                this.userAssetBuilder(CoinType.XRP, MarketType.BITHUMB, 400000000.0, LocalDateTime.now()),
                this.userAssetBuilder(CoinType.EOS, MarketType.BITHUMB, 400000000.0, LocalDateTime.now())
        );
    }
}
