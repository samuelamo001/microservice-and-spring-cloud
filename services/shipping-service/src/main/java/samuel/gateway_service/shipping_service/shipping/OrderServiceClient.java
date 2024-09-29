package samuel.gateway_service.shipping_service.shipping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import order.microservice.orderservice.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8030")
public interface OrderServiceClient {

    Logger logger = LoggerFactory.getLogger(OrderServiceClient.class);

    @CircuitBreaker(name = "orderServiceClient", fallbackMethod = "getOrderByIdFallback")
    @GetMapping("/api/v1/orders/shipping/{orderId}")
    OrderRequest getOrderById(@PathVariable("orderId") Long orderId);


    default OrderRequest getOrderByIdFallback(Long orderId, Throwable throwable) {
        logger.error("Circuit breaker triggered for orderId: {}. Error: {}", orderId, throwable.getMessage());


        String fallbackMessage = "Our order service is temporarily unavailable. "
                + "Please try again in a few minutes. Thank you for your patience!";

        return new OrderRequest(
                orderId,
                -1L,
                "",
                fallbackMessage,
                0,
                0.0
        );
    }
}

