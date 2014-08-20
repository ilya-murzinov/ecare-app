CREATE USER admin@localhost identified BY 'admin';
GRANT usage ON *.* TO admin@localhost identified BY 'admin';
DROP DATABASE IF EXISTS ecare;
CREATE DATABASE IF NOT EXISTS ecare;
GRANT ALL privileges ON ecare.* TO admin@localhost;
USE ecare;

create table client(
  id int key auto_increment,
  name varchar(32),
  lastname varchar(32),
  date_of_birth date,
  passport varchar(200),
  address varchar(200),
  email varchar(32)
);

create table contract(
  id int key auto_increment,
  number int,
  tariff_id int,
  client_id int
);

create table tariff(
  id int key auto_increment,
  name varchar(32),
  price double
);

create table t_option(
  id int key auto_increment,
  name varchar(32),
  subscription_fee double,
  price double
);

create table tariff_option(
  id int key auto_increment,
  tariff_id int,
  option_id int
);

create table contract_option(
  id int key auto_increment,
  contract_id int,
  option_id int
);

CREATE TABLE ecare.user
(
    id int key auto_increment,
    login varchar(32) NOT NULL,
    password varchar(32) NOT NULL,
    client_id int
);

insert into client(
  name, lastname, date_of_birth, passport, address, email
) values (
  'Ivan', 'Ivanov', '1990-02-02', '123123123 asdkljdhsf fjfjjdsf', 'asdhjgh 1278h nwfhasd', 'asd@asd.asd'
);

insert into contract(
  number, tariff_id, client_id
) values (
  12, 1, 1
);

insert into tariff(
  name, price
) values (
  'super tariff', 12.0
);

insert into t_option(
  name, subscription_fee, price
) values (
  'super option', 120.12, 30
);

# insert into tariff_option(
#   tariff_id, option_id
# ) values (
#   1, 1
# )

insert into contract_option(
  contract_id, option_id
) values (
  1, 1
);

insert into user(
  login, password, client_id
) values(
  'user', 'user', 1
);

insert into user(
  login, password, client_id
) values(
  'admin', 'admin', null
)
