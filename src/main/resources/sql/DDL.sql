CREATE TABLE IF NOT EXISTS invenotry
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	customer VARCHAR(255) NOT NULL,
	color_code VARCHAR(255) NOT NULL,
	category VARCHAR(255) NOT NULL,
	ware_house VARCHAR(255) NOT NULL,
	in INT NOT NULL,
	out INT NOT NULL,	
	quantity INT NOT NULL
)

CREATE TABLE IF NOT EXISTS invenotry_log
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	inventory_id INT,
	operation_type INT,	
	quantity INT NOT NULL,
	create_time DATE 
)
