package org.vdoloka.repository;


import org.springframework.data.repository.CrudRepository;
import org.vdoloka.entity.UserEntity;


public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}
