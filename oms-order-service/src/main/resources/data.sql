INSERT INTO 
	OMS_ORDER (customer_name, order_date, shipping_address) 
VALUES
  	('Customer 01', CURDATE(), 'Street 123, City, State, Pin');
  	
INSERT INTO 
	OMS_ORDER_ITEM (product_name, product_code, order_id, quantity, price)
VALUES
  	('Product 01', 'Code 01', 1, 1, 100);