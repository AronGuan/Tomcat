##应用  
3个模块：连接器模块，启动模块和核心模块  
启动模块(Bootstrap):负责启动应用程序  

连接器模块分以下5个类型  
1. 连接器及其支持类(HttpConnector和HttpProcesor)  
2. 表示HTTP请求的类(HttpRequest)及其支持类  
3. 表示HTTP响应的类(HttpResponse)及其支持类  
4. 外观类(HttpRequestFacade和HttpResponseFacade)  
5. 常量类  

核心模块包含两个类:servletProcessor类和staticResourceProcessor类

Bootstrap类的main()方法实例化HttpConnector类，并调用其start()方法就可以启动应用程序。  

HttpConnector类:实现Runnable接口，会创建一个HttpConnector实例，该实例另起一个线程来运行。  
run()方法：如下三个操作  
1. 等待HTTP请求  
2. 为每个请求创建一个HttpPorcessor实例  
3. 调用HttpProcessor对象的process()方法  

HttpProcessor类的process()方法  
1. 创建一个HttpRequest对象  
2. 创建一个HttpResponse对象  
3. 解析HTTP请求的第1行内容和请求头信息，填充HttpRequest对象  
4. 将HttpRequest对象和HttpResponse对象传递给servletProcessor或
StaticResourceProcessor的process()方法。
servletProcessor类会调用请求的servlet实例的service()方法，
staticResourceProcessor类会将请求的静态资源发送给客户端

获取参数  
ParameterMap:继承HashMap,其中有一个locked的布尔变量，只有当变量locked值为false是，才可以对ParameterMap对象中的名/值对进行添加，更新或者删除操作。  
关键部分的类图
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/3-1.png)    
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/3-2.png) 
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/3-3.png) 