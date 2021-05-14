create database if not exists `my_database`;
use `my_database`;
create table student(
id int not null primary key auto_increment,
`name`varchar(50),
birday date);
select* from student;
insert into student(`name`,birday)
value("dong1","2002-01-30"),
("dong2","2002-01-30"),
("dong3","2002-01-30");
SET SQL_SAFE_UPDATES = 0;
update student
set `name`="hoang";
SET SQL_SAFE_DELETE = 0;
delete student from `my_database`;

