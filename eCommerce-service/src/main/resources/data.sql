create database ecommerce;

INSERT INTO ecommerce.profiles (id, first_name, last_name, title, company, email, address, phone_number) VALUES ('1', 'Vivek', 'Shankar', 'mr', 'BT', 'vivek@gmail.com', 'Bengaluru', '123');
INSERT INTO ecommerce.profiles (id, first_name, last_name, title, company, email, address, phone_number) VALUES ('2', 'Vinay', 'Kumar', 'mr', 'FinCorp', 'vinay@gmail.com', 'Mandya', '124');
INSERT INTO ecommerce.profiles (id, first_name, last_name, title, company, email, address, phone_number) VALUES ('3', 'Vani', 'Satish', 'mrs', 'VC', 'vani@gmail.com', 'Chandapur', '125');
INSERT INTO ecommerce.profiles (id, first_name, last_name, title, company, email, address, phone_number) VALUES ('4', 'Veena', 'Sendhil', 'mrs', 'HM', 'veena@gmail.com', 'Madiwala', '126');
INSERT INTO ecommerce.profiles (id, first_name, last_name, title, company, email, address, phone_number) VALUES ('5', 'Vidya', 'Nagarathna', 'mrs', 'Ape', 'vidya@gmail.com', 'mandya', '127');

INSERT INTO ecommerce.sellers (id, account_id, profile_id) VALUES ('1', 'ACC01', '1');
INSERT INTO ecommerce.sellers (id, account_id, profile_id) VALUES ('2', 'ACC02', '2');
INSERT INTO ecommerce.sellers (id, account_id, profile_id) VALUES ('3', 'ACC03', '3');
INSERT INTO ecommerce.sellers (id, account_id, profile_id) VALUES ('4', 'ACC04', '4');
INSERT INTO ecommerce.sellers (id, account_id, profile_id) VALUES ('5', 'ACC05', '5');

INSERT INTO ecommerce.categories (id, name) VALUES ('1', 'shirt');
INSERT INTO ecommerce.categories (id, name) VALUES ('2', 'pant');
INSERT INTO ecommerce.categories (id, name) VALUES ('3', 'socks');
INSERT INTO ecommerce.categories (id, name) VALUES ('4', 'cap');


INSERT INTO ecommerce.products (id, brand, color, price, size, sku, seller_id, name) VALUES ('1', 'Nike', 'Red', '100', '30', 'SKU01', '1', 'Pull over');
INSERT INTO ecommerce.products (id, brand, color, price, size, sku, seller_id, name) VALUES ('2', 'Nike', 'Red', '105', '30', 'SKU01', '2', 'Pull over');
INSERT INTO ecommerce.products (id, brand, color, price, size, sku, seller_id, name) VALUES ('3', 'Nike', 'Blue', '100', '30', 'SKU02', '3', 'Polo');
INSERT INTO ecommerce.products (id, brand, color, price, size, sku, seller_id, name) VALUES ('4', 'Nike', 'Black', '100', '30', 'SKU03', '4', 'pepe jeans');
INSERT INTO ecommerce.products (id, brand, color, price, size, sku, seller_id, name) VALUES ('5', 'Nike', 'Yellow', '100', '30', 'SKU04', '5', 'sports socks');
INSERT INTO ecommerce.products (id, brand, color, price, size, sku, seller_id, name) VALUES ('6', 'Nike', 'Red', '105', '30', 'SKU05', '2', 'sport cap');

INSERT INTO ecommerce.product_images (product_id, images) values(1, 'image1, image2');
INSERT INTO ecommerce.product_images (product_id, images) values(2, 'image3');
INSERT INTO ecommerce.product_images (product_id, images) values(3, 'image4, image5');
INSERT INTO ecommerce.product_images (product_id, images) values(4, 'image6, image7');
INSERT INTO ecommerce.product_images (product_id, images) values(5, 'image8, image9, image10');
INSERT INTO ecommerce.product_images (product_id, images) values(6, 'image11');


INSERT INTO ecommerce.products_categories (products_id, categories_id) VALUES ('1', '1');
INSERT INTO ecommerce.products_categories (products_id, categories_id) VALUES ('2', '1');
INSERT INTO ecommerce.products_categories (products_id, categories_id) VALUES ('3', '1');
INSERT INTO ecommerce.products_categories (products_id, categories_id) VALUES ('4', '2');
INSERT INTO ecommerce.products_categories (products_id, categories_id) VALUES ('5', '3');
INSERT INTO ecommerce.products_categories (products_id, categories_id) VALUES ('6', '4');