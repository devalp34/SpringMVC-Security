package com.pkg.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pkg")
@PropertySource("classPath:persistence-mysql.properties")
public class appConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver viewResolver()
	{
		
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/view/");
		irv.setSuffix(".jsp");
		return irv;
	}

	@Bean
	public DataSource secureData() throws PropertyVetoException
	{
		ComboPooledDataSource  cpd = new ComboPooledDataSource();
		
		// Setting Connection with mySql DB
		cpd.setDriverClass(env.getProperty("jdbc.driver"));
		
		System.out.println("jdbc.url="+env.getProperty("jdbc.url"));
		System.out.println("jdbc.url="+env.getProperty("jdbc.user"));
		
		cpd.setJdbcUrl(env.getProperty("jdbc.url"));
		cpd.setUser(env.getProperty("jdbc.user"));
		cpd.setPassword(env.getProperty("jdbc.password"));
		
		// Setting Connection pool 
		cpd.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		cpd.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		cpd.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		cpd.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return cpd;
	}
	
	public int getIntProperty(String temp)
	{
		String temp1 = env.getProperty(temp);
		int n = Integer.parseInt(temp1);
		return n;
	}
	
}
