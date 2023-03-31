CREATE TABLE `user` (
                        `id` int NOT NULL COMMENT 'id',
                        `phone` varchar(20) DEFAULT NULL COMMENT '手机',
                        `name` varchar(50) DEFAULT NULL COMMENT '姓名',
                        `birthday` datetime DEFAULT NULL COMMENT '出生日期',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;