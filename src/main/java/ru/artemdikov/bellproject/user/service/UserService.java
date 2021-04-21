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
     * @return List<UserDto>
     */
    List<UserDto> allUsers();

    /**
     * Получить отфильтрованный список пользователей
     * @param userFilter - фильтр пользователей
     * @return List<UserDtoShort>
     */
    List<UserDtoShort> filteredUserList(@Valid UserFilter userFilter);

    /**
     * Получить User по id
     * @param id - идентификатор
     * @return UserDto
     */
    UserDto getById(Long id);

    /**
     * Добавить нового User
     *
     * @param userDto
     */
    @Validated({OnCreate.class, Default.class})
    void add(@Valid UserDto userDto);

    /**
     * Обновить User
     *
     * @param userDto
     */
    @Validated({OnUpdate.class, Default.class})
    void update(@Valid UserDto userDto);
}
