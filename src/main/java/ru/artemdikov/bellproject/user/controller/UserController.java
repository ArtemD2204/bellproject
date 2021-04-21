package ru.artemdikov.bellproject.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.dto.UserDtoShort;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для работы с User
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    /**
     * Конструктор
     * @param userService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Сохранить нового пользователя
     * @param user - пользователь
     */
    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto user) {
        userService.add(user);
    }

    /**
     * Обновить пользователя
     * @param user
     */
    @PostMapping("/update")
    public void updateUser(@RequestBody UserDto user) {
        userService.update(user);
    }

    /**
     * Получить всех пользователей
     * @return List<UserDto>
     */
    @GetMapping("/all")
    public List<UserDto> allUsers() {
        return userService.allUsers();
    }

    /**
     * Получить пользователя по id
     * @param id - идентификатор
     * @return UserDto
     */
    @GetMapping("/{id}")
    public UserDto user(@PathVariable Long id) {
        return userService.getById(id);
    }

    /**
     * Получить отфильтрованный список пользователей
     * @param userFilter - фильтр пользователей
     * @return List<UserDtoShort>
     */
    @PostMapping("/list")
    public List<UserDtoShort> list(@RequestBody UserFilter userFilter) {
        return userService.filteredUserList(userFilter);
    }
}
