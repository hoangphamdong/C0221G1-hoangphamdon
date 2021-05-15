create database if not exists `data_base_furuma_resort`;
use `data_base_furuma_resort`;

-- Bảng ViTri lưu trữ thông tin vị trí làm tại resort của Nhân viên
create table vi_tri(
id_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45));

-- Bảng TrinhDo lưu trữ thông tin trình độ của Nhân viên
create table trinh_do(
id_trinh_do int primary key auto_increment,
trinh_do varchar(45));

-- 	Bảng BoPhan lưu trữ thông tin Nhân viên nào sẽ thuộc phòng ban nào
create table bo_phan(
id_bo_phan int primary key auto_increment,
ten_bo_phan varchar(45));

create table loai_dich_vu(
id_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45));

create table kieu_thue(
id_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45),
gia int);

-- 	Bảng NhanVien lưu trữ thông tin của Nhân viên
create table nhan_vien(
id_nhan_vien int primary key auto_increment,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh varchar(45),
so_cmnd varchar(45),
luon varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(id_vi_tri) references vi_tri(id_vi_tri),
foreign key(id_trinh_do)references trinh_do(id_trinh_do),
foreign key(id_bo_phan)references bo_phan(id_bo_phan));

-- 	LoaiKhach lưu trữ thông tin các loại khách hàng
create table loai_khach(
id_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45));

-- Bảng KhachHang lưu trữ thông tin của Khách hàng
create table khach_hang(
id_khach_hang int primary key auto_increment,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
sdt varchar(45),
email varchar (45),
dia_chi varchar(45),
foreign key (id_loai_khach)references loai_khach(id_loai_khach));

-- Bảng DichVu lưu trữ thông tin các dịch vụ mà resort cung cấp
create table dich_vu(
id_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_to_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int(45),
id_loai_dich_vu int,
trang_thai varchar(45),
foreign key(id_kieu_thue)references kieu_thue(id_kieu_thue),
foreign key(id_loai_dich_vu)references loai_dich_vu(id_loai_dich_vu));

-- Bảng HopDong lưu trữ thông tin khách hàng thực hiện thuê dịch vụ tại villa
create table hop_dong(
id_hop_dong int primary key auto_increment,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key(id_nhan_vien)references nhan_vien(id_nhan_vien),
foreign key(id_khach_hang)references khach_hang(id_khach_hang),
foreign key (id_dich_vu)references dich_vu(id_dich_vu));

-- Bảng DichVuDiKem lưu trữ thông tin các dịch vụ đi kèm khi Khách hàng 
create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45));

-- Bảng HopDongChiTiet lưu trữ thông tin một khách hàng có thể thuê nhiều dịch vụ đi kèm.
create table hop_dong_chi_tient(
id_hop_dong_chi_tiet int primary key auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong),
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem));

--  Loại Customer bao gồm: (Diamond, Platinium, Gold, Silver, Member).
 insert into loai_khach(ten_loai_khach)
 value("Diamond"),
 ("Platinium"),
 ("Gold"),
 ("Silver"),
 ("Member");

-- Vị trí sẽ lưu trữ các thông tin: Lễ tân, phục vụ, chuyên viên,
--  giám sát, quản lý, giá đốc
insert into vi_tri(ten_vi_tri)
value ("lễ tân"),
("phục vụ"),
("chuyên viên"),
("giám sát"),
("quản lý"),
("giám đốc");

SET SQL_SAFE_UPDATES = 0;

delete from vi_tri;

-- Trình độ sẽ lưu trữ các thông tin: Trung cấp, Cao đẳng,
--  Đại học và sau đại học
insert into trinh_do(trinh_do)
value("Trung cấp"),
("Cao đẳng"),
("Đại học "),
("sau đại học ");

-- Thông tin Employee sẽ bao gồm: Họ tên Employee , Ngày sinh, Số CMND,
--  Số ĐT, Email, Trình độ, Vị trí, lương
insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,
so_cmnd,luon,sdt,email,dia_chi)
value('Võ Minh Vũ',7,1,1,'1996-12-01','12345123467','1000000','123456789','vmv@gmail.com','Quảng Nam'),
('Phan Gia Khánh',7,2,1,'1999-12-12','12345123213','10000000','122234567','pgk@gmail.com','Đà Nẵng'),
('Hoàng Phạm Đông',7,4,4,'2002-01-30','12345123467','150000000','122222222','hpd@gmail.com','Hà Nội'),
('Nguyễn Thị Thùy Trang',7,4,3,'1998-07-01','123433323467','1000000','133333333','nvh@gmail.com','Huế'),
('Nguyễn Văn Hiếu',7,3,2,'1997-02-10','12345123467','5000000','1444444444','vmv@gmail.com','Huế'),
('Nguyễn Quốc Tuấn',8,1,3,'1990-05-15','12345123327','12000000','156777777','tuan@gmail.com','ĐÀ Nẵng'),
('Hoàng Thị Dịu Thúy',8,2,1,'1997-12-01','12345123467','1000000','888888888','hoangthuy@gmail.com','Quảng Bình');


