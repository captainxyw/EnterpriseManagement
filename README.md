# EnterpriseManagement(企业权限管理系统)
## 项目说明
一个简单的权限管理系统练习。基于角色对用户的权限进行控制，分别在页面及Java代码中实现权限的控制。

## 功能模块
### 商品展示
展示数据库中的商品信息 
### 商品添加 
向数据库中添加新的商品，注意事务操作。
### 订单分页查询
订单的查询操作，它主要完成简单的多表查询操作，查询订单时，需要查询出与订单关联的其它表中信息。并且使用mybatis分页插件PageHelper。
### 订单详情查询 
查询某一个订单的信息，对订单、顾客、商品等进行连接查询。
### 用户管理 
用户管理中使用spring Security实现用户登录操作。UserService实现UserDetailsService接口，用户登录同时查询用户所具有角色的所有权限。
用户添加时候对其密码进行加密保存，使用Spring Security中的BCryptPasswordEncoder。
### 角色管理 
角色管理主要完成角色查询、角色添加。
### 资源权限管理 
资源权限管理主要完成查询、添加操作，它的操作与角色管理类似，角色管理以及资源权限管理都是对权限管理的补充。
### AOP日志处理 
AOP日志处理，我们使用spring AOP切面来完成系统级别的日志收集
 
## 项目技术架构
### 后端技术：
* Spring
* Spring MVC
* MyBatis
* Spring Security
* MyBatis PageHelper
### 前端技术：
* AdminLTE
 
 
## 系统主要部分效果图
* 用户列表页面，可以看到系统的用户
![alt 用户列表页面](https://raw.githubusercontent.com/captainxyw/EnterpriseManagement/master/img/user-list.png "用户列表页面")
* 用户角色权限展示界面，可以看到用户所具有的角色以及角色所具有的权限
![alt 用户角色权限展示界面](https://raw.githubusercontent.com/captainxyw/EnterpriseManagement/master/img/user-role-broswer.png "用户角色权限展示界面")
* 用户角色添加界面，可以为用户添加新的角色
![alt 用户角色添加界面](https://raw.githubusercontent.com/captainxyw/EnterpriseManagement/master/img/user-role-add.png "用户角色添加界面")
* 角色列表界面，可以看到系统所有的角色
![alt 角色列表界面](https://raw.githubusercontent.com/captainxyw/EnterpriseManagement/master/img/role-list.png "角色列表界面")
* 角色添加界面，可以添加新的角色
![alt 角色添加界面](https://raw.githubusercontent.com/captainxyw/EnterpriseManagement/master/img/role-add.png "角色添加界面")
* 角色权限添加界面，可以为角色添加新的权限
![alt 角色权限添加界面](https://raw.githubusercontent.com/captainxyw/EnterpriseManagement/master/img/role-perm-add.png "角色权限添加界面")


