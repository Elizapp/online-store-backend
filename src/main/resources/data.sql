#roles insertion
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('SELLER');
INSERT INTO roles (name) VALUES ('BUYER');

#product categories insertion
INSERT INTO categories (name) VALUES ('Food');
INSERT INTO categories (name) VALUES ('Toys');
INSERT INTO categories (name) VALUES ('Electronics');
INSERT INTO categories (name) VALUES ('Fashion');
INSERT INTO categories (name) VALUES ('Furniture');

#users insertions
INSERT INTO users (city ,  country ,  state ,  street ,  zipcode ,  email ,  enabled ,  first_name ,  last_name ,  password ,  phone_number ,  photo ,  username ) VALUES
( NULL, NULL, NULL, NULL, NULL, 'admin@example.com', b'1', 'Admin', 'Admin', '$2a$10$JirblkU.nrFQVWpRJkeTcev6J1I/UoZvIDdjPUiIHKAeBrtZq8iYe', NULL, NULL, 'admin');

INSERT INTO users (city ,  country ,  state ,  street ,  zipcode ,  email ,  enabled ,  first_name ,  last_name ,  password ,  phone_number ,  photo ,  username ) VALUES
( NULL, NULL, NULL, NULL, NULL, 'buyer@example.com', b'1', 'Buyer', 'Buyer', '$2a$10$JirblkU.nrFQVWpRJkeTcev6J1I/UoZvIDdjPUiIHKAeBrtZq8iYe', NULL, NULL, 'buyer');

INSERT INTO users (city ,  country ,  state ,  street ,  zipcode ,  email ,  enabled ,  first_name ,  last_name ,  password ,  phone_number ,  photo ,  username ) VALUES
( NULL, NULL, NULL, NULL, NULL, 'seller@example.com', b'1', 'Seller', 'Seller', '$2a$10$JirblkU.nrFQVWpRJkeTcev6J1I/UoZvIDdjPUiIHKAeBrtZq8iYe', NULL, NULL, 'seller');

#user roles insertion
INSERT INTO USERS_ROLES(user_id,role_id)
SELECT (SELECT ID FROM USERS WHERE USERNAME='SELLER' LIMIT 1) , (SELECT ID FROM ROLES WHERE NAME='SELLER' LIMIT 1);

INSERT INTO USERS_ROLES(user_id,role_id)
SELECT (SELECT ID FROM USERS WHERE USERNAME='ADMIN' LIMIT 1) , (SELECT ID FROM ROLES WHERE NAME='ADMIN' LIMIT 1);

INSERT INTO USERS_ROLES(user_id,role_id)
SELECT (SELECT ID FROM USERS WHERE USERNAME='BUYER' LIMIT 1) , (SELECT ID FROM ROLES WHERE NAME='BUYER' LIMIT 1);

#Buyer insertion

#Seller insertion

#Admin insertion

