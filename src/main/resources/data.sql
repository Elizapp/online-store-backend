
--For users
INSERT INTO `users` (`user_id`, `city`, `country`, `state`, `street`, `zipcode`, `email`, `enabled`, `first_name`, `last_name`, `password`, `phone_number`, `photo`, `username`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, 'admin@example.com', b'1', 'Admin', 'Admin', '$2a$10$JirblkU.nrFQVWpRJkeTcev6J1I/UoZvIDdjPUiIHKAeBrtZq8iYe', NULL, NULL, 'admin'),
(2, NULL, NULL, NULL, NULL, NULL, NULL, b'1', 'Seller', 'Seller', '$2a$10$JirblkU.nrFQVWpRJkeTcev6J1I/UoZvIDdjPUiIHKAeBrtZq8iYe', NULL, NULL, 'seller'),
(3, NULL, NULL, NULL, NULL, NULL, NULL, b'1', 'Buyer', 'Buyer', '$2a$10$JirblkU.nrFQVWpRJkeTcev6J1I/UoZvIDdjPUiIHKAeBrtZq8iYe', NULL, NULL, 'buyer'),
(5, NULL, NULL, NULL, NULL, NULL, 'test@example.com', b'1', 'Test', 'Test', '$2a$10$2ct/ZFJZYvsYFD6MlMpyXuzDyoO1xWrpfDcH8pNGE9h13AMMZORPu', '5043446969', NULL, 'test@example.com');

--For roles
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('SELLER');
INSERT INTO roles (name) VALUES ('BUYER');

--For assingning roles to users
INSERT INTO USERS_ROLES(user_id,role_id)
SELECT (SELECT ID FROM USERS WHERE USERNAME='ADMIN' LIMIT 1) , (SELECT ID FROM ROLES WHERE NAME='ADMIN' LIMIT 1);
INSERT INTO USERS_ROLES(user_id,role_id)
SELECT (SELECT ID FROM USERS WHERE USERNAME='SELLER' LIMIT 1) , (SELECT ID FROM ROLES WHERE NAME='SELLER' LIMIT 1);
INSERT INTO USERS_ROLES(user_id,role_id)
SELECT (SELECT ID FROM USERS WHERE USERNAME='BUYER' LIMIT 1) , (SELECT ID FROM ROLES WHERE NAME='BUYER' LIMIT 1);

--For categories
INSERT INTO Categories(category_id, category_name) VALUES('Grosery');
INSERT INTO Categories(category_id, category_name) VALUES('Shoes');
INSERT INTO Categories(category_id, category_name) VALUES('Clothing');