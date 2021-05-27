create database `data_base_furama`;
use `data_base_furama`;

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

-- 	Bảng NhanVien lưu trữ thông tin của Nhân viên
create table nhan_vien(
id_nhan_vien int primary key auto_increment,
ho_ten_nhan_vien varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh_nhan_vien date,
so_cmnd_nhan_vien varchar(45),
luong varchar(45),
sdt_nhan_vien varchar(45),
email_nhan_vien varchar(45),
dia_chi_nhan_vien varchar(45),
foreign key(id_vi_tri) references vi_tri(id_vi_tri),
foreign key(id_trinh_do)references trinh_do(id_trinh_do),
foreign key(id_bo_phan)references bo_phan(id_bo_phan));

-- 	LoaiKhach lưu trữ thông tin các loại khách hàng
create table loai_khach_hang(
id_loai_khach_hang int primary key auto_increment,
ten_loai_khach_hang varchar(45));

-- Bảng KhachHang lưu trữ thông tin của Khách hàng
create table khach_hang(
id_khach_hang int primary key auto_increment,
id_loai_khach_hang int,
ho_ten_khach_hang varchar(45),
ngay_sinh_khach_hang date,
so_cmnd_khach_hang varchar(45),
sdt_khach_hang varchar(45),
email_khach_hang varchar (45),
dia_chi_khach_hang varchar(45),
foreign key (id_loai_khach_hang)references loai_khach_hang(id_loai_khach_hang));

create table loai_dich_vu(
id_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45));

create table kieu_thue(
id_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45),
gia_kieu_thue int);

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
gia_dich_vu_di_kem int,
don_vi int,
trang_thai_kha_dung varchar(45));

-- Bảng HopDongChiTiet lưu trữ thông tin một khách hàng có thể thuê nhiều dịch vụ đi kèm.
create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong),
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem));