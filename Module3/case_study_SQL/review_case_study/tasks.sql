use `data_base_furama`;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống
--  có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from nhan_vien
where (ho_ten_nhan_vien like 'H%')or(ho_ten_nhan_vien like 'T%')or(ho_ten_nhan_vien like 'K%')
			and(length(ho_ten_nhan_vien)<=15);

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 
-- tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang as kh
where (year(curdate())-year(kh.ngay_sinh_khach_hang)between 18 and 50) 
		and (( kh.dia_chi_khach_hang='Đà Nẵng') or(kh.dia_chi_khach_hang='Quảng Trị'));
        
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select kh.id_khach_hang,kh.ho_ten_khach_hang,
		count(kh.id_khach_hang) as so_lan_dat
from khach_hang as kh
inner join hop_dong as hd
on hd.id_khach_hang = kh.id_khach_hang
where kh.id_loai_khach_hang=1
group by kh.id_khach_hang 
order by so_lan_dat;     

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong,
--  NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau:
--  ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
--  cho tất cả các Khách hàng đã từng đặt phỏng.
--  (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select kh.id_khach_hang,kh.ho_ten_khach_hang,
		lkh.ten_loai_khach_hang,hd.id_hop_dong,
        dv.ten_dich_vu,hd.ngay_lam_hop_dong,
        hd.ngay_ket_thuc,
        sum(dv.chi_phi_thue+dvdk.gia_dich_vu_di_kem*hdct.so_luong) as tong_tien
from khach_hang as kh
	left join hop_dong as hd
	on hd.id_khach_hang=kh.id_khach_hang
	left join loai_khach_hang as lkh
	on lkh.id_loai_khach_hang=kh.id_loai_khach_hang
    left join dich_vu as dv
    on dv.id_dich_vu=hd.id_dich_vu
    left join hop_dong_chi_tiet as hdct
    on hdct.id_hop_dong=hd.id_hop_dong
    left join dich_vu_di_kem as dvdk
    on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
    group by kh.id_khach_hang;
    
 --    6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
--     của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt 
--     từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select dv.id_dich_vu,dv.ten_dich_vu,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu as dv
    inner join loai_dich_vu as ldv
    on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
    left join hop_dong as hd
    on hd.id_dich_vu=dv.id_dich_vu
    left join khach_hang as kh
    on kh.id_khach_hang=hd.id_khach_hang
where dv.id_dich_vu not in(
				select dv.id_dich_vu
				from  dich_vu as dv
				inner join loai_dich_vu as ldv
				on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
				inner join hop_dong as hd
				on hd.id_dich_vu=dv.id_dich_vu
				left join khach_hang as kh
				on kh.id_khach_hang=hd.id_khach_hang
				where   (year(hd.ngay_lam_hop_dong)=2019) and (month(hd.ngay_lam_hop_dong)in (1,2,3))
				group by dv.id_dich_vu)
group by dv.id_dich_vu;

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, 
-- TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong
--  năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.so_nguoi_to_da,dv.chi_phi_thue,
		ldv.ten_loai_dich_vu
from dich_vu as dv
	inner join loai_dich_vu as ldv
    on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
    inner join hop_dong as hd 
    on hd.id_dich_vu = dv.id_dich_vu
    inner join khach_hang as kh
    on kh.id_khach_hang=hd.id_hop_dong
    where (year(hd.ngay_lam_hop_Dong)=2018)
    group by dv.id_dich_vu;
    
 --    8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống,
--     với yêu cầu HoThenKhachHang không trùng nhau.
-- 	Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- cách 1
select * from khach_hang;
-- cách 2
select distinct * from khach_hang;
-- cách 3
select * from khach_hang
union
select * from khach_hang;
     
-- 9.	Thực hiện thống kê doanh thu theo tháng, n
-- ghĩa là tương ứng với mỗi tháng trong năm 2019 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as thang,
		count(hd.ngay_lam_hop_dong) as so_luong_dat,
		sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia_dich_vu_di_kem) as doanh_thu
from hop_dong as hd 
	inner join dich_vu as dv 
		on dv.id_dich_vu=hd.id_dich_vu
	inner join hop_dong_chi_tiet as hdct 
		on hdct.id_hop_dong=hd.id_hop_dong
	inner join dich_vu_di_kem as dvdk 
		on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
    inner join khach_hang as kh
		on kh.id_khach_hang=hd.id_khach_hang
