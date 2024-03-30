create database ticket_system;

CREATE TABLE `t_order` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int DEFAULT NULL,
                           `show_id` int DEFAULT NULL,
                           `buy_num` int DEFAULT NULL,
                           `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                           `state` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `t_show` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) DEFAULT NULL,
                          `content` varchar(255) DEFAULT NULL,
                          `ticket_num` int DEFAULT NULL,
                          `show_time` varchar(255) DEFAULT NULL,
                          `price` decimal(10,2) DEFAULT NULL,
                          `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                          `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `t_user` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `account` varchar(255) DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `phone_num` varchar(255) DEFAULT NULL,
                          `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                          `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `account_unique` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ticket_system`.`t_user` (`id`, `account`, `name`, `password`, `phone_num`, `create_time`, `update_time`) VALUES (1, 'admin', '管理员', '123456', NULL, '2023-11-09 11:58:54', '2023-11-09 11:58:54');
INSERT INTO `ticket_system`.`t_user` (`id`, `account`, `name`, `password`, `phone_num`, `create_time`, `update_time`) VALUES (2, 'user1', '用户1', '123456', NULL, '2023-11-09 11:59:49', '2023-11-09 11:59:49');
INSERT INTO `ticket_system`.`t_show` (`id`, `name`, `content`, `ticket_num`, `show_time`, `price`, `create_time`, `update_time`) VALUES (1, '三星堆演出', '三星堆演出', 997, '2023-11-09', 0.00, '2023-11-09 11:51:41', '2023-11-09 11:51:41');
INSERT INTO `ticket_system`.`t_show` (`id`, `name`, `content`, `ticket_num`, `show_time`, `price`, `create_time`, `update_time`) VALUES (2, '历史演出', '历史演出', 999, '2023-11-09', 0.00, '2023-11-09 11:52:16', '2023-11-09 11:52:16');