package coinbuying.coinbuyingprice.scheduler;

import coinbuying.coinbuyingprice.service.BithumbCandleService;
import coinbuying.coinbuyingprice.vo.BithumbCandlestickResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class CoinPriceGetScheduler {
    @Autowired
    private BithumbCandleService candleService;

    @Scheduled(fixedRate = 1000)
    public void getBithumbCoinPrice() {
        WebClient webClient = WebClient.create("https://api.bithumb.com/public/candlestick");
        Mono<BithumbCandlestickResponse> mono = webClient.get()
                .uri("/BTC_KRW/1m")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(BithumbCandlestickResponse.class).doOnNext(candleService::printCandle);
    }
}
