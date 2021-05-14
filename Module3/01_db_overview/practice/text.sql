create database `demo`;

create table person(
id int primary key ,
last_name varchar (255) not null,
first_name varchar(255) not null,
age int);
select * from person;
insert into person(id,`last_name`,`first_name`)
value(1,"dong","hoang");
select * from person;
drop database `demo`;
insert into person(id,last_name,first_name)
value(2,"hoang","pham");
create table  information(
id int auto_increment primary key,
`name` varchar(255) not null,
`email`varchar(255) unique,
sdt varchar(255) unique);
insert into information(`name`,email,sdt)
value ("dong","hpdong@gmail.com","0988695564"),
("dong","hpdong1@gmail.com","0988695565"),
("dong","hpdong2@gmail.com","0988695567");
select * from information;
alter table information add age int check(age>18);
update information
set age=20
where id=4;
alter table information add city varchar(255) default 'vienam';
