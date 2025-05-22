package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderItemOut(
    String id,
    ProductRef product,
    Integer quantity,
    Double total
) {}
