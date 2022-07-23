package org.vdoloka.repository;


import org.springframework.data.repository.CrudRepository;
import org.vdoloka.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {
}
