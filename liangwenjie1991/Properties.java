package wordMaster;

import java.io.*;

public class Properties {

	private String wordBank = null;
	private int index = 0;
	private int number = 0;
	private int right;
	private int wrong;
	private String settingsPath = null;
	
	Properties(String wordBank,int index,int number,int right,int wrong,String settingsPath){
		this.wordBank = wordBank;
		this.index = index;
		this.number = number;
		this.right = right;
		this.wrong = wrong;
		this.settingsPath = settingsPath;
	}
	
	public void build(){
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
                    if(lineTxt.startsWith(wordBank) && lineTxt.contains("index")){
                    	lineTxt = wordBank + "_index=" + String.valueOf(index);
                    }else if(lineTxt.startsWith(wordBank) && lineTxt.contains("number")){
                    	lineTxt = wordBank + "_number=" + String.valueOf(number);
                    }else if(lineTxt.startsWith(wordBank) && lineTxt.contains("right")){
                    	lineTxt = wordBank + "_right=" + String.valueOf(right);
                    }else if(lineTxt.startsWith(wordBank) && lineTxt.contains("wrong")){
                    	lineTxt = wordBank + "_wrong=" + String.valueOf(wrong);
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
}
