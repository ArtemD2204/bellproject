package ru.artemdikov.bellproject.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.dto.UserDtoShort;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto user) {
        userService.add(user);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody UserDto user) {
        userService.update(user);
    }

    @GetMapping("/all")
    public List<UserDto> allUsers() {
        return userService.allUsers();
    }

    @GetMapping("/{id}")
    public UserDto user(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/list")
    public List<UserDtoShort> list(@RequestBody UserFilter userFilter) {
        return userService.filteredUserList(userFilter);
    }
}
