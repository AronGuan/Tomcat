package pers.aron;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public static final String WEB_ROOT = 
			System.getProperty("user.dir") + File.separator + "webroot";
	
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

	private boolean shutdown = false;
	
	public static void main(String[] args){
		HttpServer server = new HttpServer();
		server.await();
	}
	
	public void await(){
		ServerSocket serverSocket = null;
		int port = 8080;
		try{
			//1 表示请求的队列长度，超出客户端就会报错
			serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		while(!shutdown){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
			try{
				socket = serverSocket.accept();
				//获取输入流和输出流
				input = socket.getInputStream();
				output = socket.getOutputStream();
				//传入输入流
				Request request = new Request(input);
				//解析原始数据
				request.parse();
				//传入输出流和request对象
				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();
				
				socket.close();
				//测试请求HTTP请求的URI是否是关闭命令
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
}
