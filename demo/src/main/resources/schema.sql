
CREATE TABLE ingredient (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    inventoryCount integer NOT NULL,
    cost integer NOT NULL,
    inventoryMax integer NOT NULL,
    PRIMARY KEY (id)
);