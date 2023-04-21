CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型：',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标识：  0-正常；  1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='订单表';

CREATE TABLE `dict_order_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型：',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标识：  0-正常；  1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='订单类型表';
