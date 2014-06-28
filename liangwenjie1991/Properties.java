package wordMaster;

import java.io.*;
import java.io.*;  
import java.util.*;  
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


//import java.util.*;


public class Properties {

	private String wordBank;
	private int index = 0;
	private int number = 0;
	private int right;
	private int wrong;
	private String settingsPath = null;
	
	Properties(String wordBank,String settingsPath){
		this.wordBank = wordBank;
		this.settingsPath = settingsPath;
		read_settings(wordBank);
	}
	
	public void build(int index,int number,int right,int wrong){
		
		this.index = index;
		this.number = number;
		this.right = right;
		this.wrong = wrong;
		
        File sourceFile = new File(settingsPath);
		
		File targetFile = new File("temp.txt");
		if(targetFile.exists()){
			System.out.println("target file temp.txt already exists");
		}
		
		try {
			PrintWriter output = new PrintWriter(targetFile);
            String encoding="GBK";
            if(sourceFile.isFile() && sourceFile.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(sourceFile),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("index")){
                    	lineTxt = wordBank + "_index=" + String.valueOf(index);
                    }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("number")){
                    	lineTxt = wordBank + "_number=" + String.valueOf(number);
                    }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("right")){
                    	lineTxt = wordBank + "_right=" + String.valueOf(right);
                    }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("false")){
                    	lineTxt = wordBank + "_false=" + String.valueOf(wrong);
                    }
                    output.println(lineTxt);
                }
                read.close();
                output.close();
    }else{
        System.out.println("找不到指定的文件");
    }
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
    }
		
		sourceFile.delete();
		targetFile.renameTo(new File(settingsPath));
	
		
	}

    private void read_settings(String wordBank){
    	try {
            String encoding="GBK";
            File file=new File(settingsPath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	 if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("index")){
                     	this.index = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
                     }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("number")){
                    	 this.number = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
                     }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("right")){
                    	 this.right = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
                     }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("false")){
                    	 this.wrong = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
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
    }

	public String getWordBank() {
		return wordBank;
	}

	public int getIndex() {
		return index;
	}

	public int getNumber() {
		return number;
	}

	public int getRight() {
		return right;
	}

	public int getWrong() {
		return wrong;
	}

	public String getSettingsPath() {
		return settingsPath;
	}
}
