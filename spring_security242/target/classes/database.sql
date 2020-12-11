CREATE TABLE userdb.users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL ,
    lastname VARCHAR(255) NOT NULL ,
    password VARCHAR(255) NOT NULL
)
ENGINE  = InnoDB;

-- Table roles
CREATE TABLE userdb.roles(
    id INT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)
    ENGINE = InnoDB;

-- Table for mapping user and roles:
CREATE TABLE userdb.user_roles(
    user_id INT NOT NULL ,
    role_id INT NOT NULL ,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    UNIQUE (user_id,role_id)
)
    ENGINE = InnoDB;

INSERT INTO userdb.users VALUES (1, 'mandalorian','starwars','asd');

INSERT INTO userdb.roles VALUES (1, 'ROLE_USER');
INSERT INTO userdb.roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO userdb.user_roles VALUE(1,2)

