/* campテーブル */
CREATE TABLE IF NOT EXISTS camp (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   camp_name VARCHAR(50) NOT NULL,
   score INT NOT NULL,
   image_name VARCHAR(50) NOT NULL,
   introduction TEXT NOT NULL,
   prefecture VARCHAR(50) NOT NULL,
   city_address VARCHAR(255) NOT NULL,
   phone_number VARCHAR(50) NOT NULL,
   regular_holiday VARCHAR(50) NOT NULL,
   parking VARCHAR(50) NOT NULL,
   parking_fee VARCHAR(50) NOT NULL,
   drive_in VARCHAR(50) NOT NULL,
   check_in_time VARCHAR(50) NOT NULL,
   check_out_time VARCHAR(50) NOT NULL,
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* facilityテーブル */
CREATE TABLE IF NOT EXISTS facility (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   facility_name VARCHAR(50) NOT NULL
);

/* camp_facilityテーブル */
CREATE TABLE IF NOT EXISTS camp_facility (
   camp_id INT NOT NULL,
   facility_id INT NOT NULL,
   FOREIGN KEY (camp_id) REFERENCES camp (id),
   FOREIGN KEY (facility_id) REFERENCES facility (id)
);

/* shelterテーブル */
CREATE TABLE IF NOT EXISTS shelter (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   shelter_name VARCHAR(50) NOT NULL,
   image_name VARCHAR(50) NOT NULL,
   prefecture VARCHAR(50) NOT NULL,
   city_address VARCHAR(255) NOT NULL,
   phone_number VARCHAR(50) NOT NULL,
   capacity_short INT NOT NULL,
   capacity_long INT NOT NULL,
   space INT NOT NULL,
   quake BOOLEAN NOT NULL,
   damage BOOLEAN NOT NULL,
   safety_precautions VARCHAR(255) NOT NULL,
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* camp_shelterテーブル */
CREATE TABLE IF NOT EXISTS camp_shelter (
   camp_id INT NOT NULL,
   shelter_id INT NOT NULL,
   FOREIGN KEY (camp_id) REFERENCES camp (id),
   FOREIGN KEY (shelter_id) REFERENCES shelter (id)
);

/* reviewテーブル */
CREATE TABLE IF NOT EXISTS review (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   camp_id INT NOT NULL,
   review TEXT NOT NULL,
   score INT NOT NULL,
   FOREIGN KEY (camp_id) REFERENCES camp (id)
);

/* usersテーブル */
CREATE TABLE IF NOT EXISTS users (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   furigana VARCHAR(50) NOT NULL,
   birthday DATE,
   sex VARCHAR(50) NOT NULL,
   postal_code VARCHAR(50) NOT NULL,
   address VARCHAR(255) NOT NULL,
   phone_number VARCHAR(50) NOT NULL,
   email VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL,
   enabled BOOLEAN NOT NULL,
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted_at DATETIME NULL
);

/* mamechisikiテーブル */
CREATE TABLE IF NOT EXISTS mamechisiki (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   mamechisiki TEXT NOT NULL
);
 