package ru.artemdikov.bellproject.user.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.dto.UserDtoShort;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.validation.group.Default;
import ru.artemdikov.bellproject.validation.group.OnCreate;
import ru.artemdikov.bellproject.validation.group.OnUpdate;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для работы с User
 */
@Validated
public interface UserService {

    /**
     * Получить список всех пользователей
     *
     * @return возвращает список всех пользователей
     */
    List<UserDto> allUsers();

    /**
     * Получить отфильтрованный список пользователей
     * @param userFilter - фильтр пользователей
     * @return возвращает отфильтрованный список пользователей
     */
    List<UserDtoShort> filteredUserList(@Valid UserFilter userFilter);

    /**
     * Получить пользователя по id
     * @param id - идентификатор
     * @return возвращает пользователя
     */
    UserDto getById(Long id);

    /**
     * Добавить нового пользователя
     *
     * @param userDto - пользователь
     */
    @Validated({OnCreate.class, Default.class})
    void add(@Valid UserDto userDto);

    /**
     * Обновить пользователя
     *
     * @param userDto - пользователь
     */
    @Validated({OnUpdate.class, Default.class})
    void update(@Valid UserDto userDto);
}
