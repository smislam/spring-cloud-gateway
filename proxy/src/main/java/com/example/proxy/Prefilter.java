package com.example.proxy;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

@Configuration
public class Prefilter {

    @Bean
    @Order(-1)
    public GlobalFilter preGlobalFilter() {

        return (exchange, chain) -> exchange.getPrincipal()
            .map(p -> {

                if (p instanceof Authentication) {
                    Authentication authentication = (Authentication) p;
                    Object principal = authentication.getPrincipal();
                    System.out.println(principal.getClass());
                    if (principal instanceof DefaultOidcUser) {
                        DefaultOidcUser user = (DefaultOidcUser) principal;

                        exchange.getRequest().mutate().header("x-x-x-x-x", user.toString()).build();
                    }
                }

                return exchange;
            })
            .flatMap(chain::filter);
    }
}
