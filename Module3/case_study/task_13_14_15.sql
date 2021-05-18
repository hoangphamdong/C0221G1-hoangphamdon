use `data_base_furuma_resort`;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi 
-- các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số
--  lần sử dụng nhiều như nhau).

select sum(hop_dong_chi_tient.so_luong) as so_lan,
		dich_vu_di_kem.ten_dich_vu_di_kem
from hop_dong_chi_tient
join dich_vu_di_kem
	on hop_dong_chi_tient.id_dich_vu_di_kem=dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tient.id_dich_vu_di_kem
 having sum(hop_dong_chi_tient.so_luong)>=
 all(select sum(hop_dong_chi_tient.so_luong)
 from hop_dong_chi_tient
 group by hop_dong_chi_tient.id_dich_vu_di_kem);
 
 
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một 
-- lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu,
--  TenDichVuDiKem, SoLanSuDung.
select hd.id_hop_dong,
		ldv.ten_loai_dich_vu,
		dvdk.ten_dich_vu_di_kem,
		sum(hdct.so_luong) as so_luong
from hop_dong as hd
inner join dich_vu as dv on dv.id_dich_vu=hd.id_dich_vu
inner join loai_dich_vu as ldv on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
inner join hop_dong_chi_tient as hdct on hdct.id_hop_dong=hd.id_hop_dong
inner join dich_vu_di_kem as dvdk on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having so_luong=1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen,
--  TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 
-- 3 hợp đồng từ năm 2018 đến 2019.
select nv.id_nhan_vien,nv.ho_ten,vt.ten_vi_tri,
		td.trinh_do,bp.ten_bo_phan,nv.sdt,nv.dia_chi
from nhan_vien as nv
inner join vi_tri as vt on vt.id_vi_tri=nv.id_vi_tri
inner join trinh_do as td on td.id_trinh_do =nv.id_trinh_do
inner join bo_phan as bp on bp.id_bo_phan=nv.id_bo_phan
inner join hop_dong as hd on hd.id_nhan_vien=nv.id_nhan_vien
group by nv.id_nhan_vien
having sum(nv.id_nhan_vien)<=3 ;





