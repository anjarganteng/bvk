INSERT INTO app_order (id_order, username, order_date) VALUES (1, 'rey', '2024-02-10 05:21:10');
INSERT INTO app_order (id_order, username, order_date) VALUES (2, 'axel', '2024-02-09 23:21:19');
INSERT INTO app_order (id_order, username, order_date) VALUES (3, 'anjar', '2024-02-09 03:21:26');

INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (1, 1, 'S000001', 1, 5000000.0000, 0.0000, 5000000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (2, 2, 'S000002', 1, 7000000.0000, 0.0000, 7000000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (3, 2, 'S000003', 2, 7500000.0000, 500000.0000, 14500000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (4, 3, 'I000001', 1, 5000000.0000, 0.0000, 5000000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (5, 3, 'I000002', 2, 6000000.0000, 500000.0000, 11500000.0000);
INSERT INTO app_order_detail (id_order_detail, id_order, product_code, quantity, price, discount, total_amount) VALUES (6, 3, 'X000001', 1, 5000000.0000, 0.0000, 5000000.0000);
