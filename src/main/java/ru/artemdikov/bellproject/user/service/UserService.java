package ru.artemdikov.bellproject.user.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.dto.UserDtoShort;
import ru.artemdikov.bellproject.user.dto.UserFilter;

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
     * Получить отфильтрованный список пользователей
     *
     * @return {@List<UserDtoShort>}
     */
    List<UserDtoShort> filteredUserList(@Valid UserFilter userFilter);

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
    void update(@Valid UserDto userDto);
}
