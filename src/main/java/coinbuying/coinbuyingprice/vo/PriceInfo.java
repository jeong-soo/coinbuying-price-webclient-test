package coinbuying.coinbuyingprice.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceInfo {
    private long dttm;
    private double startPrice;
    private double endPrice;
    private double highPrice;
    private double minPrice;
    private double volume;
}
