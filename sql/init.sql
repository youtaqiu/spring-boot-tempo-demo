use tempo;

CREATE TABLE IF NOT EXISTS `t_order` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(35) NOT NULL,
    `order_no` VARCHAR(35) NOT NULL,
    `order_state` smallint (3) default 0 NOT NULL,
    `create_time` DATETIME NULL,
    `update_time` DATETIME NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `order_no_UNIQUE` (`order_no`) USING BTREE);

CREATE TABLE IF NOT EXISTS `t_user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(35) NOT NULL,
    `user_name` VARCHAR(20) NOT NULL,
    `email` VARCHAR(20) NULL,
    `phone` VARCHAR(11) NULL,
    `age` smallint (3) default 12,
    `create_time` DATETIME NULL,
    `update_time` DATETIME NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `user_id_UNIQUE` (`user_id`) USING BTREE);
