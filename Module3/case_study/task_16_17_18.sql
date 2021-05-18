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

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).