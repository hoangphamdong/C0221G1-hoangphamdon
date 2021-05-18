create database `products`;
use `products`;
-- Tạo bảng Products
create table products(
id int not null auto_increment primary key,
product_code int not null,
product_name varchar(50),
product_price int,
product_amount int,
product_description varchar(50),
product_status varchar(50));

insert into products()
values(1,979,'redbul',12000,5,'abcd','còn hàng'),
(2,003,'coca.cola',8000,10,'abcd','còn hàng'),
(3,024,'pepsi',8000,0,'abcdss','hết hàng'),
(4,737,'number1',10000,5,'abcd','còn hàng'),
(5,232,'mirida',15000,7,'abcd','còn hàng'),
(6,909,'c2',7000,5,'abcd','hết hàng'),
(7,332,'larue',10000,5,'abcd','còn hàng');
