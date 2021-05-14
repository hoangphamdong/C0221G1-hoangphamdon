create database if not exists`add_data_to_the_student_management_database`;
use `add_data_to_the_student_management_database`;

create table class(
class_id int not null  auto_increment primary key,
class_name varchar(45) not null,
start_date datetime not null,
`status` bit);

create table student(
student_id int not null auto_increment primary key ,
student_name varchar(50) not null,
address varchar(50),
phone varchar(10),
`status` bit,
class_id int not null,
foreign key (class_id)references class(class_id));

create table `subject` (
sub_id int not null auto_increment primary key,
sub_name varchar(50) not null,
credit varchar(50),
`status` bit
);

create table mark(
mark_id int not null auto_increment primary key,
sub_id int not null,
student_id int not null,
mark float default 0 check(mark between 0 and 100),
exam_time tinyint default 1,
unique(sub_id,student_id),
foreign key(sub_id) references `subject`(sub_id), 
foreign key(student_id) references student(student_id) );

insert into class(class_name,start_date,`status`)
value('A1',20/02/2008,1),
("A2",22/01/2008,1),
('A3',current_date,0);

insert into student (student_name,address,phone,`status`,class_id)
value ('Hung', 'Ha Noi', '0912113113', 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);

insert into student (student_name,address,`status`,class_id)
value ('Hung', 'Ha Noi',  1, 1);

insert into `subject`(sub_name,credit,`status`)
value('CF', 5, 1),
       ('C', 6, 1),
       ('HDJ', 5, 1),
       ('RDBMS', 10, 1);
       
insert into mark(sub_id,student_id,mark,exam_time)
value(1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
     
-- hiển thị danh sách tất cả các học viên
select * from student
where `status`=1;

 -- danh sách các môn học có thời gian học nhỏ hơn 10
select * from `subject`
where credit<10;

-- hiển thị danh sách học viên lớp A1
select s.student_id,s.student_name,c.class_name
from student s join class c on s.class_id=c.class_id
where c.class_name='A1';

-- Hiển thị tất cả các điểm đang có của học viên
select s.student_id,s.student_name,sub.sub_name,m.mark
from student s join mark m on s.student_id=m.student_id join `subject` sub on m.sub_id=sub.sub_id;

-- Hiển thị điểm môn CF của các học viên
select s.student_id,s.student_name,sub.sub_name,m.mark
from student s join mark m on s.student_id=m.student_id join `subject` sub on m.sub_id=sub.sub_id
where sub.sub_name='CF'