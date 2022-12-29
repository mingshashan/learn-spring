-- test.T_CUSTOMER definition

CREATE TABLE `T_CUSTOMER` (
                              `id` varchar(100) NOT NULL,
                              `name` varchar(100) DEFAULT NULL,
                              `phone` varchar(32) DEFAULT NULL,
                              PRIMARY KEY(id)
);

CREATE TABLE `T_ADDRESS` (
                             `id` varchar(100) NOT NULL,
                             `street` varchar(100) DEFAULT NULL,
                             `city` varchar(100) DEFAULT NULL,
                             `country` varchar(100) DEFAULT NULL,
                             `customer_id` varchar(100) DEFAULT NULL,
                             PRIMARY KEY(id)
);

CREATE TABLE `T_ORDER` (
                           `id` varchar(100) NOT NULL,
                           `customer_id` varchar(100) NOT NULL,
                           `address_id` varchar(100) NOT NULL,
                           `create_time` TIMESTAMP DEFAULT NULL,
                           PRIMARY KEY(id)
);

CREATE TABLE `T_ORDER_ITEM` (
                                `id` varchar(100) NOT NULL,
                                `product_id` varchar(100) DEFAULT NULL,
                                `amount` BIGINT(10) DEFAULT NULL,
                                `order_id` varchar(100) DEFAULT NULL,
                                PRIMARY KEY(id)
);

CREATE TABLE `T_PRODUCT` (
                             `id` varchar(100) NOT NULL,
                             `name` varchar(100) DEFAULT NULL,
                             `price` DECIMAL(20,2) DEFAULT NULL,
                             `description` varchar(255) DEFAULT NULL,
                             PRIMARY KEY(id)
);