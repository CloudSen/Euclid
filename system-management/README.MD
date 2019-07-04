# 说明

## 必要的前置步骤
- 安装PostgreSQL本地测试数据库；
- 配置用户名和密码：
  - 用户名： postgres
  - 密码：postgres
- 运行 `sql/` 目录里的DDL，创建数据库和测试表；
- IDEA连接Database；
- 进入IDEA项目设置 `Project Structure` -> `Modules` -> 选择 `system-management` 模块 -> 添加 `JPA` 框架配置 -> 选择 `default JPA provider` 为 `hibernate`；
- 添加之后，发现IDEA界面多了 `Persistence` 侧栏，可以用它查看当前项目所有Entity，它也可以自动生成Entity。

## 所有Controller统一返回

所有路由统一返回 `Result<T>` 对象，严格控制返回字段的统一。  
可以使用 `ResultUtil` 优雅获取Result对象。

## 异常的处理

项目使用 `ControllerAdvice` 来做全局统一异常处理，一般不允许随便使用 `try...catch` 捕获异常。  
因为95%的异常，在运行时是无法修复的，请直接抛出自定义的运行时异常。  

## 数据库访问
### 数据源

- 数据源用druid配置了3个环境，分别是：
  - dev: 开发环境数据库；
  - test: 测试环境数据库；
  - prod: 线上环境数据库；
  
> 待优化：  
> 1. 配置文件中的密码不应该用明文； 
> 2. 线上环境的数据库最好不要版本控制；

### 访问数据库

本项目使用的 `Spring Data JPA` 作为数据库访问框架。  
`controller->service->repository` 的整个流程可以参考以下类：  
- TestJpaController
- TestJpaService
- TestJpaRepository
- TestJpaDto
- TestJpaEntity