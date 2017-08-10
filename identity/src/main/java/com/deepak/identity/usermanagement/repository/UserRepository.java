package com.deepak.identity.usermanagement.repository;

import com.deepak.identity.usermanagement.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dgangore on 8/10/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUserId(long userId);
}
