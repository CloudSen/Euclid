# Euclid

#### 介绍
基于微服务前后端分离架构的大数据可视化平台。  

#### 目录结构

待完善...  

#### 涉及技术
软件架构说明
- root project
  - spring boot 2.1.5 GA
  - spring boot devtools
  - lombok
  - spring configuration processor
  - spring boot actuator
  - spring boot admin(server)
  - spring-boot-starter-test
  - alibaba fastjson
  - spring-boot-starter-thymeleaf
- registration center
  - spring-cloud-starter-netflix-eureka-server
- system-management
  - postgresql
  - spring-boot-starter-web
  - spring-cloud-starter-netflix-eureka-client
  - spring-boot-starter-data-jpa
  - druid-spring-boot-starter

#### 安装教程

1. 安装PostgreSQL数据库；
2. IDEA中安装必要插件：  
  a. Lombok插件；  
  b. 阿里巴巴JAVA编码规约插件；
3. xxxx

#### 使用说明

待完善...  

#### 代码规范说明
- 使用lombok减少get，set，logger这样的模板代码；
- 使用IDEA自带的格式化美化代码；
- 严格按照阿里巴巴JAVA编码规约开发；
- 严格执行Git提交规范，提交说明细分到功能点；

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request