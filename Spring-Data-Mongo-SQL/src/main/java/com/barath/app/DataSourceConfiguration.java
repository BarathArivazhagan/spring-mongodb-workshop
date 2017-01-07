package com.barath.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@Configuration
public class DataSourceConfiguration {
	
	
	@Bean(destroyMethod="close")
	public MongoClient mongoClient(MongoClientOptions mongoClientOptions){
		
		MongoClient mongoClient=new MongoClient("localhost", 27017);
		
		return mongoClient;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPackagesToScan("com.barath.app");
		entityManagerFactory.setPersistenceUnitName("test");
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaDialect(jpaDialect());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		return entityManagerFactory;
	}
	
	@Bean
	public DriverManagerDataSource dataSource(){
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");	
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("barath");
		return dataSource;
	}
	
	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter(){
		
		HibernateJpaVendorAdapter jpaVendorAdapter=new  HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL94Dialect");
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
	}

	@Bean
	public HibernateJpaDialect jpaDialect(){
		return new HibernateJpaDialect();
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager=new JpaTransactionManager();
		transactionManager.setDataSource(dataSource());
		transactionManager.setJpaDialect(jpaDialect());
		return transactionManager;
	}
	
	
	
	
	@Bean
	public  MongoClientOptions mongoClientOptions(){
		
		MongoClientOptions.Builder builder = MongoClientOptions.builder();
		//MongoClientOptions options=builder.sslEnabled(true).build();		
		return builder.build();
	}

}
