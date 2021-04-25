# Project

Для того, чтобы клонировать репозиторий по SSH, необходимо выполнить в консоли следующую команду  
git clone git@github.com:ArtemD2204/bellproject.git  
Чтобы клонировать репозиторий по HTTPS, необходимо выполнить  
git clone https://github.com/ArtemD2204/bellproject.git

Для запуска приложения необходимо в консоли перейти в папку с проектом и выполнить  
mvn spring-boot:run

Проект будет доступен по url: http://localhost:8888

Все описанные возвращаемые данные находятся в параметре data. В случае ошибки возвращается параметр error.

Например, в случае, если запрос корректно отработает, бэк возвратит данные в body ответа:
```json
{
    "data":{
        // возвращаемые данные
    }
}
```


А в случае ошибки возвратит
```json
{
    "error":"текст ошибки"
}
```
## Запросы

#### 1. Получить отфильтрованный список организаций
api/organization/list  
method:POST

In (фильтр в body запроса):
```json
{
  "name":"", //обязательный параметр
  "inn":"",
  "isActive":""
}
```
Out:
```json
{
    "data": [
        {
            "id":"",
            "name":"",
            "isActive":"true"
        },
        ...
    ]
}
```
Пример  
In:
```json
{
   "name": "IBM",
   "inn": "1234",
   "isActive": ""
}
```
Out:
```json
{
    "data": [
        {
            "id": 1,
            "name": "IBM",
            "isActive": true
        },
        {
            "id": 5,
            "name": "IBM",
            "isActive": false
        }
    ]
}
```
#### 2. Получить организацию по id
api/organization/{id}  
method:GET

Out:
```json
{
    "data":{
        "id":"",
        "name":"",
        "fullName":"",
        "inn":"",
        "kpp":"",
        "address":"",
        "phone":"",
        "isActive": true
    }
}
```
Пример  
url: http://localhost:8888/api/organization/5  
Out:
```json
{
    "data": {
        "id": 5,
        "name": "IBM",
        "fullName": "International Business Machines",
        "inn": "1234",
        "kpp": "5678",
        "address": "ул.Цюрупы, 16",
        "phone": "911",
        "isActive": true
    }
}
```
#### 3. Получить все организации
method:GET  
/api/organization/all

Out:
```json
{
    "data": [
        {
            "id": 1,
            "name": "IBM",
            "fullName": "International Business Machines",
            "inn": "1234",
            "kpp": "5678",
            "address": "ул.Цюрупы, 16",
            "phone": "911",
            "isActive": true
        },
        ...
    ]
}
```
#### 4. Обновить организацию
method:POST  
api/organization/update

In:
```json
{
    "id":"", //обязательный параметр
    "name":"", //обязательный параметр
    "fullName":"", //обязательный параметр
    "inn":"", //обязательный параметр
    "kpp":"",  //обязательный параметр
    "address":"", //обязательный параметр
    "phone":"",
    "isActive":"true"
}
```
Out:
```json
{
    "result":"success"
}
```
Пример  
In:
```json
{
    "id": 4,
    "name": "SAP",
    "fullName": "Systemanalyse und Programmentwicklung",
    "inn": "412347",
    "kpp": "85678",
    "address": "ул.К.Маркса, 11",
    "isActive": true
}
```
Out:
```json
{
    "result": "success"
}
```
#### 5. Сохранить новую организацию
method:POST  
api/organization/save

In:
```json
{
    "name":"", //обязательный параметр
    "fullName":"", //обязательный параметр
    "inn":"", //обязательный параметр
    "kpp":"", //обязательный параметр
    "address":"", //обязательный параметр
    "phone":"",
    "isActive":"true"
}
```
Out:
```json
{
    "result":"success"
}
```
Примет  
In:
```json
{
    "name": "SAP",
    "fullName": "Systemanalyse und Programmentwicklung",
    "inn": "412347",
    "kpp": "85678",
    "address": "ул.К.Маркса, 11",
    "phone": "8-123-456-78-90",
    "isActive": true
}
```
Out:
```json
{
    "result": "success"
}
```
#### 6. Получить отфильтрованный список офисов
method:POST  
api/office/list

