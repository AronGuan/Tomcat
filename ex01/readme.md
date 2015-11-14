#应用  
包含三个类:HttpServer Request Response  
main()方法创建一个HttpServer实例，然后调用其await()方法，其方法会在指定的端口上等待HTTP请求，对其进行处理，然后发送响应消息回客户端，在接收到关闭命令前，它会保持等待状态。  