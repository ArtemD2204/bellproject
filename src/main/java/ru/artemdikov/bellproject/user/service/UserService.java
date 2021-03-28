package ru.artemdikov.bellproject.user.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.user.dto.UserDto;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface UserService {

    /**
     * Получить список всех пользователей
     *
     * @return {@List<UserDto>}
     */
    List<UserDto> allUsers();

    /**
     * Получить User по id
     *
     * @return {UserDto}
     */
    UserDto getById(Long id);

    /**
     * Добавить нового пользователя User в БД
     *
     * @param userDto
     */
    void add(@Valid UserDto userDto);

    /**
     * Обновить пользователя User в БД
     *
     * @param userDto
     */
    void update(UserDto userDto);
}
