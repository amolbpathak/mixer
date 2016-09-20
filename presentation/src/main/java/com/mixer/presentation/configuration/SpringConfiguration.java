package com.mixer.presentation.configuration;

/**
 * 
 * @author Amol
 *
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;



/*
 * @EnableWebMvc : <mvc:annotation-driven /> 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mixer.presentation")
public class SpringConfiguration extends WebMvcConfigurerAdapter{

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(
				"WEB-INF/static/");
		registry.addResourceHandler("/pages/**").addResourceLocations(
				"WEB-INF/static/html/");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean
	public UrlBasedViewResolver staticViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setOrder(2);
		viewResolver.setPrefix("/WEB-INF/static/");
		viewResolver.setSuffix(".html");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	 
}
