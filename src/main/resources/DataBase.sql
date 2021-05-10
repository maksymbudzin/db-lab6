CREATE SCHEMA IF NOT EXISTS budzin_db_lab6_jdbc DEFAULT CHARACTER SET utf8;
USE budzin_db_lab6_jdbc;

-- -----------------------------------------------------
-- Table `budzin_db`.`TripAdvizor_object`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab6_jdbc.`TripAdvizor_object`
(
    `id`                  INT         NOT NULL AUTO_INCREMENT,
    `objec_name`          VARCHAR(30) NOT NULL,
    `number_of_star`      VARCHAR(1)  NOT NULL,
    `free_room`           VARCHAR(2)  NOT NULL,
    `busy_room`           VARCHAR(2)  NULL,
    `all_inclusive`       INT     NULL,
    `ultra_all_inclusive` INT     NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `budzin_db`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab6_jdbc.`Customer`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(20) NOT NULL,
    `surname` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab6_jdbc.`Feedback`
(
    `id`                     INT         NOT NULL AUTO_INCREMENT,
    `feedback_text`          VARCHAR(45) NOT NULL,
    `time`                   VARCHAR(45) NOT NULL,
    `Customer_id`            INT         NOT NULL,
    `Customer_Trip_Order_id` INT         NOT NULL,
    PRIMARY KEY (`id`, `Customer_id`, `Customer_Trip_Order_id`)

)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab6_jdbc.`rating`
(
    `Id`                     INT    NOT NULL AUTO_INCREMENT,
    `number_of_star`         INT(5) NOT NULL,
    `date`                   VARCHAR(30)  NOT NULL,
    `Customer_id`            INT    NOT NULL,
    `Customer_Trip_Order_id` INT    NOT NULL,
    PRIMARY KEY (`Id`, `Customer_id`, `Customer_Trip_Order_id`)

)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Owner_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab6_jdbc.`Owner_information`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `Name`    VARCHAR(45) NOT NULL,
    `Surname` VARCHAR(45) NOT NULL,
    `country` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Owner_information_has_TripAdvizor_object`
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `budzin_db`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab6_jdbc.`Location`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `Country` VARCHAR(45) NOT NULL,
    `City`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Locatio_TripAdvizor_object`
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `budzin_db`.`Trip_Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS budzin_db_lab6_jdbc.`Trip_Order`
(
    `id`               INT        NOT NULL AUTO_INCREMENT,
    `price_in_dollars` VARCHAR(4) NOT NULL,
    `date`             VARCHAR(30)       NOT NULL,
    `Customer_id`      INT        NOT NULL,
    PRIMARY KEY (`id`, `Customer_id`)

)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budzin_db`.`Trip_Order_TripAdvizor_object`
-- -----------------------------------------------------

insert into TripAdvizor_object (id, objec_name, number_of_star, free_room, busy_room, all_inclusive,
                                ultra_all_inclusive)
values ('1', 'Amway', '5', '50', '30', '1', '0'),
       ('2', 'Hotel_Lviv', '4', '50', '30', '1', '0'),
       ('3', '7Dniv', '3', '80', '20', '1', '0'),
       ('4', 'Ramada', '5', '50', '30', '1', '0'),
       ('5', 'Hotel_kyiv', '5', '50', '20', '1', '0'),
       ('6', 'Plaza', '4', '50', '30', '1', '0'),
       ('7', 'Radison', '5', '50', '30', '1', '0'),
       ('8', 'Amway_hotel', '3', '50', '30', '1', '0'),
       ('9', 'Radison', '5', '50', '20', '1', '0'),
       ('10', 'Amway', '5', '50', '30', '1', '0');

 

 
