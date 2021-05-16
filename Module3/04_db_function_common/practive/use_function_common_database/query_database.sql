use`management_student`;
-- Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select address,count(student_id)as'so_luong_hoc_vien'
from student
group by address;

-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
select s.student_id,s.student_name,avg(mark)as'diem_trung_binh'
from student s
inner join mark m on s.student_id=m.student_id
group by s.student_id;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select s.student_id,s.student_name,avg(mark)as'diem_trung_binh'
from student s
inner join mark m on m.student_id=s.student_id
group by s.student_id,student_name
having avg(mark)>15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất
select s.student_id,s.student_name,avg(mark)
from student s 
inner join mark m on s.student_id=m.student_id
group by s.student_id,s.student_name
having avg(mark)>=all(select avg(mark) from mark group by mark.mark_id);