package org.vdoloka.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.vdoloka.entity.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {
    @Modifying
    @Query(value = "delete from orders o where o.product_id=:product_id", nativeQuery = true)
    int deleteAllByProductId(@Param("product_id") long productId);
}
