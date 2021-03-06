
package org.hcl.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "org.hcl" })
@EnableWebMvc
public class WebMvcConfig {
	@Bean
	public InternalResourceViewResolver getView() {

		InternalResourceViewResolver internalview = new InternalResourceViewResolver();
		internalview.setPrefix("/WEB-INF/views/");
		internalview.setSuffix(".jsp");
		return internalview;
	}
}
