##Ӧ��  
3��ģ�飺������ģ�飬����ģ��ͺ���ģ��  
����ģ��(Bootstrap):��������Ӧ�ó���  

������ģ�������5������  
1. ����������֧����(HttpConnector��HttpProcesor)  
2. ��ʾHTTP�������(HttpRequest)����֧����  
3. ��ʾHTTP��Ӧ����(HttpResponse)����֧����  
4. �����(HttpRequestFacade��HttpResponseFacade)  
5. ������  

����ģ�����������:servletProcessor���staticResourceProcessor��

Bootstrap���main()����ʵ����HttpConnector�࣬��������start()�����Ϳ�������Ӧ�ó���  

HttpConnector��:ʵ��Runnable�ӿڣ��ᴴ��һ��HttpConnectorʵ������ʵ������һ���߳������С�  
run()������������������  
1. �ȴ�HTTP����  
2. Ϊÿ�����󴴽�һ��HttpPorcessorʵ��  
3. ����HttpProcessor�����process()����  

HttpProcessor���process()����  
1. ����һ��HttpRequest����  
2. ����һ��HttpResponse����  
3. ����HTTP����ĵ�1�����ݺ�����ͷ��Ϣ�����HttpRequest����  
4. ��HttpRequest�����HttpResponse���󴫵ݸ�servletProcessor��
StaticResourceProcessor��process()������
servletProcessor�����������servletʵ����service()������
staticResourceProcessor��Ὣ����ľ�̬��Դ���͸��ͻ���

��ȡ����  
ParameterMap:�̳�HashMap,������һ��locked�Ĳ���������ֻ�е�����lockedֵΪfalse�ǣ��ſ��Զ�ParameterMap�����е���/ֵ�Խ�����ӣ����»���ɾ��������  
�ؼ����ֵ���ͼ
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/3-1.png)    
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/3-2.png) 
![alt](https://github.com/AronGuan/Tomcat/blob/master/images/3-3.png) 