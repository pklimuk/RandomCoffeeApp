package com.pklimuk.RandomCoffee.service;

import com.pklimuk.RandomCoffee.model.User;

import java.util.Collection;

public interface UserService {
    User create(User user);
    Collection<User> list(int limit);
    User get(Long id);
    User update(User user);
    Boolean delete(Long id);
}
