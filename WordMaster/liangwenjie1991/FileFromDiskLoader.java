package wordMaster;

import java.io.*;  
import java.util.*;  
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


import javax.swing.JOptionPane;

    
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
		private List allChildren = new LinkedList();
		
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
                        	System.out.println("read_settings():index="+this.index);
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
			int j = 0;
			boolean exist = false;
			String english = null;
			String chinese = null;
			
			if(initialChar != null){
				if(!initialChar.equals("startFromTheFirst")){
				List allChildren = readFile(filePath);
				
				for (i = 0; i < allChildren.size(); i++) {   
				     english = ((Element) allChildren.get(i)).getChild("english").getText();   
				     chinese = ((Element) allChildren.get(i)).getChild("chinese").getText();   
				     
				     if(english.startsWith(initialChar)){
                     	exist = true;
                     	break;
                     }
				   }   
				
				if(exist){
					this.index = i ;
					
				}else{
					JOptionPane.showMessageDialog(null, "输入单词在词库中不存在，将从词库第一个单词开始！");
					Frame.setInput("一");
				}
				}else{
					System.out.println("set_init_char():startfromthefirst");
					List allChildren = readFile(filePath);
					
					for (j = 0; j < allChildren.size(); j++) {   
					     english = ((Element) allChildren.get(j)).getChild("english").getText();   
					     chinese = ((Element) allChildren.get(j)).getChild("chinese").getText();   
					     
					     if(chinese.startsWith(wordBank)){
	                     	this.index = j;
	                     	System.out.println("set_init_char():startfromthefirst:the first:"+this.index);
	                     	break;
	                     }
					   }   
				}
			}
			System.out.println("set_init_char()，this。index："+this.index);
			/*
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
	                    	
	                        if(lineTxt.startsWith(initialChar)){
	                        	exist = true;
	                        	break;
	                        }
	                        i++;
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
				}else{
					JOptionPane.showMessageDialog(null, "输入单词在词库中不存在，将从词库第一个单词开始！");
					Frame.setInput("一");
				}
			}*/
		}
	
        public void set_number(){
        	if(number==0 && old_number==0){
        		number = 1;
        	}else if(number == 0){
        		number = old_number;                
        	}
        	
            //int count[] = count_number();
            //System.out.println("index:"+index);
            //System.out.println("number:"+number);
        	/*if((index+number) > count[wordBank.charAt(0)-'a']){
        		number = count[wordBank.charAt(0)-'a'] - index;
        		JOptionPane.showMessageDialog(null, "词库剩余单词不足");
        	}*/
            
            List allChildren = readFile(filePath);
            String chinese = null;
            int num = 0;
            //System.out.println("set_number(),this.index"+this.index);
            for (int i = this.index; i < allChildren.size(); i++) {
            	chinese = ((Element) allChildren.get(i)).getChild("chinese").getText();  
            	
            	if(chinese.startsWith(wordBank)){
            		num++;
            	}
            }
            System.out.println("set_number():num:"+num);
            if(num < number){
            	number = num;
            	JOptionPane.showMessageDialog(null, "词库剩余单词不足");
            }
        }
	
         public int getNumber() {
			return number;
		}

		public int[] count_number(){
			
			String english = null;
			String chinese = null;
        	int count[] = new int[9];
        	String property[] = {"v","n","adj","adv","prep","int","conj","pron","num"};
       	    for(int i=0;i<9;i++){
       		    count[i] = 0;
       	    }
       	 
       	    List allChildren = readFile(filePath);
       	
       	    for (int i = 0; i < allChildren.size(); i++) {    
		        chinese = ((Element) allChildren.get(i)).getChild("chinese").getText();   
		     
		        for(int j=0;j<9;j++){
		    	    if(chinese.contains(property[j])){
		    		    count[j]++;
		    	    }
		        }
		     
              }
		 
       	 /*try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        count[lineTxt.charAt(0)-'a']++;
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }*/
       	 
       	 for(int i=0;i<8;i++){
       		 count[i+1] = count[i] + count[i+1];
       	 }
       	 
       	 return count;
       	 
        }
		

        
	    public void open_io(){
	    	List allChildren = readFile(filePath);
	    	this.allChildren = allChildren;
	    	/*
	    	int i;
	    	try {
                String encoding="GBK";
                p_file=new File(filePath);
                if(p_file.isFile() && p_file.exists()){ //判断文件是否存在
                    p_read = new InputStreamReader(new FileInputStream(p_file),encoding);//考虑到编码格式
                    p_bufferedReader = new BufferedReader(p_read);
                    //String lineTxt = null;
                    for(i=0;i<index;i++){
                    	p_bufferedReader.readLine();
                    }
                    
        }else{
            System.out.println("找不到字典的文件");
        }
        } catch (Exception e) {
            System.out.println("读取字典文件内容出错");
            e.printStackTrace();
        }*/
	    }
	
	    public String next(){
	    	String lineTxt = null;
	    	String english = null;
			String chinese = null;
			
	    	if(count < number){
	    	if(index < allChildren.size()){
	    		//System.out.println("next()，this。index："+this.index);
				english = ((Element) allChildren.get(index)).getChild("english").getText();   
			    chinese = ((Element) allChildren.get(index)).getChild("chinese").getText();   
			    lineTxt = english + "   " + chinese;
			    //System.out.println("next()，line："+lineTxt);
			    index++;
			    if(chinese.startsWith(wordBank)){
			    	count++;
			    	return lineTxt;
			    }else{
			    	return next();
			    }
			    	
			    
			    
	    	}else{
	    		System.out.println("该词库已背诵完成");
	    	}
	    	}else{
	    		System.out.println("已背完规定的单词");
	    		return "完";
	    	}
	    	
	    	return null;
	    	/*
	    	String lineTxt = null;
	    	if(count < number){
	    	try {
				if((lineTxt = p_bufferedReader.readLine()) != null){
					count++;
					index++;
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
	    		return "完";
	    	}
	    	
	    	return null;
	    	*/
	    }
	
	    public String word(String item){
	    	return item.substring(0,item.indexOf(' '));
	    }
	    
	    public String meaning(String item){
	    	return item.substring((item.lastIndexOf(' ')+1));
	    }

		public int getIndex() {
			return index;
		}
	    
	    public int getWordBankNum(String wordBank){
	    	int num = 0;
	    	
	    	List allChildren = readFile(filePath);
	    	String english = null;
			String chinese = null;
			
			for (int i = 0; i < allChildren.size(); i++) {    
			     chinese = ((Element) allChildren.get(i)).getChild("chinese").getText();   
			     
			     if(chinese.startsWith(wordBank)){
                	num++;
                }
			   }   
	    	/*try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        if(lineTxt.startsWith(wordBank)){
                        	num++;
                        }
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }*/
	    	
	    	return num;
	    }
	    
	    public int getAllNum(){
	    	int num=0;
	    	
	    	List allChildren = readFile(filePath);
	    	num = allChildren.size();
	    	/*
	    	try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        	num++;
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }*/
	    	
	    	return num;
	    }
	    
	    public int getAllRight(){
	    	int num = 0;
	    	
	    	try {
                String encoding="GBK";
                File file=new File(settingsPath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        	if(lineTxt.contains("right")){
                        		num = num + Integer.parseInt(lineTxt.substring(lineTxt.indexOf('=')+1));
                        	}
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
	    	
	    	return num;
	    }
	    
	    public int getAllWrong(){
	    	int num = 0;
	    	
	    	try {
                String encoding="GBK";
                File file=new File(settingsPath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        	if(lineTxt.contains("false")){
                        		num = num + Integer.parseInt(lineTxt.substring(lineTxt.indexOf('=')+1));
                        	}
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
	    	
	    	return num;
	    }
	    
	    public int getAllRemembered(){
	    	return getAllWrong()+getAllRight();
	    }
	    
	    public static List readFile(String filePath){
			List allChildren = null;
			
	    	try {   
	    		   SAXBuilder builder = new SAXBuilder();   
	    		   Document doc = builder.build(new File(filePath));   
	    		   Element foo = doc.getRootElement();   
	    		   allChildren = foo.getChildren("word");   
	    		  
	    		  } catch (Exception e) {   
	    			  System.out.println("读取字典文件内容出错");
	    		   e.printStackTrace();   
	    		  }   
	    		  
	    
	        return allChildren; 
	    }
	    
	    
	    
	    
	    

	}

