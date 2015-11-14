package pers.aron;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor2 {

	public void process(Request request,Response response){
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		URLClassLoader loader = null;
		try{
			//创建一个类加载器
			//需指明类加载器要到哪里查找类
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File(Constants.WEB_ROOT);
			//类载入器查找servlet类的目录称为仓库
			//生成仓库地址
			String repository = (new URL("file",null,classPath.getCanonicalPath() + File.separator)).toString();
			System.out.println("repository:" + repository);
			//主要是指定目录，至于streamHandler只是避免与另一个构造函数起冲突
			urls[0] = new URL (null,repository,streamHandler);
			loader = new URLClassLoader(urls);
		}catch(Exception e){
			e.printStackTrace();
		}
		Class myClass = null;
		try{
			myClass = loader.loadClass(servletName);
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		RequestFacade requestFacade = new RequestFacade(request);
		ResponseFacade responseFacade = new ResponseFacade(response);
		try{
			servlet = (Servlet)myClass.newInstance();
			servlet.service((ServletRequest)requestFacade, (ServletResponse)responseFacade);
		}catch(Exception e){
			System.out.println(e.toString());
		}catch(Throwable e){
			System.out.println(e.toString());
		}
	}
}
