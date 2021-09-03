CREATE TABLE USERS(
  id INT not null PRIMARY KEY,	
  username varchar_ignorecase(500) not null,
  password varchar_ignorecase(500) not null,
  enabled boolean	
);

CREATE TABLE AUTHORITIES(
  username varchar_ignorecase(500) not null,
  authority varchar_ignorecase(500) not null
);

create unique index ix_auth_username on authorities (username,authority);
  
CREATE TABLE DNA (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  sequence VARCHAR(1000) NOT NULL,
  creation_date TIME DEFAULT NULL,
  created_by VARCHAR(1000) DEFAULT NULL,
  enabled boolean	
);

CREATE TABLE PRIMER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(1000) NOT NULL,
  sequence VARCHAR(1000) NOT NULL,
  creation_date TIME DEFAULT NULL,
  created_by VARCHAR(1000) DEFAULT NULL
);

CREATE TABLE PROCESS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  dna_id VARCHAR(1000) NOT NULL,
  primer_id VARCHAR(1000) NOT NULL,
  polymerase_id  VARCHAR(1000) DEFAULT NULL,
  execution_date TIME DEFAULT NULL,
  executed_by VARCHAR(1000) DEFAULT NULL
);


