package coinbuying.coinbuyingprice.controller;

import coinbuying.coinbuyingprice.service.BithumbCandleService;
import coinbuying.coinbuyingprice.vo.BithumbCandlestickResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ClientContoller {
    @Autowired
    private BithumbCandleService candleService;

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<BithumbCandlestickResponse> getBithumbCandlestick() {
        WebClient webClient = WebClient.create("https://api.bithumb.com/public/candlestick");
        Mono<BithumbCandlestickResponse> mono = webClient.get()
                .uri("/BTC_KRW/1m")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(BithumbCandlestickResponse.class).doOnNext(candleService::printCandle);
        return mono;
    }
}
