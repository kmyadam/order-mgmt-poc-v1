DROP TABLE IF EXISTS OMS_ORDER;
 
CREATE TABLE OMS_ORDER (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	customer_name VARCHAR(100) NOT NULL,
  	order_date DATE NOT NULL,
  	shipping_address VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS OMS_ORDER_ITEM;
 
CREATE TABLE OMS_ORDER_ITEM (
	id INT AUTO_INCREMENT PRIMARY KEY,
	order_id INT NOT NULL,
	product_id INT NOT NULL,
  	product_name VARCHAR(100) NOT NULL,
  	product_code VARCHAR(100) NOT NULL,
  	quantity INT NOT NULL,
  	price DECIMAL(10,2) NOT NULL
);