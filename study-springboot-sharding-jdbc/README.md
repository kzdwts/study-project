# study-springboot-sharding-jdbc

* [sharding-jdbc 教程](https://www.cnblogs.com/ityml/p/14970508.html)


## 一、sharding-jdbc 实现水平分表(`application-local1.yml`)

* 1、创建`sharding_sphere`数据库
* 2、在数据库中创建两张表，`orders_1`和`orders_2`
* 3、分片规则：如果订单编号是偶数，添加到`orders_1`，如果是技术添加到`orders_2`
 

## 二、sharding-jdbc 实现水平分库(`application-local2.yml`)

* 1、在不同的数据节点node01,node02上创建不同名称的数据库：`sharding_sphere_1,sharding_sphere_2`
* 2、在两个数据库上创建相同的表`orders_1,orders_2`
* 3、分片规则，按照customer_id的奇偶性来进行分库，然后按照id的奇偶性进行分表


## 三、sharding-jdbc 实现垂直分库(`application-local3.yml`)

* 1、在不同的数据节点`node01、node02`创建相同的库`sharding_sphere`
* 2、在node01上创建`orders`表，在`node02`上创建`customer`表
* 3、分片规则：将不同的表插入到不同的库中


## 四、sharding-jdbc 公共表(`application-local4.yml`)

* 1、在不同的节点上库上创建相同的表
* 2、分片规则：公共表标识所有的库都具备相同的表


## 五、sharding-jdbc 实现读写分离(`application-local5.yml`)

* 1、规定ds1为写库，ds2为读库
