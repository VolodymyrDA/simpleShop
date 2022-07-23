package org.vdoloka.repository;

import org.springframework.data.repository.CrudRepository;
import org.vdoloka.entity.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {

}
