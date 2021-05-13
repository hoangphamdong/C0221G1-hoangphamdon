create databasebo_phan `quan_ly_ban_hang`;
use `quan_ly_ban_hang`;
create table customer(
customer_id int primary key auto_increment not null,
customer_name varchar(50) not null,
customer_age int not null);
create table `order`(
order_id int auto_increment not null primary key,
customer_id int not null,
order_date date not null,
order_total_price int,
foreign key(customer_id)references customer(customer_id));
create table product(
product_id int primary key not null,
product_name varchar (50) not null,
product_price int not null);
create table order_detail(
order_id int not null,
product_id int not null,
order_detail_quantity int,
primary key(order_id,product_id),
foreign key(order_id) references `order`(order_id),
foreign key(product_id) references `product`(product_id)
);