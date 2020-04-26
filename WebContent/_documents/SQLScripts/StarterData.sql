/**
 * Connection information for:
 *  - Macbook: root @ passWORD (MySQL@8.0.19)
 *		- log into mysql cmdl tool
 *		- source /Users/hainguyen/workspace/jee/ExpensesTracking/WebContent/_documents/SQLScripts/StarterData.sql 
 *  - Windows: '' @ '' (xampp)
 */
 
USE ExpensesTrackingSystem;

-- ========================================================
-- week_day

INSERT INTO week_day(week_day) VALUES('Monday');
INSERT INTO week_day(week_day) VALUES('Tuesday'); 
INSERT INTO week_day(week_day) VALUES('Wednesday'); 
INSERT INTO week_day(week_day) VALUES('Thursday'); 
INSERT INTO week_day(week_day) VALUES('Friday'); 
INSERT INTO week_day(week_day) VALUES('Saturday'); 
INSERT INTO week_day(week_day) VALUES('Sunday'); 

-- ========================================================
-- city

INSERT INTO city(city_name) VALUES('London');
INSERT INTO city(city_name) VALUES('Toronto');
INSERT INTO city(city_name) VALUES('Vancouver');

-- ========================================================
-- postal_code

-- Walmart London
INSERT INTO postal_code(postal_code, city_id) VALUES('N5Y1A8', '1'); -- 1275 Highbury Avenue N
INSERT INTO postal_code(postal_code, city_id) VALUES('N5W6G4', '1'); -- 330 Clark Rd
INSERT INTO postal_code(postal_code, city_id) VALUES('N6G5B1', '1'); -- 1280 Fanshawe Park Rd W
-- No Frills Toronto
INSERT INTO postal_code(postal_code, city_id) VALUES('M5A4T9', '2'); -- 200 Front St E
INSERT INTO postal_code(postal_code, city_id) VALUES('M5A3A3', '2'); -- 449 Parliament St
INSERT INTO postal_code(postal_code, city_id) VALUES('M4W3J6', '2'); -- 345 Bloor St E
-- Walmart Vancouver
INSERT INTO postal_code(postal_code, city_id) VALUES('V7P1S3', '3'); -- 925 Marine Dr,
INSERT INTO postal_code(postal_code, city_id) VALUES('V5M2G7', '3'); -- 3585 Grandview Hwy,
INSERT INTO postal_code(postal_code, city_id) VALUES('V5H4J5', '3'); -- 4545 Central Blvd
-- Other random postal codes I know
INSERT INTO postal_code(postal_code, city_id) VALUES('N5X0E1', '1');
INSERT INTO postal_code(postal_code, city_id) VALUES('N6A1A9', '1');
INSERT INTO postal_code(postal_code, city_id) VALUES('N5V4C3', '1');


-- ========================================================
-- telephone_category

INSERT INTO telephone_category(phone_category_desc) VALUES('mobile');
INSERT INTO telephone_category(phone_category_desc) VALUES('landline');

-- ========================================================
-- customer

INSERT INTO customer(first_name, last_name, address, postal_code, email, monthly_start_date) 
VALUES('Hai', 'Nguyen', '342 Okanagan Way', 'N5X0E1', 'phuchai1994@gmail.com', 5);

INSERT INTO customer(first_name, last_name, address, postal_code, email, monthly_start_date) 
VALUES('Minh', 'Nguyen', '14 Redwood Lane', 'N5V4C3', 'minhng95@gmail.com', 2);

INSERT INTO customer(first_name, last_name, address, postal_code, email, monthly_start_date) 
VALUES('Phi', 'Dac', '14 Redwood Lane', 'N5V4C3', 'pdac@outlook.ca', 10);

INSERT INTO customer(first_name, last_name, address, postal_code, email, monthly_start_date) 
VALUES('Yan', 'Zhang', '148 York Street', 'N6A1A9', 'yzhange@echidna.ca', 5);

INSERT INTO customer(first_name, last_name, address, postal_code, email, monthly_start_date) 
VALUES('On', 'Tran', '342 Okanagan Way', 'N5X0E1', 'ontran@hotmail.ca', 5);

-- ========================================================
-- telephone

