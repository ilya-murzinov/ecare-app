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
  number long,
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

create table ecare.user
(
    id int key auto_increment,
    login varchar(32) NOT NULL,
    password varchar(32) NOT NULL,
    client_id int
);

######################################################
# Client
######################################################

insert into client(
  name, lastname, date_of_birth, passport, address, email
) values (
  'Ivan', 'Ivanov', '1990-02-02', '123123123 asdkljdhsf fjfjjdsf', 'asdhjgh 1278h nwfhasd', 'asd@asd.asd'
);

######################################################
# Contract
######################################################

insert into contract(
  number, tariff_id, client_id
) values (
  1267854678, 3, 1
);
insert into contract(
  number, tariff_id, client_id
) values (
  6673747412, 2, 1
);
insert into contract(
  number, tariff_id, client_id
) values (
  54783223, 1, 1
);

######################################################
# Tariff
######################################################

insert into tariff(
  name, price
) values (
  'super tariff', 12.0
);
insert into tariff(
  name, price
) values (
  'super tariff 2', 13.0
);
insert into tariff(
  name, price
) values (
  'super tariff 3', 14.0
);
insert into tariff(
  name, price
) values (
  'super tariff 4', 15.0
);

######################################################
# Option
######################################################

insert into t_option(
  name, subscription_fee, price
) values (
  'super option', 120.12, 30
);
insert into t_option(
  name, subscription_fee, price
) values (
  'super option 2', 10.12, 120
);
insert into t_option(
  name, subscription_fee, price
) values (
  'super option 3', 20.4, 42
);
insert into t_option(
  name, subscription_fee, price
) values (
  'super option 4', 1.12, 15
);
insert into t_option(
  name, subscription_fee, price
) values (
  'super option 5', 120.12, 30
);
insert into t_option(
  name, subscription_fee, price
) values (
  'super option 6', 10.12, 120
);
insert into t_option(
  name, subscription_fee, price
) values (
  'super option 7', 20.4, 42
);
insert into t_option(
  name, subscription_fee, price
) values (
  'super option 8', 1.12, 15
);

######################################################
# Option to tariff
######################################################

insert into tariff_option(
  tariff_id, option_id
) values (
  1, 1
);
insert into tariff_option(
  tariff_id, option_id
) values (
  1, 3
);
insert into tariff_option(
  tariff_id, option_id
) values (
  1, 4
);
insert into tariff_option(
  tariff_id, option_id
) values (
  1, 7
);
insert into tariff_option(
  tariff_id, option_id
) values (
  2, 2
);
insert into tariff_option(
  tariff_id, option_id
) values (
  2, 3
);
insert into tariff_option(
  tariff_id, option_id
) values (
  2, 6
);
insert into tariff_option(
  tariff_id, option_id
) values (
  2, 7
);
insert into tariff_option(
  tariff_id, option_id
) values (
  3, 4
);
insert into tariff_option(
  tariff_id, option_id
) values (
  3, 1
);
insert into tariff_option(
  tariff_id, option_id
) values (
  3, 2
);
insert into tariff_option(
  tariff_id, option_id
) values (
  3, 8
);
insert into tariff_option(
  tariff_id, option_id
) values (
  4, 1
);
insert into tariff_option(
  tariff_id, option_id
) values (
  4, 3
);
insert into tariff_option(
  tariff_id, option_id
) values (
  4, 5
);
insert into tariff_option(
  tariff_id, option_id
) values (
  4, 7
);
insert into tariff_option(
  tariff_id, option_id
) values (
  4, 2
);

######################################################
# Option to contract
######################################################

insert into contract_option(
  contract_id, option_id
) values (
  1, 4
);
insert into contract_option(
  contract_id, option_id
) values (
  2, 3
);
insert into contract_option(
  contract_id, option_id
) values (
  2, 2
);
insert into contract_option(
  contract_id, option_id
) values (
  3, 1
);
insert into contract_option(
  contract_id, option_id
) values (
  3, 3
);
insert into contract_option(
  contract_id, option_id
) values (
  3, 4
);

######################################################
# User
######################################################

insert into user(
  login, password, client_id
) values(
  'user', 'user', 1
);

insert into user(
  login, password, client_id
) values(
  'admin', 'admin', 0
)
