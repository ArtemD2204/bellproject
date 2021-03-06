CREATE TABLE IF NOT EXISTS Organization (
    id         BIGINT                   COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL         COMMENT 'Служебное поле hibernate',
    name       VARCHAR(150) NOT NULL    COMMENT 'Название',
    full_name  VARCHAR(255) NOT NULL    COMMENT 'Полное название',
    inn        VARCHAR(20) NOT NULL     COMMENT 'ИНН',
    kpp        VARCHAR(20) NOT NULL     COMMENT 'КПП',
    address    VARCHAR(255) NOT NULL    COMMENT 'Адрес',
    phone      VARCHAR(30)              COMMENT 'Телефон',
    is_active  BOOLEAN DEFAULT true
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office (
    id                  BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version             INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    name                VARCHAR(150)            COMMENT 'Название',
    address             VARCHAR(255)            COMMENT 'Адрес',
    phone               VARCHAR(30)             COMMENT 'Телефон',
    is_active           BOOLEAN DEFAULT true    COMMENT 'Просто boolean',
    organization_id     BIGINT  NOT NULL        COMMENT 'Уникальный идентификатор организации'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User (
    user_id         BIGINT                  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version         INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
    first_name      VARCHAR(50) NOT NULL    COMMENT 'Имя',
    second_name     VARCHAR(50)             COMMENT 'Фамилия',
    middle_name     VARCHAR(50)             COMMENT 'Отчество',
    position        VARCHAR(100) NOT NULL   COMMENT 'Должность',
    phone           VARCHAR(30)             COMMENT 'Телефон',
    is_identified   BOOLEAN DEFAULT true    COMMENT 'Просто boolean',
    office_id       BIGINT  NOT NULL        COMMENT 'Офис',
    country_code    CHAR(3)                 COMMENT 'Код страны'
);
COMMENT ON TABLE User IS 'Пользователь';

CREATE TABLE IF NOT EXISTS Document (
    doc_id     BIGINT               COMMENT 'Уникальный идентификатор и foreign key на User' PRIMARY KEY,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    doc_number VARCHAR(30)          COMMENT 'Номер документа',
    doc_date   DATE                 COMMENT 'Дата документа',
    doc_code   CHAR(2)              COMMENT 'Тип документа'
);

CREATE TABLE IF NOT EXISTS Document_Type (
    code       CHAR(2)                COMMENT 'Код типа документа - Уникальный идентификатор' PRIMARY KEY ,
    name       VARCHAR(150) NOT NULL  COMMENT 'Название типа документа'
);

CREATE TABLE IF NOT EXISTS Country (
    code       CHAR(3)                COMMENT 'Код страны - Уникальный идентификатор' PRIMARY KEY ,
    name       VARCHAR(150) NOT NULL  COMMENT 'Название страны'
);

-- Organization indexes and foreign keys
CREATE INDEX IX_Organization_Name ON Organization (name);
CREATE INDEX IX_Organization_INN ON Organization (inn);
CREATE INDEX IX_Organization_Is_Active ON Organization (is_active);

-- Office indexes and foreign keys
CREATE INDEX IX_Office_Organization_Id ON Office (organization_id);
ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);

CREATE INDEX IX_Office_Name ON Office (name);
CREATE INDEX IX_Office_Phone ON Office (phone);
CREATE INDEX IX_Office_Is_Active ON Office (is_active);

-- User indexes and foreign keys
-- ALTER TABLE User ADD FOREIGN KEY (id) REFERENCES Document(id);

CREATE INDEX IX_User_Office_Id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_User_Country_Code ON User (country_code);
ALTER TABLE User ADD FOREIGN KEY (country_code) REFERENCES Country(code);

CREATE INDEX IX_User_First_Name ON User (first_name);
CREATE INDEX IX_User_Second_Name ON User (second_name);
CREATE INDEX IX_User_Middle_Name ON User (middle_name);
CREATE INDEX IX_User_Position ON User (position);

-- Document indexes and foreign keys
CREATE INDEX IX_Document_Doc_Code ON Document (doc_code);
ALTER TABLE Document ADD FOREIGN KEY (doc_code) REFERENCES Document_Type(code);
ALTER TABLE Document ADD FOREIGN KEY (doc_id) REFERENCES User(user_id);

-- Document_Type indexes and foreign keys
CREATE UNIQUE INDEX UX_Document_Type_Name ON Document_Type (name);