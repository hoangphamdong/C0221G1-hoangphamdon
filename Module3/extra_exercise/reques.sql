use `intership`;

-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên

select i.instructor_id,i.instructor_name,f.faculty_name
from instructor as i
inner join faculty as f;

-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa 
-- của các giảng viên của khoa ‘DIA LY va QLTN’

select i.instructor_id,i.instructor_name,f.faculty_name
from instructor as i
inner join faculty as f
where (f.faculty_name='DIA Ly' or f.faculty_name='QLTN')
group by instructor_id;

-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select f.faculty_name,
		sum(s.student_id) as total_student
from faculty as  f
inner join student as s
on f.faculty_id=s.faculty_id
group by s.student_id;