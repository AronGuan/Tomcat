package pers.aron;

//处理静态资源
public class StaticResourceProcessor {

	public void process(Request request,Response response){
		try{
			response.sendStaticResource();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
