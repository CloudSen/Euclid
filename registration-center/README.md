# 高可用Eureka注册中心
## 本地开发环境测试单个Eureka：
需要关闭客户端行为，将以下属性设置为false，避免当前的Eureka自己注册为一个client：  
```yaml
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```
## 本地开发环境测试Eureka集群
> 简单来说就是当前Eureka Server启动时要分别注册到其他Eureka Server
### 双节点
- 设置电脑的hosts，将Eureka的hostName加进去：  
```text
127.0.0.1 localhost1
127.0.0.1 localhost2
```  
- 为Eureka项目添加不同的配置文件，设置***不同的hostname和port***：  
peer1：  
```yaml
server:
  port: 8777
# 启动两个eureka，互相注册，实现高可用注册中心
eureka:
  instance:
    hostname: localhost1
  client:
    serviceUrl:
      defaultZone: http://localhost2:8666/eureka/
```
peer2:
```yaml
server:
  port: 8666
# 启动两个eureka，互相注册，实现高可用注册中心
eureka:
  instance:
    hostname: localhost2
  client:
    serviceUrl:
      defaultZone: http://localhost1:8777/eureka/
```
- 将项目用maven打成一个jar包，然后用终端分别启动两个Eureka实例：  
```text
java -jar .\registration-center-0.0.1-SNAPSHOT.jar
java -jar .\registration-center-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev2
```

### 多节点
和双节点同理，当前Eureka Server启动时要分别注册到其他Eureka Server即可。  
通过 `spring.profiles.active` 来激活不同的配置文件。
