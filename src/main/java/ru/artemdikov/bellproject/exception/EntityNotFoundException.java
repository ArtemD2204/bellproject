package ru.artemdikov.bellproject.exception;

/**
 * Исключение ru.artemdikov.bellproject.exception.EntityNotFoundException
 * используется в случае, если запрос к БД вернул null или пустую коллекцию
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
