package coinbuying.coinbuyingprice.repository;


import coinbuying.coinbuyingprice.entity.CoinPrice;
import coinbuying.coinbuyingprice.entity.CoinPriceKey;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CoinPriceRepository extends R2dbcRepository<CoinPrice, CoinPriceKey> {

}