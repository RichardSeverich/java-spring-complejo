CREATE TABLE users(
   id INT AUTO_INCREMENT,
   username VARCHAR(10) NOT NULL UNIQUE,
   password VARCHAR(10) NOT NULL,
   dni VARCHAR(15) NOT NULL UNIQUE,
   name VARCHAR(50) NOT NULL,
   father_last_name VARCHAR(50) NOT NULL,
   mother_last_name VARCHAR(50) NOT NULL,
   birth_date DATE NOT NULL,
   telephone TEXT NOT NULL,
   address TEXT NOT NULL,
   email TEXT NOT NULL,
   type VARCHAR(10) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(10),
   updated_by VARCHAR(10),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

--
CREATE TABLE resources(
   id INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   price_hour TEXT NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(10),
   updated_by VARCHAR(10),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

--
CREATE TABLE hours_intervals(
   id INT AUTO_INCREMENT,
   name VARCHAR(12) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(10),
   updated_by VARCHAR(10),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

--
CREATE TABLE bookings(
   id INT AUTO_INCREMENT,
   id_resource INT NOT NULL,
   id_hours_interval INT NOT NULL,
   booking_date DATE NOT NULL,
   comments TEXT NOT NULL,
   billed boolean DEFAULT false,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(10),
   updated_by VARCHAR(10),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (id_resource) REFERENCES resources(id),
   FOREIGN KEY (id_hours_interval) REFERENCES hours_intervals(id),
   UNIQUE (id_resource, id_hours_interval, booking_date),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

--
CREATE TABLE bills(
   id INT AUTO_INCREMENT,
   bills_date DATE NOT NULL,
   bills_date_limit DATE NOT NULL,
   bills_control_code TEXT NOT NULL,
   booking_date DATE NOT NULL,
   company_name TEXT NOT NULL,
   company_nit TEXT NOT NULL,
   company_authorization TEXT NOT NULL,
   client_name TEXT NOT NULL,
   client_nit TEXT NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(10),
   updated_by VARCHAR(10),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

--
CREATE TABLE bills_detail(
   id INT AUTO_INCREMENT,
   id_booking INT NOT NULL,
   id_bill INT NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(10),
   updated_by VARCHAR(10),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (id_booking) REFERENCES bookings(id),
   FOREIGN KEY (id_bill) REFERENCES bills(id),
   UNIQUE (id_booking, id_bill),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
