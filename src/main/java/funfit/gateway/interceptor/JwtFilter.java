package funfit.gateway.interceptor;

import funfit.gateway.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends AbstractGatewayFilterFactory {

    private final JwtUtils jwtUtils;

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("request.getId() = {}", request.getId());
            log.info("request.getPath() = {}", request.getPath());
            jwtUtils.validateAccessToken(request);

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                response.getStatusCode();}));
        };
    }
}
