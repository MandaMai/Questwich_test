package com.questwich.questwichbe.repositories;

import com.questwich.questwichbe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Override
    User findOne(String id);

    @Override
    void delete(User deleted);
}