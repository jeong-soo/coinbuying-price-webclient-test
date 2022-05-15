package coinbuying.coinbuyingprice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Builder
public class CoinPriceKey implements Serializable {
    @Column(value="ticker")
    private String ticker;

    @Column(value="market")
    private String market;
}
