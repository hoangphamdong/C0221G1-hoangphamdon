create database if not exists `quan_ly_diem_thi`;
use `quan_ly_diem_thi`;
create table hoc_sinh(
ma_hs varchar(50),
ten_hs varchar(50),
ngay_sinh date,
lop varchar(50),
gt varchar(50),
primary key (ma_hs)
);
create table mon_hoc(
ma_mh varchar(50),
ten_mh varchar(50),
primary key(ma_mh)
);
create table bang_diem(
ma_hs varchar(50),
ma_mh varchar(50),
diem_thi int,
ngay_kt date,
primary key(ma_hs,ma_mh),
foreign key(ma_hs)references hoc_sinh(ma_hs),
foreign key(ma_mh)references mon_hoc(ma_mh)
);
create table giao_vien(
ma_gv varchar(50),
ten_gv varchar(50),
sdt varchar(50),
primary key(ma_gv)
);
alter table mon_hoc add ma_gv varchar(50);
alter table mon_hoc add constraint fk_ma_gv foreign key(ma_gv) references giao_vien(ma_gv);