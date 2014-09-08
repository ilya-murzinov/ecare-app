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
  address varchar(200)
);

create table contract(
  id int key auto_increment,
  number long,
  tariff_id int,
  client_id int,
  blocked bool,
  blockedByEmployee bool
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
    email varchar(32) NOT NULL,
    password varchar(100) NOT NULL,
    client_id int
);

create table authority
(
  id int key auto_increment,
  authority varchar(32)
);

create table user_authority
(
  id int key auto_increment,
  user_id int,
  authority_id int
);

######################################################
# Client
######################################################

insert into client(
  name, lastname, date_of_birth, passport, address
) values (
  'Ivan', 'Ivanov', '1990-02-02', '123123123 asdkljdhsf fjfjjdsf', 'asdhjgh 1278h nwfhasd'
);

insert into client(
  name, lastname, date_of_birth, passport, address
) values (
  'Semen', 'Semenov', '1993-03-12', 'asjk777234hfhfhfhf', 'ads123sdf2455435'
);

insert into client(
  name, lastname, date_of_birth, passport, address
) values (
  'Sergey', 'Servgeev', '1982-04-22', 'kjjjdjdjdjdjdasd', '1111111111111'
);

insert into client(
  name, lastname, date_of_birth, passport, address
) values (
  'Stepan', 'Stepanov', '1978-11-18', 'seerrersereesese', 'dgkjdfjdjfjdd'
);

insert into client(
  name, lastname, date_of_birth, passport, address
) values (
  'Alexey', 'Alexeev', '1983-07-21', 'aagagagagaaaasdasd134134 3423 54', 'dfkjhsdgfkj2784678234678'
);

######################################################
# Contract
######################################################

insert into contract(
  number, tariff_id, client_id, blocked, blockedByEmployee
) values (
  1267854678, 3, 1, false, false
);
insert into contract(
  number, tariff_id, client_id, blocked, blockedByEmployee
) values (
  6673747412, 2, 1, false, false
);
insert into contract(
  number, tariff_id, client_id, blocked, blockedByEmployee
) values (
  54783223, 1, 1, false, false
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
  email, password, client_id
) values(
  'admin@mail.com', '21232f297a57a5a743894a0e4a801fc3', NULL
);

insert into user(
  email, password, client_id
) values(
  'user@mail.com', 'ee11cbb19052e40b07aac0ca060c23ee', 1
);

insert into authority (
  authority
) values (
  'ROLE_ADMIN'
);

insert into authority (
  authority
) values (
  'ROLE_CLIENT'
);

insert into user_authority (
  user_id, authority_id
) values (
  1, 1
);

insert into user_authority (
  user_id, authority_id
) values (
  2, 2
);
