use `data_base_furuma_resort`;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue,
--  TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng
--  thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.id_dich_vu,dv.ten_dich_vu,
		dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv
	inner join loai_dich_vu ldv 
		on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
	inner join hop_dong hd 
		on hd.id_dich_vu=dv.id_dich_vu
where dv.id_dich_vu not in(
			select hd.id_dich_vu
			from hop_dong hd
			where (year(ngay_lam_hop_dong)=2019) and (month(ngay_lam_hop_dong)in(1,2,3))
            );

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
--  của tất cả các loại dịch vụ đã từ Khách hàng đặt phòng trong năm 2018 
--  nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,
		dv.so_nguoi_to_da,dv.chi_phi_thue,
		ldv.ten_loai_dich_Vu,
		count(dv.id_dich_vu) as 'so_lan_dat'
from dich_vu dv
	inner join loai_dich_vu ldv 
		on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
	inner join hop_dong hd 
		on hd.id_dich_vu = dv.id_dich_vu
where (year(hd.ngay_lam_hop_dong)=2018)
group by dv.id_dich_vu;

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống,
--  với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- cách1
select ho_ten from khach_hang
group by khach_hang.id_khach_hang;

-- cách2
select distinct kh.ho_ten
from khach_hang;

-- cách3
select kh.ho_ten
from khach_hang
union 
select kh.ho_ten
from khach_hang;


-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng
--  với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select hd.id_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,
		count(ngay_lam_hop_dong) as so_lan_dat_trong_thang,
		sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia)  as 'doanh_thu_theo_thang'
from hop_dong hd
	inner join dich_vu as dv 
		on dv.id_dich_vu=hd.id_dich_vu
	inner join hop_dong_chi_tient as hdct 
		on hdct.id_hop_dong=hd.id_hop_dong
	inner join dich_vu_di_kem as dvdk 
		on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong)=2021
group by month(hd.ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng
--  bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, 
--  NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem
-- (được tính dựa trên việc count các IDHopDongChiTiet).

select hd.id_hop_dong,hd.ngay_lam_hop_dong,
		hd.ngay_ket_thuc,hd.tien_dat_coc,
		dvdk.ten_dich_vu_di_kem,hdct.so_luong,
		count(hd.id_hop_dong) as so_hop_dong
from hop_dong hd
	inner join hop_dong_chi_tient hdct 
		on hd.id_hop_dong=hdct.id_hop_dong
	inner join dich_vu_di_kem dvdk 
		on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem 
group by hd.id_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
-- có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select*
from dich_vu_di_kem dvdk
	inner join hop_dong_chi_tient hdct
		on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
	inner join hop_dong hd 
		on hd.id_hop_dong =hdct.id_hop_dong
	inner join khach_hang kh 
		on kh.id_khach_hang=hd.id_khach_hang
	inner join loai_khach lk 
		on lk.id_loai_khach=kh.id_loai_khach
where lk.ten_loai_khach='Diamond'and (kh.dia_chi='Vinh'or kh.dia_chi='Quảng Ngãi');

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang,
--  TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết),
--  TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3
--  tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hd.id_hop_dong,nv.ho_ten as 'ho_ten_nhan_vien',
		kh.ho_ten as 'ho_ten_khach_hang',
        kh.sdt as 'sdt_khach_hang',
        dv.ten_dich_vu,
        dvdk.ten_dich_vu_di_kem,
        hdct.so_luong as 'so_luong_dich_vu_di_kem',
        hd.tien_dat_coc
from hop_dong hd
	inner join nhan_vien nv 
		on nv.id_nhan_vien=hd.id_nhan_vien
	inner join khach_hang kh 
		on kh.id_khach_hang=hd.id_khach_hang
	inner join dich_vu dv
		on dv.id_dich_vu=hd.id_dich_vu
	inner join hop_dong_chi_tient hdct 
		on hdct.id_hop_dong=hd.id_hop_dong
	inner join dich_vu_di_kem dvdk 
		on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
where (year(hd.ngay_lam_hop_dong)=2019)and (month(hd.ngay_lam_hop_dong)in (10,11,12))
and ngay_lam_hop_dong not in
				(select hd.ngay_lam_hop_dong
				from hop_dong as hd
		where (year(hd.ngay_lam_hop_dong)=2019) and (month(hd.ngay_lam_hop_dong)in(1,2,3,4,5,6))
);