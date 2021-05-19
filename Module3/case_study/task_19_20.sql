use`data_base_furuma_resort`;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update dich_vu_di_kem 
set gia=gia*2
where id_dich_vu_di_kem in(
	select hdct.id_dich_vu_di_kem
		from hop_dong_chi_tient as hdct
			inner join hop_dong as hd
				on hd.id_hop_dong=hdct.id_hop_dong
		where (year(hd.ngay_lam_hop_dong)=2019) 
		group by hdct.id_dich_vu_di_kem
		having count(hdct.id_dich_vu_di_kem)>=10);

set sql_safe_updates=0;


-- 20.	Hiển thị thông tin của tất cả các Nhâviên và Khách hàng
--  có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang),
--  HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select nv.id_nhan_vien,nv.ho_ten, nv.email,nv.sdt,nv.ngay_sinh,nv.dia_chi
from nhan_vien as nv
union all
select kh.id_khach_hang ,kh.ho_ten, kh.email,kh.sdt,kh.ngay_sinh,kh.dia_chi
from khach_hang as kh;
