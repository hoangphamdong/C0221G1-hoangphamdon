create database if not exists `data_base_furuma_resort`;
use `data_base_furuma_resort`;
create table vi_tri(
id_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45));

create table trinh_do(
id_trinh_do int primary key auto_increment,
trinh_do varchar(45));

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

create table nhan_vien(
id_nhan_vien int primary key auto_increment,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmnd varchar(45),
luon varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(id_vi_tri) references vi_tri(id_vi_tri),
foreign key(id_trinh_do)references trinh_do(id_trinh_do),
foreign key(id_bo_phan)references bo_phan(id_bo_phan));

create table loai_khach(
id_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45));


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

create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45));

create table hop_dong_chi_tient(
id_hop_dong_chi_tiet int primary key auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong),
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem));

insert into vi_tri(ten_vi_tri)
value ("lễ tân"),
("phục vụ"),
("chuyên viên"),
("chuyên viên"),
("giám sát"),
("quản lý"),
("giám đốc");

insert into trinh_do(trinh_do)
value("Trung cấp"),
("Cao đẳng"),
("Đại học "),
("sau đại học ");

insert into bo_phan (ten_bo_phan)
value ("Sele-Marketing"),
 ("Sele-Marketing"),
 ("Hành Chính"),
 ("Phục vụ"),
 ("Quản lý");
 
 insert into loai_khach(ten_loai_khach)
 value("Diamond"),
 ("Platinium"),
 ("Gold"),
 ("Silver"),
 ("Member");
 
 insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
 value("massage",2000,5,"còn"),
 ("karaoke",2000,5,"còn"),
 ("thức ăn",2000,5,"còn"),
 ("nước",2000,5,"còn"),
 ("xe tham quan",2000,5,"còn");
 
insert into kieu_thue(ten_kieu_thue)
 value("Năm"),
 ("Tháng"),
 ("Ngày"),
 ("Giờ");
 
insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,
ngay_sinh,so_cmnd,luon,sdt,email,dia_chi)
value("Hoàng Phạm Đông",7,3,5,30/01/2002,"12345678","10000000","123456789","hpdong@gamil.com","abc");
