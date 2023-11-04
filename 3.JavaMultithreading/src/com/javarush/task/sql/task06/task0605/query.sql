
CREATE TABLE users (
user_id INT PRIMARY KEY auto_increment,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
date DATE DEFAULT GETDATE() NOT NULL,
weight FLOAT(10) NULL
);
