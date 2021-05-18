use `data_base_furuma_resort`;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
delete 
from nhan_vien as nv
where nv.id_nhan_vien not in (
select hd.id_nhan_vien
from hop_dong as hd
 where (year(hd.ngay_lam_hop_dong) between 2017 and 2019
 ));
SET FOREIGN_KEY_CHECKS=1;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang
--  từ  Platinium lên Diamond, chỉ cập nhật những khách hàng 
--  đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019
--  là lớn hơn 10.000.000 VNĐ.
update  khach_hang as kh
set kh.id_loai_khach=1
where kh.id_khach_hang in
(select kh.id_khach_hang from
 (select kh.id_khach_hang,
sum(dv.chi_phi_thue+dvdk.gia*hdct.so_luong) as tong_tien
from khach_hang as kh
inner join hop_dong as hd
on kh.id_khach_hang =hd.id_khach_hang
inner join dich_vu as dv
on dv.id_dich_vu=hd.id_dich_vu
inner join hop_dong_chi_tient as hdct
on hdct.id_hop_dong=hd.id_hop_dong
inner join dich_vu_di_kem as dvdk
on dvdk.id_dich_vu_di_kem =hdct.id_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong)=2019 and kh.id_loai_khach=2
group by hd.id_khach_hang
having tong_tien>10000000)as kh);

SET SQL_SAFE_UPDATES = 0;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
delete from khach_hang as kh
where kh.id_khach_hang in
(select kh.id_khach_hang 
from khach_hang as kh
inner join hop_dong as hd
on hd.id_khach_hang=kh.id_khach_hang
where year(hd.ngay_lam_hop_dong)<2016
group by kh.id_khach_hang);


