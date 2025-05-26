package store.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order", url = "http://order:8080")
public interface OrderController {

    @PostMapping("/order")
    public ResponseEntity<OrderOut> createOrder(
        @RequestHeader(value = "id-account", required = true) String accountId,
        @RequestBody OrderIn orderIn
    );

    @GetMapping("/order")
    public ResponseEntity<List<OrderOut>> getAllOrders(
        @RequestHeader(value = "id-account", required = true) String accountId
    );

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderOut> getOrderById(
        @RequestHeader(value = "id-account", required = true) String accountId,
        @PathVariable("id") String orderId
    );

    @DeleteMapping("/order/{id}")
    public void deleteOrder(
        @RequestHeader(value = "id-account", required = true) String accountId,
        @PathVariable("id") String orderId
    );

}