In (фильтр в body запроса):
```json
{
  "orgId":"", //обязательный параметр
  "name":"",
  "phone":"",
  "isActive": ""
}
```
Out:
```json
{
    "data": [
        {
            "id":"",
            "name":"",
            "isActive":""
        },
        ...
    ]
}
```
Пример  
In:
```json
{
    "orgId": 1,
    "name":"IBM main office",
    "phone":"123-456-789",
    "isActive": true
}
```
Out:
```json
{
    "data": [
        {
            "id": 23,
            "name": "IBM main office",
            "isActive": true
        }
    ]
}
```
#### 7. Получить офис по id
api/office/{id}  
method:GET

Out:
```json
{
    "data": {
        "id":"",
        "name":"",
        "address":"",
        "phone":"",
        "isActive":"",
        "orgId": ""
    }
}
```
Пример  
url: http://localhost:8888/api/office/4  
Out:
```json
{
    "data": {
        "id": 4,
        "name": "Dell office",
        "address": "ул.Урицкого, 31",
        "phone": "8-977-1234",
        "isActive": true,
        "orgId": 3
    }
}
```
#### 8. Получить все офисы
method:GET  
http://localhost:8888/api/office/all

Out:
```json
{
    "data": [
        {
            "id": 1,
            "name": "IBM main office",
            "address": "ул.Цюрупы, 16",
            "phone": "911",
            "isActive": true,
            "orgId": 1
        },
        ...
    ]
}
```
#### 9. Обновить офис
method:POST  
api/office/update

In:
```json
{
  "id":"", //обязательный параметр
  "name":"", //обязательный параметр
  "address":"", //обязательный параметр
  "phone":"",
  "isActive": true //пример
}
```
Out:
```json
{
    "result":"success"
}
```
Пример  
In:
```json
{
    "id": 6,
    "name": "Oracle office",
    "address": "ул.Кирова, 20",
    "phone": "8-985-4568",
    "isActive": true
}
```
Out:
```json
{
    "result": "success"
}
```
#### 10. Сохранить новый офис
method:POST  
api/office/save

In:
```json
{
    "orgId":"", //обязательный параметр
    "name":"",
    "address":"",
    "phone":"",
    "isActive":"true" // пример
}
```
Out:
```json
{
    "result":"success"
}
```
Пример  
In:
```json
{
    "orgId": 2,
    "name": "Oracle office",
    "address": "ул.Кирова, 20",
    "phone": "+7-123-4567",
    "isActive": true
}
```
Out:
```json
{
    "result": "success"
}
```

#### 11. Получить отфильтрованный список пользователей
method: POST  
api/user/list

In (фильтр):
```json
{
    "officeId":"", //обязательный параметр
    "firstName":"",
    "lastName":"",
    "middleName":"",
    "position","",
    "docCode":"",
    "citizenshipCode":""
}
```
Out:
```json
{
    "data": [
        {
            "id": """,
            "firstName": "",
            "secondName": "",
            "middleName": "",
            "position": ""
        },
        ...
    ]
}
```
Пример  
In:
```json
{
    "officeId": 1,
    "firstName": "Пётр",
    "secondName": "Петров",
    "middleName": "Петрович",
    "position": "",
    "docCode": "21",
    "citizenshipCode": "643"
}
```
Out:
```json
{
    "data": [
        {
            "id": 1,
            "firstName": "Пётр",
            "secondName": "Петров",
            "middleName": "Петрович",
            "position": "manager"
        },
        {
            "id": 2,
            "firstName": "Пётр",
            "secondName": "Петров",
            "middleName": "Петрович",
            "position": "lawyer"
        }
    ]
}
```
#### 12. Получить пользователя по id
api/user/{id}  
method:GET

