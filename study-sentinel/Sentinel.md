# Sentinel


## Sentinel 规则持久化

### 1.1、原始模式

### 1.2、拉模式

pull 模式的数据源（如本地文件、RDBMS等）一般是可以写入的。使用时需要在客户端注册数据源：将对应的读数据源注册至对应的RuleManager，将写数据源注册至 transport 的 `WritableDataSourceRegistry`中

### 1.3、推模式

生产环境下一般更常用的是push模式的数据源。对于push模式的数据源，如远程配置中心（Zookeeper，Nacos，Apollo等等），推送的操作不应由 `Sentinel` 客户端进行，而应该经控制台统一进行管理，直接进行推送，数据源仅负责获取配置中心推送的配置并更新到本地。

因此推送规则正确做法应该是 **配置中心控制台/Sentinel控制台 → 配置中心 → Sentinel数据源 → Sentinel** ，而不是经 `Sentinel` 数据源推送至配置中心。
这样流程就非常清晰了

#### 1.3.1、基于Nacos配置中心控制台实现推送

官方demo：`sentinel-demo-nacos-datasource`

引入依赖
```xml

```
