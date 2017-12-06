-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Table: manufacturers
CREATE TABLE manufacturers (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nameMan VARCHAR(255) NOT NULL

) ENGINE = InnoDB;

-- Table: products
CREATE TABLE products (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DECIMAL NOT NULL,
  manufacturer_id INT NOT NULL,

  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)

) ENGINE = InnoDB;

-- Insert data                              password 12345678

INSERT INTO users VALUES (1, 'roleadmin', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG','admin@email.com','General','Napoleon');
INSERT INTO users VALUES (2, 'tetyana1', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG','user@email.com','Imperator','Alexandr');
INSERT INTO users VALUES (3, 'useruser', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG','useruser@email.com','Imperator','August');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);
INSERT INTO user_roles VALUES (2, 2);
INSERT INTO user_roles VALUES (3, 1);

INSERT INTO manufacturers VALUE (1, 'Ariston');
INSERT INTO manufacturers VALUE (2, 'BMW');
INSERT INTO manufacturers VALUE (3, 'Samsung');
INSERT INTO manufacturers VALUE (4, 'IBM');
INSERT INTO manufacturers VALUE (5, 'Apple');
INSERT INTO manufacturers VALUE (6, 'Lipton');
INSERT INTO manufacturers VALUE (7, 'Luxoft');
INSERT INTO manufacturers VALUE (8, 'Mercedes');
INSERT INTO manufacturers VALUE (9, 'Lexus');

INSERT INTO products VALUE (1, 'car', 20, 1);
INSERT INTO products VALUE (2, 'plain', 300, 2);
INSERT INTO products VALUE (3, 'flat', 100, 3);
INSERT INTO products VALUE (4, 'house', 2300, 4);
INSERT INTO products VALUE (5, 'smart house', 1200, 5);
INSERT INTO products VALUE (6, 'phone', 100, 6);
INSERT INTO products VALUE (7, 'notebook', 350, 7);
INSERT INTO products VALUE (8, 'book', 50, 8);
INSERT INTO products VALUE (9, 'bike', 90, 9);
INSERT INTO products VALUE (10, 'office', 10000, 10);
INSERT INTO products VALUE (11, 'car', 20, 10);
INSERT INTO products VALUE (12, 'plain', 300, 7);
INSERT INTO products VALUE (13, 'flat', 100, 1);
INSERT INTO products VALUE (14, 'house', 2300, 2);
INSERT INTO products VALUE (15, 'smart house', 1200, 3);
INSERT INTO products VALUE (16, 'phone', 100, 4);
INSERT INTO products VALUE (17, 'notebook', 350, 5);
INSERT INTO products VALUE (18, 'book', 50, 6);
INSERT INTO products VALUE (19, 'bike', 90, 8);
INSERT INTO products VALUE (20, 'office', 10000, 9);