-- Hiện tại resort bao gồm các bộ phận: Sale – Marketing, 
-- Hành Chính, Phục vụ, Quản lý.
insert into bo_phan (ten_bo_phan)
value ("Sele-Marketing"),
 ("Sele-Marketing"),
 ("Hành Chính"),
 ("Phục vụ"),
 ("Quản lý");
 
 
 
 -- dịch vụ đi kèm như massage, karaoke, thức ăn, nước uống, 
 -- thuê xe di chuyển tham quan resort
 -- Dịch vụ đi kèm sẽ bao gồm các thông tin: Tên dịch vụ đi kèm, Đơn vị, Giá tiền
 insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
 value("massage",2000,5,"còn"),
 ("karaoke",2000,5,"còn"),
 ("thức ăn",2000,5,"còn"),
 ("nước",2000,5,"còn"),
 ("xe tham quan",2000,5,"còn");
 
 -- Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ).
insert into kieu_thue(ten_kieu_thue)
 value("Năm"),
 ("Tháng"),
 ("Ngày"),
 ("Giờ");
 
insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)
value(1,'Đinh Thị Kiều Nhi','2003/12/04','122234456','0359756804','kieunhi@gamil.com','daklak');

insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)
value(2,'Thảo Nhi','2003/04/06','122234456','0359756804','thaonhi@gamil.com','daklak'),
(3,'Hải Trinh','2002/10/04','122234456','0359756804','thaonhi@gamil.com','Hồ Chí Minh'),
(2,'Cẩm Đang','2002/10/30','122224456','0359756804','dangmap@gamil.com','Quảng Trị');

-- Tất cả các dịch vụ này sẽ bao có các thông tin: Tên dịch vụ, Diện tích sử dụng,
--  Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ).
-- -	Riêng Villa sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác,
--  Diện tích hồ bơi, Số tầng.
-- -	Riêng House sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác,
-- Số tầng.
-- -	Riêng Phòng sẽ có thêm thông tin: Dịch vụ miễn phí đi kèm.

insert into dich_vu (ten_dich_vu,dien_tich,so_tang,so_nguoi_to_da,chi_phi_thue,
id_kieu_thue,id_loai_dich_vu,trang_thai)
value('Villa',1000,3,'10','1000000000',1,1,'còn trống'),
('House',500,2,'5','500000000',2,1,'còn trống'),
('room',500,2,'5','500000',2,1,'còn trống');

insert into loai_dich_vu(ten_loai_dich_vu)
value ('trọn gói');

-- 	Bảng HopDong lưu trữ thông tin khách hàng thực hiện thuê dịch vụ tại villa
insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,
ngay_ket_thuc,tien_dat_coc,tong_tien)
value (2,1,1,'2021/05/15','2021/06/14','5000000','2000000'),
(2,1,1,'2021/05/15','2021/06/14','5000000','2000000'),
(3,2,1,'2021/05/15','2021/06/14','5000000','2000000'),
(3,3,1,'2021/05/15','2021/06/14','5000000','2000000');

-- Bảng HopDongChiTiet lưu trữ thông tin một khách hàng có thể thuê nhiều dịch vụ đi kèm.
insert into hop_dong_chi_tient(id_hop_dong,id_dich_vu_di_kem,so_luong)
value(1,3,3);

-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một
--  trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from nhan_vien
where ho_ten like 'H%'or 'T%'or 'K%' ;

-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where year(current_date())-year(ngay_sinh) between 18 and 50 and dia_chi='Quảng Trị' ;

-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.id_khach_hang,kh.id_loai_khach,lk.ten_loai_khach,kh.ho_ten,hd.id_hop_dong,
hd.ngay_lam_hop_dong,count(kh.ho_ten)as'số lần đặt'
 from khach_hang kh
inner join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
inner join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach
where lk.ten_loai_khach='Diamond'
-- where kh.id_loai_khach=1
group by kh.ho_ten;



-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, 
-- NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: 
-- ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng 
-- đặt phòng cũng phải hiển thị ra).
select kh.id_khach_hang,kh.ho_ten,
lk.ten_loai_khach,
hd.id_hop_dong,
dv.ten_dich_vu,
hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
dv.chi_phi_thue+hdct.so_luong*dvdk.gia as 'tổng tiền'
from khach_hang kh
left join loai_khach lk on kh.id_loai_khach=lk.id_loai_khach
left join hop_dong hd on hd.id_khach_hang=kh.id_khach_hang
left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
left join hop_dong_chi_tient hdct on hd.id_hop_dong=hdct.id_hop_dong
left join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem;

-- Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt
--  từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.id_dich_vu,dv.ten_dich_vu,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv
left join loai_dich_vu ldv on dv.id_loai_dich_vu=ldv.id_loai_dich_vu
left join hop_dong hd on dv.id_dich_vu=hd.id_dich_vu
left join khach_hang kh on kh.id_khach_hang=hd.id_khach_hang
;