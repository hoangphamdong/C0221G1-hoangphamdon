CREATE DATABASE `demo2`;
USE demo2;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER //
CREATE PROCEDURE get_user()
BEGIN
    SELECT *
    FROM users;
    END ;

// DELIMITER ;

CALL get_user;


DELIMITER //
CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END//
DELIMITER ;

call get_user_by_id(1);

call delete_user_by_id(1);
DELIMITER //
CREATE PROCEDURE delete_user_by_id(IN user_id INT)

BEGIN

    delete 

    FROM users

    where users.id = user_id;

    END//
DELIMITER ;