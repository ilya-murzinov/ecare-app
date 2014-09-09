CREATE USER admin@localhost
  IDENTIFIED BY 'admin';
GRANT USAGE ON *.* TO admin@localhost
IDENTIFIED BY 'admin';
DROP DATABASE IF EXISTS ecare;
CREATE DATABASE IF NOT EXISTS ecare;
GRANT ALL PRIVILEGES ON ecare.* TO admin@localhost;
USE ecare;

CREATE TABLE client (
  id            INT KEY AUTO_INCREMENT,
  name          VARCHAR(32),
  lastname      VARCHAR(32),
  date_of_birth DATE,
  passport      VARCHAR(200),
  address       VARCHAR(200)
);

CREATE TABLE contract (
  id                INT KEY AUTO_INCREMENT,
  number            BIGINT,
  tariff_id         INT,
  client_id         INT,
  blocked           BOOL,
  blockedByEmployee BOOL
);

CREATE TABLE tariff (
  id    INT KEY AUTO_INCREMENT,
  name  VARCHAR(32),
  price DOUBLE
);

CREATE TABLE t_option (
  id               INT KEY AUTO_INCREMENT,
  name             VARCHAR(32),
  subscription_fee DOUBLE,
  price            DOUBLE
);

CREATE TABLE required_option (
  id         INT KEY AUTO_INCREMENT,
  option1_id INT,
  option2_id INT
);

CREATE TABLE incompatible_option (
  id         INT KEY AUTO_INCREMENT,
  option1_id INT,
  option2_id INT
);

CREATE TABLE tariff_option (
  id        INT KEY AUTO_INCREMENT,
  tariff_id INT,
  option_id INT
);

CREATE TABLE contract_option (
  id          INT KEY AUTO_INCREMENT,
  contract_id INT,
  option_id   INT
);

CREATE TABLE ecare.user
(
  id        INT KEY AUTO_INCREMENT,
  email     VARCHAR(32)  NOT NULL,
  password  VARCHAR(100) NOT NULL,
  client_id INT
);

CREATE TABLE authority
(
  id        INT KEY AUTO_INCREMENT,
  authority VARCHAR(32)
);

CREATE TABLE user_authority
(
  id           INT KEY AUTO_INCREMENT,
  user_id      INT,
  authority_id INT
);

######################################################
# Client
######################################################

INSERT INTO client (
  name, lastname, date_of_birth, passport, address
) VALUES (
  'Ivan', 'Ivanov', '1990-02-02', '123123123 asdkljdhsf fjfjjdsf', 'asdhjgh 1278h nwfhasd'
);

INSERT INTO client (
  name, lastname, date_of_birth, passport, address
) VALUES (
  'Semen', 'Semenov', '1993-03-12', 'asjk777234hfhfhfhf', 'ads123sdf2455435'
);

INSERT INTO client (
  name, lastname, date_of_birth, passport, address
) VALUES (
  'Sergey', 'Servgeev', '1982-04-22', 'kjjjdjdjdjdjdasd', '1111111111111'
);

INSERT INTO client (
  name, lastname, date_of_birth, passport, address
) VALUES (
  'Stepan', 'Stepanov', '1978-11-18', 'seerrersereesese', 'dgkjdfjdjfjdd'
);

INSERT INTO client (
  name, lastname, date_of_birth, passport, address
) VALUES (
  'Alexey', 'Alexeev', '1983-07-21', 'aagagagagaaaasdasd134134 3423 54', 'dfkjhsdgfkj2784678234678'
);

######################################################
# Contract
######################################################

INSERT INTO contract (
  number, tariff_id, client_id, blocked, blockedByEmployee
) VALUES (
  1267854678, 3, 1, FALSE, FALSE
);
INSERT INTO contract (
  number, tariff_id, client_id, blocked, blockedByEmployee
) VALUES (
  6673747412, 2, 1, FALSE, FALSE
);
INSERT INTO contract (
  number, tariff_id, client_id, blocked, blockedByEmployee
) VALUES (
  54783223, 1, 1, FALSE, FALSE
);

######################################################
# Tariff
######################################################

INSERT INTO tariff (
  name, price
) VALUES (
  'super tariff', 12.0
);
INSERT INTO tariff (
  name, price
) VALUES (
  'super tariff 2', 13.0
);
INSERT INTO tariff (
  name, price
) VALUES (
  'super tariff 3', 14.0
);
INSERT INTO tariff (
  name, price
) VALUES (
  'super tariff 4', 15.0
);

######################################################
# Option
######################################################

INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option', 120.12, 30
);
INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option 2', 10.12, 120
);
INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option 3', 20.4, 42
);
INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option 4', 1.12, 15
);
INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option 5', 120.12, 30
);
INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option 6', 10.12, 120
);
INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option 7', 20.4, 42
);
INSERT INTO t_option (
  name, subscription_fee, price
) VALUES (
  'super option 8', 1.12, 15
);

INSERT INTO required_option (
  option1_id, option2_id
) VALUES (
  1, 1
);

INSERT INTO incompatible_option (
  option1_id, option2_id
) VALUES (
  1, 2
);

######################################################
# Option to tariff
######################################################

INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  1, 1
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  1, 3
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  1, 4
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  1, 7
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  2, 2
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  2, 3
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  2, 6
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  2, 7
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  3, 4
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  3, 1
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  3, 2
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  3, 8
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  4, 1
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  4, 3
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  4, 5
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  4, 7
);
INSERT INTO tariff_option (
  tariff_id, option_id
) VALUES (
  4, 2
);

######################################################
# Option to contract
######################################################

INSERT INTO contract_option (
  contract_id, option_id
) VALUES (
  1, 4
);
INSERT INTO contract_option (
  contract_id, option_id
) VALUES (
  2, 3
);
INSERT INTO contract_option (
  contract_id, option_id
) VALUES (
  2, 2
);
INSERT INTO contract_option (
  contract_id, option_id
) VALUES (
  3, 1
);
INSERT INTO contract_option (
  contract_id, option_id
) VALUES (
  3, 3
);
INSERT INTO contract_option (
  contract_id, option_id
) VALUES (
  3, 4
);

######################################################
# User
######################################################

INSERT INTO user (
  email, password, client_id
) VALUES (
  'admin@mail.com', '21232f297a57a5a743894a0e4a801fc3', NULL
);

INSERT INTO user (
  email, password, client_id
) VALUES (
  'user@mail.com', 'ee11cbb19052e40b07aac0ca060c23ee', 1
);

INSERT INTO authority (
  authority
) VALUES (
  'ROLE_ADMIN'
);

INSERT INTO authority (
  authority
) VALUES (
  'ROLE_CLIENT'
);

INSERT INTO user_authority (
  user_id, authority_id
) VALUES (
  1, 1
);

INSERT INTO user_authority (
  user_id, authority_id
) VALUES (
  2, 2
);
