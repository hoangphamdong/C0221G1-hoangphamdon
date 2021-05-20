use `intership`;
insert into faculty()
values('001','Công nghệ Hoá học','000033'),
('002','Công nghệ Sinh học','00003033'),
('003','DIA LY ','00374733'),
('004','QLTN','0000933'),
('005','TOAN','2433033');

insert into instructor()
values(1,'Hoàng Phạm Đông','1','001'),
(2,'Nguyễn Thị Xuân','1','002'),
(3,'Phạm Thị Thu','1','003'),
(4,'Hoàng Tuấn Bảo','1','004'),
(5,'Phạm Thị Yến','2','005');

insert into student()
values (1,'Nguyễn Hiếu','001','2002-01-20','Huế'),
(2,'Quốc Tuấn','002','2002-01-20','Đà Nẵng'),
(3,'Hòa Thọ','003','2002-01-20','Quảng Trị'),
 (4,'Dịu Thúy','004','2002-01-20','Quảng Bình');
 
 insert into project()
 values ('1','phụ hồ',7,'Dak Lak'),
 ('2','Thợ xây',7,'Dak Nong'),
 ('3','Trộn hồ',7,'Gia Lai');
 
 insert into instructor_student()
 values(1,'1',1,7.5),
(2,'2',2,7.5);