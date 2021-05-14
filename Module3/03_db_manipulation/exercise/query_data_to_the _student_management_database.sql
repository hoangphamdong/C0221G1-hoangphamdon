create database `query_data_to_the_student_management_database`;
use `query_data_to_the_student_management_database`;

create table class(
class_id int not null  auto_increment primary key,
class_name varchar(45) not null,
start_date date,
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
value('A1',"2009/12/20",1),
('A2',"2009/01/12",1),
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

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student
where student_name like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12

select * from class
where start_date like '%12%';

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.

select*from `subject`
where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.

SET SQL_SAFE_UPDATES = 0;
update student
set class_id=2mark
where student_name='Hung';

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp
--  xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần

select s.student_name,m.mark,sub.sub_name
from student s 
	inner join mark m on m.mark_id = s.student_id
    inner join `subject` sub on sub.sub_id=m.sub_id
    group by m.mark
    order by m.mark desc;
    
