package org.vdoloka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.vdoloka.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {
    @Query(value = "select p.id,p.name,p.price from orders o join products p on p.id = o.user_id " +
            "where o.user_id = :user_id", nativeQuery = true)
    Iterable<ProductEntity> findAllByUserId(@Param("user_id") long userId);
}

