import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

    
	public class FileFromDiskLoader{
		
		private String wordBank = null;
		private String filePath = null;
		private String settingsPath = null;
		private String initialChar = null;
		private int index = 0;
		private int number = 0;
		private int old_number;
		private int count = 0;
		private File p_file;
		private InputStreamReader p_read;
		private BufferedReader p_bufferedReader;
		
		FileFromDiskLoader(){
			
		}
		
		FileFromDiskLoader(String filePath,String settingsPath,String wordBank,String initialChar,int number){
			this.filePath = filePath;
			this.settingsPath = settingsPath;
			this.wordBank = wordBank;
			this.initialChar = initialChar;
			this.number = number;
			setup();
		}
		
		//before any execution,the setup() should be ran
		public void setup(){
			read_settings();
			set_init_char();
			set_number();
			open_io();
		}
		
		public void read_settings(){
			try {
                String encoding="GBK";
                File file=new File(settingsPath);
                int begin;
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    
                    while((lineTxt = bufferedReader.readLine()) != null){
                        if(lineTxt.contains("index") && lineTxt.startsWith(wordBank)){
                        	begin = lineTxt.indexOf('=')+1;
                        	this.index = Integer.parseInt(lineTxt.substring(begin));
                        }else if(lineTxt.contains("number") && lineTxt.startsWith(wordBank)){
                        	begin = lineTxt.indexOf('=')+1;
                        	this.old_number = Integer.parseInt(lineTxt.substring(begin));
                        }
                    }
                    read.close();
        }else{
            System.out.println("找不到设置文件");
        }
        } catch (Exception e) {
            System.out.println("读取设置文件内容出错");
            e.printStackTrace();
        }
		}
		
		public void set_init_char(){
			int i = 0;
			boolean exist = false;
			if(initialChar != null){
				try {
	                String encoding="GBK";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt = null;
	                    while((lineTxt = bufferedReader.readLine()) != null){	
	                    	i++;
	                        if(lineTxt.startsWith(initialChar)){
	                        	exist = true;
	                        	break;
	                        }
	                    }
	                    read.close();
	        }else{
	            System.out.println("找不到字典文件");
	        }
	        } catch (Exception e) {
	            System.out.println("读取字典文件内容出错");
	            e.printStackTrace();
	        }
				
				if(exist){
					this.index = i ;
				}
			}
		}
	
        public void set_number(){
        	if(number==0 && old_number==0){
        		number = 30;
        	}else if(number == 0){
        		number = old_number;
        	}
        }
	
	    public void open_io(){
	    	int i;
	    	try {
                String encoding="GBK";
                p_file=new File(filePath);
                if(p_file.isFile() && p_file.exists()){ //判断文件是否存在
                    p_read = new InputStreamReader(new FileInputStream(p_file),encoding);//考虑到编码格式
                    p_bufferedReader = new BufferedReader(p_read);
                    String lineTxt = null;
                    for(i=0;i<index;i++){
                    	p_bufferedReader.readLine();
                    }
                    
        }else{
            System.out.println("找不到字典的文件");
        }
        } catch (Exception e) {
            System.out.println("读取字典文件内容出错");
            e.printStackTrace();
        }
	    }
	
	    public String next(){
	    	String lineTxt = null;
	    	if(count < number){
	    	try {
				if((lineTxt = p_bufferedReader.readLine()) != null){
					count++;
					return lineTxt;
				}else{
					p_read.close();
					System.out.println("该词库已背诵完成");
				}
			} catch (IOException e) {
				System.out.println("读取单词出错");
				e.printStackTrace();
			}
	    	}else{
	    		System.out.println("已背完规定的单词");
	    	}
	    	
	    	return null;
	    }
	
	    public String word(String item){
	    	return item.substring(0,item.indexOf(' '));
	    }
	    
	    public String meaning(String item){
	    	return item.substring((item.lastIndexOf(' ')+1));
	    }
	}

