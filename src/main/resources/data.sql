INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone)
    VALUES (1, 0, 'IBM', 'International Business Machines', '1234', '5678', 'ул.Цюрупы, 16', '911');
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone)
    VALUES (2, 0, 'SAP', 'Systemanalyse und Programmentwicklung', '2345', '65678', 'ул.Лунина, 7', '112');
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone)
    VALUES (3, 0, 'Dell', 'Dell Technologies Inc.', '312346', '75678', 'ул.Октябрьская, 1', '+7-095-02-02');
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone)
    VALUES (4, 0, 'Oracle', 'Oracle Corporation', '412347', '85678', 'ул.К.Маркса, 11', '+7-059-20-20');
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
    VALUES (5, 0, 'IBM', 'Fake IBM', '1234', '5678', 'ул.Цюрупы, 16', '911', FALSE);

INSERT INTO Office (id, version, name, address, phone, organization_id) VALUES (1, 0, 'IBM main office', 'ул.Цюрупы, 16', '911', 1);
INSERT INTO Office (id, version, name, address, phone, organization_id) VALUES (2, 0, 'SAP main office', 'ул.Лунина, 7', '8-915-4545', 2);
INSERT INTO Office (id, version, name, address, phone, organization_id) VALUES (3, 0, 'Dell office', 'ул.Луначарского, 1', '8-977-1234', 3);
INSERT INTO Office (id, version, name, address, phone, organization_id) VALUES (4, 0, 'Dell office', 'ул.Урицкого, 31', '8-977-1234', 3);
INSERT INTO Office (id, version, name, address, phone, organization_id) VALUES (5, 0, 'Oracle office', 'ул.Володарского, 11', '8-985-4568', 4);
INSERT INTO Office (id, version, name, address, phone, is_active, organization_id) VALUES (6, 0, 'Oracle office', 'ул.Кирова, 20', '8-985-4568', FALSE, 4);

INSERT INTO Country (code, name) VALUES ('010', 'Антарктида');
INSERT INTO Country (code, name) VALUES ('060', 'БЕРМУДЫ');
INSERT INTO Country (code, name) VALUES ('643', 'Российская Федерация');
INSERT INTO Country (code, name) VALUES ('646', 'Руандийская Республика');

INSERT INTO Document_Type (code, name) VALUES ('03', 'Свидетельство о рождении');
INSERT INTO Document_Type (code, name) VALUES ('07', 'Военный билет');
INSERT INTO Document_Type (code, name) VALUES ('21', 'Паспорт гражданина РФ');

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, office_id, country_code)
    VALUES (1, 0, 'Пётр', 'Петров', 'Петрович', 'proger', '8-789-465-11-11', 1, '643');
INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, is_identified, office_id, country_code)
    VALUES (2, 0, 'John', 'Smith', 'Петрович', 'coder', '8-654-987-7-7',  FALSE, 1, '643');
INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, office_id, country_code)
    VALUES (3, 0, 'John', 'Snow', 'Иванович', 'developer', '8-987-123-11', 5, '643');
INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, office_id, country_code)
    VALUES (4, 0, 'Иван', 'Smith', 'Иванович', 'developer', '8-999-123-11', 6, '010');

INSERT INTO Document (id, version, doc_number, doc_date, doc_code) VALUES (1, 0, '1234 567891', '2017-05-23', '21');
INSERT INTO Document (id, version, doc_number, doc_date, doc_code) VALUES (2, 0, '2345 678912', '2017-05-23', '07');
INSERT INTO Document (id, version, doc_number, doc_date, doc_code) VALUES (3, 0, '3456 789123', '2020-11-19', '07');
INSERT INTO Document (id, version, doc_number, doc_date, doc_code) VALUES (4, 0, '159487', '2000-09-19', '21');