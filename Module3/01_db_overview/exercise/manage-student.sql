create database if not exists `student-management`;
use `student-management`;
create table class(
id int not null primary key auto_increment,
`name` varchar(50));
create table teacher(
id int not null primary key auto_increment,
`name`varchar(50),
`age`int,
`country`varchar(100)
);
select*
from class;
select* 
from teacher;
insert into class(`name`)
value("hoang"),
("pham"),
("dong");
insert into teacher(`name`,`age`,`country`)
value("dong",15,"daklak"),
("dong",16,"daklak");
delete from class
where `name`="dong";
update class
set `name`="hoang";
drop table class;
drop table teacher;
delete from teacher
where (id=1) or (id=2);