where year(hd.ngay_lam_hop_dong)=2021
group by month(hd.ngay_lam_hop_dong)
order by thang;


-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã 
-- sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong,
--  NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
--  (được tính dựa trên việc count các IDHopDongChiTiet).

select hd.id_hop_dong,hd.ngay_lam_hop_dong,
		hd.ngay_ket_thuc,hd.tien_dat_coc,
		count(hdct.id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem
from hop_dong hd
	inner join hop_dong_chi_tiet hdct 
		on hd.id_hop_dong=hdct.id_hop_dong
	inner join dich_vu_di_kem dvdk 
		on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem 
group by hdct.id_hop_dong_chi_tiet;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những
--  Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select  dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem,dvdk.gia_dich_vu_di_kem
from dich_vu_di_kem dvdk
	inner join hop_dong_chi_tiet hdct
		on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
	inner join hop_dong hd 
		on hd.id_hop_dong =hdct.id_hop_dong
	inner join khach_hang kh 
		on kh.id_khach_hang=hd.id_khach_hang
	inner join loai_khach_hang lk 
		on lk.id_loai_khach_hang=kh.id_loai_khach_hang
where lk.ten_loai_khach_hang='Diamond'and 
	(kh.dia_chi_khach_hang='Vinh'or kh.dia_chi_khach_hang='Quảng Ngãi')
    group by dvdk.id_dich_vu_di_kem;
    
 --    12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, 
--     SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
--     (được tính dựa trên tổng Hợp đồng chi tiết), 
--     TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt
--     vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng 
--     đặt vào 6 tháng đầu năm 2019.
select hd.id_hop_dong,nv.ho_ten_nhan_vien as 'ho_ten_nhan_vien',
		kh.ho_ten_khach_hang as 'ho_ten_khach_hang',
        kh.sdt_khach_hang as 'sdt_khach_hang',
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
	inner join hop_dong_chi_tiet hdct 
		on hdct.id_hop_dong=hd.id_hop_dong
	inner join dich_vu_di_kem dvdk 
		on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
where (year(hd.ngay_lam_hop_dong)=2019)and (month(hd.ngay_lam_hop_dong)in (5,10,11,12))
and ngay_lam_hop_dong not in
				(select hd.ngay_lam_hop_dong
				from hop_dong as hd
		where (year(hd.ngay_lam_hop_dong)=2019) and (month(hd.ngay_lam_hop_dong)in(1,2,3,4,6)));
        
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều 
-- nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có 
-- nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.*
from dich_vu_di_kem as dvdk
inner join hop_dong_chi_tiet as hdct
on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
inner join hop_dong as hd
on hd.id_hop_dong=hdct.id_hop_dong
inner join khach_hang as kh
on kh.id_khach_hang =hd.id_khach_hang
group by dvdk.id_dich_vu_di_kem
having max(hdct.so_luong)>=all(
					select sum(hop_dong_chi_tiet.so_luong)
					from hop_dong_chi_tiet
					group by hop_dong_chi_tiet.id_dich_vu_di_kem
                    );

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được 
-- sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, 
-- TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hd.id_hop_dong,
		ldv.ten_loai_dich_vu,
		dvdk.ten_dich_vu_di_kem,
		sum(hdct.so_luong) as so_luong
from hop_dong as hd
	inner join dich_vu as dv 
		on dv.id_dich_vu=hd.id_dich_vu
	inner join loai_dich_vu as ldv
		on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
	inner join hop_dong_chi_tiet as hdct
		on hdct.id_hop_dong=hd.id_hop_dong
	inner join dich_vu_di_kem as dvdk 
		on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having so_luong=1;


-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, 
-- HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được
--  tối đa 3 hợp đồng từ năm 2018 đến 2019.

select nv.id_nhan_vien,nv.ho_ten_nhan_vien,td.trinh_do,bp.ten_bo_phan,
		nv.sdt_nhan_vien,nv.dia_chi_nhan_vien
from nhan_vien as nv
inner join trinh_do as td 
	on td.id_trinh_do =nv.id_trinh_do
inner join bo_phan as bp 
	on bp.id_bo_phan=nv.id_bo_phan
left join hop_dong as hd 
	on hd.id_nhan_vien=nv.id_nhan_vien
where  hd.id_nhan_vien in (select hd.id_nhan_vien
							from hop_dong as hd
                            where (year(hd.ngay_lam_hop_dong) between 2018 and 2019)
)
						
group by hd.id_nhan_vien
having count(hd.id_nhan_vien)<=3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.



