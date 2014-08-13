drop table client, contract, tariff, t_option, tariff_option;

create table client(
  id int key auto_increment,
  name varchar(32),
  lastname varchar(32),
  date_of_birth date,
  passport varchar(200),
  address varchar(200),
  email varchar(32),
  password varchar(16)
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

insert into client(
  name, lastname, date_of_birth, passport, address, email, password
) values (
  'Ivan', 'Ivanov', '1990-02-02', '123123123 asdkljdhsf fjfjjdsf', 'asdhjgh 1278h nwfhasd', 'asd@asd.asd', 'password'
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