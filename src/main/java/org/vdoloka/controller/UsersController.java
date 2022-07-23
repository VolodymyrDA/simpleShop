package org.vdoloka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vdoloka.entity.UserEntity;
import org.vdoloka.repository.UsersRepository;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @GetMapping
    public ResponseEntity<Iterable<UserEntity>> getUsers() {
        return new ResponseEntity<>(usersRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid UserEntity userEntity) {
        usersRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(usersRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@Valid UserEntity userEntity) {
        usersRepository.save(userEntity);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserById(@PathVariable(value = "id") long id) {
        usersRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/product/{id}")
    public Iterable<UserEntity> getProducts(@PathVariable(value = "id") long id) {
        return usersRepository.findAllByProductId(id);
    }
}