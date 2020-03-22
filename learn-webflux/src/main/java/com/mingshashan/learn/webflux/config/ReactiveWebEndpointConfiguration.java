package com.mingshashan.learn.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * ReactiveWebEndpointConfiguration
 *
 * @author jasonxu
 */
@Configuration
public class ReactiveWebEndpointConfiguration {

    @Bean
    public RouterFunction<ServerResponse> hello() {
        return route(GET("hello"), request -> ServerResponse.ok()
                .body(Mono.just("Hello World!"), String.class));
    }
}
