package org.vdoloka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.vdoloka.entity.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    @Query(value = "select u.id,u.first_name,u.last_name,u.ammount_money from orders o join users u on o.user_id = u.id " +
            "where o.product_id = :product_id", nativeQuery = true)
    Iterable<UserEntity> findAllByProductId(@Param("product_id") long productId);
}