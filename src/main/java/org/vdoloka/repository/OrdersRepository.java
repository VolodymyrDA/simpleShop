package org.vdoloka.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.vdoloka.entity.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {
//    @Query("select s from ORDERS s where s.name = :name")
//    void save(@Param("name") String userId,String productId);
}
