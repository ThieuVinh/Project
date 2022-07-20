package su22.assignment.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfigguration implements WebMvcConfigurer{
	@Autowired
	private AuthenticationInterceptor ai;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ai).addPathPatterns("/**").excludePathPatterns("/login/**");
	}
}
