##Ӧ��1  
�����¼�����  
HttpServlet1
1. �ȴ�HTTP����  
2. ����һ��servletRequest�����һ��servletResponse����  
3. ���������һ����̬��Դ�������StaticResourceProcessor�����process()����������servletRequest�����servletResponse����  
4. ���������servelt����������Ӧ��servlet�࣬������service()����������servletRequest�����servletResponse����  
����6����  
HttpServer  
Request  
Response  
StaticResourceProcessor  
ServletProcessor1  
Constants  
��ͼ  
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/HttpServer1.png)  


##Ӧ��2  
HttpServlet2
����Ӧ����һ��ȱ��  
```
		try{
			servlet = (Servlet)myClass.newInstance();
			servlet.service((ServletRequest)request, (ServletResponse)response);
		}
```
���ǲ���ȫ�ģ���Ϊ�ͻ��˳���Ա��������ת��Ȼ�����request��response�Ĺ���������  
�����ʽʹ��RequestFacade��ResponseFacade����ࡣ

ͨ����������࣬���ط����Ĺ�����������Ϊ��Щ��������ϵͳ������������Ҫ���ã������ܱ��ͻ��˵��á�  
��ͼ  
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/HttpServer2.png)  