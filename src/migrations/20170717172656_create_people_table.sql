CREATE TABLE people (
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  first_name VARCHAR(256),
  last_name  VARCHAR(256),
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;