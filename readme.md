# Project
Как скачать

Для запуска приложения необходимо в корневой папке выполнить команду
 mvn spring-boot:run

Пример запроса GET  http://localhost:8888/api/office/4

В теле ответа возвращается JSON. Пример:
{
    "data": {
        "id": 4,
        "name": "Dell office",
        "address": "ул.Урицкого, 31",
        "phone": "8-977-145-1234",
        "orgId": 3,
        "active": true
    }
}