# study-springboot-sharding-jdbc

* [sharding-jdbc 教程](https://www.cnblogs.com/ityml/p/14970508.html)

## sharding-jdbc 实现水平分表

* 1、创建`sharding_sphere`数据库
* 2、在数据库中创建两张表，`orders_1`和`orders_2`
* 3、分片规则：如果订单编号是偶数，添加到`orders_1`，如果是技术添加到`orders_2`
 
