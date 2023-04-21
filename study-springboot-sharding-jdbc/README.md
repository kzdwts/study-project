# study-springboot-sharding-jdbc

* [sharding-jdbc 教程](https://www.cnblogs.com/ityml/p/14970508.html)

## sharding-jdbc 实现水平分表(`application-local1.yml`)

* 1、创建`sharding_sphere`数据库
* 2、在数据库中创建两张表，`orders_1`和`orders_2`
* 3、分片规则：如果订单编号是偶数，添加到`orders_1`，如果是技术添加到`orders_2`
 

## sharding-jdbc 实现水平分库(`application-local2.yml`)

* 1、在不同的数据节点node01,node02上创建不同名称的数据库：`sharding_sphere_1,sharding_sphere_2`
* 2、在两个数据库上创建相同的表`orders_1,orders_2`
* 3、分片规则，按照customer_id的奇偶性来进行分库，然后按照id的奇偶性进行分表
