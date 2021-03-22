INSERT INTO Office (id, version, name, address, phone) VALUES (1, 0, 'IBM', 'ул.Цюрупы, 16', '911');
--
-- INSERT INTO Office (id, version, address) VALUES (2, 0, 'ул.Лунина, 7');
--
INSERT INTO User (id, version, first_name, position, office_id) VALUES (1, 0, 'Пётр', 'proger', 1);
INSERT INTO User (id, version, first_name, position, office_id) VALUES (2, 0, 'John', 'coder', 1);
--
-- INSERT INTO User (id, version, first_name, age) VALUES (2, 0, 'John', 25);
--
-- INSERT INTO Person_House (person_id, house_id) VALUES (1, 1);
--
-- INSERT INTO Person_House (person_id, house_id) VALUES (1, 2);