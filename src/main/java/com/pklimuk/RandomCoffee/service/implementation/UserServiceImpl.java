package com.pklimuk.RandomCoffee.service.implementation;

import com.pklimuk.RandomCoffee.model.User;
import com.pklimuk.RandomCoffee.repository.UserRepository;
import com.pklimuk.RandomCoffee.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        log.info("Saving new user with email: {}", user.getEmail());
        user.setImageUrl(setUserImageUrl());
        return userRepository.save(user);
    }

    @Override
    public Collection<User> list(int limit) {
        log.info("Fetching {} users", limit);
        return userRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public User get(Long id) {
        log.info("Fetching user with id: {}", id);
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        log.info("Updating user with email: {}", user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
        return TRUE;
    }

    private String setUserImageUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/image/defaultImage.png").toUriString();
    }
}
