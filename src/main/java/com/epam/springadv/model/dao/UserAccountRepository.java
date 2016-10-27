package com.epam.springadv.model.dao;

import com.epam.springadv.model.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 26.10.2016.
 */

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    UserAccount findByUserId(Long userId);
}
