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
     * Добавить нового пользователя в БД
     *
     * @param userDto
     */
    void add(@Valid UserDto userDto);

    /**
     * Получить список пользователей
     *
     * @return {@User}
     */
    List<UserDto> users();
}
