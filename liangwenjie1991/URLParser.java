package wordMaster;

public class URLParser {

	/*public static void main(String args[]){
		System.out.println(getSuffix("http://blog.sina.com.cn/s/blog_8a7200cd01014ukt.html"));
	}*/
	
	//return the path 
	public static String getProtocol(String url){
		return url;
	}
	
	public static String getPath(String url){
		return url;
	}
	
	//return the file name
	public static String getFileName(String url){
		String filename = null;
		int begin,end;
		
		begin = url.lastIndexOf("/")+1;
		end = url.lastIndexOf('.');
		filename = url.substring(begin,end);
		
		return filename;
	}
	
	public static String getSuffix(String url){
		
		String suffix = null;
		int begin,end;
		
		begin = url.lastIndexOf('.')+1;
		
		if(url.indexOf('?')>=0){
			end = url.lastIndexOf('?');	
			suffix = url.substring(begin, end);
		}else{
			suffix = url.substring(begin);
		}
		
		return suffix;
	}
}
