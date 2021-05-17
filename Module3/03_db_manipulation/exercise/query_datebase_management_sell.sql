create database `query_database_management_sell`;
use `query_database_management_sell`;

create table customer(
customer_id int primary key auto_increment not null,
customer_name varchar(25) not null,
customer_age tinyint not null);

create table `order`(
order_id int auto_increment not null primary key,
customer_id int not null,
order_date varchar(25) not null,
foreign key(customer_id)references customer(customer_id));

create table product(
product_id int primary key not null auto_increment,
product_name varchar (25) not null,
product_price int not null);

create table order_detail(
order_id int not null,
product_id int not null,
order_detail_quantity int,
primary key(order_id,product_id),
foreign key(order_id) references `order`(order_id),
foreign key(product_id) references `product`(product_id));

-- thêm dữ diệu customer
insert into customer(customer_name,customer_age)
value('Minh Quan',10),
('Ngoc Anh',20),
('Hong Ha',50);

-- thêm dữ liệu order
insert into `order`(customer_id,order_date)
value(1,'21/3/2006'),
(2,'23/3/2006'),
(1,'16/3/2006');

-- thêm dữ liệu product
insert into product(product_name,product_price)
value ('May Giac',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);

-- thêm dữ liệu order_dentail
insert into order_detail(order_id,product_id,order_detail_quantity)
value(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin tất cả các hóa đơn trong bảng Order
select*from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách 

select c.customer_id,c.customer_name,c.customer_age,o.order_date,p.product_name,p.product_price
from customer c
inner join `order` o on c.customer_id=o.customer_id
 inner join order_detail od on o.order_id=od.order_id
 inner join product p on p.product_id=od.product_id;
 
 -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
 select c.customer_name
 from customer c
 left join `order` o on c.customer_id=o.customer_id
where customer_name is null
group by c.customer_name;
 
--  Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn customer
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện
--  trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)

select c.customer_id,c.customer_name,c.customer_age,o.order_date,
p.product_name,p.product_price,od.order_detail_quantity,sum(order_detail_quantity*product_price)as 'total_order_dental_quantity',
p.product_price*od.order_detail_quantity"total"
from customer c
inner join `order` o on c.customer_id=o.customer_id
inner join order_detail od on o.order_id=od.order_id
inner join product p on p.product_id=od.product_id
group by o.order_id;
