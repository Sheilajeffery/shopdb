package bootsample;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class Application {
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.customersource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.shopsource")
	public DataSource secondDataSource() {
	    return DataSourceBuilder.create().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}