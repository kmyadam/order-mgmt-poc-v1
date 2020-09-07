DROP TABLE IF EXISTS OMS_PRODUCT;
 
CREATE TABLE OMS_PRODUCT (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	name VARCHAR(100) NOT NULL,
  	code VARCHAR(100) NOT NULL,
  	price DECIMAL(10,2) NOT NULL
);