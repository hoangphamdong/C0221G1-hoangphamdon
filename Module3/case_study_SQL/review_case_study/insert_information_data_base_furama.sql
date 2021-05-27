use `data_base_furama`;

-- Hiện tại resort bao gồm các bộ phận: Sale – Marketing, 
-- Hành Chính, Phục vụ, Quản lý.
insert into bo_phan (ten_bo_phan)
value ("Sele-Marketing"),
 ("Sele-Marketing"),
 ("Hành Chính"),
 ("Phục vụ"),
 ("Quản lý");
 
  insert into dich_vu ()
value(1,'Villa',1000,3,'10','1000000000',1,1,'còn trống'),
(2,'House',500,2,'5','500000000',2,1,'còn trống'),
(3,'room',500,2,'5','500000',2,1,'còn trống');


  -- dịch vụ đi kèm như massage, karaoke, thức ăn, nước uống, 
 -- thuê xe di chuyển tham quan resort
 -- Dịch vụ đi kèm sẽ bao gồm các thông tin: Tên dịch vụ đi kèm, Đơn vị, Giá tiền
 insert into dich_vu_di_kem()
 value(1,"massage",2000,5,"còn"),
 (2,"karaoke",2000,5,"còn"),
 (3,"thức ăn",2000,5,"còn"),
 (4,"nước",2000,5,"còn"),
 (5,"xe tham quan",2000,5,"còn");
 
 
 -- 	Bảng HopDong lưu trữ thông tin khách hàng thực hiện thuê dịch vụ tại villa
insert into hop_dong()
value (1,2,1,1,'2021/05/15','2021/06/14','5000000','2000000'),
(2,2,3,2,'2019/05/15','2022/06/14','5000000','2000000'),
(3,3,2,3,'2021/05/15','2021/06/14','5000000','2000000'),
(4,3,1,2,'2021/05/15','2021/06/14','5000000','2000000');



insert into hop_dong_chi_tiet()
value(1,1,1,5),
	(2,2,2,4),
	(3,3,3,1),
	(4,4,4,2);
	

insert into khach_hang()
value(1,1,'Thảo Nhi','2003/04/06','122234456','0359756804','thaonhi@gamil.com','Dak Lak'),
(2,2,'Hải Trinh','2002/10/04','122234456','0359756804','thaonhi@gamil.com','Hồ Chí Minh'),
(3,3,'Phạm Thị Yến','1963/12/04','122224456','0359756804','yen@gamil.com','Quảng Trị'),
(4,4,'Phạm Tuyên','2002/10/30','122224456','0359756804','tuyen@gamil.com','Quảng Nam'),
(5,5,'Nguyễn Phạm Đan Huyên','1987/09/09','122224456','0359756804','dh@gamil.com','Quảng Trị'),
(6,1,'Hồ Thị bảo Ngân','1998/10/10','122224456','0359756804','baongan@gamil.com','Đà Nẵng'),
(7,2,'Phan Thanh Nam','2002/03/13','122224456','0359756804','ptn@gamil.com','Đà Năng'),
(8,3,'Bùi Công Vỹ','2002/03/22','122224456','0359756804','oppp@gamil.com','Quảng Trị'),
(9,4,'Trần Thị Thủy Tiên','2002/06/30','122224456','0359756804','daneeeep@gamil.com','Đà Nẵng'),
(10,5,'Nguyễn Hải Thủy Tiên','2005/01/2','122224456','0359756804','dangmartep@gamil.com','Quảng Trị'),
(11,1,'Văn Thị Thu Huyền','2002/02/14','122224456','0359756804','dangmaaaagp@gamil.com','Quảng Trị'),
(12,1,'Cẩm Đang','2002/04/01','122224456','0359756804','dangmap@gamil.com','Quảng Trị');


   -- Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ).
insert into kieu_thue()
 value(1,"Năm",12000),
 (2,"Tháng",3000),
 (3,"Ngày",500),
 (4,"Giờ",50);
 
 insert into loai_dich_vu(ten_loai_dich_vu)
value ('trọn gói');

--  Loại Customer bao gồm: (Diamond, Platinium, Gold, Silver, Member).
 insert into loai_khach_hang()
 value	(1,"Diamond"),
		(2,"Platinium"),
		(3,"Gold"),
		(4,"Silver"),
		(5,"Member");


  insert into nhan_vien()
value	(1,'Võ Minh Vũ',1,4,1,'1996-12-01','12345123467','1000000','123456789','vmv@gmail.com','Quảng Nam'),
		(2,'Phan Gia Khánh',2,3,1,'1999-12-12','12345123213','10000000','122234567','pgk@gmail.com','Đà Nẵng'),
		(3,'Phi khanh',1,2,4,'1996-01-30','12345123467','150000000','122222222','hpd@gmail.com','Hà Nội'),
		(4,'Võ Thành Trung',1,2,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Hà Nội'),
		(5,'Nguyễn Hải Thủy Tiên',2,2,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Hà Nội'),
		(6,'Hồ Bảo Ngân',1,2,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Hà Nội'),
		(7,'Phạm Thị Thu',3,2,4,'1972-12-24','12345123467','150000000','122222222','hpd@gmail.com','Quảng Trị'),
		(8,'Hoàng Tuấn Bảo',1,2,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Quảng Trị'),
		(9,'Nguyễn Văn Thuận',2,2,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Quảng Bình'),
		(10,'Nguyễn Thị Thu Nguyệt',3,2,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Quảng Nam'),
		(11,'Quốc Bảo',1,2,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Hà Nội'),
		(12,'Trần Công Khánh',3,2,4,'1997-05-30','12345123467','150000000','122222222','hpd@gmail.com','Đà Nẵng'),
		(13,'Lê Viết Hiếu',2,2,4,'1990-01-30','12345123467','150000000','122222222','hpd@gmail.com','Quảng Trị'),
		(14,'Trần Nhật Anh',3,2,4,'1995-01-30','12345123467','150000000','122222222','hpd@gmail.com','Hà Nội'),
		(15,'Nguyễn Thị Thùy Trang',3,1,3,'1998-07-01','123433323467','1000000','133333333','nvh@gmail.com','Huế'),
		(16,'Hoàng Phạm Đông',4,1,3,'2002-01-30','123433323467','1000000','133333333','nvh@gmail.com','Huế');


-- Trình độ sẽ lưu trữ các thông tin: Trung cấp, Cao đẳng,
--  Đại học và sau đại học
insert into trinh_do(trinh_do)
value("Trung cấp"),
("Cao đẳng"),
("Đại học "),
("sau đại học ");


 -- Vị trí sẽ lưu trữ các thông tin: Lễ tân, phục vụ, chuyên viên,
--  giám sát, quản lý, giá đốc
insert into vi_tri(ten_vi_tri)
value ("lễ tân"),
("phục vụ"),
("chuyên viên"),
("giám sát"),
("quản lý"),
("giám đốc");





 



 


 
 






 
