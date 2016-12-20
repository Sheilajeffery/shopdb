package bootsample.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import bootsample.model.shop.Product;

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
					.packages(Product.class)
					.persistenceUnit("mysqlPU")
					.build();
	}
	
	@Bean(name = "shopTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("shopEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}	
}