INSERT INTO telephone(customer_id, phone_category_id, phone_number)
VALUES('1', '1', '2265038196');

INSERT INTO telephone(customer_id, phone_category_id, phone_number)
VALUES('2', '2', '6135550135');

INSERT INTO telephone(customer_id, phone_category_id, phone_number)
VALUES('3', '2', '4503695145');

INSERT INTO telephone(customer_id, phone_category_id, phone_number)
VALUES('4', '1', '9059491538');

INSERT INTO telephone(customer_id, phone_category_id, phone_number)
VALUES('5', '1', '7804195206');

-- ========================================================
-- product

INSERT INTO product(product_name) VALUES('tissue paper');
INSERT INTO product(product_name) VALUES('headphone');
INSERT INTO product(product_name) VALUES('laptop');
INSERT INTO product(product_name) VALUES('chicken nugget');
INSERT INTO product(product_name) VALUES('webcam');
INSERT INTO product(product_name) VALUES('keyboard');

-- ========================================================
-- store

INSERT INTO store(store_name, address, postal_code) 
VALUES('Walmart Northland', '1275 Highbury Avenue N', 'N5Y1A8');

INSERT INTO store(store_name, address, postal_code) 
VALUES('Walmart Argyle Supercenter', '330 Clark Road', 'N5W6G4');

INSERT INTO store(store_name, address, postal_code) 
VALUES('Walmart London North Supercenter', '1280 Fanshawe Park Road W', 'N6G5B1');

INSERT INTO store(store_name, address, postal_code) 
VALUES('Rocco No Frills', '200 Front Street E', 'M5A4T9');

INSERT INTO store(store_name, address, postal_code) 
VALUES('Cosimo No Frills', '449 Parliament Street', 'M5A3A3');

INSERT INTO store(store_name, address, postal_code) 
VALUES('Rexall Pharma Plus', '345 Bloor Street E', 'M4W3J6');

INSERT INTO store(store_name, address, postal_code) 
VALUES('North Vancouver Supercenter', '925 Marine Drive', 'V7P1S3');

INSERT INTO store(store_name, address, postal_code) 
VALUES('Walmart Grandview Supercenter', '3585 Grandview Hwy', 'V5M2G7');

INSERT INTO store(store_name, address, postal_code) 
VALUES('Burnaby Metrotown Walmart Supercenter', '4545 Central Blvd', 'V5H4J5');

-- ========================================================
-- store_week_day_opening_hour

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('1', '1', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('1', '2', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('1', '3', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('1', '4', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('1', '5', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('1', '6', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('1', '7', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('2', '1', '9', '22');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('2', '2', '9', '22');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('2', '3', '10', '21');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('2', '4', '9', '20');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('2', '5', '10', '22');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('2', '6', '10', '17');

INSERT INTO store_week_day_opening_hour(store_id, week_day_id, from_hour, to_hour)
VALUES('2', '7', '10', '17');

-- ========================================================
-- monthly_budget

INSERT INTO monthly_budget(customer_id, year, month, amount)
VALUES('1', '20020', '4', '3000');

INSERT INTO monthly_budget(customer_id, year, month, amount)
VALUES('2', '20020', '4', '900');

INSERT INTO monthly_budget(customer_id, year, month, amount)
VALUES('3', '20020', '4', '1500');

INSERT INTO monthly_budget(customer_id, year, month, amount)
VALUES('4', '20020', '4', '1200');

-- ========================================================
-- receipt

INSERT INTO receipt(store_id, customer_id, print_timestamp)
VALUES('1', '1', '2020-04-20 10:12:24');

INSERT INTO receipt(store_id, customer_id, print_timestamp)
VALUES('1', '1', '2020-04-21 15:10:00');

-- ========================================================
-- receipt_product

INSERT INTO receipt_product(receipt_id, product_id, quantity, sale_price, hst)
VALUES('1', '1', '2', '12.30', '13.00');

INSERT INTO receipt_product(receipt_id, product_id, quantity, sale_price, hst)
VALUES('1', '3', '1', '15.30', '13.00');

INSERT INTO receipt_product(receipt_id, product_id, quantity, sale_price, hst)
VALUES('1', '2', '3', '9.00', '13.00');
