use `management_student`;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất
select * 
from `subject`as sub
where credit=(select max(credit) from `subject`)
group by sub_id;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sub.sub_id,sub.sub_name,m.mark
from `subject`sub
inner join mark m on sub.sub_id=m.sub_id
where m.mark=(select  max(mark) from mark)
group by sub.sub_id; 

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên,
--  xếp hạng theo thứ tự điểm giảm dần

select* ,avg(mark)as 'diem_trung_binh'
from student s
left join mark m on s.student_id=m.student_id
group by s.student_id
order by 'diem_trung_binh' desc;


