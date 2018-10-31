# spring cloud 分享笔记

#### 导读：分布式和微服务
- 分布式：
> 分布式是若干独立计算机的集合。简单点说就是把每个模块单独部署到一台服务器上，然后通过服务器集群来达到高负载，高可用的稳定系统。
- 微服务：
> 把系统拆分成若干个可单独部署，单独运行的子系统或模块。不需要分别部署到不同的服务器上。甚至每个模块可以用不同的编程语言，不同的数据库，各个服务之间互不干扰。
- 分布式代表框架dubbo：高性能java rpc框架
> Apache Dubbo (incubating) |ˈdʌbəʊ| 是一款高性能、轻量级的开源Java RPC框架，它提供了三大核心能力：面向接口的远程方法调用，智能容错和负载均衡，以及服务自动注册和发现。  
- 微服务代表框架spring cloud：基于SpringBoot的一整套微服务框架的实现
> spring cloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等。

### 项目环境
- spring boot 版本：2.0.6  
- spring cloud 版本：Finchley  

### 所包含的工程
- spring-cloud-share-parent: 项目的父工程，其他工程都继承此工程  

- eureka-server: 服务的注册中心  
端口号：8081  

- service-hello: 服务的提供者  
端口号：8082、8083、8084 多个实例模拟集群效果  
说明：spring.application.name 需要指明，以后的服务与服务之间的相互调用，都是靠name来指定

- service-ribbon：服务的消费者  
端口号：8091

- service-feign：服务的消费者  
端口号：8092  

- service-zuul：路由和过滤  
端口号：8093  

#### 第一小节：服务的注册与发现
> Eureka是Netflix开发的服务发现框架，本身基于rest服务，SpringCloud将它集成在其子项目spring-cloud-netflix中，以实现SpringCloud的服务发现功能。  

Eureka Server：提供服务注册，所有注册的服务都可以在管理页面看到。  
Eureka Client：客户端，用来和服务器交互
#### 第二小节：服务的调用与负载均衡
Ribbon是一个负载均衡客户端，Feign默认就集成了Ribbon  
Feign是一个声明式的伪Http客户端，默认实现了负载均衡，整合了Hystrix，具有服务熔断的能力  

#### 第三小节：断路器
简介：如果服务出现问题，调用这个服务就会出现线程阻塞，如果现在有大量的请求，就会消耗完资源，服务器就会瘫痪。  
断路器就是在此时发生作用，可以给出发生错误时的解决办法。  
![断路器](https://upload-images.jianshu.io/upload_images/2279594-8dcb1f208d62046f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)  
(图片来自于方志朋的博客，最下面有链接)

#### 第四小节：路由转发和过滤
zuul的主要功能就是路由和过滤，一般都是通过客户端负载均衡到zuul，然后再路由到服务器集群。zuul默认和Ribbon结合实现了负载均衡的功能。

### 最终的架构
![架构](http://132.232.103.155:9876/img/架构.png)

#### 第五小节：学习资料参考
- 博客大牛  
方志朋：[SpringCloud教程终篇：文章汇总](https://www.fangzhipeng.com/springcloud/2018/08/30/sc-f-all/)  
于起宇：[目录：SpringCloud核心技术学习目录](https://www.jianshu.com/p/64e4aaada96b)  
翟永超：[Spring Cloud基础教程](http://blog.didispace.com/Spring-Cloud%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/)  
许进：[许进沉思录](https://xujin.org/)   

- 文档参考  
[SpringCloud官方文档](http://cloud.spring.io/spring-cloud-static/Finchley.SR1/single/spring-cloud.html)  
[Springcloud中文文档翻译](https://springcloud.cc/spring-cloud-dalston.html)