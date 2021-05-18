use `products`;
select * from products where product_code ='737';
explain select * from products where product_code ='737';

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
alter table products add index idx_product_code(product_code);
explain select * from products where product_code='737';

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table products add index idex_product_name_product_price(product_name,product_price);
explain select * from products where product_name='coca.cola' and product_price =8000;
explain select * from products where product_name='coca.cola';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products
create view product_view as
select product_code,product_name,product_price,product_status
from products;
select *from product_view as pv;

-- Tiến hành sửa đổi view
update product_view
set product_code=341
where product_code=3;

-- Tiến hành xoá view
drop view product_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure find_all_product()
begin
select * from products;
end 
// delimiter ;

call find_all_product();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure insert_new_product(p_product_code int,
									p_product_name varchar(50),
                                    p_product_price int,
                                    p_product_amount int,
                                    p_product_description varchar(50),
                                    p_product_status varchar(50))
begin
insert into products(product_code,product_name,product_price,product_amount,product_description,
product_status)
value(p_product_code,p_product_name,p_product_price,p_product_amount,p_product_description,p_product_status);
end
// delimiter ;

call insert_new_product(123,'sting',13000,2,'abcxyz','còn hàng');

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product_by_id(p_id int,
									p_product_code int,
									p_product_name varchar(50),
                                    p_product_price int,
                                    p_product_amount int,
                                    p_product_description varchar(50),
                                    p_product_status varchar(50))
begin
update products
set product_code=p_product_code,
	product_name=p_product_name,
	product_price=p_product_price,
    product_amount=p_product_amount,
    product_description=p_product_description,
    product_status=p_product_status
    where id=p_id;
end

// delimiter ;
call update_product_by_id(5,113,'on1',20000,0,'abcdd','hết hàng');

--  Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product_by_id(p_id int)
begin
delete from products
where id=p_id;
end
// delimiter ;
call delete_product_by_id(8);