package ru.stepanov.core.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.stepanov.core.filters.HttpServletRequestFilter;
import ru.stepanov.route.auth.interfaces.IAuthenticationService;
import ru.stepanov.route.auth.services.AuthenticationService;


@Configuration
@EnableDiscoveryClient
public class MicroservicesConfiguration {

    private final DiscoveryClient discoveryClient;

    public MicroservicesConfiguration(@Autowired DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    IAuthenticationService authenticationService(){
        return new AuthenticationService(restTemplate());
    }


    @Bean
    public FilterRegistrationBean filterRegistrationService() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestFilter());
        return registration;
    }
}
