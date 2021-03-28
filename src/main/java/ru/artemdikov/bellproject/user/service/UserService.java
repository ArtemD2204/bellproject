package ru.artemdikov.bellproject.user.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.dto.UserDtoShort;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    List<UserDtoShort> filteredUserList(Map<String, Object> filters);

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