Out:
```json
{
    data: {
        "id":"",
        "firstName":"",
        "secondName":"",
        "middleName":"",
        "position":""
        "phone","",
        "docName":"",
        "docNumber":"",
        "docDate":"",
        "citizenshipName":"",
        "citizenshipCode":"",
        "isIdentified":"true"
    }
}
```
Пример  
url: http://localhost:8888/api/user/3  
Out:
```json
{
    "data": {
        "id": 3,
        "firstName": "Иван",
        "secondName": "Иванов",
        "middleName": "Иванович",
        "position": "developer",
        "phone": "8-999-123-11",
        "officeId": 6,
        "docCode": "21",
        "docName": "Паспорт гражданина РФ",
        "docNumber": "159487",
        "docDate": "2000-09-19",
        "citizenshipCode": "643",
        "citizenshipName": "Российская Федерация",
        "identified": true
    }
}
```
#### 13. Получить всех пользователей
method:GET  
http://localhost:8888/api/user/all

Out:
```json
{
    "data": [
        {
            "id": 1,
            "firstName": "Пётр",
            "secondName": "Петров",
            "middleName": "Петрович",
            "position": "manager",
            "phone": "8-789-465-11-11",
            "officeId": 12,
            "docCode": "21",
            "docName": "Паспорт гражданина РФ",
            "docNumber": "1234 567891",
            "docDate": "2017-05-23",
            "citizenshipCode": "643",
            "citizenshipName": "Российская Федерация",
            "identified": true
        },
        ...
    ]
}
```
#### 14. Обновить пользователя
method: POST  
api/user/update

In:
```json
{
    "id":"", //обязательный параметр
    "officeId":"",
    "firstName":"", //обязательный параметр
    "secondName":"",
    "middleName":"",
    "position":"" //обязательный параметр
    "phone","",
    "docName":"",
    "docNumber":"",
    "docDate":"",
    "citizenshipCode":"",
    "isIdentified":"true" //пример
}
```
Out:
```json
{
    "result":"success"
}
```
Пример  
In:
```json
{
    "id": 4,
    "officeId": 3,
    "firstName": "Петр",
    "secondName": "Петров",
    "middleName": "Иванович",
    "position": "Senior Developer",
    "phone": "8-123-13-7-7",
    "docName": "Паспорт гражданина РФ",
    "docNumber": "1591287",
    "docDate": "2001-09-19",
    "citizenshipCode": "643",
    "isIdentified":"true"
}
```
Out:
```json
{
    "result": "success"
}
```
#### 15. Сохранить нового пользователя
method: POST  
api/user/save

In:
```json
{
    "officeId":"", //обязательный параметр
    "firstName":"", //обязательный параметр
    "secondName":"",
    "middleName":"",
    "position":"" //обязательный параметр
    "phone","",
    "docCode":"",
    "docName":"",
    "docNumber":"",
    "docDate":"",
    "citizenshipCode":"",
    "isIdentified":"true" //пример
}
```
Out:
```json
{
    "result": "success"
}
```
Пример  
In:
```json
{
    "officeId": 4,
    "firstName": "Александр",
    "secondName": "Петров",
    "middleName": "Иванович",
    "position": "Senior Developer",
    "phone": "8-123-13-7-7",
    "docCode": "21",
    "docName": "Паспорт гражданина РФ",
    "docNumber": "1591287",
    "docDate": "2001-09-19",
    "citizenshipCode": "643",
    "isIdentified":"true"
}
```
Out:
```json
{
    "result": "success"
}
```
#### 16. Справочник типов документов. Получить все типы документов
method: GET  
/api/docs

Out:
```json
{
    "data": [
        {
            "code": "03",
            "name": "Свидетельство о рождении"
        },
        {
            "code": "07",
            "name": "Военный билет"
        },
        {
            "code": "21",
            "name": "Паспорт гражданина РФ"
        },
        ...
    ]
}
```
#### 17. Справочник стран. Получить все страны
method: GET  
/api/countries

Out:
```json
{
    "data": [
        {
            "code": "643",
            "name": "Российская Федерация"
        },
        {
            "code": "646",
            "name": "Руандийская Республика"
        },
        ...
    ]
}
```
