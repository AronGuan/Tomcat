##应用1  
做以下几件事  
HttpServlet1
1. 等待HTTP请求  
2. 创建一个servletRequest对象和一个servletResponse对象  
3. 若请求的是一个静态资源，则调用StaticResourceProcessor对象的process()方法，传入servletRequest对象和servletResponse对象  
4. 若请求的是servelt，则载入相应的servlet类，调用其service()方法，传入servletRequest对象和servletResponse对象  
包含6个类  
HttpServer  
Request  
Response  
StaticResourceProcessor  
ServletProcessor1  
Constants  
类图  
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/HttpServer1.png)  


##应用2  
HttpServlet2
上述应用有一个缺陷  
```
		try{
			servlet = (Servlet)myClass.newInstance();
			servlet.service((ServletRequest)request, (ServletResponse)response);
		}
```
这是不安全的，因为客户端程序员可以向下转换然后调用request和response的公共方法。  
解决方式使用RequestFacade和ResponseFacade外观类。

通过增加外观类，隐藏方法的公共方法，因为这些公共方法系统端里其他类需要调用，但不能被客户端调用。  
类图  
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/HttpServer2.png)  