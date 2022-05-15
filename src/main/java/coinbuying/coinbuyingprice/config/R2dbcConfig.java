package coinbuying.coinbuyingprice.config;

import coinbuying.coinbuyingprice.model.CoinPriceFactory;
import coinbuying.coinbuyingprice.repository.CoinPriceRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
public class R2dbcConfig {

    private final CoinPriceFactory userAssetFactory;

    @Autowired
    public R2dbcConfig(CoinPriceFactory userAssetFactory) {
        this.userAssetFactory = userAssetFactory;
    }

    @Bean
    public ConnectionFactoryInitializer dbInit(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer init = new ConnectionFactoryInitializer();
        init.setConnectionFactory(connectionFactory);
        init.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return init;
    }

    @Bean
    public CommandLineRunner dataInit(CoinPriceRepository userAssetRepository) {
        return (args) -> {
            userAssetRepository.saveAll(
                    userAssetFactory.setupListBuilder()
            ).blockLast();
        };
    }


}
