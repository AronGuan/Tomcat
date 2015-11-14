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
			//����һ���������
			//��ָ���������Ҫ�����������
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File(Constants.WEB_ROOT);
			//������������servlet���Ŀ¼��Ϊ�ֿ�
			//���ɲֿ��ַ
			String repository = (new URL("file",null,classPath.getCanonicalPath() + File.separator)).toString();
			System.out.println("repository:" + repository);
			//��Ҫ��ָ��Ŀ¼������streamHandlerֻ�Ǳ�������һ�����캯�����ͻ
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
