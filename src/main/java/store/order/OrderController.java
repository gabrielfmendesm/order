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
        @RequestBody OrderIn orderIn
    );

    @GetMapping
    ResponseEntity<List<OrderOut>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<OrderOut> findById(
        @PathVariable String id
    );

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(
        @PathVariable String id
    );

}