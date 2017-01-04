package bootsample.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import bootsample.model.shop.Cart;
import bootsample.model.shop.Cart_detail;
import bootsample.model.shop.Product;
import bootsample.model.shop.Review;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "shopEntityManager",
		transactionManagerRef = "shopTransactionManager", 
		basePackages = "bootsample.dao.shop"
)
public class ShopConfiguration {

	@Bean(name="shopDataSource")
	@ConfigurationProperties(prefix="spring.shopsource")
	public DataSource secondDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "shopEntityManager")
	public LocalContainerEntityManagerFactoryBean shopEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		
		return builder
					.dataSource(secondDataSource())
					.properties(hibernateProperties())
					.packages(Product.class,Cart.class,Cart_detail.class,Review.class)
					.persistenceUnit("mysqlPU")
					.build();
	}
	
	@Bean(name = "shopTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("shopEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}	

	private Map<String, Object> hibernateProperties() {

		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			return properties.entrySet().stream()
											.collect(Collectors.toMap(
														e -> e.getKey().toString(),
														e -> e.getValue())
													);
		} catch (IOException e) {
			return new HashMap<String, Object>();
		}
	}


}
