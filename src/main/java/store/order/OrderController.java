package store.order;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order", url = "http://order:8080")
@RequestMapping("/order")
public interface OrderController {

    @PostMapping
    ResponseEntity<OrderOut> create(
        @RequestHeader("id-account") String idAccount,
        @RequestBody OrderIn orderIn
    );

    @GetMapping
    ResponseEntity<List<OrderOut>> findAll(
        @RequestHeader("id-account") String idAccount
    );

    @GetMapping("/{id}")
    ResponseEntity<OrderDetailOut> findById(
        @RequestHeader("id-account") String idAccount,
        @PathVariable String id
    );

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(
        @RequestHeader("id-account") String idAccount,
        @PathVariable String id
    );

}