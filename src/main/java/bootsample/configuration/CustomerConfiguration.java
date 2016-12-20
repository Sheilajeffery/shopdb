package bootsample.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import bootsample.model.customers.Customer;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "customerEntityManager",
		transactionManagerRef = "customerTransactionManager", 
		basePackages = "bootsample.dao.customers"
)
public class CustomerConfiguration {
	
	@Bean(name="customerDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.customersource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "customerEntityManager")
	public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		
		return builder
					.dataSource(primaryDataSource())
					.packages(Customer.class)
					.persistenceUnit("mysqlPU")
					.build();
	}

	@Primary
	@Bean(name = "customerTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("customerEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
