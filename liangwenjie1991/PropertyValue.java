package wordMaster;

import java.io.*;
import java.util.Scanner;

public class PropertyValue {

     
	private String filePath = null;
	private String recordPath = null;
	
	PropertyValue(){
		
	}
	
	PropertyValue(String filePath,String recordPath){
		this.filePath = filePath;
		this.recordPath = recordPath;
		setup();
	}
	
	private void setup(){
		File record = new File(recordPath);
		if(!record.exists()){
			try {
				PrintWriter output = new PrintWriter(record);
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	output.println(lineTxt+"=0");       //0 means the word has never been studyed
                    }                                       //1 means the word has been right once
                    read.close();                           //2 means the word has never been right
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
		}
	}

	//0 means the word has never been studyed
	//1 means the word has been right once
	//2 means the word has never been right
    public int getStatus(String word){
    	int status = 0;
    	try {
            String encoding="GBK";
            File file=new File(recordPath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	if(lineTxt.startsWith(word+" ")){
                    	status = Integer.parseInt(lineTxt.substring(lineTxt.indexOf('=')+1));
                    	break;
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
    	return status;
    }

    public void setStatus(int status[],String word[]){
    	int i;
    	
        File sourceFile = new File(recordPath);
		
		File targetFile = new File("temp_record.txt");
		if(targetFile.exists()){
			System.out.println("target file temp_record.txt already exists");
		}
		
		try {
			PrintWriter output = new PrintWriter(targetFile);
            
            if(sourceFile.isFile() && sourceFile.exists()){ //判断文件是否存在
                Scanner input = new Scanner(sourceFile);
                String lineTxt = null;
                while(input.hasNext()){
                	lineTxt = input.nextLine();
                	for(i = 0 ; i < word.length ; i++){
                		if(lineTxt.startsWith(word[i]+" ")){
                			lineTxt = lineTxt.substring(0,lineTxt.indexOf('=')+1) + String.valueOf(status[i]);
                		}
                	}
                    output.println(lineTxt);
                }
                input.close();
                output.close();
    }else{
        System.out.println("找不到指定的文件");
    }
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
    }
		
		sourceFile.delete();
		targetFile.renameTo(new File(recordPath));
    	
    	
    }
}
