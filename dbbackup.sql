CREATE TABLE app_user (
	username VARCHAR(20) NOT NULL,
	password VARCHAR(200),
	firstname VARCHAR(20),
	lastname VARCHAR(20),
	email VARCHAR(50),
	phone VARCHAR(20),
	address VARCHAR(500),
	is_active TINYINT(1) DEFAULT '1',
	created_date TIMESTAMP,
	modified_date TIMESTAMP,
	PRIMARY KEY (username)
);

INSERT INTO app_user (username, password, firstname, lastname, email, phone, address, is_active, created_date, modified_date) VALUES ('axel', '$2a$10$POH.Nm9ylO9VtTpgtwxZXeeUEFwQY52UFKqqf0hvVSwVnJ3XyaNyu', 'Ibrahim', 'Axel', 'axel@gmail.com', '081311114909', 'Paradise Serpong City, Kawasan Adventures, Cluster Balmoral, J29/61 Kel. Babakan, Kec. Setu, Tangerang Selatan, Banten, 15315', 1, '2024-02-02 05:54:11', '2024-02-02 05:54:13');
INSERT INTO app_user (username, password, firstname, lastname, email, phone, address, is_active, created_date, modified_date) VALUES ('rey', '$2a$10$wPaWi3S4dkwqqPu5nDQCb.yEjnxwGObYDIYgTlNCno8ccwyhpaWXS', 'Muhammad', 'Rayyanka', 'rey@gmail.com', '081311114910', 'Paradise Serpong City, Kawasan Adventures, Cluster Balmoral, J29/62 Kel. Babakan, Kec. Setu, Tangerang Selatan, Banten, 15315', 1, '2024-02-02 05:54:11', '2024-02-02 05:54:13');
INSERT INTO app_user (username, password, firstname, lastname, email, phone, address, is_active, created_date, modified_date) VALUES ('anjar', '$2a$10$e6Zmh5mkTffy6/hGNFjAnO0ZlDfDWd/baa/uRNgM9GzTl2eiFI2yG', 'Ginanjar', 'Sanjaya', 'anjar@gmail.com', '081311114911', 'Paradise Serpong City, Kawasan Adventures, Cluster Balmoral, J29/63 Kel. Babakan, Kec. Setu, Tangerang Selatan, Banten, 15315', 1, '2024-02-02 05:54:11', '2024-02-02 05:54:11');

CREATE TABLE app_product (
	product_code VARCHAR(20) NOT NULL,
	product_name VARCHAR(200),
	price DECIMAL(20,4),
	quantity INT(10),
	PRIMARY KEY (product_code)
);

INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('I000001', 'Iphone 11', 5000000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('I000002', 'Iphone 12 Pro', 6000000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('S000001', 'Samsung Galaxy S24', 5000000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('S000002', 'Samsung Z Flip', 7000000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('S000003', 'Samsung Z Fold', 7500000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('V000001', 'Vivo Y27', 2000000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('V000002', 'Vivo V29', 5500000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('X000001', 'Xiaomi X5 Pro', 5000000.0000, 10);
INSERT INTO app_product (product_code, product_name, price, quantity) VALUES ('X000002', 'Xiaomi Poco X3', 5500000.0000, 10);

CREATE TABLE app_order (
	id_order INT(10) NOT NULL AUTO_INCREMENT,
	username VARCHAR(20),
	order_date TIMESTAMP,
	PRIMARY KEY (id_order)
)
AUTO_INCREMENT=4;

INSERT INTO app_order (id_order, username, order_date) VALUES (1, 'rey', '2024-02-10 05:21:10');
INSERT INTO app_order (id_order, username, order_date) VALUES (2, 'axel', '2024-02-09 23:21:19');
INSERT INTO app_order (id_order, username, order_date) VALUES (3, 'anjar', '2024-02-09 03:21:26');

CREATE TABLE app_order_detail (
	id_order_detail INT(10) NOT NULL AUTO_INCREMENT,
	id_order INT(10),
	product_code VARCHAR(20),
	quantity INT(10),
	price DECIMAL(20,4),
	discount DECIMAL(20,4),
	total_amount DECIMAL(20,4),
	PRIMARY KEY (id_order_detail)
)
AUTO_INCREMENT=7;

INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (1, 1, 'S000001', 1, 5000000.0000, 0.0000, 5000000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (2, 2, 'S000002', 1, 7000000.0000, 0.0000, 7000000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (3, 2, 'S000003', 2, 7500000.0000, 500000.0000, 14500000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (4, 3, 'I000001', 1, 5000000.0000, 0.0000, 5000000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (5, 3, 'I000002', 2, 6000000.0000, 500000.0000, 11500000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (6, 3, 'X000001', 1, 5000000.0000, 0.0000, 5000000.0000);

