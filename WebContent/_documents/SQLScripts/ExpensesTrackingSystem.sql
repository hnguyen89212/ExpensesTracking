/**
 * Connection information for:
 *  - Macbook: root @ passWORD (MySQL@8.0.19)
 *  - Windows: '' @ '' (xampp)
 */

DROP DATABASE IF EXISTS ExpensesTrackingSystem;

CREATE DATABASE ExpensesTrackingSystem;

USE ExpensesTrackingSystem;

CREATE TABLE week_day(
	week_day_id				INT NOT NULL AUTO_INCREMENT,
	week_day				VARCHAR(20) NOT NULL,
	PRIMARY KEY(week_day_id),
	UNIQUE(week_day)
--	We cannot use CHECK on the primary key
--	CHECK(week_day_id < 8)
);

CREATE TABLE city(
	city_id					INT NOT NULL AUTO_INCREMENT,
	city_name				VARCHAR(100) NOT NULL,
	PRIMARY KEY(city_id)
);

CREATE TABLE postal_code(
	postal_code				VARCHAR(6) NOT NULL,
	city_id					INT NOT NULL,
	PRIMARY KEY(postal_code),
	FOREIGN KEY(city_id) REFERENCES city(city_id)
);

CREATE TABLE telephone_category(
	phone_category_id		INT NOT NULL AUTO_INCREMENT,
	phone_category_desc		VARCHAR(50) NOT NULL,
	PRIMARY KEY(phone_category_id),
	UNIQUE(phone_category_desc)
);

CREATE TABLE customer(
	customer_id 			INT NOT NULL AUTO_INCREMENT,
	first_name 				VARCHAR(50) NOT NULL DEFAULT 'John',
	last_name 				VARCHAR(50) NOT NULL DEFAULT 'Doe',
	address 				VARCHAR(100),
	postal_code 			VARCHAR(6) NOT NULL,
	email 					VARCHAR(100) NOT NULL,
--	monthly_start_date 		DATETIME NOT NULL,
	monthly_start_date		TINYINT NOT NULL DEFAULT 1,
	PRIMARY KEY(customer_id),
	FOREIGN KEY(postal_code) REFERENCES postal_code(postal_code),
	UNIQUE(email)
);

CREATE TABLE telephone(
	phone_id				INT NOT NULL AUTO_INCREMENT,
	customer_id 			INT NOT NULL,
	phone_category_id 		INT NOT NULL DEFAULT 1,
	phone_number 			VARCHAR(10) NOT NULL,
	PRIMARY KEY(phone_id),
	FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY(phone_category_id) REFERENCES telephone_category(phone_category_id),
	UNIQUE(phone_number)
);


CREATE TABLE product(
	product_id				INT NOT NULL AUTO_INCREMENT,
	product_name			VARCHAR(200) NOT NULL,
	PRIMARY KEY(product_id),
	UNIQUE(product_name)
);

CREATE TABLE store(
	store_id				INT NOT NULL AUTO_INCREMENT,
	store_name				VARCHAR(100) NOT NULL,
	address					VARCHAR(100),
	postal_code 			VARCHAR(6) NOT NULL,
	PRIMARY KEY(store_id),
	FOREIGN KEY(postal_code) REFERENCES postal_code(postal_code)
);



CREATE TABLE store_week_day_opening_hour(
	store_week_day_id		INT NOT NULL AUTO_INCREMENT,
	store_id				INT NOT NULL,
	week_day_id				INT NOT NULL,
	from_hour				INT NOT NULL DEFAULT 8,
	to_hour					INT NOT NULL DEFAULT 20,
	PRIMARY KEY(store_week_day_id),
	FOREIGN KEY(store_id) REFERENCES store(store_id),
	FOREIGN KEY(week_day_id) REFERENCES week_day(week_day_id)
);

CREATE TABLE monthly_budget(
	monthly_budget_id		INT NOT NULL AUTO_INCREMENT,
	customer_id				INT NOT NULL,
	year					INT NOT NULL,
	month					INT NOT NULL,
	amount					INT NOT NULL DEFAULT 1000,
	PRIMARY KEY(monthly_budget_id),
	FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
	UNIQUE(customer_id, year, month)
);

CREATE TABLE receipt(
	receipt_id 				INT NOT NULL AUTO_INCREMENT,
	store_id				INT NOT NULL,
	customer_id				INT NOT NULL,
	print_timestamp			TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(receipt_id),
	FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY(store_id) REFERENCES store(store_id)
);

CREATE TABLE receipt_product(
	receipt_product_id		INT NOT NULL AUTO_INCREMENT,
	receipt_id				INT NOT NULL,
	product_id				INT NOT NULL,
	quantity				TINYINT NOT NULL DEFAULT 1,
	sale_price				DECIMAL(13, 4) NOT NULL,
	hst						DECIMAL(4, 2) NOT NULL,
	PRIMARY KEY(receipt_product_id),
	FOREIGN KEY(receipt_id) REFERENCES receipt(receipt_id),
	FOREIGN KEY(product_id) REFERENCES product(product_id),
	UNIQUE(receipt_id, product_id)
);