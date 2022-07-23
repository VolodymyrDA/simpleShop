package org.vdoloka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vdoloka.entity.UserEntity;
import org.vdoloka.repository.UsersRepository;

@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @GetMapping("/")
    public Iterable<UserEntity> getUsers() {
        return usersRepository.findAll();
    }

}