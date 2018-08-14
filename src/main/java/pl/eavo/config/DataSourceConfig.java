package pl.eavo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("root")
                .password("root")
                .url("jdbc:mysql://localhost:3306/eavo")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }

}
