package wordMaster;

import java.io.*;

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
		File record = new File(recordPath + "\\record.txt");
		if(!record.exists()){
			try {
				PrintWriter output = new PrintWriter(record);
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//���ǵ������ʽ
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	output.println(lineTxt+"=0");       //0 means the word has never been studyed
                    }                                       //1 means the word has been right once
                    read.close();                           //2 means the word has never been right
        }else{
            System.out.println("�Ҳ���ָ�����ļ�");
        }
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���");
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
            File file=new File(recordPath + "\\record.txt");
            if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//���ǵ������ʽ
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
        System.out.println("�Ҳ���ָ�����ļ�");
    }
    } catch (Exception e) {
        System.out.println("��ȡ�ļ����ݳ���");
        e.printStackTrace();
    }
    	return status;
    }

    public boolean setStatus(int status[],String word[]){
    	boolean set = true;
    	int i;
    	
        File sourceFile = new File(recordPath + "\\record.txt");
		
		File targetFile = new File("temp_record.txt");
		if(targetFile.exists()){
			System.out.println("target file temp_record.txt already exists");
		}
		
		try {
			PrintWriter output = new PrintWriter(targetFile);
            String encoding="GBK";
            if(sourceFile.isFile() && sourceFile.exists()){ //�ж��ļ��Ƿ����
                InputStreamReader read = new InputStreamReader(new FileInputStream(sourceFile),encoding);//���ǵ������ʽ
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	for(i = 0 ; i < word.length ; i++){
                		if(lineTxt.startsWith(word[i])){
                			lineTxt = lineTxt.substring(0,lineTxt.indexOf('=')+1) + String.valueOf(status[i]);
                		}
                	}
                	
                    
                    output.println(lineTxt);
                }
                read.close();
                output.close();
    }else{
        System.out.println("�Ҳ���ָ�����ļ�");
    }
    } catch (Exception e) {
        System.out.println("��ȡ�ļ����ݳ���");
        e.printStackTrace();
    }
		
		sourceFile.delete();
		targetFile.renameTo(new File(recordPath + "\\record.txt"));
    	
    	return set;
    }
}
