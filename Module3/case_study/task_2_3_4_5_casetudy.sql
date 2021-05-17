use`data_base_furuma_resort`;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một
--  trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from nhan_vien
where (ho_ten like'H%'or ho_ten like'T%' or ho_ten like'K%') and (length(ho_ten)<=15) ;

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where year(current_date())-year(ngay_sinh) between 18 and 50 and dia_chi='Quảng Trị'or dia_chi='Đà Nẵng' ;

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.id_khach_hang,kh.id_loai_khach,lk.ten_loai_khach,kh.ho_ten,hd.id_hop_dong,
hd.ngay_lam_hop_dong,count(hd.id_khach_hang)as'so_lan_dat'
 from khach_hang kh
inner join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
inner join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach
where lk.ten_loai_khach='Diamond'
-- where kh.id_loai_khach=1
group by kh.id_khach_hang
order by 'so_lan_dat'asc;



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
sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) as 'tong_tien'
from khach_hang kh
left join loai_khach lk on kh.id_loai_khach=lk.id_loai_khach
left join hop_dong hd on hd.id_khach_hang=kh.id_khach_hang
left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
left join hop_dong_chi_tient hdct on hd.id_hop_dong=hdct.id_hop_dong
left join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
group by kh.id_khach_hang,hd.id_hop_dong;

 --  Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt
--  từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.id_dich_vu,dv.ten_dich_vu,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv
left join loai_dich_vu ldv on dv.id_loai_dich_vu=ldv.id_loai_dich_vu
left join hop_dong hd on dv.id_dich_vu=hd.id_dich_vu
left join khach_hang kh on kh.id_khach_hang=hd.id_khach_hang;