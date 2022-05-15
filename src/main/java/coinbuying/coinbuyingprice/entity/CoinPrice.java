package coinbuying.coinbuyingprice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(value="user_asset")
@AllArgsConstructor
@Getter
@Builder
public class CoinPrice {
    @Id
    @Column(value="ticker")
    private String ticker;

    @Id
    @Column(value="market")
    private String market;

    @Column(value="price")
    private Double price;

    @Column(value="update_dttm")
    private LocalDateTime updateDttm;
}